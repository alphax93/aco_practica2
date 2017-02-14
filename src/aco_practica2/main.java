package aco_practica2;

import aco_practica2.grafos.Grafo;
import aco_practica2.grafos.Vertice;

public class main {

    public static void main(String[] args) {
      
        Grafo original = new Grafo(4);
        crear(original.getVertices());
        generaOriginal(original);
        for (Vertice arg : original.getVertices()) {
            System.out.println(arg.getEtapa() + " " + arg.getNum());
        }
    }
    
    
    
    private static void crear(Vertice[] vertices){
        
        vertices[0]=new Vertice(0,0);
        vertices[1]=new Vertice(1,1);
        vertices[2]=new Vertice(1,2);      
        vertices[vertices.length-1]=new Vertice(2,0);
    }
    private static void generaOriginal(Grafo original){
            original.connect(0, 1, 1);
            original.connect(1, 2, 2);
            original.connect(3, 4, 4);
            original.connect(4, 5, 8);
            original.connect(2, 6, 4);
            original.connect(0, 3, 4);
            original.connect(1, 4, 4);
            original.connect(4, 6, 7);
            original.connect(2, 5, 6);
            original.connect(0, 4, 6);
            original.connect(2, 4, 4);
            original.connect(3, 6, 4);
            original.connect(5, 6, 3);
   }
}
