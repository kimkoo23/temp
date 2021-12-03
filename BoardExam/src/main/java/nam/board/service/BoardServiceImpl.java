package nam.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import nam.board.domain.BoardVO;
import nam.board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO dao;

	// 11 26 미니게시판 게시물 등록
	@Override
	public void mWrite(BoardVO vo) throws Exception {
		dao.mWrite(vo);
	}

	// 11 26 미니게시판 게시물 목록
	@Override
	public List<BoardVO> mList(BoardVO vo) throws Exception {
		return dao.mList(vo);

	}

	// 11 26 미니게시판 게시물 수정
	@Override
	public void mModify(BoardVO vo) throws Exception {
		dao.mModify(vo);
	}

	// 11 26 미니게시판 게시물 삭제
	@Override
	public void mDelete(int seqno) throws Exception {
		dao.mDelete(seqno);
	}

	// 11 26 미니게시판 게시물 목록보기
	@Override
	public BoardVO mView(int seqno) throws Exception {
		return dao.mView(seqno);
	}

}
