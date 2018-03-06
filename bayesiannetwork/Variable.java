package bayesiannetwork;

import java.util.Objects;

public class Variable {
    private String name;
    private boolean invalid;

    public Variable(String name, boolean invalid) {
        this.name = name;
        this.invalid = invalid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNegada() {
        return invalid;
    }

    public void setNegada(boolean invalid) {
        this.invalid = invalid;
    }
    
    public boolean equals(Object object2) {
        return object2 instanceof Variable && name.equals(((Variable)object2).name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + (this.invalid ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
