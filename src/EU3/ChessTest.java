package EU3;
import java.util.Scanner;
public class ChessTest {
    public static void main(String[] args) throws NotValidFieldException {
        Scanner in = new Scanner(System.in);
        Chessboard test = new Chessboard();
        Chessboard.Pawn pawn = test.new Pawn('b', 'P');
        System.out.println(test.toString());
        System.out.println("Pawn row: ");
        pawn.setRow(in.next().charAt(0));


    }
}
