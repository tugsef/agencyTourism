package com.tourism.agency.core.utilities.security.jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthTokenFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	//Http request  response larının isteğinin cevaplarını vermek için kullanılır
	//Var olacak sorunları hataları yada tokenin doğruluğunda da gitmesi gereken yere gitmesiini izin vereceğiz
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			
			String jwt = parseJwt(request);
			if(jwt !=null && jwtUtils.validateJwtToken(jwt)) {
				String username = jwtUtils.getUserNameFromJwtToken(jwt);
				
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails , null ,
						userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}
		
		 filterChain.doFilter(request, response);
	}
	
	  // Gelen iste aslında bir jwt isteği mi jwt kullanıyor mu
	private String parseJwt(HttpServletRequest request) {
		
		String headerAuth = request.getHeader("Authorization");

	    //Gelen header başlığı null mı ve Bearerla başlıyor mu?
	    //Bearla başlamasının nedeni benzersiz şifrelenmiş karakterlerin başında herhangi bir yerden sunucuya istekgeldiği zaman
	    //Authorization Bearer başlığıile gelmeli bunların olup olmadığını onrol etmem gerekir
		
		if(StringUtils.hasText(headerAuth)&&headerAuth.startsWith("Bearer ")){
			//Bu örnekte  eğer header ve bear var ise header eğer 7 satırdan başlarsa ben tokenıma ulaşaabilirim
			//Bundan sonra anlamsız bu değerlerden usurnamr bulmam gerekiyor metod yukarıda kullanılmıştır...
			return headerAuth.substring(7 , headerAuth.length());
		}
		return null;
	}
	
}