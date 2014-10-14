/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brett
 */
public class Dictionary {

    Node root;
    
    public Dictionary()
    {
        root = new Node();
    }

    
    public boolean Contains(String word)
    {
        Node currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {   
            if(currentNode.FindChild(word.charAt(i)) == null)
                return false;
            else
                currentNode = currentNode.FindChild(word.charAt(i));
        }
        return true;
    }
     
    
    public void Add(int indx, String word)
    {
        Node currentNode = root;
       
        for(int i=0; i < word.length() ; i++)
        {
            Node child = currentNode.FindChild(word.charAt(i));
            if(child != null)
            {
                currentNode = child;
            }
            else
            {
                currentNode.children.add(new Node(indx, word.charAt(i), currentNode));
                currentNode = currentNode.FindChild(word.charAt(i));
            }
            // Set marker to indicate end of the word
            if(i == word.length()-1)
                currentNode.endsWord = true;
        } 
    }
    
    public int IndexOf(String word)
    {
        Node currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {   
            if(currentNode.FindChild(word.charAt(i)) == null)
                return currentNode.index;
            else
                currentNode = currentNode.FindChild(word.charAt(i));
        }
        return currentNode.index;
    }
    
    
    
}
