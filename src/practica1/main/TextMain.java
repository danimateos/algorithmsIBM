/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import practica1.mice.Colony;
import practica1.mice.Mouse;
import practica1.io.Utilities;

/**
 *
 * @author dani
 */
public class TextMain {

    public static void main(String[] args) {
        Colony colony = null;
        Mouse mouse = null;
        String currentFile = null;

        int option = 0;
        String code;

        while (option != 10) {
            option = showMenu();

            switch (option) {
                case 1:
                    currentFile = Utilities.getString("Please input file name");
                    try {
                        colony = Utilities.openPopulationFile(currentFile);
                    } catch (IOException ex) {
                        System.out.println("Couldn't read a population from file " + currentFile);
                        ex.printStackTrace();
                }
                    break;

                case 2:
                    currentFile = Utilities.getString("Please input file name");
                    colony = Utilities.createPopulationFile(currentFile);
                    break;

                default:

                    if (colony == null) {
                        System.out.println("Please create or open a population file first.");
                    } else {
                        switch (option) {
                            case 3:
                                try {
                                    mouse = Utilities.takeMouseFromInput("Please input new mouse");
                                    colony.add(mouse);
                                } catch (IOException ex) {
                                    System.out.println("Could't create mouse from input");
                                    ex.printStackTrace();
                                }
                                break;
                            case 4:
                                String[] codes = colony.getReferenceCodes();
                                System.out.println(Arrays.toString(codes));
                                break;
                            case 5:
                                code = Utilities.getString("Please input reference code");
                                colony.remove(code);
                                break;

                            case 6:
                                code = Utilities.getString("Please input reference code");
                                try {
                                    mouse = Utilities.takeMouseFromInput("Please input new details for code " + code);
                                    colony.modify(code, mouse);
                                } catch (IOException ex) {
                                    System.out.println("Could't create mouse from input");
                                    ex.printStackTrace();
                                }
                                break;

                            case 7:
                                code = Utilities.getString("Please input reference code");
                                System.out.println(colony.showDetails(code));
                                break;

                            case 8:
                                Utilities.save(colony, currentFile);
                                break;
                            case 9:
                                currentFile = Utilities.getString("Please input file name");
                                Utilities.save(colony, currentFile);
                                break;

                        }

                    }

            }
        }
    }

    public static int showMenu() {
        int option = 0;

        System.out.println("Please choose an option");
        System.out.println("1. Open population file");
        System.out.println("2. Create population");
        System.out.println("3. Add mouse to current population");
        System.out.println("4. List all reference codes for current population");
        System.out.println("5. Delete mouse from population");
        System.out.println("6. Modify mouse");
        System.out.println("7. Show mouse details");
        System.out.println("8. Save current population");
        System.out.println("9. Save current population as");
        System.out.println("10. Exit");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (option < 1 || option > 10) {
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (IOException ex) {
                System.out.println("Couldn't read your choice, please try again");
            } catch (NumberFormatException ex) {
                System.out.println("Please input a number");
            }
        }

        return option;
    }

}
