import org.omg.PortableInterceptor.ServerRequestInfo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class YouTube {
    private String nomeVid;
    private int bytes;
    private LocalDate data;
    private int resolucaoX;
    private int resolucaoY;
    private int duracao_segundos;
    private List<String> comentarios;
    private int likes;
    private int dislikes;

    public YouTube(){
        this.nomeVid = "";
        this.bytes = 0;
        this.data = LocalDate.now();
        this.resolucaoX = resolucaoX;
        this.resolucaoY = resolucaoY;
        this.duracao_segundos = duracao_segundos;
        this.comentarios = comentarios;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public YouTube(String nomeVid, int bytes, LocalDate data, int resolucaoX, int resolucaoY, int duracao_segundos, List<String> comentarios, int likes, int dislikes) {
        this.nomeVid = nomeVid;
        this.bytes = bytes;
        this.data = data;
        this.resolucaoX = resolucaoX;
        this.resolucaoY = resolucaoY;
        this.duracao_segundos = duracao_segundos;
        this.comentarios = comentarios;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public YouTube(YouTube yt){
        this.nomeVid = yt.getNomeVid();
        this.bytes = yt.getBytes();
        this.data = yt.getData();
        this.resolucaoX = getResolucaoX();
        this.resolucaoY = getResolucaoY();
        this.duracao_segundos = getDuracao_segundos();
        this.comentarios = yt.getComentarios();
        this.likes = yt.getLikes();
        this.dislikes = yt.getDislikes();
    }

    public String getNomeVid() {
        return nomeVid;
    }

    public void setNomeVid(String nomeVid) {
        this.nomeVid = nomeVid;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getResolucaoX() {
        return resolucaoX;
    }

    public void setResolucaoX(int resolucaoX) {
        this.resolucaoX = resolucaoX;
    }

    public int getResolucaoY() {
        return resolucaoY;
    }

    public void setResolucaoY(int resolucaoY) {
        this.resolucaoY = resolucaoY;
    }

    public int getDuracao_segundos() {
        return duracao_segundos;
    }

    public void setDuracao_segundos(int duracao_segundos) {
        this.duracao_segundos = duracao_segundos;
    }

    public List<String> getComentarios() {
        return new ArrayList<>(this.comentarios);
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = new ArrayList<>(comentarios);
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void insereComentario(String comentario){
        this.comentarios.add(comentario);
    }

    public long qtdDiasDepois(){
        LocalDate date = LocalDate.now();
        Period period = Period.between(date, this.data);
        return period.getDays();
    }

    public void thumbsUp(){
        this.likes++;
    }

    public String processa(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.bytes);
        return sb.toString();
    }
}
