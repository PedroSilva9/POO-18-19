import java.util.Comparator;

public class ComparatorComentarios implements Comparator<FBPost> {
    public int compare(FBPost p1, FBPost p2){
        return p1.getComentarios().size() - p2.getComentarios().size();
    }
}
