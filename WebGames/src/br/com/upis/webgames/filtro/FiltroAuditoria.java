package br.com.upis.webgames.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 
import javax.servlet.http.HttpServletRequest;

import br.com.upis.webgames.entidade.Usuario;

public class FiltroAuditoria implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.getRequestURI();
		String uri = req.getRequestURI();
		String usuario= getUsuario((HttpServletRequest) request);
		System.out.println("Usuário " +usuario+ " acessando a URI " + uri);
		chain.doFilter(request, response);
	}

	
	private String getUsuario(HttpServletRequest request){
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		if(usuario == null)return "deslogado";
		return usuario.getEmail();
		
	}
}
