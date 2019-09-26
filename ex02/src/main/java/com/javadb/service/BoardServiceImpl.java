package com.javadb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javadb.domain.BoardVO;
import com.javadb.domain.Criteria;
import com.javadb.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j	
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ =@Autowired)
	private BoardMapper mapper;			// mapper 객체를 생성해 BoardMapper의 기능들을 사용
	
	@Override
	public void register(BoardVO board) {

		log.info("register.............." + board);
		
		mapper.insertSelectKey(board);
	}
	
	/*
	 * @Override public List<BoardVO> getList() {
	 * 
	 * log.info("getList...............");
	 * 
	 * return mapper.getList(); }
	 */
	
	@Override
	public List<BoardVO> getList(Criteria cri){
		log.info("get List with criteria : " + cri);
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public BoardVO get(Long bno) {
		
		log.info("get............." + bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify............." + board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		
		log.info("remove............." + bno);
		
		return mapper.delete(bno) == 1;
	}


	//spring 4.3 이상에서 자동 처리

}
