import java.util.*;
import java.util.stream.Collectors;

public class HoteisInc {
    private String nomeCadeia;
    private Map<String, Hotel> hoteis;

    public HoteisInc(){
        this.nomeCadeia = "";
        this.hoteis = new HashMap<>();
    }

    public HoteisInc(String nome, Map<String,Hotel> hoteis){
        this.nomeCadeia = nome;
        this.hoteis = new HashMap<>();
        this.hoteis = hoteis.values().stream().collect(Collectors.toMap((e) -> e.getId(), (e) -> e.clone()));
    }

    public HoteisInc(HoteisInc hoteis){
        this.nomeCadeia = hoteis.getNomeCadeia();
        this.hoteis = hoteis.getHoteis();
    }

    public String getNomeCadeia(){
        return this.nomeCadeia;
    }

    public void setNomeCadeia(String nomeCadeia){
        this.nomeCadeia = nomeCadeia;
    }

    public Map<String, Hotel> getHoteis(){
        Map<String, Hotel> hoteis = new HashMap<>();
        for (Hotel h : this.hoteis.values()){
            hoteis.put(h.getId(), h.clone());
        }
        return hoteis;
    }

    public void setHoteis(Map<String,Hotel> hoteis){
        for (Hotel h : hoteis.values()){
            this.hoteis.put(h.getId(),h.clone());
        }
    }

    public HoteisInc clone(){
        return new HoteisInc(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoteisInc hoteisInc = (HoteisInc) o;
        return this.hoteis.equals(hoteisInc.getHoteis()) &&
               this.nomeCadeia.equals(hoteisInc.getNomeCadeia());
    }

    public boolean existeHotel(String cod){
        return this.hoteis.containsKey(cod);
    }

    public int quantos(){
        return this.hoteis.size();
    }

    public int quantos(String loc){
        return (int) this.hoteis.values().stream()
                .filter(x -> x.getLocalidade().equals(loc))
                .count();
    }

    public Hotel getHotel(String cod){
        return this.hoteis.get(cod).clone();
    }

    public void adiciona(Hotel h){
        this.hoteis.put(h.getId(), h.clone());
    }

    public List<Hotel> getAllHoteis(){
        List<Hotel> hoteis = new ArrayList<>();
        for (Hotel h : this.hoteis.values()){
            hoteis.add(h.clone());
        }
        return hoteis;
    }

    public void adiciona(Set<Hotel> hs){
        for (Hotel h : hs){
            this.hoteis.put(h.getId(), h.clone());
        }
    }

    public int quantosTipo(String tipo){
        return (int) this.hoteis.values().stream().filter(h -> h.getClass().getSimpleName().equals(tipo)).count();
    }

    public void mudaPara(String epoca){
        for(Hotel h : hoteis.values()){
            if(h instanceof HotelStandard){
                if(epoca.equals("Alta")){
                    ((HotelStandard) h).setEpocaAlta(true);
                }else{
                    ((HotelStandard) h).setEpocaAlta(false);
                }
            }
        }
    }

    public int totalDiario(){
        return (int) this.hoteis.values().stream()
                .map(Hotel::getPreco)
                .count();
    }
}
