package PolyMath;

public class Monomial {
    private final int exponent;
    private final Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        if(coefficient.sign() == 0)
        {
            exponent = 0;
            coefficient = new Integer(0);
        }
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial(Monomial m) {
        this.exponent = m.exponent;
        this.coefficient = m.coefficient;
    }

    public Monomial add(Monomial m) {
        if (this.exponent != m.exponent) {
            return null;
        }
        return new Monomial(this.exponent, this.coefficient.add(m.coefficient));
    }

    public Monomial mul(Monomial m) {
        return new Monomial(this.exponent + m.exponent, this.coefficient.mul(m.coefficient));
    }

    public Scalar evaluate(Scalar s) {
        return s.power(this.exponent).mul(this.coefficient);
    }

    public Monomial derivative() {
        if(this.exponent == 0)
            return new Monomial(0, new Integer(0));
        int newExponent = this.exponent - 1;
        Scalar newCoefficient = this.coefficient.mulInteger(new Integer(this.exponent));
        return new Monomial(newExponent, newCoefficient);
    }

    public int sign() {
        return coefficient.sign();
    }

    private boolean isOne(String coefficient)
    {
        return coefficient.charAt(0) == '1' && coefficient.length() == 1;
    }
    public int getExponent() {
        return exponent;
    }

    @Override
    public String toString() {
        if(this.exponent == 0)
            return this.coefficient.toString();
        String coefficient = this.coefficient.toString();
        if(isOne(coefficient))
            coefficient = "";
        if(this.exponent==1)
            return coefficient+"x";
        return coefficient + "x^" + this.exponent;
    }
}
