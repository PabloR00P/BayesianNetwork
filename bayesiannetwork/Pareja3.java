package bayesiannetwork;

public class Pareja3 {
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;

    public Pareja3(boolean a1, boolean a2, boolean a3, boolean a4) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
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

    public boolean isA3() {
        return a3;
    }

    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    public boolean isA4() {
        return a4;
    }

    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Pareja3 other = (Pareja3) obj;
        if (this.a1 != other.a1) {
            return false;
        }
        if (this.a2 != other.a2) {
            return false;
        }
        if (this.a3 != other.a3) {
            return false;
        }
        if (this.a4 != other.a4) {
            return false;
        }
        return true;
    }
    
    
    
}
