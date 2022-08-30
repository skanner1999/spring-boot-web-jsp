package com.mkyong;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.models.Signup;
import com.mkyong.repository.CustomerRepo;

@Controller
public class WelcomeController {

	@Autowired
	private CustomerRepo customers;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		//model.put("message", this.message);
		return "index";
	}

	@GetMapping("/signup")
	public ModelAndView getSignup() {
		ModelAndView getSignupPage = new ModelAndView("signup");
		getSignupPage.addObject("PageTitle", "Signup");
		return getSignupPage;
	}

	@PostMapping("/signup")
	public ModelAndView register(@Valid @ModelAttribute("signup") Signup signup,
								BindingResult result,
								@RequestParam("phone_number") String phone_number,
								@RequestParam("first_name")String first_name,
								@RequestParam("last_name")String last_name,
								@RequestParam("password")String password) {
		ModelAndView SignupPage = new ModelAndView("signup");
		String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());
		customers.signUp(phone_number, first_name, last_name, hashed_password);
		return SignupPage;						
	}

	@GetMapping("/login")
	public ModelAndView getLogin() {
		ModelAndView getLoginPage = new ModelAndView("login");
		getLoginPage.addObject("PageTitle", "Login");
		return getLoginPage;
	}

	@PostMapping("/login")
	public String Login(@RequestParam("phone_number") String phone_number,
						@RequestParam("password")String password,
						Model model, HttpSession session) {
		String getPhoneInDb = customers.getPhone(phone_number);
		String getPasswordInDB = customers.getPassword(getPhoneInDb);
		if (!BCrypt.checkpw(password, getPasswordInDB)) {
			return "login";
		} 
		String getAll = customers.getUser(phone_number);
			session.setAttribute("user", getAll);
			return "index";
	}
}