#include<iostream>
using namespace std;

#define N 32//N es el numero de reinas y cantidad nxn del ajedrez



void mostrarTabla(int tablero[N][N]);
bool verificador(int tablero[N][N], int fil, int col);
bool resolverBcktking(int tablero[N][N], int col);


bool verificador(int tablero[N][N],int fil, int col){
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

void mostrarTabla(int tablero [N][N]){
	int f,c;
	for(f=0; f<N; f++){
		for(c=0; c<N;c++){
			cout << tablero[f][c] <<" ";
		}
		cout << endl;
	}
}

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



int main(){
  
  int tablero[N][N]={0};
  if(resolverBcktking(tablero,0)==false){
	  cout << "No hay solucion" << endl;	
    } else{
	      mostrarTabla(tablero);
      }
    return 0;
}
