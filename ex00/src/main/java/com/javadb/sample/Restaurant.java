package com.javadb.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	 //의존성 주입(lombok) 테스트
	@Setter(onMethod_ = @Autowired) //-jdk8버전
	//@Setter(onMethod = @__({@Autowired}))-jdk7버전
	
	private Chef chef;
	//lombok으로 인해 getter, setter, toString, 생성자가 자동으로 생성됨

}
