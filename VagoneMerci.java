public class VagoneMerci extends Vagone{
    private double caricoMax;
    private double caricoAttuale;
    /**
     * costruttore che imposta in automatico dei valori definiti
     * matricola="000000000000",lunghezza=400 cm,peso=120 tonnelate,caricoMax=40,caricoAttuale=10;
     */
    public VagoneMerci() {
        super();
        this.caricoMax= 40;
        this.caricoAttuale =10;
    }
    /**
     * coastruttore
     * @param matricola stringa
     * @param lunghezza cm
     * @param peso tonnelata
     * @param caricoMax in tonnelate
     * @param caricoAttuale in tonnelate
     */
    public VagoneMerci(String matricola, int lunghezza, double peso,double caricoMax,double caricoAttuale) {
        super(matricola, lunghezza, peso);
        this.caricoMax = caricoMax;
        this.caricoAttuale=caricoAttuale;
    }
    //getter and setter
    public double getCaricoMax() {
        return caricoMax;
    }
    public void setCaricoMax(double caricoMax) {
        this.caricoMax = caricoMax;
    }
    public double getCaricoAttuale() {
        return caricoAttuale;
    }
    /**
     * cambia il valore con quelli inseirto dall'utente se il valore è maggiore del peso massimo trasportabile imposta il valore  a -1 
     * @param caricoAttuale
     */
    public void setCaricoAttuale(double caricoAttuale) {
        if(caricoAttuale<caricoMax){
            this.caricoAttuale = caricoAttuale;
        } 
    }

    public double calcolaPeso(){
        double pesoTot=0;
        pesoTot+=caricoAttuale;
        pesoTot+=peso;
        return pesoTot;
    }
    //metodi
    @Override
    public String toString() {
        return super.toString() + ",caricoMax=" + caricoMax + ",caricoAttuale=" + caricoAttuale;
    }
    
    

    
}
