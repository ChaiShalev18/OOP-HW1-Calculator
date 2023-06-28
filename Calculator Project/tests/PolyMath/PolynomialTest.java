package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    Polynomial p1;
    Polynomial p2;
    Polynomial p3;
    Polynomial p4;
    Monomial m;
    Polynomial polynomialRes;
    @BeforeEach
    void setUp() {
        p1 = Polynomial.build("1/2 1");
        p2 = Polynomial.build("1 0 -1 0 1/4");
        p3 = Polynomial.build("5 0 -2");
        p4 = Polynomial.build("5");
        m = new Monomial(2, new Integer(2));

    }

    @Test
    void build() {
        try {
            polynomialRes = Polynomial.build("1 2 3");
            assertEquals("1 + 2x + 3x^2",polynomialRes.toString());
            polynomialRes=Polynomial.build("0 1 2 3");
            assertEquals("x + 2x^2 + 3x^3",polynomialRes.toString());
            polynomialRes=Polynomial.build("0 0 0 0 7");
            assertEquals("7x^4",polynomialRes.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void add() {
        try {
            polynomialRes = p1.add(p1);
            assertEquals("1 + 2x", polynomialRes.toString());
            polynomialRes = p1.add(m);
            assertEquals("1/2 + x + 2x^2", polynomialRes.toString());
            polynomialRes = p1.add(p2);
            assertEquals("3/2 + x - 1x^2 + 1/4x^4", polynomialRes.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    void mul() {
        try {
            polynomialRes = p1.mul(p1);
            assertEquals("1/4 + x + x^2", polynomialRes.toString());
            polynomialRes = p1.mul(m);
            assertEquals("x^2 + 2x^3", polynomialRes.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void evaluate() {
        try {
            Scalar result = p1.evaluate(new Integer(1));
            assertEquals("3/2", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void derivative() {
        try {
            polynomialRes = p1.derivative();
            assertEquals("1", polynomialRes.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testToString() {
        try {
            assertEquals("1/2 + x",p1.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}