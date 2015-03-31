package EJBInterface;

import javax.ejb.Remote;
import java.io.IOException;

/**
 * Created by Jaime on 30/03/2015.
 *
 *
 */
@Remote
public interface LogEJBInterface {
	void addLog(String log, int type) throws IOException;
}