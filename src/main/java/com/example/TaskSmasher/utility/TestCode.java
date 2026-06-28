package com.example.TaskSmasher.utility;

import java.util.Map;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

//@RequiredArgsConstructor
public class TestCode {
//	private  final  LoginUserDetailsServiceImpl loginUserDetailsServiceImpl;
	
	public static void main(String[] args) throws UsernameNotFoundException, JsonProcessingException{
		
//		List<GrantedAuthority> authorities= new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority("USER"));
//		authorities.add(new SimpleGrantedAuthority("ADMIN"));
//		authorities.add(new SimpleGrantedAuthority("ADMIN"));
//		System.out.println(authorities);
		
//		AuthenticationMapper mapper = new AuthenticationMapper();
//		ToDoMapper to = new ToDoMapper();
//		Authentication authentication = authenticationMapper.selectByUsername("admin");
//		LoginUserDetailsServiceImpl luds = new LoginUserDetailsServiceImpl(mapper);
//		System.out.println(luds. loadUserByUsername("admin"));
//		System.out.println(authentication);
		ObjectMapper objectMapper = new ObjectMapper();
		
		String json = objectMapper.writeValueAsString(Map.of("error", "メールアドレスまたはパスワードが正しくありません。","Result", "error"));
//		String jsonSaveError = objectMapper.writeValueAsString(Map.of("Result", "error"));
		JsonNode root = objectMapper.readTree(json);
        // ageを更新
//        ((ObjectNode) root).put("age", 30);
        // 新しいフィールド追加
        ((ObjectNode) root).put("city", "Tokyo");
        String jsonnew = objectMapper.writeValueAsString(root);
        
		System.out.println(jsonnew);
//		response.setContentType("application/json");
//        response.getWriter().write(json);
		
	}

}
