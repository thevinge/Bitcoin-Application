package com.jving16.bitcoin;

import java.util.List;

public interface IBitCoin {
    double getBalance();
    String getAddress();
    String sendBitcoins(String address, double amount);
    List<String> unspendTransactions();
    String stopServer();
    List<String> generateBlocks(int amount);
    List<String> help();
}
