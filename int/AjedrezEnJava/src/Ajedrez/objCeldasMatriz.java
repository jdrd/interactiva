
package Ajedrez;

//Esta es la clase para manejar el movimiento de las piezas alrededor del tablero

public class objCeldasMatriz {
    
    private int[][] matrizJug = new int[8][8];//0 vacio, 1 jugador 1, 2 jugador 2
    private int[][] matrizPieza = new int[8][8];//0 peon, 1 torre, 2 caballo, 3 alfil, 4 reina, 5 rey, 6 empty
    
    public void objCellMatrix() {
    }
    
    public void resetMatriz() {
        
        for (int fila = 0; fila < 8; fila++) {
            
            for (int column = 0; column < 8; column++) {
                
                if (fila <= 1) {
                    
                    matrizJug[fila][column] = 2;
                    
                    if (fila == 1) {
                        matrizPieza[fila][column] = 0;
                    }
                    
                } else if (fila >= 2 && fila <= 5) {
                    
                    matrizJug[fila][column] = 0;
                    matrizPieza[fila][column] = 6;
                    
                } else {
                    
                    matrizJug[fila][column] = 1;
                    
                    if (fila == 6) {
                        matrizPieza[fila][column] = 0;
                    }
                    
                }
                
                if (fila == 0 || fila == 7) {
                    
                    if (column < 5) {
                        matrizPieza[fila][column] = (column + 1);
                    } else {
                        matrizPieza[fila][column] = (8 - column);
                    }
                    
                }
                
            }
            
        }
        
    }
    
    public int getPlayerCell(int fila, int column) {
        return matrizJug[fila][column];
    }
    
    public int getPieceCell(int fila, int column) {
        return matrizPieza[fila][column];
    }
    
    public void setPlayerCell(int fila, int column, int jug) {
        matrizJug[fila][column] = jug;
    }
    
    public void setPieceCell(int fila, int column, int pieza) {
        matrizPieza[fila][column] = pieza;
    }
    
    public int[][] getPlayerMatrix() {
        return matrizJug;
    }
    
    public int[][] getPieceMatrix() {
        return matrizPieza;
    }
    
    public boolean verifGanador(int jugActual) {
        
        int comprobarJug = 0;
        
        if (jugActual == 1) {
            comprobarJug = 2;
        } else {
            comprobarJug = 1;
        }
        
        for (int fila = 0; fila < 8; fila++) {
            
            for (int column = 0; column < 8; column++) {
                
                if (matrizJug[fila][column] == comprobarJug && matrizPieza[fila][column] == 5) {//Si el rey del enemigo todavía se queda
                    return false;
                }
                
            }
            
        }
        
        return true;
        
    }
    
}