class solution {
    public void com(int k,int n,int prev, List<Integer> list, List<List<Integer>> li){
        // System.out.println(list);
        // bse case
        if(n<0) return;
        if(k==0) {
            if(n==0){
                // System.out.println("addlist = "+list);
                li.add(new ArrayList(list));
            }
            return;
        }


        // kaam
        // System.out.println("k="+k+" n= "+n);
        for(int i=prev+1; i<10; i++){
                list.add(i);
                com(k-1,n-i,i,list,li);
                list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> li = new ArrayList<>();
        // valid cases
        int sum= (k*(k+1)/2);
        if(sum>n){
            return li;
        } else {
            List<Integer> list = new ArrayList<>();
            com(k,n,0,list,li);
        }
        return li;
    }
}