import java.util.Objects;

public class Circulo {

    private double x;
    private double y;
    private double raio;

    public Circulo(){
        this.x = 0.0;
        this.y = 0.0;
        this.raio = 0.0;
    }

    public Circulo(double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo c){
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public Circulo clone(){
        return new Circulo(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return circulo.getX() == this.x &&
               circulo.getY() == this.y &&
               circulo.getRaio() == this.raio;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("x = " + this.x + "\n");
        sb.append("y = " + this.y + "\n");
        sb.append("raio = " + this.raio + "\n");

        return sb.toString();
    }

    public void alteraCentro(double x, double y){
        this.setX(x);
        this.setY(y);
    }

    public double calculaArea(){
        return (Math.PI * Math.pow(this.raio,2));
    }

    public double calculaPerimetro(){
        return (Math.PI * 2 * this.raio);
    }
}
