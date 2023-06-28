package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
    private Monomial m1;
    private Monomial m2;
    private Monomial m3;
    private Monomial m4;
    private Monomial m5;
    private Monomial m6;
    private Monomial m7;
    private Monomial monomialRes;

    @BeforeEach
    void setUp() {
        m1 = new Monomial(2,new Integer(2));//2x^2
        m2 = new Monomial(0,new Integer(6));//6
        m3 = new Monomial(1,new Integer(2));//2x
        m4 = new Monomial(1,new Integer(6));//6x
        m5 = new Monomial(1,new Integer(-2));//-2x
        m6 = new Monomial(1,new Rational(1,2));//1/2x
        m7 = new Monomial(1,new Integer(0));//0
    }

    @Test
    void add() {
        try {
            monomialRes =  m3.add(m4);
            assertEquals(monomialRes.toString(),"8x");
            monomialRes =  m6.add(m3);
            assertEquals(monomialRes.toString(),"5/2x");
            monomialRes =  m1.add(m3);
            assertNull(monomialRes, "Add monomial with unequal exponent");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void mul() {
        try {
            monomialRes =  m3.mul(m4);
            assertEquals("12x^2",monomialRes.toString());
            monomialRes =  m2.mul(m4);
            assertEquals("36x",monomialRes.toString());
            monomialRes =  m7.mul(m4);
            assertEquals("0",monomialRes.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void evaluate() {
        Scalar result;
        try {
            result = m1.evaluate(new Integer(3));
            assertEquals("18", result.toString());
            result = m6.evaluate(new Integer(-3));
            assertEquals("-3/2",result.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void derivative() {
        try {
            monomialRes = m1.derivative();
            assertEquals("4x",monomialRes.toString());
            monomialRes =  m5.derivative();
            assertEquals("-2",monomialRes.toString());
            monomialRes =  m6.derivative();
            assertEquals("1/2",monomialRes.toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sign() {
        try {
            assertEquals(1,m1.sign());
            assertEquals(-1,m5.sign());
            assertEquals(0,m7.sign());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testToString() {
        String[] excepted = {"2x^2","6","2x","6x","-2x","1/2x","0"};
        Monomial[] monomialTested = {m1,m2,m3,m4,m5,m6,m7};
        try {
            for(int i = 0; i < monomialTested.length; i += 1)
            {
                assertEquals(monomialTested[i].toString(), excepted[i]);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}