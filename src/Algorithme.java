import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Algorithme {
    private List<Vertex> vertexlist;
    private List<Edge> edgeList;
    private LinkedList<LinkedList<Double>> distances;


    public Algorithme(List<Vertex> vertexlist, List<Edge>edgeList){
        this.vertexlist=vertexlist;
        this.edgeList=edgeList;
    }

    public void shortestPath(Vertex sourcevertex, Vertex targetvertex){
        // init distance of initial Vertex at zero
        sourcevertex.setDistanceMin(0);

        int size = this.vertexlist.size();
        for(int i=0;i<size-1;i++){

            for(Edge edge:this.edgeList){

                if(edge.getStartVertex().getDistanceMin()==Double.MAX_VALUE)
                    continue;

                Vertex v=edge.getStartVertex();
                Vertex u=edge.getTargetVertex();

                double newDistance =v.getDistanceMin()+edge.getWeight();
                if(newDistance<u.getDistanceMin()){
                    u.setDistanceMin(newDistance);
                    u.setPreviousVertex(v);


                }

            }


        }
        if(targetvertex.getDistanceMin()!=Double.MAX_VALUE){
            System.out.println("The Shortest Path is : "+
                    targetvertex.getDistanceMin());
        }else{
            System.out.println("there is not sortest path");

        }
        this.negativeCycle(this.edgeList);
    }

    // check if you get a negative cycle
    private void negativeCycle(List<Edge> edgeList) {
        for(Edge edge:edgeList){
            if(edge.getStartVertex().getDistanceMin()!=Double.MAX_VALUE){
                if(cycle(edge)){
                    System.out.println("there is a negative cycle");
                    return;
                }
            }
        }
    }


    private boolean cycle(Edge edge){
        return(edge.getStartVertex().getDistanceMin()+edge.getWeight())<edge.getTargetVertex().getDistanceMin();
    }


}