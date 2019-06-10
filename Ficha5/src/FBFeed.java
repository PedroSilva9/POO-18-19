import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FBFeed {
    private List<FBPost> posts;

    public FBFeed(){
        this.posts = new ArrayList<>();
    }

    public FBFeed(List<FBPost> elems){
        this.posts = new ArrayList<>();
        for(FBPost p : elems){
            this.posts.add(p.clone());
        }
    }

    public FBFeed(FBFeed f){
        setPosts(f.getPosts());
    }

    public List<FBPost> getPosts(){
        List<FBPost> ret = new ArrayList<>();
        for(FBPost f : this.posts){
            ret.add(f.clone());
        }
        return ret;
    }

    public void setPosts(List<FBPost> elems){
        this.posts = new ArrayList<>();
        for(FBPost f : elems){
            this.posts.add(f.clone());
        }
    }

    public int nrPosts(String user){
        return (int) this.posts.stream()
                .filter(x -> x.getUsername().equals(user))
                .count();
    }

    public List<FBPost> postsOf(String user){
        List<FBPost> lista = new ArrayList<>();
        this.posts.forEach((FBPost p) -> {
                    if (p.getUsername().equals(user)){
                        lista.add(p.clone());
                    }
                });
        return lista;
    }

    public FBPost getPost(int id){
        return this.posts.stream()
                .filter(x -> x.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }

    public void comment(FBPost post, String comentario){
        Iterator<FBPost> it = this.posts.iterator();
        FBPost f;
        boolean found = false;
        while (it.hasNext() && !found){
            f = it.next();
            if (f.equals(post)){
                f.addComentario(comentario);
                found = true;
            }
        }
    }

    public void comment(int postid, String comentario){
        Iterator<FBPost> it = this.posts.iterator();
        FBPost f;
        boolean found = false;
        while (it.hasNext() && !found){
            f = it.next();
            if (f.getId() == postid){
                f.addComentario(comentario);
                found = true;
            }
        }
    }

    public void like(FBPost post){
        Iterator<FBPost> it = this.posts.iterator();
        FBPost f;
        boolean found = false;
        while (it.hasNext() && !found){
            f = it.next();
            if (f.equals(post)){
                f.addLike();
                found = true;
            }
        }
    }

    public void like(int postid){
        Iterator<FBPost> it = this.posts.iterator();
        FBPost f;
        boolean found = false;
        while (it.hasNext() && !found){
            f = it.next();
            if (f.getId() == postid){
                f.addLike();
                found = true;
            }
        }
    }

    public List<Integer> top5Comments(){
        return this.posts.stream()
                .sorted(new ComparatorComentarios())
                .limit((long) 5)
                .map(FBPost::getId)
                .collect(Collectors.toList());
    }
}
