/**
 * Escreva a descrição da classe Hotel aqui.
 * 
 * @author Pedro Silva
 */
public class Hotel{
    private String id;
    private String nome;
    private String localidade;
    private String categoria;
    private int nQuartos;
    private double preco;
    
    public Hotel(){
        this.id = "";
        this.nome = "";
        this.localidade = "";
        this.categoria = "";
        this.nQuartos = 0;
        this.preco = 0;
    }
    public Hotel(String id, String nome, String localidade, String categoria, int nq, double preco){
        this.id = id;
        this.nome = nome;
        this.localidade = localidade;
        this.categoria = categoria;
        this.nQuartos = nq;
        this.preco = preco;
    }
    public Hotel (Hotel outroHotel){
        this.id = outroHotel.getId();
        this.nome = outroHotel.getNome();
        this.localidade = outroHotel.getLocalidade();
        this.categoria = outroHotel.getCategoria();
        this.nQuartos = outroHotel.getNQuartos();
        this.preco = outroHotel.getPreco();
    }

    public String getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getLocalidade(){
        return this.localidade;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public int getNQuartos(){
        return this.nQuartos;
    }
    public double getPreco(){
        return this.preco;
    }
    public Hotel clone() {
        return new Hotel(this);
    }
    
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        Hotel h = (Hotel) obj;
        return h.getId().equals(this.id) &&
               h.getNome().equals(this.nome) &&
               h.getLocalidade().equals(this.localidade) &&
               h.getCategoria().equals(this.categoria) &&
               h.getNQuartos() == this.nQuartos &&
               h.getPreco() == this.preco;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(this.id);
        sb.append("Nome: ").append(this.nome);
        sb.append("Localidade: ").append(this.localidade);
        sb.append("Categoria: ").append(this.categoria);
        sb.append("Número de Quartos: ").append(this.nQuartos);
        sb.append("Preço por noite: ").append(this.preco);
        return sb.toString();
    }
}
