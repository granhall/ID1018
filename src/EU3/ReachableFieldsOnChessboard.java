package EU3;

import java.util.Random;

/* Answering Question 2: All the pieces inherit from the superclass Chesspiece
This allows all the pieces to be stored within the same array instead of having separate arrays for each.
 */
/* Answering Question 3: Pieces can be presented in a loop because they all stem from class Chesspiece and are stored in the same array.
This allows us to loop through the array to access each piece.
The alternative to this is having a different array of the object type of the piece.
 */
public class ReachableFieldsOnChessboard {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Chessboard chessBoard = new Chessboard();
        Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
        pieces[0] = chessBoard.new Pawn('w', 'P');
        pieces[1] = chessBoard.new Rook('w', 'R');
        pieces[2] = chessBoard.new Knight('w', 'N');
        pieces[3] = chessBoard.new Bishop('b', 'B');
        pieces[4] = chessBoard.new Queen('b', 'Q');
        pieces[5] = chessBoard.new King('b', 'K');

        for (int i = 0; i < 6; i++) {
            pieces[i].setColumn((byte)(1 + random.nextInt(6)));
            pieces[i].setRow((char)('a' + random.nextInt(6)));
            chessBoard.setField(pieces[i]);
            System.out.println(chessBoard);
            pieces[i].markReachableFields();
            System.out.println(chessBoard);
            Thread.sleep(2000);
            pieces[i].unmarkReachableFields();
            System.out.println(chessBoard);
            pieces[i].moveOut();
            System.out.println(chessBoard);
        }
    }
}
