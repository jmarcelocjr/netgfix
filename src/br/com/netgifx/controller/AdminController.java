package br.com.netgifx.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.netgifx.dao.UsuarioDao;
import br.com.netgifx.model.Role;
import br.com.netgifx.model.Usuario;

@Controller
public class AdminController {
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String formularioUsuario(Model model) {
		Role[] roles = Role.values();
		
		model.addAttribute("roles", roles);
		
		return "form-usuario";
	}
	
	@RequestMapping(value = "/usuarios")
	public String listarUsuarios(Model model) {
		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.listar();

		model.addAttribute("usuarios", usuarios);

		return "lista-usuarios";
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String cadastrarUsuario(Usuario usuario, Model model) {
		UsuarioDao usuarioDao = new UsuarioDao();

		boolean hasSaved = usuarioDao.cadastra(usuario);
		model.addAttribute("hasSaved", hasSaved);

		return "redirect:/usuarios";
	}
	
	
}
