package test.mysql;

public class DeptVo {
	private long no;
	private String name;
	
	@Override
	public String toString() {
		return "DeptVo [no=" + no + ", name=" + name + "]";
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
