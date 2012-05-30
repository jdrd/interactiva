package Ajedrez;
public class objReina extends objChessPieces {
    
    public void objQueen() {
    }
    
    public boolean legalMove(int startRow, int startColumn, int desRow, int desColumn, int[][] playerMatrix) {
        
        boolean axis = true;
        
        if (startRow == desRow ^ startColumn == desColumn) {
            axis = true;
        } else if (startRow != desRow && startColumn != desColumn) {
            axis = false; //MOver diagonal
        } else {
            
            strErrorMsg = "Reina se puede mover en cualquier direccion";
            return false;
            
        }
        
        return axisMove(startRow, startColumn, desRow, desColumn, playerMatrix, axis);
        
    }
    
}