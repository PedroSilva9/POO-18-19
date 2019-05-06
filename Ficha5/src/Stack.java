import java.util.*;

public class Stack {
    private List<String> st;

    public Stack(){
        this.st = new ArrayList<String>();
    }

    public Stack(List<String> arr){
        this.st = new ArrayList<String>();
        for(String s: arr){
            this.st.add(s);
        }
    }

    public Stack(Stack s){
        setSt(s.getSt());
    }

    public List<String> getSt() {
        ArrayList<String> newArr = new ArrayList<>();
        for(String s: this.st){
            newArr.add(s);
        }
        return newArr;
    }

    public void setSt(List<String> st){
        for(String s : st){
            this.st.add(s);
        }
    }

    public String top(){
        return this.st.get(this.st.size() - 1);
    }

    public void push(String s){
        this.st.add(s);
    }

    public void pop(){
        this.st.remove(this.st.size() - 1);
    }

    public boolean empty(){
        return this.st.isEmpty();
    }
}
