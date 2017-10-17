boolean validSudoku(char[][] grid) 
{
    // Boolean value being returned if valid or not valid sudoku 
    boolean legal = true;
    // Keep count of rows read
    int rowCount = 0;
    // Hashsets to record characters and check if they have already appeared in the same 3 x 3 square.
    HashSet<Character> a = new HashSet<Character>(); 
    HashSet<Character> b = new HashSet<Character>(); 
    HashSet<Character> c = new HashSet<Character>(); 
    
    // For loops to check each position in 2D array
    for (int i = 0; i < grid.length; i++)
    {   
        for (int j = 0; j < grid.length; j++)
        { 
            // If character is a number
            if (grid[i][j] != '.')
            {
                // Returns false for not a valid sudoku puzzle if number already appears in same row
                for (int k = j + 1; k < grid.length; k++) 
                {
                    if (grid[i][k] == grid[i][j])
                    {
                        return !legal;
                    }
                }
                
                // Returns false for not a valid sudoku puzzle if number already appears in same column 
                for (int l = i + 1; l < grid.length; l++) 
                {
                    if (grid[l][j] == grid[i][j])
                    {
                        return !legal;
                    }
                }
                
                // Returns false for not a valid sudoku puzzle if number already appears in same 3x3 square 
                
                // For checking square in the first three columns
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
                // For checking square in the middle three columns
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
                // For checking Square in the last three columns
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
        rowCount++;
        
        // Reset the HashSets after three rows since it is a new square.
        if (count % 3 == 0)
        {
            a.clear();
            b.clear();
            c.clear();
        }           
    }
    
    // Return valid sudoku puzzle
    return legal;
}
