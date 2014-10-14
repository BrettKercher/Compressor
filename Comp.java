/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author Brett
 */
public class Comp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        if(args.length < 2)
        {    
            System.out.println("Error - Program must be supplied with 2 command line arguments");
            System.out.println("a letter c or d for compress or decompress, and the name of the file to be compressed.");
            System.out.println("Example: java Comp c infile.txt");
        }
        else
        {    
            //File name, taken as a command line argument
            String inFile = args[1];

            //Input either d or c as a command line argument
            String action = args[0];

            if(action.equals("c") || action.equals("C"))
                compress(inFile + ".txt");
            else if(action.equals("d") || action.equals("D")) 
                decompress(inFile + ".txt.myZ");
            else
	    {
                System.out.println("Error in second command line argument");
                System.out.println("Input either \"c\" for Compression or \"d\" for Decompression");
            }
        }    
        
    }
    
    
    public static void compress(String infile) throws Exception
    {
        IO.Compressor compressor = new IO.Compressor(infile);
        char[] charArray = compressor.giveArray();
        Dictionary dictionary = new Dictionary();
        
        String word = "";
        int index = 0;
        
        for(int i = 0; i < charArray.length - 1; i++)
        {
            if(dictionary.Contains(word + charArray[i]))
            {
                word =  word + charArray[i];
            }    
            else
            {
                index++;
                dictionary.Add(index, word + charArray[i]);
                compressor.encode(dictionary.IndexOf(word), charArray[i]);
                word = "";
            }
            
        }
        
        compressor.done();
        
    }
    
    public static void decompress(String infile) throws Exception
    {
        IO.Decompressor decompress = new IO.Decompressor(infile);
        
        
        IO.pair next = decompress.decode();
        String output = "";
        int index = 0;
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
        dictionary.put(index, output);
        
        while(next.valid)
        {
            output = dictionary.get(next.index);
            output = output + next.extension;
            
            dictionary.put(++index, output);
            
            
            next = decompress.decode();
        } 
        
        for(int i = 1; i < dictionary.size(); i++)
            decompress.append(dictionary.get(i));
        decompress.append("");
        
        
         decompress.done();
         
         
       
    } 
    
}
