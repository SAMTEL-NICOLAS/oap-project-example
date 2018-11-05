package co.com.samtel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.samtel.service.BussinesService;

@Controller
@RestController
@RequestMapping("/v.1/aspect")
public class AspectController {
	
	@Autowired
	BussinesService bussinesService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<String> getBussines(){
		return new ResponseEntity<>(bussinesService.getSaludo("Nicolas") , HttpStatus.OK);
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ResponseEntity<String> getTest(){
		return new ResponseEntity<>(bussinesService.testExecution("Nicolas") , HttpStatus.OK);
	}
	
}
