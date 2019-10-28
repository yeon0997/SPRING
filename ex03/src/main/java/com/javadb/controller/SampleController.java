package com.javadb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadb.domain.SampleVO;
import com.javadb.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}

	/* 객체반환 VO를 먼저 만들어야함 */
	@GetMapping(value = "/getSample", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}

	
	/* 컬렉션 타입의 객체 반환 */
	  
	  @GetMapping(value="/getList") public List<SampleVO> getList(){ return
	  IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, 1 + "First", i +
	  "Last")) .collect(Collectors.toList()); }
	  
	/* 맵: 키와 값을 가지는 하나의 객체로 간주 */
	  @GetMapping(value ="/getMap")
	  public Map<String, SampleVO> getMap() {
		  Map<String, SampleVO> map = new HashMap<>();
		  map.put("FIRST", new SampleVO(111,"그루트", "주니어"));
		  
		  return map;
	  }
	  
	/* 값의 정확성의 여부에 대한 부가 정보를 함께 반환할 때 responseEntity를 사용한다 */
	  @GetMapping(value="/check", params = {"height", "weight"})
	  public ResponseEntity<SampleVO> check(Double height, Double weight) {
		  SampleVO vo = new SampleVO(0, "" + height, ""+weight);
		  
		  ResponseEntity<SampleVO> result = null;
		  if(height < 150) {
			  result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		  } else {
			  result = ResponseEntity.status(HttpStatus.OK).body(vo);
		  }
		  
		  return result;
	  }
	  
	/* pathVariable: URL경로의 일부를 파라미터로 사용할 때 사용하는 애노테이션 */
	  @GetMapping("/product/{cat}/{pid}")
	  public String[] getPath(
	  @PathVariable("cat") String cat,
	  @PathVariable("pid") Integer pid) {
		  return new String[] {"category: " + cat, "productid: " + pid};
	  }
	  
	/* requestbody : 전달된 요청의 내용을 이용해서 해당 파라미터의 타입으로 변환요구 */
	  
	  @PostMapping("/ticket")
	  public Ticket convert(@RequestBody Ticket ticket) {
		  log.info("convert.....ticket" + ticket);
		  
		  return ticket;
	  }
}
