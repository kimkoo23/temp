package nam.board.dao;

import java.util.List;

import nam.board.domain.BoardVO;

public interface BoardDAO {

	// 11 26 미니게시판 게시물 등록
	public void mWrite(BoardVO vo) throws Exception;

	// 11 26 미니게시판 게시물 목록
	public List<BoardVO> mList(BoardVO vo) throws Exception;

	// 11 26 미니게시판 게시물 수정
	public void mModify(BoardVO vo) throws Exception;

	// 11 26 미니게시판 게시물 삭제
	public void mDelete(int seqno) throws Exception;

	// 11 26 미니게시판 게시물 목록보기
	public BoardVO mView(int seqno) throws Exception;

}
