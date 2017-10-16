#include<iostream>
using namespace std;
/*
\ Codigo N REINAS 
\ author: Juan Gonzalo Quiroz
\         Alejandro Díaz Cano
\ Version Lab03.1
*/

/**es el numero de reinas y cantidad nxn del ajedrez*/
#define N 1 


/**\ hacemos referencia a los metodos que vamos a tener en el codigo*/

void mostrarTabla(int tablero[N][N]);
bool verificador(int tablero[N][N], int fil, int col);
bool resolverBcktking(int tablero[N][N], int col);

/**\ usamos este metodo para saber si se puede poner o no la reina   */
bool verificador(int tablero[N][N],int fil, int col){
  
/** usamos f y c para recorrer y dar un estado de verdad al metodo */
	int f,c;
	for(c=0;c<col;c++){
		if(tablero[fil][c]==1){
			return false;
		}
	}
	for(f=fil,c=col;f>=0 && c>=0; f--, c--){
		if(tablero[f][c]==1){
			return false;
		}
	}
	for(f=fil, c=col;c>=0 && f<N; f++, c--){
		if(tablero[f][c]==1){
			return false;
		}
	}
return true;
}

/**Este metodo lo usamos para mostrar un resultado de la solucion en la pantalla con 1 y 0, 1 es igual a reina y 0 es igual a una posición sin reina */
void mostrarTabla(int tablero [N][N]){
	int f,c;
	for(f=0; f<N; f++){
		for(c=0; c<N;c++){
			cout << tablero[f][c] <<" ";
		}
		cout << endl;
	}
}

/**\ Este metodo verifica si se puede poner y la poner y empieza avanzar y retroceder hasta que encuentre la solucion*/
bool resolverBcktking(int tablero[N][N], int col){
	int i;
	if(col>=N){
		return true;
	}
	for(i=0;i<N; i++){
	if(verificador(tablero, i, col) == true){
		tablero[i][col]=1;	
		if(resolverBcktking(tablero,col+1)==true){
			return true;
		}
	tablero[i][col]=0;
	}
}
	return false;
}



/**\ en el main llamamos todos los metdos y mostramos en pantalla la solucion llamando al metodo de resolver Backtracking*/
int main(){
  
  int tablero[N][N]={0};
  if(resolverBcktking(tablero,0)==false){
	  cout << "No hay solucion" << endl;	
    } else{
	      mostrarTabla(tablero);
      }
    return 0;
}
