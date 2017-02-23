package aco_practica2;

import aco_practica2.grafos.Arista;
import aco_practica2.grafos.Grafo;
import aco_practica2.grafos.Vertice;
import java.util.ArrayList;
import java.util.List;

public class Prueba {

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
                        vertices.add(arista.getFin());
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

}
