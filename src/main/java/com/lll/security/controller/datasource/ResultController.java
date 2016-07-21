package com.lll.security.controller.datasource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/result")
public class ResultController {
	
	
	/** 
	 * @description  需要跳转页面的方法
	 * @date 2013-5-11 
	 * @param content
	 * @return
	 */
	@RequestMapping(value="/showMessage")
	public String index(@RequestParam(value="content") String content,Model model) {
		model.addAttribute("content", content);
		return "util/resultMessage";
	}
	

}
