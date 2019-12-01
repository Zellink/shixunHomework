package Chat;

public class ChatRoom {

	private String createrId;
	private String name;
	private String introduce;
	
	ChatRoom(String createrId, String name, String introduce){
		this.createrId = createrId;
		this.name = name;
		this.introduce = introduce;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
}
