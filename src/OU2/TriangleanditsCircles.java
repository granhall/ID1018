package OU2;

import java.util.*;

class TriangleanditsCircles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in. useLocale ( Locale .US );
        System.out.println("Hello, what do you want to calculate?: ");
        System.out.println("For bisector length, using two sides and the angle in between them, enter: 1 ");
        System.out.println("For area using two lengths and the angle between them, enter: 2  ");
        System.out.println("For area using base and height, enter: 3 ");
        System.out.println("For perimeter using the 3 sides enter: 4 ");
        System.out.println("For angle using cosine rule, using all three sides, enter: 5 ");
        System.out.println("For length using cosine rule, using two sides and the angle between them, enter: 6");
        System.out.println("For angle using sine rule, using two lengths and one angle, enter: 7");
        System.out.println("For length using sine rule, using one length and two angles: enter: 8");
        System.out.println("NOTE: If angles are used, Enter in Radians");
        
        int x = in.nextInt(); 
        double b;
        double a;
        double alpha;
        double base;
        double height;
        double c;
        double beta;

        switch (x) {
        case 1:
            System.out.println("Enter side 1: ");
            b = in.nextDouble();
            System.out.println("Enter side 2: ");
            c = in.nextDouble();
            System.out.println("Enter the angle: ");
            alpha = in.nextDouble();
            System.out.println("Answer");
            System.out.println(Triangle.bisector(b, c, alpha));
            
            break;
        case 2: 
            System.out.println("Enter side 1: ");
            a = in.nextDouble();
            System.out.println("Enter side 2: ");
            b = in.nextDouble();
            System.out.println("Enter the angle: ");
            alpha = in.nextDouble();
            System.out.println("Answer");
            System.out.println(Triangle.areaLengthsAngle(a, b, alpha));
            break;
        case 3: 
            System.out.println("Enter base: ");
            base = in.nextDouble();
            System.out.println("Enter side height ");
            height = in.nextDouble();
            System.out.println("Answer");
            System.out.println(Triangle.areaHeightBase(base, height));
            break;
        
        case 4: 
            System.out.println("Enter side 1: ");
            a = in.nextDouble();
            System.out.println("Enter side 2: ");
            b = in.nextDouble();
            System.out.println("Enter side 3: ");
            c = in.nextDouble();
            System.out.println("Answer");
            System.out.println(Triangle.perimeterLengthsOnly(a, b, c));
            break; 
        case 5: 
            System.out.println("Enter side 1: ");
            a = in.nextDouble();
            System.out.println("Enter side 2: ");
            b = in.nextDouble();
            System.out.println("Enter side 3: ");
            c = in.nextDouble();
            System.out.println("Answer in Radians");
            System.out.println(Triangle.angleCosineRule(a, b, c));
            break;
        case 6: 
            System.out.println("Enter side 1: ");
            a = in.nextDouble();
            System.out.println("Enter side 2: ");
            b = in.nextDouble();
            System.out.println("Enter the angle: ");
            alpha = in.nextDouble();
            System.out.println("Answer");
            System.out.println(Triangle.lenthCosineRule(a, b, alpha));
            break;
        case 7: 
            System.out.println("Enter side 1: ");
            a = in.nextDouble();
            System.out.println("Enter angle 1: ");
            alpha = in.nextDouble();
            System.out.println("Enter angle 2: ");
            beta = in.nextDouble();
            System.out.println("Answer");
            System.out.println(Triangle.lengthSineRule(a, alpha, beta));
            break;
        case 8: 
            System.out.println("Enter side 1: ");
            a = in.nextDouble();
            System.out.println("Enter side 2: ");
            b = in.nextDouble();
            System.out.println("Enter the angle: ");
            alpha = in.nextDouble();
            System.out.println("Answer in Radians");
            System.out.println(Triangle.angleSineRule(a, b, alpha));
            break;
        
        
        case 9: 
            System.out.println("Enter side 1: ");
            a = in.nextDouble();
            System.out.println("Enter side 2: ");
            b = in.nextDouble();
            System.out.println("Enter side 3: ");
            c = in.nextDouble();
            System.out.println("Answer");
            System.out.println(Triangle.inCircle(a, b, c));
            break;

        case 10: 
            System.out.println("Enter side 1: ");
            a = in.nextDouble();
            System.out.println("Enter side 2: ");
            b = in.nextDouble();
            System.out.println("Enter side 3: ");
            c= in.nextDouble();
            System.out.println("Answer");
            System.out.println(Triangle.circumcircle(a, b, c));
            break;
        }
        in.close();
        
    }
}