import java.util.Objects;

public class HotelStandard extends Hotel{
    private boolean epocaAlta;

    public HotelStandard(){
        super();
        this.epocaAlta = false;
    }

    public HotelStandard(String cod, String nome, String loc, String cat, int nquartos, double preco, boolean ep){
        super(cod, nome, loc, cat, nquartos, preco);
        this.epocaAlta = ep;
    }

    public HotelStandard(HotelStandard h){
        super(h);
        this.epocaAlta = h.getEpocaAlta();
    }

    public boolean getEpocaAlta(){
        return this.epocaAlta;
    }

    public void setEpocaAlta(boolean ep){
        this.epocaAlta = ep;
    }

    public HotelStandard clone(){
        return new HotelStandard(this);
    }

    public double precoQuarto(){
        return super.getPreco() + (this.epocaAlta?20:0);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HotelStandard that = (HotelStandard) o;
        return epocaAlta == that.epocaAlta &&
               super.equals(that) ;
    }
}
