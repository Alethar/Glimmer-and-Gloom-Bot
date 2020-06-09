import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class Main
{
    /**
     * Variables to configure TODO change these before using!
     */
    public static int games = 47; // amount of games you want to play (47 earns
                                  // to max), 1600kt per game and 75000kt max

    /**
     * coordinates of starting block (center to top left using provided program)
     */
    static int starty = 535; // y is pixels from top side of screen

    static int startx = 730; // x is pixels from left side of screen

    static int xdiff = 60; // pixels from center of top left hex to the hex next
                           // to it (to the right)

    static int starttime = 3; // Time given (in seconds) to bring up the Glimmer
                              // and Gloom page. Set to 5 seconds by default.
    
    


    /**
     * 
     * loops 47 and completes the game 47 times. Should be calibrated to top of
     * screen.
     * 
     * @param args
     * @throws AWTException
     * @throws InterruptedException
     */
    public static void main( String args[] ) throws AWTException, InterruptedException
    {
        Robot r = new Robot();
        Thread.sleep( starttime * 1000 );
        r.mouseMove( 800, 700 ); // TUNE POSITION OF "PLAY GAME" BUTTON
        r.mousePress( InputEvent.BUTTON1_DOWN_MASK );
        r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );
        r.mousePress( InputEvent.BUTTON1_DOWN_MASK );
        r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );
        Thread.sleep( 200 );
        r.mouseMove( 750, 800 ); // TUNE POSITION OF "HARD" BUTTON
        r.mousePress( InputEvent.BUTTON1_DOWN_MASK );
        r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );
        Thread.sleep( 500 );
        for ( int i = 0 ; i < games ; i++ )
        {
            game(r);
            Thread.sleep( 300 );
            r.mouseMove( 1000, 870 );
            r.mousePress( InputEvent.BUTTON1_DOWN_MASK );
            r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );
            Thread.sleep( 1300 );
        }

    }


    public static void game(Robot r) throws InterruptedException, AWTException
    {
        // r.mouseMove( 800, 700 ); for starting games
        // r.mousePress( InputEvent.BUTTON1_DOWN_MASK );
        // r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );
        boolean[][] map = new boolean[7][7];
        boolean[][] clickmap = new boolean[7][7];
        fillmap( map, r );
        printmap( map );
        for ( int row = 0; row < 3; row++ )
        {
            for ( int col = 0; col < 4 + row; col++ )
            {
                if ( map[row][col] )
                {
                    press( row + 1, col + 1, map, clickmap );
                }
            }

        }
        for ( int col = 0; col < 6; col++ )
        { // layer 4
            if ( map[3][col] )
            {
                press( 4, col, map, clickmap );
            }
        }
        if ( map[3][6] )
        { // accounting for odd tile
            for ( int col = 0; col < 7; col++ )
            {
                press( 3, col, map, clickmap );
            }
            for ( int col = 0; col < 6; col++ )
            {
                if ( map[3][col] )
                {
                    press( 3 + 1, col, map, clickmap );
                }
            }
        }
        for ( int col = 0; col < 5; col++ )
        {
            if ( map[4][col] )
            {
                press( 5, col, map, clickmap );
            }
        }
        if ( map[4][5] )
        {
            for ( int col = 0; col < 5; col++ )
            {
                press( 1, col, map, clickmap );
            }
            press( 2, 2, map, clickmap );
            press( 2, 4, map, clickmap );
            press( 2, 5, map, clickmap );
            press( 3, 1, map, clickmap );
            press( 3, 3, map, clickmap );
            press( 3, 4, map, clickmap );
            press( 3, 5, map, clickmap );
            press( 4, 0, map, clickmap );
            press( 4, 2, map, clickmap );
            for ( int col = 0; col < 5; col++ )
            {
                if ( map[4][col] )
                {
                    press( 5, col, map, clickmap );
                }
            }
        }
        for ( int col = 0; col < 4; col++ )
        {
            if ( map[5][col] )
            {
                press( 6, col, map, clickmap );
            }
        }
        boolean left = false;
        for ( int col = 0; col < 5; col++ )
        {
            if ( map[5][col] )
            {
                left = true;
                break;
            }
        }
        if ( !left )
        {
            for ( int col = 0; col < 4; col++ )
            {
                if ( map[6][col] )
                {
                    left = true;
                    break;
                }
            }
        }
        if ( left )
        {
            System.out.println("bottom triggered");
            press( 0, 0, map, clickmap );
            press( 0, 3, map, clickmap );
            press( 1, 1, map, clickmap );
            press( 1, 3, map, clickmap );
            press( 3, 2, map, clickmap );
            press( 3, 4, map, clickmap );
            press( 4, 1, map, clickmap );
            press( 4, 4, map, clickmap );
            press( 5, 0, map, clickmap );
            press( 5, 1, map, clickmap );
            press( 5, 2, map, clickmap );
            press( 5, 3, map, clickmap );
            press( 5, 4, map, clickmap );

            for ( int col = 0; col < 4; col++ )
            {
                if ( map[5][col] )
                {
                    press( 6, col, map, clickmap );
                }
            }
        }
        System.out.println( "" );
        System.out.println( "___________________" );
        printmap( map );
        System.out.println( "" );
        System.out.println( "___________________" );
        printmap( clickmap );

        // implement loop later
        /*
         * for ( int games = 0; games < 47; games++ ) { r.mouseMove(?, ?);
         * boolean[][] map = new boolean[7][7];
         * 
         * }
         */
        int columns = 4;
        r.mouseMove( 600, 450 );// get rid of weird bug no first click
        r.mousePress( InputEvent.BUTTON1_DOWN_MASK );
        r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );
        r.mousePress( InputEvent.BUTTON1_DOWN_MASK );
        r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );
        for ( int row = 0; row < 7; row++ )
        {

            for ( int col = 0; col < columns; col++ )
            {
                if ( clickmap[row][col] )
                {
                    
                    r.mouseMove( getxcoord( row, col ), getycoord( row ) );
                    Thread.sleep( 120 );
                    r.mousePress( InputEvent.BUTTON1_DOWN_MASK );
                    r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );
                }
            }
            if ( row < 3 )
            {
                columns++;
            }
            else
            {
                columns--;
            }
        }
    }


    public static int getxcoord( int row, int col )
    {
        int xoffset = 0;
        if ( row % 2 == 1 )
        {
            xoffset = -30;
        }
        else
        {
            xoffset = 0;
        }
        int midoffset = 0;
        if(row > 1 && row < 5) {
            midoffset = -60;
        }
        /*System.out.println(startx);
        System.out.println(xoffset);
        System.out.println(midoffset);
        System.out.println(col);
        System.out.println(xdiff);
        
        System.out.println(startx + xoffset + midoffset + col * xdiff);*/
        return startx + xoffset + midoffset + col * xdiff;// TODO

    }


    public static int getycoord( int row )
    {
        int ydiff = xdiff * 53 / 60;
        return starty + ydiff * row;// TODO
    }


    public static void press( int row, int col, boolean[][] map, boolean[][] clickmap )
    {
        System.out.println( row + "    " + col );
        clickmap[row][col] = flipboolean( clickmap[row][col] );
        map[row][col] = flipboolean( map[row][col] ); // center
        if ( row > 0 )
        {
            if ( row < 4 )
            {
                if ( col > 0 )
                {
                    map[row - 1][col - 1] = flipboolean( map[row - 1][col - 1] ); // upper
                                                                                  // left
                                                                                  // or
                                                                                  // right
                }
            }
            else
            {
                if ( col < 6 )
                {
                    map[row - 1][col + 1] = flipboolean( map[row - 1][col + 1] );
                }
            }

            map[row - 1][col] = flipboolean( map[row - 1][col] );// upper
        }
        if ( col > 0 )
        {
            map[row][col - 1] = flipboolean( map[row][col - 1] );// left
        }
        if ( col < 6 )
        {
            map[row][col + 1] = flipboolean( map[row][col + 1] );// right
        }
        if ( row < 6 )
        {
            map[row + 1][col] = flipboolean( map[row + 1][col] );// bottom
            if ( row < 3 )
            {
                if ( col < 6 )
                {
                    map[row + 1][col + 1] = flipboolean( map[row + 1][col + 1] );// bottom
                                                                                 // right
                                                                                 // or
                                                                                 // left
                }
            }
            else
            {
                if ( col > 0 )
                {
                    map[row + 1][col - 1] = flipboolean( map[row + 1][col - 1] );
                }
            }
        }

    }


    /**
     * 
     * Takes in map and Robot object, checks colors at each value of map and
     * sets map to T for light and F for dark 0, 0 is coord 730, 535 to shift
     * right one move 60 px to shift down one move down 55 px and left or right
     * 30 px
     * 
     * @param map
     * @param r
     * @throws InterruptedException
     */
    public static void fillmap( boolean[][] map, Robot r ) throws InterruptedException
    {
        int columns = 4;
        for ( int row = 0; row < 7; row++ )
        {
            for ( int col = 0; col < columns; col++ )
            {
                // r.mouseMove( getxcoord(row, col), getycoord(row) );
                // Thread.sleep( 1000 );
                if ( r.getPixelColor( getxcoord( row, col ), getycoord( row ) ).getGreen() > 125 )
                {
                    map[row][col] = true;
                }
                else
                {
                    map[row][col] = false;
                }
            }

            if ( row < 3 )
            {
                columns++;
            }
            else
            {
                columns--;
            }
        }
    }


    public static void printmap( boolean[][] map )
    {
        for ( boolean[] row : map )
        {
            for ( boolean col : row )
            {
                System.out.print( col + "   " );
            }
            System.out.println( "" );
        }
    }


    public static boolean flipboolean( boolean b )
    {
        if ( b == true )
        {
            return false;
        }
        return true;
    }
}
