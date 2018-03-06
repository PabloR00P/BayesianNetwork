package bayesiannetwork;

public class Type {
    private Variable variable;
    private float numberValue;
    private String error;
    
    private Object whatever;

    public Type(String error) {
        this.error = error;
    }
    
 
    public Type(Variable variable) {
        this.variable = variable;
    }

    public Type(Variable variable, float value, Object whatever) {
        this.variable = variable;
        this.numberValue = value;
        this.whatever = whatever;
    }
    
    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Object getWhatever() {
        return whatever;
    }

    public float getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(float numberValue) {
        this.numberValue = numberValue;
    }    
}
