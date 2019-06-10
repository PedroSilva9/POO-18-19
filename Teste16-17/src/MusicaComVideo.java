import java.time.LocalDateTime;
import java.util.ArrayList;

public class MusicaComVideo extends Faixa{
    private String vid;

    //b)
    public MusicaComVideo (String vid, String nome, String autor, double duracao, int classificacao, ArrayList<String> letra, int numeroVezesTocada, LocalDateTime ultimavez){
        super(nome, autor, duracao, classificacao, letra, numeroVezesTocada, ultimavez);
        this.vid = vid;
    }

    //c)
    public void play() {
        super.play();
        System.out.println(vid);
    }
}
