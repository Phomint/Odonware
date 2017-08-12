package odonware.controller;

import odonware.model.Usuario;
import odonware.model.dao.UsuarioDAO;
import odonware.view.FXMLPrincipalController;

/**
 * Classe para gerar objetos do tipo LoginController
 * @author Patrick Amaral
 * @sinse Classe criada em 07/06/2017
 */
public class LoginController {
     public static boolean efetuarLogin(String login, String senha) {
         System.out.println("controller >> efetuarLogin");
         UsuarioDAO dao = new UsuarioDAO();
         Usuario usuario = dao.validarLogin(login, senha);
         FXMLPrincipalController.user = login;         
        return usuario != null;  
    }//fim do efetuarLogin
   
}//fim da classe LoginController
