import java.util.*;
import javax.swing.*;
import java.io.*;
public class Main
{
   public static void main(String [] args) throws IOException
   {
       // Build an adjacency list
       Map<String, List<String>> adjList = getAdjacencyList();
       output(adjList);

       // Get two names form the user
       String name1, name2;
       name1 = JOptionPane.showInputDialog(null, "Enter the name of a person: ");
       name2 = JOptionPane.showInputDialog(null, "Enter the name of another person: ");

       List<String> path = findPath(name1, name2, adjList);
       if (path.isEmpty())
       {
           System.out.print("Neither one of these people descends from the other. ");
           return;
       }
       System.out.println("The line of descent is " + path);



   }

   static Map<String, List<String>> getAdjacencyList() throws IOException
   {
       // Ask the user to choose a file
       JFileChooser chooser = new JFileChooser();
       int result = chooser.showOpenDialog(chooser);
       if (result != JFileChooser.APPROVE_OPTION)
       {
           JOptionPane.showMessageDialog(null, "No file selected: Program will exit.");
           System.exit(0);
       }
       // Open the file and put a scanner on it
       Scanner sc = new Scanner(chooser.getSelectedFile());
       // Construct a map to hold the adjacency list
       Map<String, List<String>> adjList = new HashMap<String, List<String>>();
       // read the number of vertices
       int numberVertices = sc.nextInt();
       sc.nextLine();
       // Read each vertex and its list of neighbors
       for (int k = 0; k < numberVertices; k++)
       {
           String vertex;
           int outDegree;
           List<String> neighbors = new ArrayList<String>();
           vertex = sc.next();
           outDegree = sc.nextInt();
           for (int i = 0; i < outDegree; i++)
           {
               neighbors.add(sc.next());
           }
           adjList.put(vertex, neighbors);           
           if (sc.hasNextLine())  sc.nextLine();
       }
       return adjList;
   }

   static void output(Map<String, List<String>> myMap)
   {
       Set<String> keys = myMap.keySet();
       for (String key : keys)
       {
           System.out.println(key + " " + myMap.get(key));
       }
   }

   static List<String> findPath(String name1, String name2,
                                Map<String, List<String>> adjList)
    {
       // Stack to do depth first search
       // Map of iterators to keep track of where we are in the list of
       // neighbors for each vertex
    }
}
