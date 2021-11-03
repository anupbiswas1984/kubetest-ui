package com.kubetestui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kubetestui.services.KubeTestService;

@Controller
public class KubeTestController {
	
	@Autowired
	private KubeTestService kubeTestService;

	@RequestMapping(path = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView showHomePage() {
		
		String data1 = kubeTestService.populateHostData1();
		String data2 = kubeTestService.populateHostData2();
		ModelAndView mv = new ModelAndView();
		mv.addObject("data1", data1);
		mv.addObject("data2", data2);
		mv.setViewName("homepage");
		return mv;
	}
}
