import java.util.Objects;

public class HotelDiscount extends Hotel{
    private double ocupacao;

    public HotelDiscount(){
        super();
        this.ocupacao = 0;
    }

    public HotelDiscount(String cod, String nome, String loc, String cat, int nquartos, double preco, double ocupacao){
        super(cod, nome, loc, cat, nquartos, preco);
        this.ocupacao = ocupacao;
    }

    public HotelDiscount(HotelDiscount h){
        super(h);
        this.ocupacao = h.getOcupacao();
    }

    public double getOcupacao(){
        return this.ocupacao;
    }

    public void setOcupacao(double ocupacao){
        this.ocupacao = ocupacao;
    }

    public double precoQuarto(){
        return getPreco() * 0.75 + getPreco() * 0.25 * ocupacao;
    }

    public HotelDiscount clone(){
        return new HotelDiscount(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HotelDiscount that = (HotelDiscount) o;
        return super.equals(that) && this.ocupacao == that.getOcupacao();
    }
}
