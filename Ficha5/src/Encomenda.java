import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Encomenda {
    private String nome;
    private int nif;
    private String morada;
    private int numeroEncomenda;
    private String data;
    private List<LinhaEncomenda> encomendas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumeroEncomenda() {
        return numeroEncomenda;
    }

    public void setNumeroEncomenda(int numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<LinhaEncomenda> getEncomendas() {
        List<LinhaEncomenda> ret = new ArrayList<>();
        for(LinhaEncomenda l : this.encomendas){
            ret.add(l.clone());
        }
        return ret;
    }

    public void setEncomendas(List<LinhaEncomenda> encomendas) {
        for(LinhaEncomenda l : encomendas){
            this.encomendas.add(l);
        }
    }

    public double calculaValorTotal(){
        double total = 0;
        for(LinhaEncomenda l : this.encomendas){
            total += l.calculaValorLinhaEnc();
        }
        return total;
    }

    public double calculaValorDesconto(){
        return this.encomendas.stream()
                .mapToDouble(x -> x.calculaValorDesconto())
                .sum();
    }

    public int numeroTotalProdutos(){
        return this.encomendas.stream()
                .mapToInt(x -> x.getQuantidade())
                .sum();
    }

    public boolean existeProdutoEncomenda(String refProduto){
        //return this.encomendas.contains(refProduto);
        return this.encomendas.stream()
                .filter(x -> x.getReferencia().equals(refProduto))
                .collect(Collectors.toList())
                .isEmpty();
    }

    public void adicionaLinha(LinhaEncomenda linha){
        this.encomendas.add(linha);
    }

    public void removeProduto(String codProd){
        this.encomendas.remove(codProd);
    }
}
