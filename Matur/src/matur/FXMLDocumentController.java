/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeString.substring;

public class FXMLDocumentController implements Initializable
{
    
    @FXML private Label pinLabel1;
    @FXML private Label pinLabel2;
    @FXML private RadioButton binvstup;
    @FXML private RadioButton binvystup;
    @FXML private RadioButton desetvstup;
    @FXML private RadioButton desetvystup;
    @FXML private RadioButton hexvstup;
    @FXML private RadioButton hexvystup;
    @FXML private RadioButton octvstup;
    @FXML private RadioButton octvystup;
    @FXML private Button button0;
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;
    @FXML private Button button6;
    @FXML private Button button7;
    @FXML private Button button8;
    @FXML private Button button9;
    @FXML private Button buttonA;
    @FXML private Button buttonB;
    @FXML private Button buttonClean;
    @FXML private Button buttonC;
    @FXML private Button buttonD;
    @FXML private Button buttonE;
    @FXML private Button buttonF;
    @FXML private Button carka;
    @FXML private Button tecka;
    @FXML private Button buttonplus;
    @FXML private Button buttonminus;
    @FXML private Button buttonkrat;
    @FXML private Button buttondeleno;
    int soustava1 = 0;
    int soustava2 = 0;
    int soustavavystup = 0;
    
    @FXML
     public static String convertFromDecimaldes(int base, String number1) {
           double number = Double.valueOf("0."+number1); 
            String result = "";
            int pocitadlo = 0;
            while(number != 0){
            int remainder = (int) (number * base); //zjisteni zbytku (hodnoty na odpovidajici pozici)
            
            if(remainder == 10){
                    String numeral = "A";
                    result += numeral;
                }
            else if(remainder == 11){
                   String numeral = "B";
                   result += numeral;
            }
             else if(remainder == 12){
                   String numeral = "C";
                   result += numeral;
                }
             else if(remainder == 13){
                   String numeral = "D";
                   result += numeral;
                }
             else if(remainder == 14){
                   String numeral = "E";
                   result += numeral;
                }
             else if(remainder == 15){
                   String numeral = "F";
                   result += numeral;
                }
             else{
            
            result += String.valueOf(remainder) ;
             }
            number = (number * base) - remainder;
            
            pocitadlo++;
            if(pocitadlo ==8) break;
            }
            if (result =="") result="0";
            return result;
            }
  
    
    @FXML
    public static String convertFromDecimal(int base, String number1) {
           int number = Integer.decode(number1);
           String pom = "";
            String result = "";
            while(number != 0){
            int remainder = number % base; //zjisteni zbytku (hodnoty na odpovidajici pozici)
            
            if(remainder == 10){
                    String numeral = "A";
                    result += numeral;
                }
            else if(remainder == 11){
                   String numeral = "B";
                   result += numeral;
            }
             else if(remainder == 12){
                   String numeral = "C";
                   result += numeral;
                }
             else if(remainder == 13){
                   String numeral = "D";
                   result += numeral;
                }
             else if(remainder == 14){
                   String numeral = "E";
                   result += numeral;
                }
             else if(remainder == 15){
                   String numeral = "F";
                   result += numeral;
                }
             else{
            
            result += String.valueOf(remainder) ;
             }
            number = number / base; //posun o pozici dal
            }
            String[] ary = result.split("");
            for (int i = result.length() - 1; i >= 0; i--) {
                pom += ary[i];
            }
            
            return pom;
            }
  
    
    @FXML
    public  static int convertTobase(int base, String number) 
    {
       if (base == 16){
           //String[] ary = number.split("");
            int result = 0; 
            int position = 0; 
            int numeral = 0;
          
            for(int i = number.length()-1; i>-1; i--){
                if(number.charAt(i) == 'A'){
                    numeral = 10;
                    result += numeral * Math.pow(base, position);
                position++;
                }
                else if(number.charAt(i) == 'B'){
                    numeral = 11;
                    result += numeral * Math.pow(base, position);
                position++;
                }
                else if(number.charAt(i) == 'C'){
                    numeral = 12;
                    result += numeral * Math.pow(base, position);
                position++;
                }
                else if(number.charAt(i) == 'D'){
                    numeral = 13;
                    result += numeral * Math.pow(base, position);
                position++;
                }
                else if(number.charAt(i) == 'E'){
                    numeral = 14;
                    result += numeral * Math.pow(base, position);
                position++;
                }
                else if(number.charAt(i) == 'F'){
                    numeral = 15;
                    result += numeral * Math.pow(base, position);
                position++;
                }
                else {
                
                numeral = Character.getNumericValue(number.charAt(i));
                result += numeral * Math.pow(base, position);
                position++;
                }
                
            }
           return result;   
       }
       else{
        //String[] ary = number.split("");
        int result = 0; 
        int position = 0; 
        int numeral = 0;
        
        for(int i = number.length()-1; i>=0; i--){
           
        numeral = Character.getNumericValue(number.charAt(i));
       
        result += numeral * Math.pow(base, position);
        position++;
        }
        return result; 
       }
    }
    
     @FXML
    public  static double convertTodecaddes(int base, String number) 
    {
       if (base == 16){
          // String[] ary = number.split("");
       //double
        double result = 0; 
        int position = -1; 
        int numeral = 0;
        
        for(int i = 0; number.length() > i; i++){
                if(number.charAt(i) == 'A'){
                    numeral = 10;
                    result += numeral * Math.pow(base, position);
                position--;
                }
                else if(number.charAt(i) == 'B'){
                    numeral = 11;
                    result += numeral * Math.pow(base, position);
                position--;
                }
                else if(number.charAt(i) == 'C'){
                    numeral = 12;
                    result += numeral * Math.pow(base, position);
                position--;
                }
                else if(number.charAt(i) == 'D'){
                    numeral = 13;
                    result += numeral * Math.pow(base, position);
                position--;
                }
                else if(number.charAt(i) == 'E'){
                    numeral = 14;
                    result += numeral * Math.pow(base, position);
                position--;
                }
                else if(number.charAt(i) == 'F'){
                    numeral = 15;
                    result += numeral * Math.pow(base, position);
                position--;                    
                }  
                else {
                
                numeral = Character.getNumericValue(number.charAt(i));
                result += numeral * Math.pow(base, position);
                position--;
                }
            }
        return result; 
       
       }
       else{
       // String[] ary = number.split("");
       //double
        double result = 0; 
        int position = -1; 
        int numeral = 0;
        
        for(int i = 0; number.length() > i; i++){
           
         numeral = Character.getNumericValue(number.charAt(i));
         result += numeral * Math.pow(base, position);
         position--;
        }
       return result; 
    }
        
       
    }
    
     @FXML
    private void desetineCislo(ActionEvent event)
    {
         /* switch () {
            case 1:  ;
                     break;
           
            default: ;
                     break;
        }*/
        
      /*   float soucet = hodnota1f + hodnota2f;
       String vvv = String.valueOf(soucet);
       String vvvv = String.valueOf((int)soucet);
       int d = vvv.length();
       int dd = vvvv.length();
        String hod = vvv.substring((d-dd)+1 ,d);
        
        int o=0;
        String hod = "656";
        String[] ary = hod.split("");
        for(int i = 0 ; i <= 2; i++){
            double p = Double.valueOf(ary[i]);
            double pom = Math.pow(p, o-1);
        }*/
    }
    
    @FXML
    private void stisk(ActionEvent event)
    { 
      if(binvstup.isSelected()){
          
        
        }
       
      String pomocna = pinLabel1.getText();
      pinLabel2.setText(pinLabel1.getText()); 
      pinLabel1.setText("");
    }
     
   

   @FXML
    private void plus2()
    {  
      String pomoc2 = "0";
      String pomoc = "0";
      String hodnota2 = pinLabel2.getText().substring(0,pinLabel2.getText().length()-1);
      String hodnota1 = pinLabel1.getText();
      String[] parts2 = hodnota2.split(Pattern.quote("."));
      String[] parts1 = hodnota1.split(Pattern.quote("."));
      if(parts2.length == 2){
           pomoc2 = parts2[1];
      }
      if(parts1.length == 2){
           pomoc = parts1[1];
      }
      
      double popp = convertTobase(soustava1 , parts2[0])+ convertTodecaddes(soustava1, pomoc2);    
      double poppp = convertTobase(soustava2 , parts1[0])+convertTodecaddes(soustava2, pomoc);
      String pom1 = poppp + "";  
      String pom2 = popp + "";
      
      double i = Double.parseDouble(pom1);
      double i2 = Double.parseDouble(pom2);
      double ii = i2+i;
      String pop = String.valueOf(ii);
      //String[] poo = pop.split(".");
      String[] part = pop.split(Pattern.quote("."));      
      pinLabel2.setText("");
      String vystup = convertFromDecimal(soustavavystup, part[0]);
      String vystupdes = convertFromDecimaldes(soustavavystup, part[1]);
      pinLabel1.setText("" + vystup+"."+ vystupdes);
      soustava1 = 0;
      soustava2 = 0;
    
    //  convertTobase(soustava1 , hodnota2);
     // convertTodecaddes(soustava2, hodnota1);
   // convertFromDecimal(8, parts[0]);
  // convertFromDecimaldes(16,parts[1]);
    }
    
    @FXML
    private void minus2()
    {   
      String pomoc2 = "0";
      String pomoc = "0";
      String hodnota2 = pinLabel2.getText().substring(0,pinLabel2.getText().length()-1);
      String hodnota1 = pinLabel1.getText();
      String[] parts2 = hodnota2.split(Pattern.quote("."));
      String[] parts1 = hodnota1.split(Pattern.quote("."));
       if(parts2.length == 2){
           pomoc2 = parts2[1];
      }
      if(parts1.length == 2){
           pomoc = parts1[1];
      }
      
      double popp = convertTobase(soustava1 , parts2[0])+ convertTodecaddes(soustava1, pomoc2);    
      double poppp = convertTobase(soustava2 , parts1[0])+convertTodecaddes(soustava2, pomoc);
      String pom1 = poppp+"";
      String pom2 = popp+"";
      
      double i = Double.parseDouble(pom1);
      double i2 = Double.parseDouble(pom2);
      double ii = i2-i;
      String pop = String.valueOf(ii);
      //String[] poo = pop.split(".");
      String[] parts = pop.split(Pattern.quote("."));      
      pinLabel2.setText("");
      pinLabel1.setText("" + parts[0]+"."+parts[1]);
      soustava1 = 0;
      soustava2 = 0;
    }
    
       @FXML
    private void krat2()
    { 
      String pomoc2 = "0";
      String pomoc = "0";
      String hodnota2 = pinLabel2.getText().substring(0,pinLabel2.getText().length()-1);
      String hodnota1 = pinLabel1.getText();
      String[] parts2 = hodnota2.split(Pattern.quote("."));
      String[] parts1 = hodnota1.split(Pattern.quote("."));
       if(parts2.length == 2){
           pomoc2 = parts2[1];
      }
      if(parts1.length == 2){
           pomoc = parts1[1];
      }
      
      double popp = convertTobase(soustava1 , parts2[0])+ convertTodecaddes(soustava1, pomoc2);    
      double poppp = convertTobase(soustava2 , parts1[0])+convertTodecaddes(soustava2, pomoc);
      String pom1 = popp+"";
      String pom2 = poppp+"";
      
      double i = Double.parseDouble(pom1);
      double i2 = Double.parseDouble(pom2);
      double ii = i2*i;
      String pop = String.valueOf(ii);
      //String[] poo = pop.split(".");
      String[] parts = pop.split(Pattern.quote("."));      
      pinLabel2.setText("");
      pinLabel1.setText("" + parts[0]+"."+parts[1]);
      soustava1 = 0;
      soustava2 = 0;
    }
    
       @FXML
    private void deleno2()
    { 
      String pomoc2 = "0";
      String pomoc = "0";
      String hodnota2 = pinLabel2.getText().substring(0,pinLabel2.getText().length()-1);
      String hodnota1 = pinLabel1.getText();
      String[] parts2 = hodnota2.split(Pattern.quote("."));
      String[] parts1 = hodnota1.split(Pattern.quote("."));
      if(parts2.length == 2){
           pomoc2 = parts2[1];
      }
      if(parts1.length == 2){
           pomoc = parts1[1];
      }
      
      double popp = convertTobase(soustava1 , parts2[0])+ convertTodecaddes(soustava1, pomoc2);    
      double poppp = convertTobase(soustava2 , parts1[0])+convertTodecaddes(soustava2, pomoc);
      String pom1 = poppp+"";
      String pom2 = popp+"";
      
      double i = Double.parseDouble(pom1);
      double i2 = Double.parseDouble(pom2);
      double ii = i2/i;
      String pop = String.valueOf(ii);
      //String[] poo = pop.split(".");
      String[] parts = pop.split(Pattern.quote("."));      
      pinLabel2.setText("");
      pinLabel1.setText("" + parts[0]+"."+parts[1]);
      soustava1 = 0;
      soustava2 = 0;
    }
    
     @FXML
    private void rovnase(ActionEvent event)
    {
      int znamenkoindex = pinLabel2.getText().length();
      String znamenko = pinLabel2.getText().substring(znamenkoindex-1, znamenkoindex);
      
        if(binvstup.isSelected()){
             soustava2 = 2;
        }
          if(desetvstup.isSelected()){
             soustava2 = 10;
        }
           if(hexvstup.isSelected()){
             soustava2 = 16;
        }
            if(octvstup.isSelected()){
             soustava2 = 8;
        }
            if(binvystup.isSelected()){
             soustavavystup = 2;
        }
          if(desetvystup.isSelected()){
             soustavavystup = 10;
        }
           if(hexvystup.isSelected()){
             soustavavystup = 16;
        }
            if(octvystup.isSelected()){
             soustavavystup = 8;
        }
       switch (znamenko) {
            case "+": plus2();
                     break;
            case "-": minus2();
                     break;
            case "*": krat2();
                     break;
            case "/": deleno2();
                     break;
           
            default: 
                     break;
                         }
   
    /*  
      double i = Double.parseDouble(hodnota1);
      double i2 = Double.parseDouble(hodnota2);
      double ii = i+i2;
      String pop = String.valueOf(ii);
      //String[] poo = pop.split(".");
      String[] parts = pop.split(Pattern.quote("."));
     
        
     /*
      String vvv = String.valueOf(soucet);
       String vvvv = String.valueOf((int)soucet);
       
       int d = vvv.length();
       int dd = vvvv.length();
       String v = Integer.toBinaryString((int)soucet);
       
       String hod = vvv.substring((d-dd)+1 ,d);  
      
      
      pinLabel2.setText("");
      pinLabel1.setText("" + parts[0]+"ahoj"+parts[1] + znamenko);
    */
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        button0.setOnAction(e -> buttonClick("0"));
        button1.setOnAction(e -> buttonClick("1"));
        button2.setOnAction(e -> buttonClick("2"));
        button3.setOnAction(e -> buttonClick("3"));
        button4.setOnAction(e -> buttonClick("4"));
        button5.setOnAction(e -> buttonClick("5"));
        button6.setOnAction(e -> buttonClick("6"));
        button7.setOnAction(e -> buttonClick("7"));
        button8.setOnAction(e -> buttonClick("8"));
        button9.setOnAction(e -> buttonClick("9"));
        buttonA.setOnAction(e -> buttonClick("A"));
        buttonB.setOnAction(e -> buttonClick("B"));
        buttonClean.setOnAction(e -> buttonClick("Clean"));
        buttonD.setOnAction(e -> buttonClick("D"));
        buttonE.setOnAction(e -> buttonClick("E"));
        buttonF.setOnAction(e -> buttonClick("F"));
      
    }
    
    @FXML
    public void buttonClick(String value)
    {
        if(value == "Clean") pinLabel1.setText("");
        else pinLabel1.setText(pinLabel1.getText() + value);
    }
    
     @FXML
    public void tecka(ActionEvent event)
    {
        if(pinLabel1.getText().indexOf(".") > 1) 
        {
        
        }
        else pinLabel1.setText(pinLabel1.getText() + ".");
    }
    
      @FXML
    public void plus(ActionEvent event)
    {
        if(pinLabel1.getText().indexOf("+") > 1) 
        {
        
        }
        else pinLabel1.setText(pinLabel1.getText() + "+");
        
         if(binvstup.isSelected()){
             soustava1 = 2;
        }
          if(desetvstup.isSelected()){
             soustava1 = 10;
        }
           if(hexvstup.isSelected()){
             soustava1 = 16;
        }
            if(octvstup.isSelected()){
             soustava1 = 8;
        }
       
      String pomocna = pinLabel1.getText();
      pinLabel2.setText(pinLabel1.getText()); 
       if(pinLabel1.getText().length()>0)
      {
            pinLabel1.setText("");
      }
    }
    
      @FXML
    public void minus(ActionEvent event)
    {
        if(pinLabel1.getText().indexOf("-") > 1) 
        {
        
        }
        else pinLabel1.setText(pinLabel1.getText() + "-");
       if(binvstup.isSelected()){
             soustava1 = 2;
        }
          if(desetvstup.isSelected()){
             soustava1 = 10;
        }
           if(hexvstup.isSelected()){
             soustava1 = 16;
        }
            if(octvstup.isSelected()){
             soustava1 = 8;
        }
       
      String pomocna = pinLabel1.getText();
      pinLabel2.setText(pinLabel1.getText()); 
       if(pinLabel1.getText().length()>0)
      {
            pinLabel1.setText("");
      }
    } 
    @FXML
    public void krat (ActionEvent event)
    {
        if(pinLabel1.getText().indexOf("*") > 1) 
        {
        
        }
        else pinLabel1.setText(pinLabel1.getText() + "*");
         if(binvstup.isSelected()){
             soustava1 = 2;
        }
          if(desetvstup.isSelected()){
             soustava1 = 10;
        }
           if(hexvstup.isSelected()){
             soustava1 = 16;
        }
            if(octvstup.isSelected()){
             soustava1 = 8;
        }
       
      String pomocna = pinLabel1.getText();
      pinLabel2.setText(pinLabel1.getText()); 
      if(pinLabel1.getText().length()>0)
      {
            pinLabel1.setText("");
      }
    }
      @FXML
    public void deleno (ActionEvent event)
    {
        if(pinLabel1.getText().indexOf("/") > 1) 
        {
        
        }
        else pinLabel1.setText(pinLabel1.getText() + "/");
         if(binvstup.isSelected()){
             soustava1 = 2;
        }
          if(desetvstup.isSelected()){
             soustava1 = 10;
        }
           if(hexvstup.isSelected()){
             soustava1 = 16;
        }
            if(octvstup.isSelected()){
             soustava1 = 8;
        }
       
      String pomocna = pinLabel1.getText();
      pinLabel2.setText(pinLabel1.getText()); 
       if(pinLabel1.getText().length()>0)
      {
            pinLabel1.setText("");
      }
    }
    
     @FXML
    public void buttonClick2(ActionEvent event)
    {  
        int pocet = pinLabel1.getText().length();
        if (pocet == 0){
            pinLabel1.setText("");
        }
        else{
            pinLabel1.setText(pinLabel1.getText().substring(0,pocet-1));
        }
    }

   
    
}