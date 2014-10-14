/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Brett
 */
public class Node {
    
    char value;
    int index;
    boolean endsWord;
    ArrayList<Node> children;
    Node parent;
    
    
    public Node()
    {
        children = new ArrayList<Node>();
        value = '\0';
        index = 0;
        endsWord = false;
        parent = null;
    }
    
    public Node(int indx, char val, Node prnt)
    {
        children = new ArrayList<Node>();
        index = indx;
        value = val;
        endsWord = false;
        parent = prnt;
        
    }
    
    public Node FindChild(char c)
    {
        if(children != null)
        {    
            for(Node child : children)
            {
                if(child.value == c)
                    return child;
            }    
        }        
        return null;
    }

    
}
