package com.javadb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javadb.domain.BoardVO;
import com.javadb.mapper.BoardMapper;

import lombok.AllArgsConstructor;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}


}
