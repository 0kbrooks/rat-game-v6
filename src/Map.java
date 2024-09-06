//import java.lang.ArrayIndexOutOfBoundsException;
//import java.lang.NullPointerException;
import java.util.Hashtable;
//import java.util.HashMap;

public class Map {
    private static MapTile[] a;
	Hashtable<Integer, Hashtable<Integer,MapTile>> Tiles = new Hashtable<Integer, Hashtable<Integer,MapTile>>();
    public String Stringify() {
        Hashtable<Integer,String> lines = new Hashtable<Integer,String>();
        for(int i = 0;i<Tiles.size();i++){
            for(int j = 0;j<Tiles.get(i).size();j++){
                //System.out.println("("+i+","+j+")");
                if(lines.get(i)==null){
                    lines.put(i,"");
                }
                lines.put(i,lines.get(i)+String.valueOf(Tiles.get(i).get(j).ch));
            }
        }
        String output = "";
        for(int i = 0;i<lines.size();i++){
            output+=lines.get(i)+"\n";
        }
        return(output);
    }
    public Map(MapTile[] tiles) {
        System.out.println("Initializing new map");
        Hashtable<Integer, Hashtable<Integer,MapTile>> output = new Hashtable<Integer, Hashtable<Integer,MapTile>>();
            //build table of tables for 2d map
        output.put(0,new Hashtable<Integer,MapTile>());
        
        for(int i = 0;i<tiles.length;i+=1) {
            System.out.println("Putting tile "+tiles[i]+" at "+tiles[i].x+","+tiles[i].y+": "+(i+1)+"/"+tiles.length);
            if(output.get(tiles[i].x)==null) {
                output.put(tiles[i].x,new Hashtable<Integer,MapTile>());
            }
            
            output.get(tiles[i].x).put(tiles[i].y,tiles[i]);
        }
        System.out.println("Filling in holes");
        int rowsFound = 0;
        int largestRow = 0;
        for(int i = 0;rowsFound<output.size();) {
            if(output.get(i)!=null) {
                rowsFound++;
            } else {
                output.put(i, new Hashtable<Integer, MapTile>());
                System.out.println("Placed row at "+i);
            }
            if(output.get(i).size()>largestRow){largestRow=output.get(i).size();}
            i++;
        }
        System.out.println("Largest row found: "+largestRow+"\nRows found: "+rowsFound);
        for(int j = 0;j<output.size();j++){
            for(int k = 0;k<largestRow+1;k++){
                if(output.get(j).get(k)==null){
                    output.get(j).put(k, new MapTile(j,k));
                    System.out.println("Placed tile at ("+j+","+k+")");
                }
            }
        }
        Tiles = output;
        System.out.println("Finished building map");
    }
    public Map() {
        this(a);
    }
}