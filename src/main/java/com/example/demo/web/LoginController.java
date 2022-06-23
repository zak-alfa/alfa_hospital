package com.example.demo.web;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@RolesAllowed("USER")
	   @RequestMapping("/medecin/*")
	   public String getUser()
	   {
	      return "Welcome User";
	   }

	   @RolesAllowed({"USER","ADMIN"})
	   @RequestMapping("/admin")
	   public String getAdmin()
	   {
	      return "Welcome Admin";
	   }

}
