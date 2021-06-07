package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {

	@RequestMapping(value="/insertBoard.do")
	public void insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
//		return "getBoardList.do";
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
	}
	

}
