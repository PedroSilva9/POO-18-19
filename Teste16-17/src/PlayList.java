import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayList {
    private String nome;
    private Map<String, List<Faixa>> musicas;

    public PlayList() {
        this.nome = "";
        this.musicas = new HashMap<>();
    }

    public PlayList(String nome, Map<String, List<Faixa>> musicas) {
        this.nome = nome;
        this.musicas = this.getMusicas();
    }

    public PlayList(PlayList p) {
        this.nome = p.getNome();
        this.musicas = p.getMusicas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, List<Faixa>> getMusicas() {
        Map <String, List<Faixa>> ret = null;
        for (List<Faixa> lf : this.musicas.values()){
            List<Faixa> nova = null;
            for (Faixa f : lf){
                nova.add(f.clone());
            }
            ret.put(nova.get(0).getAutor(), nova);
        }
        return ret;
    }

    public void setMusicas(Map<String, List<Faixa>> musicas) {
        for (List<Faixa> lf : musicas.values()){
            List<Faixa> nova = null;
            for (Faixa f : lf){
                nova.add(f.clone());
            }
            this.musicas.put(nova.get(0).getAutor(), nova);
        }
    }

    //a)
    public List<Faixa> getFaixas(String autor) throws AutorInexistenteException {
       if (this.musicas.containsKey(autor))
           return this.musicas.get(autor);
       else throw new AutorInexistenteException();
    }

    //b)
    public double tempoTotal(String autor) throws AutorInexistenteException {
        if (this.musicas.containsKey(autor))
            return this.musicas.get(autor).stream()
                    .mapToDouble(Faixa::getDuracao)
                    .sum();
        else throw new AutorInexistenteException();
    }

    //3-a)
    public List<Faixa> todasAsFaixas(){
        return this.musicas.values().stream()
                .flatMap(Collection::stream)
                .map(Faixa::clone)
                .collect(Collectors.toList());
    }

    //3-b)
    public Map<Integer, List<Faixa>> faixasPorClass(){
        return this.musicas.values().stream()
                .flatMap(Collection::stream)
                .map(Faixa::clone)
                .collect(Collectors.groupingBy(Faixa::getClassificacao));
    }
















}
