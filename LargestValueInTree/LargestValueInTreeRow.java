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
    // Null tree case
    if (t == null)
    {
        int[] array = new int[0];
        return array;
    }
    else
    {
        Queue<Tree <Integer>> bfs = new LinkedList<Tree<Integer>>();
        // ArrayList to keep track of largest values of each row
        ArrayList<Integer> list = new ArrayList<Integer>();
        bfs.add(t);
        int size = bfs.size();
        
        while (size > 0)
        {
            // Set max to smallest integer
            int max = Integer.MIN_VALUE;
            
            // Loops through the tree for all integers in each row
            for (int i = 0; i < size; i++)
            {
                Tree <Integer> current = bfs.poll();
                max = Math.max(current.value, max);
                // Add current nodes left child if it exists
                if (current.left != null)
                {
                    bfs.add(current.left);
                }
                 // Add current nodes right child if it exists
                if (current.right != null)
                {
                    bfs.add(current.right);
                }
            }
            // Add max integer from row to ArrayList
            list.add(max);
            // Set size to number of integers in row
            size = bfs.size();
        }
            
        // Convert ArrayList to array to return 
        int[] array = new int[list.size()];
        for (int j = 0; j < array.length; j++)
        {
            array[j] = list.get(j);
        }    
            
        return array;
    }
}
