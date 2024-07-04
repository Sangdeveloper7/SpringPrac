package com.thc.realspr.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;

import java.io.IOException;

public class LoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	public LoginAuthenticationFilter(final String defaultFilterProcessesUrl,
                                     final AuthenticationManager authenticationManager) {
		super(defaultFilterProcessesUrl, authenticationManager);
		// 로그인 이후 Context 생성 전략 설정
		setSecurityContextRepository(
				new DelegatingSecurityContextRepository(
						new HttpSessionSecurityContextRepository(),
						new RequestAttributeSecurityContextRepository()
				)
		);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
												HttpServletResponse response)
			throws AuthenticationException, IOException {

		String method = request.getMethod();

		if (!method.equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		ServletInputStream inputStream = request.getInputStream();

		LoginRequestDto loginRequestDto = new ObjectMapper().readValue(inputStream, LoginRequestDto.class);

		return this.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
				loginRequestDto.username,
				loginRequestDto.password
		));
	}

	public record LoginRequestDto(
			String username,
			String password
	){}



//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        SecurityContextHolder.getContext().setAuthentication(authResult); // 이 부분을 추가
//        super.successfulAuthentication(request, response, chain, authResult);
//    }
}