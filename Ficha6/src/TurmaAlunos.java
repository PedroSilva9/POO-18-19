import javax.print.DocFlavor;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class TurmaAlunos {
    private Map<String, Aluno> turma;

    public TurmaAlunos(){
        this.turma = new HashMap<>();
    }

    public TurmaAlunos(Map<String,Aluno> turma){
        this.turma = new HashMap<>();
        for (Aluno a : turma.values()){
            this.turma.put(a.getNumero(), a.clone());
        }
    }

    public TurmaAlunos(TurmaAlunos turma){
        this.turma = turma.getTurma();
    }

    public Map<String, Aluno> getTurma(){
        Map<String,Aluno> ret = new HashMap<>();
        for (Aluno a : this.turma.values()){
            ret.put(a.getNumero(), a.clone());
        }
        return ret;
    }

    public void setTurma(Map<String,Aluno> hashmap){
        for (Aluno a : hashmap.values()){
            this.turma.put(a.getNumero(), a.clone());
        }
    }

    public TurmaAlunos clone(){
        return new TurmaAlunos(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaAlunos that = (TurmaAlunos) o;
        return this.turma.equals(that);
    }

    public void insereAluno(Aluno a){
        this.turma.put(a.getNumero(),a.clone());
    }

    public Aluno getAluno(String codAluno){
        return this.turma.get(codAluno);
    }

    public void removeAlunos(String codAluno){
        this.turma.remove(codAluno);
    }

    public Set<String> todosOsCodigos(){
        Set<String> hashset = new HashSet<>();
        for(String s : this.turma.keySet()){
            hashset.add(s);
        }
        return hashset;
    }

    public int qtsAlunos(){
        return this.turma.size();
    }

    public Set<Aluno> alunosOrdemAlfabetica(){
        return this.turma.values().stream()
                .map(Aluno::clone)
                .collect(Collectors.toCollection(() -> new TreeSet<Aluno>(new ComparatorOrdemAlfabetica())));
    }

    public Set<Aluno> alunosOrdemAlfabetica2(){
        Set<Aluno> ret = new TreeSet<>(new ComparatorOrdemAlfabetica());
        for (Aluno a : this.turma.values()){
            ret.add(a.clone());
        }
        return ret;
    }

    public Set<Aluno> alunosOrdemDescrescenteNumero(){
        Set<Aluno> ret = new TreeSet<>(new ComparatorOrdemDecrescenteNum());
        for (Aluno a : this.turma.values()){
            ret.add(a.clone());
        }
        return ret;
    }

}
