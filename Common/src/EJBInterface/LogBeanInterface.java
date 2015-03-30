package EJBInterface;

/**
 * Created by Jaime on 30/03/2015.
 *
 *
 */
public interface LogBeanInterface {
	//Defines Loggable actions
	enum Action{
		LOGIN(1), LOGOUT(2), ADD_ORDER(3), SHIP_ORDER(4);
		private int value;
		private Action(int value) {
			this.value = value;
		}
		public int getValue(){
			return value;
		}
	}

	boolean logAction(Action action, String logString, String logFilePath);
}