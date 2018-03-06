package bayesiannetwork;

import java.util.ArrayList;

public class Nodo {
    
    private Variable queryVariable;
    private ArrayList<Variable> evidenceVariables;
    private float value;

    public Nodo(Variable queryVariable, ArrayList<Variable> evidenceVariables, float value) {
        this.queryVariable = queryVariable;
        this.evidenceVariables = evidenceVariables;
        this.value = value;
    }

    public Nodo(Variable queryVariable, float value) {
        this.queryVariable = queryVariable;
        this.value = value;
    }

    public Variable getQueryVariable() {
        return queryVariable;
    }

    public void setQueryVariable(Variable queryVariable) {
        this.queryVariable = queryVariable;
    }

    public ArrayList<Variable> getEvidenceVariables() {
        return evidenceVariables;
    }

    public void setEvidenceVariables(ArrayList<Variable> evidenceVariables) {
        this.evidenceVariables = evidenceVariables;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if(evidenceVariables!=null){
            return "P( " + queryVariable + " | "  + evidenceVariables+ " ) ";
        }
        else{
            return "P( " + queryVariable +")";
        }
        
    }
    
    public String otherToString(boolean neg){
        if(neg){
             if(evidenceVariables!=null){
                return "P( ! " + queryVariable + " | "  + evidenceVariables+ " ) = " + String.format("%.2f", Math.abs(1-value));
            }
            else{
                return "P( ! " + queryVariable +") = " + String.format("%.2f", Math.abs(1-value));
            }
        }
        else{
             if(evidenceVariables!=null){
                return "P( " + queryVariable + " | "  + evidenceVariables+ " ) = " + value;
            }
            else{
                return "P( " + queryVariable +") = " + value;
            }
        }
       
    } 
}
