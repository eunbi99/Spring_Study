package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.common.JDBCUtil;

//DAO(Data Access Object)

@Repository
public class BoardDAOMybatis  {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("====> JDBC �� insertBoard() 기능처리");
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	
	
		public void updateBoard(BoardVO vo) {
			System.out.println("====> JDBC �� updateBoard() ��� ó��");
			mybatis.update("BoardDAO.updateBoard",vo);
		}
		
		
				public void deleteBoard(BoardVO vo) {
					System.out.println("====> JDBC �� deleteBoard() ��� ó��");
					mybatis.delete("BoardDAO.deleteBoard",vo);
				}
				
				
				public BoardVO getBoard(BoardVO vo) {
					System.out.println("====> JDBC �� getBoard() ��� ó��");
					return (BoardVO) mybatis.selectOne("BoardDAO.getBoard",vo);
				}
				
				
				public List<BoardVO> getBoardList(BoardVO vo) {
					System.out.println("====> JDBC �� getBoardList() ��� ó��");
					return mybatis.selectList("BoardDAO.getBoardList",vo);
				}
	
}
