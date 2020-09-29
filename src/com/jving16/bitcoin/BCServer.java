package com.jving16.bitcoin;

import java.util.List;

public class BCServer extends BitCoinBase {

    public String start(){
        addCommand("bitcoind -regtest -daemon -fallbackfee=0.00001");
        List<String> result = execute();
        return result.get(0);
    }

    public String stop(){
        addCommand("bitcoin-cli -regtest stop");
        List<String> result = execute();
        return "Server stopped";
    }
}
