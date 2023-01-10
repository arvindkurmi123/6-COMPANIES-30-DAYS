class solution {
       
    private TreeSet<Node> set = new TreeSet<Node>();
    private PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> {
        if(n1.x2 < n2.x2) return -1;
        else if(n1.x2==n2.x2 && n1.x1 < n2.x1) return -1;
        else if(n1.x2==n2.x2 && n1.x1 == n2.x1) return 0;
        else return 1;
    });

    int topIdx = 1;
    
   
    public class Node implements Comparable{
        private int idx;
        private int x1,y1,x2,y2;
        
        public Node(int idx, int[] points){
            this.idx = idx;
            this.x1 = points[0];
            this.y1 = points[1];
            this.x2 = points[2];
            this.y2 = points[3];
        }
        
        
        public boolean equals(Object o){
            if(!(o instanceof Node)) return false;
            Node node = (Node)(o);
            
            if(this.x1 == node.x1 && this.x2 == node.x2 && this.y1 == node.y1 && this.y2 == node.y2) return true;
            return false;
        }   

        public int hashCode(){
            return this.x1*10+this.x2*100+this.y1*1000+this.y2*10000;
        }
        
    
         public int compareTo(Object n) {
            if(!(n instanceof Node)) return 0;
            Node node = (Node)n;
            if(this.y1 < node.y1) return -1;
            else if(this.y1 == node.y1 && this.y2 < node.y2) return -1;
            else if(this.y1 == node.y1 && this.y2 == node.y2) return 0;
            else return 1;
        }

    }

    
    private boolean checkOverLaping(int[][] rectangles){
        
        
        int left = 0;
        int right =0;
        
        while(true){
            if(left >= rectangles.length) break;
            
            while(!pq.isEmpty() && pq.peek().x2 <= rectangles[left][0]) {
                Node n = pq.poll();
                set.remove(n);
            }
            right = left+1;
            
            pq.add(new Node(left, rectangles[left]));
            for(;right<rectangles.length;right++){
                if(!pq.isEmpty() && rectangles[right][0] >= pq.peek().x2) break;
                Node n = new Node(right, rectangles[right]);
                
                set.add(n);
                pq.add(n);
            }
            
            while(left<right){
                while(!pq.isEmpty() && pq.peek().x2 <= rectangles[left][0]) {
                    Node n = pq.poll();
                    set.remove(n);
                }
                
                Node target = new Node(left, rectangles[left]);
                Node cmp1 = set.lower(target);
                Node cmp2 = set.ceiling(target);
                
              
                if(cmp1!=null && cmp1.idx != target.idx && cmp1.y2 > target.y1){
                    return true;
                }
                if(cmp2!=null && cmp2.idx != target.idx && cmp2.y1 < target.y2){
                    return true;
                }
                left++;
            }
        }
        
        return false;
    }
    
    public boolean isRectangleCover(int[][] rectangles) {
        
        if(rectangles.length == 1) return true;

        java.util.Arrays.sort(rectangles, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] < b[0]) return -1;
                else if(a[0] == b[0] && a[2] < b[2]) return -1;
                return 1;
            }
        });
        
        
        if(checkOverLaping(rectangles)) return false;
        
        int mins[] = new int[]{rectangles[0][0],rectangles[0][1]};
        int maxs[] = new int[]{rectangles[0][2],rectangles[0][3]};
        
        int totalArea = 0;
        for(int i=0;i<rectangles.length;i++){
            Node node = new Node(i, rectangles[i]);
            
            totalArea += (node.x2-node.x1 ) * (node.y2-node.y1);
            
            if(node.x1 < mins[0]) mins[0] = node.x1;
            if(node.y1 < mins[1]) mins[1] = node.y1;
            if(node.x2 > maxs[0]) maxs[0] = node.x2;
            if(node.y2 > maxs[1]) maxs[1] = node.y2;
        }
        
        if(totalArea != (maxs[0] - mins[0]) * (maxs[1] - mins[1])) {
            return false;
        }
        else return true;
        
    }
}