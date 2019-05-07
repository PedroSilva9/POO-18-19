import java.util.Comparator;

public class ComparatorOrdemDecrescenteNum implements Comparator<Aluno> {
    public int compare(Aluno a1, Aluno a2){
        return a2.getNumero().compareTo(a1.getNumero());
    }
}
