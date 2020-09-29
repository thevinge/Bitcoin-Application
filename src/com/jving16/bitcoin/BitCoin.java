package com.jving16.bitcoin;

import java.util.ArrayList;
import java.util.List;

public class BitCoin implements IBitCoin {

    private final BCWallet wallet = new BCWallet();
    private final BCServer server = new BCServer();
    private final BCBlocks blocks = new BCBlocks();

    public BitCoin() {
        server.start();
        blocks.generate(101);
    }

    @Override
    public double getBalance() {
        return wallet.getBalance();
    }

    @Override
    public String getAddress() {
        return wallet.newAddress();
    }

    @Override
    public String sendBitcoins(String address, double amount) { return wallet.sendTransaction(address, amount); }

    @Override
    public List<String> unspendTransactions() {
        return wallet.unspendTransactions(false);
    }

    @Override
    public String stopServer() {
        return server.stop();
    }

    @Override
    public List<String> generateBlocks(int amount) {
        return blocks.generate(amount);
    }

    @Override
    public List<String> help() {
        List<String> list = new ArrayList<>();
        list.add("Balance = get the current balance of the wallet");
        list.add("newaddress = Get a new address");
        list.add("Send = Send bitcoins");
        list.add("Generateblock x = generate x amount of blocks");
        list.add("unspend  = List the unspend transactions");
        list.add("Exit = Stop the bitcoin application");
        return list;
    }
}
