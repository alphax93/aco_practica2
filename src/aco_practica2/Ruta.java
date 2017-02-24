package aco_practica2;

import aco_practica2.grafos.Arista;
import aco_practica2.grafos.Grafo;
import aco_practica2.grafos.Vertice;
import java.util.ArrayList;
import java.util.List;

public class Ruta {

    public static int ruta(Grafo g, List<Vertice> result) {
        List<Vertice> temp = new ArrayList<>();
        int total = 0;
        int etapaAct = 0;
        int max = (int) Double.POSITIVE_INFINITY;

        Vertice verticeAct = g.getEtapas()[etapaAct].get(0);
        temp.add(verticeAct);
        Vertice fin = g.getEtapas()[g.getEtapas().length - 1].get(0);
        int pesoFin = aux(total, max, verticeAct, result, temp, fin);

        return pesoFin;
    }

    private static int aux(int total, int max, Vertice verticeAct, List<Vertice> result, List<Vertice> temp, Vertice fin) {

        if (verticeAct.getEtapa() == fin.getEtapa()) {
            result.clear();
            result.addAll(temp);
            return total;
        }

        if (verticeAct.getArista() != null) {
            List<Arista> aristas = verticeAct.getEveryArista();
            ordena(aristas, 0, aristas.size() - 1);
            for (Arista arista : aristas) {
                if (arista.getFin().getEtapa() == arista.getInicio().getEtapa() + 1) {
                    int suma = arista.getPeso() + total;
                    if (suma < max) {
                        temp.add(arista.getFin());
                        max = aux(suma, max, arista.getFin(), result, temp, fin);
                        temp.remove(arista.getFin());
                    }
                }
            }
        }

        return max;
    }

    public static void ordena(List<Arista> aristas, int linf, int lsup) {
        if (linf < lsup - 1) {

            int[] p = division(aristas, linf, lsup);

            ordena(aristas, linf, p[1]);
            ordena(aristas, p[0], lsup);
        } else if (lsup - linf == 1) {
            if (aristas.get(lsup).getPeso() < aristas.get(linf).getPeso()) {
                Arista aux = aristas.get(lsup);
                aristas.set(lsup, aristas.get(linf));
                aristas.set(linf, aux);
            }
        }

    }

    public static int[] division(List<Arista> aristas, int linf, int lsup) {

        int[] p = new int[2];
        p[0] = linf;
        p[1] = lsup;
        int piv = linf + (int) (Math.random() * (lsup - linf));
        while (p[0] <= p[1]) {
            while (p[0] <= lsup && aristas.get(p[0]).getPeso() <= aristas.get(piv).getPeso()) {
                p[0]++;
            }
            while (p[1] >= linf && aristas.get(p[1]).getPeso() >= aristas.get(piv).getPeso()) {
                p[1]--;
            }
            if (p[0] < p[1]) {
                Arista aux = aristas.get(p[0]);
                aristas.set(p[0], aristas.get(p[1]));
                aristas.set(p[1], aux);
                p[0]++;
                p[1]--;
            }

        }
        if (p[0] < piv) {
            Arista aux = aristas.get(p[0]);
            aristas.set(p[0], aristas.get(piv));
            aristas.set(piv, aux);
            p[0]++;
        } else if (p[1] > piv) {
            Arista aux = aristas.get(p[1]);
            aristas.set(p[1], aristas.get(piv));
            aristas.set(piv, aux);
            p[1]--;
        }

        return p;
    }
}
