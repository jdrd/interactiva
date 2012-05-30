
package Ajedrez;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class windowChessBoard extends objTableAjedrez implements MouseListener, MouseMotionListener {
    
    private final int refreshRate = 5;
    
    private Image[][] imgPlayer = new Image[2][6];
    private String[] strPlayerName = {"Henry Wong", "TU --> MI CONTRICANTE"};
    private String strStatusMsg = "";
    private objCeldasMatriz cellMatrix = new objCeldasMatriz();
    private int currentPlayer = 1, startRow = 0, startColumn = 0, pieceBeingDragged = 0;
    private int startingX = 0, startingY = 0, currentX = 0, currentY = 0, refreshCounter = 0;
    private boolean firstTime = true, hasWon = false, isDragging = false;
    
    private objPeon peonObject = new objPeon();
    private objTorre torreObject = new objTorre();
    private objCaballo caballoObject = new objCaballo();
    private objAlfil alfinObject = new objAlfil();
    private objReina reinaObject = new objReina();
    private objRey reyObject = new objRey();
    
    public windowChessBoard() {
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
    }
    //Siver para cambiar los mensajes que vez en el tablero
    private String getPlayerMsg() {
        
        if (hasWon) {
            return "\nFelicitaciones " + strPlayerName[currentPlayer - 1] + ", tu eres el ganadaror!";
        } else if (firstTime) {
            return "\n" + strPlayerName[0] + " tu eres los negros, " + strPlayerName[1] + " tu eres los blancos";
        } else {
            return "\n" + strPlayerName[currentPlayer - 1] + " mueve";
        }
        
    }
    
    //Comiezan el juego de nuevo
    private void resetBoard() {
        
        hasWon = false;
        currentPlayer = 1;
        strStatusMsg = getPlayerMsg();
        cellMatrix.resetMatriz();
        repaint();
        
    }
    
    public void setupImages(Image[] imgRed, Image[] imgBlue) {
        
        imgPlayer[0] = imgRed;
        imgPlayer[1] = imgBlue;
        resetBoard();
        
    }
    
    //Estabke los nombres a los jugadores
    
    public void setNames(String strPlayer1Name, String strPlayer2Name) {
        
        strPlayerName[0] = strPlayer1Name;
        strPlayerName[1] = strPlayer2Name;
        strStatusMsg = getPlayerMsg();
        repaint();
        
    }
    
    protected void drawExtra(Graphics g) {
        
        for (int i = 0; i < vecPaintInstructions.size(); i++) {
            
            instruccionActual = (objPaintInstruction)vecPaintInstructions.elementAt(i);
            int paintStartRow = instruccionActual.getStartRow();
            int paintStartColumn = instruccionActual.getStartColumn();
            int rowCells = instruccionActual.getRowCells();
            int columnCells = instruccionActual.getColumnCells();
            
            for (int row = paintStartRow; row < (paintStartRow + rowCells); row++) {
                
                for (int column = paintStartColumn; column < (paintStartColumn + columnCells); column++) {
                    
                    int playerCell = cellMatrix.getPlayerCell(row, column);
                    int pieceCell = cellMatrix.getPieceCell(row, column);
                    
                    if (playerCell != 0) {
                        
                        try {
                            g.drawImage(imgPlayer[playerCell - 1][pieceCell], ((column + 1) * 50), ((row + 1) * 50), this);
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                        
                    }
                    
                }
                
            }
            
        }
        
        if (isDragging) {
            g.drawImage(imgPlayer[currentPlayer - 1][pieceBeingDragged], (currentX - 25), (currentY - 25), this);
        }
        
        g.setColor(new Color(0,0,0));
        g.drawString(strStatusMsg, 50, 475);
        
        vecPaintInstructions.clear();
    }
    
    
    //Nuevo juegi
    public void newGame() {
        
        firstTime = false;
        resetBoard();
        
    }
    
    //Valida los movimientos
    
    private void checkMove(int desRow, int desColumn) {
        
        boolean legalMove = false;
        
        if (cellMatrix.getPlayerCell(desRow,desColumn) == currentPlayer) {
            strStatusMsg = "No puedes mover";
        } else {
            
            switch (pieceBeingDragged) {
                //Aca es la parte mas importante aca es donde se ve si realmente las piezas se mueven en la direccion correcta
                case 0: legalMove = peonObject.legalMove(startRow, startColumn, desRow, desColumn, cellMatrix.getPlayerMatrix(), currentPlayer);
                break;
                case 1: legalMove = torreObject.legalMove(startRow, startColumn, desRow, desColumn, cellMatrix.getPlayerMatrix());
                break;
                case 2: legalMove = caballoObject.legalMove(startRow, startColumn, desRow, desColumn, cellMatrix.getPlayerMatrix());
                break;
                case 3: legalMove = alfinObject.legalMove(startRow, startColumn, desRow, desColumn, cellMatrix.getPlayerMatrix());
                break;
                case 4: legalMove = reinaObject.legalMove(startRow, startColumn, desRow, desColumn, cellMatrix.getPlayerMatrix());
                break;
                case 5: legalMove = reyObject.legalMove(startRow, startColumn, desRow, desColumn, cellMatrix.getPlayerMatrix());
                break;
                
            }
            
        }
        
        if (legalMove) {
            
            int newDesRow = 0;
            int newDesColumn = 0;
            
            switch (pieceBeingDragged) {
                
                case 0: newDesRow = peonObject.getDesRow();
                newDesColumn = peonObject.getDesColumn();
                break;
                case 1: newDesRow = torreObject.getDesRow();
                newDesColumn = torreObject.getDesColumn();
                break;
                case 2: newDesRow = caballoObject.getDesRow();
                newDesColumn = caballoObject.getDesColumn();
                break;
                case 3: newDesRow = alfinObject.getDesRow();
                newDesColumn = alfinObject.getDesColumn();
                break;
                case 4: newDesRow = reinaObject.getDesRow();
                newDesColumn = reinaObject.getDesColumn();
                break;
                case 5: newDesRow = reyObject.getDesRow();
                newDesColumn = reyObject.getDesColumn();
                break;
                
            }
            
            cellMatrix.setPlayerCell(newDesRow, newDesColumn, currentPlayer);
            
            //Si el peon llega al final puede cambiar por cualquier pieza es asi por
            //el cual debe de poder eligir q pieza a cambir
            
            
            if (pieceBeingDragged == 0 && (newDesRow == 0 || newDesRow == 7))
            {
                
                boolean canPass = false;
                int newPiece = 2;
                String strNewPiece = "Torre";
                String[] strPieces = {"Torre","Caballo","Alfil","Reina"};
                JOptionPane digBox = new JOptionPane("Elige la pieza", JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, strPieces, "Torre");
                JDialog dig = digBox.createDialog(null, "Peon al final del camino");
                
                do
                {
                    
                    dig.setVisible(true);
                    
                    try {
                        
                        strNewPiece = digBox.getValue().toString();
                        
                        for (int i = 0; i < strPieces.length; i++) {
                            
                            if (strNewPiece.equalsIgnoreCase(strPieces[i])) {
                                
                                canPass = true;
                                newPiece = i + 1;
                                
                            }
                            
                        }
                        
                    } catch (NullPointerException e) {
                        canPass = false;
                    }
                    
                }
                while (canPass == false);
                
                cellMatrix.setPieceCell(newDesRow, newDesColumn, newPiece);
                
            } else {
                cellMatrix.setPieceCell(newDesRow, newDesColumn, pieceBeingDragged);
            }
            
            if (cellMatrix.verifGanador(currentPlayer)) {
                
                hasWon = true;
                strStatusMsg = getPlayerMsg();
                
            } else {
                
                if (currentPlayer == 1) {
                    currentPlayer = 2;
                } else {
                    currentPlayer = 1;
                }
                
                strStatusMsg = getPlayerMsg();
                
            }
            
        } else {
            
            switch (pieceBeingDragged) {
                
                case 0: strStatusMsg = peonObject.getErrorMsg();
                break;
                case 1: strStatusMsg = torreObject.getErrorMsg();
                break;
                case 2: strStatusMsg = caballoObject.getErrorMsg();
                break;
                case 3: strStatusMsg = alfinObject.getErrorMsg();
                break;
                case 4: strStatusMsg = reinaObject.getErrorMsg();
                break;
                case 5: strStatusMsg = reyObject.getErrorMsg();
                break;
                
            }
            
            unsucessfullDrag(desRow, desColumn);
            
        }
        
    }
    
    private void unsucessfullDrag(int desRow, int desColumn) {
        
        cellMatrix.setPieceCell(startRow, startColumn, pieceBeingDragged);
        cellMatrix.setPlayerCell(startRow, startColumn, currentPlayer);
        
    }
    
    private void updatePaintInstructions(int desRow, int desColumn) {
        
        instruccionActual = new objPaintInstruction(startRow, startColumn, 1);
        vecPaintInstructions.addElement(instruccionActual);
        
        instruccionActual = new objPaintInstruction(desRow, desColumn);
        vecPaintInstructions.addElement(instruccionActual);
        
    }
    
    
    /*Sirve para poder controloar los eventos del mouse, esto es lo que se llama el famoso
     drag and drop
     */
    
    public void mouseClicked(MouseEvent e) {
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
        mouseReleased(e);
    }
    
    public void mousePressed(MouseEvent e) {
        
        if (!hasWon && !firstTime) {
            
            int x = e.getX();
            int y = e.getY();
            
            if ((x > 72 && x < 430) && (y > 72
                    && y < 430)) {
                
                startRow = findWhichTileSelected(y);
                startColumn = findWhichTileSelected(x);
                
                if (cellMatrix.getPlayerCell(startRow, startColumn) == currentPlayer) {
                    
                    pieceBeingDragged = cellMatrix.getPieceCell(startRow, startColumn);
                    cellMatrix.setPieceCell(startRow, startColumn, 6);
                    cellMatrix.setPlayerCell(startRow, startColumn, 0);
                    isDragging = true;
                    
                } else {
                    isDragging = false;
                }
                
            }
            
        }
        
    }
    
    public void mouseReleased(MouseEvent e) {
        
        if (isDragging) {
            
            isDragging = false;
            
            int desRow = findWhichTileSelected(currentY);
            int desColumn = findWhichTileSelected(currentX);
            checkMove(desRow, desColumn);
            repaint();
            
        }
        
    }
    
    public void mouseDragged(MouseEvent e) {
        
        if (isDragging) {
            
            int x = e.getX();
            int y = e.getY();
            
            if ((x > 72 && x < 430) && (y > 72 && y < 430)) {
                
                if (refreshCounter >= refreshRate) {
                    
                    currentX = x;
                    currentY = y;
                    refreshCounter = 0;
                    int desRow = findWhichTileSelected(currentY);
                    int desColumn = findWhichTileSelected(currentX);
                    
                    updatePaintInstructions(desRow, desColumn);
                    repaint();
                    
                } else {
                    refreshCounter++;
                }
                
            }
            
        }
        
    }
    
    public void mouseMoved(MouseEvent e) {
    }
    
    public void gotFocus() {
        repaint();
    }
    
}