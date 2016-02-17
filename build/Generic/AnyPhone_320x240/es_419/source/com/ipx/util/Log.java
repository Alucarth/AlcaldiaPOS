/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipx.util;

/**
 *
 * @author David Torrez
 */
public class Log {
  
    public static void i(final String titulo, final String mensaje) {
 
    System.out.println("\n"+titulo+": "+mensaje);

    }
//     public static void w(final String titulo, final String mensaje){
//        
//         try {
//             
//             
//             try{
//             OutputConnection connection = (OutputConnection)
//                     Connector.open("file:/miFichero.txt;append=true", Connector.WRITE );
//             OutputStream out = connection.openOutputStream();
//             PrintStream output = new PrintStream( out );
//             output.println("\n"+titulo+": "+mensaje);
//            
//             out.close();
//             
//             connection.close();
//             }
//              catch( ConnectionNotFoundException error )
//             {
//             }
//           
////        recordstore = 
//         } catch (IOException ex) {
//             ex.printStackTrace();
//         }
//    }
}
