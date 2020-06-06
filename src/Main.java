import java.util.*;
import java.util.Comparator;

class ServiceNode {
    int frequency;
    String name;
    String phoneNumber;
    ServiceNode[] nodes=new ServiceNode[10];

}
class MyComprator implements Comparator<ServiceNode> {
    @Override
    public int compare(ServiceNode o1, ServiceNode o2) {
        return o1.frequency-o2.frequency;
    }

}

public class Main {


    // recursive function to print the
    // huffman-code through the tree traversal.KKK
    // Here s is the huffman - code generated.
    public static void numberGenerator(ServiceNode root,String s)
    {

        if (
                root.nodes[0]==null
                        &&root.nodes[1]==null
                        &&root.nodes[2]==null
                        &&root.nodes[3]==null
                        &&root.nodes[4]==null
                        &&root.nodes[5]==null
                        &&root.nodes[6]==null
                        &&root.nodes[7]==null
                        &&root.nodes[8]==null
                        &&root.nodes[9]==null
        )
        {
            System.out.println(root.name + "\t\t:\t\t" +root.frequency+ "\t\t:\t\t" +s );

        }
        
        else
            for (int i =0 ; i<10;i++)
                if(root.nodes[i]!=null)
                    numberGenerator(root.nodes[i],s+i);

    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);




            //number of services
            int numberOfServices = Integer.parseInt( s.nextLine());

            //split frequencies by comma
            String[] frequencies = s.nextLine().split(",");

            // creating a priority queue q.
            // makes a min-priority queue(min-heap).
            PriorityQueue<ServiceNode> q
                    = new PriorityQueue<>(numberOfServices, new MyComprator());

            //create services nodes and add them to priority queue
            for (int i = 0; i < numberOfServices; i++) {

                // creating a ServiceNode object
                // and add it to the priority queue.
                ServiceNode hn = new ServiceNode();
                hn.name = "s" + i;
                hn.frequency = Integer.parseInt(frequencies[i].replace(" ",""));
                Arrays.fill(hn.nodes, null);

                // add functions adds
                // the service node to the queue.
                q.add(hn);
            }

            // create a root node
            ServiceNode root = null;

            //extract 10 nodes and add them to array
            while (q.size() > 1) {

                ServiceNode[] extractedNodes;
                ServiceNode sumNode = new ServiceNode();


                if (q.size() < 10) {
                    extractedNodes = new ServiceNode[q.size()];
                } else
                    extractedNodes = new ServiceNode[10];


                //extract minimum 10 nodes
                for (int i = 0; i < extractedNodes.length; i++) {
                    extractedNodes[i] = q.peek();
                    q.poll();
                    //sum extracted nodes frequency
                    sumNode.frequency +=extractedNodes[i].frequency;
                    //assign extracted nodes to be sumNode children
                    sumNode.nodes[i]=extractedNodes[i];
                }

                // marking the sumNode node as the root node.
                root = sumNode;

                // add this node to the priority-queue.
                q.add(sumNode);

            }

            System.out.println("name\t:\tFrequency:\tPhone Number");
            numberGenerator(root, "");
        }


}
