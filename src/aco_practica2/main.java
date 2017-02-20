package aco_practica2;

import aco_practica2.grafos.Grafo;
import aco_practica2.grafos.Vertice;
import java.util.List;

public class main {

    public static void main(String[] args) {
      
        Grafo original = new Grafo(2);
        Vertice v1=new Vertice(0,0);
        Vertice v2=new Vertice(1,0);
        original.añadirVertice(v1);
        original.añadirVertice(v2);
        
        
        
        List<Vertice>[] a = original.getEtapas();
        for (int i = 0; i < a.length; i++) {
            System.out.println("Etapa " + i);
            for (Vertice v : a[i]) {
                System.out.println(v.getEtapa() + " " + v.getNum());
            }
            
        }
        System.out.println("-------------------------------");
        original.connect(v1, v2, 8);
        if(original.isConnected(v1,v2)){
            System.out.println("Correcto");
        }
    }
    
    
    
}
