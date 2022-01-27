package edu.web.persistence;

import static edu.web.domain.Board.Entry.*;

import java.util.List;

import edu.web.domain.Board;

// CRUD(Create/Read/Update/Delete)
public interface BoardDao {

	// 전체 검색: select * from boards order by bno desc;
	String SQL_SELECT_ALL = String.format(
			"select * from %s order by %s desc", 
			TABLE_BOARD, COL_BNO);
	/**
	 * DB BOARDS 테이블에서 전체 검색 결과를 리턴하는 메서드.
	 * 
	 * @return Board 객체를 원소로 갖는 ArrayList.
	 */
	List<Board> read();
	
	// 새 글 작성: insert into boards (title, content, userid) values (?, ?, ?);
	String SQL_INSERT_BOARD = String.format(
			"insert into %s (%s,%s, %s, %s) values (bno_seq.nextval, ?, ?, ?)", 
			 TABLE_BOARD,"bno", COL_TITLE, COL_CONTENT, COL_USERID); 
	/**
	 * DB boards 테이블에 새 레코드를 삽입.
	 * 
	 * @param board boards 테이블에 insert할 title, content, userid를 갖고 있는 객체.
	 * @return insert 성공하면 1, 실패하면 0.
	 */
	int create(Board board);
	
	// 글 상세보기: select * from BOARDS where BNO = ?;
	String SQL_SELECT_BY_BNO = String.format(
			"select * from %s where %s = ?", 
			TABLE_BOARD, COL_BNO);
	/**
	 * 글 번호(bno)를 argument로 전달받아서 DB boards 테이블에서 게시글 1개를 검색하고, 
	 * 그 결과를 리턴.
	 * 
	 * @param bno 글 번호(양의 정수). 테이블의 primary key(고유키).
	 * @return 해당 글 번호의 게시글 전체 정보를 가지고 있는 Board 객체.
	 */
	Board read(int bno);
	
	// 글 조회수 업데이트: update BOARDS set VIEW_CNT = VIEW_CNT + 1 where BNO = ?;
	String SQL_UPDATE_VIEW_COUNT = String.format(
			"update %s set %s = %s + 1 where %s = ?", 
			TABLE_BOARD, COL_VIEW_CNT, COL_VIEW_CNT, COL_BNO);
	/**
	 * 글 번호(bno)를 전달받아서 해당 글의 조회수(view_cnt)를 1 증가.
	 * 
	 * @param bno 조회수를 증가시킬 글 번호(primary key).
	 * @return 조회수 증가가 성공하면 1, 실패하면 0.
	 */
	int update(int bno);
	
	// 글 제목, 내용을 update: 
	// update BOARDS set TITLE=?, CONTENT =?, REG_DATE= sysdate where BNO= ?;
	String SQL_UPDATE_TITLE_CONTENT= String.format("update %s set %s =?, %s = ?, %s=sysdate where %s=?",TABLE_BOARD, COL_TITLE, COL_CONTENT, COL_REG_DATE, COL_BNO);
	
	
	/**
	 * 게시글의 제목과 내용을 update
	 * @param board 업데이트 할 글 번호(bno), 제목(title), 내용(content)을 가지고 있는 Board 객체.
	 * @return 성공 1 실패 0
	 */
	int update(Board board);
}
