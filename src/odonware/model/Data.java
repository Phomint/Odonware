package odonware.model;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * Classe que valida RG
 * @author Ana Carolina Santos
 * @since Classe criada em 21/10/2017
 */
public class Data {
    private String data;
    private static final String Formato = "##/##/####";
    
    //CONSTRUTOR
    public Data(String C) {
        this.data = this.Format(C,false);
    }//fim do contrutor
    
    
    public boolean isData(){
        System.out.println("data -> validando");
        if (this.data.length() != 8) {
            
            return(false);
        }
        return true;
    }//fim do isData

    public String getData(boolean Mascara) {
        return Format(this.data,Mascara);
    }//fim do getData

    private String Format(String C, boolean Mascara){
        if(Mascara){
            return(C.substring(0, 2) + "/" + C.substring(2, 4) + "/" +
            C.substring(4, 8));
        }else{
            C = C.replace("/","");
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
}//fim da classe Data
