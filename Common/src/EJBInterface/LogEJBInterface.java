package EJBInterface;

import javax.ejb.Remote;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Jaime on 30/03/2015.
 *
 *
 */
@Remote
public interface LogEJBInterface {
	FileWriter CreateWriter(String path)throws IOException;
	void addLog(String log, int type);
}