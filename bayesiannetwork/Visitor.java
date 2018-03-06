package bayesiannetwork;

import bayesiannetwork.Pars.EvidenceVariableContext;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Visitor extends bayesianBaseVisitor<Type> {
        //aqui se almacena el texto de errores y resultados
        private String texto;
        private NodeControl control;
        private CopyOnWriteArrayList<Pareja> listaPares;
        private CopyOnWriteArrayList<Pareja2> listaPares2;
        private CopyOnWriteArrayList<Pareja3> listaPares3;
        
        public Visitor() { 
            this.texto = "";
            this.control = new NodeControl();
            this.listaPares = new CopyOnWriteArrayList<>();
            this.listaPares2 = new CopyOnWriteArrayList<>();
            this.listaPares3 = new CopyOnWriteArrayList<>();
        }
        
        @Override 
        public Type visitBayes(Pars.BayesContext ctx) {                 
            Type probResult = visitChildren(ctx);
            if(probResult==null){
                this.texto+="¡ Parsing de la gramatica ingresada : \n \n";
                this.texto+= "Error: Existe un error en la sintaxis de la expresión!\n";
                return new Error("");
            }
                 
            if(this.texto.equals("")){
               this.texto+="¡ Parsing de la gramatica ingresada: \n \n";
               this.texto= "¡No hay errores en la gramática!\n";
            }  
            else{
                this.texto+="¡ Parsing de la gramatica ingresada: \n \n";
                this.texto+= "Error: Existe un error en la sintaxis de la expresión!\n";
                return new Error("");
            }            
            
            if(completamenteDescrita()){
                this.texto+= "\nla Red Bayesiana esta completamente descrita: \n"
                        + "Nota: La red bayesiana está completamente descrita!\n\n"; 
                
               
                this.texto+= formaCompacta();
                
                
                this.texto+="\n"+factores();
            }
            else{
                this.texto+= "Error: La red bayesiana no esta completamente descrita, revise las sentencias!\n";    
            }
            
          
            
            
            return new Type(new Variable("",false)); 
        }
        
        @Override
        public Type visitFactor(Pars.FactorContext ctx) {        
            float prob;
            String queryVariableName = "";
            Variable query= null;
                   
            try{
             Type tipo = visit(ctx.queryVariable(0));
             query= tipo.getVariable();     
            }
            catch(Exception e){
                this.texto+="¡ Parsing de la gramatica ingresada: \n \n";
                this.texto+= "Error: Se ingreso un valor incorrecto en un Query Variable!\n";
                return new Error("");
            }
      
            try{
                if(ctx.FLOAT_VAL()!=null){
                    prob= Float.parseFloat(ctx.FLOAT_VAL().getText()); 
                }
                else{
                    try{
                        prob = Float.parseFloat(ctx.NUM().getText());
                    }
                    catch(Exception e){
                        this.texto+="¡ Parsing de la gramatica ingresada: \n \n";
                        this.texto+= "Error: Se ingresó un valor que no es un número!\n";
                        return new Error("");
                    }                  
                }
                
                // aqui se valida que la prueba es correcta
                if(prob>1 || prob<0){
                    this.texto+="¡ Parsing de la gramatica ingresada: \n \n";
                    this.texto+= "Error: Ingrese una probabilidad correcta, entre 0 y 1:\n";
                    return new Error("");
                }
                 
            }catch(Exception e){
                this.texto+="¡ Parsing de la gramatica ingresada: \n \n";
                this.texto+= "La probabilidad  de la variable: "+queryVariableName+" no es un número.\n";
                return new Error("");
            }
                       
            // Get the evidence variables        
            ArrayList<Variable> evidences= new ArrayList();
            if(ctx.GIVEN() != null){
                for(EvidenceVariableContext var: ctx.evidenceVariable()){
                    try{
                        Type tipo = visit(var);
                        evidences.add(tipo.getVariable());
                    }
                    catch(Exception e){
                        this.texto+="¡ PARSING DE LA GRAMÁTICA INGRESADA: \n \n";
                        this.texto+= "Error: Se ingresó un nombre de variable incorrecto.\n";
                        return new Error("");
                    }               
                }
            }            
     
            if(evidences==null|| evidences.isEmpty()){
                Nodo node = new Nodo(query,prob);             
                control.getListaNodes().add(node);
            }
            else{
                ;
                Nodo node = new Nodo(query,evidences,prob);             
                control.getListaNodes().add(node);
            }
            return new Type(query,prob,evidences);                
        }
         
	@Override public Type visitQueryVariable(Pars.QueryVariableContext ctx) {
            String variableName = ctx.ID().getText();
            Variable var;
            if(!variableName.equals("<missing ID>")){      
                if(ctx.NOT()!=null){
                    var= new Variable(variableName,true);
                }
                else{
                    var= new Variable(variableName,false);
                }
            }
            else{
                 this.texto+="¡ PARSING DE LA GRAMÁTICA INGRESADA: \n \n";
                 this.texto+= "Error: Hace falta un identificador de una probabilidad!\n";
                 return new Error("");
            }           
            return new Type(var);  
        }

       
        @Override
        public Type visitEvidenceVariable(Pars.EvidenceVariableContext ctx) {
            String variableName = ctx.ID().getText();
            Variable var;
            if(!variableName.equals("<missing ID>")){
                if(ctx.NOT()!=null){
                    var= new Variable(variableName,true);
                }
                else{
                    var= new Variable(variableName,false);
                }
            }      
            else{
                 this.texto+="¡ Parsing de la gramatica ingresada: \n \n";
                 this.texto+= "Error: Hace falta un identificador de una probabilidad!\n";
                 return new Error("");
            }
            return new Type(var); 
        }
	       
        public String getTexto() {
            return texto;
        }
        
        public boolean completamenteDescrita(){
            boolean descrita= true;
            for(Nodo probabilidad :this.control.getListaNodes()){
                if(probabilidad.getEvidenceVariables()!=null){
                    descrita = revisarNodo(probabilidad);
                    if(!descrita){
                        return descrita;
                    }
                }
            }
            
            return descrita;
        }
        
        public boolean revisarNodo(Nodo nodo){
            boolean total = false;
            boolean res = false;
            boolean rev= false;
            boolean rev2= false;
            boolean simple= false;
            
            for(Nodo probabilidad :this.control.getListaNodes()){ 
                    
                    switch(nodo.getEvidenceVariables().size()){
                        case 1:
                            simple=true;
                            if(nodo.getQueryVariable().equals(probabilidad.getQueryVariable())){
                                
                                try{
                                    if(nodo.getEvidenceVariables().get(0).isNegada()&& 
                                      !probabilidad.getEvidenceVariables().get(0).isNegada()){
                                        total= true;
                                    }
                                    else if(!nodo.getEvidenceVariables().get(0).isNegada()&& 
                                           probabilidad.getEvidenceVariables().get(0).isNegada()){
                                        total = true;
                                    }
                                    else{
                                        res= revProbUnica(nodo);
                                    }
                                }
                                catch(Exception e){
                                    total= true;
                                    res= revProbUnica(nodo);
                                }                               
                            }
                            break;
                        case 2:
                            if(nodo.getQueryVariable().equals(probabilidad.getQueryVariable())){
                                boolean a1= probabilidad.getEvidenceVariables().get(0).isNegada();
                                boolean a2= probabilidad.getEvidenceVariables().get(1).isNegada();
                                ingresarPares(a1,a2);                               
                            }
                            break;
                        
                        case 3:
                            if(nodo.getQueryVariable().equals(probabilidad.getQueryVariable())){
                                boolean a1= probabilidad.getEvidenceVariables().get(0).isNegada();
                                boolean a2= probabilidad.getEvidenceVariables().get(1).isNegada();
                                boolean a3= probabilidad.getEvidenceVariables().get(2).isNegada();
                                ingresarPares2(a1,a2,a3);
                            }
                            break;
                        
                        case 4:
                            if(nodo.getQueryVariable().equals(probabilidad.getQueryVariable())){
                                boolean a1= probabilidad.getEvidenceVariables().get(0).isNegada();
                                boolean a2= probabilidad.getEvidenceVariables().get(1).isNegada();
                                boolean a3= probabilidad.getEvidenceVariables().get(2).isNegada();
                                boolean a4= probabilidad.getEvidenceVariables().get(3).isNegada();                            
                                ingresarPares3(a1,a2,a3,a4);                              
                            }
                            break;                         
                    }                           
            }
            if(nodo.getEvidenceVariables().size()>=2){
                switch(nodo.getEvidenceVariables().size()){
                    case 2:
                        rev= revisarPares(nodo);
                        rev2 =revProbUnica2(nodo, 2);
                        
                        if(simple){
                             return total && res && rev && rev2;
                        }
                        else{
                            return rev && rev2;
                        }
                                            
                    case 3:
                        rev= revisarPares2(nodo);
                        rev2= revProbUnica2(nodo, 3);
                        return total && rev && rev2;
                       
                    case 4:
                        rev= revisarPares3(nodo);
                        rev2= revProbUnica2(nodo, 4);
                        return rev && rev2;
                    default:
                        break;
                }               
            }         
            return res && total;        
        }
        
        public boolean revProbUnica(Nodo node){
            int counter=0;
            for(Nodo n:this.control.getListaNodes()){
                if(n.getEvidenceVariables()==null || n.getEvidenceVariables().isEmpty()){
                    if(n.getQueryVariable().getName().equals(node.getEvidenceVariables().get(0).getName())){
                        return true;
                    }
                }
            }
            
            for(Nodo n: this.control.getListaNodes()){
                if(n.getEvidenceVariables()!=null && !n.getEvidenceVariables().isEmpty()){
                    if(n.getQueryVariable().getName().equals(node.getEvidenceVariables().get(0).getName())){
                        counter++;
                    }
                }
            }
            if(counter==2){
                return true;
            }
            
            return false;
        }
        
        public boolean revProbUnica2(Nodo node, int num){
            ArrayList<Boolean> bools= new ArrayList(); 
            for(Variable var :node.getEvidenceVariables()){
                for(Nodo nody : this.control.getListaNodes()){
                    try{
                        if(nody.getQueryVariable().getName().equals(var.getName())){
                            try{
                                if(nody.getEvidenceVariables()==null){
                                    bools.add(true);
                                }                                
                            }
                            catch(Exception e){
                                   bools.add(true);
                            }        
                       }
                    }
                    catch(Exception e){               
                    }                   
                } 
            }
            
            switch (num) {
                case 2:
                    return bools.size()==2;
                case 3:
                    return bools.size()==3;
                case 4:
                    return bools.size()==4;
                default:
                    break;
            }
            return false;           
        }
        
        public boolean ingresarPares(boolean a1, boolean a2){
            this.listaPares.add(new Pareja(a1,a2));
            return true;
        }
        
        public boolean ingresarPares2(boolean a1, boolean a2, boolean a3){
            this.listaPares2.add(new Pareja2(a1,a2,a3));
            return true;
        }
         
        public boolean ingresarPares3(boolean a1, boolean a2,boolean a3, boolean a4){
            this.listaPares3.add(new Pareja3(a1,a2,a3,a4));
            return true;
        }
        
        public boolean revisarPares(Nodo nodo){
            if(this.listaPares.size()==4){
                for(Pareja par: this.listaPares){
                    Pareja a1 = par;
                    this.listaPares.remove(par);
                    if(this.listaPares.contains(a1)){
                        return false;
                    }
                    this.listaPares.add(a1);
                }
                
              this.listaPares.clear();
              return true;
            }
            this.listaPares.clear();
            return false;
            
        }
            
        public boolean revisarPares2(Nodo nodo){
            if(this.listaPares2.size()==8){
                for(Pareja2 par: this.listaPares2){
                    Pareja2 a1 = par;
                    this.listaPares2.remove(par);
                    if(this.listaPares2.contains(a1)){
                        return false;
                    }
                    this.listaPares2.add(a1);
                }
                
              this.listaPares2.clear();
              return true;
            }
            this.listaPares2.clear();
            return false;
            
        }
        
          public boolean revisarPares3(Nodo nodo){
            if(this.listaPares3.size()==16){
                for(Pareja3 par: this.listaPares3){
                    Pareja3 a1 = par;
                    this.listaPares3.remove(par);
                    if(this.listaPares3.contains(a1)){
                        return false;
                    }
                    this.listaPares3.add(a1);
                }
                
              this.listaPares3.clear();
              return true;
            }
            this.listaPares3.clear();
            return false;     
        }
          
        
        public String formaCompacta(){
            String total= "Distribución conjunta de la red en forma compacta: \n\n";
            boolean what=false;
                    
            for(Nodo proub: this.control.getListaNodes()){
                if(proub.getEvidenceVariables()!=null){
                    for(Variable evidence: proub.getEvidenceVariables()){
                        if(evidence.isNegada()){
                            what=true;
                            break;
                        }
                    }
                    if(!what){
                        total+=proub.toString()+"\n";
                    }
                    what=false;
                }
                else{
                    total+=proub.toString()+"\n";
                }    
            }
            return total;
        }
        
        
        public String factores(){
            String total = "Los Factores de la red Bayesiana son: \n\n";
            for(Nodo proub: this.control.getListaNodes()){
                total+=proub.otherToString(false)+"\n";
                total+=proub.otherToString(true)+"\n";
            }      
            return total;
        }
          
}
