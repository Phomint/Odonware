package odonware.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import odonware.model.Dentista;
import odonware.model.Funcionario;
import odonware.model.Usuario;
import odonware.model.dao.DentistaDAO;
import odonware.model.dao.FuncionarioDAO;
import odonware.model.dao.UsuarioDAO;

/**
 * Classe para gerar objetos do tipo UsuarioController
 * @author Patrick Amaral
 * @sinse Classe criada em 05/06/2017
 */
public class UsuarioController {  
    
 
     public static void salvarDentista(int cro,String especialidade,String nome, String rg, String cpf, String endereco, int numero,
              String bairro, String cidade, String telefone, String email,String user,String senha){
         
          
          Usuario usuario = new Usuario(user, senha);
          UsuarioDAO uDao = new UsuarioDAO();
          uDao.createUsuario(usuario);
          
          Dentista dentista = new Dentista(nome, rg, cpf, endereco, numero, bairro, cidade, telefone, email, cro, especialidade, usuario);
          DentistaDAO dDao = new DentistaDAO();
          dDao.createDentista(dentista);
          
      }//fim do metodo salvarUsuario
     public static void salvarFuncionario(String nome, String rg, String cpf, String endereco, int numero, String bairro, String cidade, String telefone, String email,String user,String senha){
         Usuario usuario = new Usuario(user, senha);
         UsuarioDAO uDao = new UsuarioDAO();
         uDao.createUsuario(usuario);
         
         Funcionario funcionario = new Funcionario(nome, rg, cpf, endereco, numero, bairro, cidade, telefone, email, usuario);
         FuncionarioDAO fDao = new  FuncionarioDAO();
         fDao.createFuncionario(funcionario);
                  
     }//fim do salvarFuncionario
     public static String criptografarSenha(String senha){
         MessageDigest md;
         try {
             md = MessageDigest.getInstance("MD5");
             BigInteger hash = new BigInteger(1,md.digest(senha.getBytes()));
             return hash.toString(16);
         } catch (NoSuchAlgorithmException e) {
             System.out.println("Erro Criptografia ->"+e);
         }
         return null;
     }//fim do criptografarSennha
}//fim da classe UsuarioController
