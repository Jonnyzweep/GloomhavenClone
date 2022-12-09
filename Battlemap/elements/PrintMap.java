package com.mycompany.gloomhaven.Battlemap.elements;

import com.mycompany.gloomhaven.Battlemap.elements.HexTile;

public class PrintMap
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    private int maxX;
    private int maxY;
    private int counter;


    HexTile theMap[][];

    public PrintMap(HexTile map[][], int maxX, int maxY)
    {
        counter = 1;
        this.maxX=maxX;
        this.maxY = maxY;
        this.theMap = map;

        System.out.println("Battle Map 84:");
        System.out.print("X coordinate are the white numbers and ");
        System.out.print(ANSI_CYAN + "Y coordinate are the cyan numbers:" + ANSI_RESET);
        for(int y= 0; y < maxY; y++)
        {
            reset(y);
            for(int x = 0; x < maxX; x++)
            {
                box(x,y);
            }
        }
        System.out.println("");
    }

    public void reset(int y)
    {
        System.out.println("");
        System.out.print(ANSI_CYAN + (y + 1) + ANSI_RESET); // showing y cord

        if(counter == 0)
        {
            System.out.print("     ");
            counter =1;
        }
        else
        {
            System.out.print("   ");
         counter = 0;
        }
    }

    public void box(int x, int y)
    {
        if(theMap[x][y].getType() == 0)
        {
            System.out.print((x+1) +"[ ] ");
        }
        else if (theMap[x][y].getType() == 1)
        {

            insideBox(x,y, 1);

        }
        else if (theMap[x][y].getType() == 2)
        {
            insideBox(x,y, 2);

        }
        else if (theMap[x][y].getType() == 3)
        {
            insideBox(x,y, 3);

        }
        else if (theMap[x][y].getType() == 4)
        {
            insideBox(x,y, 4);

        }
        else if (theMap[x][y].getType() == 5)
        {
            insideBox(x,y, 5);

        }
        else if (theMap[x][y].getType() == 6)
        {
            insideBox(x,y,6);

        }
        else if (theMap[x][y].getType() == 7)
        {
            insideBox(x,y,7);

        }
        else if (theMap[x][y].getType() == 8)
        {
            insideBox(x,y, 8);

        }
        else if (theMap[x][y].getType() == 9)
        {
            System.out.print(ANSI_RED + "[" + theMap[x][y].getName() +"] " + ANSI_RESET);

        }
        else if (theMap[x][y].getType() == 20)
        {
            System.out.print("    "); // deadspace

        }
    }

    public void insideBox(int x, int y, int t)
    {
        int curX = x +1;
        if(t == 1)
        {
            if(theMap[x][y].getName() == 0)
            {
                System.out.print(curX+"[ ] ");
            }
        }
        else if (t == 2)
        {
            if(theMap[x][y].getName() == 0)
            {
                System.out.print(curX+"[ ] ");
            }

        }
        else if (t == 3)
        {
            if(theMap[x][y].getName() == 0)
            {
                System.out.print(curX+"[ ] ");
            }

        }
        else if (t == 4)
        {
            if(theMap[x][y].getName() == 0)
            {
                System.out.print(curX+"[ ] ");
            }

        }
        else if (t == 5)
        {
            System.out.print(curX);
            if(theMap[x][y].getName() == 0)
            {
                System.out.print(ANSI_PURPLE + "[L] " + ANSI_RESET);
            }

        }
        else if (t == 6)
        {
            System.out.print(curX);
            if(theMap[x][y].getName() == 0)
            {
                System.out.print(ANSI_GREEN + "[B] " + ANSI_RESET);
            }
            else if (theMap[x][y].getName() == 1)
            {
                System.out.print(ANSI_GREEN + "[T] " + ANSI_RESET);
            }
            else
            {
                System.out.print("[ ] "); // if nothings comes up
            }

        }
        else if (t == 7)
        {
            System.out.print(curX);
            if(theMap[x][y].getName() == 0)
            {
                System.out.print(ANSI_YELLOW + "[C] " + ANSI_RESET);
            }
            else
            {
                System.out.print("[ ] ");
            }

        }
        else if (t == 8)
        {
            System.out.print(curX);
            if(theMap[x][y].getName() == 0)
            {
                System.out.print(ANSI_BLACK + "[H] " + ANSI_RESET);
            }

            else if (theMap[x][y].getName() == 1)
            {
                System.out.print(ANSI_BLACK + "[F] " + ANSI_RESET);
            }
            else if (theMap[x][y].getName() == 2)
            {
                System.out.print(ANSI_BLACK + "[E] " + ANSI_RESET);
            }
            else
            {
                System.out.print("[ ] ");
            }


        }

    }

}
