package blankjavafx.finalprojectfx5;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController
{
    @FXML
    private GridPane gridPane;

    public void initialize()
    {
        int columns = 6;
        for (int i = 1; i < 158; i++)
        {
            ImageView pokemonSprite = new ImageView("https://img.pokemondb.net/sprites/lets-go-pikachu-eevee/normal/" + PokemonInfo.getName(i) + ".png");
            pokemonSprite.setFitHeight(80);
            pokemonSprite.setFitWidth(80);
            Text pokemonName = new Text(PokemonInfo.getName(i));
            if (i > 151)
            {
                pokemonSprite.setImage(null);
                pokemonName.setText("");
            }
            final int currentIndex = i;
            pokemonSprite.setOnMouseClicked((MouseEvent event) -> {
                try {
                    switchScene(event, PokemonInfo.getID(currentIndex));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            pokemonName.setTranslateY(60);
            pokemonName.setStyle("-fx-font-weight: bold;");
            pokemonName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            GridPane.setHalignment(pokemonName, javafx.geometry.HPos.CENTER);
            gridPane.add(pokemonSprite, (i - 1) % columns, (i - 1) / columns);
            gridPane.add(pokemonName, (i - 1) % columns, (i - 1) / columns);
        }
    }

    private  void switchScene(MouseEvent event, int pokemon) throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pokemonInfoCard.fxml"));
        Parent root = fxmlLoader.load();
        PokemonInfoCardController controller = fxmlLoader.getController();
        controller.openData(pokemon);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}