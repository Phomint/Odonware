package odonware.model;

/**
 * Classe para gerar objetos do tipo Orcamento
 * @author Patrick Amaral
 * @sinse Classe criada em 01/06/2017
 */
public class Orcamento {
    private int codigo;
    private String paciente;
    private String servico;
    private int quantidadeServico;
    private float valorUnitario;
    private int quantidadeParcelas;
    private float valorParcelas;
    
    //CONSTRUTOR
    public Orcamento(int codigo, String paciente, String servico, int quantidadeServico, float valorUnitario, int quantidadeParcelas, float valorParcelas) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.servico = servico;
        this.quantidadeServico = quantidadeServico;
        this.valorUnitario = valorUnitario;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorParcelas = valorParcelas;
    }//fim do construtor
    
    //SETTER E GETTER
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getQuantidadeServico() {
        return quantidadeServico;
    }

    public void setQuantidadeServico(int quantidadeServico) {
        this.quantidadeServico = quantidadeServico;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public float getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(float valorParcelas) {
        this.valorParcelas = valorParcelas;
    }
    
    
}//fim da classe Orcamento
