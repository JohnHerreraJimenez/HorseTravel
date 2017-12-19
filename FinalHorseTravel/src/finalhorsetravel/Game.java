package finalHorseTravel;


/**
 * 
 * @author Diego BV
 * 
 */
public class Game {
 
 private final int numFilas;
 private final int numColumnas;
 private int[][] tablero;
 
  /*
   Constructor
   */
 public Game(int nRows, int nColumns) {
  numFilas = nRows;
  numColumnas = nColumns;
  tablero     = new int[nRows][nColumns];
 }
  
 public int[][] start(int  val1, int val2)
 {
  resolverProblema(val1, val2, 1);
  return tablero;
 }
 

 private  boolean resolverProblema(int r, int c, int num) {
 tablero[r][c] = num;
 if(num==numFilas*numColumnas) 
  return true;
 int[][] posibles = findPosibles(r, c);
 sortPosibles(posibles);   
 for (int[] posible : posibles)
 {
  if (resolverProblema(posible[0], posible[1], num+1))
  {
   return true;
  }
 }
 tablero[r][c]=0;
 return false;
}
 

 private void sortPosibles(int[][] posibles) {
  for(int i=0; i<posibles.length; i++)
  {
   for(int j=i+1; j<posibles.length; j++) 
   {
    int cuantosPosiblesI = findPosibles(posibles[i][0], posibles[i][1]).length;
    int cuantosPosiblesJ = findPosibles(posibles[j][0], posibles[j][1]).length;
    
    if(cuantosPosiblesJ<cuantosPosiblesI) 
    {
     int tmp0 = posibles[i][0];
     posibles[i][0] = posibles[j][0];
     posibles[j][0] = tmp0;
     int tmp1 = posibles[i][1];
     posibles[i][1] = posibles[j][1];
     posibles[j][1] = tmp1;
    }
   }
  }
 }
 
 private int[][] findPosibles(int r, int c) {
  int[][] resp = new int[8][2];
  int pos  = 0;
  
  if(isValido(r-2,c-1)){
   resp[pos][0]=r-2; 
   resp[pos++][1]=c-1; 
  }
  
  if(isValido(r-2,c+1)){ 
   resp[pos][0]=r-2; 
   resp[pos++][1]=c+1; 
  }
  
  if(isValido(r-1,c-2)){ 
   resp[pos][0]=r-1; 
   resp[pos++][1]=c-2; 
  }
  
  if(isValido(r-1,c+2)){ 
   resp[pos][0]=r-1;
   resp[pos++][1]=c+2; 
  }
  if(isValido(r+2,c-1)){
   resp[pos][0]=r+2; 
   resp[pos++][1]=c-1;
  }
  
  if(isValido(r+2,c+1)){
   resp[pos][0]=r+2; 
   resp[pos++][1]=c+1; 
  }
  
  if(isValido(r+1,c-2)){
   resp[pos][0]=r+1;
   resp[pos++][1]=c-2; 
  }
  
  if(isValido(r+1,c+2)){ 
   resp[pos][0]=r+1; 
   resp[pos++][1]=c+2; 
  }
  
  int[][] tmp = new int[pos][2];
  
  for(int i=0; i<pos; i++){ 
   tmp[i][0] = resp[i][0];
   tmp[i][1]=resp[i][1];
  }
  return tmp;
 }
 
 private boolean isValido(int i, int j) {

  if (i < 0 || i > numFilas-1 || j < 0 || j > numColumnas - 1){
   return false;
  } else {
  return tablero[i][j] == 0;
 }
}
}