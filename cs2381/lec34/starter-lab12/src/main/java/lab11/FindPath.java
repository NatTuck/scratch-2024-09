package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayDeque; 

public class FindPath {
    static List<String> findPath(RoadMap mm,
                                 String src,
                                 String dst) 
    {
        //var visited = new TreeSet<String>();
        return iteratedDepthFirst(mm, src, dst);
    }

    static List<String> breadthFirst(RoadMap mm, String src, String dst)
    {
        var prev = new TreeMap<String, String>(); 
        prev.put(src, src);

        var queue = new ArrayDeque<String>();
        queue.addLast(src);

        while (!queue.isEmpty()) {
            var city = queue.removeFirst();

            if (city.equals(dst)) {
                var path = new ArrayList<String>();
                var curr = dst;
                while (!curr.equals(src)) {
                    path.add(curr);
                    curr = prev.get(curr);
                }
                path.add(src);
                Collections.reverse(path);
                return path;
            }
        
            var ns = mm.getNeighbors(city);
            for (var neib : ns) {
                if (!prev.containsKey(neib)) {
                    prev.put(neib, city);
                    queue.addLast(neib);
                }
            }
        }

        return null;
    }
    
    static List<String> iteratedDepthFirst(RoadMap mm, String src, String dst) {
        int limit = 1;
        while (limit <= mm.size()) {
            var visited = new TreeSet<String>();
            var path = iteratedDepthFirst1(mm, src, dst, visited, limit);
            if (path != null) {
                return path;
            }
            limit += 1;
        }
        return null;
    }

    static List<String> iteratedDepthFirst1(RoadMap mm, String src, 
            String dst, TreeSet<String> visited, int limit) 
    {
        System.out.println("idf(" + src + ", " + dst + ", " + limit + ")");
        
        if (src.equals(dst)) {
            return List.of(dst);
        }

        if (limit < 1) {
            return null;
        }

        visited.add(src);

        var ns = mm.getNeighbors(src);
        for (var neib : ns) {
            if (visited.contains(neib)) {
                continue;
            }
            System.out.println("try " + src + " => " + neib);
            var rest = iteratedDepthFirst1(mm, neib, dst, visited, limit - 1);
            if (rest != null) {
                var xs = new ArrayList<String>();
                xs.add(src);
                xs.addAll(rest);
                System.out.println(" => " + xs);
                return xs;
            }
        }

        return null;
    }



    static List<String> depthFirst(RoadMap mm, String src, 
            String dst, TreeSet<String> visited) 
    {
        System.out.println("depthFirst(" + src + ", " + dst + ")");

        visited.add(src);

        if (src.equals(dst)) {
            return List.of(dst);
        }

        var ns = mm.getNeighbors(src);
        for (var neib : ns) {
            if (visited.contains(neib)) {
                continue;
            }
            System.out.println("try " + src + " => " + neib);
            var rest = depthFirst(mm, neib, dst, visited);
            if (rest != null) {
                var xs = new ArrayList<String>();
                xs.add(src);
                xs.addAll(rest);
                System.out.println(" => " + xs);
                return xs;
            }
        }

        return null;
    }

    static List<String> findPath(RoadMap mm,
            TreeMap<String, CityInfo> infos,
            MinHeap<CityInfo> queue,
            String src,
            String cur,
            String dst) {
        // Probably not this.
        var ys = new ArrayList<String>();
        for (var name : mm.listCities()) {
            ys.add(name);
        }
        return ys;

        // If we've reached the destination (cur.equals(dst))
        // then use buildPath to get the list of
        // city names to return.

        // For each neighbor of the current city:
        // - Calculate the distance through the current city to
        // the neighbor (cur srcDist + dist(cur, neib)).
        // - If this is better than the best distance we've found so
        // far (or we haven't gotten here previously).
        // - Update the distance in infos to the better one.
        // - Update the prev in infos to the current city.
        // - Add the neighbor to the queue
        // Mark current city as done.

        // Pull a non-done city out of the queue and recurse
        // with that city as cur.
        //
        // If the queue is empty there's no path - throw an exception.
    }

    static List<String> buildPath(TreeMap<String, CityInfo> infos,
                                  String dst,
                                  String src) {
        var ys = new ArrayList<String>();

        while (!dst.equals(src)) {
            ys.add(dst);
            var di = infos.get(dst);
            dst = di.prev;
        }

        ys.add(src);
        
        Collections.reverse(ys);
        return ys;
    }

    static public int compare(CityInfo aa, CityInfo bb) {
        var ad = Double.valueOf(aa.srcDist);
        var bd = Double.valueOf(bb.srcDist);
        return ad.compareTo(bd);
    }
}

class CityInfo {
    String name;
    String prev;
    double srcDist;
    boolean done;

    CityInfo(String name, String prev, double srcDist) {
        this.name = name;
        this.prev = prev;
        this.srcDist = srcDist;
        this.done = false;
    }
}
