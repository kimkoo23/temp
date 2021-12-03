package nam.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import nam.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
	private static String namespace = "nam.board.mappers.board";

	// 11 26 미니게시판 게시물 등록
	@Override
	public void mWrite(BoardVO vo) throws Exception {
		sql.insert(namespace + ".mWrite", vo);
	}

	// 11 26 미니게시판 게시물 목록
	@Override
	public List<BoardVO> mList(BoardVO vo) throws Exception {
		return sql.selectList(namespace + ".mList", vo);

	}

	// 11 26 미니게시판 게시물 수정
	@Override
	public void mModify(BoardVO vo) throws Exception {
		sql.update(namespace + ".mModify", vo);
	}

	// 11 26 미니게시판 게시물 삭제
	@Override
	public void mDelete(int seqno) throws Exception {
		sql.delete(namespace + ".mDelete", seqno);
	}

	// 11 26 미니게시판 게시물 목록보기
	public BoardVO mView(int seqno) throws Exception {

		return sql.selectOne(namespace + ".mView", seqno);
	}

}
