package presenter;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.model.board.Board;
import org.model.board.BoardChangeListener;
import org.model.pieces.Piece;
import org.model.util.Vector2d;

import java.util.Map;

public class GamePresenter implements BoardChangeListener {
    @FXML
    private GridPane mapGrid;
    private Board board;

    private int cellSize;
    private final int maxGridWidth = 600;
    private final int maxGridHeight = 600;


    public void initializePresenter(Board board){
        this.board = board;
        cellSize = calculateCellSize();
    }

    private int calculateCellSize(){
        Vector2d bounds = board.getBoundaries();
        int maxCellWidth = maxGridWidth / (bounds.getX() + 1);
        int maxCellHeight = maxGridHeight / (bounds.getY() + 1);
        return Math.min(maxCellWidth, maxCellHeight);
    }

    @Override
    public void boardChanged(Board board, Piece piece, Vector2d move) {
        Platform.runLater(() -> drawBoard(board, piece, move));
    }

    //Draw the board with the current state of pieces.
    private void drawBoard(Board board, Piece piece, Vector2d move){
        clearGrid();
        if (piece != null){
            String pieceColor = piece.getIsWhite() ? "White" : "Black";
            System.out.println(pieceColor + " " + piece + " moved from " + piece.getPosition().subtract(move) + " to " + piece.getPosition());
        }
        Vector2d bounds = board.getBoundaries();

        for (int i = 0; i < bounds.getX() + 1; i++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(cellSize));
        }

        for (int i = 0; i < bounds.getY() + 1; i++) {
            mapGrid.getRowConstraints().add(new RowConstraints(cellSize));
        }

        Label label;
        for (int i = 0; i < bounds.getX(); i++){
            char c = (char)(i + 97);
            label = new Label(String.valueOf(c));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label, i + 1, 0);
        }
        for (int i = 0; i < bounds.getY(); i++){
            label = new Label(String.valueOf(bounds.getY() - i));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label, 0, i + 1);
        }

        for (Map.Entry<Vector2d, Piece> entry : board.getElements().entrySet()){
            Node objectToDraw = createPiece(entry.getValue());
            GridPane.setHalignment(objectToDraw, HPos.CENTER);

            mapGrid.add(objectToDraw, entry.getKey().getX() + 1, bounds.getY() - entry.getKey().getY());
        }
    }

    private Node createPiece(Piece piece){
        Rectangle invisibleRect = new Rectangle(cellSize, cellSize, Color.TRANSPARENT);
        invisibleRect.setMouseTransparent(false);
        Label objectToDraw = new Label(piece.toString());
        objectToDraw.setTextFill(piece.getIsWhite() ? Color.WHITE : Color.BLACK);
        objectToDraw.setMouseTransparent(true);
        GridPane.setHalignment(invisibleRect, HPos.CENTER);
        mapGrid.add(invisibleRect, piece.getPosition().getX() + 1,
                board.getBoundaries().getY() - piece.getPosition().getY());

        invisibleRect.setOnMouseReleased(event -> handleDragEnd(piece, event));
        return objectToDraw;
    }

    private void handleDragStart(Piece piece) {
        System.out.println(piece.getPosition().toString());
    }

    private void handleDragEnd(Piece piece, MouseEvent event){
        double mouseX = event.getSceneX();
        double mouseY = event.getSceneY();
        int x = ((int) Math.floor((mouseX - mapGrid.getParent().getParent().getLayoutX()) / cellSize)) - 1;
        int y = board.getBoundaries().getY() - ((int) Math.floor((mouseY - mapGrid.getParent().getLayoutY()) / cellSize));
        piece.move(new Vector2d(x, y));
    }

    private void clearGrid(){
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0));
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }
}
