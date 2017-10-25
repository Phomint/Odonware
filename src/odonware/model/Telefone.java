package odonware.model;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * Classe que valida CPF
 * @author Ana Carolina 
 * @since Classe criada em 21/10/2017
 */
public class Telefone {
    private String telefone;
    private static final String Formato = "(##) #####-####";
    
    //CONSTRUTOR
    public Telefone(String C) {
        this.telefone = this.Format(C,false);
    }//fim do contrutor
    
    
    public boolean isTelefone(){
        System.out.println("telefone -> validando");
        if (this.telefone.equals("00000000000") || 
            this.telefone.equals("11111111111") || 
            this.telefone.equals("22222222222") || 
            this.telefone.equals("33333333333") ||
            this.telefone.equals("44444444444") ||
            this.telefone.equals("55555555555") ||
            this.telefone.equals("66666666666") ||
            this.telefone.equals("77777777777") ||
            this.telefone.equals("88888888888") ||
            this.telefone.equals("99999999999") ||
            this.telefone.length() != 11){
            return(false);
        }
    return true;
       
    }//fim do isTelefone

    public String getTelefone(boolean Mascara) {
        return Format(this.telefone,Mascara);
    }//fim do getTelefone

    private String Format(String C, boolean Mascara){
        if(Mascara){
            return( "(" + C.substring(0, 2) + ") " + C.substring(2, 7) + "-" +
            C.substring(7, 11));
        }else{
            C = C.replace("(","");
            C = C.replace(")","");
            C = C.replace("-","");
            return C;
        }//fim do else
    }//fim do metodo Format
    
    
    public static DefaultFormatterFactory getFormat(){
        try {
            return new DefaultFormatterFactory(new MaskFormatter(Formato));
        } catch (Exception e) {
            return null;
        }//fim do catch
    }//fim do metodo getFormat
    
}//fim da classe Telefone
