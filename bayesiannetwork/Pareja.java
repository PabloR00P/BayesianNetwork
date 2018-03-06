package bayesiannetwork;


public class Pareja {
    private boolean a1;
    private boolean a2;
    

    public Pareja(boolean a1, boolean a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    public boolean isA1() {
        return a1;
    }

    public void setA1(boolean a1) {
        this.a1 = a1;
    }

    public boolean isA2() {
        return a2;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pareja other = (Pareja) obj;
        if (this.a1 != other.a1) {
            return false;
        }
        if (this.a2 != other.a2) {
            return false;
        }
        return true;
    }
}
