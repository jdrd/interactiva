package Ajedrez;
public class objPaintInstruction {
    
    private int filaIni = 0, columnIni = 0, celdasFila = 0, celdasColumn = 0;
    
    public objPaintInstruction() {
    }
    
    public objPaintInstruction(int primerFila, int primerColumn) {
        calculaRedibujadoCelds(primerFila, primerColumn);
    }
    
    public objPaintInstruction(int filaIni, int columnIni, int numCelds) {
        
        this.filaIni = filaIni;
        this.columnIni = columnIni;
        celdasFila = numCelds;
        celdasColumn = numCelds;
        
    }
    
    private void calculaRedibujadoCelds(int primerFila, int primerColumn) {
        
        if (primerFila == 0) {
            this.filaIni = primerFila;
        } else {
            this.filaIni = primerFila - 1;
        }
        
        if (primerColumn == 0) {
            this.columnIni = primerColumn;
        } else {
            this.columnIni = primerColumn - 1;
        }
        
        if (primerFila <= 5) {
            celdasFila = 3;
        } else {
            celdasFila = 8 - filaIni;
        }
        
        if (primerColumn <= 5) {
            celdasColumn = 3;
        } else {
            celdasColumn = 8 - columnIni;
        }
        
    }
    
    public void setMatriz(int primerFila, int primerColumn) {
        calculaRedibujadoCelds(primerFila, primerColumn);
    }
    
    public void setMatriz(int filaIni, int columnIni, int numCelds) {
        
        this.filaIni = filaIni;
        this.columnIni = columnIni;
        celdasFila = numCelds;
        celdasColumn = numCelds;
        
    }
    
    public int getStartRow() {
        return filaIni;
    }
    
    public int getStartColumn() {
        return columnIni;
    }
    
    public int getRowCells() {
        return celdasFila;
    }
    
    public int getColumnCells() {
        return celdasColumn;
    }
    
}