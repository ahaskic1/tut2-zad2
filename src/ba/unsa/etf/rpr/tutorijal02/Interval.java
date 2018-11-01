package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna,krajnja;
    private boolean ukljucena_prva,ukljucena_druga;
    public Interval(double pocetna,double krajnja,boolean ukljucena_prva,boolean ukljucena_druga){
        if(pocetna > krajnja)   throw new IllegalArgumentException("Pocetna tacka veca od krajnje.");
        this.pocetna=pocetna;
        this.krajnja=krajnja;
        this.ukljucena_prva=ukljucena_prva;
        this.ukljucena_druga=ukljucena_druga;
    }
    public Interval(){
        this.pocetna=0;
        this.krajnja=0;
        this.ukljucena_prva=false;
        this.ukljucena_druga=false;
    }
    public String dajZnakZaPrvu(){
        if(ukljucena_prva == true)  return "[";
        else return "(";
    }
    public String dajZnakZaDrugu(){
        if(ukljucena_druga == true) return "]";
        else return ")";
    }
    public boolean isNull(){
        if(this.pocetna == 0 && this.krajnja == 0)
            return true;
        return false;
    }
    public boolean isIn(double tacka){
        if(this.pocetna <= tacka && this.krajnja >= tacka)
            return true;
        return false;
    }
    public Interval interrsect(Interval i1){
        Interval vrati = new Interval();
        if(this.pocetna >= i1.pocetna && this.pocetna <= i1.krajnja) {
            vrati.pocetna = this.pocetna;
            vrati.ukljucena_prva = this.ukljucena_prva;
        }
        else if(i1.pocetna >= this.pocetna && i1.pocetna <= this.krajnja) {
            vrati.pocetna = i1.pocetna;
            vrati.ukljucena_prva = i1.ukljucena_prva;
        }
        if(i1.krajnja >= this.pocetna && i1.krajnja <=this.krajnja) {
            vrati.krajnja = i1.krajnja;
            vrati.ukljucena_druga = i1.ukljucena_druga;
        }
        else if(this.krajnja >= i1.pocetna && this.krajnja <=i1.krajnja) {
            vrati.krajnja = this.krajnja;
            vrati.ukljucena_druga = this.ukljucena_druga;
        }
        return vrati;
    }
    static public Interval intersect(Interval i1,Interval i2){
        Interval vrati = new Interval();
        if(i2.pocetna >= i1.pocetna && i2.pocetna <= i1.krajnja) {
            vrati.pocetna = i2.pocetna;
            vrati.ukljucena_prva = i2.ukljucena_prva;
        }
        else if(i1.pocetna >= i2.pocetna && i1.pocetna <= i2.krajnja) {
            vrati.pocetna = i1.pocetna;
            vrati.ukljucena_prva = i1.ukljucena_prva;
        }
        if(i1.krajnja >= i2.pocetna && i1.krajnja <=i2.krajnja) {
            vrati.krajnja = i1.krajnja;
            vrati.ukljucena_druga = i1.ukljucena_druga;
        }
        else if(i2.krajnja >= i1.pocetna && i2.krajnja <=i1.krajnja) {
            vrati.krajnja = i2.krajnja;
            vrati.ukljucena_druga = i2.ukljucena_druga;
        }
        return vrati;
    }
    public String toString(){
        String s = new String();
        s=s+dajZnakZaPrvu()+this.pocetna+","+this.krajnja+dajZnakZaDrugu();
        return s;
    }
}
