package Beans;

import EJBInterface.LogEJBInterface;

import javax.ejb.Stateless;
import java.io.*;

@Stateless
public class LogEJB implements LogEJBInterface{

    private final String orderFilePath = "order.txt";
    private final String logFilePath = "Logins.txt";
    private final String shippingFilePath = "shipping.txt";

    private static FileWriter writerOrder;
    private static FileWriter writerLog;
    private static FileWriter writerShipping;

    public LogEJB(){
        this.writerOrder = CreateWriter(orderFilePath);
        this.writerLog = CreateWriter(logFilePath);
        this.writerShipping = CreateWriter(shippingFilePath);

    }

    public FileWriter CreateWriter(String path) {
        try{
            File file = new File(path);

            if(!file.exists()) { file.createNewFile(); }
            return new FileWriter(file);
        }catch (Exception e){
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public void addLog(String log, int type) throws IOException {
        switch (type){
            case(0):
                this.writerLog.append(log + "\n");
                break;
            case(1):
                this.writerLog.append(log + "\n");
                break;
            case(2):
                this.writerShipping.append(log + "\n");
                break;
            default:
                break;
        }

    }
}
