package Servlet.Notifications;

/**
 * Created by Jaime on 31/03/2015.
 *
 *
 */
public enum NotificationType{
	ERROR(1), INFO(2);
	private int value;
	private NotificationType(int value) {
		this.value = value;
	}
	public int getValue(){
		return value;
	}
}