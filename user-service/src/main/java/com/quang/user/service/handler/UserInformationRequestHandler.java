package com.quang.user.service.handler;

import com.quang.user.UserInformationRequest;
import com.quang.user.exceptions.UnknownUserException;
import com.quang.user.repository.PortfolioItemRepository;
import com.quang.user.repository.UserRepository;
import com.quang.user.util.EntityMessageMapper;
import com.quang.user.UserInformation;
import org.springframework.stereotype.Service;

@Service
public class UserInformationRequestHandler {

    private final UserRepository userRepository;
    private final PortfolioItemRepository portfolioItemRepository;

    public UserInformationRequestHandler(UserRepository userRepository, PortfolioItemRepository portfolioItemRepository) {
        this.userRepository = userRepository;
        this.portfolioItemRepository = portfolioItemRepository;
    }

    public UserInformation getUserInformation(UserInformationRequest request) {
        var user = this.userRepository.findById(request.getUserId())
                                      .orElseThrow(() -> new UnknownUserException(request.getUserId()));
        var portfolioItems = this.portfolioItemRepository.findAllByUserId(request.getUserId());
        return EntityMessageMapper.toUserInformation(user, portfolioItems);
    }


}
