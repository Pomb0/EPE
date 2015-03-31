package Servlet.Notifications;

import java.io.Serializable;

/**
 * Created by Jaime on 31/03/2015.
 */



public class NotificationItem implements Serializable {
	private NotificationType type;
	private String notification;

	public NotificationItem(NotificationType type, String notification) {
		this.type = type;
		this.notification = notification;
	}

	public NotificationType getType() {
		return type;
	}

	public String getNotification() {
		return notification;
	}

	public NotificationItem setType(final NotificationType type) {
		this.type = type;
		return this;
	}

	public NotificationItem setNotification(final String notification) {
		this.notification = notification;
		return this;
	}


}