package org.example.navigator;


/**
 * Created by Dmitry.Ivanov on 10/25/2014.
 */
public class Main {
    public static void main(String[] args) {
//        Node __src = new Node(0, 30.31252384185791, 59.937472354745424);
//        Node __dst = new Node(0, 30.323853492736816, 59.93980482945983);

//        Node __src = new Node(0, 30.31252384185791, 59.937472354745424);
//        Node __dst = new Node(0, 30.335065126419067, 59.934188339228506);

        Node __src = new Node(0, 30.679321289062496,59.89720326334451);
        Node __dst = new Node(0, 30.146484374999996,60.056615845305764);

        System.out.println("Building graph:");
        Graph[] graph = new Graph[1];
        printTime(() -> graph[0] = OsmParser.INSTANCE.graph);

        System.out.println("Find src:");
        final Node src[] = new Node[1];
        printTime(() -> src[0] = graph[0].find(__src, 100));

        System.out.println("Find dst:");
        final Node dst[] = new Node[1];
        printTime(() -> dst[0] = graph[0].find(__dst, 100));

        System.out.println("__src:" + __src);
        System.out.println("src:" + src[0]);

        System.out.println("__dst:" + __dst);
        System.out.println("dst:" + dst[0]);

        System.out.println("");
        System.out.println("Djikstra:");
        printTime(() -> graph[0].djikstra(src[0], dst[0]).print(System.out));

        System.out.println("AStar:");
        printTime(() -> graph[0].aStar(src[0], dst[0]).print(System.out));

        System.out.println("Add obstacle:");
        printTime(() -> graph[0].addObstacle(new Obstacle(30.3125342000, 59.9371094000)));

        System.out.println("AStar:");
        printTime(() -> graph[0].aStar(src[0], dst[0]).print(System.out));


        System.out.println((graph[0].allObstaclesSorted().toArray(new Obstacle[0])[0].print()));
    }

    private static void printTime(Runnable rn) {
        long start = System.nanoTime();
        rn.run();
        long elapsed = System.nanoTime() - start;
        System.out.println("-------------------------------------");
        System.out.println(elapsed/1000000+" ms");
        System.out.println("-------------------------------------\n\n");
    }

}

