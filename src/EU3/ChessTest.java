package EU3;
import java.util.Scanner;
@SuppressWarnings("Duplicates")
public class ChessTest {
    public static void main(String[] args) throws NotValidFieldException {
        Scanner in = new Scanner(System.in);

        Chessboard test = new Chessboard();
        Chessboard.Pawn pawn = test.new Pawn('b', 'P');
        System.out.println(test.toString());
        System.out.println("Pawn row: ");
        pawn.setRow(in.next().charAt(0));
        System.out.println("Pawn column: ");
        pawn.setColumn(in.nextByte());
        test.setField(pawn);
        pawn.markReachableFields();
        System.out.println(test.toString());
        pawn.unmarkReachableFields();
        System.out.println(test.toString());
        pawn.moveOut();
        System.out.println(test.toString());

        Chessboard.Knight knight = test.new Knight('w', 'N');
        System.out.println("Knight Row: ");
        knight.setRow(in.next().charAt(0));
        System.out.println("Knight Column: ");
        knight.setColumn(in.nextByte());
        test.setField(knight);
        knight.markReachableFields();
        System.out.println(test.toString());
        knight.unmarkReachableFields();
        System.out.println(test.toString());
        knight.moveTo('b', (byte) 3);
        knight.markReachableFields();
        System.out.println(test.toString());
        knight.unmarkReachableFields();
        System.out.println(test.toString());

        Chessboard.King king = test.new King('w', 'K');
        System.out.println("King row: ");
        king.setRow(in.next().charAt(0));
        System.out.println("King column: ");
        king.setColumn(in.nextByte());
        test.setField(king);
        king.markReachableFields();
        System.out.println(test.toString());
        king.unmarkReachableFields();
        System.out.println(test.toString());
        in.close();
    }
}
