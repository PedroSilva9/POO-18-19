import java.util.Comparator;

//d)
public class ComparatorFaixas implements Comparator<Faixa> {
    public int compare(Faixa f1, Faixa f2){
        return f1.getUltimavez().compareTo(f2.getUltimavez());
    }
}
