package OU4;
//Cool!, now to put this on github we deleted all the respositories????? How is 'hi' still there... it is not... but the info on the vcs file of the project is still here... wait a second
import java . util .*; // Scanner
import static java . lang . System . out ;
@SuppressWarnings("Duplicates")
    class OperationsWithNaturalNumbersGivenAsStrings {
    
        public static void main ( String [] args )
        {
            out . println ( " OPERATIONS ON NATURAL NUMBERS " + " IN CHARACTER STRINGS " );
            // enter two natural numbers
            Scanner in = new Scanner ( System . in );
            out . println ( " two natural numbers : " );
            String num1 = in . next ();
            String num2 = in . next ();
            out . println ();
            // add the numbers and show the result
            String sum = add ( num1 , num2 );
            show ( num1 , num2 , sum , '+' );
            // subtract the numbers and show the result
            // *** WRITE YOUR CODE HERE ***
            String difference = subtract (num1, num2 );
            show (num1 , num2, difference, '-');
        }
        // The add method accepts two natural numbers represented
        // as character strings and returns their sum as a
        // character string .
        public static String add ( String num1 , String num2 )
        {
        int sum;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        
        num2 = setLen (num2 , (num1.length()-num2.length()));

        for (int i = num1.length()-1;i >= 0; i--) { // this starts the process at the end of the strings.
            char currentvalue1 = num1.charAt(i);
            char currentvalue2 = num2.charAt(i);

            int numeric1 = Character.getNumericValue(currentvalue1);
            int numeric2 = Character.getNumericValue(currentvalue2);

            sum = numeric1 + numeric2 + carry;

            if (num2.charAt(i) == (' ')){
                sum = numeric1 + carry;
            }
            if (sum > 9 && i > 0) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            result.insert(0 , sum);
        }
        return result.toString();
    }
        // The subtract method accepts two natural numbers
        // represented as character strings and returns their
        // difference as a character string .
        // The first number is not smaller than the second
        public static String subtract ( String num1 , String num2 ) {
            int difference;
            int carry = 0;
            StringBuilder result = new StringBuilder();
            
            num2 = setLen (num2 , (num1.length()-num2.length()));
    
            for (int i = num1.length()-1;i >= 0; i--) {
                char currentvalue1 = num1.charAt(i);
                char currentvalue2 = num2.charAt(i);
    
                int numeric1 = Character.getNumericValue(currentvalue1);
                int numeric2 = Character.getNumericValue(currentvalue2);

                if (numeric1 < numeric2 && i > 0) {
                    numeric1 += 10;
                    difference = (numeric1 - numeric2) + carry;
                    carry = -1;
                    
                }
                
                else if (num2.charAt(i) != (' ')) {
                    carry = 0;
                    difference = (numeric1 - numeric2) + carry;
                }
                else {
                    difference = numeric1 + carry;
                    carry = 0;
                }
                result.insert(0 , difference);
            }
            return result.toString();
        }

        public static void show ( String num1 , String num2 , String result , char operator )
        {
        // set an appropriate length on numbers and result
            int len1 = num1 . length ();
            int len2 = num2 . length ();
            int len = result . length ();
            int maxLen = Math . max ( Math . max ( len1 , len2 ) , len );
            num1 = setLen ( num1 , maxLen - len1 );
            num2 = setLen ( num2 , maxLen - len2 );
            result = setLen ( result , maxLen - len );
            // show the expression
            out . println ( "   " + num1 );
            out . println ( " " + operator + " " + num2 );
            for ( int i = 0; i < maxLen + 2; i ++)
            out . print ( " -" );
            out . println ();
            out . println ( "   " + result + " \n " );
        }
        // The setLen method prepends the supplied number of
        // spaces ato the beginning of a string
        public static String setLen ( String s , int nofSpaces )
        {
            StringBuilder sb = new StringBuilder ( s );
            for ( int i = 0; i < nofSpaces ; i ++)
            sb . insert (0 , " " );
            return sb . toString ();
        }   
}