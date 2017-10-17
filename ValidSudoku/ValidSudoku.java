boolean validSudoku(char[][] grid) 
{
    boolean legal = true;
    int count = 0;
    HashSet<Character> a = new HashSet<Character>(); 
    HashSet<Character> b = new HashSet<Character>(); 
    HashSet<Character> c = new HashSet<Character>(); 
    
    for (int i = 0; i < grid.length; i++)
    {   
        for (int j = 0; j < grid.length; j++)
        {
            if (grid[i][j] != '.')
            {
                // same row case
                for (int k = j + 1; k < grid.length; k++) 
                {
                    if (grid[i][k] == grid[i][j])
                    {
                        return !legal;
                    }
                }
                
                // same column case
                for (int l = i + 1; l < grid.length; l++) 
                {
                    if (grid[l][j] == grid[i][j])
                    {
                        return !legal;
                    }
                }
                
                // same square case
                if (j < 3)
                {
                    if(a.contains(grid[i][j]))
                    {
                        return !legal;
                    } 
                    else
                    {
                        a.add(grid[i][j]);
                    }
                        
                }    
                else if (j < 6)
                {
                    if(b.contains(grid[i][j]))
                    {
                        return !legal;
                    } 
                    else
                    {
                        b.add(grid[i][j]);
                    }
                }
                else
                {
                     if(c.contains(grid[i][j]))
                    {
                        return !legal;
                    } 
                    else
                    {
                        c.add(grid[i][j]);
                    }
                }
            }
        }
        count++;
        
        if (count % 3 == 0)
        {
            a.clear();
            b.clear();
            c.clear();
        }           
    }
    return legal;
}
