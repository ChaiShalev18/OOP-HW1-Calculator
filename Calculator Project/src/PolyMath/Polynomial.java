package PolyMath;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private final Map<java.lang.Integer, Monomial> monomials;

    public Polynomial() {
        this.monomials = new HashMap<java.lang.Integer, Monomial>();
    }

    public Polynomial(Polynomial p) {
        this.monomials = new HashMap<java.lang.Integer, Monomial>();
        for (Map.Entry<java.lang.Integer, Monomial> monomial : p.monomials.entrySet()) {
            monomials.put(monomial.getKey(), new Monomial(monomial.getValue()));
        }
    }

    private static Scalar toScalar(String strScalar) {
        Scalar scalar = null;
        String[] arguments = strScalar.split("/");
        if (arguments.length == 1) {
            int number = java.lang.Integer.parseInt(arguments[0]);
            scalar = new Integer(number);
        } else if (arguments.length == 2) {
            int numerator = java.lang.Integer.parseInt(arguments[0]);
            int denominator = java.lang.Integer.parseInt(arguments[1]);
            scalar = new Rational(numerator, denominator);
        }
        return scalar;
    }

    public static Polynomial build(String input) {
        Polynomial polynomial = new Polynomial();
        int exponent = 0;
        String[] strMonomials = input.split(" ");
        for (String strMonomial : strMonomials) {
            if(strMonomial.charAt(0)!='0')
                polynomial.monomials.put(exponent, new Monomial(exponent, toScalar(strMonomial)));
            exponent += 1;
        }
        return polynomial;
    }


    public Polynomial add(Polynomial p) {
        Polynomial polynomial = new Polynomial(this);
        for (Map.Entry<java.lang.Integer, Monomial> monomial : p.monomials.entrySet()) {
            polynomial = polynomial.add(monomial.getValue());
        }
        return polynomial;
    }

    public Polynomial add(Monomial m) {
        Polynomial polynomial = new Polynomial(this);
        if(m.sign() == 0){
            return polynomial;
        }
        else if (polynomial.monomials.containsKey(m.getExponent())) {
            Monomial newMonomial = m.add(polynomial.monomials.get(m.getExponent()));
            polynomial.monomials.put(m.getExponent(), newMonomial);
        } else {
            polynomial.monomials.put(m.getExponent(), m);
        }
        return polynomial;
    }
    public Polynomial mul(Polynomial p) {
        Polynomial polynomial = new Polynomial();

        for (Map.Entry<java.lang.Integer, Monomial> monomial : p.monomials.entrySet()) {
            polynomial = polynomial.add(this.mul(monomial.getValue()));
        }

        return polynomial;
    }
    public Polynomial mul(Monomial m) {
        Polynomial polynomial = new Polynomial();
        for (Map.Entry<java.lang.Integer, Monomial> monomial : this.monomials.entrySet()) {
            polynomial = polynomial.add(monomial.getValue().mul(m));
        }

        return polynomial;
    }
    public Scalar evaluate(Scalar s) {
        Scalar evaluateScalar = new Integer(0);
        for (Map.Entry<java.lang.Integer, Monomial> monomial : this.monomials.entrySet()) {
            evaluateScalar = evaluateScalar.add(monomial.getValue().evaluate(s));
        }
        return evaluateScalar;
    }

    public Polynomial derivative() {
        Polynomial polynomialDer = new Polynomial();
        for (Map.Entry<java.lang.Integer, Monomial> monomial : this.monomials.entrySet()) {
            Monomial monomialDerivative = monomial.getValue().derivative();
            polynomialDer = polynomialDer.add(monomialDerivative);
        }
        return polynomialDer;
    }


    @Override
    public String toString() {
        String polynomialString = "";
        boolean isFirstMono = true;
        if(this.monomials.isEmpty()){
            return "0";
        }
        for (Map.Entry<java.lang.Integer, Monomial> monomial : this.monomials.entrySet()) {
            int sign = monomial.getValue().sign();
            if (sign != 0) {
                String s = monomial.getValue().toString();
                if (monomial.getValue().sign() == 1 && !isFirstMono) {
                    polynomialString += " + ";

                }
                if (monomial.getValue().sign() == -1 && !isFirstMono) {
                    polynomialString += " - ";
                    s = s.substring(1,s.length());
                }
                isFirstMono = false;
                polynomialString += s;
            }
            else{

                polynomialString += monomial.toString();
            }
        }
        return polynomialString;
    }
}
