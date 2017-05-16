package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Game 
{  
    @Min(4)
    @Max(8)
    @NotNull
    private Integer number = DEFAULT_NUMBER;
    
    private static final int DEFAULT_NUMBER = 6;
    
    private static final String BOMB = "bomb";
    private static final String OK = "ok";
    private static final String NOT_PLAYED = "?";
    
    private Random random = new Random();

    private String[] value;
    
    private String[] showValue;
    
    private boolean win, lost;
    
    public void startGame()
    {
        //Deze methode roep je in de controller op
        //nadat de gebruiker een geldige number
        //heeft ingegeven (bij de start van het spel)
        
        value = new String[number];
        showValue = new String[number];
        fillValues();
        fillShowValues();
    }
    
    private void fillValues()
    {  //de array wordt opgevuld met OKs en ��n bom
        Arrays.fill(value, OK);

        int index = random.nextInt(number);
        value[index] = BOMB;
    }
    
    private void fillShowValues()
    {
        //De array wordt opgevuld met ? 
        //Deze array dien je tonen op het scherm
        Arrays.fill(showValue, NOT_PLAYED);
    }
    
    public void play(int i)
    {    
        //Deze methode dien je op te roepen in de 
        //controller als de gebruiker een vraagteken
        //heeft geselecteerd 
        //(i = index van het geselecteerde vraagteken)
        
        //indien de gebruiker is verloren dan wordt lost op true geplaatst.
        //indien de gebruiker is gewonnen dan wordt win op true geplaatst.
        showValue[i] = value[i];
        lost = lost(i);
        if (!lost)
            win = win();
    }
    
    private boolean lost(int index)
    {  //gaat na of de gebruiker verloren is?
        return (value[index].equals(BOMB));
    }
    
    private boolean win()
    {
        //gaat na of de gebruiker gewonnen is?
        List<String> showValueList = new ArrayList<>(Arrays.asList(showValue));
        showValueList.remove(NOT_PLAYED);
        if (showValueList.contains(BOMB) || showValueList.contains(NOT_PLAYED))
            return false;
        
        return true;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isLost() {
        return lost;
    }

    public String[] getShowValue() {
        return showValue;
    }
    
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}