package OU2;

import java.util.*; //Scanner & Locale
class Triangle {

    
        // The bisector method accepts two sides and the angle (in
    // radians ) between these sides . The method returns the
    // length of the corresponding bisector - the one which
    // splits the given angle in two equals halves .
    public static double bisector ( double b, double c, double alpha ){
        double p = 2 * b * c * Math.cos( alpha / 2);
        double bis = p / (b + c);
        return bis;
    }
    //Calculates the area using two lengths and the angle between them
    public static double areaLengthsAngle (double a, double b, double alpha) {
        double area = (0.5 * a * b * Math.sin(alpha));
        return area;

    }
    //Calculates area using height and base
    public static double areaHeightBase (double base, double height) {
        double area = (0.5 * base * height);
        return area;
    }
    public static double perimeterLengthsOnly (double a, double b, double c) {
        double perimeter = a + b + c;
        return perimeter;
    }
    //using the cosine rule, find the the angle using 3 lengths
    public static double angleCosineRule (double a, double b, double c) {
        double angleC = Math.acos(((a*a)+(b*b)-(c*c))/(0.5*a*b));
        return angleC;
    }
    //using the cosine rule, find the length using an angle and two sides.
    public static double lenthCosineRule (double a, double b, double alpha) {
        double missingangle = (Math.sqrt((a*a)+(b*b)-(2*a*b*Math.cos(alpha))));
        return missingangle;
    }
    
    // Using the sine rule, find the missing angle with two angles.
    public static double lengthSineRule (double a, double alpha, double beta){
        double missinglength = (Math.sin(alpha)*a)/(Math.sin(beta));
        return missinglength; 
    }
    //Using the sine rule, find the missing length with two lengths and an angle.
    public static double angleSineRule (double a, double b, double alpha){
        double missingangle = (Math.asin((Math.sin(alpha)*b)/a));
        return missingangle;
    }
    //Radius of incircle using 3 sides, area calculated using herons formula.
    public static double inCircle(double a, double b, double c) {
        double s = (0.5 * (a + b + c));
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        double perimeter = a + b + c;
        double radius = (2 * area)/(perimeter);
        return radius;      
    }

    //Circumcircle radius
    public static double circumcircle(double a, double b, double c) {
        double product = a*b*c;
        double denominator = Math.sqrt((a+b+c)*(b+c-a)*(c+a-b)*(a+b-c));
        double radius = (product)/(denominator);
        return radius;
        
    }
    
}

