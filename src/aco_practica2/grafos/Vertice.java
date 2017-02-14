
package aco_practica2.grafos;


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

    
    
    

    public void setArista(Arista arista) {
        this.arista = arista;
    }
    
    
}
