package odonware.controller;

import jdk.nashorn.internal.ir.annotations.Ignore;
import odonware.model.Usuario;
import odonware.model.dao.UsuarioDAO;

/**
 * Classe para gerar objetos do tipo Controller
 * @author Patrick Amaral
 * @sinse Classe criada em 11/06/2017
 */
public class Controller {
         @Ignore
         public static void main(String []args){          
             Usuario usuario = new Usuario("admin",UsuarioController.criptografarSenha("admin123"));
             UsuarioDAO uDao = new UsuarioDAO();
             uDao.createUsuario(usuario);
         }//fim do main
}//fim da classe Controller
