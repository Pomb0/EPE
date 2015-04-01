package Beans;

import EJBInterface.LogEJBInterface;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class LogEJB implements LogEJBInterface{
    Logger logger;

    @Override
    public void addLog(LogType type, String log) throws IOException {
        System.out.println("[LOG]" + type + ": " + log);

        switch (type){
            case SESSION:
                logger = Logger.getLogger("session");
                break;
            case SHIPPING:
                logger = Logger.getLogger("shipping");
                break;
            case ORDER:
                logger = Logger.getLogger("orders");
                break;
        }
        logger.info(log);
    }
}
