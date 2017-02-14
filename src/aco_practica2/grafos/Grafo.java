package aco_practica2.grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    
    private int nV;
    private Vertice[] vertices;
    private int aristas;

    public Vertice[] getVertices() {
        return vertices;
    }
    
    
    public Grafo(int n){
        nV = n;
        aristas=0;
        vertices = new Vertice[n];
        
       
    }


    
    public void connect(int ei, int i, int ej, int j, int value){
        
        /*if(!isConnected(i,j)){
            if(i>j){
                int temp = i;
                i = j;
                j = temp;
            }
            Arista aux = vertices[i].getArista();
            if(aux==null){
                vertices[i].setArista(new Arista(value,vertices[i],vertices[j]));
            } else {
                
                vertices[i].setArista(new Arista(value,vertices[i],vertices[j]));
                vertices[i].getArista().setNext(aux);

            }
            aristas++;
        }*/
        
        
    }
    
    public void disconnect(int i, int j){
        
        if(isConnected(i,j)){
            if(i>j){
                int temp = i;
                i = j;
                j = temp;
            }
            Arista aux= vertices[i].getArista();
            Arista next = aux.getNext();
            if(aux.getInicio()==i&&aux.getFin()==j){
                vertices[i].setArista(next);
                aristas--;
                return;
            }
            while(aux.hasNext()){
                if(next.getInicio()==i&&next.getFin()==j){
                    aux.setNext(next.getNext());
                    aristas--;
                    return;
                }
                aux=next;
                next=next.getNext();
            }
            
        }        
    }

    public int getAristas() {
        return aristas;
    }

    public boolean isConnected(int i, int j){
        if(i>j){
            int temp = i;
            i = j;
            j = temp;
        }
        
        Arista aux = vertices[i].getArista();
        if(aux==null) return false;
        while(aux.hasNext()){
            
            if(aux.getInicio()==i&&aux.getFin()==j){
                return true;
                
            }
            aux=aux.getNext();
        }
        if(aux.getNext()==null){
            if(aux.getInicio()==i&&aux.getFin()==j){
                return true;
                
            }
            return false;
        }
        return false;
    }
    
    public int getnV() {
        return nV;
    }

    public Arista[] aristas() {
        //List<Arista> list = new ArrayList<>();
        Arista[] result = new Arista[aristas];
        int j = 0;
        for (int i = 0; i < vertices.length; i++) {
            Arista aux = vertices[i].getArista();
            if(aux!=null){
                //list.add(aux);
                result[j]=aux;
                j++;
                while(aux.hasNext()){
                    aux=aux.getNext();
                    //list.add(aux);
                    result[j]=aux;
                    j++;
                }
            }
            
        }
        return result;//list.toArray(new Arista[0]);
    }
    
    
    
}
