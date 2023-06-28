package PolyMath;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar addRational(Rational s);
    Scalar addInteger(Integer s);
    Scalar mulRational(Rational s);
    Scalar mulInteger(Integer s);
    Scalar power(int exponent);
    int sign();
    Scalar neg();
}
