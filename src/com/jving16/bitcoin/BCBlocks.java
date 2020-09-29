package com.jving16.bitcoin;

import java.util.List;

public class BCBlocks extends BitCoinBase {


    public List<String> generate(int amount){
        System.out.println("Generates Blocks");
        addCommand("bitcoin-cli -regtest getnewaddress");
        List<String> address = execute();

        addCommand("bitcoin-cli -regtest generatetoaddress " + amount + " "+ address.get(0) );
        List<String> result = execute();
        return result;
    }

}
