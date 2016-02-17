/*
 * Generador de Codigo de Control
 * 

 */

package com.ipx.util;

import java.io.UnsupportedEncodingException;


/**
 *
 * @author David
 */

public class CodigoDeControl
{
    
    public CodigoDeControl()
    {
        
    }
    
    public String cambiar(char caracterABuscar,char caracterAReemplazar,String cadena)
    {
        String nuevaCadena;
        nuevaCadena = cadena.replace(caracterABuscar, caracterABuscar);
        return nuevaCadena;
    }
    public String getInvierteNumero(String cadena)
    {
        String numeroInvertido="";
        char[] caracteres = cadena.toCharArray();
        for(int i=0;i<caracteres.length;i++)
        {
         numeroInvertido =caracteres[i]+numeroInvertido;
        }
        return numeroInvertido;
    }
    public int getVerhoeff(String cifra)
    {
        int Mul[][]={{0,1,2,3,4,5,6,7,8,9}, 
                    {1,2,3,4,0,6,7,8,9,5}, 
                    {2,3,4,0,1,7,8,9,5,6}, 
                    {3,4,0,1,2,8,9,5,6,7}, 
                    {4,0,1,2,3,9,5,6,7,8}, 
                    {5,9,8,7,6,0,4,3,2,1}, 
                    {6,5,9,8,7,1,0,4,3,2}, 
                    {7,6,5,9,8,2,1,0,4,3}, 
                    {8,7,6,5,9,3,2,1,0,4}, 
                    {9,8,7,6,5,4,3,2,1,0}};
        int Per[][]={{0,1,2,3,4,5,6,7,8,9},
                    {1,5,7,6,2,8,3,0,9,4}, 
                    {5,8,0,3,7,9,6,1,4,2}, 
                    {8,9,1,6,0,4,3,5,2,7}, 
                    {9,4,5,3,1,2,6,8,7,0}, 
                    {4,2,8,6,5,7,3,9,0,1}, 
                    {2,7,9,3,8,0,6,4,1,5}, 
                    {7,0,4,6,9,1,3,2,5,8}};
        int Inv[]={0,4,3,2,1,5,6,7,8,9};
        int Check=0;
        String cifraInvertida=getInvierteNumero(cifra);
        char [] caracteresInvertidos=cifraInvertida.toCharArray();
        for(int i=0;i<cifraInvertida.length();i++)
        {
            Check=Mul[Check][Per[((i+1)%8)][Integer.parseInt(caracteresInvertidos[i]+"")]];
        }
        
        return Inv[Check];
    }
    public String getRC4(String mensaje,String llave)
    {
        
        int state [] = new int[256];
        char key[]=llave.toCharArray();
        char mensajeArray[] = mensaje.toCharArray();
        Mostrar(key);
        Mostrar(mensajeArray);
        System.out.println("Ingresando a las operaciones");
        
        int x=0,y=0,index1=0,index2=0,Nmen,i;
        String mensajeCifrado="";
        for( i=0;i<256;i++)
        {
            state[i]=i;
        }
        Mostrar(state);
        for( i=0;i<256;i++)
        {
            index2 = (CharUtil.CharToASCII(key[index1])+state[i]+index2)%256;
            IntercambiarValor(state[i],state[index2]);
            index1 = (index1+1)%llave.length();
        }
        Mostrar(state);
        for(i=0;i<mensaje.length();i++)
        {
            x= (x+1)%256;
            y=(state[x]+y)%256;
            IntercambiarValor(state[x],state[y]);
            
            Nmen =(int)( CharUtil.CharToASCII(mensajeArray[i])^(state[(state[x]+state[y])%256]));
            mensajeCifrado=mensajeCifrado+"-"+Integer.toHexString(Nmen);
        }
        return mensajeCifrado.substring(1, mensajeCifrado.length()-1);
    }
    public void Mostrar(char c[])
    {
        System.out.print("\nMostrando vector de chars");
        for (int i =0;i<c.length;i++)
        {
            System.out.print("\n["+c[i]+"]");
        }
    }
    public void Mostrar(int c[])
    {
        System.out.print("\nMostrando vector de ints");
        for (int i =0;i<c.length;i++)
        {
            System.out.print("\n["+c[i]+"]");
        }
    }
    public int getAscii(String caracter)
    {
        char c[] = caracter.toCharArray();
        int resp = CharUtil.CharToASCII(c[0]);
        return resp;
//        try {
//            byte []bytes = caracter.getBytes("US-ASCII");
//            
//            return (int) caracter.charAt(0);
//        } catch (UnsupportedEncodingException ex) {
//            ex.printStackTrace();
//        }
    }
//     public static int CharToASCII(final char character){
//		return (int)character;
//	}
    public void IntercambiarValor(int a,int b)
    {
        int aux = a;
        a=b;
        b=aux;
      
    }
    public String getRellenaCeros(String cad)
    {
        String newCad=cad;
        if(cad.length()<2)
        {
            newCad="0"+newCad;
        }
        return newCad;
    }
    //conversor hexadecimal 
    public String inToHex(int numero)
    {
//       int numero =0;
        int dividendo =0;
        int residuo =0;
        int cociente =0;
        int [] hexal = new int [16];
        int size = 0;
       int otro=0;
         
      
           //Guardamos el numero ingresado en pantalla en la variable dividendo
            dividendo =numero;
            
            if(dividendo==0){
                otro=dividendo;
              
            }
            //Realizar operaciones y almacenar en vector con tamaño definido por contador
            while (dividendo > 0){
                cociente = dividendo / 16;
                residuo = dividendo % 16;
                hexal [size] = residuo;
                size = size + 1;
                dividendo = cociente;
                
            }
        
            
            String numeroHex="";
           for (int i =(size-1);i>=0;i--)
           {
           
           if (hexal[i] >= 0 && hexal[i] <= 9)
           {
               numeroHex = numeroHex +hexal[i];
//                System.out.print(""+hexal);
           }
           else{
               
               switch(hexal[i])
               {
                   case 10:
                       numeroHex = numeroHex +"A";
                       break;
                   case 11:
                       numeroHex = numeroHex +"B";
                       break;
                   case 12:
                       numeroHex = numeroHex +"C";
                       break;
                   case 13:
                       numeroHex = numeroHex +"D";
                       break;
                   case 14: 
                       numeroHex = numeroHex +"E";
                       break;
                   case 15:
                       numeroHex = numeroHex +"F";
                       break;
                       
               }
                 

           }
           }
           return numeroHex;
    }
   
    
}
