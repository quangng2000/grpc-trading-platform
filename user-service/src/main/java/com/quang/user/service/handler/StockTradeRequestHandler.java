package com.quang.user.service.handler;

import com.quang.user.StockTradeResponse;
import com.quang.user.exceptions.InsufficientBalanceException;
import com.quang.user.exceptions.UnknownUserException;
import com.quang.user.repository.PortfolioItemRepository;
import com.quang.user.repository.UserRepository;
import com.quang.user.util.EntityMessageMapper;
import com.quang.common.Ticker;
import com.quang.user.StockTradeRequest;
import com.quang.user.exceptions.InsufficientSharesException;
import com.quang.user.exceptions.UnknownTickerException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StockTradeRequestHandler {

    private final UserRepository userRepository;
    private final PortfolioItemRepository portfolioItemRepository;

    public StockTradeRequestHandler(UserRepository userRepository, PortfolioItemRepository portfolioItemRepository) {
        this.userRepository = userRepository;
        this.portfolioItemRepository = portfolioItemRepository;
    }

    @Transactional
    public StockTradeResponse buyStock(StockTradeRequest request) {
        // validate
        this.validateTicker(request.getTicker());
        var user = this.userRepository.findById(request.getUserId())
                                      .orElseThrow(() -> new UnknownUserException(request.getUserId()));
        var totalPrice = request.getQuantity() * request.getPrice();
        this.validateUserBalance(user.getId(), user.getBalance(), totalPrice);

        // valid request
        user.setBalance(user.getBalance() - totalPrice);
        this.portfolioItemRepository.findByUserIdAndTicker(user.getId(), request.getTicker())
                                    .ifPresentOrElse(
                                            item -> item.setQuantity(item.getQuantity() + request.getQuantity()),
                                            () -> this.portfolioItemRepository.save(EntityMessageMapper.toPortfolioItem(request))
                                    );
        return EntityMessageMapper.toStockTradeResponse(request, user.getBalance());
    }

    @Transactional
    public StockTradeResponse sellStock(StockTradeRequest request) {
        // validate
        this.validateTicker(request.getTicker());
        var user = this.userRepository.findById(request.getUserId())
                                      .orElseThrow(() -> new UnknownUserException(request.getUserId()));
        var portfolioItem = this.portfolioItemRepository.findByUserIdAndTicker(user.getId(), request.getTicker())
                                                        .filter(pi -> pi.getQuantity() >= request.getQuantity())
                                                        .orElseThrow(() -> new InsufficientSharesException(user.getId()));

        // valid request
        var totalPrice = request.getQuantity() * request.getPrice();
        user.setBalance(user.getBalance() + totalPrice);
        portfolioItem.setQuantity(portfolioItem.getQuantity() - request.getQuantity());
        return EntityMessageMapper.toStockTradeResponse(request, user.getBalance());
    }

    private void validateTicker(Ticker ticker) {
        if (Ticker.UNKNOWN.equals(ticker)) {
            throw new UnknownTickerException();
        }
    }

    private void validateUserBalance(Integer userId, Integer userBalance, Integer totalPrice) {
        if (totalPrice > userBalance) {
            throw new InsufficientBalanceException(userId);
        }
    }

}
