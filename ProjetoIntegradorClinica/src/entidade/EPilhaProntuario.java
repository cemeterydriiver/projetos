package entidade;


public class EPilhaProntuario {

    private EProntuario topo;
    private EProntuario inicio;
    private EProntuario fim;

    //cria uma pilha vazia
   
    
    public EPilhaProntuario() {
        topo = null;
    }
    

    //verifica se a pilha esta vazia

    public boolean pilhaVazia() {
        return topo == null;
    }

    //insere elemento na pilha --> empilhar

    public void empilhar(EProntuario id) {
        if (topo == null) { //
            topo = id;
            topo.setPilhaproximo(null);
        } else {
            id.setPilhaproximo(topo);
            topo = id;
        }
    }

    //retirar um elemento da pilha --> desempilhar
    public void desempilhar(EProntuario aux) {
        if (pilhaVazia()) {
//            return null;
        }
//        NumerosInteiros aux = topo;
        topo = topo.getPilhaproximo();
        aux.setPilhaproximo(null);
//        return aux;
    }

    //consultar o topo da pilha (sem remover)

    public EProntuario consultarTopo() {
        return topo;
    }
    
    public boolean busca(EProntuario obj){
        EProntuario aux = inicio;
        while(aux != null && obj.getId()> aux.getId()){
            aux = aux.getPilhaproximo();
        }
        if(aux == null)
            return false;
        if(obj.getId()== aux.getId())
            return true;
        return false;
    }
    
    public void insereSemReptidos(EProntuario obj){
        if(!busca(obj)){
            insereElementoOrdenado(obj);
        }
    }

    //ordena
    //recebe um pilha e retorna a pilha ordenada (pilha definitiva)
    public void insereElementoOrdenado(EProntuario obj) {
//        if (inicio == null) {
//            empilhar(obj);
//            return;
//        }
        desempilhar(obj);
        EProntuario auxA, auxP;
        auxA = null;
        auxP = topo;
        while (auxP != null && auxP.getId()< obj.getId()) {
            auxA = auxP;
            auxP = auxP.getPilhaproximo();
        }  
        if(auxA == null){
                       
            empilhar(obj);
            return;
        }
//        if(auxP==null){
//                       
//            desempilhar(obj);
//            return;
//        }
            auxA.setPilhaproximo(obj);
            obj.setPilhaproximo(auxP);
        }
    

    //mostrar os elementos da pilha
    public void mostrarPilha() {
        if (pilhaVazia()) {
            System.out.println("pilha vazia");
            return;
        }
        System.out.println("Elementos da pilha");
        EProntuario aux = topo;
        while (aux != null) {
            System.out.printf("%d\t", aux.getId());
            aux = aux.getPilhaproximo();
        }
        System.out.println();
    }

}

