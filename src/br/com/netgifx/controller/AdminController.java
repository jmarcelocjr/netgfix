package br.com.netgifx.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.netgifx.dao.CategoriaDao;
import br.com.netgifx.dao.GifDao;
import br.com.netgifx.dao.UsuarioDao;
import br.com.netgifx.model.Role;
import br.com.netgifx.model.Usuario;
import br.com.netgifx.model.gif.Categoria;
import br.com.netgifx.model.gif.Gif;

@Controller
public class AdminController {
	
	@RequestMapping(value = "/admin/usuario", method = RequestMethod.GET)
	public String formularioUsuario(Model model) {
		Role[] roles = Role.values();
		
		model.addAttribute("roles", roles);
		
		return "admin/form-usuario";
	}
	
	@RequestMapping(value = "/admin/usuarios", method = RequestMethod.GET)
	public String listarUsuarios(Model model) {
		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.listar();

		model.addAttribute("usuarios", usuarios);

		return "admin/lista-usuarios";
	}
	
	@RequestMapping(value = "/admin/usuario", method = RequestMethod.POST)
	public String cadastrarUsuario(Usuario usuario, Model model) {
		UsuarioDao usuarioDao = new UsuarioDao();

		boolean hasSaved = usuarioDao.cadastra(usuario);
		model.addAttribute("hasSaved", hasSaved);

		return "redirect:/admin/usuarios";
	}
	
	@RequestMapping(value = "/admin/categoria", method = RequestMethod.GET)
	public String formularioCategoria(Model model) {		
		return "admin/form-categoria";
	}
	
	@RequestMapping(value = "/admin/categorias", method = RequestMethod.GET)
	public String listarCategorias(Model model) {
		CategoriaDao categoriaDao = new CategoriaDao();
		List<Categoria> categorias = categoriaDao.listar();

		model.addAttribute("categorias", categorias);

		return "admin/lista-categorias";
	}
	
	@RequestMapping(value = "/admin/categoria", method = RequestMethod.POST)
	public String cadastrarCategoria(Categoria categoria, Model model) {
		CategoriaDao categoriaDao = new CategoriaDao();

		boolean hasSaved = categoriaDao.cadastra(categoria);
		model.addAttribute("hasSaved", hasSaved);

		return "redirect:/admin/categorias";
	}
	
	@RequestMapping(value = "/admin/gif", method = RequestMethod.GET)
	public String formularioGif(Model model) {
		CategoriaDao categoriaDao = new CategoriaDao();
		model.addAttribute("categorias", categoriaDao.listar());

		return "admin/form-gif";
	}
	
	@RequestMapping(value = "/admin/gifs", method = RequestMethod.GET)
	public String listarGifs(Model model) {
		GifDao gifDao = new GifDao();
		List<Gif> gifs = gifDao.listar();

		model.addAttribute("gifs", gifs);

		return "admin/lista-gifs";
	}
	
	@RequestMapping(value = "/admin/gif", method = RequestMethod.POST)
	public String cadastrarGif(Gif gif, @RequestParam("arquivo") MultipartFile file, Model model) {
		GifDao gifDao = new GifDao();

		boolean hasSaved = gifDao.cadastra(gif, file);
		model.addAttribute("hasSaved", hasSaved);

		return "redirect:/admin/gifs";
	}

}
