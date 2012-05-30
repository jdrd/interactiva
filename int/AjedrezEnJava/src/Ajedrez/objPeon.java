package Ajedrez;
public class objPeon extends objChessPieces {
    
    public void objPawn() {
    }
    
    public boolean legalMove(int startRow, int startColumn, int desRow, int desColumn, int[][] playerMatrix, int currentPlayer) {
        
        boolean legalMove = true;
        int[] playerPawnStart = {6,1};
        
        if ((currentPlayer == 1 && desRow >= startRow) || (currentPlayer == 2 && desRow <= startRow)) //Si se mueven en direccion incorrcta
        {
            
            strErrorMsg = "No se puede mover de esa manera";
            legalMove = false;
            
        } else if (desColumn != startColumn) {
            
            if ((desColumn > startColumn && desColumn == (startColumn + 1)) || (desColumn < startColumn && desColumn == (startColumn - 1))) {
                
                if ((desRow == (startRow + 1) && currentPlayer == 2) || (desRow == (startRow - 1) && currentPlayer == 1)) {
                    
                    if (playerMatrix[desRow][desColumn] == 0) 
                    {
                        
                        strErrorMsg = "Solo se puede mover en diagonal cuando van a cojer una pieza enemiga";
                        legalMove = false;
                        
                    }
                    
                } else {
                    
                    strErrorMsg = "No se puede mover de esa manera";
                    legalMove = false;
                    
                }
                
            } else {
                
                strErrorMsg =  "No se puede mover de esa manera";
                legalMove = false;
                
            }
            
        } else if ((currentPlayer == 1 && desRow < (startRow - 1)) || (currentPlayer == 2 && desRow > (startRow + 1))) //If moved two or more places
        {
            
            if ((currentPlayer == 1 && desRow == (startRow - 2)) || (currentPlayer == 2 && desRow == (startRow + 2))) //If moved two places
            {
                
                if (playerPawnStart[currentPlayer - 1] != startRow) 
                {
                    
                    strErrorMsg =  "No se puede mover de esa manera";
                    legalMove = false;
                    
                }
                
            } else {
                
                strErrorMsg =  "No se puede mover de esa manera";
                legalMove = false;
                
            }
            
        }
        
        if (legalMove) {
            
            finalDesRow = desRow;
            finalDesColumn = desColumn;
            
        }
        
        return legalMove;
        
    }
    
}