package com.myblog.entity.rote;

public class ReadRote extends BasicRote {

	private Integer read_id;
	private String read_ip;
	private String read_time;
	private String read_dervice;
	private String read_brow;

	public Integer getRead_id() {
		return read_id;
	}

	public void setRead_id(Integer read_id) {
		this.read_id = read_id;
	}

	public String getRead_ip() {
		return read_ip;
	}

	public void setRead_ip(String read_ip) {
		this.read_ip = read_ip;
	}

	public String getRead_time() {
		return read_time;
	}

	public void setRead_time(String read_time) {
		this.read_time = read_time;
	}

	public ReadRote() {
		super();
	}

	public ReadRote(Integer read_id, Integer user_id, String read_ip, String read_time, Integer article_id, String read_brow, String read_system) {
		super();
		this.read_id = read_id;
		super.setUser_id(user_id);
		this.read_ip = read_ip;
		this.read_time = read_time;
		this.read_brow = read_brow;
		this.read_dervice = read_system;
		this.setArticle_id(article_id);
	}

	@Override
	public String toString() {
		return "ReadRote [read_id=" + read_id + ", user_id=" + getUser_id() + ", read_ip=" + read_ip + ", read_time="
				+ read_time + ", article_id=" + getArticle_id() +"read_dervice=" + read_dervice +"read_brow=" + read_brow +"]";
	}

	/**
	 * @return the read_system
	 */
	public String getRead_system() {
		return read_dervice;
	}

	/**
	 * @param read_system the read_system to set
	 */
	public void setRead_system(String read_system) {
		this.read_dervice = read_system;
	}

	/**
	 * @return the read_brow
	 */
	public String getRead_brow() {
		return read_brow;
	}

	/**
	 * @param read_brow the read_brow to set
	 */
	public void setRead_brow(String read_brow) {
		this.read_brow = read_brow;
	}

	/*public static void main(String[] args) {
		System.err.println(new ReadRote(1, 1, "1", "2", 1));
	}*/

}
