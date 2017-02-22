package aco_practica2;

import aco_practica2.grafos.Arista;
import aco_practica2.grafos.Grafo;
import aco_practica2.grafos.Vertice;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
      
        Grafo original = new Grafo(4);
        Vertice v0=new Vertice(0,0);
        Vertice v11=new Vertice(1,0);
        Vertice v12=new Vertice(1,1);
        Vertice v13=new Vertice(1,2);
        Vertice v21=new Vertice(2,0);
        Vertice v22=new Vertice(2,1);
        Vertice v23=new Vertice(2,2);
        Vertice v3=new Vertice(3,0);
        original.añadirVertice(v0);
        original.añadirVertice(v11);
        original.añadirVertice(v12);
        original.añadirVertice(v13);
        original.añadirVertice(v21);
        original.añadirVertice(v22);
        original.añadirVertice(v23);
        original.añadirVertice(v3);
        
        original.connect(v0, v11, 1);
        original.connect(v0, v12, 3);
        original.connect(v0, v13, 2);
        original.connect(v11, v21, 5);
        original.connect(v11, v23, 3);
        original.connect(v12, v21, 4);
        original.connect(v12, v22, 3);
        original.connect(v13, v22, 2);
        original.connect(v13, v23, 7);
        original.connect(v21, v3, 4);
        original.connect(v22, v3, 1);
        original.connect(v23, v3, 1);
        
        
        List<Vertice>[] a = original.getEtapas();
        for (int i = 0; i < a.length; i++) {
            System.out.println("Etapa " + i);
            for (Vertice v : a[i]) {
                System.out.println(v.getEtapa() + " " + v.getNum());
            }
        }
        System.out.println("---------------------------------");
        List<Vertice> result = new ArrayList<>();
        int peso= Ruta.ruta(original,result);
        System.out.println("Peso: " + peso);
        for (Vertice vertice : result) {
            System.out.println(vertice.getEtapa() + " " + vertice.getNum());
        }
        
        
        
    }
    
    
    
}
