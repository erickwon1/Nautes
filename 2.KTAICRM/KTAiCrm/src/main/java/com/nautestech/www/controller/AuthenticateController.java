package com.nautestech.www.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.nautestech.www.model.Member;
import com.nautestech.www.repository.MemberRepository;


import com.nautestech.www.dto.ResultDto;

import com.nautestech.www.config.CustomPasswordEncoder;
@RestController
@RequestMapping
public class AuthenticateController {


	@Autowired
	private MemberRepository memberRepository;
	private CustomPasswordEncoder customPasswordEncoder ;

    @PostMapping("/authenticate/pw_reset")
    public ResultDto pw_reset(@RequestParam String username,
    		@RequestParam String currentPassword,
    		@RequestParam String newPassword) {
    	System.err.println(username);
    	ResultDto result = new ResultDto();
    	customPasswordEncoder = new CustomPasswordEncoder();
    	Optional<Member> memberOptional = memberRepository.findByUsername(username);

		if (memberOptional.isPresent()) {
			if (customPasswordEncoder.matches(currentPassword, memberOptional.get().getPassword())) {
				Member member = memberOptional.get();
				member.updatePassword(customPasswordEncoder.encode(newPassword));
				memberRepository.save(member);
				result.setResult(true);
			}

			else {

				result.setResult(false);
				result.setFailMsg("현재 비밀번호가 틀립니다.");
			}
		} else {

			result.setResult(false);
			result.setFailMsg("사용자가 없습니다.");
		}
    	
        return result;
    }
}
