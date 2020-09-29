package com.jving16.bitcoin;

import java.util.List;

public class BCWallet extends BitCoinBase {

    public double getBalance(){
        addCommand("bitcoin-cli -regtest getbalance");
        List<String> balance = execute();
        return Double.parseDouble(balance.get(0));
    }


    public String sendTransaction(String address, double amount){
        addCommand("bitcoin-cli -regtest sendtoaddress " + address  + " " + amount);
        List<String> result = execute();
        return result.get(0);
    }

    public String newAddress(){
        addCommand("bitcoin-cli -regtest getnewaddress");
        List<String> result = execute();
        return result.get(0);
    }

    public List<String> unspendTransactions(boolean confirmed){
        if (confirmed){
            addCommand("bitcoin-cli -regtest listunspent");
        } else {
            addCommand("bitcoin-cli -regtest listunspent 0");
        }
        return execute();
    }
}
