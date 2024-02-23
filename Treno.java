import java.util.ArrayList;

public class Treno {
    ArrayList<Vagone> listaVagoni = new ArrayList<>();
    /**costruttore */
    public Treno(){}
    //getter and setter
    public ArrayList<Vagone> getLIstaVagoni(){
        return listaVagoni;
    }
    public void addVagoneMerci(VagoneMerci v){
        listaVagoni.add(v);
    }
    public void addVagonePasseggieri(VagonePasseggeri v){
        listaVagoni.add(v);
    }
    //metodi
    /**
     * rimozione del vagone con una determinata matricola
     * @param matricola
     * @return 0 se è andata a buon fine la rimozione altrimenti -1
     */
    public int rimuoviVagone(String matricola){
        int stato=-1;
        Vagone vd = null;
        for(Vagone v : listaVagoni){
            if(v.getMatricola().equals(matricola)){
                vd=v;
                break;
            }
        }
        if(vd!=null){
            listaVagoni.remove(vd);
            stato=0;
        }
        return stato;
    }
    /**
     * cerca il vagone con una determinata matricola
     * @param matricola
     * @return
     */
    public Vagone cercaVagone(String matricola){
        Vagone vd = null;
        for(Vagone v : listaVagoni){
            if(v.getMatricola().equals(matricola)){
                vd=v;
                break;
            }
        }
        return vd;
    }
    /**
     * caqlcolcolo della lunghezza totale
     * @return
     */
    public int calcolaLunghezza(){
        int lunghezzaTot=0;
        for(Vagone v : listaVagoni){
            lunghezzaTot+=v.getLunghezza();
        }
        return lunghezzaTot;
    }
    /**
     * 
     * @return
     */
    public double calcolaPesoTreno(){
        double pesoTot=0;
        for(Vagone v : listaVagoni){
            pesoTot+=v.calcolaPeso();
        }
        return pesoTot;
    }

    public StringBuilder stampaTreno() {
        StringBuilder s= new StringBuilder();
        for(Vagone v:listaVagoni){
            s.append(v.toString());
            s.append(" ");
        }
        return s;
    }
    
}
