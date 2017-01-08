import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String []args){

        List<Vertex> vertexlist=new ArrayList<>();



        vertexlist.add(new Vertex("A"));
        vertexlist.add(new Vertex("B"));
        vertexlist.add(new Vertex("C"));
        vertexlist.add(new Vertex("D"));
        vertexlist.add(new Vertex("E"));




        List<Edge> edgeList=new ArrayList<>();



        edgeList.add(new Edge(1,vertexlist.get(0),vertexlist.get(1)));
        edgeList.add(new Edge(2,vertexlist.get(0),vertexlist.get(2)));
        edgeList.add(new Edge(3,vertexlist.get(0),vertexlist.get(3)));
        edgeList.add(new Edge(5,vertexlist.get(1),vertexlist.get(2)));
        edgeList.add(new Edge(6,vertexlist.get(2),vertexlist.get(4)));
        edgeList.add(new Edge(2,vertexlist.get(3),vertexlist.get(4)));






        Algorithme algorithme=new Algorithme(vertexlist,edgeList);

        algorithme.shortestPath(vertexlist.get(0), vertexlist.get(4));
    }


}