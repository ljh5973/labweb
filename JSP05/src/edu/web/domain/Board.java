package edu.web.domain;

import java.util.Date;

// MVC 아키텍쳐에서 Model(Domain)에 해당하는 클래스(데이터 클래스) -> DB 테이블 관련
// VO(Value Object), DTO(Data Transfer Object)
public class Board {
	public static abstract class Entry{
		// DB  테이블 이름, 컬럼 이름들을 상수로 정의
		// abstract(추상) 클래스로 선언한 이유는 생성자를 호출할 수 없도록 하기 위해서(객체를 생성하지 못하도록)
		public static final String TABLE_BOARD= "BOARDS";	// 테이블 이름
		public static final String COL_BNO= "BNO"; // 글 번호(primary key, sequence 이용)
		public static final String COL_TITLE= "TITLE";	//글 제목
		public static final String CONTENT="CONTENT"; // 글 내용
		public static final String COL_USERID= "USERID"; // 글 작성자 아이디 (foreign key)
		public static final String COL_REGDATE = "REG_DATE"; // 글 최종 작성/수정 시간;
		public static final String COL_VIEW_CNT ="VIEW_CNT"; // 조회수
		public static final String COL_REPLY_CNT="REPLY_CNT"; // 댓글 개수
		public static final String COL_ATTACH= "ATTACHMENT"; // 첨부된 파일이 저장된 위치(폴더)
		
	}
	
	// 멤버 변수, 필드 프로퍼티
	
	private int bno;
	private String title;
	private String content;
	private String userId;
	private Date regDate;
	private int viewCnt;
	private int replyCnt;
	private String attachment;

	
	public Board() {
		// TODO Auto-generated constructor stub
	}


	public Board(int bno, String title, String content, String userId, Date regDate, int viewCnt, int replyCnt,
			String attachment) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
		this.replyCnt = replyCnt;
		this.attachment = attachment;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getViewCnt() {
		return viewCnt;
	}


	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}


	public int getReplyCnt() {
		return replyCnt;
	}


	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}


	public String getAttachment() {
		return attachment;
	}


	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
	
}
