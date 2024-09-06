//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MapTile a = new MapTile(1,1);
        MapTile b = new MapTile(2,1);
        MapTile c = new MapTile(1,2);
        MapTile[] d = {a,b,c};
        Map e = new Map(d);
        System.out.println(e.Stringify());
    }
    
}