// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stock-service.proto

// Protobuf Java Version: 3.25.1
package com.quang.stock;

public final class StockServiceOuterClass {
  private StockServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stock_PriceUpdate_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stock_PriceUpdate_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stock_StockPriceRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stock_StockPriceRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stock_StockPriceResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stock_StockPriceResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023stock-service.proto\022\005stock\032\033google/pro" +
      "tobuf/empty.proto\032\023common/common.proto\"<" +
      "\n\013PriceUpdate\022\036\n\006ticker\030\001 \001(\0162\016.common.T" +
      "icker\022\r\n\005price\030\002 \001(\005\"3\n\021StockPriceReques" +
      "t\022\036\n\006ticker\030\001 \001(\0162\016.common.Ticker\"C\n\022Sto" +
      "ckPriceResponse\022\036\n\006ticker\030\001 \001(\0162\016.common" +
      ".Ticker\022\r\n\005price\030\002 \001(\0052\225\001\n\014StockService\022" +
      "D\n\rGetStockPrice\022\030.stock.StockPriceReque" +
      "st\032\031.stock.StockPriceResponse\022?\n\017GetPric" +
      "eUpdates\022\026.google.protobuf.Empty\032\022.stock" +
      ".PriceUpdate0\001B\023\n\017com.quang.stockP\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
          com.quang.common.Common.getDescriptor(),
        });
    internal_static_stock_PriceUpdate_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_stock_PriceUpdate_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stock_PriceUpdate_descriptor,
        new java.lang.String[] { "Ticker", "Price", });
    internal_static_stock_StockPriceRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_stock_StockPriceRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stock_StockPriceRequest_descriptor,
        new java.lang.String[] { "Ticker", });
    internal_static_stock_StockPriceResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_stock_StockPriceResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stock_StockPriceResponse_descriptor,
        new java.lang.String[] { "Ticker", "Price", });
    com.google.protobuf.EmptyProto.getDescriptor();
    com.quang.common.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
