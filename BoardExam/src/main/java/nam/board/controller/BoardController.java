package nam.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nam.board.domain.BoardVO;
import nam.board.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	@Inject
	private BoardService service; // 의존성 주입으로 객체 생성
	
		//11/26 추가 미니 게시판 등록 (GET)
		@RequestMapping(value = "/mWrite", method = RequestMethod.GET)
		public void getMWrite(BoardVO vo) throws Exception {
			
			
		}
		//11/26 추가 미니 게시판 등록 (POST)
		@RequestMapping(value = "/mWrite", method = RequestMethod.POST)
		public String postMWrite(BoardVO vo) throws Exception {
			service.mWrite(vo);
			return "redirect:/board/mList";
		}

		
		//11/26 추가 미니 게시판 보기
		@RequestMapping(value = "/mList", method = RequestMethod.GET)
		public void postMList(BoardVO vo, Model model) throws Exception {
			
			List<BoardVO> list=null;
			list = service.mList(vo);
			model.addAttribute("list", list );
			
		}
		//11/26 추가 미니 게시판 내용 보기
		@RequestMapping(value = "/mView", method = RequestMethod.GET)
		public void getMView(Model model, @RequestParam(name="seqno", required=false) int seqno) throws Exception {
			
			BoardVO list = service.mView(seqno);
			
			model.addAttribute("list", list );
			
		}
		//11/26 추가 미니 게시판 수정
		@RequestMapping(value = "/mModify", method = RequestMethod.GET)
		public void getModify(Model model, @RequestParam(name="seqno", required=false) int seqno) throws Exception {
			
			BoardVO list = service.mView(seqno);
			
			model.addAttribute("list", list );
			
		}
		//11/26 추가 미니 게시판 수정
			@RequestMapping(value = "/mModify", method = RequestMethod.POST)
			public String postModify(Model model, BoardVO vo) throws Exception {
				
				System.out.println("seqno =" + vo.getSeqno());
				
				service.mModify(vo);
				return "redirect:/board/mView?seqno="+ vo.getSeqno();
				
				
			}
		
		//11/26 추가 미니 게시판 삭제
		@RequestMapping(value = "/mDelete", method = RequestMethod.GET)
		public String postDelete(Model model, BoardVO vo, @RequestParam(name="seqno", required=false) int seqno) throws Exception {
			
			service.mDelete(seqno);
			return "redirect:/board/mList";
			
			

			
		}

}
