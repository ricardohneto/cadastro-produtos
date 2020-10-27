package projeto;

public class Categorias {

    private String _nome;
    private int _codigo;
    private double _peso;
    private double _valor;

    void setNome(String nome) {
        this._nome = nome;
    }

    String getNome() {
        return _nome;
    }

    void setCodigo(int codigo) {
        this._codigo = codigo;
    }

    int getCodigo() {
        return _codigo;
    }

    void setPeso(double peso) {
        this._peso = peso;
    }

    double getPeso() {
        return _peso;
    }

    public void setValor(double valor) {
        this._valor = valor;
    }

    public double getValor() {
        return _valor;
    }

}