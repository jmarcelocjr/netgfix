package br.com.netgifx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.netgifx.model.Usuario;

public class AdminAccessFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		HttpSession session = httpRequest.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if (usuario == null || !usuario.isAdmin()) {
			httpResponse.sendRedirect(httpRequest.getContextPath());
			return;
		}
				
		chain.doFilter(request, response);
	}
}
