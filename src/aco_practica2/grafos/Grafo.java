package aco_practica2.grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private int nV;
    private List<Vertice>[] etapas;
    private int aristas;

    public List<Vertice>[] getEtapas() {
        return etapas;
    }

    public Grafo(int n) {
        nV = n;
        aristas = 0;
        etapas = new List[n];
        for (int i = 0; i < etapas.length; i++) {
            etapas[i] = new ArrayList<>();

        }
        

    }

    public void connect(Vertice origen, Vertice fin, int value) {
        if(!isConnected(origen,fin)){
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

    /*public void disconnect(int i, int j) {

        if (isConnected(i, j)) {
            if (i > j) {
                int temp = i;
                i = j;
                j = temp;
            }
            Arista aux = vertices[i].getArista();
            Arista next = aux.getNext();
            if (aux.getInicio() == i && aux.getFin() == j) {
                vertices[i].setArista(next);
                aristas--;
                return;
            }
            while (aux.hasNext()) {
                if (next.getInicio() == i && next.getFin() == j) {
                    aux.setNext(next.getNext());
                    aristas--;
                    return;
                }
                aux = next;
                next = next.getNext();
            }

        }
    }

    public int getAristas() {
        return aristas;
    }*/
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

    /*public int getnV() {
        return nV;
    }

    public Arista[] aristas() {
        //List<Arista> list = new ArrayList<>();
        Arista[] result = new Arista[aristas];
        int j = 0;
        for (int i = 0; i < vertices.length; i++) {
            Arista aux = vertices[i].getArista();
            if (aux != null) {
                //list.add(aux);
                result[j] = aux;
                j++;
                while (aux.hasNext()) {
                    aux = aux.getNext();
                    //list.add(aux);
                    result[j] = aux;
                    j++;
                }
            }

        }
        return result;//list.toArray(new Arista[0]);
    }*/
    public void añadirVertice(Vertice v) {
        if (!etapas[v.getEtapa()].contains(v)) {
            if(v.getEtapa()==0&&etapas[v.getEtapa()].size()==1){
                return;
            }
            if(v.getEtapa()==etapas.length-1&&etapas[v.getEtapa()].size()==1){
                return;
            }
            etapas[v.getEtapa()].add(v);
        }
    }

}
