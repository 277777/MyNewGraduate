package com.Graduate.Po;

import java.sql.Timestamp;

public class Multiple {

    private int friendid;
    private int userid;
    private int user_friend_id;
    private int status;
	private int msgid;
	private String msgtext;
	private Timestamp msgtime;
	private String username;
	private String userpwd;
	private String userimg;
	public Multiple(int friendid, int userid, int user_friend_id, int status, int msgid, String msgtext,
			Timestamp msgtime, String username, String userpwd, String userimg) {
		super();
		this.friendid = friendid;
		this.userid = userid;
		this.user_friend_id = user_friend_id;
		this.status = status;
		this.msgid = msgid;
		this.msgtext = msgtext;
		this.msgtime = msgtime;
		this.username = username;
		this.userpwd = userpwd;
		this.userimg = userimg;
	}
	public Multiple() {
		super();
	}
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUser_friend_id() {
		return user_friend_id;
	}
	public void setUser_friend_id(int user_friend_id) {
		this.user_friend_id = user_friend_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public String getMsgtext() {
		return msgtext;
	}
	public void setMsgtext(String msgtext) {
		this.msgtext = msgtext;
	}
	public Timestamp getMsgtime() {
		return msgtime;
	}
	public void setMsgtime(Timestamp msgtime) {
		this.msgtime = msgtime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUserimg() {
		return userimg;
	}
	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}
	
	
}
