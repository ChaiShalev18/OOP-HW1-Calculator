package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTest {
    Integer integerA;
    Integer integerB;
    Integer integerMinusA;
    Integer integerZero;
    Scalar result;
    Rational rationalA;

    @BeforeEach
    void setUp() {
        integerA = new Integer(7);
        integerB = new Integer(6);
        integerMinusA = new Integer(-7);
        integerZero = new Integer(0);
        rationalA =new Rational(1,2);
    }

    @Test
    void add() {
        try {
            result = integerA.add(integerB);
            assertEquals("13", result.toString());
            result = integerA.add(rationalA);
            assertEquals("15/2", result.toString());
            result = integerA.add(integerZero);
            assertEquals("7",result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void mul() {
        try {
            result = integerA.mul(integerB);
            assertEquals("42",result.toString());
            result = integerA.mul(integerZero);
            assertEquals("0",result.toString());
            result = integerMinusA.mul(integerB);
            assertEquals("-42", result.toString());
            result = integerMinusA.mul(rationalA);
            assertEquals("-7/2", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addRational() {
        try {
            result = integerA.addRational(rationalA);
            assertEquals("15/2", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addInteger() {
        try {
            result = integerA.addInteger(integerB);
            assertEquals("13", result.toString());
            result = integerA.addInteger(integerZero);
            assertEquals("7", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void mulRational() {
        try {
            result = integerA.mulRational(rationalA);
            assertEquals("7/2", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void mulInteger() {
        try {
            result = integerA.mulInteger(integerB);
            assertEquals("42", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void power() {
        try {
            result = integerA.power(2);
            assertEquals("49", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sign() {
        try {
            assertEquals(1, integerA.sign());
            assertEquals(0, integerZero.sign());
            assertEquals(-1, integerMinusA.sign());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void neg() {
        try {
            result = integerA.neg();
            assertEquals("-7", result.toString());
            result = integerMinusA.neg();
            assertEquals("7", result.toString());
            result = integerZero.neg();
            assertEquals("0", result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testToString() {
        try {
            assertEquals("0", integerZero.toString());
            assertEquals("7", integerA.toString());
            assertEquals("-7", integerMinusA.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}