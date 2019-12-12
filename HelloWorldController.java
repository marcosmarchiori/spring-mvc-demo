package springdemo.mvc;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	
	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
	
	// new controller method to read form data
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShout(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create message
		String result = "Hi DUDE!" + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloWorld";
		
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {
		
		
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create message
		String result = "Hi " + theName + " from v3!";
		
		
		// add message to the model
		model.addAttribute("message", result);
		
		
		return "helloWorld";
		
	}
	
}
