import java.util.Comparator;

public class ComparatorOrdemAlfabetica implements Comparator<Aluno> {
    public int compare(Aluno a1, Aluno a2){
        return a1.getNome().compareTo(a2.getNome());
    }
}
