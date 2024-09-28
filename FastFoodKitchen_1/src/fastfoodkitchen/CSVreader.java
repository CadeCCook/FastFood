/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fastfoodkitchen;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Cman0
 */
public class CSVreader {
    static ArrayList<ArrayList<String>> startFile() throws FileNotFoundException {
        ArrayList<ArrayList<String>> orders = new ArrayList<ArrayList<String>>();
        int count = 0;
        File inputFile = new File("C:\\Users\\Cman0\\Downloads\\FastFoodKitchen_1\\src\\fastfoodkitchen\\OrderList1.csv");
                Scanner fileScan = new Scanner(inputFile);
                String header = fileScan.nextLine();
                System.out.println("Header: " + header);
                String[] headerValues = header.split(",");
                for(int i = 0; i<headerValues.length; i++){
                    System.out.println(i + ":" + headerValues[i]);
                }
        String line;
        ArrayList<String> lineValues;
        String[] temp;
        while(fileScan.hasNext()){
            lineValues = new ArrayList<String>();
            line = fileScan.nextLine();
            temp = line.split(",");
            for(String value : temp)
            {
                lineValues.add((String)value);
            }
            orders.add(lineValues);
            count++;
        }
        return orders;
    }
    static void CreateFile(ArrayList<BurgerOrder> orders, ArrayList<BurgerOrder> completed) throws FileNotFoundException, IOException{
        FileOutputStream fs = new FileOutputStream("C:\\Users\\Cman0\\Downloads\\FastFoodKitchen_1\\src\\fastfoodkitchen\\EndOfDayList.txt");
        PrintWriter outfs = new PrintWriter(fs);
        outfs.println("Completed orders: ");
        for(BurgerOrder order : completed){
            outfs.println(order);
        }
        outfs.println("\nRemaining orders:");
        for(BurgerOrder order : orders){
            outfs.println(order);
        }
        outfs.close();
        fs.close();
        fs = new FileOutputStream("C:\\Users\\Cman0\\Downloads\\FastFoodKitchen_1\\src\\fastfoodkitchen\\OrderList2.csv");
        outfs = new PrintWriter(fs);
        outfs.println("orderID, numHamburgers, numCheseburgers, numVeggieburgers, numSodas, toGo");
        for(BurgerOrder order : orders){
            outfs.println(order.getOrderNum() + "," + order.getNumHamburger() + "," + order.getNumCheeseburgers() + "," + order.getNumVeggieburgers() + "," + order.getNumSodas() + "," + order.isOrderToGo());
        }
        outfs.close();
        fs.close();
    }
}
