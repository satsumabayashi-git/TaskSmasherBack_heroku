package com.example.TaskSmasher.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TaskSmasher.form.LoginForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
	
	private final AuthenticationManager authenticationManager;
//	private final JwtUtil jwtUtil;
	
	@GetMapping
	public String showLogin(@ModelAttribute LoginForm form) {
		return "login";
	}
	
//	@PostMapping
//	@ResponseBody
//    public String login(@RequestParam String usernameInput,
//                        @RequestParam String passwordInput,
//                        HttpServletResponse response) {
//        // 認証処理
//		 try {
////	            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
////	            authenticationManager.authenticate(authToken);
////	            // JWTトークンを発行
////	            String token = jwtUtil.generateToken(username);
////	            // ヘッダーにトークンをセットして返却
////	            response.setHeader("Authorization", "Bearer " + token);
//			 System.out.println("loginSuccess");  
//			 return "loginSuccess";
//	        } catch (AuthenticationException e) {
//	        	 	System.out.println("loginError");
//	            return "loginError";
//	        }
//    }

}
