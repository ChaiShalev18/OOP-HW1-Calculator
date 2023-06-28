package PolyMath;

public class Integer implements Scalar {
    private final int number;

    public Integer(int number) {
        this.number = number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar addInteger(Integer s) {
        return new Integer(this.number + s.number);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Integer(this.number * s.number);
    }

    @Override
    public Scalar power(int exponent) {
        return new Integer((int) Math.pow(this.number, exponent));
    }


    @Override
    public int sign() {
        return (int) Math.signum(number);
    }

    @Override
    public Scalar neg() {
        return new Integer(this.number * -1);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
