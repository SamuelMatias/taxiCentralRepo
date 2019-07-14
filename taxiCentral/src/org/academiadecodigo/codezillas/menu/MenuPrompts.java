package org.academiadecodigo.codezillas.menu;

//TODO: Implement Prompt-view menus and inputs here
//TODO (associated logic can be put in adjacent class MenuLogic if the methods become too large)
//TODO This class will need to "know" the main logic handler class in order to interact

//Symbolic "login" menu and "Request taxi" menus

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.codezillas.tripManager.Location;

import java.io.InputStream;
import java.io.PrintStream;


public class MenuPrompts {

    private InputStream inputStream;
    private PrintStream printStream;
    private Prompt prompt;
    private String name;

    public MenuPrompts(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
        prompt = new Prompt(inputStream, printStream);
    }

    public int login() {
        printStream.println(MenuAssets.LINE);
        printStream.println(MenuAssets.WELCOME);

        MenuInputScanner scanner = new MenuInputScanner(MenuAssets.OPTIONSLOGIN);
        scanner.setMessage("Choose an option");
        printStream.println(" ");
        return prompt.getUserInput(scanner);

    }

    public String clientName() {
        printStream.println(MenuAssets.LINE);
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("Name: ");
        name = prompt.getUserInput(scanner);
        return name;

    }

    public int passengerNumber() {
        printStream.println(MenuAssets.LINE);
        IntegerRangeInputScanner inputScanner = new IntegerRangeInputScanner(1, 4);
        inputScanner.setMessage("Passengers number: ");
        return prompt.getUserInput(inputScanner);

    }

    public int clientMenu() {
        printStream.println(" ");
        printStream.println(MenuAssets.LINE);
        printStream.println(MenuAssets.PROFILE + " " + name);

        MenuInputScanner scanner = new MenuInputScanner(MenuAssets.OPTIONSPROFILE);
        scanner.setMessage("Choose an option");
        printStream.println(" ");
        return prompt.getUserInput(scanner);
    }

    public double amountToDeposit() {
        printStream.println(" ");
        printStream.println(MenuAssets.LINE);
        printStream.println(MenuAssets.AMOUNT);

        DoubleInputScanner scanner = new DoubleInputScanner();

        return prompt.getUserInput(scanner);

    }

    public Location askLocation(String option) {

        printStream.println(" ");
        printStream.println(MenuAssets.LINE);
        MenuInputScanner scanner = new MenuInputScanner(MenuAssets.LOCATIONS);
        scanner.setMessage("Choose your " + option);
        return Location.values()[prompt.getUserInput(scanner) - 1];

    }


}
