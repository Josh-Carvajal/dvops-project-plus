
public class Reminder {
	public Reminder(String name, String reminder, String status, String importance, String date) {
		super();
		this.name = name;
		this.reminder = reminder;
		this.status = status;
		this.importance = importance;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReminder() {
		return reminder;
	}
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	protected String name;
	protected String reminder;
	protected String status;
	protected String importance;
	protected String date;
}
