
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapearmemoriacache;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Rafael
 */
public class MapearMemoriaCache {

    public static void main(String[] args) {
        int numbers;        
        int validade=0;       
        int option;
        
        do{
        JOptionPane.showMessageDialog(null, "\nSIMULADOR CACHE\n==================\n1 - Mapeamento Direto\n2 - Totalmente Associativa\n3 - Associativa por Conjunto\n 0- SAIR");
        option= Integer.parseInt(JOptionPane.showInputDialog("Informe sua Opção: "));
        
        
        if(option==1){
        // MAPEAMENTO DIRETO
        JTextArea fimCache = new JTextArea (10,15);
        JScrollPane completo = new JScrollPane (fimCache);
        JOptionPane.showMessageDialog(null, "Mapeamento Direto - Slot = 4 - Tamanho da Palavra = 8 bits");        
        int contMiss=0;
        int contHit=0;        
        MapeamentoDireto mDireto = new MapeamentoDireto();        
        mDireto.setSlot(4);
        mDireto.setTamanhoPlavra(8);
        int acessoCache;
        acessoCache=Integer.parseInt(JOptionPane.showInputDialog("Informte velocidade de Acesso a Memória Cache: ","Velocidade MemCache"));
        mDireto.setAcessoCache(acessoCache);
        int acessoPrincipal;
        acessoPrincipal=Integer.parseInt(JOptionPane.showInputDialog("Informte velocidade de Acesso a Memória Principal: ","Velocidade MemPrinc"));
        mDireto.setAcessoPrincipal(acessoPrincipal);
        int vetorDireto[] =new int[mDireto.getSlot()];
        
        do{
        numbers = Integer.parseInt(JOptionPane.showInputDialog("Informe DADO: ou -1 (para finalizar)","DADO"));               
                
        if (numbers%4==0 && validade==0){
            vetorDireto[0]=numbers;
            validade=1;            
            contMiss++;
            mDireto.setMiss(contMiss);
        }
        
        else if (numbers%4==1 && validade==0){
            vetorDireto[1]=numbers;
            validade=1;           
            contMiss++;
            mDireto.setMiss(contMiss);
        }
        
        else if (numbers%4==2 && validade==0){
            vetorDireto[2]=numbers;
            validade=1;             
            contMiss++;
            mDireto.setMiss(contMiss);
        }
        
        else if (numbers%4==3 && validade==0){
            vetorDireto[3]=numbers;
            validade=1;            
            contMiss++;
            mDireto.setMiss(contMiss);
        }
        
        else if (numbers%4==0 && validade==1){
            if(vetorDireto[0]!=numbers){
            vetorDireto[0]=numbers;
            contMiss++;
            mDireto.setMiss(contMiss);
            }
            else if(vetorDireto[0]==numbers){
            contHit++;
            mDireto.setHit(contHit);
            }
        }
        
        else if (numbers%4==1 && validade==1){
            if(vetorDireto[1]!=numbers){
            vetorDireto[1]=numbers;
            contMiss++;
            mDireto.setMiss(contMiss);
            }
            else if(vetorDireto[1]==numbers){
            contHit++;
            mDireto.setHit(contHit);
            }
        }
        
        else if (numbers%4==2 && validade==1){
            if(vetorDireto[2]!=numbers){
            vetorDireto[2]=numbers;
            contMiss++;
            mDireto.setMiss(contMiss);
            }
            else if(vetorDireto[2]==numbers){
            contHit++;
            mDireto.setHit(contHit);
            }
        }
        
        else if (numbers%4==3 && validade==1){
            if(vetorDireto[3]!=numbers){
            vetorDireto[3]=numbers;
            contMiss++;
            mDireto.setMiss(contMiss);
            }
            else if(vetorDireto[3]==numbers){
            contHit++;
            mDireto.setHit(contHit);
            }
        }
        
        }while (numbers != -1);
        
        double tempoParalelo=(mDireto.getAcessoCache()*mDireto.getHit())+(mDireto.getAcessoPrincipal()*mDireto.getMiss());
        double tempoSequencial=((mDireto.getHit()+mDireto.getMiss())*mDireto.getAcessoCache())+(mDireto.getAcessoPrincipal()*mDireto.getMiss());        
        JOptionPane.showMessageDialog(null, "Total Cache Hit: "+mDireto.getHit()+"\n Total Cache Miss: "+mDireto.getMiss()+
                "\n Tempo Acesso Paraleo: "+tempoParalelo+" ns."+"\n Tempo Acesso Paraleo: "+tempoSequencial+" ns."+"\n SpeedUp: "+tempoSequencial/tempoParalelo+" ns.");
        fimCache.setText("ENDEREÇO\tDADO\n");
        for (int i=0; i<mDireto.getSlot(); i++) {
        fimCache.append(i+"\t"+vetorDireto[i]+"\n");            
        }
        
        JOptionPane.showMessageDialog(null, completo, "MAPEAMENTO CACHE", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        if(option==2){
        //TOTALMENTE ASSOCIATIVA
        JTextArea fimCache = new JTextArea (10,15);
        JScrollPane completo = new JScrollPane (fimCache);
        JOptionPane.showMessageDialog(null, "Totalmente Associativa - Slot = 1 - Tamanho da Palavra = 8 bits - Associatividade = 4 - Substituição: LRU"); 
        int contMiss=0;
        int contHit=0;
        TotalmenteAssociativa tAssociativa = new TotalmenteAssociativa();
        tAssociativa.setSlot(1);
        tAssociativa.setTamanhoPlavra(8);
        tAssociativa.setAssociatividade(4);
        int acessoCache;
        acessoCache=Integer.parseInt(JOptionPane.showInputDialog("Informte velocidade de Acesso a Memória Cache: ","Velocidade MemCache"));
        tAssociativa.setAcessoCache(acessoCache);
        int acessoPrincipal;
        acessoPrincipal=Integer.parseInt(JOptionPane.showInputDialog("Informte velocidade de Acesso a Memória Principal: ","Velocidade MemPrinc"));
        tAssociativa.setAcessoPrincipal(acessoPrincipal);
        tAssociativa.setSubstituir("LRU");
        int vetorAssociativa[] =new int[tAssociativa.getAssociatividade()];
        int vetorGuardar[] = new int[tAssociativa.getAssociatividade()];
        int total=0;  
        for(int i=0;i<tAssociativa.getAssociatividade();i++){
    	vetorAssociativa[i]=-10;    	
    }       
               
        do{
        numbers = Integer.parseInt(JOptionPane.showInputDialog("Informe DADO: ou -1 (para finalizar)","DADO"));
        
        if(total==0 &&numbers!=-1){
            vetorAssociativa[0]=numbers;
            total=total+1;
            contMiss=contMiss+1;
            tAssociativa.setMiss(contMiss);
            vetorGuardar[0]=numbers; 
        } 
        
        else if(numbers==vetorAssociativa[0] && total>0 &&numbers!=-1 && vetorAssociativa[0]!=-10){        	
        	
            if(vetorGuardar[3]==numbers){              
                vetorGuardar[3]=vetorGuardar[2];
                vetorGuardar[2]=vetorGuardar[1];
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[0]=numbers;                
            }
            else if(vetorGuardar[2]==numbers){                
                vetorGuardar[0]=vetorGuardar[2];
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[2]=vetorGuardar[1];                               
            }
            else if(vetorGuardar[1]==numbers){                
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[0]=numbers;
            }           	
        	total=total+1;
            contHit=contHit+1; 
            tAssociativa.setHit(contHit);
        }
        
       else if(numbers==vetorAssociativa[1] &&total>1 &&numbers!=-1 &&vetorAssociativa[1]!=-10){

            if(vetorGuardar[3]==numbers){
                vetorGuardar[3]=vetorGuardar[2];
                vetorGuardar[2]=vetorGuardar[1];
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[0]=numbers;                
            }
            else if(vetorGuardar[2]==numbers){
                vetorGuardar[2]=vetorGuardar[1];
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[0]=numbers;                               
            }
            else if(vetorGuardar[1]==numbers){
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[0]=numbers;
            }                   	
        	total++;
        	contHit++;
                tAssociativa.setHit(contHit);
        }
        
       else if(numbers!=vetorAssociativa[0] &&total>0 &&numbers!=-1 &&vetorAssociativa[1]==-10){
    	    if(total<4){
	       	vetorAssociativa[1]=numbers; 
	       	vetorGuardar[1]=vetorGuardar[0];
	       	vetorGuardar[0]=numbers;
	       	total++;
	       	contMiss++;
                tAssociativa.setMiss(contMiss);
	       	}	 	
	      
       }
        
   	
       else if(numbers==vetorAssociativa[2] &&total>1 &&numbers!=-1 &&vetorAssociativa[2]!=-10){

   	       	if(vetorGuardar[3]==numbers){
   	               vetorGuardar[3]=vetorGuardar[2];
   	               vetorGuardar[2]=vetorGuardar[1];
   	               vetorGuardar[1]=vetorGuardar[0];
   	               vetorGuardar[0]=numbers;                
   	           }
   	           else if(vetorGuardar[2]==numbers){
   	        	   vetorGuardar[2]=vetorGuardar[1];
   	               vetorGuardar[1]=vetorGuardar[0];
   	               vetorGuardar[0]=numbers;                                
   	           }
   	           else if(vetorGuardar[1]==numbers){
   	               vetorGuardar[1]=vetorGuardar[0];
   	               vetorGuardar[0]=numbers;
   	           }
   	                   	
   	       	total++;
   	       	contHit++;
                tAssociativa.setHit(contHit);
   	}
   	        
   	else if(numbers!=vetorAssociativa[2] &&total>0 &&numbers!=-1 &&vetorAssociativa[2]==-10){
   		       	if(total<4){
   		       	vetorAssociativa[2]=numbers; 
   		       	vetorGuardar[2]=vetorGuardar[1];
   		       	vetorGuardar[1]=vetorGuardar[0];
   		       	vetorGuardar[0]=numbers;
   		       	total++;
   		       	contMiss++;
                        tAssociativa.setMiss(contMiss);
   		       	}
   	}
        
   	else if(numbers==vetorAssociativa[3] &&total>1 &&numbers!=-1 &&vetorAssociativa[3]!=-10){

   	       	if(vetorGuardar[3]==numbers){
   	               vetorGuardar[3]=vetorGuardar[2];
   	               vetorGuardar[2]=vetorGuardar[1];
   	               vetorGuardar[1]=vetorGuardar[0];
   	               vetorGuardar[0]=numbers;                
   	           }
   	           else if(vetorGuardar[2]==numbers){
   	        	   vetorGuardar[2]=vetorGuardar[1];
   	               vetorGuardar[1]=vetorGuardar[0];
   	               vetorGuardar[0]=numbers;                                
   	           }
   	           else if(vetorGuardar[1]==numbers){
   	               vetorGuardar[1]=vetorGuardar[0];
   	               vetorGuardar[0]=numbers;
   	           }   	                   	
   	       	total++;
   	       	contHit++;
                tAssociativa.setHit(contHit);
   	}
   	        
   	else if(numbers!=vetorAssociativa[3] &&total>0 &&numbers!=-1 &&vetorAssociativa[3]==-10){
   		       	if(total<4){
   		       	vetorAssociativa[3]=numbers; 
   		       	vetorGuardar[3]=vetorGuardar[2];
   		       	vetorGuardar[2]=vetorGuardar[1];
   		       	vetorGuardar[1]=vetorGuardar[0];
   		       	vetorGuardar[0]=numbers;
   		       	total++;
   		       	contMiss++;
                        tAssociativa.setMiss(contMiss);
   		       	}
   	}
        
   	else if(total>=4 && numbers!=vetorAssociativa[0] && vetorAssociativa[1]!=numbers && vetorAssociativa[2]!=numbers && vetorAssociativa[3]!=numbers &&numbers!=-1){
   	    	if(vetorGuardar[3]==vetorAssociativa[0]){
                vetorAssociativa[0]=numbers;
                vetorGuardar[3]=vetorGuardar[2];
                vetorGuardar[2]=vetorGuardar[1];
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[0]=numbers;                
            }
            else if(vetorGuardar[3]==vetorAssociativa[1]){
                vetorAssociativa[1]=numbers;
                vetorGuardar[3]=vetorGuardar[2];
                vetorGuardar[2]=vetorGuardar[1];
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[0]=numbers;                
            }
            else if(vetorGuardar[3]==vetorAssociativa[2]){
                vetorAssociativa[2]=numbers;
                vetorGuardar[3]=vetorGuardar[2];
                vetorGuardar[2]=vetorGuardar[1];
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[0]=numbers;                
            }
            else if(vetorGuardar[3]==vetorAssociativa[3]){
                vetorAssociativa[3]=numbers;
                vetorGuardar[3]=vetorGuardar[2];
                vetorGuardar[2]=vetorGuardar[1];
                vetorGuardar[1]=vetorGuardar[0];
                vetorGuardar[0]=numbers;                
            }
            total++;
            contMiss++;
            tAssociativa.setMiss(contMiss);
   	    }
     
    }while(numbers!=-1);
       
        /*for (int i=0; i<tAssociativa.getAssociatividade(); i++) {
    		System.out.println(vetorAssociativa[i]);
        }
    	for (int i=0; i<tAssociativa.getAssociatividade(); i++) {
    		System.out.println(vetorGuardar[i]);
        }*/
    	
    	double tempoParalelo=(tAssociativa.getAcessoCache()*tAssociativa.getHit())+(tAssociativa.getAcessoPrincipal()*tAssociativa.getMiss());
        double tempoSequencial=((tAssociativa.getHit()+tAssociativa.getMiss())*tAssociativa.getAcessoCache())+(tAssociativa.getAcessoPrincipal()*tAssociativa.getMiss());
        JOptionPane.showMessageDialog(null, "Total Cache Hit: "+tAssociativa.getHit()+"\n Total Cache Miss: "+tAssociativa.getMiss()+
                "\n Tempo Acesso Paraleo: "+tempoParalelo+" ns."+"\n Tempo Acesso Paraleo: "+tempoSequencial+" ns."+"\n SpeedUp: "+tempoSequencial/tempoParalelo+" ns.");
        
        fimCache.setText("ENDEREÇO\tDADO\n");
        for (int i=0; i<tAssociativa.getAssociatividade(); i++) {
            if(vetorAssociativa[i]==-10){
            fimCache.append(i+"\t"+0+" = VAZIO"+"\n");
        }else{
        fimCache.append(i+"\t"+vetorAssociativa[i]+"\n");            
        }
        }
        JOptionPane.showMessageDialog(null, completo, "MAPEAMENTO CACHE", JOptionPane.INFORMATION_MESSAGE);
        
        }
        
        if(option==3){
        //ASSOCIATIVA POR CONJUNTO
        JTextArea fimCache = new JTextArea (10,15);
        JScrollPane completo = new JScrollPane (fimCache);
        JOptionPane.showMessageDialog(null, "Associativa por Conjunto - Slot = 2 - Tamanho da Palavra = 8 bits - Substituição: FIFO"); 
        int contMiss=0;
        int contHit=0;
        AssociativaConjunto aConjunto = new AssociativaConjunto();
        aConjunto.setSlot(2);
	int acessoCache;
        acessoCache=Integer.parseInt(JOptionPane.showInputDialog("Informte velocidade de Acesso a Memória Cache: ","Velocidade MemCache"));
        aConjunto.setAcessoCache(acessoCache);
        int acessoPrincipal;
        acessoPrincipal=Integer.parseInt(JOptionPane.showInputDialog("Informte velocidade de Acesso a Memória Principal: ","Velocidade MemPrinc"));
        aConjunto.setAcessoPrincipal(acessoPrincipal);
	int vetorConjunto[] =new int[aConjunto.getSlot()*2];	   
	int total=0;  
	int contadorP=0;
	int contadorI=0;
	for(int i=0;i<(aConjunto.getSlot()*2);i++){
	    	vetorConjunto[i]=-10;    	
	    } 
        
        do{
	        numbers = Integer.parseInt(JOptionPane.showInputDialog("Informe DADO: ou -1 (para finalizar)","DADO"));
	        
	        if(numbers%2==0 && numbers!=-1){
	        	if(vetorConjunto[0]==-10){
	        		vetorConjunto[0]=numbers;
                                contMiss++;
	        		aConjunto.setMiss(contMiss);
	        		total++;
	        	}
	        	else if(vetorConjunto[0]!=-10 && vetorConjunto[1]==-10){
	        		vetorConjunto[1]=numbers;
	        		contMiss++;
                                aConjunto.setMiss(contMiss);
	        		total++;
	        	}
	        	else if(vetorConjunto[0]==numbers || vetorConjunto[1]==numbers){
	        		contHit++;
                                aConjunto.setHit(contHit);
	        		total++;
	        	}
	        	else if(vetorConjunto[0]!=-10 && vetorConjunto[1]!=-10 && vetorConjunto[0]!=numbers && vetorConjunto[1]!=numbers && numbers!=-1){
	        		if(contadorP%2==0){
	        			vetorConjunto[0]=numbers;
	        			contMiss++;
                                        aConjunto.setMiss(contMiss);
	        			total++;
	        			contadorP++;
	        		}else if(contadorP%2!=0){
	        			vetorConjunto[1]=numbers;
	        			contMiss++;
                                        aConjunto.setMiss(contMiss);
	        			total++;
	        			contadorP++;
	        		}
	        	}
	        } //vetor 0,1
	        
	        else if(numbers%2!=0 && numbers!=-1){
	        	if(vetorConjunto[2]==-10){
	        		vetorConjunto[2]=numbers;
	        		contMiss++;
                                aConjunto.setMiss(contMiss);
	        		total++;
	        	}
	        	else if(vetorConjunto[2]!=-10 && vetorConjunto[3]==-10){
	        		vetorConjunto[3]=numbers;
	        		contMiss++;
                                aConjunto.setMiss(contMiss);
	        		total++;
	        	}
	        	else if(vetorConjunto[2]==numbers || vetorConjunto[3]==numbers){
	        		contHit++;
                                aConjunto.setHit(contHit);
	        		total++;
	        	}
	        	else if(vetorConjunto[2]!=-10 && vetorConjunto[3]!=-10 && vetorConjunto[2]!=numbers && vetorConjunto[3]!=numbers && numbers!=-1){
	        		if(contadorI%2==0){
	        			vetorConjunto[2]=numbers;
	        			contMiss++;
                                        aConjunto.setMiss(contMiss);
	        			total++;
	        			contadorI++;
	        		}else if(contadorI%2!=0){
	        			vetorConjunto[3]=numbers;
	        			contMiss++;
                                        aConjunto.setMiss(contMiss);
	        			total++;
	        			contadorI++;
	        		}
	        	}
	        	
	        }
	    }while(numbers!=-1);
	    
	   /* for (int i=0; i<(aConjunto.getSlot()*2); i++) {
    		System.out.println(vetorConjunto[i]);
        }    */	
    	double tempoParalelo=(aConjunto.getAcessoCache()*aConjunto.getHit())+(aConjunto.getAcessoPrincipal()*aConjunto.getMiss());
        double tempoSequencial=(total*aConjunto.getAcessoCache())+(aConjunto.getAcessoPrincipal()*aConjunto.getMiss());
        JOptionPane.showMessageDialog(null, "Total Cache Hit: "+aConjunto.getHit()+"\n Total Cache Miss: "+aConjunto.getMiss()+
                "\n Tempo Acesso Paraleo: "+tempoParalelo+" ns."+"\n Tempo Acesso Paraleo: "+tempoSequencial+" ns."+"\n SpeedUp:"+tempoSequencial/tempoParalelo);
        
        fimCache.setText("ENDEREÇO\tDADO\n");
        for (int i=0; i<aConjunto.getSlot()*2; i++) {
            if(vetorConjunto[i]==-10){
            fimCache.append(i+"\t"+0+" = VAZIO"+"\n");
        }else{
        fimCache.append(i+"\t"+vetorConjunto[i]+"\n"); 
            }
        }        
        JOptionPane.showMessageDialog(null, completo, "MAPEAMENTO CACHE", JOptionPane.INFORMATION_MESSAGE);

        }
        
        if(option>3){
            JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
        
        }while(option!=0);
        
    }  
        
}
