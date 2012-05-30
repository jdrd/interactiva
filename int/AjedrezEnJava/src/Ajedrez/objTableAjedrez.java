
package Ajedrez;

import java.awt.*;
import java.util.Vector;

public class objTableAjedrez extends Canvas {
    
    protected objPaintInstruction instruccionActual = null;
    protected Vector vecPaintInstructions = new Vector();
    
    public void chessBoard() {
    }
    
    public void update(Graphics g) {
        paint(g);
    }
    
    public void paint(Graphics g) {
        
        if (vecPaintInstructions.size() == 0) {
            
            g.setColor(new Color(25,25,25)); //Estable los colores al tablero
            g.fillRect(0,0,500,50);//Borde norte
            g.fillRect(0,0,50,500);//Oeste
            g.fillRect(450,0,50,500);//este
            g.fillRect(50,450,450,50);
            
            instruccionActual = new objPaintInstruction(0,0,8);
            vecPaintInstructions.addElement(instruccionActual);
            
        }
        

        
        for (int i = 0; i < vecPaintInstructions.size(); i++) {
            
            instruccionActual = (objPaintInstruction)vecPaintInstructions.elementAt(i);
            int startRow = instruccionActual.getStartRow();
            int startColumn = instruccionActual.getStartColumn();
            int rowCells = instruccionActual.getRowCells();
            int columnCells = instruccionActual.getColumnCells();
            
            for (int row = startRow; row < (startRow + rowCells); row++) {
                
                for (int column = startColumn; column < (startColumn + columnCells); column++) {
                    drawTile(row, column, g);
                }
                
            }
            
        }
        
        drawExtra(g);
        
    }
    
    private void drawTile(int row, int column, Graphics g) {
        
        if ((row + 1) % 2 == 0) {
            
            if ((column + 1) % 2 == 0) {
                g.setColor(new Color(255,255,255));
            } else {
                g.setColor(new Color(0,0,0));
            }
            
        } else {
            
            if ((column + 1) % 2 == 0) {
                g.setColor(new Color(0,0,0));
            } else {
                g.setColor(new Color(255,255,255));
            }
            
        }
        
        g.fillRect((50 + (column * 50)), (50 + (row * 50)), 50, 50);
        
    }
    
    protected void drawExtra(Graphics g) {
    }
    
    protected int findWhichTileSelected(int coor) {
        
        for (int i = 0; i < 8; i++) {
            
            if ((coor >= (50 + (i * 50))) && (coor <= (100 + (i * 50)))) {
                return i;
            }
            
        }
        
        return -1;
        
    }
    
}