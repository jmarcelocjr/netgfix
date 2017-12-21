package br.com.netgifx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.netgifx.dao.UsuarioDao;
import br.com.netgifx.model.Role;
import br.com.netgifx.model.Usuario;

@Controller
public class LoginController {
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String formularioLogin() {
		
		return "form-login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String acesso(Usuario usuario, HttpSession session) {

			UsuarioDao usuarioDao = new UsuarioDao();
			
			Usuario usuarioBanco = usuarioDao.buscarEmail(usuario.getEmail());
			
			if(usuarioBanco == null || !usuarioBanco.getSenha().equals(usuario.getSenha())) {
				return "form-login";
			} 
			
			usuario = usuarioBanco;
			
			session.setAttribute("usuario", usuario);
			
			return (usuario.isAdmin())? "redirect:/admin" : "redirect:/home";
		}
}
