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
	enum LogType{
		SHIPPING(1), SESSION(2), ORDER(3);
		private int value;
		LogType(int value) {
			this.value = value;
		}
		public int getValue(){
			return value;
		}
	}
	void addLog(LogType type, String log) throws IOException;
}