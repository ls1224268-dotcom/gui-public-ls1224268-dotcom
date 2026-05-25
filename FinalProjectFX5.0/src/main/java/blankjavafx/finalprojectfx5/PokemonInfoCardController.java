package blankjavafx.finalprojectfx5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class PokemonInfoCardController
{

    @FXML
    private Text pokemonName;
    @FXML
    private Text pokemonType;
    @FXML
    private Text pokemonType2;
    @FXML
    private Text PokemonHeight;
    @FXML
    private Text PokemonWeight;
    @FXML
    private Text PokemonAbility;
    @FXML
    private Text PokemonAbility2;
    @FXML
    private Text PokemonAbility3;
    @FXML
    private Text HP;
    @FXML
    private Text Atk;
    @FXML
    private Text Def;
    @FXML
    private Text SpAtk;
    @FXML
    private Text SpDef;
    @FXML
    private Text Spe;
    @FXML
    private ImageView PokemonImage;
    @FXML
    private StackPane Type1Box;
    @FXML
    private StackPane Type2Box;
    @FXML
    private ProgressBar HPBar;
    @FXML
    private ProgressBar AtkBar;
    @FXML
    private ProgressBar DefBar;
    @FXML
    private ProgressBar SpAtkBar;
    @FXML
    private ProgressBar SpDefBar;
    @FXML
    private ProgressBar SpeBar;
    @FXML
    private ToggleButton genderToggle;
    @FXML
    private ToggleButton mega1Toggle;
    @FXML
    private ToggleButton mega2Toggle;
    @FXML
    private Text pokemonEntries;
    @FXML
    private ToggleButton shinyToggle;
    @FXML
    private Text total;
    @FXML
    private Label statusLabel;
    @FXML
    private Label statusLabel2;
    @FXML
    private Label statusLabel3;

    static int pokemonCount;
    static boolean isShiny;
    static boolean hasGender;
    static boolean hasMega1;
    static boolean hasMega2;
    static String formattedName;

    public void openData(int pokemonID)
    {
        pokemonName.setText(PokemonInfo.getName(pokemonID));
        pokemonType.setText(PokemonInfo.getType1(pokemonID));
        pokemonType2.setText(PokemonInfo.getType2(pokemonID));
        TypeBoxColor(pokemonID);
        PokemonHeight.setText("Height: " + PokemonInfo.getHeight(pokemonID));
        PokemonWeight.setText("Weight: " + PokemonInfo.getWeight(pokemonID));
        PokemonAbility.setText(PokemonInfo.getAbility(pokemonID));
        PokemonAbility2.setText(PokemonInfo.getAbility2(pokemonID));
        PokemonAbility3.setText(PokemonInfo.getAbility3(pokemonID));
        HP.setText("HP: " + PokemonInfo.getHP(pokemonID));
        Atk.setText("ATK: " + PokemonInfo.getATK(pokemonID));
        Def.setText("DEF: " + PokemonInfo.getDEF(pokemonID));
        SpAtk.setText("SPATK: " + PokemonInfo.getSPATK(pokemonID));
        SpDef.setText("SPDEF: " + PokemonInfo.getSPDEF(pokemonID));
        Spe.setText("SPE: " + PokemonInfo.getSPE(pokemonID));
        getTotal(pokemonID);
        String textType;
        if (isShiny == true){
            textType = "shiny-sprite";
        } else {
            textType = "normal-sprite";
        }
        String genderText;
        if (hasGender == true)
        {
            genderText = "-f";
        } else {
            genderText = "";
        }
        String mega1Text;
        String mega2Text;
        if (mega1Toggle.isSelected() == true && hasMega1 == true && hasMega2 == true)
        {
            mega1Text = "-megax";
        }  else if (mega1Toggle.isSelected() == true && hasMega1 == true && hasMega2 == false)
        {
            mega1Text = "-mega";
        } else {
            mega1Text = "";
        }
        if (mega2Toggle.isSelected() == true && hasMega2 == true)
        {
            mega2Text = "-megay";
        }  else {
            mega2Text = "";
        }
        String pokemonName = PokemonInfo.getName(pokemonID);
        if (PokemonInfo.getID(pokemonID) == 122)
        {
            formattedName = pokemonName.replace("-", ".");
        } else {
            formattedName = pokemonName.replace("-", "_");
        }
        String url = "https://projectpokemon.org/images/" + textType + "/" + formattedName + genderText + mega1Text + mega2Text + ".gif";
        Image pokemonSprite = new Image(url);
        PokemonImage.setImage(pokemonSprite);
        if (pokemonID == 142 || pokemonID == 144 || pokemonID == 146 || pokemonID == 153 || pokemonID == 154 || pokemonID == 157 || pokemonID == 163 || pokemonID == 164)
        {
            PokemonImage.setFitHeight(150);
            PokemonImage.setFitWidth(150);
        } else {
            PokemonImage.setFitHeight(0);
            PokemonImage.setFitWidth(0);
        }
        ProgressBar(pokemonID);
        pageCount(pokemonID);
        type2Check(pokemonID);
        genderCheck(pokemonID);
        pokemonEntries(pokemonID);
        megaCheck(pokemonID);
        mega2Check(pokemonID);
        ability2Check(pokemonID);
        ability3Check(pokemonID);
        statusLabel.setVisible(false);
        statusLabel2.setVisible(false);
        statusLabel3.setVisible(false);
    }

    public void pokemonEntries(int PokemonID)
    {
        pokemonEntries.setWrappingWidth(300);
        pokemonEntries.setText(PokemonInfo.getEntries(PokemonID));
    }

    public void pageCount(int pokemonID)
    {
        pokemonCount = PokemonInfo.getID(pokemonID);
    }

    public void getTotal(int PokemonID)
    {
        total.setText("TOTAL: " + (Integer.parseInt(PokemonInfo.getHP(PokemonID)) + Integer.parseInt(PokemonInfo.getATK(PokemonID)) + Integer.parseInt(PokemonInfo.getDEF(PokemonID)) + Integer.parseInt(PokemonInfo.getSPATK(PokemonID)) + Integer.parseInt(PokemonInfo.getSPDEF(PokemonID)) + Integer.parseInt(PokemonInfo.getSPE(PokemonID))));
    }

    public void TypeBoxColor(int PokemonID)
    {
        if (PokemonInfo.getType1(PokemonID).equals("normal"))
        {
            Type1Box.setStyle("-fx-background-color: #aaaa99;");
        } else if (PokemonInfo.getType1(PokemonID).equals("fire"))
        {
            Type1Box.setStyle("-fx-background-color: #ff4422;");
        } else if (PokemonInfo.getType1(PokemonID).equals("water"))
        {
            Type1Box.setStyle("-fx-background-color: #3399ff;");
        } else if (PokemonInfo.getType1(PokemonID).equals("electric"))
        {
            Type1Box.setStyle("-fx-background-color: #ffcc33;");
        } else if (PokemonInfo.getType1(PokemonID).equals("grass"))
        {
            Type1Box.setStyle("-fx-background-color: #77cc55;");
        } else if (PokemonInfo.getType1(PokemonID).equals("ice"))
        {
            Type1Box.setStyle("-fx-background-color: #66ccff;");
        } else if (PokemonInfo.getType1(PokemonID).equals("fight"))
        {
            Type1Box.setStyle("-fx-background-color: #bb5544;");
        } else if (PokemonInfo.getType1(PokemonID).equals("poison"))
        {
            Type1Box.setStyle("-fx-background-color: #aa5599;");
        } else if (PokemonInfo.getType1(PokemonID).equals("ground"))
        {
            Type1Box.setStyle("-fx-background-color: #ddbb55;");
        } else if (PokemonInfo.getType1(PokemonID).equals("flying"))
        {
            Type1Box.setStyle("-fx-background-color: #8899ff;");
        } else if  (PokemonInfo.getType1(PokemonID).equals("psychic"))
        {
            Type1Box.setStyle("-fx-background-color: #ff5599;");
        } else if (PokemonInfo.getType1(PokemonID).equals("bug"))
        {
            Type1Box.setStyle("-fx-background-color: #aabb22;");
        } else if (PokemonInfo.getType1(PokemonID).equals("rock"))
        {
            Type1Box.setStyle("-fx-background-color: #bbaa66;");
        } else if (PokemonInfo.getType1(PokemonID).equals("ghost"))
        {
            Type1Box.setStyle("-fx-background-color: #6666bb;");
        } else if (PokemonInfo.getType1(PokemonID).equals("dragon"))
        {
            Type1Box.setStyle("-fx-background-color: #7766ee;");
        } else if  (PokemonInfo.getType1(PokemonID).equals("dark"))
        {
            Type1Box.setStyle("-fx-background-color: #775544;");
        } else if (PokemonInfo.getType1(PokemonID).equals("steel"))
        {
            Type1Box.setStyle("-fx-background-color: #aaaabb;");
        } else if (PokemonInfo.getType1(PokemonID).equals("fairy"))
        {
            Type1Box.setStyle("-fx-background-color: #ee99ee;");
        }

        if (PokemonInfo.getType2(PokemonID).equals("normal"))
        {
            Type2Box.setStyle("-fx-background-color: #aaaa99;");
        } else if (PokemonInfo.getType2(PokemonID).equals("fire"))
        {
            Type2Box.setStyle("-fx-background-color: #ff4422;");
        } else if (PokemonInfo.getType2(PokemonID).equals("water"))
        {
            Type2Box.setStyle("-fx-background-color: #3399ff;");
        } else if (PokemonInfo.getType2(PokemonID).equals("electric"))
        {
            Type2Box.setStyle("-fx-background-color: #ffcc33;");
        } else if (PokemonInfo.getType2(PokemonID).equals("grass"))
        {
            Type2Box.setStyle("-fx-background-color: #77cc55;");
        } else if (PokemonInfo.getType2(PokemonID).equals("ice"))
        {
            Type2Box.setStyle("-fx-background-color: #66ccff;");
        } else if (PokemonInfo.getType2(PokemonID).equals("fight"))
        {
            Type2Box.setStyle("-fx-background-color: #bb5544;");
        } else if (PokemonInfo.getType2(PokemonID).equals("poison"))
        {
            Type2Box.setStyle("-fx-background-color: #aa5599;");
        } else if (PokemonInfo.getType2(PokemonID).equals("ground"))
        {
            Type2Box.setStyle("-fx-background-color: #ddbb55;");
        } else if (PokemonInfo.getType2(PokemonID).equals("flying"))
        {
            Type2Box.setStyle("-fx-background-color: #8899ff;");
        } else if  (PokemonInfo.getType2(PokemonID).equals("psychic"))
        {
            Type2Box.setStyle("-fx-background-color: #ff5599;");
        } else if (PokemonInfo.getType2(PokemonID).equals("bug"))
        {
            Type2Box.setStyle("-fx-background-color: #aabb22;");
        } else if (PokemonInfo.getType2(PokemonID).equals("rock"))
        {
            Type2Box.setStyle("-fx-background-color: #bbaa66;");
        } else if (PokemonInfo.getType2(PokemonID).equals("ghost"))
        {
            Type2Box.setStyle("-fx-background-color: #6666bb;");
        } else if (PokemonInfo.getType2(PokemonID).equals("dragon"))
        {
            Type2Box.setStyle("-fx-background-color: #7766ee;");
        } else if  (PokemonInfo.getType2(PokemonID).equals("dark"))
        {
            Type2Box.setStyle("-fx-background-color: #775544;");
        } else if (PokemonInfo.getType2(PokemonID).equals("steel"))
        {
            Type2Box.setStyle("-fx-background-color: #aaaabb;");
        } else if (PokemonInfo.getType2(PokemonID).equals("fairy"))
        {
            Type2Box.setStyle("-fx-background-color: #ee99ee;");
        }
    }

    public void ProgressBar(int PokemonID)
    {
        double maxhp = 250;
        double maxatk = 250;
        double maxdef = 250;
        double maxspatk = 250;
        double maxspdef = 250;
        double maxspe = 250;

        double HPProgress = Double.parseDouble(PokemonInfo.getHP(PokemonID)) / maxhp;
        double ATKProgress = Double.parseDouble(PokemonInfo.getATK(PokemonID)) / maxatk;
        double DEFProgress = Double.parseDouble(PokemonInfo.getDEF(PokemonID)) / maxdef;
        double SPATKProgress = Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) / maxspatk;
        double SPDEFProgress = Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) / maxspdef;
        double SPEProgress = Double.parseDouble(PokemonInfo.getSPE(PokemonID)) / maxspe;

        HPBar.setProgress(HPProgress);
        AtkBar.setProgress(ATKProgress);
        DefBar.setProgress(DEFProgress);
        SpAtkBar.setProgress(SPATKProgress);
        SpDefBar.setProgress(SPDEFProgress);
        SpeBar.setProgress(SPEProgress);

        if (Double.parseDouble(PokemonInfo.getHP(PokemonID)) <= 29)
        {
            HPBar.setStyle("-fx-accent: #f04242");
        } else if (Double.parseDouble(PokemonInfo.getHP(PokemonID)) >= 30 && Double.parseDouble(PokemonInfo.getHP(PokemonID)) <= 59)
        {
            HPBar.setStyle("-fx-accent: #fe7e12");
        } else if (Double.parseDouble(PokemonInfo.getHP(PokemonID)) >= 60 && Double.parseDouble(PokemonInfo.getHP(PokemonID)) <= 89)
        {
            HPBar.setStyle("-fx-accent: #fedd58");
        } else if (Double.parseDouble(PokemonInfo.getHP(PokemonID)) >= 90 && Double.parseDouble(PokemonInfo.getHP(PokemonID)) <= 119)
        {
            HPBar.setStyle("-fx-accent: #9ddc1c");
        } else if (Double.parseDouble(PokemonInfo.getHP(PokemonID)) >= 120 && Double.parseDouble(PokemonInfo.getHP(PokemonID)) <= 149)
        {
            HPBar.setStyle("-fx-accent: #21cc5f");
        } else if (Double.parseDouble(PokemonInfo.getHP(PokemonID)) >= 150)
        {
            HPBar.setStyle("-fx-accent: #02c2b5");
        }

        if (Double.parseDouble(PokemonInfo.getATK(PokemonID)) <= 29)
        {
            AtkBar.setStyle("-fx-accent: #f04242");
        } else if (Double.parseDouble(PokemonInfo.getATK(PokemonID)) >= 30 && Double.parseDouble(PokemonInfo.getATK(PokemonID)) <= 59)
        {
            AtkBar.setStyle("-fx-accent: #fe7e12");
        } else if (Double.parseDouble(PokemonInfo.getATK(PokemonID)) >= 60 && Double.parseDouble(PokemonInfo.getATK(PokemonID)) <= 89)
        {
            AtkBar.setStyle("-fx-accent: #fedd58");
        } else if (Double.parseDouble(PokemonInfo.getATK(PokemonID)) >= 90 && Double.parseDouble(PokemonInfo.getATK(PokemonID)) <= 119)
        {
            AtkBar.setStyle("-fx-accent: #9ddc1c");
        } else if (Double.parseDouble(PokemonInfo.getATK(PokemonID)) >= 120 && Double.parseDouble(PokemonInfo.getATK(PokemonID)) <= 149)
        {
            AtkBar.setStyle("-fx-accent: #21cc5f");
        } else if (Double.parseDouble(PokemonInfo.getATK(PokemonID)) >= 150)
        {
            AtkBar.setStyle("-fx-accent: #02c2b5");
        }

        if (Double.parseDouble(PokemonInfo.getDEF(PokemonID)) <= 29)
        {
            DefBar.setStyle("-fx-accent: #f04242");
        } else if (Double.parseDouble(PokemonInfo.getDEF(PokemonID)) >= 30 && Double.parseDouble(PokemonInfo.getDEF(PokemonID)) <= 59)
        {
            DefBar.setStyle("-fx-accent: #fe7e12");
        } else if (Double.parseDouble(PokemonInfo.getDEF(PokemonID)) >= 60 && Double.parseDouble(PokemonInfo.getDEF(PokemonID)) <= 89)
        {
            DefBar.setStyle("-fx-accent: #fedd58");
        } else if (Double.parseDouble(PokemonInfo.getDEF(PokemonID)) >= 90 && Double.parseDouble(PokemonInfo.getDEF(PokemonID)) <= 119)
        {
            DefBar.setStyle("-fx-accent: #9ddc1c");
        } else if (Double.parseDouble(PokemonInfo.getDEF(PokemonID)) >= 120 && Double.parseDouble(PokemonInfo.getDEF(PokemonID)) <= 149)
        {
            DefBar.setStyle("-fx-accent: #21cc5f");
        } else if (Double.parseDouble(PokemonInfo.getDEF(PokemonID)) >= 150)
        {
            DefBar.setStyle("-fx-accent: #02c2b5");
        }

        if (Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) <= 29)
        {
            SpAtkBar.setStyle("-fx-accent: #f04242");
        } else if (Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) >= 30 && Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) <= 59)
        {
            SpAtkBar.setStyle("-fx-accent: #fe7e12");
        } else if (Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) >= 60 && Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) <= 89)
        {
            SpAtkBar.setStyle("-fx-accent: #fedd58");
        } else if (Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) >= 90 && Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) <= 119)
        {
            SpAtkBar.setStyle("-fx-accent: #9ddc1c");
        } else if (Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) >= 120 && Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) <= 149)
        {
            SpAtkBar.setStyle("-fx-accent: #21cc5f");
        } else if (Double.parseDouble(PokemonInfo.getSPATK(PokemonID)) >= 150)
        {
            SpAtkBar.setStyle("-fx-accent: #02c2b5");
        }

        if (Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) <= 29)
        {
            SpDefBar.setStyle("-fx-accent: #f04242");
        } else if (Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) >= 30 && Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) <= 59)
        {
            SpDefBar.setStyle("-fx-accent: #fe7e12");
        } else if (Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) >= 60 && Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) <= 89)
        {
            SpDefBar.setStyle("-fx-accent: #fedd58");
        } else if (Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) >= 90 && Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) <= 119)
        {
            SpDefBar.setStyle("-fx-accent: #9ddc1c");
        } else if (Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) >= 120 && Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) <= 149)
        {
            SpDefBar.setStyle("-fx-accent: #21cc5f");
        } else if (Double.parseDouble(PokemonInfo.getSPDEF(PokemonID)) >= 150)
        {
            SpDefBar.setStyle("-fx-accent: #02c2b5");
        }

        if (Double.parseDouble(PokemonInfo.getSPE(PokemonID)) <= 29)
        {
            SpeBar.setStyle("-fx-accent: #f04242");
        } else if (Double.parseDouble(PokemonInfo.getSPE(PokemonID)) >= 30 && Double.parseDouble(PokemonInfo.getSPE(PokemonID)) <= 59)
        {
            SpeBar.setStyle("-fx-accent: #fe7e12");
        } else if (Double.parseDouble(PokemonInfo.getSPE(PokemonID)) >= 60 && Double.parseDouble(PokemonInfo.getSPE(PokemonID)) <= 89)
        {
            SpeBar.setStyle("-fx-accent: #fedd58");
        } else if (Double.parseDouble(PokemonInfo.getSPE(PokemonID)) >= 90 && Double.parseDouble(PokemonInfo.getSPE(PokemonID)) <= 119)
        {
            SpeBar.setStyle("-fx-accent: #9ddc1c");
        } else if (Double.parseDouble(PokemonInfo.getSPE(PokemonID)) >= 120 && Double.parseDouble(PokemonInfo.getSPE(PokemonID)) <= 149)
        {
            SpeBar.setStyle("-fx-accent: #21cc5f");
        } else if (Double.parseDouble(PokemonInfo.getSPE(PokemonID)) >= 150)
        {
            SpeBar.setStyle("-fx-accent: #02c2b5");
        }
    }

    @FXML
    private void handleGoBack(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleBack(ActionEvent event)
    {
        hasGender = false;
        hasMega1 = false;
        hasMega2 = false;
        genderToggle.setSelected(false);
        switch(pokemonCount)
        {
            case 152:
                pokemonCount = 3;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 153:
                if (mega1Toggle.isSelected() == true && mega2Toggle.isSelected() == false)
                {
                    pokemonCount = 6;
                }
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 155:
                pokemonCount = 9;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 156:
                pokemonCount = 15;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 157:
                pokemonCount = 18;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 158:
                pokemonCount = 65;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 159:
                pokemonCount = 80;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 160:
                pokemonCount = 94;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 161:
                pokemonCount = 115;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 162:
                pokemonCount = 127;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 163:
                pokemonCount = 130;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 164:
                pokemonCount = 142;
                pokemonCount--;
                openData(PokemonInfo.getID(pokemonCount));
                break;
        }
        if (pokemonCount > 1 && mega1Toggle.isSelected() == false)
        {
            pokemonCount--;
            openData(pokemonCount);
        }
        if (hasGender == true)
        {
            genderToggle.setText("Gender: ♀");
        } else {
            genderToggle.setText("Gender: ♂");
        }
    }

    @FXML
    private void handleNext(ActionEvent event)
    {
        hasGender = false;
        hasMega1 = false;
        hasMega2 = false;
        genderToggle.setSelected(false);
        if (pokemonCount < 151)
        {
            pokemonCount++;
            openData(pokemonCount);
        }
        if (hasGender == true)
        {
            genderToggle.setText("Gender: ♀");
        } else {
            genderToggle.setText("Gender: ♂");
        }
    }

    @FXML
    private void type2Check(int pokemonID)
    {
        if (PokemonInfo.getType2(pokemonID).equals("null"))
        {
            Type2Box.setVisible(false);
        } else {
            Type2Box.setVisible(true);
        }
    }

    @FXML
    private void genderCheck(int pokemonID)
    {
        if (PokemonInfo.getGender(pokemonID).equals("FALSE"))
        {
            genderToggle.setVisible(false);
        } else {
            genderToggle.setVisible(true);
        }
    }

    @FXML
    private void megaCheck(int pokemonID)
    {
        if (PokemonInfo.getMega(pokemonID).equals("FALSE"))
        {
            mega1Toggle.setVisible(false);
            mega1Toggle.setText("Mega");
        } else {
            mega1Toggle.setVisible(true);
            if ((PokemonInfo.getMega2(pokemonID).equals("TRUE")))
            {
                mega1Toggle.setText("Mega X");
            }
        }
    }

    @FXML
    private void mega2Check(int pokemonID)
    {
        if (PokemonInfo.getMega2(pokemonID).equals("FALSE"))
        {
            mega2Toggle.setVisible(false);
            mega2Toggle.setText("Mega");
        } else {
            mega2Toggle.setVisible(true);
            mega2Toggle.setText("Mega Y");
        }
    }

    @FXML
    private void ability2Check(int pokemonID)
    {
        if (PokemonInfo.getAbility2(pokemonID).equals("null"))
        {
            PokemonAbility2.setVisible(false);
        } else {
            PokemonAbility2.setVisible(true);
        }
    }

    @FXML
    private void ability3Check(int pokemonID)
    {
        if (PokemonInfo.getAbility3(pokemonID).equals("null"))
        {
            PokemonAbility3.setVisible(false);
        } else {
            PokemonAbility3.setVisible(true);
        }
    }

    @FXML
    void handleMouseEntered(MouseEvent event) throws IOException
    {
        statusLabel.setText(PokemonInfo.getAbilityInfo(PokemonInfo.getAbility(pokemonCount)));
        statusLabel.setVisible(true);
    }

    @FXML
    void handleMouseExited(MouseEvent event)
    {
        statusLabel.setVisible(false);
    }

    @FXML
    void handleMouseEntered2(MouseEvent event) throws IOException
    {
        statusLabel2.setText(PokemonInfo.getAbilityInfo(PokemonInfo.getAbility2(pokemonCount)));
        statusLabel2.setVisible(true);
    }

    @FXML
    void handleMouseExited2(MouseEvent event)
    {
        statusLabel2.setVisible(false);
    }

    @FXML
    void handleMouseEntered3(MouseEvent event) throws IOException
    {
        statusLabel3.setText(PokemonInfo.getAbilityInfo(PokemonInfo.getAbility3(pokemonCount)));
        statusLabel3.setVisible(true);
    }

    @FXML
    void handleMouseExited3(MouseEvent event)
    {
        statusLabel3.setVisible(false);
    }

    @FXML
    protected void OnShinyClick()
    {
        isShiny = shinyToggle.isSelected();
        openData(PokemonInfo.getID(pokemonCount));
    }

    @FXML
    protected void OnGenderClick()
    {
        hasGender = genderToggle.isSelected();
        if (hasGender == true)
        {
            genderToggle.setText("Gender: ♀");
        } else {
            genderToggle.setText("Gender: ♂");
        }
        openData(PokemonInfo.getID(pokemonCount));
    }

    @FXML
    protected void OnMegaClick()
    {
        mega2Toggle.setSelected(false);
        hasMega1 = mega1Toggle.isSelected();
        if (mega1Toggle.isSelected() == true)
        {
            switch(pokemonCount)
            {
                case 3:
                    pokemonCount = 152;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 6:
                    if (mega1Toggle.isSelected() == true && mega2Toggle.isSelected() == false)
                    {
                        pokemonCount = 153;
                    }
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 9:
                    pokemonCount = 155;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 15:
                    pokemonCount = 156;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 18:
                    pokemonCount = 157;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 65:
                    pokemonCount = 158;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 80:
                    pokemonCount = 159;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 94:
                    pokemonCount = 160;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 115:
                    pokemonCount = 161;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 127:
                    pokemonCount = 162;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 130:
                    pokemonCount = 163;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 142:
                    pokemonCount = 164;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 150:
                    if (mega1Toggle.isSelected() == true && mega2Toggle.isSelected() == false)
                    {
                        pokemonCount = 165;
                    }
                    openData(PokemonInfo.getID(pokemonCount));
                    break;
            }
        }
        if (mega1Toggle.isSelected() == false)
        {
            switch(pokemonCount)
            {
                case 152:
                    pokemonCount = 3;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 153:
                    if (mega1Toggle.isSelected() == true && mega2Toggle.isSelected() == false)
                    {
                        pokemonCount = 3;
                    }
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 155:
                    pokemonCount = 9;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 156:
                    pokemonCount = 15;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 157:
                    pokemonCount = 18;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 158:
                    pokemonCount = 65;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 159:
                    pokemonCount = 80;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 160:
                    pokemonCount = 94;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 161:
                    pokemonCount = 115;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 162:
                    pokemonCount = 127;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 163:
                    pokemonCount = 130;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 164:
                    pokemonCount = 142;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 165:
                    pokemonCount = 150;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;
            }
        }
        //openData(PokemonInfo.getID(pokemonCount));
    }

    @FXML
    protected void OnMega2Click() {
        mega1Toggle.setSelected(false);
        hasMega2 = mega2Toggle.isSelected();
        switch (pokemonCount) {
            case 6:
                if (mega1Toggle.isSelected() == false && mega2Toggle.isSelected() == true) {
                    pokemonCount = 154;
                }
                openData(PokemonInfo.getID(pokemonCount));
                break;

            case 150:
                if (mega1Toggle.isSelected() == false && mega2Toggle.isSelected() == true) {
                    pokemonCount = 165;
                }
                openData(PokemonInfo.getID(pokemonCount));
                break;
        }
        if (mega2Toggle.isSelected() == false) {
            switch (pokemonCount) {
                case 154:
                    pokemonCount = 6;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;

                case 165:
                    pokemonCount = 150;
                    openData(PokemonInfo.getID(pokemonCount));
                    break;
            }
            //openData(PokemonInfo.getID(pokemonCount));
        }
    }
}