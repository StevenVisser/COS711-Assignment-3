
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steve
 */
public class main
{
    public static void main(String[] args)
    {
        List<String> arr = new ArrayList<String>();
        String output = "";
        try
        {
            Scanner fr = new Scanner(new File("TrainOneHot.csv"));
            output = fr.nextLine();
            while (fr.hasNextLine())
            {
                String data = fr.nextLine();
                String[] parts = data.split(",");
                if(!arr.contains(parts[0]))
                {
                    arr.add(parts[0]);
                    output += "\n" + data;
                }
            }
            fr.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
        try
        {
            FileWriter fw = new FileWriter("TrainOneHotUpdate.csv");
            fw.write(output);
            fw.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
