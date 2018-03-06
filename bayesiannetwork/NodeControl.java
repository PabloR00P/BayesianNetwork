package bayesiannetwork;

import java.util.ArrayList;

public class NodeControl {
    private ArrayList<Nodo> listaNodes;

    public NodeControl() {
        listaNodes = new ArrayList();
    }

    public ArrayList<Nodo> getListaNodes() {
        return listaNodes;
    }

    public void setListaNodes(ArrayList<Nodo> listaNodes) {
        this.listaNodes = listaNodes;
    }
    
    
    
}
