import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Telemovel {
    private String marca;
    private String modelo;
    private double resolucaoX;
    private double resolucaoY;
    private int dimensao_mensagens;
    private int dimensao_fotos;
    private int dimensao_apps;
    private int espaco_ocupado;
    private int fotos;
    private int apps;
    private List<String> nomeApps;

    public Telemovel(){
        this.marca = "";
        this.modelo = "";
        this.resolucaoX = 0;
        this.resolucaoY = 0;
        this.dimensao_mensagens = 0;
        this.dimensao_fotos = 0;
        this.dimensao_apps = 0;
        this.espaco_ocupado = 0;
        this.apps = 0;
        this.nomeApps = new ArrayList<>();
    }
    public Telemovel(String marca, String modelo, double resolucaoX, double resolucaoY, int dimensao_mensagens, int dimensao_fotos, int dimensao_apps, int espaco_ocupado, int fotos, int apps, List<String> nomeApps) {
        this.marca = marca;
        this.modelo = modelo;
        this.resolucaoX = resolucaoX;
        this.resolucaoY = resolucaoY;
        this.dimensao_mensagens = dimensao_mensagens;
        this.dimensao_fotos = dimensao_fotos;
        this.dimensao_apps = dimensao_apps;
        this.espaco_ocupado = espaco_ocupado;
        this.fotos = fotos;
        this.apps = apps;
        this.setNomeApps(nomeApps);
    }

    public Telemovel(Telemovel t){
        this.marca = t.getMarca();
        this.modelo = t.getModelo();
        this.resolucaoY = t.getResolucaoX();
        this.resolucaoY = t.getResolucaoY();
        this.dimensao_mensagens = t.getDimensao_mensagens();
        this.dimensao_fotos = t.getDimensao_fotos();
        this.dimensao_apps = t.getDimensao_apps();
        this.espaco_ocupado = t.getEspaco_ocupado();
        this.fotos = t.getFotos();
        this.apps = t.getApps();
        this.setApps(t.getApps());
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getResolucaoX() {
        return resolucaoX;
    }

    public double getResolucaoY() {
        return resolucaoY;
    }

    public int getDimensao_mensagens() {
        return dimensao_mensagens;
    }

    public int getDimensao_fotos() {
        return dimensao_fotos;
    }

    public int getDimensao_apps() {
        return dimensao_apps;
    }

    public int getEspaco_ocupado(){
        return this.espaco_ocupado;
    }

    public int getFotos() {
        return fotos;
    }

    public int getApps() {
        return apps;
    }

    public List<String> getNomeApps() {
        return new ArrayList<>(this.nomeApps);
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setResolucaoX(double resolucaoX) {
        this.resolucaoX = resolucaoX;
    }

    public void setResolucaoY(double resolucaoY) {
        this.resolucaoY = resolucaoY;
    }

    public void setDimensao_mensagens(int dimensao_mensagens) {
        this.dimensao_mensagens = dimensao_mensagens;
    }

    public void setDimensao_fotos(int dimensao_fotos) {
        this.dimensao_fotos = dimensao_fotos;
    }

    public void setDimensao_apps(int dimensao_apps) {
        this.dimensao_apps = dimensao_apps;
    }

    public void setEspaco_ocupado(int espaco_ocupado) {
        this.espaco_ocupado = espaco_ocupado;
    }

    public void setFotos(int fotos) {
        this.fotos = fotos;
    }

    public void setApps(int apps) {
        this.apps = apps;
    }

    public void setNomeApps(List<String> nomeApps) {
        this.nomeApps = new ArrayList<>(nomeApps);
    }

    public int espacoTotal(){
        return this.dimensao_apps + this.dimensao_fotos + this.dimensao_mensagens;
    }

    public boolean existeEspaço(int numeroBytes){
        int x = this.espacoTotal();
        int y = x - this.espaco_ocupado;
        return y>=numeroBytes;
    }

    public void instalaApp(String nome, int tamanho){
        this.apps++;
        this.dimensao_apps += tamanho;
        this.nomeApps.add(nome);
    }

    public void recebeMsg(String msg){
        this.dimensao_mensagens += msg.length();
    }

    public double tamMedioApps(){
        return (double)this.apps / this.nomeApps.size();
    }

    public void removeApp(String nome, int tamanho){
        this.apps--;
        this.dimensao_apps -= tamanho;
        this.nomeApps.remove(nome);
    }
}
