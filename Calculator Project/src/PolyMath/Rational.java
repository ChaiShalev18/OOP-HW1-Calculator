package PolyMath;

public class Rational implements Scalar{
    private int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            //return null;
            throw new IllegalArgumentException("The denominator cannot be 0!");

        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Rational reduce() {
        int sign = sign();
        int gcd = gcd(this.numerator, this.denominator);
        int reduceNumerator = Math.abs(this.numerator / gcd);
        int reduceDenominator = Math.abs(this.denominator / gcd);
        return new Rational(sign * reduceNumerator, reduceDenominator);
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addRational(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        int addNumerator = s.numerator * this.denominator + s.denominator * this.numerator;
        int addDenominator = s.denominator * this.denominator;
        return new Rational(addNumerator, addDenominator).reduce();
    }

    @Override
    public Scalar addInteger(Integer s) {
        return addRational(new Rational(s.getNumber(), 1));
    }

    @Override
    public Scalar mulRational(Rational s) {
        int mulNumerator = s.numerator * this.numerator;
        int mulDenominator = s.denominator * this.denominator;
        return new Rational(mulNumerator, mulDenominator).reduce();
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return mulRational(new Rational(s.getNumber(), 1));
    }

    @Override
    public Scalar power(int exponent) {
        int PowerNumerator = (int) Math.pow(this.numerator, exponent);
        int PowerDenominator = (int) Math.pow(this.denominator, exponent);
        Rational ret=new Rational(PowerNumerator, PowerDenominator).reduce();
        if (ret.denominator==1) {
            return new Integer(ret.numerator);
        }
        return ret;
    }

    @Override
    public int sign() {
        return (int) (Math.signum(this.numerator) * Math.signum(this.denominator));
    }

    @Override
    public Scalar neg() {
        Rational rationalReduced = this.reduce();
        rationalReduced.numerator *= -1;
        return rationalReduced;
    }

    @Override
    public String toString() {
        Rational rationalReduced = this.reduce();
        if (rationalReduced.denominator==1) {
            return (String.valueOf(rationalReduced.numerator));
        }
        return rationalReduced.numerator + "/" + rationalReduced.denominator;
    }
}
