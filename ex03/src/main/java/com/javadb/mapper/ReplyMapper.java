package com.javadb.mapper;

import com.javadb.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long bno);
	
	public int delete(Long targetRno);
	
	public int update(ReplyVO reply);


}
