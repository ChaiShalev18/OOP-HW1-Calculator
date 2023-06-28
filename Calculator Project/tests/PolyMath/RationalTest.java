package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {
    Rational rationalA;
    Rational rationalB;
    Rational rationalMinusA;
    Rational rationalZero;
    Integer integerA;
    Scalar result;

    @BeforeEach
    void setUp() {
        rationalA = new Rational(1,2);
        rationalB = new Rational(1,4);
        rationalMinusA = new Rational(-1,2);
        integerA = new Integer(2);
        rationalZero = new Rational(0,1);
    }

    @Test
    void reduce() {
        try {
            result = new Rational(2,4).reduce();
            assertEquals("1/2", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void add() {
        try {
            result = rationalA.add(rationalB);
            assertEquals("3/4", result.toString());
            result = rationalA.add(integerA);
            assertEquals("5/2", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void mul() {
        try {
            result = rationalA.mul(rationalB);
            assertEquals("1/8", result.toString());
            result = rationalA.mul(integerA);
            assertEquals("1", result.toString());
            result = rationalMinusA.mul(rationalB);
            assertEquals("-1/8", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addRational() {
        try {
            result = rationalA.addRational(rationalB);
            assertEquals("3/4", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addInteger() {
        try {
            result = rationalA.addInteger(integerA);
            assertEquals("5/2", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void mulRational() {
        try {
            result = rationalA.mulRational(rationalB);
            assertEquals("1/8", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void mulInteger() {
        try {
            result = rationalA.mulInteger(integerA);
            assertEquals("1",result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void power() {
        try {
            result = rationalA.power(2);
            assertEquals("1/4",result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sign() {
        try {
            assertEquals(1, rationalA.sign());
            assertEquals(0, rationalZero.sign());
            assertEquals(-1, rationalMinusA.sign());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void neg() {
        try {
            result = rationalA.neg();
            assertEquals("-1/2", result.toString());
            result = rationalMinusA.neg();
            assertEquals("1/2", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testToString() {
        try {
            assertEquals("1/2", rationalA.toString());
            assertEquals("-1/2", rationalMinusA.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}