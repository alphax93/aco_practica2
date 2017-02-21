package aco_practica2;

import aco_practica2.grafos.Arista;
import aco_practica2.grafos.Grafo;
import aco_practica2.grafos.Vertice;
import java.util.ArrayList;
import java.util.List;

public class Ruta {
    
    public static List<Vertice> ruta(Grafo g){
        List<Vertice> result = new ArrayList<>();
                       
        int total = 0;
        int etapaAct=0;
        int max=(int)Double.POSITIVE_INFINITY;
        
        Vertice verticeAct = g.getEtapas()[etapaAct].get(0);
        result.add(verticeAct);
        result = aux(total,verticeAct,g,result,max);
        
        
        return result;
    }
    
    private static List<Vertice> aux(int total, Vertice verticeAct, Grafo g, List<Vertice> result, int max){
    
        if(verticeAct.getEtapa()==g.getEtapas().length-1){
            max=total;
            return result;
        }
        if(result.size()==g.getEtapas().length) return result;
        
        List<Arista> aristas = verticeAct.getEveryArista();
        Arista min =aristas.get(0);
        System.out.println(max);
        for (Arista arista : aristas) {
            if(total+arista.getPeso()<max){
                result = aux(total+arista.getPeso(), arista.getFin(),g,result,max);
            }
        }
        
        
        
        
        
        return result ;
    }
    
}
