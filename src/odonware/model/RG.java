package odonware.model;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * Classe que valida RG
 * @author Ana Carolina Santos
 * @since Classe criada em 21/10/2017
 */
public class RG {
    private String rg;
    private static final String Formato = "##.###.###-#";
    
    //CONSTRUTOR
    public RG(String C) {
        this.rg = this.Format(C,false);
    }//fim do contrutor
    
    
    public boolean isRG(){
        System.out.println("rg -> validando");
        if (this.rg.equals("000000000") || 
            this.rg.equals("111111111") || 
            this.rg.equals("222222222") || 
            this.rg.equals("333333333") ||
            this.rg.equals("444444444") ||
            this.rg.equals("555555555") ||
            this.rg.equals("666666666") ||
            this.rg.equals("777777777") ||
            this.rg.equals("888888888") ||
            this.rg.equals("999999999") ||
            this.rg.length() != 9){
            return(false);
        }
        return true;
    }//fim do isRG

    public String getRG(boolean Mascara) {
        return Format(this.rg,Mascara);
    }//fim do getRG

    private String Format(String C, boolean Mascara){
        if(Mascara){
            return(C.substring(0, 2) + "." + C.substring(2, 5) + "." +
            C.substring(5, 8) + "-" + C.substring(8, 9));
        }else{
            C = C.replace(".","");
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
}//fim da classe RG
