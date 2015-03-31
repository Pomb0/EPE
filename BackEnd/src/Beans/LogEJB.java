package Beans;

import EJBInterface.LogEJBInterface;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class LogEJB implements LogEJBInterface{

    @Override
    public void addLog(String log, int type) throws IOException {

    }
}
