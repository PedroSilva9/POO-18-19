import java.util.*;
import java.util.stream.Collectors;

public class Parque {
    private String nome;
    private Map<String,Lugar> lugares;

    public Parque(){
        this.nome = "";
        this.lugares = new HashMap<>();
    }

    public Parque(String nome, Map<String,Lugar> lugares){
        this.nome = nome;
        this.lugares = new HashMap<>();
        for(Lugar l : lugares.values()){
            this.lugares.put(l.getMatricula(), l.clone());
        }
    }

    public Parque(Parque p){
        this.nome = p.getNome();
        this.lugares = p.getLugares();
    }

    public String getNome(){
        return this.getNome();
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Parque clone(){
        return new Parque(this);
    }

    public Map<String,Lugar> getLugares(){
        HashMap hashmap = new HashMap<>();
        for(Lugar l : this.lugares.values()){
            hashmap.put(l.getMatricula(), l.clone());
        }
        return hashmap;
    }

    public void setLugares(Map<String,Lugar> hashmap){
        for(Lugar l : hashmap.values()){
            this.lugares.put(l.getMatricula(), l.clone());
        }
    }

    // considerei ocupado se tiver minutos atribuidos ao lugar
    public List<String> ocupados(){
        return this.lugares.values().stream()
                .filter(x -> x.getMinutos() > 0)
                .map(x -> x.getMatricula())
                .collect(Collectors.toList());
    }

    public void addAluguer(Lugar l){
        this.lugares.put(l.getMatricula(), l);
    }

    public void removeLugar(Lugar l){
        this.lugares.remove(l.getMatricula());
    }

    public void alteraTempo(int tempo, String matricula){
        this.lugares.get(matricula).setMinutos(tempo);
    }

    public int totalMinutos_I(){
        return this.lugares.values().stream()
                .mapToInt(x -> x.getMinutos())
                .sum();
    }

    public int totalMinutos_E(){
        int total = 0;
        for(Lugar l : this.lugares.values()) {
            total += l.getMinutos();
        }
        return total;
    }

    public boolean existe(String matricula){
        return this.lugares.values().stream()
                .anyMatch(x -> x.getMatricula().equals(matricula));
    }

    public boolean existe2(String matricula){
        return this.lugares.containsKey(matricula);
    }

    public List<String> getMatriculasByTime_I(int y){
        return this.lugares.values().stream()
                .filter(x -> x.getMinutos() > y && x.getPermanente())
                .map(Lugar::getMatricula)
                .collect(Collectors.toList());
    }

    public List<String> getMatriculasByTime_E(int y){
        List<String> list = new ArrayList<>();
        for (Lugar l : this.lugares.values()){
            if (l.getMinutos() > y && l.getPermanente()){
                list.add(l.getMatricula());
            }
        }
        return list;
    }

    public List<Lugar> copiaLugares(){
        return new ArrayList<>(this.lugares.values());
    }

    public List<Lugar> copiaLugares2(){
        return this.lugares.values().stream()
                .map(Lugar::clone)
                .collect(Collectors.toList());
    }

    public Lugar lugarInfo(String matricula){
        Iterator<Lugar> it = this.lugares.values().iterator();
        boolean found = false;
        Lugar l = null;
        while (it.hasNext() && !found){
            l = it.next();
            if (l.getMatricula().equals(matricula)){
                found = true;
            }
        }
        return l;
    }
}
