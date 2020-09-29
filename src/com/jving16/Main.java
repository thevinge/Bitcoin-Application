package com.jving16;

import com.jving16.bitcoin.BitCoin;
import com.jving16.bitcoin.IBitCoin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IBitCoin bitCoin = new BitCoin();
	    Scanner sc = new Scanner(System.in);
	    String input;
        System.out.println("Welcome to the best Bitcoin Application");
	    Boolean stop = false;
	    while (!stop){
            input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")){
                stop = true;
                System.out.println(bitCoin.stopServer());
            } else if (input.equalsIgnoreCase("balance")){
                System.out.println("Current Balance:");
                System.out.println(bitCoin.getBalance());

            } else if (input.equalsIgnoreCase("help")){
                System.out.println("Commands:");
                System.out.println(bitCoin.help());
            } else if (input.equalsIgnoreCase("newaddress")){
                System.out.println(bitCoin.getAddress());
            } else if (input.equalsIgnoreCase("unspend")){
                System.out.println(bitCoin.unspendTransactions());
            } else if (input.equalsIgnoreCase("generateblock")){
                System.out.println("How many?");
                int amount = sc.nextInt();
                System.out.println(bitCoin.generateBlocks(amount));
            } else if (input.equalsIgnoreCase("send")){
                System.out.println("To who:");
                String who = sc.nextLine();
                System.out.println("Amount:");
                double amount = sc.nextDouble();
                System.out.println(bitCoin.sendBitcoins(who, amount));
            }
        }
    }
}
