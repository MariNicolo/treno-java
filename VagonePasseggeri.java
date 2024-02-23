public class VagonePasseggeri extends Vagone{
    private int passeggieriMax;
    private int passeggeriAttuali;
    /**
     * costruttore che imposta in automatico dei valori definiti
     * matricola="000000000000",lunghezza=400 cm,peso=120 tonnelate,passeggieriMax=60,passeggieriAttuali=20;
     */
    public VagonePasseggeri(){
        super();
        this.passeggieriMax = 60;
        this.passeggeriAttuali= 20;
    }
    /**
     * costruttore
     * @param matricola stringa
     * @param lunghezza cm
     * @param peso tonnelate
     * @param passeggieriMax capienza massima
     * @param passeggeriAttuali capacità attuale
     */
    public VagonePasseggeri(String matricola, int lunghezza, double peso, int passeggieriMax, int passeggeriAttuali) {
        super(matricola, lunghezza, peso);
        this.passeggieriMax = passeggieriMax;
        this.passeggeriAttuali = passeggeriAttuali;
    }
    //getter and setter
    public int getPasseggieriMax() {
        return passeggieriMax;
    }
    public void setPasseggieriMax(int passeggieriMax) {
        this.passeggieriMax = passeggieriMax;
    }
    public int getPasseggeriAttuali() {
        return passeggeriAttuali;
    }
    /**
     * cambia il valore con quelli inseirto dall'utente se il valore è maggiore del numero massimo di passeggieri imposta il valore  a -1 
     * @param passeggeriAttuali
     */
    public void setPasseggeriAttuali(int passeggeriAttuali) {
        if(passeggeriAttuali < passeggieriMax){
            this.passeggeriAttuali = passeggeriAttuali;
        }
        this.passeggeriAttuali = -1;
    }
    public double calcolaPeso(){
        double pesoTot=0;
        pesoTot+=(passeggeriAttuali * 70)/1000;
        pesoTot+=peso;
        return pesoTot;
    }
    //metodi
    @Override
    public String toString() {
        return super.toString()+",passeggieriMax=" + passeggieriMax + ", passeggeriAttuali=" + passeggeriAttuali;
    }
    
    
}
