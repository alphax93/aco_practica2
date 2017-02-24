package aco_practica2;

import aco_practica2.grafos.Arista;
import aco_practica2.grafos.Grafo;
import aco_practica2.grafos.Vertice;
import java.util.ArrayList;
import java.util.List;

public class Prueba {

    //Comprueba que todos los nodos puedan ser alcanzado desde una etapa anterior
    public static boolean nodoInaccesible(Grafo g) {

        List<Vertice> vertices = new ArrayList<>();
        vertices.add(g.getEtapas()[0].get(0));
        List<Vertice> visitados = new ArrayList<>();
        while (visitados.size() < g.getnV() && vertices.size() > 0) {

            Vertice temp = vertices.get(0);

            if (!visitados.contains(temp)) {

                visitados.add(temp);
                if (temp.getArista() != null) {
                    List<Arista> aux = temp.getEveryArista();
                    for (Arista arista : aux) {
                        if (arista.getFin().getEtapa() == arista.getInicio().getEtapa() + 1) {
                            vertices.add(arista.getFin());
                        }
                    }

                }

            }
            vertices.remove(0);
        }
        if (visitados.size() == g.getnV()) {
            return true;
        }
        return false;
    }

    //Comprueba que todos los nodos puedan avanzar a la siguiente etapa
    public static boolean etapaSiguiente(Grafo g) {

        List<Vertice>[] lista = g.getEtapas();
        boolean result = false;
        for (int i = 0; i < lista.length - 1; i++) {
            for (Vertice vertice : lista[i]) {
                List<Arista> aristas = vertice.getEveryArista();
                if (aristas.size() == 0) {
                    return false;
                }
                result = false;
                for (Arista arista : aristas) {
                    if (arista.getFin().getEtapa() == arista.getInicio().getEtapa() + 1) {
                        result = true;
                        break;
                    }
                }
                if (result == false) {
                    return result;
                }
            }

        }

        return result;
    }
    
    
    public static boolean respuesta(List<Vertice> vertices, int nE){
        
        if(vertices.size()!=nE) {
            System.out.println("Cantidad de vértices de la respuesta incorrecta");
            return false;
        }
        for (int i = 0; i < vertices.size()-1; i++) {
            if(vertices.get(i).getEtapa()+1!=vertices.get(i+1).getEtapa()){
                return false;
            }
        }
        return true;
    }

}
