//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
int[] largestValuesInTreeRows(Tree<Integer> t) 
{
    // null case
    if (t == null)
    {
        int[] array = new int[0];
        return array;
    }
    else
    {
        Queue<Tree <Integer>> bfs = new LinkedList<Tree<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        bfs.add(t);
        int size = bfs.size();
        
        while (size > 0)
        {
            int max = Integer.MIN_VALUE;
            System.out.println(Integer.MIN_VALUE);
            for (int i = 0; i < size; i++)
            {
                Tree <Integer> current = bfs.poll();
                max = Math.max(current.value, max);
                if (current.left != null)
                {
                    bfs.add(current.left);
                }
                if (current.right != null)
                {
                    bfs.add(current.right);
                }
            }
            list.add(max);
            size = bfs.size();
        }
            
        int[] array = new int[list.size()];
        for (int j = 0; j < array.length; j++)
        {
            array[j] = list.get(j);
        }    
            
        return array;
    }
}
