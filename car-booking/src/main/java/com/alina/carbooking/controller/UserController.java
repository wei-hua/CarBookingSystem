package com.alina.carbooking.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alina.carbooking.entity.Car;
import com.alina.carbooking.entity.User;
import com.alina.carbooking.service.CarService;
import com.alina.carbooking.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制器.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2017年2月26日
 */
@Controller
public class UserController {
	@Resource
	private UserService userService;

	@Resource
	private CarService carService;

	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/gologin")
	public String gologin(){
		return "login";
	}

	@RequestMapping("/goregister")
	public String goregister(){
		return  "register";
	}
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(User user){
		int i = userService.adduser(user);
		if (i>0){
			return true;
		}else {
			return false;
		}
	}

	@RequestMapping("/login")
	public String  login(User user,HttpServletRequest request,Model model){
		User existUser = userService.queryUserByName(user.getName());
		if (existUser==null || !user.getPassword().equals(existUser.getPassword())){
			return  "public/false";
		}
		//HttpSession session =  request.getSession();
		//session.setAttribute("name",user.getName());
		//session.setAttribute("password",user.getPassword());
		List<Car> carList = carService.queryAllCars();
		model.addAttribute("user",existUser);
		model.addAttribute("cars", carList);
		return "homepage";
	}

	@RequestMapping("/test")
    @ResponseBody
	public boolean  test(HttpServletRequest request,Model model){
		return true;
	}

}