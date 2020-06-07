package com.pravin.interview.ctci.chapter8;

public class PaintFill {

   enum Colors  {White, Green, Black, Yellow, Red};

   public Colors[][] paintScreen(Colors[][] screen, int r, int c, Colors newColor) {
       if (screen == null) {
           return null;
       }
       if(screen[r][c] == newColor) {
           return screen;
       }
       return paintScreenR(screen, r, c, screen[r][c], newColor);
   }

    private Colors[][] paintScreenR(Colors[][] screen, int r, int c, Colors oldColor, Colors newColor) {

       if (r >= 0 && r < screen.length && c >= 0 && c < screen[0].length){
           if (screen[r][c] == oldColor) {
               screen[r][c] = newColor;
               paintScreenR(screen, r-1, c,oldColor, newColor );
               paintScreenR(screen, r+1, c,oldColor, newColor );
               paintScreenR(screen, r, c-1,oldColor, newColor );
               paintScreenR(screen, r, c+1,oldColor, newColor );
           }
       }
       return screen;
   }

}
