package com.lucasMaraia.MeuProjetoWeb.controllers;

import com.lucasMaraia.MeuProjetoWeb.modelos.UserNotFoundException;
import com.lucasMaraia.MeuProjetoWeb.modelos.Usuario;
import com.lucasMaraia.MeuProjetoWeb.repositorios.UsuarioRepository;
import com.lucasMaraia.MeuProjetoWeb.servicos.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String listaUsuarios(Model model) {
        List<Usuario> listaUsuarios = usuarioService.listarTodosUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);

        return "usuarios";
    }

    @GetMapping("/usuarios/novo")
    public String insereUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("tituloDaPagina", "Adicionar novo Usuario");

        return "usuarioNovo";


    }


    @PostMapping("/usuario/salvar")
    public String salvarUsuario(Usuario usuario, RedirectAttributes ra) {
        usuarioService.salvar(usuario);

        ra.addFlashAttribute("mensagem", "Usuario salvo com sucesso");
        return "redirect:/usuarios";


    }

    @GetMapping("/usuarios/editar/{usuarioID}")
    public String editarUsuario(@PathVariable("usuarioID") Long usuarioID, Model model, RedirectAttributes ra) {
        try {
            Usuario usuario = usuarioService.get(usuarioID);
            model.addAttribute("usuario", usuario);
            model.addAttribute("tituloDaPagina", "Editar usuario " + usuario.getNome());
            return "usuarioNovo";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("mensagem", "Usuario editado com sucesso");
            return "redirect:/usuarios";
        }



        }


    @GetMapping("/usuarios/deletar/{usuarioID}")
    public String deletarUsuario(@PathVariable("usuarioID") Long usuarioID, Model model, RedirectAttributes ra) {
        try {
            usuarioService.deletar(usuarioID);
            ra.addFlashAttribute("mensagem", "Usuario deletado com sucesso");
            return "redirect:/usuarios";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("mensagem", "Usuario editado com sucesso");
            return "redirect:/usuarios";
        }



    }





    }




