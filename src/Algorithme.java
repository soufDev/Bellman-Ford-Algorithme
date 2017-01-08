import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Algorithme {
    private List<Vertex> vertexlist;
    private List<Edge> edgeList;
    private LinkedList<LinkedList<Double>> distances;
    private LinkedList<String> shortestPath;


    public Algorithme(List<Vertex> vertexlist, List<Edge>edgeList){
        this.vertexlist=vertexlist;
        this.edgeList=edgeList;
        this.shortestPath = new LinkedList<String>();
    }

    public void shortestPath(Vertex sourcevertex, Vertex targetvertex){
        // init distance of initial Vertex at zero
        sourcevertex.setDistanceMin(0);
        this.shortestPath.add(sourcevertex.toString());

        int size = this.vertexlist.size();
        for(int i=0;i<size-1;i++){

            for(Edge edge:this.edgeList){

                if(edge.getStartVertex().getDistanceMin()==Double.MAX_VALUE)
                    continue;

                Vertex v=edge.getStartVertex();
                Vertex u=edge.getTargetVertex();

                double newDistance =v.getDistanceMin()+edge.getWeight();
                if(!shortestPath.contains(u.toString()))
                    shortestPath.add(u.toString());
                if(newDistance<u.getDistanceMin()){
                    u.setDistanceMin(newDistance);
                    u.setPreviousVertex(v);
                    this.shortestPath.set(this.shortestPath.size()-1, u.toString());
                }

            }


        }
        if(targetvertex.getDistanceMin()!=Double.MAX_VALUE){
            System.out.println("The Shortest Path is : "+
                    targetvertex.getDistanceMin() +
                    " The Path is "+this.shortestPath);
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