package presenter;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.model.board.Board;
import org.model.board.ChessBoard;

import java.io.IOException;

public class ChessPresenter {

    //Start the game
    public void onGameStartClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GamePresenter.fxml"));
        Stage stage = new Stage();
        HBox viewRoot = loader.load();
        configureStage(stage, viewRoot);
        stage.show();

        GamePresenter gamePresenter = loader.getController();
        Board board = new ChessBoard();
        board.subscribeObserver(gamePresenter);
        gamePresenter.initializePresenter(board);
        board.resetBoard();
    }

    private void configureStage(Stage primaryStage, HBox viewRoot){
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
