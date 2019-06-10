import java.time.LocalDateTime;
import java.util.ArrayList;

public class Faixa implements Playable{
    private String nome;
    private String autor;
    private double duracao;
    private int classificacao;
    private ArrayList<String> letra;
    private int numeroVezesTocada;
    private LocalDateTime ultimavez;

    public Faixa(){
        this.nome = "";
        this.autor = "";
        this.duracao = 0;
        this.classificacao = 0;
        this.letra = new ArrayList<>();
        this.numeroVezesTocada = 0;
        this.ultimavez = LocalDateTime.now();
    }

    public Faixa(String nome, String autor, double duracao, int classificacao, ArrayList<String> letra, int numeroVezesTocada, LocalDateTime ultimavez){
        this.nome = nome;
        this.autor = autor;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.letra = letra;
        this.numeroVezesTocada = numeroVezesTocada;
        this.ultimavez = ultimavez;
    }

    //a)
    public Faixa(Faixa f){
        this.nome = f.getNome();
        this.autor = f.getAutor();
        this.duracao = f.getDuracao();
        this.classificacao = f.getClassificacao();
        this.letra = f.getLetra();
        this.numeroVezesTocada = f.getNumeroVezesTocada();
        this.ultimavez = f.getUltimavez();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public ArrayList<String> getLetra() {
        return letra;
    }

    public void setLetra(ArrayList<String> letra) {
        this.letra = letra;
    }

    public int getNumeroVezesTocada() {
        return numeroVezesTocada;
    }

    public void setNumeroVezesTocada(int numeroVezesTocada) {
        this.numeroVezesTocada = numeroVezesTocada;
    }

    public LocalDateTime getUltimavez() {
        return ultimavez;
    }

    public void setUltimavez(LocalDateTime ultimavez) {
        this.ultimavez = ultimavez;
    }

    public Faixa clone(){
        return new Faixa(this);
    }

    // b)
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Faixa f = (Faixa) o;
        return this.nome.equals(f.getNome()) &&
               this.autor.equals(f.getAutor());
    }

    //c)
    public int compareTo(Faixa f){
        return (this.numeroVezesTocada - f.getNumeroVezesTocada());
    }

    public void play(){
        //System.audio(this.getLetra()); -- comentado pq System.audio nao existe
        return;
    }
}
