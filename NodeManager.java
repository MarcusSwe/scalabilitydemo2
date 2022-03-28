package me;

import java.util.ArrayList;
import java.util.List;

public class NodeManager {

    // fem trådar ska startas ..praxis att använda stora bokstäver på final..
    private static final int NODE_COUNT = 5;

    //------------ proxyn- hanterar noderna..
    //singelton
    public static NodeManager INSTANCE = new NodeManager();

    private List<Node> nodes;

    public NodeManager() {
        this.nodes = new ArrayList<>(); // SAKERNA , nodesen, lägg i arrayen för att lättare köra round robin på noderna..
    }

    public void start(){
        for (int i = 0; i < NODE_COUNT; i++){
            Node node = new Node("Thread #" + (i+1));
            node.start();

            nodes.add(node);

        }
    }
    //-------- proxyn- hanterar noderna..


    private int nodeIndex = 0;


    public void push(int num) {

        //load balancer..round robin..först går den till node 1(0) och sedan node 2(1) osv.. sedan resetar den tillbaka till node 1 efter node 5..
        Node node = nodes.get(nodeIndex++);
        if (nodeIndex >= nodes.size())
            nodeIndex = 0;

        //proxyn..omdirigerar..
        node.push(num);

    }


}
