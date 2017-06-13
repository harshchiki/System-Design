package ChessGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ChessGame.pieces.Bishop;
import ChessGame.pieces.ChessPiece;
import ChessGame.pieces.King;
import ChessGame.pieces.Knight;
import ChessGame.pieces.Pawn;
import ChessGame.pieces.PieceColor;
import ChessGame.pieces.Position;
import ChessGame.pieces.Queen;
import ChessGame.pieces.Rook;

public class GameSession {
	ChessPiece[][] pieces = new ChessPiece[8][8];
	final Player blackPlayer, whitePlayer;
	int blackScore = 0, whiteScore = 0;
	boolean isGameOver = false;
	Player nextTurn;
	Map<Position, ChessPiece> chessMap = new HashMap<>();
	
	GameSession(final String player1, final String player2){
		initializeSession();
		blackPlayer = new Player(player1, player1);
		whitePlayer = new Player(player2, player2);
		nextTurn = whitePlayer;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(!isGameOver){
			System.out.println("Next turn: "+ nextTurn);
			
			String[] tokens = sc.nextLine().split(" ");
			Position from = new Position(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
			Position to = new Position(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
			
			ChessPiece piece = chessMap.get(from);
		}
	}
	
	
	void stop(){
		isGameOver = true;
	}
	
	Player getWinner(){
		return blackScore > whiteScore ? blackPlayer : whitePlayer;
	}
	
	
	void initializeSession(){
		Position position1 = new Position(0,1);
		Knight blackKnight1 = new Knight(PieceColor.BLACK, position1, chessMap);
		chessMap.put(blackKnight1.getPosition(), blackKnight1);
		pieces[0][1] = blackKnight1;

		Position position2 = new Position(0,6);
		Knight blackKnight2 = new Knight(PieceColor.BLACK, position2, chessMap);
		chessMap.put(blackKnight2.getPosition(), blackKnight2);
		pieces[0][6] = blackKnight2;
		
		
		Position position3 = new Position(0,2);
		Bishop blackBishop1 = new Bishop(PieceColor.BLACK, position3, chessMap);
		chessMap.put(blackBishop1.getPosition(), blackBishop1);
		pieces[0][2] = blackBishop1;
		
		Position position4 = new Position(0,5);
		Bishop blackBishop2 = new Bishop(PieceColor.BLACK, position4, chessMap);
		chessMap.put(blackBishop2.getPosition(), blackBishop2);
		pieces[0][5] = blackBishop2;
		
		Position position5 = new Position(0,0);
		Rook blackRook1 = new Rook(PieceColor.BLACK, position5, chessMap);
		chessMap.put(blackRook1.getPosition(), blackRook1);
		pieces[0][0] = blackRook1;
		
		Position position6 = new Position(0,7);
		Rook blackRook2 = new Rook(PieceColor.BLACK, position6, chessMap);
		chessMap.put(blackRook2.getPosition(), blackRook2);
		pieces[0][7] = blackRook2;
		
		Position position7 = new Position(0,3);
		King blackKing = new King(PieceColor.BLACK, position7, chessMap);
		chessMap.put(blackKing.getPosition(), blackKing);
		pieces[0][3] = blackKing;
		
		Position position8 = new Position(0,4);
		Queen blackQueen = new Queen(PieceColor.BLACK, position8, chessMap);
		chessMap.put(blackQueen.getPosition(), blackQueen);
		pieces[0][4] = blackQueen;
		
		for(int j = 0;j<8;j++){
			Position position = new Position(1,j);
			Pawn pawn = new Pawn(PieceColor.BLACK, position, chessMap);
			pieces[1][j] = pawn;
			chessMap.put(pawn.getPosition(), pawn);
		}
		
		Knight whiteKnight1 = new Knight(PieceColor.WHITE, new Position(7,1), chessMap);
		chessMap.put(whiteKnight1.getPosition(), whiteKnight1);
		pieces[7][1] = whiteKnight1;
		
		Knight whiteKnight2 = new Knight(PieceColor.WHITE, new Position(7,6), chessMap);
		chessMap.put(whiteKnight2.getPosition(), whiteKnight2);
		pieces[7][6] = whiteKnight2;
		
		Bishop whiteBishop1 = new Bishop(PieceColor.WHITE, new Position(7,2), chessMap);
		chessMap.put(whiteBishop1.getPosition(), whiteBishop1);
		pieces[7][2] = whiteBishop1;
		
		Bishop whiteBishop2 = new Bishop(PieceColor.WHITE, new Position(7,5), chessMap);
		chessMap.put(whiteBishop2.getPosition(), whiteBishop2);
		pieces[7][5] = whiteBishop2;
		
		Rook whiteRook1 = new Rook(PieceColor.WHITE, new Position(7,0), chessMap);
		chessMap.put(whiteRook1.getPosition(), whiteRook1);
		pieces[7][0] = whiteRook1;
		
		
		Rook whiteRook2 = new Rook(PieceColor.WHITE, new Position(7,7), chessMap);
		chessMap.put(whiteRook2.getPosition(), whiteRook2);
		pieces[7][7] = whiteRook2;
		
		King whiteKing = new King(PieceColor.WHITE, new Position(7,4), chessMap);
		chessMap.put(whiteKing.getPosition(), whiteKing);
		pieces[7][4] = whiteKing;
		
		Queen whiteQueen = new Queen(PieceColor.WHITE, new Position(7,3), chessMap);
		chessMap.put(whiteQueen.getPosition(), whiteQueen);
		pieces[7][3] = whiteQueen;
		
		for(int j = 0;j<8;j++){
			Pawn whitePawn = new Pawn(PieceColor.WHITE, new Position(6,j), chessMap);
			pieces[6][j] = whitePawn;
			chessMap.put(whitePawn.getPosition(), whitePawn);
		}
	}
	
}
