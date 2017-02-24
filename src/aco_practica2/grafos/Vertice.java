
package aco_practica2.grafos;

import java.util.ArrayList;
import java.util.List;


public class Vertice {
    
    private int num;
    private int etapa;
    private Arista arista;
    
    public Vertice(int etapa,int num) {
        this.etapa=etapa;
        this.num = num;
        arista=null;
    }

    public Arista getArista() {
        return arista;
    }

    public int getNum() {
        return num;
    }

    public int getEtapa() {
        return etapa;
    }

    public List<Arista> getEveryArista(){
        List<Arista> result = new ArrayList<>();
        Arista aux = arista;
        if(aux==null) return result;
        result.add(aux);
        while(aux.hasNext()){
            aux=aux.getNext();
            result.add(aux);
        }
        return result;
    }
    
    

    public void setArista(Arista arista) {
        this.arista = arista;
    }
    
    public boolean igualA(Vertice v){
        if(this.etapa==v.etapa && this.num==v.num) {
            return true;
        }
        return false;
    }
    
}
