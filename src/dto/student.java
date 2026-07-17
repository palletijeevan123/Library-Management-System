package dto;

public class student {
	private int student_id;
	private String name;
	private String phone;
	public student(int student_id, String name, String phone) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.phone = phone;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "student [student_id=" + student_id + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
