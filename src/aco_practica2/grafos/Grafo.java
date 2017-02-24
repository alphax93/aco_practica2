package aco_practica2.grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private int nE;
    private List<Vertice>[] etapas;

    private int nV;

    public List<Vertice>[] getEtapas() {
        return etapas;
    }

    public int getnE() {
        return nE;
    }
    
    

    public Grafo(int n) {
        nE = n;
  
        nV = 0;
        etapas = new List[n];
        for (int i = 0; i < etapas.length; i++) {
            etapas[i] = new ArrayList<>();

        }

    }

    public void connect(Vertice origen, Vertice fin, int value) {
        if (!isConnected(origen, fin)) {
            if (origen.getEtapa() > fin.getEtapa()) {
                Vertice temp = origen;
                origen = fin;
                fin = temp;
            }

            Arista aux = origen.getArista();
            if (aux == null) {
                origen.setArista(new Arista(value, origen, fin));
            } else {
                origen.setArista(new Arista(value, origen, fin));
                origen.getArista().setNext(aux);
            }
        }
    }

    public void disconnect(Vertice origen, Vertice fin) {

        if (isConnected(origen, fin)) {
            if (origen.getEtapa() > fin.getEtapa()) {
                Vertice temp = origen;
                origen = fin;
                fin = temp;
            }
            Arista aux = origen.getArista();
            if (aux.getInicio().igualA(origen) && aux.getFin().igualA(fin)) {
                origen.setArista(aux.getNext());
            }
            while (aux.hasNext()) {
                Arista next = aux.getNext();
                if (next.getInicio().igualA(origen) && next.getFin().igualA(fin)) {
                    aux.setNext(next.getNext());
                }
                aux = next;
            }
        }

    }


    public boolean isConnected(Vertice origen, Vertice fin) {

        if (origen.getEtapa() > fin.getEtapa()) {
            Vertice temp = origen;
            origen = fin;
            fin = temp;
        }
        Arista aux = origen.getArista();
        if (aux == null) {
            return false;
        }
        while (aux.hasNext()) {
            if (aux.getInicio() == origen && aux.getFin() == fin) {
                return true;

            }
            aux = aux.getNext();
        }
        if (aux.getNext() == null) {
            if (aux.getInicio() == origen && aux.getFin() == fin) {
                return true;

            }
            return false;
        }
        return false;

    }

    public void añadirVertice(Vertice v) {
        if (!etapas[v.getEtapa()].contains(v)) {
            if (v.getEtapa() == 0 && etapas[v.getEtapa()].size() == 1) {
                return;
            }
            if (v.getEtapa() == etapas.length - 1 && etapas[v.getEtapa()].size() == 1) {
                return;
            }
            etapas[v.getEtapa()].add(v);
            nV++;
        }
    }

    public int getnV() {
        return nV;
    }

}
