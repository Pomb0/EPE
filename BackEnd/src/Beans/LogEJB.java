package Beans;

import java.io.*;

public class LogEJB {

    private final String orderFilePath = "order.txt";
    private final String logFilePath = "Logins.txt";
    private final String shippingFilePath = "shipping.txt";

    private int type;
    private static FileWriter writer;

    private LogEJB(int type){
        this.type = type;
        switch (type){
            case(0): CreateWriter(orderFilePath);

            case(1): CreateWriter(logFilePath);

            case(2): CreateWriter(shippingFilePath);

            default:
        }

    }

    private void CreateWriter(String path) {
        try{
            File file = new File(path);

            if(!file.exists()) { file.createNewFile(); }
            this.writer = new FileWriter(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean writeMessage(String message) {
        try {
            this.writer.append(message + "\n");
            this.writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
}
