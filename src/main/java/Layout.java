import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Layout extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // HBox widok poziomy horyzontalny
        HBox hbox = new HBox();

        // VBox widok pionowy wertykalny
        VBox vBox = new VBox();

        // StackPane stos czyli co jest na czym kolejnosc jest wazna
        StackPane stackPane = new StackPane();

        // BorderPane granice gdzie co ma byc
        BorderPane borderPane = new BorderPane();

        Button buttonMenu = new Button("Menu");
        Button buttonZamowienie = new Button("Zamówienie");
        Button buttonKontakt = new Button("Kontakt");

        hbox.getChildren().addAll(buttonMenu, buttonZamowienie, buttonKontakt);
        // Odstępy
        hbox.setSpacing(20);
        // Marginesy
        hbox.setPadding(new Insets(10, 5, 10, 20));
        hbox.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(12), new Insets(5))));

        // Utworzenie obrazków
        ImageView pizzaImageView = new ImageView(new Image("obrazki/ikony/pizza.png"));
        ImageView hamburgerImageView = new ImageView(new Image("obrazki/ikony/hamburger.png"));
        ImageView napojeImageView = new ImageView(new Image("obrazki/ikony/napoje.png"));

        // Utworzenie etykiet czyli napisów do tych obrazków
        Label pizzaLabel = new Label("Pizza", pizzaImageView);
        Label hamburgerLabel = new Label("Hamburger", hamburgerImageView);
        Label napojeLabel = new Label("Napoje", napojeImageView);

        vBox.getChildren().addAll(pizzaLabel, hamburgerLabel, napojeLabel);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        ImageView czterySeryDuzaImageView = new ImageView(new Image("obrazki/pizza/pizza-cztery-sery-duza.png"));
        Label opisCzterySeryLabel = new Label("Mozarella, rokplo, edamski, gouda");
        opisCzterySeryLabel.setTextFill(Color.WHITE);

        stackPane.getChildren().addAll(czterySeryDuzaImageView, opisCzterySeryLabel);
        stackPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        stackPane.setAlignment(Pos.BOTTOM_CENTER);

        // FlowPane czyli taki dynamiczny hbox lub vbox
        ImageView czterySeryImageView = new ImageView("obrazki/pizza/pizza-cztery-sery.png");
        ImageView funghiImageView = new ImageView("obrazki/pizza/pizza-funghi.png");
        ImageView margarittaImageView = new ImageView("obrazki/pizza/pizza-margaritta.png");
        ImageView mexicanaImageView = new ImageView("obrazki/pizza/pizza-mexicana.png");
        ImageView pepperoniImageView = new ImageView("obrazki/pizza/pizza-pepperoni.png");
        ImageView salamiImageView = new ImageView("obrazki/pizza/pizza-salami.png");

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(
                czterySeryImageView,
                funghiImageView,
                margarittaImageView,
                mexicanaImageView,
                pepperoniImageView,
                salamiImageView
        );
        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setMaxWidth(250);
        flowPane.setHgap(10);
        flowPane.setVgap(5);
        flowPane.setPadding(new Insets(5));

        // GridPane taka siatka
        Button plusButton = new Button("+");
        plusButton.setPrefSize(30, 30);
        Button minusButton = new Button("-");
        minusButton.setPrefSize(30, 30);
        Label iloscLabel = new Label("1");
        iloscLabel.setPadding(new Insets(0, 10, 0, 10));

        Button okButton = new Button("OK");
        Button anulujButton = new Button("Anuluj");

        Pane pane = new Pane();
        pane.setPrefWidth(100);

        GridPane gridPane = new GridPane();
        gridPane.add(minusButton, 0, 0); // 1 kolumna 1 wiersz
        gridPane.add(iloscLabel, 1, 0); // 2 kolumna 1 wiersz
        gridPane.add(plusButton, 2, 0); // 3 koluma 1 wiersz
        gridPane.add(pane, 3, 1); // 4 koluma 2 wiersz pusta przestrzen miedzy plus minus a ok anuluj
        gridPane.add(okButton, 4, 1);  // 5 kolumna 2 wiersz
        gridPane.add(anulujButton, 5, 1); // 6 kolumna 2 wiersz

        // ScrollPane
        for(int i = 0; i < 30; i++) {
            ImageView pizzaFunghiImageView = new ImageView(new Image("obrazki/pizza/pizza-funghi.png"));
            flowPane.getChildren().add(pizzaFunghiImageView);
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(flowPane);
        scrollPane.setMaxWidth(200);


        borderPane.setTop(hbox);
        borderPane.setLeft(vBox);
        borderPane.setCenter(stackPane);
        borderPane.setRight(scrollPane);
        borderPane.setBottom(gridPane);

        Scene scene = new Scene(borderPane, 900, 650);

        primaryStage.setX(300);
        primaryStage.setY(100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Zadanie z Layoutem");
        primaryStage.show();
    }
}
