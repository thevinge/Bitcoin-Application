package com.jving16.bitcoin;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public abstract class BitCoinBase {


    private StringBuilder sb;

    public BitCoinBase() {
        sb = new StringBuilder();
    }

    protected void addCommand(String Command){
        sb.append(Command);
    }

    protected List<String> execute(){

        Runtime rt = Runtime.getRuntime();
        try {
            Process process = rt.exec(sb.toString());
            process.waitFor();
            List<String> result = getResults(process);
            sb = new StringBuilder();
            return result;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }

    private ArrayList<String> getResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        ArrayList<String> list = new ArrayList<>();
        String line = "";
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        return list;
    }


}
