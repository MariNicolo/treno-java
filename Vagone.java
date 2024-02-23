public abstract class Vagone {
    protected String matricola;
    protected int lunghezza;
    protected double peso;
    /**
     * costruttore che imposta in automatico dei valori definiti
     * matricola="000000000000",lunghezza=400 cm,peso=120 tonnelate;
     */
    public Vagone(){
        this.matricola = "00000000000";
        this.lunghezza= 400;
        this.peso= 120;
    }
    /**
     * costruttore
     * @param matricola stringa
     * @param lunghezza in cm
     * @param peso in tonnelate
     */
    public Vagone(String matricola, int lunghezza, double peso) {
        this.matricola = matricola;
        this.lunghezza = lunghezza;
        this.peso = peso;
    }
    //getter and setter
    public String getMatricola() {
        return matricola;
    }
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }
    public int getLunghezza() {
            return lunghezza;
    }
    /**
     * controlla se la lunghezza è positiva e poi la cambia se no la setta -1
     * @param lunghezza
     */
    public void setLunghezza(int lunghezza) {
        if(lunghezza>0){
            this.lunghezza=lunghezza;
        }
        lunghezza=-1;
    }
    public double getPeso() {
            return peso;
    }
    /**
     * conrolla se il peso è positivo e poi lo cambia se no lo setta a -1
     * @param peso
     */
    public void setPeso(double peso) {
        if(peso>0){
            this.peso=peso;
        }
        peso=-1;
    }
     
    public abstract double calcolaPeso();
    //metodi
    @Override
    public String toString() {
        return  getClass().getSimpleName() +" matricola=" + matricola + ", lunghezza=" + lunghezza + ", peso=" + peso;
    }
    

    
    
}
