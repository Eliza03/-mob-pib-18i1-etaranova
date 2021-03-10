package com.company;

import
        java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BuhBalance buhBalance = null;
        if(new File("Accounts.txt").exists()){
            System.out.println("File is exists");
            //чтение из файла
            Reader readerAccounts = new FileReader("Accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(readerAccounts);
            List<Account> accounts = new ArrayList<>();
            while(true){
                String line = bufferedReader.readLine();
                if(line == null)
                    break;
                String[] splitedLine = line.split(";");
                Account account = new Account(splitedLine[0], splitedLine[1], Double.parseDouble(splitedLine[2]), Double.parseDouble(splitedLine[3]));
                accounts.add(account);
            }
            buhBalance = new BuhBalance(accounts);
        }
        else {
            buhBalance = new BuhBalance();
        }

        buhBalance.createOperation(buhBalance.getAccounts().get(2), buhBalance.getAccounts().get(1), 1000);
        buhBalance.createOperation(buhBalance.getAccounts().get(0), buhBalance.getAccounts().get(2), 1000);
        buhBalance.createOperation(buhBalance.getAccounts().get(0), buhBalance.getAccounts().get(2), 500);
        //buhBalance.createOperation(buhBalance.getAccounts().get(2), buhBalance.getAccounts().get(1), 500);
        //buhBalance.createOperation(buhBalance.getAccounts().get(4), buhBalance.getAccounts().get(1), 500);

        watchOperations(buhBalance);
        for (Account account : buhBalance.getAccounts()) {
            System.out.println(account);
        }
        //buhBalance.writeInTxtAccounts();
    }

    public static void watchOperations(BuhBalance buhBalance) {
        System.out.println("\nOperations:");
        for (Operation operation : buhBalance.getOperations()) {
            System.out.println(operation);
        }
        System.out.println("\n");
    }
}
