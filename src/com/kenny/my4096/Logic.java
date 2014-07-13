package com.kenny.my4096;

import java.util.Random;

public class Logic {
	
	private int[][] gameBoard;
	
	public int getCell(int cellSpace)
	{
		return gameBoard[cellSpace / 4][cellSpace % 4];
	}
    
    public void InitBoard()
    {
        gameBoard = new int[4][4];
        
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                gameBoard[i][j] = 0;
            }
        }
        
        NewNumber();
        NewNumber();
    }
    
    private void NewNumber()
    {
        Random randomGenerator = new Random();
        int i,j;
        int newNum = randomGenerator.nextInt(10);
        int place;
        boolean check = true;
        
        if(ZeroCheck())
        {
            while(check)
            {
                place = randomGenerator.nextInt(16);
                i = place / 4;
                j = place % 4;
                
                if(gameBoard[i][j] == 0)
                {
                    if(newNum < 9)
                        gameBoard[i][j] = 2;
                    else
                        gameBoard[i][j] = 4;
                    
                    check = false;
                }
            }
        }
        
    }
    
    public void LeftMove()
    {
        int tempRow1[] = new int[4];
        int tempRow2[] = new int[4];
        int counter1;
        int counter2;
        
        int[][] gbCheck = CopyBoard();
        
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                tempRow1[j] = 0;
                tempRow2[j] = 0;
            }
            counter1 = 0;
            counter2 = 0;
            
            for(int j = 0; j < 4; j++)
            {
                if(gameBoard[i][j] != 0)
                {
                    tempRow1[counter1] = gameBoard[i][j];
                    counter1++;
                }
            }
            
            for(int j = 0; j < 3; j++)
            {
                if(tempRow1[j] == tempRow1[j + 1])
                {
                    tempRow1[j] *= 2;
                    tempRow1[j + 1] = 0;
                }
            }
            
            for(int j = 0; j < 4; j++)
            {
                if(tempRow1[j] != 0)
                {
                    tempRow2[counter2] = tempRow1[j];
                    counter2++;
                }
            }
            
            System.arraycopy(tempRow2, 0, gameBoard[i], 0, 4);
        }
        
        if(!SameCheck(gbCheck, gameBoard))
            NewNumber();
        
    }
    
    public void RightMove()
    {
        int tempRow1[] = new int[4];
        int tempRow2[] = new int[4];
        int counter1;
        int counter2;
        
        int[][] gbCheck = CopyBoard();
        
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                tempRow1[j] = 0;
                tempRow2[j] = 0;
            }
            counter1 = 3;
            counter2 = 3;
            
            for(int j = 3; j >= 0; j--)
            {
                if(gameBoard[i][j] != 0)
                {
                    tempRow1[counter1] = gameBoard[i][j];
                    counter1--;
                }
            }
            
            for(int j = 3; j > 0; j--)
            {
                if(tempRow1[j] == tempRow1[j - 1])
                {
                    tempRow1[j] *= 2;
                    tempRow1[j - 1] = 0;
                }
            }
            
            for(int j = 3; j >= 0; j--)
            {
                if(tempRow1[j] != 0)
                {
                    tempRow2[counter2] = tempRow1[j];
                    counter2--;
                }
            }
            
            System.arraycopy(tempRow2, 0, gameBoard[i], 0, 4);
        }
        
        if(!SameCheck(gbCheck, gameBoard))
            NewNumber();
        
    }
    
    public void UpMove()
    {
        int tempCol1[] = new int[4];
        int tempCol2[] = new int[4];
        int counter1;
        int counter2;
        
        int[][] gbCheck = CopyBoard();
        
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                tempCol1[j] = 0;
                tempCol2[j] = 0;
            }
            counter1 = 0;
            counter2 = 0;
            
            for(int j = 0; j < 4; j++)
            {
                if(gameBoard[j][i] != 0)
                {
                    tempCol1[counter1] = gameBoard[j][i];
                    counter1++;
                }
            }
            
            for(int j = 0; j < 3; j++)
            {
                if(tempCol1[j] == tempCol1[j + 1])
                {
                    tempCol1[j] *= 2;
                    tempCol1[j + 1] = 0;
                }
            }
            
            for(int j = 0; j < 4; j++)
            {
                if(tempCol1[j] != 0)
                {
                    tempCol2[counter2] = tempCol1[j];
                    counter2++;
                }
            }
            
            for(int j = 0; j < 4; j++)
                gameBoard[j][i] = tempCol2[j];
        }
        
        if(!SameCheck(gbCheck, gameBoard))
            NewNumber();
        
    }
    
    public void DownMove()
    {
        int tempCol1[] = new int[4];
        int tempCol2[] = new int[4];
        int counter1;
        int counter2;
        
        int[][] gbCheck = CopyBoard();
        
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                tempCol1[j] = 0;
                tempCol2[j] = 0;
            }
            counter1 = 3;
            counter2 = 3;
            
            for(int j = 3; j >= 0; j--)
            {
                if(gameBoard[j][i] != 0)
                {
                    tempCol1[counter1] = gameBoard[j][i];
                    counter1--;
                }
            }
            
            for(int j = 3; j > 0; j--)
            {
                if(tempCol1[j] == tempCol1[j - 1])
                {
                    tempCol1[j] *= 2;
                    tempCol1[j - 1] = 0;
                }
            }
            
            for(int j = 3; j >= 0; j--)
            {
                if(tempCol1[j] != 0)
                {
                    tempCol2[counter2] = tempCol1[j];
                    counter2--;
                }
            }
            
            for(int j = 0; j < 4; j++)
                gameBoard[j][i] = tempCol2[j];
        }
        
        if(!SameCheck(gbCheck, gameBoard))
            NewNumber();
        
    }
    
    private boolean ZeroCheck()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(gameBoard[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
    
    public boolean FailCheck()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(gameBoard[i][j] == 0)
                    return false;
                else if(j != 3 && gameBoard[i][j] == gameBoard[i][j + 1])
                    return false;
                else if(i != 3 && gameBoard[i][j] == gameBoard[i + 1][j])
                    return false;
            }
        }
        
        return true;
    }
    
    private int[][] CopyBoard()
    {
        int[][] gbcopy = new int[4][4];
        
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                gbcopy[i][j] = gameBoard[i][j];
            }
        }
        
        return gbcopy;
    }
    
    private boolean SameCheck(int[][] gb1, int[][] gb2)
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(gb1[i][j] != gb2[i][j])
                    return false;
            }
        }
        return true;
    }

}
