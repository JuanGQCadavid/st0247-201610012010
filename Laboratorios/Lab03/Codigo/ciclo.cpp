/**incluimos las librerias que necesitamos */
#include <iostream>
#include <list>
#include <stack>

using namespace std;
/** creamos la clase grafo*/

class Grafo{
  int v;
  list<int> *adj;
  
  public:
/**
*creamos variables de los metodos que pasamos como parametros
*/
  Grafo(int v);
  bool dfs(int v);
   void addicionarArista(int a,int b);
  
  bool tempCiclo();
};
/** en este metodo pasamos el argumento a una lista*/
Grafo::Grafo(int v){
  this->v=v;
  adj = new list<int>[v];
}
/** en este metodo recorremos en tipo de lifo*/
bool Grafo::dfs(int v){
  stack<int>pila;
  bool visitados[v], pilar[v];
  
  for(int i=0;i<v; i++)
    visitados[i]= pilar[i]=false;
  while(true){
    bool vis = false;
    list<int>::iterator punt;
    
    if(!visitados[v]){
      pila.push(v);
      visitados[v]= pilar[v]= true;
    }
    for(punt= adj[v].begin(); punt != adj[v].end();punt++){
      if(pilar[*punt]) 
      return true;
      else if(!visitados[*punt]){
        vis=true;
        break;
      }
    }
    if(!vis){
      pilar[pila.top()]= false;
      pila.pop();
      if(pila.empty()) 
      break;
      v = pila.top();
    }else 
    v= *punt;
  }
  return false;
}

/** en este metodo adicionaamos la arista nueva con su respectiva conexion y  pasamos parametros. empujamos en cola y conectamos */
void Grafo::addicionarArista(int a, int b){
  adj[a].push_back(b);
}

/** en el main llamamos a la clase de grafo y decimos cuantas aristas tendremos y empezamos a enlazar aristas creando nuevas */
int main(int argc, char *argv[]){
  /** x = al numero de aristas que tiene el grafo. */
  Grafo grafo(x); 
  /** el primer valor y esta conectado con z y esto es una arista. */
  grafo.addicionarArista(y,z);
  
  if(grafo.dfs(0)) cout << "tiene ciclo \n";
  else
  cout << "no tiene ciclos \n" ;
  return 0;
}



