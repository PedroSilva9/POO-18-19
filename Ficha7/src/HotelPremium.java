import java.util.Objects;

public class HotelPremium extends Hotel{
    private double taxa;

    public HotelPremium(){
        super();
        this.taxa = 1;
    }

    public HotelPremium(String cod, String nome, String loc, String cat, int nquartos, double preco, double taxa){
        super(cod, nome, loc, cat, nquartos, preco);
        this.taxa = taxa;
    }

    public HotelPremium(HotelPremium h){
        super(h);
        this.taxa = h.getTaxa();
    }

    public double getTaxa(){
        return this.taxa;
    }

    public void setTaxa(double taxa){
        this.taxa = taxa;
    }

    public HotelPremium clone(){
        return new HotelPremium(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HotelPremium that = (HotelPremium) o;
        return super.equals(that) && that.getTaxa() == this.taxa;
    }
}
