package com.javadb.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javadb.controller.SampleController;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data

public class SampleDTOList {
	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list = new ArrayList<>();
	}
	
	
}
