 package com.mobiwire.startup;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.ipx.http.ConectorRest;
import com.ipx.http.Conexion;
import com.ipx.http.Rest;
import com.ipx.http.switchDisplay;
import com.ipx.json.Autentificacion;
import com.ipx.json.Cliente;
import com.ipx.json.Codigo;
import com.ipx.json.Colores;
import com.ipx.json.ConsultaCliente;
import com.ipx.json.ConsultaDatos;
import com.ipx.json.Cuenta;
import com.ipx.json.Factura;
import com.ipx.json.Inf;
import com.ipx.json.Infraccion;
import com.ipx.json.Infraccion_1;
import com.ipx.json.InvoiceItems;
import com.ipx.json.ListaUsuarios;

import com.ipx.json.Products;
import com.ipx.json.RecargaPos;
import com.ipx.json.RegistroCliente;
import com.ipx.json.Usuarios;
import com.ipx.json.Vehiculo;
import com.ipx.json.Zona;
import com.ipx.json.solicitudFactura;
import com.ipx.util.BmpArray;
import com.ipx.util.CharUtil;
import com.ipx.util.CodigoDeControl;
import com.ipx.util.DateUtil;
import com.ipx.util.Numero_a_Letra;
import com.ipx.util.Tokenizer;
import com.mobiwire.print.DeviceOps;
import com.nbbse.printer.Printer;
import com.sagereal.utils.BMPGenerator;
import de.enough.polish.io.RmsStorage;
import de.enough.polish.ui.*;
//import de.enough.polish.ui.TableItem;
import de.enough.polish.ui.SplashScreen;
import de.enough.polish.util.TableData;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;  
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.rms.RecordStore;
import net.sf.microlog.core.Logger;
import net.sf.microlog.core.LoggerFactory;
import net.sf.microlog.core.PropertyConfigurator;

import org.netbeans.microedition.util.SimpleCancellableTask;


public class StartApp extends MIDlet implements CommandListener {

    // logger instance for this class
    private static final Logger logme = LoggerFactory.getLogger(StartApp.class);
    //constantes para la comunicacion 
    private final int AUTENTIFICACION = 0;
    private final int CLIENTE=1;
    private final int GUARDARFACTURA=2;
    private final int VERSION=3;
    private final int CANTPROD=4;
    private final int PRERECARGA=6;
    private final int RECARGA=7;
    private final int REGISTRARCLIENTE=5;
    private final int CONSULTA=10;
    private final int REGISTRARINFRACCION=11;
    private final int CONSULTAUSUARIOS=12;
    
    private final RmsStorage storage;
    
    private boolean midletPaused = false;
    //variables de comunicacion
       
 
    //datos Cuenta
    private String llave;
    private Cuenta cuenta;
    private Printer imprimir;
    private Vector listaProductos;
    private TableItem table;
    private TableData data;
    private String usuario;
    private int numMemo=751;
    TableItem tp;
    int z=0;
   //variable de envio Rest
 
    private Conexion conexion;
  
    private ConsultaCliente cc;
    private Codigo c;
    private RecargaPos rp;
    // varibales para impresion
    private Hashtable lp;
    
    private String ip = "198.199.75.179";
    private Gauge gau;
    //flags 
 

    private int pantalla;
    private Rest rest;
    private String mensaje;
    private String titulo;
    private boolean estaRegistrado=false;
    
    private Image qrCodeImage;
   
    private static final int BACK = 0xFF000000;
    private static final int WHTIE = 0xFFFFFFFF;
    //* rms de prueba*/
    private RecordStore rs = null;
    static final String REC_STORE = "MIrms";
    //variable para el filtro
    
    private FilteredList filtro,zona,vehiculos;
    private Command okZona;
//    private Infraccion infraccion;
    private Autentificacion autentificacion;
    private ConsultaDatos consulta;
    private ListaUsuarios usuarios;
    
    private Vector vectorVehiculo,vectorZona,vectorColores,vectorUsuarios;
//    private final Vector vectorUsuarios;
    private Command okVehiculo,backVehiculo;
    private ChoiceGroup group;
    private final int vV=0,vC=1,vZ=2;
    private Inf infcon;
    private Infraccion_1 infraccion;
//    private Thread t;
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command okOpciones;
    private Command okCliente;
    private Command okLista;
    private Command backMenu;
    private Command okCommand;
    private Command okCommand2;
    private Command okCommand1;
    private Command ImprimirFactura;
    private Command okCommand8;
    private Command stopCommand;
    private Command backCommand2;
    private Command okCommand9;
    private Command screenCommand;
    private Command cancelCommand1;
    private Command cancelCommand2;
    private Command back;
    private Command okRegistrar;
    private Command backDatos;
    private Command okDatos;
    private Command okMenu;
    private Command cancelCommand;
    private Command backSalir;
    private Command okSelOp;
    private Command backFactura;
    private Command backCliente;
    private Command okCommand4;
    private Command okCommand3;
    private Command backCommand;
    private Command okCommand5;
    private Command okCommand6;
    private Command backCommand1;
    private Command okCommand7;
    private Command okCommand25;
    private Command okCommand24;
    private Command okCommand23;
    private Command okCommand22;
    private Command okLogin;
    private Command okCommand21;
    private Command okCommand20;
    private Command okCommand29;
    private Command okCommand28;
    private Command okCommand27;
    private Command okCommand26;
    private Command exitCommand;
    private Command okCommand13;
    private Command okCommand14;
    private Command okCommand12;
    private Command okProducto;
    private Command okCommand10;
    private Command okCommand11;
    private Command okFiltro;
    private Command okFil;
    private Command okCommand18;
    private Command okCommand19;
    private Command okCommand16;
    private Command okCommand17;
    private Command exitCommand1;
    private Command okCommand15;
    private Command backProducto;
    private Command okCommand30;
    private Command backCommand4;
    private Command backCommand3;
    private Command okCommand31;
    private SplashScreen splashScreen;
    private List listLugar;
    private List lista;
    private Form formLoading;
    private Form formRegistro;
    private TextField txtEmailCli;
    private TextField txtTelCli;
    private TextField txtNomCli;
    private TextField txtNitCli;
    private List listMenu;
    private Alert Problemas;
    private Form formInfraccion;
    private TextField textField3;
    private TextField textField2;
    private TextField textField4;
    private List listVehiculo;
    private Form formVehiculo;
    private TextField textField1;
    private TextField textField;
    private TextField textField13;
    private TextField textField11;
    private TextField textField12;
    private Form formLogin;
    private TextField textField9;
    private TextField textField10;
    private Form formConductor;
    private TextField textField6;
    private TextField textField7;
    private TextField textField8;
    private TextField textField5;
    private Form formAgenda;
    private TextField txt1;
    private TextField txt2;
    private TextField txt3;
    private List listAdministrador;
    private Image image;
    private Image image2;
    private Image image11;
    private Ticker tickerLogin;
    private Image image12;
    private Image image1;
    private Image image4;
    private Image image3;
    private Image image10;
    private Image image5;
    private Image image6;
    private Image image7;
    private Ticker ticker;
    private SimpleCancellableTask task1;
    private Image image9;
    private SimpleCancellableTask task;
    private Image image8;
    private Image image13;
    private Image image14;
    private Image image15;
    private SimpleCancellableTask task2;
    private Ticker ticker1;
    private Font font;
//</editor-fold>//GEN-END:|fields|0|

    //SMS ENVIO
    /*
     * The StartApp constructor.
     */
    public StartApp() {
        // configuration for the logger
        PropertyConfigurator.configure();
         // restore notes from record store:
		this.storage = new RmsStorage();
                try {
			vectorUsuarios = (Vector) this.storage.read("Usuarios");
			vectorZona = (Vector) this.storage.read("Zonas");
                        vectorVehiculo = (Vector) this.storage.read("Vehiculo");
                        vectorColores = (Vector) this.storage.read("Color");
		} catch (IOException e) {
			// storage does not yet exist
                  
			vectorUsuarios = new Vector();
                        vectorZona = new Vector();
                        vectorVehiculo = new Vector();
                        vectorColores =new Vector();
                        
		}
        logme.info("Midlet started.");
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|
//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize



//GEN-LINE:|0-initialize|1|0-postInitialize


//        gau = new Gauge(null, false, Gauge.INDEFINITE, Gauge.CONTINUOUS_RUNNING);
//        ScreenInfo.setItem(gau);
//        gau.setVisible(true);
//        ScreenInfo.setVisible(false);
        
        
//        imprimir = Printer.getInstance();
//        imprimir.printText(ConstruirFila("hola"), 1);
//        imprimir.printTextWidthHeightZoom(ConstruirFilaA("Mantanial"),2, 1);
//        imprimir.printEndLine();
//       
//        // restore notes from record store:
//		this.storage = new RmsStorage();
//                try {
//			vectorUsuarios = (Vector) this.storage.read("Usuarios");
//			vectorZona = (Vector) this.storage.read("Zonas");
//                        vectorVehiculo = (Vector) this.storage.read("Vehiculo");
//                        vectorColores = (Vector) this.storage.read("Color");
//		} catch (IOException e) {
//			// storage does not yet exist
//			vectorUsuarios = new Vector();
//                        vectorZona = new Vector();
//                        vectorVehiculo = new Vector();
//                        vectorColores =new Vector();
//		}
        listaProductos = new Vector();
//       vectorUsuarios = new Vector();

        rest = new Rest();
        
        conexion = new Conexion(rest);
        conexion.start();
        
        
//        String version =conexion.getRespuesta();
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
           /*imprimir = Printer.getInstance();
            DeviceOps deviceOps = DeviceOps.getInstance();
              imprimir.printBitmap(deviceOps.readImage("/FAC_ALE.bmp", 0));
              imprimir.printBitmap(deviceOps.readImage("/FAC1.bmp", 0));*/
//        sd = new switchDisplay(this);
//        sd.start();
switchDisplayable(null, getSplashScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here

        //  display.setCurrent(nextDisplayable);
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here

        if (displayable == formAgenda) {//GEN-BEGIN:|7-commandAction|1|1319-preAction
            if (command == okCommand15) {//GEN-END:|7-commandAction|1|1319-preAction
 // write pre-action user code here
        //gaurdando a la base de datos 
//        Persona p = new Persona();
//        p.setNombre(txt1.getString());
//        p.setNumero(txt2.getString());
//        txt3.setText("haber hasta aqui its work:");
        openRecStore();
        writeRecord(txt1.getText()+";"+txt2.getText());
        
        
      
        closeRecStore();
        
        
//        try {
//        PersistableManager pm = PersistableManager.getInstance();
//        txt3.setText("se esta guardando el dato:");
//        // A new object ID is generated.
//        // You can use it in future operations.
//        int id = pm.save(p);
//        txt3.setText("id guardado: "+id);
//    
//} catch (FloggyException e) {
//    System.out.print("Error al guardar dato: "+e.toString());
//        
//}



//GEN-LINE:|7-commandAction|2|1319-postAction
 // write post-action user code here
} else if (command == okCommand17) {//GEN-LINE:|7-commandAction|3|1325-preAction
 // write pre-action user code here
//    Persona persona = new Persona();
//
//try {
//        PersistableManager pm = PersistableManager.getInstance();
//
//        /* To load an object, use the object ID 
//         * generated previously by the save() operation.
//         */
//        System.out.print("se esta recuperando  el dato:");
//        pm.load(persona, Integer.parseInt(txt3.getString()));
//        txt1.setText(persona.getNombre());
//        txt2.setText(persona.getNumero());
//} catch (FloggyException e) {
//       System.out.print("Error al guardar dato: "+e.toString());
//}
    openRecStore();
        readRecords();
        
        
      
        closeRecStore();
    
//GEN-LINE:|7-commandAction|4|1325-postAction
 // write post-action user code here
} else if (command == okCommand18) {//GEN-LINE:|7-commandAction|5|1331-preAction
 // write pre-action user code here
    CodigoDeControl cd = new CodigoDeControl();
//    String nuevaCad;
//        nuevaCad = ""+cd.getVerhoeff(txt1.getString());
//    txt3.setText(nuevaCad);
//    int n = Integer.parseInt(txt1.getString());
//    txt2.setText(cd.inToHex(n));
      String m, l;
      m ="d3Ir6";
      l = "sesamo";
    
//    char car[] = txt2.getString().toCharArray();
//    String c="";
//    for(int i =0;i<car.length;i++)
//    {
//            c=c+","+CharUtil.CharToASCII(car[i]);
//    }
//    txt3.setText(cd.getRC4("d3Ir6","sesamo"));
    txt3.setText(cd.getRC4(m, l));
//    txt3.setText(""+cd.cambiar(txt1.getText().toCharArray(), txt2.getText().toCharArray(), "hola mundo Xd"));
    
                                              
 // write post-action user code here
//        char[] c1 = txt1.getString().toCharArray();
//        char[] c2 = txt2.getString().toCharArray();
//            
//        
//        String nc="";
//        char [] caracteres = "Hola mundo Xd lalala".toCharArray();
//         for (int i = 0; i < caracteres.length; i++) {
//             nc = nc+" "+caracteres[i];
//          }   
////        nuevaCad = cd.cambiar(c2[0],c1[0],"hola mundo XD");
////        txt3.setText(nuevaCad);
//         txt3.setText(nc);
//         String texto = txt3.getText();
//        
//         char[] caracter = txt1.getString().toCharArray();
//         txt2.setText(cd.getInvierteNumero("Hola mundo Xd lalala"));
//    txt3.setText(""+cd.cambiar(txt1.getText().toCharArray(), txt2.getText().toCharArray(), "hola mundo Xd"));
    
//GEN-LINE:|7-commandAction|6|1331-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|7|1393-preAction
        } else if (displayable == formConductor) {
            if (command == okCommand27) {//GEN-END:|7-commandAction|7|1393-preAction
 // write pre-action user code here
                infcon.setCi(textField8.getText());
                infcon.setNombre(textField6.getText());
                infcon.setApaterno(textField7.getText());
                infcon.setAmaterno(textField5.getText());
                switchDisplayable(null, getFormInfraccion());//GEN-LINE:|7-commandAction|8|1393-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|9|1407-preAction
        } else if (displayable == formInfraccion) {
            if (command == ImprimirFactura) {//GEN-END:|7-commandAction|9|1407-preAction
 // write pre-action user code here
//                infraccion.setCodinfracion(textField2.getText());
//                infraccion.setCodgravamen(textField3.getText());
                  infcon.setInf1(textField2.getText());
                  infcon.setInf2(textField4.getText());
                  infcon.setCodGrav(textField3.getText());                  
                  infcon.setCodUser(autentificacion.getUserCod());
                  
//                Imprimir(infraccion);
//                try {
////                        factura = new Factura(rest.getRespuesta());
////                        
//                        javax.microedition.lcdui.Image ImagenQr=ImprimirQr(infraccion);
//                        BmpArray ba = new BmpArray();
//                        byte imagen[] =  ba.readImage(BMPGenerator.encodeBMP(ImagenQr));
//                        Imprimir(infraccion,imagen);
////                        cambiarPantalla();
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }   
                  
                methodInfraccion();//GEN-LINE:|7-commandAction|10|1407-postAction
 // write post-action user code here
                  
                         
            }//GEN-BEGIN:|7-commandAction|11|1244-preAction
        } else if (displayable == formLoading) {
            if (command == cancelCommand2) {//GEN-END:|7-commandAction|11|1244-preAction
                // write pre-action user code here
                retornarPantalla();
                
                
//GEN-LINE:|7-commandAction|12|1244-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|13|1400-preAction
        } else if (displayable == formLogin) {
            if (command == okCommand28) {//GEN-END:|7-commandAction|13|1400-preAction
 // write pre-action user code here
methodLogin();//GEN-LINE:|7-commandAction|14|1400-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|15|1255-preAction
        } else if (displayable == formRegistro) {
            if (command == back) {//GEN-END:|7-commandAction|15|1255-preAction
 // write pre-action user code here
//GEN-LINE:|7-commandAction|16|1255-postAction
 // write post-action user code here
} else if (command == okRegistrar) {//GEN-LINE:|7-commandAction|17|1253-preAction
 // write pre-action user code here
//GEN-LINE:|7-commandAction|18|1253-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|19|1421-preAction
        } else if (displayable == formVehiculo) {
            if (command == back) {//GEN-END:|7-commandAction|19|1421-preAction
 // write pre-action user code here
switchDisplayable(null, getListMenu());//GEN-LINE:|7-commandAction|20|1421-postAction
 // write post-action user code here
} else if (command == okCommand21) {//GEN-LINE:|7-commandAction|21|1354-preAction
 // write pre-action user code here
    infcon.setPlacaLit(textField.getText());
    infcon.setPlacaNum(textField1.getText());
    infcon.setVia(textField11.getText());
    infcon.setCalle(textField12.getText());
    infcon.setLineaDesc(textField13.getText());
                switchDisplayable(null, getListVehiculo());//GEN-LINE:|7-commandAction|22|1354-postAction
//  write post-action user code here
//infraccion.setPlaca(textField.getText()+"-"+textField1.getText());
}//GEN-BEGIN:|7-commandAction|23|1433-preAction
        } else if (displayable == listAdministrador) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|23|1433-preAction
                // write pre-action user code here
listAdministradorAction();//GEN-LINE:|7-commandAction|24|1433-postAction
                // write post-action user code here
} else if (command == backCommand4) {//GEN-LINE:|7-commandAction|25|1458-preAction
                // write pre-action user code here
switchDisplayable(null, getFormLogin());//GEN-LINE:|7-commandAction|26|1458-postAction
                // write post-action user code here
} else if (command == okCommand31) {//GEN-LINE:|7-commandAction|27|1452-preAction
                // write pre-action user code here
listAdministradorAction();//GEN-LINE:|7-commandAction|28|1452-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|29|1125-preAction
        } else if (displayable == listLugar) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|29|1125-preAction
                // write pre-action user code here
listLugarAction();//GEN-LINE:|7-commandAction|30|1125-postAction
                // write post-action user code here
} else if (command == backMenu) {//GEN-LINE:|7-commandAction|31|1133-preAction
                // write pre-action user code here
switchDisplayable(null, getListMenu());//GEN-LINE:|7-commandAction|32|1133-postAction
                
//                strProductos.setText("entro");
//                String p="lista de Items:\nCANT CONCEPTO      BS";
//                double total=0;
//                for (int i=0;i<listaProductos.size();i++)
//                {
//                    Products pro = (Products) listaProductos.elementAt(i);
//                    p = p +"\n "+Double.parseDouble(pro.getQty())+" "+pro.getNotes()+" "+(Double.parseDouble(pro.getCost())*Double.parseDouble(pro.getQty()));
//                    total = total + (Double.parseDouble(pro.getCost())*Double.parseDouble(pro.getQty()));
//                    
//                }
//                strProductos.setText(p);
////                strProductos.setText(""+total);
//                strTotal.setText(""+total);
                
                // write post-action user code here
} else if (command == okCommand4) {//GEN-LINE:|7-commandAction|33|1192-preAction
                // write pre-action user code here
                    switchDisplayable(null, getFormVehiculo());
//                   listaProductos.removeElementAt(listLugar.getSelectedIndex());
//                   listLugar.delete(listLugar.getSelectedIndex());
//GEN-LINE:|7-commandAction|34|1192-postAction
                // write post-action user code here
} else if (command == okOpciones) {//GEN-LINE:|7-commandAction|35|1127-preAction
                // write pre-action user code here
                    //Cambiando a la pantalla lugar donde se cometio la infraccion
                    if(getListLugar().getSelectedIndex() ==0)
                    {
                        switchDisplayable(null, getFiltro()); 
                    }
                    if(getListLugar().getSelectedIndex()==1)
                    {
                        switchDisplayable(null, getZona()); 
                    }
                
//GEN-LINE:|7-commandAction|36|1127-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|37|1155-preAction
        } else if (displayable == listMenu) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|37|1155-preAction
                // write pre-action user code here
listMenuAction();//GEN-LINE:|7-commandAction|38|1155-postAction
                // write post-action user code here
} else if (command == backSalir) {//GEN-LINE:|7-commandAction|39|1166-preAction
                // write pre-action user code here
switchDisplayable(null, getFormLogin());//GEN-LINE:|7-commandAction|40|1166-postAction
             
                // write post-action user code here
} else if (command == okMenu) {//GEN-LINE:|7-commandAction|41|1161-preAction
                // write pre-action user code here
listMenuAction();//GEN-LINE:|7-commandAction|42|1161-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|43|1359-preAction
        } else if (displayable == listVehiculo) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|43|1359-preAction
 // write pre-action user code here
listVehiculoAction();//GEN-LINE:|7-commandAction|44|1359-postAction
 // write post-action user code here
} else if (command == okCommand22) {//GEN-LINE:|7-commandAction|45|1365-preAction
 // write pre-action user code here
switchDisplayable(null, getFormConductor());//GEN-LINE:|7-commandAction|46|1365-postAction
 // write post-action user code here
} else if (command == okCommand29) {//GEN-LINE:|7-commandAction|47|1403-preAction
 // write pre-action user code here
    
    switch(getListVehiculo().getSelectedIndex())
    {
        case 0:  switchDisplayable(null, getVehiculos());break;
        case 1:  switchDisplayable(null, getLista()); break; 
        case 2: switchDisplayable(null,getZona()); break;
    }
//    /*
//    if(lista.getSelectedIndex()==1)
//    {
    /*
switchDisplayable (null, getLista ());//GEN-BEGIN:|7-commandAction|48|1403-postAction
//GEN-END:|7-commandAction|48|1403-postAction
 */
    
  
//e post-action user code here
}//GEN-BEGIN:|7-commandAction|49|1043-preAction
        } else if (displayable == lista) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|49|1043-preAction
                // write pre-action user code here
listaAction();//GEN-LINE:|7-commandAction|50|1043-postAction
                // write post-action user code here
} else if (command == backCommand) {//GEN-LINE:|7-commandAction|51|1194-preAction
                // write pre-action user code here
switchDisplayable(null, getListVehiculo());//GEN-LINE:|7-commandAction|52|1194-postAction
                // write post-action user code here
} else if (command == okLista) {//GEN-LINE:|7-commandAction|53|1117-preAction
                // write pre-action user code here
                String taux = lista.getString(lista.getSelectedIndex());
                Buscar(taux,vectorColores,1);
                getListVehiculo().set(1, "Color:"+taux, null);
                
                switchDisplayable(null, getListVehiculo());//GEN-LINE:|7-commandAction|54|1117-postAction
                // write post-action user code here
                 
//                 getListVehiculo().
//                 if(getListVehiculo().getSelectedIndex()==0)
//                 {
//                     getListVehiculo().set(getListVehiculo().getSelectedIndex(), "Tipo de Vehiculo:"+taux, null);
//                 }
                 
                    
               
//                 if (getListVehiculo().)
//                txtCant.setText("");
                
            }//GEN-BEGIN:|7-commandAction|55|24-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|55|24-preAction
                // write pre-action user code here
switchDisplayable(null, getFormLogin());//GEN-LINE:|7-commandAction|56|24-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|57|7-postCommandAction
        }//GEN-END:|7-commandAction|57|7-postCommandAction
        else if (command == okFiltro) {
                                
//                              retornarPantalla();
                    getListLugar().set(getListLugar().getSelectedIndex(), "Nombre de la via:"+getFiltro().getString(getFiltro().getSelectedIndex()),null);
//                    infraccion.setNomvia(getFiltro().getString(getFiltro().getSelectedIndex()));
                    
                    switchDisplayable(null,getListLugar());
//                               
        }
        else if (command == okZona) {
                                
//                              retornarPantalla();
                Buscar(getZona().getString(getZona().getSelectedIndex()),vectorZona,2);
                    getListVehiculo().set(2, "Zona:"+getZona().getString(getZona().getSelectedIndex()),null);
                                switchDisplayable(null,getListVehiculo());
                    
//                               
        }
        else if(command == okVehiculo)
        {
            Buscar(getVehiculos().getString(getVehiculos().getSelectedIndex()),vectorVehiculo,0);
            getListVehiculo().set(0,"Vehiculo:"+getVehiculos().getString(getVehiculos().getSelectedIndex()), null);
            switchDisplayable(null,getListVehiculo());
        }
        
// write post-action user code here
}//GEN-BEGIN:|7-commandAction|58|
//</editor-fold>//GEN-END:|7-commandAction|58|










//<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of splashScreen component.
     *
     * @return the initialized component instance
     */
    public SplashScreen getSplashScreen() {
        if (splashScreen == null) {
//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here


            splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|22-getter|1|22-postInit
            splashScreen.setTitle("");
            splashScreen.setCommandListener(this);
            splashScreen.setFullScreenMode(true);
            splashScreen.setImage(getImage10());
            splashScreen.setTimeout(2000);//GEN-END:|22-getter|1|22-postInit
            splashScreen.repaint();
        }//GEN-BEGIN:|22-getter|2|
        return splashScreen;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: font ">//GEN-BEGIN:|487-getter|0|487-preInit
    /**
     * Returns an initialized instance of font component.
     *
     * @return the initialized component instance
     */
    public Font getFont() {
        if (font == null) {
//GEN-END:|487-getter|0|487-preInit
            // write pre-init user code here
font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);//GEN-LINE:|487-getter|1|487-postInit
            // write post-init user code here
}//GEN-BEGIN:|487-getter|2|
        return font;
    }
//</editor-fold>//GEN-END:|487-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image ">//GEN-BEGIN:|519-getter|0|519-preInit
    /**
     * Returns an initialized instance of image component.
     *
     * @return the initialized component instance
     */
    public Image getImage() {
        if (image == null) {
//GEN-END:|519-getter|0|519-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|519-getter|1|519-@java.io.IOException
                image = Image.createImage("/splash_128x160.PNG");
            } catch (java.io.IOException e) {//GEN-END:|519-getter|1|519-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|519-getter|2|519-postInit
            // write post-init user code here
}//GEN-BEGIN:|519-getter|3|
        return image;
    }
//</editor-fold>//GEN-END:|519-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: tickerLogin ">//GEN-BEGIN:|644-getter|0|644-preInit
    /**
     * Returns an initialized instance of tickerLogin component.
     *
     * @return the initialized component instance
     */
    public Ticker getTickerLogin() {
        if (tickerLogin == null) {
//GEN-END:|644-getter|0|644-preInit
            // write pre-init user code here
tickerLogin = new Ticker("");//GEN-LINE:|644-getter|1|644-postInit
            // write post-init user code here
}//GEN-BEGIN:|644-getter|2|
        return tickerLogin;
    }
//</editor-fold>//GEN-END:|644-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|671-getter|0|671-preInit
    /**
     * Returns an initialized instance of image1 component.
     *
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {
//GEN-END:|671-getter|0|671-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|671-getter|1|671-@java.io.IOException
                image1 = Image.createImage("/print.png");
            } catch (java.io.IOException e) {//GEN-END:|671-getter|1|671-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|671-getter|2|671-postInit
            // write post-init user code here
}//GEN-BEGIN:|671-getter|3|
        return image1;
    }
//</editor-fold>//GEN-END:|671-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image2 ">//GEN-BEGIN:|683-getter|0|683-preInit
    /**
     * Returns an initialized instance of image2 component.
     *
     * @return the initialized component instance
     */
    public Image getImage2() {
        if (image2 == null) {
//GEN-END:|683-getter|0|683-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|683-getter|1|683-@java.io.IOException
                image2 = Image.createImage("/talkin.png");
            } catch (java.io.IOException e) {//GEN-END:|683-getter|1|683-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|683-getter|2|683-postInit
            // write post-init user code here
}//GEN-BEGIN:|683-getter|3|
        return image2;
    }
//</editor-fold>//GEN-END:|683-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image3 ">//GEN-BEGIN:|704-getter|0|704-preInit
    /**
     * Returns an initialized instance of image3 component.
     *
     * @return the initialized component instance
     */
    public Image getImage3() {
        if (image3 == null) {
//GEN-END:|704-getter|0|704-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|704-getter|1|704-@java.io.IOException
                image3 = Image.createImage("/recarga.png");
            } catch (java.io.IOException e) {//GEN-END:|704-getter|1|704-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|704-getter|2|704-postInit
            // write post-init user code here
}//GEN-BEGIN:|704-getter|3|
        return image3;
    }
//</editor-fold>//GEN-END:|704-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image4 ">//GEN-BEGIN:|712-getter|0|712-preInit
    /**
     * Returns an initialized instance of image4 component.
     *
     * @return the initialized component instance
     */
    public Image getImage4() {
        if (image4 == null) {
//GEN-END:|712-getter|0|712-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|712-getter|1|712-@java.io.IOException
                image4 = Image.createImage("/waiting.png");
            } catch (java.io.IOException e) {//GEN-END:|712-getter|1|712-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|712-getter|2|712-postInit
            // write post-init user code here
}//GEN-BEGIN:|712-getter|3|
        return image4;
    }
//</editor-fold>//GEN-END:|712-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image5 ">//GEN-BEGIN:|722-getter|0|722-preInit
    /**
     * Returns an initialized instance of image5 component.
     *
     * @return the initialized component instance
     */
    public Image getImage5() {
        if (image5 == null) {
//GEN-END:|722-getter|0|722-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|722-getter|1|722-@java.io.IOException
                image5 = Image.createImage("/Others_32x32.png");
            } catch (java.io.IOException e) {//GEN-END:|722-getter|1|722-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|722-getter|2|722-postInit
            // write post-init user code here
}//GEN-BEGIN:|722-getter|3|
        return image5;
    }
//</editor-fold>//GEN-END:|722-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image6 ">//GEN-BEGIN:|723-getter|0|723-preInit
    /**
     * Returns an initialized instance of image6 component.
     *
     * @return the initialized component instance
     */
    public Image getImage6() {
        if (image6 == null) {
//GEN-END:|723-getter|0|723-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|723-getter|1|723-@java.io.IOException
                image6 = Image.createImage("/Voucher 2_32x24.png");
            } catch (java.io.IOException e) {//GEN-END:|723-getter|1|723-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|723-getter|2|723-postInit
            // write post-init user code here
}//GEN-BEGIN:|723-getter|3|
        return image6;
    }
//</editor-fold>//GEN-END:|723-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image7 ">//GEN-BEGIN:|724-getter|0|724-preInit
    /**
     * Returns an initialized instance of image7 component.
     *
     * @return the initialized component instance
     */
    public Image getImage7() {
        if (image7 == null) {
//GEN-END:|724-getter|0|724-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|724-getter|1|724-@java.io.IOException
                image7 = Image.createImage("/Top up 2_32x26.png");
            } catch (java.io.IOException e) {//GEN-END:|724-getter|1|724-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|724-getter|2|724-postInit
            // write post-init user code here
}//GEN-BEGIN:|724-getter|3|
        return image7;
    }
//</editor-fold>//GEN-END:|724-getter|3|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|776-getter|0|776-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|776-getter|0|776-preInit
            // write pre-init user code here
exitCommand = new Command("Exit", "Exit", Command.EXIT, 1);//GEN-LINE:|776-getter|1|776-postInit
            // write post-init user code here
}//GEN-BEGIN:|776-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|776-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: ticker ">//GEN-BEGIN:|780-getter|0|780-preInit
    /**
     * Returns an initialized instance of ticker component.
     *
     * @return the initialized component instance
     */
    public Ticker getTicker() {
        if (ticker == null) {
//GEN-END:|780-getter|0|780-preInit
            // write pre-init user code here
ticker = new Ticker("tickerError");//GEN-LINE:|780-getter|1|780-postInit
            // write post-init user code here
}//GEN-BEGIN:|780-getter|2|
        return ticker;
    }
//</editor-fold>//GEN-END:|780-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okLogin ">//GEN-BEGIN:|801-getter|0|801-preInit
    /**
     * Returns an initialized instance of okLogin component.
     *
     * @return the initialized component instance
     */
    public Command getOkLogin() {
        if (okLogin == null) {
//GEN-END:|801-getter|0|801-preInit
            // write pre-init user code here
okLogin = new Command("Aceptar", Command.OK, 0);//GEN-LINE:|801-getter|1|801-postInit
            // write post-init user code here
}//GEN-BEGIN:|801-getter|2|
        return okLogin;
    }
//</editor-fold>//GEN-END:|801-getter|2|




//<editor-fold defaultstate="collapsed" desc=" Generated Getter: task ">//GEN-BEGIN:|853-getter|0|853-preInit
    /**
     * Returns an initialized instance of task component.
     *
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask() {
        if (task == null) {
//GEN-END:|853-getter|0|853-preInit
            // write pre-init user code here
task = new SimpleCancellableTask();//GEN-BEGIN:|853-getter|1|853-execute
            task.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|853-getter|1|853-execute
// write task-execution user code here
}//GEN-BEGIN:|853-getter|2|853-postInit
            });//GEN-END:|853-getter|2|853-postInit
            // write post-init user code here
}//GEN-BEGIN:|853-getter|3|
        return task;
    }
//</editor-fold>//GEN-END:|853-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image8 ">//GEN-BEGIN:|858-getter|0|858-preInit
    /**
     * Returns an initialized instance of image8 component.
     *
     * @return the initialized component instance
     */
    public Image getImage8() {
        if (image8 == null) {
//GEN-END:|858-getter|0|858-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|858-getter|1|858-@java.io.IOException
                image8 = Image.createImage("/logoipx.png");
            } catch (java.io.IOException e) {//GEN-END:|858-getter|1|858-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|858-getter|2|858-postInit
            // write post-init user code here
}//GEN-BEGIN:|858-getter|3|
        return image8;
    }
//</editor-fold>//GEN-END:|858-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image9 ">//GEN-BEGIN:|865-getter|0|865-preInit
    /**
     * Returns an initialized instance of image9 component.
     *
     * @return the initialized component instance
     */
    public Image getImage9() {
        if (image9 == null) {
//GEN-END:|865-getter|0|865-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|865-getter|1|865-@java.io.IOException
                image9 = Image.createImage("/login.png");
            } catch (java.io.IOException e) {//GEN-END:|865-getter|1|865-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|865-getter|2|865-postInit
            // write post-init user code here
}//GEN-BEGIN:|865-getter|3|
        return image9;
    }
//</editor-fold>//GEN-END:|865-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okProducto ">//GEN-BEGIN:|870-getter|0|870-preInit
    /**
     * Returns an initialized instance of okProducto component.
     *
     * @return the initialized component instance
     */
    public Command getOkProducto() {
        if (okProducto == null) {
//GEN-END:|870-getter|0|870-preInit
            // write pre-init user code here
okProducto = new Command("Adicionar Producto", Command.OK, 0);//GEN-LINE:|870-getter|1|870-postInit
            // write post-init user code here
}//GEN-BEGIN:|870-getter|2|
        return okProducto;
    }
//</editor-fold>//GEN-END:|870-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: task1 ">//GEN-BEGIN:|894-getter|0|894-preInit
    /**
     * Returns an initialized instance of task1 component.
     *
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask1() {
        if (task1 == null) {
//GEN-END:|894-getter|0|894-preInit
            // write pre-init user code here
task1 = new SimpleCancellableTask();//GEN-BEGIN:|894-getter|1|894-execute
            task1.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|894-getter|1|894-execute
// write task-execution user code here
}//GEN-BEGIN:|894-getter|2|894-postInit
            });//GEN-END:|894-getter|2|894-postInit
            // write post-init user code here
}//GEN-BEGIN:|894-getter|3|
        return task1;
    }
//</editor-fold>//GEN-END:|894-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backProducto ">//GEN-BEGIN:|946-getter|0|946-preInit
    /**
     * Returns an initialized instance of backProducto component.
     *
     * @return the initialized component instance
     */
    public Command getBackProducto() {
        if (backProducto == null) {
//GEN-END:|946-getter|0|946-preInit
            // write pre-init user code here
backProducto = new Command("Volver", Command.BACK, 0);//GEN-LINE:|946-getter|1|946-postInit
            // write post-init user code here
}//GEN-BEGIN:|946-getter|2|
        return backProducto;
    }
//</editor-fold>//GEN-END:|946-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: ticker1 ">//GEN-BEGIN:|968-getter|0|968-preInit
    /**
     * Returns an initialized instance of ticker1 component.
     *
     * @return the initialized component instance
     */
    public Ticker getTicker1() {
        if (ticker1 == null) {
//GEN-END:|968-getter|0|968-preInit
            // write pre-init user code here
ticker1 = new Ticker("");//GEN-LINE:|968-getter|1|968-postInit
            // write post-init user code here
}//GEN-BEGIN:|968-getter|2|
        return ticker1;
    }
//</editor-fold>//GEN-END:|968-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: task2 ">//GEN-BEGIN:|1003-getter|0|1003-preInit
    /**
     * Returns an initialized instance of task2 component.
     *
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask2() {
        if (task2 == null) {
//GEN-END:|1003-getter|0|1003-preInit
            // write pre-init user code here
task2 = new SimpleCancellableTask();//GEN-BEGIN:|1003-getter|1|1003-execute
            task2.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|1003-getter|1|1003-execute
// write task-execution user code here
}//GEN-BEGIN:|1003-getter|2|1003-postInit
            });//GEN-END:|1003-getter|2|1003-postInit
            // write post-init user code here
}//GEN-BEGIN:|1003-getter|3|
        return task2;
    }
//</editor-fold>//GEN-END:|1003-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: lista ">//GEN-BEGIN:|1042-getter|0|1042-preInit
    /**
     * Returns an initialized instance of lista component.
     *
     * @return the initialized component instance
     */
    public List getLista() {
        if (lista == null) {
//GEN-END:|1042-getter|0|1042-preInit
            // write pre-init user code here
lista = new List("list", Choice.IMPLICIT);//GEN-BEGIN:|1042-getter|1|1042-postInit
            lista.addCommand(getOkLista());
            lista.addCommand(getBackCommand());
            lista.setCommandListener(this);//GEN-END:|1042-getter|1|1042-postInit
            // write post-init user code here
            for(int i=0;i<vectorColores.size();i++)
            {
                 Colores c = (Colores) vectorColores.elementAt(i);
                  lista.append(c.getColdes(), null);
                 
            }
//            if(getListVehiculo().getSelectedIndex()==0)
//            {
//                lista.append("Rojo", null);
//                lista.append("Amarillo", null);
//                lista.append("Plomo", null);
//                lista.append("Blanco", null);
//                lista.append("Azul", null);
//            }
//            if(getListVehiculo().getSelectedIndex()==1)
//            {
//                for(int i=0;i<10;i++)
//                {
//                    lista.append("Tipo"+i, null);
//                }
//            }
//            for(int i=0;i<cuenta.getProductos().size();i++)
//            {
//                Products prod = (Products) cuenta.getProductos().elementAt(i);
//                lista.append(prod.getNotes(), null);
//                lista.setTitle("Lista de Productos");
//            }
}//GEN-BEGIN:|1042-getter|2|
        return lista;
    }
//</editor-fold>//GEN-END:|1042-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listaAction ">//GEN-BEGIN:|1042-action|0|1042-preAction
    /**
     * Performs an action assigned to the selected list element in the lista
     * component.
     */
    public void listaAction() {
//GEN-END:|1042-action|0|1042-preAction
        // enter pre-action user code here
String __selectedString = getLista().getString(getLista().getSelectedIndex());//GEN-LINE:|1042-action|1|1042-postAction
        // enter post-action user code here
}//GEN-BEGIN:|1042-action|2|
//</editor-fold>//GEN-END:|1042-action|2|







//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCliente ">//GEN-BEGIN:|1092-getter|0|1092-preInit
    /**
     * Returns an initialized instance of okCliente component.
     *
     * @return the initialized component instance
     */
    public Command getOkCliente() {
        if (okCliente == null) {
//GEN-END:|1092-getter|0|1092-preInit
            // write pre-init user code here
okCliente = new Command("Ok", Command.OK, 0);//GEN-LINE:|1092-getter|1|1092-postInit
            // write post-init user code here
}//GEN-BEGIN:|1092-getter|2|
        return okCliente;
    }
//</editor-fold>//GEN-END:|1092-getter|2|







//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okOpciones ">//GEN-BEGIN:|1099-getter|0|1099-preInit
    /**
     * Returns an initialized instance of okOpciones component.
     *
     * @return the initialized component instance
     */
    public Command getOkOpciones() {
        if (okOpciones == null) {
//GEN-END:|1099-getter|0|1099-preInit
            // write pre-init user code here
okOpciones = new Command("Seleccionar", Command.BACK, 0);//GEN-LINE:|1099-getter|1|1099-postInit
            // write post-init user code here
}//GEN-BEGIN:|1099-getter|2|
        return okOpciones;
    }
//</editor-fold>//GEN-END:|1099-getter|2|













//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okLista ">//GEN-BEGIN:|1116-getter|0|1116-preInit
    /**
     * Returns an initialized instance of okLista component.
     *
     * @return the initialized component instance
     */
    public Command getOkLista() {
        if (okLista == null) {
//GEN-END:|1116-getter|0|1116-preInit
            // write pre-init user code here
okLista = new Command("Ok", Command.OK, 0);//GEN-LINE:|1116-getter|1|1116-postInit
            // write post-init user code here
}//GEN-BEGIN:|1116-getter|2|
        return okLista;
    }
//</editor-fold>//GEN-END:|1116-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|1121-getter|0|1121-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|1121-getter|0|1121-preInit
            // write pre-init user code here
okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|1121-getter|1|1121-postInit
            // write post-init user code here
}//GEN-BEGIN:|1121-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|1121-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: listLugar ">//GEN-BEGIN:|1124-getter|0|1124-preInit
    /**
     * Returns an initialized instance of listLugar component.
     *
     * @return the initialized component instance
     */
    public List getListLugar() {
        if (listLugar == null) {
//GEN-END:|1124-getter|0|1124-preInit
            // write pre-init user code here
listLugar = new List("Productos Seleccionados", Choice.IMPLICIT);//GEN-BEGIN:|1124-getter|1|1124-postInit
            listLugar.append("Nombre de la Via:", null);
            listLugar.append("Zona:", null);
            listLugar.addCommand(getOkOpciones());
            listLugar.addCommand(getBackMenu());
            listLugar.addCommand(getOkCommand4());
            listLugar.setCommandListener(this);
            listLugar.setSelectedFlags(new boolean[]{true, false});//GEN-END:|1124-getter|1|1124-postInit
            // write post-init user code here
}//GEN-BEGIN:|1124-getter|2|
        return listLugar;
    }
//</editor-fold>//GEN-END:|1124-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listLugarAction ">//GEN-BEGIN:|1124-action|0|1124-preAction
    /**
     * Performs an action assigned to the selected list element in the listLugar
     * component.
     */
    public void listLugarAction() {
//GEN-END:|1124-action|0|1124-preAction
        // enter pre-action user code here
String __selectedString = getListLugar().getString(getListLugar().getSelectedIndex());//GEN-BEGIN:|1124-action|1|1350-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Nombre de la Via:")) {//GEN-END:|1124-action|1|1350-preAction
 // write pre-action user code here
//GEN-LINE:|1124-action|2|1350-postAction
 // write post-action user code here
} else if (__selectedString.equals("Zona:")) {//GEN-LINE:|1124-action|3|1351-preAction
 // write pre-action user code here
//GEN-LINE:|1124-action|4|1351-postAction
 // write post-action user code here
}//GEN-BEGIN:|1124-action|5|1124-postAction
        }//GEN-END:|1124-action|5|1124-postAction
        // enter post-action user code here
}//GEN-BEGIN:|1124-action|6|
//</editor-fold>//GEN-END:|1124-action|6|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backMenu ">//GEN-BEGIN:|1132-getter|0|1132-preInit
    /**
     * Returns an initialized instance of backMenu component.
     *
     * @return the initialized component instance
     */
    public Command getBackMenu() {
        if (backMenu == null) {
//GEN-END:|1132-getter|0|1132-preInit
            // write pre-init user code here
backMenu = new Command("Atras", Command.OK, 0);//GEN-LINE:|1132-getter|1|1132-postInit
            // write post-init user code here
}//GEN-BEGIN:|1132-getter|2|
        return backMenu;
    }
//</editor-fold>//GEN-END:|1132-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: ImprimirFactura ">//GEN-BEGIN:|1139-getter|0|1139-preInit
    /**
     * Returns an initialized instance of ImprimirFactura component.
     *
     * @return the initialized component instance
     */
    public Command getImprimirFactura() {
        if (ImprimirFactura == null) {
//GEN-END:|1139-getter|0|1139-preInit
            // write pre-init user code here
ImprimirFactura = new Command("Imprimir ", Command.OK, 0);//GEN-LINE:|1139-getter|1|1139-postInit
            // write post-init user code here
}//GEN-BEGIN:|1139-getter|2|
        return ImprimirFactura;
    }
//</editor-fold>//GEN-END:|1139-getter|2|









//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|1147-getter|0|1147-preInit
    /**
     * Returns an initialized instance of okCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {
//GEN-END:|1147-getter|0|1147-preInit
            // write pre-init user code here
okCommand1 = new Command("ingresar nombre", Command.OK, 0);//GEN-LINE:|1147-getter|1|1147-postInit
            // write post-init user code here
}//GEN-BEGIN:|1147-getter|2|
        return okCommand1;
    }
//</editor-fold>//GEN-END:|1147-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|1150-getter|0|1150-preInit
    /**
     * Returns an initialized instance of okCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {
//GEN-END:|1150-getter|0|1150-preInit
            // write pre-init user code here
okCommand2 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1150-getter|1|1150-postInit
            // write post-init user code here
}//GEN-BEGIN:|1150-getter|2|
        return okCommand2;
    }
//</editor-fold>//GEN-END:|1150-getter|2|





//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okMenu ">//GEN-BEGIN:|1160-getter|0|1160-preInit
    /**
     * Returns an initialized instance of okMenu component.
     *
     * @return the initialized component instance
     */
    public Command getOkMenu() {
        if (okMenu == null) {
//GEN-END:|1160-getter|0|1160-preInit
            // write pre-init user code here
okMenu = new Command("OK", Command.OK, 0);//GEN-LINE:|1160-getter|1|1160-postInit
            // write post-init user code here
}//GEN-BEGIN:|1160-getter|2|
        return okMenu;
    }
//</editor-fold>//GEN-END:|1160-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|1163-getter|0|1163-preInit
    /**
     * Returns an initialized instance of cancelCommand component.
     *
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {
//GEN-END:|1163-getter|0|1163-preInit
            // write pre-init user code here
cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|1163-getter|1|1163-postInit
            // write post-init user code here
}//GEN-BEGIN:|1163-getter|2|
        return cancelCommand;
    }
//</editor-fold>//GEN-END:|1163-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backSalir ">//GEN-BEGIN:|1165-getter|0|1165-preInit
    /**
     * Returns an initialized instance of backSalir component.
     *
     * @return the initialized component instance
     */
    public Command getBackSalir() {
        if (backSalir == null) {
//GEN-END:|1165-getter|0|1165-preInit
            // write pre-init user code here
backSalir = new Command("Atras", Command.BACK, 0);//GEN-LINE:|1165-getter|1|1165-postInit
            // write post-init user code here
}//GEN-BEGIN:|1165-getter|2|
        return backSalir;
    }
//</editor-fold>//GEN-END:|1165-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: listMenu ">//GEN-BEGIN:|1154-getter|0|1154-preInit
    /**
     * Returns an initialized instance of listMenu component.
     *
     * @return the initialized component instance
     */
    public List getListMenu() {
        if (listMenu == null) {
//GEN-END:|1154-getter|0|1154-preInit
            // write pre-init user code here
            
            listMenu = new List("list", Choice.IMPLICIT);//GEN-BEGIN:|1154-getter|1|1154-postInit
            listMenu.append("1) Infraccion Municipal", null);
            listMenu.append("2) Actualizar Informacion", null);
            listMenu.append("3) Ayuda", null);
            listMenu.addCommand(getOkMenu());
            listMenu.addCommand(getBackSalir());
            listMenu.setCommandListener(this);
            listMenu.setSelectedFlags(new boolean[]{false, false, false});//GEN-END:|1154-getter|1|1154-postInit
            // write post-init user code here
            
            listMenu.setTitle("Menu Infraccion Usuario:"+textField9.getText());
        }//GEN-BEGIN:|1154-getter|2|
        return listMenu;
    }
//</editor-fold>//GEN-END:|1154-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listMenuAction ">//GEN-BEGIN:|1154-action|0|1154-preAction
    /**
     * Performs an action assigned to the selected list element in the listMenu
     * component.
     */
    public void listMenuAction() {
//GEN-END:|1154-action|0|1154-preAction
        // enter pre-action user code here
String __selectedString = getListMenu().getString(getListMenu().getSelectedIndex());//GEN-BEGIN:|1154-action|1|1158-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("1) Infraccion Municipal")) {//GEN-END:|1154-action|1|1158-preAction
                // write pre-action user code here
switchDisplayable(null, getFormVehiculo());//GEN-LINE:|1154-action|2|1158-postAction
                // write post-action user code here
                  
//                  infraccion = new Infraccion();
//                  infraccion.setNombreagente(textField9.getString());
                  if(infcon !=null)
                  {
                      infcon = null;
                  }
                  infcon = new Inf();
                  Limpiar();
            } else if (__selectedString.equals("2) Actualizar Informacion")) {//GEN-LINE:|1154-action|3|1159-preAction
                // write pre-action user code here
//GEN-LINE:|1154-action|4|1159-postAction
                // write post-action user code here
} else if (__selectedString.equals("3) Ayuda")) {//GEN-LINE:|1154-action|5|1157-preAction
                // write pre-action user code here
//                formFactura = null;
//GEN-LINE:|1154-action|6|1157-postAction
//              strNitCli.setText(cliente.getCliente().getNit());
//              strNomCli.setText(cliente.getCliente().getName());
            
              
//              Object[] data;
//                while ( (data = getNextData()) != null ) {
//                        int row = table.addRow();
//                        for (int i=0; i<data.length; i++ ) {
//                                if (i  >= table.getNumberOfColumns() ) {
//                                        table.addColumn();
//                                }
//                                table.set( i, row, data[i] );
//                        }
//                }
              
//               table.addRow();
//               table.addColumn();
//               table.addColumn();
//               table.addColumn();
//               table.set(0, 0,"Cant.");
//               table.set(1, 0,"Producto");
//               table.set(2, 0,"Bs");
//               double total=0;
//          
//               for(int i=0;i<listaProductos.size();i++)
//                {
//                  table.addRow();
//                    Products pro = (Products) listaProductos.elementAt(i);
//                   table.set(0, i+1, pro.getQty());
//                   table.set(1, i+1, pro.getNotes());
//                   table.set(2, i+1, Double.parseDouble(pro.getCost())*Double.parseDouble(pro.getQty())+"");
//    //                    p = p +"\n "+Double.parseDouble(pro.getQty())+" "+pro.getNotes()+" "+(Double.parseDouble(pro.getCost())*Double.parseDouble(pro.getQty()));
//                   total = total + (Double.parseDouble(pro.getCost())*Double.parseDouble(pro.getQty()));
//                }
//                table.addRow();
//                table.set(0, listaProductos.size(),"Cant.");
//                table.set(1, listaProductos.size(),"Producto");
//                table.set(2, listaProductos.size(),"Bs");
//              // columna fila
//              if(data!=null)
//              {
//                  data = null;
//              }
//               data = new TableData(3,(listaProductos.size()+3));
//  //            formFactura.setTitle(""+listaProductos.size());
//  //            Products pro = (Products) listaProductos.elementAt(0);
//  //            data.set( 1, 0, "1,0");
//  //            data.set( 2, 0, "2,0");
//  //            data.set( 0, 1, "0,1");
//  //            data.set( 1, 1, "xxxx1,1");
//  //            data.set( 2, 1, "2,1");
//               data.set(0,0, "Cant.");
//               data.set(1,0,"Producto");
//               data.set(2,0, "Bs");
//               double total=0;
//                for(int i=0;i<listaProductos.size();i++)
//                {
//                   Products pro = (Products) listaProductos.elementAt(i);
//                   data.set(0, i+1, pro.getQty());
//                   data.set(1, i+1, pro.getNotes());
//                   data.set(2, i+1, Double.parseDouble(pro.getCost())*Double.parseDouble(pro.getQty())+"");
//    //                    p = p +"\n "+Double.parseDouble(pro.getQty())+" "+pro.getNotes()+" "+(Double.parseDouble(pro.getCost())*Double.parseDouble(pro.getQty()));
//                        total = total + (Double.parseDouble(pro.getCost())*Double.parseDouble(pro.getQty()));
//                }
//                 data.set(0,listaProductos.size()+1, "Total");
//                 data.set(1,listaProductos.size()+1,"");
//                 data.set(2,listaProductos.size()+1, ""+total);
//                //#style defaultTable
//                TableItem table = new TableItem(data);
//                formFactura.append( table );            

                // write post-action user code here
}//GEN-BEGIN:|1154-action|7|1154-postAction
        }//GEN-END:|1154-action|7|1154-postAction
        // enter post-action user code here
}//GEN-BEGIN:|1154-action|8|
//</editor-fold>//GEN-END:|1154-action|8|






//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okSelOp ">//GEN-BEGIN:|1174-getter|0|1174-preInit
    /**
     * Returns an initialized instance of okSelOp component.
     *
     * @return the initialized component instance
     */
    public Command getOkSelOp() {
        if (okSelOp == null) {
//GEN-END:|1174-getter|0|1174-preInit
            // write pre-init user code here
okSelOp = new Command("Ok", Command.OK, 0);//GEN-LINE:|1174-getter|1|1174-postInit
            // write post-init user code here
}//GEN-BEGIN:|1174-getter|2|
        return okSelOp;
    }
//</editor-fold>//GEN-END:|1174-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backFactura ">//GEN-BEGIN:|1178-getter|0|1178-preInit
    /**
     * Returns an initialized instance of backFactura component.
     *
     * @return the initialized component instance
     */
    public Command getBackFactura() {
        if (backFactura == null) {
//GEN-END:|1178-getter|0|1178-preInit
            // write pre-init user code here
backFactura = new Command("Cancelar", Command.BACK, 0);//GEN-LINE:|1178-getter|1|1178-postInit
            // write post-init user code here
}//GEN-BEGIN:|1178-getter|2|
        return backFactura;
    }
//</editor-fold>//GEN-END:|1178-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCliente ">//GEN-BEGIN:|1184-getter|0|1184-preInit
    /**
     * Returns an initialized instance of backCliente component.
     *
     * @return the initialized component instance
     */
    public Command getBackCliente() {
        if (backCliente == null) {
//GEN-END:|1184-getter|0|1184-preInit
            // write pre-init user code here
backCliente = new Command("Atras", Command.OK, 0);//GEN-LINE:|1184-getter|1|1184-postInit
            // write post-init user code here
}//GEN-BEGIN:|1184-getter|2|
        return backCliente;
    }
//</editor-fold>//GEN-END:|1184-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand3 ">//GEN-BEGIN:|1188-getter|0|1188-preInit
    /**
     * Returns an initialized instance of okCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand3() {
        if (okCommand3 == null) {
//GEN-END:|1188-getter|0|1188-preInit
            // write pre-init user code here
okCommand3 = new Command("Adicionar", Command.OK, 0);//GEN-LINE:|1188-getter|1|1188-postInit
            // write post-init user code here
}//GEN-BEGIN:|1188-getter|2|
        return okCommand3;
    }
//</editor-fold>//GEN-END:|1188-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand4 ">//GEN-BEGIN:|1191-getter|0|1191-preInit
    /**
     * Returns an initialized instance of okCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand4() {
        if (okCommand4 == null) {
//GEN-END:|1191-getter|0|1191-preInit
            // write pre-init user code here
okCommand4 = new Command("Siguente", Command.OK, 0);//GEN-LINE:|1191-getter|1|1191-postInit
            // write post-init user code here
}//GEN-BEGIN:|1191-getter|2|
        return okCommand4;
    }
//</editor-fold>//GEN-END:|1191-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|1193-getter|0|1193-preInit
    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {
//GEN-END:|1193-getter|0|1193-preInit
            // write pre-init user code here
backCommand = new Command("Atras", Command.BACK, 0);//GEN-LINE:|1193-getter|1|1193-postInit
            // write post-init user code here
}//GEN-BEGIN:|1193-getter|2|
        return backCommand;
    }
//</editor-fold>//GEN-END:|1193-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image10 ">//GEN-BEGIN:|1196-getter|0|1196-preInit
    /**
     * Returns an initialized instance of image10 component.
     *
     * @return the initialized component instance
     */
    public Image getImage10() {
        if (image10 == null) {
//GEN-END:|1196-getter|0|1196-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|1196-getter|1|1196-@java.io.IOException
                image10 = Image.createImage("/banner alcaldia.png");
            } catch (java.io.IOException e) {//GEN-END:|1196-getter|1|1196-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|1196-getter|2|1196-postInit
            // write post-init user code here
}//GEN-BEGIN:|1196-getter|3|
        return image10;
    }
//</editor-fold>//GEN-END:|1196-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand5 ">//GEN-BEGIN:|1198-getter|0|1198-preInit
    /**
     * Returns an initialized instance of okCommand5 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand5() {
        if (okCommand5 == null) {
//GEN-END:|1198-getter|0|1198-preInit
            // write pre-init user code here
okCommand5 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1198-getter|1|1198-postInit
            // write post-init user code here
}//GEN-BEGIN:|1198-getter|2|
        return okCommand5;
    }
//</editor-fold>//GEN-END:|1198-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand6 ">//GEN-BEGIN:|1203-getter|0|1203-preInit
    /**
     * Returns an initialized instance of okCommand6 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand6() {
        if (okCommand6 == null) {
//GEN-END:|1203-getter|0|1203-preInit
            // write pre-init user code here
okCommand6 = new Command("Crear", Command.OK, 0);//GEN-LINE:|1203-getter|1|1203-postInit
            // write post-init user code here
}//GEN-BEGIN:|1203-getter|2|
        return okCommand6;
    }
//</editor-fold>//GEN-END:|1203-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|1206-getter|0|1206-preInit
    /**
     * Returns an initialized instance of backCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {
//GEN-END:|1206-getter|0|1206-preInit
            // write pre-init user code here
backCommand1 = new Command("Limpiar", Command.BACK, 0);//GEN-LINE:|1206-getter|1|1206-postInit
            // write post-init user code here
}//GEN-BEGIN:|1206-getter|2|
        return backCommand1;
    }
//</editor-fold>//GEN-END:|1206-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand7 ">//GEN-BEGIN:|1208-getter|0|1208-preInit
    /**
     * Returns an initialized instance of okCommand7 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand7() {
        if (okCommand7 == null) {
//GEN-END:|1208-getter|0|1208-preInit
            // write pre-init user code here
okCommand7 = new Command("AgregarProducto", Command.OK, 0);//GEN-LINE:|1208-getter|1|1208-postInit
            // write post-init user code here
}//GEN-BEGIN:|1208-getter|2|
        return okCommand7;
    }
//</editor-fold>//GEN-END:|1208-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Problemas ">//GEN-BEGIN:|1211-getter|0|1211-preInit
    /**
     * Returns an initialized instance of Problemas component.
     *
     * @return the initialized component instance
     */
    public Alert getProblemas() {
        if (Problemas == null) {
//GEN-END:|1211-getter|0|1211-preInit
           
            //#style mailAlert
//           Problemas = new Alert("Exit?", "Do you really want to exit?", null, AlertType.CONFIRMATION);
            Problemas = new Alert(getAlertTitulo(),getAlertMensaje(),getImage11(),AlertType.CONFIRMATION);
            final Command cmdYes = new Command("Aceptar", Command.OK, 1);
           
            Problemas.addCommand(cmdYes);
        
            Problemas.setCommandListener(new CommandListener() {
                    public void commandAction(Command c, Displayable d) {
                            if (c == cmdYes) {
                                
                              retornarPantalla();
                               
                            }			
                    }
            });
                   
           
            /* Codigo de netbeans 
Problemas = new Alert ("alert", "Problemas XD", null, null);//GEN-BEGIN:|1211-getter|1|1211-postInit
             Problemas.setTimeout (Alert.FOREVER);
//GEN-END:|1211-getter|1|1211-postInit
            */
            // write post-init user code here
            
        }//GEN-BEGIN:|1211-getter|2|
        return Problemas;
    }
//</editor-fold>//GEN-END:|1211-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stopCommand ">//GEN-BEGIN:|1218-getter|0|1218-preInit
    /**
     * Returns an initialized instance of stopCommand component.
     *
     * @return the initialized component instance
     */
    public Command getStopCommand() {
        if (stopCommand == null) {
//GEN-END:|1218-getter|0|1218-preInit
            // write pre-init user code here
stopCommand = new Command("Stop", Command.STOP, 0);//GEN-LINE:|1218-getter|1|1218-postInit
            // write post-init user code here
}//GEN-BEGIN:|1218-getter|2|
        return stopCommand;
    }
//</editor-fold>//GEN-END:|1218-getter|2|





//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand8 ">//GEN-BEGIN:|1223-getter|0|1223-preInit
    /**
     * Returns an initialized instance of okCommand8 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand8() {
        if (okCommand8 == null) {
//GEN-END:|1223-getter|0|1223-preInit
            // write pre-init user code here
okCommand8 = new Command("ok", "<null>", Command.OK, 0);//GEN-LINE:|1223-getter|1|1223-postInit
            // write post-init user code here
}//GEN-BEGIN:|1223-getter|2|
        return okCommand8;
    }
//</editor-fold>//GEN-END:|1223-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|1227-getter|0|1227-preInit
    /**
     * Returns an initialized instance of backCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand2() {
        if (backCommand2 == null) {
//GEN-END:|1227-getter|0|1227-preInit
            // write pre-init user code here
backCommand2 = new Command("Salir", Command.BACK, 0);//GEN-LINE:|1227-getter|1|1227-postInit
            // write post-init user code here
}//GEN-BEGIN:|1227-getter|2|
        return backCommand2;
    }
//</editor-fold>//GEN-END:|1227-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: screenCommand ">//GEN-BEGIN:|1235-getter|0|1235-preInit
    /**
     * Returns an initialized instance of screenCommand component.
     *
     * @return the initialized component instance
     */
    public Command getScreenCommand() {
        if (screenCommand == null) {
//GEN-END:|1235-getter|0|1235-preInit
            // write pre-init user code here
screenCommand = new Command("Screen", Command.SCREEN, 0);//GEN-LINE:|1235-getter|1|1235-postInit
            // write post-init user code here
}//GEN-BEGIN:|1235-getter|2|
        return screenCommand;
    }
//</editor-fold>//GEN-END:|1235-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand9 ">//GEN-BEGIN:|1237-getter|0|1237-preInit
    /**
     * Returns an initialized instance of okCommand9 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand9() {
        if (okCommand9 == null) {
//GEN-END:|1237-getter|0|1237-preInit
            // write pre-init user code here
okCommand9 = new Command("activar gauge", Command.OK, 0);//GEN-LINE:|1237-getter|1|1237-postInit
            // write post-init user code here
}//GEN-BEGIN:|1237-getter|2|
        return okCommand9;
    }
//</editor-fold>//GEN-END:|1237-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: formLoading ">//GEN-BEGIN:|1239-getter|0|1239-preInit
    /**
     * Returns an initialized instance of formLoading component.
     *
     * @return the initialized component instance
     */
    public Form getFormLoading() {
        if (formLoading == null) {
//GEN-END:|1239-getter|0|1239-preInit
            // write pre-init user code here
            //#style mailAlert
formLoading = new Form("Enviando Solicitud");//GEN-BEGIN:|1239-getter|1|1239-postInit
            formLoading.addCommand(getCancelCommand2());
            formLoading.setCommandListener(this);//GEN-END:|1239-getter|1|1239-postInit
            // write post-init user code here
            //#style .busyIndicator
            Gauge busyIndicator = new Gauge( null, false,Gauge.INDEFINITE, Gauge.CONTINUOUS_RUNNING );
            formLoading.append(busyIndicator);
        }//GEN-BEGIN:|1239-getter|2|
        return formLoading;
    }
//</editor-fold>//GEN-END:|1239-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand1 ">//GEN-BEGIN:|1240-getter|0|1240-preInit
    /**
     * Returns an initialized instance of cancelCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getCancelCommand1() {
        if (cancelCommand1 == null) {
//GEN-END:|1240-getter|0|1240-preInit
            // write pre-init user code here
cancelCommand1 = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|1240-getter|1|1240-postInit
            // write post-init user code here
}//GEN-BEGIN:|1240-getter|2|
        return cancelCommand1;
    }
//</editor-fold>//GEN-END:|1240-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand2 ">//GEN-BEGIN:|1243-getter|0|1243-preInit
    /**
     * Returns an initialized instance of cancelCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getCancelCommand2() {
        if (cancelCommand2 == null) {
//GEN-END:|1243-getter|0|1243-preInit
            // write pre-init user code here
cancelCommand2 = new Command("Cancelar", Command.CANCEL, 0);//GEN-LINE:|1243-getter|1|1243-postInit
            // write post-init user code here
}//GEN-BEGIN:|1243-getter|2|
        return cancelCommand2;
    }
//</editor-fold>//GEN-END:|1243-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image11 ">//GEN-BEGIN:|1246-getter|0|1246-preInit
    /**
     * Returns an initialized instance of image11 component.
     *
     * @return the initialized component instance
     */
    public Image getImage11() {
        if (image11 == null) {
//GEN-END:|1246-getter|0|1246-preInit
            // write pre-init user code here
try {//GEN-BEGIN:|1246-getter|1|1246-@java.io.IOException
                image11 = Image.createImage("/alert2.png");
            } catch (java.io.IOException e) {//GEN-END:|1246-getter|1|1246-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|1246-getter|2|1246-postInit
            // write post-init user code here
            if(rest.getCodigoRespuesta()==200)
            {
                try {                                                    
                    image11 = Image.createImage("/ok.png");
                } catch (java.io.IOException e) {                                                  
                    e.printStackTrace();
                }        
            }
            
        }//GEN-BEGIN:|1246-getter|3|
        return image11;
    }
//</editor-fold>//GEN-END:|1246-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okRegistrar ">//GEN-BEGIN:|1252-getter|0|1252-preInit
    /**
     * Returns an initialized instance of okRegistrar component.
     *
     * @return the initialized component instance
     */
    public Command getOkRegistrar() {
        if (okRegistrar == null) {
//GEN-END:|1252-getter|0|1252-preInit
 // write pre-init user code here
okRegistrar = new Command("Ok", Command.OK, 0);//GEN-LINE:|1252-getter|1|1252-postInit
 // write post-init user code here
}//GEN-BEGIN:|1252-getter|2|
        return okRegistrar;
    }
//</editor-fold>//GEN-END:|1252-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: back ">//GEN-BEGIN:|1254-getter|0|1254-preInit
    /**
     * Returns an initialized instance of back component.
     *
     * @return the initialized component instance
     */
    public Command getBack() {
        if (back == null) {
//GEN-END:|1254-getter|0|1254-preInit
 // write pre-init user code here
back = new Command("Salir", Command.OK, 0);//GEN-LINE:|1254-getter|1|1254-postInit
 // write post-init user code here
}//GEN-BEGIN:|1254-getter|2|
        return back;
    }
//</editor-fold>//GEN-END:|1254-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okDatos ">//GEN-BEGIN:|1260-getter|0|1260-preInit
    /**
     * Returns an initialized instance of okDatos component.
     *
     * @return the initialized component instance
     */
    public Command getOkDatos() {
        if (okDatos == null) {
//GEN-END:|1260-getter|0|1260-preInit
 // write pre-init user code here
okDatos = new Command("Ok", Command.OK, 0);//GEN-LINE:|1260-getter|1|1260-postInit
 // write post-init user code here
}//GEN-BEGIN:|1260-getter|2|
        return okDatos;
    }
//</editor-fold>//GEN-END:|1260-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: formRegistro ">//GEN-BEGIN:|1247-getter|0|1247-preInit
    /**
     * Returns an initialized instance of formRegistro component.
     *
     * @return the initialized component instance
     */
    public Form getFormRegistro() {
        if (formRegistro == null) {
//GEN-END:|1247-getter|0|1247-preInit
 // write pre-init user code here
formRegistro = new Form("Registro de Cliente", new Item[]{getTxtNitCli(), getTxtNomCli(), getTxtTelCli(), getTxtEmailCli()});//GEN-BEGIN:|1247-getter|1|1247-postInit
            formRegistro.addCommand(getOkRegistrar());
            formRegistro.addCommand(getBack());
            formRegistro.setCommandListener(this);//GEN-END:|1247-getter|1|1247-postInit
 // write post-init user code here
}//GEN-BEGIN:|1247-getter|2|
        return formRegistro;
    }
//</editor-fold>//GEN-END:|1247-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtNitCli ">//GEN-BEGIN:|1248-getter|0|1248-preInit
    /**
     * Returns an initialized instance of txtNitCli component.
     *
     * @return the initialized component instance
     */
    public TextField getTxtNitCli() {
        if (txtNitCli == null) {
//GEN-END:|1248-getter|0|1248-preInit
 // write pre-init user code here
txtNitCli = new TextField("Nit:", null, 32, TextField.NUMERIC);//GEN-LINE:|1248-getter|1|1248-postInit
 // write post-init user code here
}//GEN-BEGIN:|1248-getter|2|
        return txtNitCli;
    }
//</editor-fold>//GEN-END:|1248-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtNomCli ">//GEN-BEGIN:|1249-getter|0|1249-preInit
    /**
     * Returns an initialized instance of txtNomCli component.
     *
     * @return the initialized component instance
     */
    public TextField getTxtNomCli() {
        if (txtNomCli == null) {
//GEN-END:|1249-getter|0|1249-preInit
 // write pre-init user code here
txtNomCli = new TextField("Nombre:", null, 32, TextField.ANY);//GEN-LINE:|1249-getter|1|1249-postInit
 // write post-init user code here
}//GEN-BEGIN:|1249-getter|2|
        return txtNomCli;
    }
//</editor-fold>//GEN-END:|1249-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtTelCli ">//GEN-BEGIN:|1250-getter|0|1250-preInit
    /**
     * Returns an initialized instance of txtTelCli component.
     *
     * @return the initialized component instance
     */
    public TextField getTxtTelCli() {
        if (txtTelCli == null) {
//GEN-END:|1250-getter|0|1250-preInit
 // write pre-init user code here
txtTelCli = new TextField("Telefono:", null, 32, TextField.NUMERIC);//GEN-LINE:|1250-getter|1|1250-postInit
 // write post-init user code here
}//GEN-BEGIN:|1250-getter|2|
        return txtTelCli;
    }
//</editor-fold>//GEN-END:|1250-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtEmailCli ">//GEN-BEGIN:|1251-getter|0|1251-preInit
    /**
     * Returns an initialized instance of txtEmailCli component.
     *
     * @return the initialized component instance
     */
    public TextField getTxtEmailCli() {
        if (txtEmailCli == null) {
//GEN-END:|1251-getter|0|1251-preInit
 // write pre-init user code here
txtEmailCli = new TextField("Email:", null, 32, TextField.ANY);//GEN-LINE:|1251-getter|1|1251-postInit
 // write post-init user code here
}//GEN-BEGIN:|1251-getter|2|
        return txtEmailCli;
    }
//</editor-fold>//GEN-END:|1251-getter|2|







//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backDatos ">//GEN-BEGIN:|1262-getter|0|1262-preInit
    /**
     * Returns an initialized instance of backDatos component.
     *
     * @return the initialized component instance
     */
    public Command getBackDatos() {
        if (backDatos == null) {
//GEN-END:|1262-getter|0|1262-preInit
 // write pre-init user code here
backDatos = new Command("Ok", Command.OK, 0);//GEN-LINE:|1262-getter|1|1262-postInit
 // write post-init user code here
}//GEN-BEGIN:|1262-getter|2|
        return backDatos;
    }
//</editor-fold>//GEN-END:|1262-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image12 ">//GEN-BEGIN:|1271-getter|0|1271-preInit
    /**
     * Returns an initialized instance of image12 component.
     *
     * @return the initialized component instance
     */
    public Image getImage12() {
        if (image12 == null) {
//GEN-END:|1271-getter|0|1271-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|1271-getter|1|1271-@java.io.IOException
                image12 = Image.createImage("/f3.png");
            } catch (java.io.IOException e) {//GEN-END:|1271-getter|1|1271-@java.io.IOException
    e.printStackTrace();
            }//GEN-LINE:|1271-getter|2|1271-postInit
 // write post-init user code here
}//GEN-BEGIN:|1271-getter|3|
        return image12;
    }
//</editor-fold>//GEN-END:|1271-getter|3|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand10 ">//GEN-BEGIN:|1281-getter|0|1281-preInit
    /**
     * Returns an initialized instance of okCommand10 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand10() {
        if (okCommand10 == null) {
//GEN-END:|1281-getter|0|1281-preInit
 // write pre-init user code here
okCommand10 = new Command("Aceptar", Command.OK, 0);//GEN-LINE:|1281-getter|1|1281-postInit
 // write post-init user code here
}//GEN-BEGIN:|1281-getter|2|
        return okCommand10;
    }
//</editor-fold>//GEN-END:|1281-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand11 ">//GEN-BEGIN:|1286-getter|0|1286-preInit
    /**
     * Returns an initialized instance of okCommand11 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand11() {
        if (okCommand11 == null) {
//GEN-END:|1286-getter|0|1286-preInit
 // write pre-init user code here
okCommand11 = new Command("Atras", Command.OK, 0);//GEN-LINE:|1286-getter|1|1286-postInit
 // write post-init user code here
}//GEN-BEGIN:|1286-getter|2|
        return okCommand11;
    }
//</editor-fold>//GEN-END:|1286-getter|2|




 // enter pre-action user code here

 // enter post-action user code here






















//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand12 ">//GEN-BEGIN:|1302-getter|0|1302-preInit
    /**
     * Returns an initialized instance of okCommand12 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand12() {
        if (okCommand12 == null) {
//GEN-END:|1302-getter|0|1302-preInit
 // write pre-init user code here
okCommand12 = new Command("Aceptar", Command.OK, 0);//GEN-LINE:|1302-getter|1|1302-postInit
 // write post-init user code here
}//GEN-BEGIN:|1302-getter|2|
        return okCommand12;
    }
//</editor-fold>//GEN-END:|1302-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand13 ">//GEN-BEGIN:|1304-getter|0|1304-preInit
    /**
     * Returns an initialized instance of okCommand13 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand13() {
        if (okCommand13 == null) {
//GEN-END:|1304-getter|0|1304-preInit
 // write pre-init user code here
okCommand13 = new Command("Atras", Command.OK, 0);//GEN-LINE:|1304-getter|1|1304-postInit
 // write post-init user code here
}//GEN-BEGIN:|1304-getter|2|
        return okCommand13;
    }
//</editor-fold>//GEN-END:|1304-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand14 ">//GEN-BEGIN:|1309-getter|0|1309-preInit
    /**
     * Returns an initialized instance of okCommand14 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand14() {
        if (okCommand14 == null) {
//GEN-END:|1309-getter|0|1309-preInit
 // write pre-init user code here
okCommand14 = new Command("Aceptar", Command.OK, 0);//GEN-LINE:|1309-getter|1|1309-postInit
 // write post-init user code here
}//GEN-BEGIN:|1309-getter|2|
        return okCommand14;
    }
//</editor-fold>//GEN-END:|1309-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image13 ">//GEN-BEGIN:|1313-getter|0|1313-preInit
    /**
     * Returns an initialized instance of image13 component.
     *
     * @return the initialized component instance
     */
    public Image getImage13() {
        if (image13 == null) {
//GEN-END:|1313-getter|0|1313-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|1313-getter|1|1313-@java.io.IOException
                image13 = Image.createImage("/reporte.png");
            } catch (java.io.IOException e) {//GEN-END:|1313-getter|1|1313-@java.io.IOException
    e.printStackTrace();
            }//GEN-LINE:|1313-getter|2|1313-postInit
 // write post-init user code here
}//GEN-BEGIN:|1313-getter|3|
        return image13;
    }
//</editor-fold>//GEN-END:|1313-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image14 ">//GEN-BEGIN:|1314-getter|0|1314-preInit
    /**
     * Returns an initialized instance of image14 component.
     *
     * @return the initialized component instance
     */
    public Image getImage14() {
        if (image14 == null) {
//GEN-END:|1314-getter|0|1314-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|1314-getter|1|1314-@java.io.IOException
                image14 = Image.createImage("/ipx.png");
            } catch (java.io.IOException e) {//GEN-END:|1314-getter|1|1314-@java.io.IOException
    e.printStackTrace();
            }//GEN-LINE:|1314-getter|2|1314-postInit
 // write post-init user code here
}//GEN-BEGIN:|1314-getter|3|
        return image14;
    }
//</editor-fold>//GEN-END:|1314-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image15 ">//GEN-BEGIN:|1316-getter|0|1316-preInit
    /**
     * Returns an initialized instance of image15 component.
     *
     * @return the initialized component instance
     */
    public Image getImage15() {
        if (image15 == null) {
//GEN-END:|1316-getter|0|1316-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|1316-getter|1|1316-@java.io.IOException
                image15 = Image.createImage("/salir.png");
            } catch (java.io.IOException e) {//GEN-END:|1316-getter|1|1316-@java.io.IOException
    e.printStackTrace();
            }//GEN-LINE:|1316-getter|2|1316-postInit
 // write post-init user code here
}//GEN-BEGIN:|1316-getter|3|
        return image15;
    }
//</editor-fold>//GEN-END:|1316-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand15 ">//GEN-BEGIN:|1318-getter|0|1318-preInit
    /**
     * Returns an initialized instance of okCommand15 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand15() {
        if (okCommand15 == null) {
//GEN-END:|1318-getter|0|1318-preInit
 // write pre-init user code here
okCommand15 = new Command("guardar", Command.OK, 0);//GEN-LINE:|1318-getter|1|1318-postInit
 // write post-init user code here
}//GEN-BEGIN:|1318-getter|2|
        return okCommand15;
    }
//</editor-fold>//GEN-END:|1318-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand16 ">//GEN-BEGIN:|1320-getter|0|1320-preInit
    /**
     * Returns an initialized instance of okCommand16 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand16() {
        if (okCommand16 == null) {
//GEN-END:|1320-getter|0|1320-preInit
 // write pre-init user code here
okCommand16 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1320-getter|1|1320-postInit
 // write post-init user code here
}//GEN-BEGIN:|1320-getter|2|
        return okCommand16;
    }
//</editor-fold>//GEN-END:|1320-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: formAgenda ">//GEN-BEGIN:|1317-getter|0|1317-preInit
    /**
     * Returns an initialized instance of formAgenda component.
     *
     * @return the initialized component instance
     */
    public Form getFormAgenda() {
        if (formAgenda == null) {
//GEN-END:|1317-getter|0|1317-preInit
 // write pre-init user code here
formAgenda = new Form("Agenda", new Item[]{getTxt1(), getTxt2(), getTxt3()});//GEN-BEGIN:|1317-getter|1|1317-postInit
            formAgenda.addCommand(getOkCommand15());
            formAgenda.addCommand(getOkCommand17());
            formAgenda.addCommand(getOkCommand18());
            formAgenda.setCommandListener(this);//GEN-END:|1317-getter|1|1317-postInit
 // write post-init user code here
}//GEN-BEGIN:|1317-getter|2|
        return formAgenda;
    }
//</editor-fold>//GEN-END:|1317-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txt1 ">//GEN-BEGIN:|1322-getter|0|1322-preInit
    /**
     * Returns an initialized instance of txt1 component.
     *
     * @return the initialized component instance
     */
    public TextField getTxt1() {
        if (txt1 == null) {
//GEN-END:|1322-getter|0|1322-preInit
 // write pre-init user code here
txt1 = new TextField("Numero de Telefono:", null, 32, TextField.NUMERIC);//GEN-LINE:|1322-getter|1|1322-postInit
 // write post-init user code here
}//GEN-BEGIN:|1322-getter|2|
        return txt1;
    }
//</editor-fold>//GEN-END:|1322-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txt2 ">//GEN-BEGIN:|1323-getter|0|1323-preInit
    /**
     * Returns an initialized instance of txt2 component.
     *
     * @return the initialized component instance
     */
    public TextField getTxt2() {
        if (txt2 == null) {
//GEN-END:|1323-getter|0|1323-preInit
 // write pre-init user code here
txt2 = new TextField("Nombre", null, 32, TextField.ANY);//GEN-LINE:|1323-getter|1|1323-postInit
 // write post-init user code here
}//GEN-BEGIN:|1323-getter|2|
        return txt2;
    }
//</editor-fold>//GEN-END:|1323-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand17 ">//GEN-BEGIN:|1324-getter|0|1324-preInit
    /**
     * Returns an initialized instance of okCommand17 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand17() {
        if (okCommand17 == null) {
//GEN-END:|1324-getter|0|1324-preInit
 // write pre-init user code here
okCommand17 = new Command("rescatar", Command.OK, 0);//GEN-LINE:|1324-getter|1|1324-postInit
 // write post-init user code here
}//GEN-BEGIN:|1324-getter|2|
        return okCommand17;
    }
//</editor-fold>//GEN-END:|1324-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txt3 ">//GEN-BEGIN:|1326-getter|0|1326-preInit
    /**
     * Returns an initialized instance of txt3 component.
     *
     * @return the initialized component instance
     */
    public TextField getTxt3() {
        if (txt3 == null) {
//GEN-END:|1326-getter|0|1326-preInit
 // write pre-init user code here
txt3 = new TextField("id para rescatar", null, 32, TextField.ANY);//GEN-LINE:|1326-getter|1|1326-postInit
 // write post-init user code here
}//GEN-BEGIN:|1326-getter|2|
        return txt3;
    }
//</editor-fold>//GEN-END:|1326-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|1327-getter|0|1327-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {
//GEN-END:|1327-getter|0|1327-preInit
 // write pre-init user code here
exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|1327-getter|1|1327-postInit
 // write post-init user code here
}//GEN-BEGIN:|1327-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|1327-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand18 ">//GEN-BEGIN:|1330-getter|0|1330-preInit
    /**
     * Returns an initialized instance of okCommand18 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand18() {
        if (okCommand18 == null) {
//GEN-END:|1330-getter|0|1330-preInit
 // write pre-init user code here
okCommand18 = new Command("cambiar", Command.OK, 0);//GEN-LINE:|1330-getter|1|1330-postInit
 // write post-init user code here
}//GEN-BEGIN:|1330-getter|2|
        return okCommand18;
    }
//</editor-fold>//GEN-END:|1330-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand19 ">//GEN-BEGIN:|1334-getter|0|1334-preInit
    /**
     * Returns an initialized instance of okCommand19 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand19() {
        if (okCommand19 == null) {
//GEN-END:|1334-getter|0|1334-preInit
 // write pre-init user code here
okCommand19 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1334-getter|1|1334-postInit
 // write post-init user code here
}//GEN-BEGIN:|1334-getter|2|
        return okCommand19;
    }
//</editor-fold>//GEN-END:|1334-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okFiltro ">//GEN-BEGIN:|1337-getter|0|1337-preInit
    /**
     * Returns an initialized instance of okFiltro component.
     *
     * @return the initialized component instance
     */
    public Command getOkFiltro() {
        if (okFiltro == null) {
//GEN-END:|1337-getter|0|1337-preInit
 // write pre-init user code here
okFiltro = new Command("Aceptar", Command.OK, 0);//GEN-LINE:|1337-getter|1|1337-postInit
 // write post-init user code here
}//GEN-BEGIN:|1337-getter|2|
        return okFiltro;
    }
//</editor-fold>//GEN-END:|1337-getter|2|

    public Command getOkZona()
    {
        if(okZona == null )
        {
            //nota el valor 0 es la pocision del submenu de botones utilizados en la parte de la isquina inferio<
            okZona = new Command("Aceptar",Command.OK,0);
        }
        return okZona;
    }
//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okFil ">//GEN-BEGIN:|1340-getter|0|1340-preInit

    /**
     * Returns an initialized instance of okFil component.
     *
     * @return the initialized component instance
     */
    public Command getOkFil() {
        if (okFil == null) {
//GEN-END:|1340-getter|0|1340-preInit
 // write pre-init user code here
okFil = new Command("Ok", Command.OK, 0);//GEN-LINE:|1340-getter|1|1340-postInit
 // write post-init user code here
}//GEN-BEGIN:|1340-getter|2|
        return okFil;
    }
//</editor-fold>//GEN-END:|1340-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand20 ">//GEN-BEGIN:|1346-getter|0|1346-preInit
    /**
     * Returns an initialized instance of okCommand20 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand20() {
        if (okCommand20 == null) {
//GEN-END:|1346-getter|0|1346-preInit
 // write pre-init user code here
okCommand20 = new Command("oklista", Command.OK, 0);//GEN-LINE:|1346-getter|1|1346-postInit
 // write post-init user code here
}//GEN-BEGIN:|1346-getter|2|
        return okCommand20;
    }
//</editor-fold>//GEN-END:|1346-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: formVehiculo ">//GEN-BEGIN:|1352-getter|0|1352-preInit
    /**
     * Returns an initialized instance of formVehiculo component.
     *
     * @return the initialized component instance
     */
    public Form getFormVehiculo() {
        if (formVehiculo == null) {
//GEN-END:|1352-getter|0|1352-preInit
 // write pre-init user code here
formVehiculo = new Form("Datos de la Infaccion", new Item[]{getTextField(), getTextField1(), getTextField11(), getTextField12(), getTextField13()});//GEN-BEGIN:|1352-getter|1|1352-postInit
            formVehiculo.addCommand(getOkCommand21());
            formVehiculo.addCommand(getBack());
            formVehiculo.setCommandListener(this);//GEN-END:|1352-getter|1|1352-postInit
 // write post-init user code here
}//GEN-BEGIN:|1352-getter|2|
        return formVehiculo;
    }
//</editor-fold>//GEN-END:|1352-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand21 ">//GEN-BEGIN:|1353-getter|0|1353-preInit
    /**
     * Returns an initialized instance of okCommand21 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand21() {
        if (okCommand21 == null) {
//GEN-END:|1353-getter|0|1353-preInit
 // write pre-init user code here
okCommand21 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1353-getter|1|1353-postInit
 // write post-init user code here
}//GEN-BEGIN:|1353-getter|2|
        return okCommand21;
    }
//</editor-fold>//GEN-END:|1353-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|1355-getter|0|1355-preInit
    /**
     * Returns an initialized instance of textField component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {
//GEN-END:|1355-getter|0|1355-preInit
 // write pre-init user code here
textField = new TextField("Literal de Placa:", null, 32, TextField.ANY);//GEN-LINE:|1355-getter|1|1355-postInit
 // write post-init user code here
}//GEN-BEGIN:|1355-getter|2|
        return textField;
    }
//</editor-fold>//GEN-END:|1355-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|1356-getter|0|1356-preInit
    /**
     * Returns an initialized instance of textField1 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {
//GEN-END:|1356-getter|0|1356-preInit
 // write pre-init user code here
textField1 = new TextField("No. de Placa:", null, 32, TextField.NUMERIC);//GEN-LINE:|1356-getter|1|1356-postInit
 // write post-init user code here
}//GEN-BEGIN:|1356-getter|2|
        return textField1;
    }
//</editor-fold>//GEN-END:|1356-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand22 ">//GEN-BEGIN:|1364-getter|0|1364-preInit
    /**
     * Returns an initialized instance of okCommand22 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand22() {
        if (okCommand22 == null) {
//GEN-END:|1364-getter|0|1364-preInit
 // write pre-init user code here
okCommand22 = new Command("Datos del Conductor", Command.OK, 0);//GEN-LINE:|1364-getter|1|1364-postInit
 // write post-init user code here
}//GEN-BEGIN:|1364-getter|2|
        return okCommand22;
    }
//</editor-fold>//GEN-END:|1364-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand23 ">//GEN-BEGIN:|1366-getter|0|1366-preInit
    /**
     * Returns an initialized instance of okCommand23 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand23() {
        if (okCommand23 == null) {
//GEN-END:|1366-getter|0|1366-preInit
 // write pre-init user code here
okCommand23 = new Command("Datos del Operador", Command.OK, 0);//GEN-LINE:|1366-getter|1|1366-postInit
 // write post-init user code here
}//GEN-BEGIN:|1366-getter|2|
        return okCommand23;
    }
//</editor-fold>//GEN-END:|1366-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand24 ">//GEN-BEGIN:|1368-getter|0|1368-preInit
    /**
     * Returns an initialized instance of okCommand24 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand24() {
        if (okCommand24 == null) {
//GEN-END:|1368-getter|0|1368-preInit
 // write pre-init user code here
okCommand24 = new Command("Siguiente", Command.OK, 0);//GEN-LINE:|1368-getter|1|1368-postInit
 // write post-init user code here
}//GEN-BEGIN:|1368-getter|2|
        return okCommand24;
    }
//</editor-fold>//GEN-END:|1368-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand25 ">//GEN-BEGIN:|1371-getter|0|1371-preInit
    /**
     * Returns an initialized instance of okCommand25 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand25() {
        if (okCommand25 == null) {
//GEN-END:|1371-getter|0|1371-preInit
 // write pre-init user code here
okCommand25 = new Command("Imprimir Infraccion", Command.OK, 0);//GEN-LINE:|1371-getter|1|1371-postInit
 // write post-init user code here
}//GEN-BEGIN:|1371-getter|2|
        return okCommand25;
    }
//</editor-fold>//GEN-END:|1371-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: listVehiculo ">//GEN-BEGIN:|1358-getter|0|1358-preInit
    /**
     * Returns an initialized instance of listVehiculo component.
     *
     * @return the initialized component instance
     */
    public List getListVehiculo() {
        if (listVehiculo == null) {
//GEN-END:|1358-getter|0|1358-preInit
 // write pre-init user code here
listVehiculo = new List("Descripcion del Vehiculo", Choice.IMPLICIT);//GEN-BEGIN:|1358-getter|1|1358-postInit
            listVehiculo.append("Tipo de Vehiculo:", null);
            listVehiculo.append("Color:", null);
            listVehiculo.append("Zona:", null);
            listVehiculo.addCommand(getOkCommand29());
            listVehiculo.addCommand(getOkCommand22());
            listVehiculo.setCommandListener(this);
            listVehiculo.setSelectedFlags(new boolean[]{false, false, false});//GEN-END:|1358-getter|1|1358-postInit
 // write post-init user code here
}//GEN-BEGIN:|1358-getter|2|
        return listVehiculo;
    }
//</editor-fold>//GEN-END:|1358-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listVehiculoAction ">//GEN-BEGIN:|1358-action|0|1358-preAction
    /**
     * Performs an action assigned to the selected list element in the
     * listVehiculo component.
     */
    public void listVehiculoAction() {
//GEN-END:|1358-action|0|1358-preAction
 // enter pre-action user code here
String __selectedString = getListVehiculo().getString(getListVehiculo().getSelectedIndex());//GEN-BEGIN:|1358-action|1|1361-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Tipo de Vehiculo:")) {//GEN-END:|1358-action|1|1361-preAction
 // write pre-action user code here
//GEN-LINE:|1358-action|2|1361-postAction
 // write post-action user code here
} else if (__selectedString.equals("Color:")) {//GEN-LINE:|1358-action|3|1362-preAction
 // write pre-action user code here
//GEN-LINE:|1358-action|4|1362-postAction
 // write post-action user code here
} else if (__selectedString.equals("Zona:")) {//GEN-LINE:|1358-action|5|1423-preAction
 // write pre-action user code here
//GEN-LINE:|1358-action|6|1423-postAction
 // write post-action user code here
}//GEN-BEGIN:|1358-action|7|1358-postAction
        }//GEN-END:|1358-action|7|1358-postAction
 // enter post-action user code here
}//GEN-BEGIN:|1358-action|8|
//</editor-fold>//GEN-END:|1358-action|8|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: formInfraccion ">//GEN-BEGIN:|1370-getter|0|1370-preInit
    /**
     * Returns an initialized instance of formInfraccion component.
     *
     * @return the initialized component instance
     */
    public Form getFormInfraccion() {
        if (formInfraccion == null) {
//GEN-END:|1370-getter|0|1370-preInit
 // write pre-init user code here
formInfraccion = new Form("Infraccion", new Item[]{getTextField2(), getTextField4(), getTextField3()});//GEN-BEGIN:|1370-getter|1|1370-postInit
            formInfraccion.addCommand(getImprimirFactura());
            formInfraccion.setCommandListener(this);//GEN-END:|1370-getter|1|1370-postInit
 // write post-init user code here
}//GEN-BEGIN:|1370-getter|2|
        return formInfraccion;
    }
//</editor-fold>//GEN-END:|1370-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField2 ">//GEN-BEGIN:|1374-getter|0|1374-preInit
    /**
     * Returns an initialized instance of textField2 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField2() {
        if (textField2 == null) {
//GEN-END:|1374-getter|0|1374-preInit
 // write pre-init user code here
textField2 = new TextField("Codigo de Infraccion 1:", null, 32, TextField.NUMERIC);//GEN-LINE:|1374-getter|1|1374-postInit
 // write post-init user code here
}//GEN-BEGIN:|1374-getter|2|
        return textField2;
    }
//</editor-fold>//GEN-END:|1374-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField3 ">//GEN-BEGIN:|1375-getter|0|1375-preInit
    /**
     * Returns an initialized instance of textField3 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField3() {
        if (textField3 == null) {
//GEN-END:|1375-getter|0|1375-preInit
 // write pre-init user code here
textField3 = new TextField("Codigo de Agravante:", null, 32, TextField.NUMERIC);//GEN-LINE:|1375-getter|1|1375-postInit
 // write post-init user code here
}//GEN-BEGIN:|1375-getter|2|
        return textField3;
    }
//</editor-fold>//GEN-END:|1375-getter|2|









//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand26 ">//GEN-BEGIN:|1382-getter|0|1382-preInit
    /**
     * Returns an initialized instance of okCommand26 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand26() {
        if (okCommand26 == null) {
//GEN-END:|1382-getter|0|1382-preInit
 // write pre-init user code here
okCommand26 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1382-getter|1|1382-postInit
 // write post-init user code here
}//GEN-BEGIN:|1382-getter|2|
        return okCommand26;
    }
//</editor-fold>//GEN-END:|1382-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand27 ">//GEN-BEGIN:|1392-getter|0|1392-preInit
    /**
     * Returns an initialized instance of okCommand27 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand27() {
        if (okCommand27 == null) {
//GEN-END:|1392-getter|0|1392-preInit
 // write pre-init user code here
okCommand27 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1392-getter|1|1392-postInit
 // write post-init user code here
}//GEN-BEGIN:|1392-getter|2|
        return okCommand27;
    }
//</editor-fold>//GEN-END:|1392-getter|2|





//<editor-fold defaultstate="collapsed" desc=" Generated Getter: formConductor ">//GEN-BEGIN:|1386-getter|0|1386-preInit
    /**
     * Returns an initialized instance of formConductor component.
     *
     * @return the initialized component instance
     */
    public Form getFormConductor() {
        if (formConductor == null) {
//GEN-END:|1386-getter|0|1386-preInit
 // write pre-init user code here
            
                    
            formConductor = new Form("Datos del Infractor", new Item[]{getTextField8(), getTextField6(), getTextField7(), getTextField5()});//GEN-BEGIN:|1386-getter|1|1386-postInit
            formConductor.addCommand(getOkCommand27());
            formConductor.setCommandListener(this);//GEN-END:|1386-getter|1|1386-postInit
 
            
            //#style horizontalChoice
            group = new ChoiceGroup("Lugar de Procedencia:", ChoiceGroup.EXCLUSIVE );
            //#style choiceItem
            group.append( "LP", null );
            //#style choiceItem
            group.append( "SCZ", null );
            //#style choiceItem
            group.append( "CBA", null );
            //#style choiceItem
            group.append( "BNI", null );
            //#style choiceItem
            group.append( "CHQ", null );
            //#style choiceItem
            group.append( "ORU", null );
            //#style choiceItem
            group.append( "PND", null );
            //#style choiceItem
            group.append( "PSI", null );
            //#style choiceItem
            group.append( "TJA", null );    

            formConductor.append( group );
            
        }//GEN-BEGIN:|1386-getter|2|
        return formConductor;
    }
//</editor-fold>//GEN-END:|1386-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField6 ">//GEN-BEGIN:|1389-getter|0|1389-preInit
    /**
     * Returns an initialized instance of textField6 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField6() {
        if (textField6 == null) {
//GEN-END:|1389-getter|0|1389-preInit
 // write pre-init user code here
textField6 = new TextField("Nombre:", null, 32, TextField.ANY);//GEN-LINE:|1389-getter|1|1389-postInit
 // write post-init user code here
}//GEN-BEGIN:|1389-getter|2|
        return textField6;
    }
//</editor-fold>//GEN-END:|1389-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField7 ">//GEN-BEGIN:|1390-getter|0|1390-preInit
    /**
     * Returns an initialized instance of textField7 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField7() {
        if (textField7 == null) {
//GEN-END:|1390-getter|0|1390-preInit
 // write pre-init user code here
textField7 = new TextField("Apellido Paterno:", null, 32, TextField.ANY);//GEN-LINE:|1390-getter|1|1390-postInit
 // write post-init user code here
}//GEN-BEGIN:|1390-getter|2|
        return textField7;
    }
//</editor-fold>//GEN-END:|1390-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField8 ">//GEN-BEGIN:|1391-getter|0|1391-preInit
    /**
     * Returns an initialized instance of textField8 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField8() {
        if (textField8 == null) {
//GEN-END:|1391-getter|0|1391-preInit
 // write pre-init user code here
textField8 = new TextField("CI:", null, 32, TextField.NUMERIC);//GEN-LINE:|1391-getter|1|1391-postInit
 // write post-init user code here
}//GEN-BEGIN:|1391-getter|2|
        return textField8;
    }
//</editor-fold>//GEN-END:|1391-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand28 ">//GEN-BEGIN:|1399-getter|0|1399-preInit
    /**
     * Returns an initialized instance of okCommand28 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand28() {
        if (okCommand28 == null) {
//GEN-END:|1399-getter|0|1399-preInit
 // write pre-init user code here
okCommand28 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1399-getter|1|1399-postInit
 // write post-init user code here
}//GEN-BEGIN:|1399-getter|2|
        return okCommand28;
    }
//</editor-fold>//GEN-END:|1399-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: formLogin ">//GEN-BEGIN:|1396-getter|0|1396-preInit
    /**
     * Returns an initialized instance of formLogin component.
     *
     * @return the initialized component instance
     */
    public Form getFormLogin() {
        if (formLogin == null) {
//GEN-END:|1396-getter|0|1396-preInit
 // write pre-init user code here
formLogin = new Form("Autentificaci\u00F3n", new Item[]{getTextField9(), getTextField10()});//GEN-BEGIN:|1396-getter|1|1396-postInit
            formLogin.addCommand(getOkCommand28());
            formLogin.setCommandListener(this);//GEN-END:|1396-getter|1|1396-postInit
 // write post-init user code here
}//GEN-BEGIN:|1396-getter|2|
        return formLogin;
    }
//</editor-fold>//GEN-END:|1396-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField9 ">//GEN-BEGIN:|1397-getter|0|1397-preInit
    /**
     * Returns an initialized instance of textField9 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField9() {
        if (textField9 == null) {
//GEN-END:|1397-getter|0|1397-preInit
 // write pre-init user code here
textField9 = new TextField("Usuario:", null, 32, TextField.ANY);//GEN-LINE:|1397-getter|1|1397-postInit
 // write post-init user code here
}//GEN-BEGIN:|1397-getter|2|
        return textField9;
    }
//</editor-fold>//GEN-END:|1397-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField10 ">//GEN-BEGIN:|1398-getter|0|1398-preInit
    /**
     * Returns an initialized instance of textField10 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField10() {
        if (textField10 == null) {
//GEN-END:|1398-getter|0|1398-preInit
 // write pre-init user code here
textField10 = new TextField("Contrase\u00F1a:", null, 32, TextField.ANY | TextField.PASSWORD);//GEN-LINE:|1398-getter|1|1398-postInit
 // write post-init user code here
}//GEN-BEGIN:|1398-getter|2|
        return textField10;
    }
//</editor-fold>//GEN-END:|1398-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand29 ">//GEN-BEGIN:|1402-getter|0|1402-preInit
    /**
     * Returns an initialized instance of okCommand29 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand29() {
        if (okCommand29 == null) {
//GEN-END:|1402-getter|0|1402-preInit
 // write pre-init user code here
okCommand29 = new Command("Seleccionar", Command.BACK, 0);//GEN-LINE:|1402-getter|1|1402-postInit
 // write post-init user code here
}//GEN-BEGIN:|1402-getter|2|
        return okCommand29;
    }
//</editor-fold>//GEN-END:|1402-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: methodLogin ">//GEN-BEGIN:|1409-entry|0|1410-preAction
    /**
     * Performs an action assigned to the methodLogin entry-point.
     */
    public void methodLogin() {
//GEN-END:|1409-entry|0|1410-preAction
 // write pre-action user code here 
//        UsrCod=admin&UsrPwd=adm
//        String parametros= "UsrCod="+textField9.getString()+"&UsrPwd="+textField10.getString();
        pantalla = AUTENTIFICACION;
        System.out.print("entrando al comparador");
        if(textField9.getString().equals("admin")&&textField10.getString().equals("adm"))
        {
            switchDisplayable(null, getListAdministrador());
            
        }
//        System.out.print("saliendo comparador");
        else
        {
            int sw;
            sw=0;
            for(int i=0;i<vectorUsuarios.size();i++)
            {
                Usuarios u = (Usuarios) vectorUsuarios.elementAt(i);
                if(u.getUser().equals(textField9.getString())&&u.getPassword().equals(textField10.getString()))
                {
                    sw=1;
                    
                    i=vectorUsuarios.size();
                    autentificacion = new Autentificacion();
                    autentificacion.setNombre(u.getUser());
                    autentificacion.setUsrpwd(u.getPassword());
                }
            }
                if(sw==1)
                {
                    cambiarPantalla();
                }
                else
                {
                    
                    switchDisplayable(null, getFormLogin());
                    
                    switchDisplayable(getProblemas(), getFormLogin());
                    
                }
            
       }
       
//        Cargando();
//        Thread t = new Thread()
//        {
//            public void run()
//            {
//                   
//                System.out.println(" thred consumidor activo");
//                if(rest.getCodigoRespuesta()==200)
//                {   
//                    
//                    autentificacion = new Autentificacion(rest.getRespuesta());
//                    
//                    cambiarPantalla();
//                    listMenu.setTitle("Usuario:"+autentificacion.getNombre());
//                    //Cargando el titulo de la lista
//                    
//                }
//                else
//                {   
//                    //Repinta la pantalla antes de que esta esetes
//                    switchDisplayable(null, getFormLogin());
//                    
//                    switchDisplayable(getProblemas(), getFormLogin());
//                }   
//
//            
//            }
//      
//        };       
//        
//        conexion.EnviarGet(AUTENTIFICACION,parametros,t);
//        conexion.Lenvantate();
           
/*        
switchDisplayable (null, getListMenu ());//GEN-BEGIN:|1409-entry|1|1410-postAction
//GEN-END:|1409-entry|1|1410-postAction
 */
// write post-action user code here
}//GEN-BEGIN:|1409-entry|2|
//</editor-fold>//GEN-END:|1409-entry|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: methodActualizacion ">//GEN-BEGIN:|1413-entry|0|1414-preAction
    /**
     * Performs an action assigned to the methodActualizacion entry-point.
     */
    public void methodActualizacion() {
//GEN-END:|1413-entry|0|1414-preAction
 // write pre-action user code here
       pantalla = CONSULTA;
       Cargando();
       
        Thread t = new Thread()
        {
            public void run()
            {
                   
                System.out.println(" thred consumidor activo");
                if(rest.getCodigoRespuesta()==200)
                {   
//                    consulta = new ConsutalDatos(rest.getRespuesta());
                    consulta = new ConsultaDatos("{\"respond1\":{\"Colores\":{\"SDColores.SDColoresItem\":[{\"ColCod\":0,\"ColDes\":\"\"},{\"ColCod\":3,\"ColDes\":\"AMARILLO\"}]}},\"respond2\":{\"Tipos\":{\"SDTiposVehiculo.SDTiposVehiculoItem\":[{\"TipVehCod\":0,\"TipVehDes\":\"\"},{\"TipVehCod\":15,\"TipVehDes\":\"AUTOMOVIL\"},{\"TipVehCod\":4,\"TipVehDes\":\"BUS\"},{\"TipVehCod\":14,\"TipVehDes\":\"CAMION\"},{\"TipVehCod\":2,\"TipVehDes\":\"CARRY\"},{\"TipVehCod\":11,\"TipVehDes\":\"FURGON\"},{\"TipVehCod\":12,\"TipVehDes\":\"FURGONETA\"},{\"TipVehCod\":5,\"TipVehDes\":\"MICRO\"},{\"TipVehCod\":10,\"TipVehDes\":\"MICROBUS\"},{\"TipVehCod\":1,\"TipVehDes\":\"MINIBUS\"},{\"TipVehCod\":13,\"TipVehDes\":\"OMNIBUS\"},{\"TipVehCod\":16,\"TipVehDes\":\"TAXI\"},{\"TipVehCod\":3,\"TipVehDes\":\"TRUFI\"},{\"TipVehCod\":6,\"TipVehDes\":\"VAGONETA\"}]}},\"respond3\":{\"Zonas\":{\"RestZonas.RestZonasItem\":[{\"ZonCod\":643,\"ZonDes\":\"SIN REGISTRAR\",\"ZonEst\":\"S\"},{\"ZonCod\":14,\"ZonDes\":\"1 DE MAYO CONSTRUCTORES\",\"ZonEst\":\"S\"},{\"ZonCod\":7,\"ZonDes\":\"14 DE SEPTIEMBRE\",\"ZonEst\":\"S\"},{\"ZonCod\":15,\"ZonDes\":\"18 DE MARZO\",\"ZonEst\":\"S\"},{\"ZonCod\":10,\"ZonDes\":\"21 DE ENERO\",\"ZonEst\":\"S\"},{\"ZonCod\":13,\"ZonDes\":\"23 DE MARZO\",\"ZonEst\":\"S\"},{\"ZonCod\":325,\"ZonDes\":\"23 DE MARZO\",\"ZonEst\":\"S\"},{\"ZonCod\":37,\"ZonDes\":\"24 DE JUNIO \\\"A\\\"\",\"ZonEst\":\"S\"},{\"ZonCod\":60,\"ZonDes\":\"24 DE JUNIO \\\"B\\\"\",\"ZonEst\":\"S\"},{\"ZonCod\":83,\"ZonDes\":\"24 DE JUNIO SECTOR B\",\"ZonEst\":\"S\"}]}}}");
//                    autentificacion = new Autentificacion(rest.getRespuesta());
                    vectorVehiculo= consulta.getVectorVehiculo();
                    vectorColores=consulta.getVectorColores();
                    vectorZona=consulta.getVectorZona();
                    
                    System.out.print("termino consumiendo");
                    cambiarPantalla();
//                    listMenu.setTitle("Usuario:"+autentificacion.getNombre());
                    //Cargando el titulo de la lista
                    
                }
                else
                {   
                    //Repinta la pantalla antes de que esta esetes
                    switchDisplayable(null, getFormLogin());
                    switchDisplayable(getProblemas(), getFormLogin());
                }   

            
            }
      
        };       
        
        conexion.EnviarGet(CONSULTA,"",t);
        conexion.Lenvantate();
        /*
switchDisplayable (null, getListAdministrador ());//GEN-BEGIN:|1413-entry|1|1414-postAction
//GEN-END:|1413-entry|1|1414-postAction
 */
    }//GEN-BEGIN:|1413-entry|2|
//</editor-fold>//GEN-END:|1413-entry|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField11 ">//GEN-BEGIN:|1419-getter|0|1419-preInit
    /**
     * Returns an initialized instance of textField11 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField11() {
        if (textField11 == null) {
//GEN-END:|1419-getter|0|1419-preInit
 // write pre-init user code here
textField11 = new TextField("Tipo de Via:", null, 32, TextField.ANY);//GEN-LINE:|1419-getter|1|1419-postInit
 // write post-init user code here
}//GEN-BEGIN:|1419-getter|2|
        return textField11;
    }
//</editor-fold>//GEN-END:|1419-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField12 ">//GEN-BEGIN:|1420-getter|0|1420-preInit
    /**
     * Returns an initialized instance of textField12 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField12() {
        if (textField12 == null) {
//GEN-END:|1420-getter|0|1420-preInit
 // write pre-init user code here
textField12 = new TextField("Calle:", null, 32, TextField.ANY);//GEN-LINE:|1420-getter|1|1420-postInit
 // write post-init user code here
}//GEN-BEGIN:|1420-getter|2|
        return textField12;
    }
//</editor-fold>//GEN-END:|1420-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField4 ">//GEN-BEGIN:|1424-getter|0|1424-preInit
    /**
     * Returns an initialized instance of textField4 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField4() {
        if (textField4 == null) {
//GEN-END:|1424-getter|0|1424-preInit
 // write pre-init user code here
textField4 = new TextField("Codigo de Infraccion 2:", null, 32, TextField.NUMERIC);//GEN-LINE:|1424-getter|1|1424-postInit
 // write post-init user code here
}//GEN-BEGIN:|1424-getter|2|
        return textField4;
    }
//</editor-fold>//GEN-END:|1424-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField5 ">//GEN-BEGIN:|1425-getter|0|1425-preInit
    /**
     * Returns an initialized instance of textField5 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField5() {
        if (textField5 == null) {
//GEN-END:|1425-getter|0|1425-preInit
 // write pre-init user code here
textField5 = new TextField("Apellido Materno:", null, 32, TextField.ANY);//GEN-LINE:|1425-getter|1|1425-postInit
 // write post-init user code here
}//GEN-BEGIN:|1425-getter|2|
        return textField5;
    }
//</editor-fold>//GEN-END:|1425-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField13 ">//GEN-BEGIN:|1426-getter|0|1426-preInit
    /**
     * Returns an initialized instance of textField13 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField13() {
        if (textField13 == null) {
//GEN-END:|1426-getter|0|1426-preInit
 // write pre-init user code here
textField13 = new TextField("Linea:", null, 32, TextField.NUMERIC);//GEN-LINE:|1426-getter|1|1426-postInit
 // write post-init user code here
}//GEN-BEGIN:|1426-getter|2|
        return textField13;
    }
//</editor-fold>//GEN-END:|1426-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: methodInfraccion ">//GEN-BEGIN:|1427-entry|0|1428-preAction
    /**
     * Performs an action assigned to the methodInfraccion entry-point.
     */
    public void methodInfraccion() {
//GEN-END:|1427-entry|0|1428-preAction
 // write pre-action user code here
        pantalla = REGISTRARINFRACCION;
        infcon.setFecha(DateUtil.getCurrentDate());
        Cargando();
        Thread t = new Thread()
        {
            public void run()
            {
                   
                System.out.println(" thred consumidor activo");
                if(rest.getCodigoRespuesta()==200)
                {   
                    infraccion = new Infraccion_1(rest.getRespuesta());
//                   
                    try {
                     
                        javax.microedition.lcdui.Image ImagenQr=ImprimirQr(infcon);
                        BmpArray ba = new BmpArray();
                        byte imagen[] =  ba.readImage(BMPGenerator.encodeBMP(ImagenQr));
                        Imprimir(infraccion,infcon,imagen);
                        cambiarPantalla();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } 
                    
//                     Imprimir(infcon);
//                    cambiarPantalla();
                   
//                    listMenu.setTitle("Usuario:"+autentificacion.getNombre());
                    //Cargando el titulo de la lista
                    //imprimr la infraccion
                    
                    
                    
                    
                }
                else
                {   
                    //Repinta la pantalla antes de que esta esetes
                    switchDisplayable(null, getFormLogin());
                    switchDisplayable(getProblemas(), getFormLogin());
                }   

            
            }
      
        };       
        
        conexion.EnviarGet(REGISTRARINFRACCION,infcon.getConsulta(),t);
        conexion.Lenvantate();
        /*
switchDisplayable (null, getListMenu ());//GEN-BEGIN:|1427-entry|1|1428-postAction
//GEN-END:|1427-entry|1|1428-postAction
        */
        
        // write post-action user code here
}//GEN-BEGIN:|1427-entry|2|
//</editor-fold>//GEN-END:|1427-entry|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand30 ">//GEN-BEGIN:|1439-getter|0|1439-preInit
    /**
     * Returns an initialized instance of okCommand30 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand30() {
        if (okCommand30 == null) {
//GEN-END:|1439-getter|0|1439-preInit
            // write pre-init user code here
okCommand30 = new Command("Salir", Command.BACK, 0);//GEN-LINE:|1439-getter|1|1439-postInit
            // write post-init user code here
}//GEN-BEGIN:|1439-getter|2|
        return okCommand30;
    }
//</editor-fold>//GEN-END:|1439-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand3 ">//GEN-BEGIN:|1441-getter|0|1441-preInit
    /**
     * Returns an initialized instance of backCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand3() {
        if (backCommand3 == null) {
//GEN-END:|1441-getter|0|1441-preInit
            // write pre-init user code here
backCommand3 = new Command("Seleccionar", Command.OK, 0);//GEN-LINE:|1441-getter|1|1441-postInit
            // write post-init user code here
}//GEN-BEGIN:|1441-getter|2|
        return backCommand3;
    }
//</editor-fold>//GEN-END:|1441-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: listAdministrador ">//GEN-BEGIN:|1432-getter|0|1432-preInit
    /**
     * Returns an initialized instance of listAdministrador component.
     *
     * @return the initialized component instance
     */
    public List getListAdministrador() {
        if (listAdministrador == null) {
//GEN-END:|1432-getter|0|1432-preInit
            // write pre-init user code here
listAdministrador = new List("Usuario Administrador", Choice.IMPLICIT);//GEN-BEGIN:|1432-getter|1|1432-postInit
            listAdministrador.append("Actualizar Informacion", null);
            listAdministrador.append("Actualizar Usuarios", null);
            listAdministrador.addCommand(getOkCommand31());
            listAdministrador.addCommand(getBackCommand4());
            listAdministrador.setCommandListener(this);
            listAdministrador.setSelectedFlags(new boolean[]{false, false});//GEN-END:|1432-getter|1|1432-postInit
            // write post-init user code here
}//GEN-BEGIN:|1432-getter|2|
        return listAdministrador;
    }
//</editor-fold>//GEN-END:|1432-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listAdministradorAction ">//GEN-BEGIN:|1432-action|0|1432-preAction
    /**
     * Performs an action assigned to the selected list element in the
     * listAdministrador component.
     */
    public void listAdministradorAction() {
//GEN-END:|1432-action|0|1432-preAction
        // enter pre-action user code here
String __selectedString = getListAdministrador().getString(getListAdministrador().getSelectedIndex());//GEN-BEGIN:|1432-action|1|1435-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Actualizar Informacion")) {//GEN-END:|1432-action|1|1435-preAction
                // write pre-action user code here
methodActualizacion();//GEN-LINE:|1432-action|2|1435-postAction
                // write post-action user code here
} else if (__selectedString.equals("Actualizar Usuarios")) {//GEN-LINE:|1432-action|3|1436-preAction
                // write pre-action user code here
methodUsurios();//GEN-LINE:|1432-action|4|1436-postAction
                // write post-action user code here
}//GEN-BEGIN:|1432-action|5|1432-postAction
        }//GEN-END:|1432-action|5|1432-postAction
        // enter post-action user code here
}//GEN-BEGIN:|1432-action|6|
//</editor-fold>//GEN-END:|1432-action|6|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: methodUsurios ">//GEN-BEGIN:|1445-entry|0|1446-preAction
    /**
     * Performs an action assigned to the methodUsurios entry-point.
     */
    public void methodUsurios() {
//GEN-END:|1445-entry|0|1446-preAction
        // write pre-action user code here
        pantalla = CONSULTAUSUARIOS;
       Cargando();
       
        Thread t = new Thread()
        {
            public void run()
            {
                   
                System.out.println(" thred consumidor activo");
                if(rest.getCodigoRespuesta()==200)
                {   
//                    consulta = new ConsutalDatos(rest.getRespuesta());
                    usuarios = new ListaUsuarios("{\"respuesta\":{\"RestUsuarios.RestUsuariosItem\":[{\"User\":\"a\",\"Password\":\"123\"},{\"User\":\"abel.sirpa\",\"Password\":\"123\"},{\"User\":\"abigail.alconini\",\"Password\":\"123\"}]}}");
                    
                    vectorUsuarios=usuarios.getUsuarios();
                    for(int i=0;i<vectorUsuarios.size();i++)
                    {
                        Usuarios u = (Usuarios) vectorUsuarios.elementAt(i);
                        System.out.println("user:"+u.getUser()+" pass:"+u.getPassword());
                    }    
                        System.out.print("termino consumiendo usuarios");
                    cambiarPantalla();
//                    listMenu.setTitle("Usuario:"+autentificacion.getNombre());
                    //Cargando el titulo de la lista
                    
                }
                else
                {   
                    //Repinta la pantalla antes de que esta esetes
                    switchDisplayable(null, getFormLogin());
                    switchDisplayable(getProblemas(), getFormLogin());
                }   

            
            }
      
        };       
        
        conexion.EnviarGet(CONSULTAUSUARIOS,"",t);
        conexion.Lenvantate();
        /*
switchDisplayable (null, getListAdministrador ());//GEN-BEGIN:|1445-entry|1|1446-postAction
//GEN-END:|1445-entry|1|1446-postAction
        */
        
    }//GEN-BEGIN:|1445-entry|2|
//</editor-fold>//GEN-END:|1445-entry|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand31 ">//GEN-BEGIN:|1451-getter|0|1451-preInit
    /**
     * Returns an initialized instance of okCommand31 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand31() {
        if (okCommand31 == null) {
//GEN-END:|1451-getter|0|1451-preInit
            // write pre-init user code here
okCommand31 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1451-getter|1|1451-postInit
            // write post-init user code here
}//GEN-BEGIN:|1451-getter|2|
        return okCommand31;
    }
//</editor-fold>//GEN-END:|1451-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand4 ">//GEN-BEGIN:|1457-getter|0|1457-preInit
    /**
     * Returns an initialized instance of backCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand4() {
        if (backCommand4 == null) {
//GEN-END:|1457-getter|0|1457-preInit
            // write pre-init user code here
backCommand4 = new Command("Salir", Command.BACK, 0);//GEN-LINE:|1457-getter|1|1457-postInit
            // write post-init user code here
}//GEN-BEGIN:|1457-getter|2|
        return backCommand4;
    }
//</editor-fold>//GEN-END:|1457-getter|2|





public void Imprimir(Factura factura)
{
     double monto = Double.parseDouble(factura.getAmount());
                    imprimir = Printer.getInstance();
                    switch (imprimir.getPaperStatus()) // check paper status
			{
			case Printer.PRINTER_EXIST_PAPER:
				if (imprimir.voltageCheck()) // check voltage, if it is allowed to
											// print
				{
                                    //Imprimiendo Factura
                                    DeviceOps deviceOps = DeviceOps.getInstance();
                                    imprimir.printBitmap(deviceOps.readImage("/1d.bmp", 0));
//                                   
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    //Datos de la Empresa
//                                    imprimir.printText(ConstruirFila("NIT:"+factura.getAccount().getNit()), 1);
                                    imprimir.printText(ConstruirFila("FACTURA No."+factura.getInvoiceNumber()), 1);
                                    imprimir.printText(ConstruirFila("AUTORIZACI\u00D3N No."+factura.getAccount().getNumAuto()), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    //Datos del cliente
                                    imprimir.printText("FECHA:"+factura.getInvoiceDate(), 1);
                                    imprimir.printText("NOMBRE:"+factura.getCliente().getName(), 1);
                                    imprimir.printText("NIT/CI:"+factura.getCliente().getNit(), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    //invoice items
                                    imprimir.printText(ConstruirFila("CANT.","CONCEPTO","TOTAL"), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
//                                    for(int i=0;i<listaProductos.size();i++)
//                                    {   
//                                       Products prod= (Products) listaProductos.elementAt(i);
//                                       Tokenizer tk = new Tokenizer(Double.parseDouble(prod.getQty())+"","."); 
//                                       String cantidad= tk.nextToken();
//                                       String costo = ""+(Double.parseDouble(prod.getCost())*Double.parseDouble(prod.getQty()));
//                                       String concepto = prod.getNotes();
//                                       imprimir.printText(ConstruirFila(cantidad,concepto,costo), 1);
//                                    }
                                    String costo="";
                                    for(int i =0;i<factura.getInvoiceItems().size();i++)
                                    {
                                        InvoiceItems invitem = (InvoiceItems) factura.getInvoiceItems().elementAt(i);
                                        
                                        Tokenizer tk = new Tokenizer(invitem.getQty(),".");
                                        
                                        String cantidad= tk.nextToken();
                                        costo = ""+(Double.parseDouble(invitem.getCost())*Double.parseDouble(invitem.getQty()));
                                        String concepto = invitem.getNotes();
                                        imprimir.printText(ConstruirFila(cantidad,concepto,costo), 1);
                                    }
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                                                       
                                    imprimir.printText("MONTO TOTAL: Bs "+costo,1);
                                    imprimir.printText("SON:"+NumeroLiteral(""+monto)+"Bolivianos",1);
                                    imprimir.printText("C\u00D3DIGO DE CONTROL:"+factura.getControlCode(),1);
                                    imprimir.printText("FECHA LIMITE EMISI\u00D3N:"+factura.getAccount().getFechaLimite(),1);
//                                    imprimir.printText("CSD:"+operador.getId()+" "+operador.getUsuario() +"-"+factura.getDatecom(), 1);
                                    imprimir.printText("CSD:143 farbo-18:"+DateUtil.getCurrentDate(), 1);
//                                    ImprimirQr(factura);
                                    imprimir.printBitmap(deviceOps.readImage("/FAC3.bmp", 0));
//                                    if(!txtBoxNota.getString().equals(""))
//                                    {
//                                        imprimir.printText("Nota:"+txtBoxNota.getString(),1);
//                                    }
                                    imprimir.printEndLine();
                                    //imprimir.printText("Fecha:"+factura.getFechaEmision()+"         Id:"+operador.getUsuario(), 1);
                                    //imprimir.printText(ConstruirFila("Fecha:"+factura.getFechaEmision(),"Id:"+operador.getId()),1);
                                    //imprimir.printTextWidthHeightZoom("Tel.No.:"+factura.getInstancia(),2, 1);
                                    
                                    
                                    
                                    
                                    
                                   
                                    //imprimir.printText(ConstruirFila(factura.getConcepto(),"Bs."+factura.getMonto()), 1);
                                    
                                    //imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    
                                    //imprimir.printText(ConstruirFila("Total Bs.:",factura.getMonto()), 1);
                                    
                                    
                                    
                                    
				} else {
					tickerLogin.setText("Bateria baja!! ");
				
				}
				break;
			case Printer.PRINTER_NO_PAPER:
                                tickerLogin.setText("Verifique el estado del papel!! ");
				break;
			case Printer.PRINTER_PAPER_ERROR:
                                tickerLogin.setText("Error de impresi髇!! ");
				break;
			}
                   
}
public void Imprimir(Infraccion_1 infraccion,Inf infcon, byte[] ImagenQr)
{
//     double monto = Double.parseDouble(factura.getAmount());
                    imprimir = Printer.getInstance();
                    switch (imprimir.getPaperStatus()) // check paper status
			{
			case Printer.PRINTER_EXIST_PAPER:
				if (imprimir.voltageCheck()) // check voltage, if it is allowed to
											// print
				{
                                    //Imprimiendo Factura
                                    DeviceOps deviceOps = DeviceOps.getInstance();
                                    imprimir.printBitmap(deviceOps.readImage("/FAC_ALE.bmp", 0));
//                                 
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));

                                    numMemo++;
//                                    imprimir.printText(ConstruirFila(" MEMORANDUM No. "+infraccion.getNumeroInfraccion()), 1);
                                   imprimir.printText(ConstruirFila(" MEMORANDUM No. "+numMemo), 1);
                                   imprimir.printText("Fecha:"+DateUtil.getCurrentDate()+" "+DateUtil.getHour()+":"+DateUtil.getMinute(), 1);

                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                 
                                    imprimir.printText("PLACA:"+infcon.getPlacaLit()+" "+infcon.getPlacaNum(), 1);
                                    imprimir.printText("VIA:"+infcon.getVia(), 1);
                                    imprimir.printText("CODIGO DE INFRACCION:"+infcon.getInf1(), 1);
                                    
                                    imprimir.printText("CODIGO DE AGRAVANTE:"+infcon.getCodGrav(), 1);
//                                    imprimir.printText("MONTO:"+infraccion.getMontoInfraccion(), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                 
                                    imprimir.printBitmap(ImagenQr);
                                    imprimir.printText("USUARIO:"+autentificacion.getNombre(),1);
//                                   
                                    imprimir.printEndLine();
                       
                                    
                                    
                                    
				} else {
					tickerLogin.setText("Bateria baja!! ");
				
				}
				break;
			case Printer.PRINTER_NO_PAPER:
                                tickerLogin.setText("Verifique el estado del papel!! ");
				break;
			case Printer.PRINTER_PAPER_ERROR:
                                tickerLogin.setText("Error de impresi髇!! ");
				break;
			}
                   
}
public void Imprimir(Inf infcon)
{
//     double monto = Double.parseDouble(factura.getAmount());
                    imprimir = Printer.getInstance();
                    switch (imprimir.getPaperStatus()) // check paper status
			{
			case Printer.PRINTER_EXIST_PAPER:
				if (imprimir.voltageCheck()) // check voltage, if it is allowed to
											// print
				{
                                    //Imprimiendo Factura
                                    DeviceOps deviceOps = DeviceOps.getInstance();
                                    imprimir.printBitmap(deviceOps.readImage("/FAC_ALE.bmp", 0));
//                                    //imprimir.printBitmap(deviceOps.readImage("/viva.bmp", 0));
                                    //Encabezado 
//                                    imprimir.printTextWidthHeightZoom(ConstruirFilaA(factura.getAccount().getName()), 2, 1);
//                                    imprimir.printText(ConstruirFila(factura.getAccount().getAddress1()), 1);
//                                    imprimir.printText(ConstruirFila(factura.getAccount().getAddress2()), 1);
//                                    imprimir.printText(ConstruirFila("SFC-001"), 1);
//                                    imprimir.printText(ConstruirFila("FACTURA"), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    //Datos de la Empresa
//                                    imprimir.printText(ConstruirFila("NIT:"+factura.getAccount().getNit()), 1);
//                                    numMemo++;
//                                    imprimir.printText(ConstruirFila(" MEMORANDUM No. "+infraccion.getNumeroInfraccion()), 1);
                                    imprimir.printText(ConstruirFila(" MEMORANDUM No. 1"),1);
//                                   imprimir.printText("Fecha:"+DateUtil.getCurrentDate()+" "+DateUtil.getHour()+":"+DateUtil.getMinute(), 1);
//                                    imprimir.printText(usuario, z);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    //Datos del cliente
//                                    if(!infraccion.getOperador().equals("")){
//                                        imprimir.printText("OPERADOR:"+infraccion.getOperador(), 1);
//                                    }
//                                    if(!infraccion.getRuta().equals("")){
//                                        imprimir.printText("RUTA:"+infraccion.getRuta(), 1);
//                                    }
                                    imprimir.printText("PLACA:"+infcon.getPlacaLit()+" "+infcon.getPlacaNum(), 1);
                                    imprimir.printText("VIA:"+infcon.getVia(), 1);
                                    imprimir.printText("CODIGO DE INFRACCION:"+infcon.getInf1(), 1);
                                    
                                    imprimir.printText("CODIGO DE AGRAVANTE:"+infcon.getCodGrav(), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
//                                    //invoice items
////                                    imprimir.printBitmap(ImagenQr);
//                                    imprimir.printText("USUARIO:"+autentificacion.getNombre(),1);

                                    

                                    imprimir.printEndLine();
                       
                                    
                                    
                                    
				} else {
					tickerLogin.setText("Bateria baja!! ");
				
				}
				break;
			case Printer.PRINTER_NO_PAPER:
                                tickerLogin.setText("Verifique el estado del papel!! ");
				break;
			case Printer.PRINTER_PAPER_ERROR:
                                tickerLogin.setText("Error de impresi髇!! ");
				break;
			}
                   
}
 public void Imprimir(Factura factura, byte[] ImagenQr)
    {
     double monto = Double.parseDouble(factura.getAmount());
                    imprimir = Printer.getInstance();
                    switch (imprimir.getPaperStatus()) // check paper status
			{
			case Printer.PRINTER_EXIST_PAPER:
				if (imprimir.voltageCheck()) // check voltage, if it is allowed to
											// print
				{
                                    //Imprimiendo Factura
                                    DeviceOps deviceOps = DeviceOps.getInstance();
                                    imprimir.printBitmap(deviceOps.readImage("/FAC1.bmp", 0));
//                                    //imprimir.printBitmap(deviceOps.readImage("/viva.bmp", 0));
                                    //Encabezado 
                                    
//                                    imprimir.printTextWidthHeightZoom(ConstruirFilaA(factura.getAccount().getName()), 2, 1);
//                                    imprimir.printText(ConstruirFila(factura.getAccount().getAddress1()), 1);
//                                    imprimir.printText(ConstruirFila(factura.getAccount().getAddress2()), 1);
//                                    imprimir.printText(ConstruirFila("SFC-001"), 1);
//                                    imprimir.printText(ConstruirFila("FACTURA"), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    //Datos de la Empresa
//                                    imprimir.printText(ConstruirFila("NIT:"+factura.getAccount().getNit()), 1);
                                    imprimir.printText(ConstruirFila("FACTURA No."+factura.getInvoiceNumber()), 1);
                                    imprimir.printText(ConstruirFila("AUTORIZACI\u00D3N No."+factura.getAccount().getNumAuto()), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    //Datos del cliente
                                    imprimir.printText("FECHA:"+factura.getInvoiceDate(), 1);
                                    imprimir.printText("NOMBRE:"+factura.getCliente().getName(), 1);
                                    imprimir.printText("NIT/CI:"+factura.getCliente().getNit(), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    //invoice items
                                    imprimir.printText(ConstruirFila("CANT.","CONCEPTO","TOTAL"), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    for(int i=0;i<listaProductos.size();i++)
                                    {   
                                       Products prod= (Products) listaProductos.elementAt(i);
                                       Tokenizer tk = new Tokenizer(Double.parseDouble(prod.getQty())+"","."); 
                                       String cantidad= tk.nextToken();
                                       String costo = ""+(Double.parseDouble(prod.getCost())*Double.parseDouble(prod.getQty()));
                                       String concepto = prod.getNotes();
                                       imprimir.printText(ConstruirFila(cantidad,concepto,costo), 1);
                                    }
//                                    for(int i =0;i<factura.getInvoiceItems().size();i++)
//                                    {
//                                        InvoiceItems invitem = (InvoiceItems) factura.getInvoiceItems().elementAt(i);
//                                        
//                                        String cantidad= tk.nextToken();
//                                        String costo = ""+(Double.parseDouble(invitem.getCost())*Double.parseDouble(invitem.getQty()));
//                                        String concepto = invitem.getNotes();
//                                        imprimir.printText(ConstruirFila(cantidad,concepto,costo), 1);
//                                    }
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                                                       
                                    imprimir.printText("MONTO TOTAL: Bs "+Double.parseDouble(factura.getAmount()),1);
                                    imprimir.printText("SON:"+NumeroLiteral(""+monto)+"Bolivianos",1);
                                    imprimir.printText("C\u00D3DIGO DE CONTROL:"+factura.getControlCode(),1);
                                    imprimir.printText("FECHA LIMITE EMISI\u00D3N:"+factura.getAccount().getFechaLimite(),1);
                                    imprimir.printBitmap(ImagenQr);
//                                    imprimir.printText("CSD:"+operador.getId()+" "+operador.getUsuario() +"-"+factura.getDatecom(), 1);
//                                    imprimir.printText("CSD:143 farbo-18:00:35", 1);
//                                    BmpArray ba = new BmpArray();
//                                    try { 
//                                        imprimir.printBitmap(ba.readImage(BMPGenerator.encodeBMP(ImagenQr)));
//                                    } catch (IOException ex) {
//                                        ex.printStackTrace();
//                                    }
//                                    imprimir.printBitmap(deviceOps.readImage("/FAC3.bmp", 0));
//                                    if(!txtBoxNota.getString().equals(""))
//                                    {
//                                        imprimir.printText("Nota:"+txtBoxNota.getString(),1);
//                                    }
                                    imprimir.printEndLine();
                                    //imprimir.printText("Fecha:"+factura.getFechaEmision()+"         Id:"+operador.getUsuario(), 1);
                                    //imprimir.printText(ConstruirFila("Fecha:"+factura.getFechaEmision(),"Id:"+operador.getId()),1);
                                    //imprimir.printTextWidthHeightZoom("Tel.No.:"+factura.getInstancia(),2, 1);
                                    
                                    
                                    
                                    
                                    
                                   
                                    //imprimir.printText(ConstruirFila(factura.getConcepto(),"Bs."+factura.getMonto()), 1);
                                    
                                    //imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    
                                    //imprimir.printText(ConstruirFila("Total Bs.:",factura.getMonto()), 1);
                                    
                                    
                                    
                                    
				} else {
					tickerLogin.setText("Bateria baja!! ");
				
				}
				break;
			case Printer.PRINTER_NO_PAPER:
                                tickerLogin.setText("Verifique el estado del papel!! ");
				break;
			case Printer.PRINTER_PAPER_ERROR:
                                tickerLogin.setText("Error de impresi髇!! ");
				break;
			}
                   
    }
    private double redondeo(double num,int numDecim){
        long p=1;
        for(int i=0; i<numDecim; i++)p*=10;
        return (double)(int)(p * num + 0.5) / p;
    }
    public String NumeroLiteral(String n)
    {
       int coma =0;
       for(int i=0;i<n.length();i++)
       {
           if(n.substring(i,i+1).equals(","))
           {
              coma=1;
           }
           if(n.substring(i,i+1).equals("."))
           {
              coma=2;
           }
       }
       int j=0;
       if(coma==0)
       {
           n=n+",00";
           coma=1;
       }
       if (coma==1)
       {
           j= n.indexOf(",");
       }
       if(coma ==2)
       {
           j = n.indexOf(".");
       }
      
       return Numero_a_Letra.readNumber(n.substring(0,j),n.substring(j+1,n.length())).toUpperCase();
      
    }
    /*
     * Parametros Cad1:  
     * Se contruye una fila con 32 caracteres y la variable Cad1 centrado
     * 
     */
    public String ConstruirFilaA(String cad1)
    {
        String fila=cad1;
        String espacio =" ";
        int size = (16-cad1.length())/2;
         for(int i=0;i<size;i++)
        {
            fila = espacio+fila ;
        }
                
        return fila;
    }
    public String ConstruirFila(String cad1)
    {
        String fila=cad1;
        String espacio =" ";
        int size = (32-cad1.length())/2;
         for(int i=0;i<size;i++)
        {
            fila = espacio+fila ;
        }
                
        return fila;
    }
    public String ConstruirFila(String cad1,int espacios)
    {
        String fila=cad1;
        String espacio =" ";
        int size = espacios-cad1.length();
         for(int i=0;i<size;i++)
        {
            fila = fila +espacio;
        }
                
        return fila;
    }
     public String ConstruirFila(String cad1,String cad2)
    {
        String fila=cad1;
        String espacio =" ";
        int size = 32- cad2.length()-cad1.length();
        for(int i=0;i<size;i++)
        {
            fila = fila +espacio;
        }
        fila = fila+cad2;
        
        return fila;
    }
     public String ConstruirFilaA(String cantidad,String concepto,String monto)
     {
         String linea="";
          String espacio =" ";
         linea = ""+cantidad+" ";
         Tokenizer tk = new Tokenizer(concepto," ");
         String con=tk.nextToken();
         int size=15-con.length();
         for(int i=0;i<size;i++)
         {
             con = con+ espacio;
         }
         linea = linea +con;
         size = 7-monto.length();
         String m=monto;
         for(int i=0;i<size;i++)
         {
             m = espacio+m;
         }
         linea = linea+m;
         size = 7-monto.length();
         String m2=monto;
         for(int i=0;i<size;i++)
         {
             m2 = espacio+ m2;
         }
         linea = linea+m2;
         return linea;
     }
     public String ConstruirFila(String cantidad,String concepto,String monto)
     {
         String linea=""+cantidad+" "+concepto;
         String espacio =" ";
                  
         int size=32-linea.length()-monto.length();
         for(int i=0;i<size;i++)
         {
             linea = linea+ espacio;
         }
         linea = linea +monto;
         
         return linea;
     }


    
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    public void exitMIDlet() {
        switchDisplayable(null, null);
        try {
            destroyApp(true);
        } catch (MIDletStateChangeException ex) {
            ex.printStackTrace();
        }
        notifyDestroyed();
    }


    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    public void pauseApp() {
        midletPaused = true;
    }
    public void destroyApp(boolean unconditional)throws MIDletStateChangeException
    {
        try {
			this.storage.save( this.vectorUsuarios, "Usuarios");
		} catch (IOException e) {
			
			System.out.println("no se pudo guardar los datos de los usuarios" + e );
		}
         try {
			this.storage.save( this.vectorColores, "Colores");
                        this.storage.save( this.vectorVehiculo, "Vehiculos");
                        this.storage.save( this.vectorZona, "Zonas");
                    } catch (IOException e) {
			
			System.out.println("no se pudo registrar las listas " + e );
                    }
    }

    public static String convertiraISO(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("ISO-8859-1"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;

        }
        return out;
    }  
    
   
    public void Cargando()
    {
        Thread tsd = new Thread(){
            public void run()
            {
                switchDisplayable(null,getFormLoading());
            }
        };
        tsd.start();
       
    }
    public void cambiarPantalla()
    {
        switch(pantalla)
        {
             case AUTENTIFICACION:
                    switchDisplayable(null,getListMenu());
                    break;
             case CONSULTA:
                    switchDisplayable(null,getListAdministrador());
                    switchDisplayable(getProblemas(),getListAdministrador());
                   
                    break;
             case CONSULTAUSUARIOS:
                   switchDisplayable(null,getListAdministrador());
                   switchDisplayable(getProblemas(),getListAdministrador());
                   break;
             case REGISTRARINFRACCION:
                    switchDisplayable(null,getListMenu());
                    break;
//             case CLIENTE:
//                    switchDisplayable(null,getFormDatosCliente());
//                    break;
//             case GUARDARFACTURA:
//                    switchDisplayable(null, getListPrincipal());
//                    break;
//             case CANTPROD:
//                    switchDisplayable(null,getListProductos());
//                    break;
//             case REGISTRARCLIENTE:
//                    switchDisplayable(null,getFormRegistro());
//                    break;
//             case PRERECARGA:
////                 getFormRecarga
//                    switchDisplayable(null,getFormRecarga());
//                    break;
//             case RECARGA:
////                 getAppMenu
//                 switchDisplayable(null,getAppMenu());
//                   break;
        }
                    
    }
    public void retornarPantalla()
    {
        switch(pantalla)
        {
            case AUTENTIFICACION:
                switchDisplayable(null,getFormLogin());
                break;
            case CONSULTA:
                    switchDisplayable(null,getListAdministrador());
                    break;   
            case CONSULTAUSUARIOS:
                    switchDisplayable(null,getListAdministrador());
                    break;    
            case REGISTRARINFRACCION:
                    switchDisplayable(null,getFormInfraccion());
                    break;
//            case CLIENTE:
//                switchDisplayable(null,getFormCliente());
//                break;    
//            case GUARDARFACTURA:
//                switchDisplayable(null, getFormFactura());
//                break;    
//            case CANTPROD:
//                switchDisplayable(null,getFormCantidad());
//                break;
//            case REGISTRARCLIENTE:
//                if(estaRegistrado)
//                {
//                    switchDisplayable(null,getListMenu());
//                }
//                else
//                {
//                    switchDisplayable(null,getFormRegistro());
//                }
//                
//                break;
//            case PRERECARGA:
//                 switchDisplayable(null,getAppMenu());
//                break;
//            case RECARGA:
//                  switchDisplayable(null,getFormPrerecarga());
//                break;
                
        }
    }   
    public String getAlertTitulo()
    { 
      switch(pantalla)
      {
          case AUTENTIFICACION:
          case CLIENTE:
          case GUARDARFACTURA:
          case VERSION:
          case PRERECARGA:
          case RECARGA:
          case REGISTRARINFRACCION:
               switch(rest.getCodigoRespuesta())
                {
                    case 401:
                        titulo= "Autentificacion Fallida";
                        break;
                    case 404:
                        titulo= "Problemas de Conectividad";
                        break;
                    case 500:
                        titulo ="Error del Servidor";
                        break;  
                    default:  mensaje="Problemas de Conectividad";
                        break;
                }
              break;
          case CANTPROD:
              titulo= "Casilla de Texto Vacia";
              break;
           case REGISTRARCLIENTE:
                    if(estaRegistrado)
                    {
                        titulo ="Registro Exitoso";
                    }
                    else
                    {
                        switch(rest.getCodigoRespuesta())
                        {
                            case 401:
                                titulo= "Verifique que el Usuario y Password sean CORRECTOS";
                                break;
                            case 404:
                                titulo= "Se perdio la coneccion con el servidor";
                                break;
                            case 500:
                                titulo= " Conflictos internos con el servidor";
                                break;

                        }
                    }
                 break;
           case CONSULTA:
           case CONSULTAUSUARIOS:
               switch(rest.getCodigoRespuesta())
                {
                    case 401:
                        titulo= "Autentificacion Fallida";
                        break;
                    case 404:
                        titulo= "Problemas de Conectividad";
                        break;
                    case 500:
                        titulo ="Error del Servidor";
                        break;  
                    case 200:
                        titulo = "Informacion Actualizada";
                        break;
                }
              break;
         
      }
       
        return this.titulo;
    }
    public String getAlertMensaje()
    {
        switch(pantalla)
        {
            case AUTENTIFICACION:
            case CLIENTE:
            case GUARDARFACTURA:
            case VERSION:
            case RECARGA:
            case REGISTRARINFRACCION:
            
                switch(rest.getCodigoRespuesta())
                {
                    case 401:
                        mensaje= "Verifique que el Usuario y Password sean CORRECTOS";
                        break;
                    case 404:
                        mensaje= "Se perdio la coneccion con el servidor";
                        break;
                    case 500:
                        mensaje="Conflictos internos con el servidor";
                        break;
                    default:  mensaje="Por favor verifique su conexion de Internet";
                        break;
                            
                }
                
                break;
            case CANTPROD:
                 mensaje="Por favor ingrese la cantidad del producto";
                 break;
            case REGISTRARCLIENTE:
                    if(estaRegistrado)
                    {
                        mensaje =" El usuario se registro CORRECTAMENTE";
                    }
                    else
                    {
                        switch(rest.getCodigoRespuesta())
                        {
                            case 401:
                                mensaje= "Verifique que el Usuario y Password sean CORRECTOS";
                                break;
                            case 404:
                                mensaje= "Se perdio la coneccion con el servidor";
                                break;
                            case 500:
                                mensaje="Conflictos internos con el servidor";
                                break;

                        }
                    }
                 break;
            case PRERECARGA:
                mensaje="Verifique si los datos son correctos";
                break;
            case CONSULTA:
            case CONSULTAUSUARIOS:
                 switch(rest.getCodigoRespuesta())
                {
                    case 401:
                        mensaje= "Verifique que el Usuario y Password sean CORRECTOS";
                        break;
                    case 404:
                        mensaje= "Se perdio la coneccion con el servidor";
                        break;
                    case 500:
                        mensaje="Conflictos internos con el servidor";
                        break;
                    case 200:
                        mensaje="Se Actualizo la informacion correctamente.";

                }
                
                break;
           
        }
        
        return this.mensaje;
    }
    public Image loadImage(String url) throws IOException {
    HttpConnection hpc = null;
    DataInputStream dis = null;
    try {
      hpc = (HttpConnection) Connector.open(url);
      int length = (int) hpc.getLength();
      byte[] data = new byte[length];
      dis = new DataInputStream(hpc.openInputStream());
      dis.readFully(data);
      return Image.createImage(data, 0, data.length);
    } finally {
      if (hpc != null)
        hpc.close();
      if (dis != null)
        dis.close();
    }
  }
    private Image encode(String content) throws IOException {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            int qrWidth = 200;
            int qrHeigth = 200;
            BitMatrix qrBitMatrix = qrCodeWriter.encode(content,BarcodeFormat.QR_CODE, qrWidth, qrHeigth);
            int[] rgb = new int[qrWidth * qrHeigth];
            
            for (int y = 0; y < qrBitMatrix.getHeight(); y++)
            {
                for (int x = 0; x < qrWidth; x++)
                {
                    int offset = y * qrHeigth;
                    rgb[offset + x] = qrBitMatrix.get(x, y) ? BACK : WHTIE;
                }
            }
            // Tambien intente usar esta forma para crear la imagen e intentar imprimir directamente el array de byte
            // Also try using this way to create the image and try to directly print the byte array
            
            return Image.createRGBImage(rgb, qrWidth, qrHeigth, false);
            // 
             
                 
           
            
        
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
     private Image ImprimirQr(Factura factura) {
         javax.microedition.lcdui.Image temp=null;
        try {
            System.out.println(" decode");
//            String datos = "4771553|Guisbert S.R.L.|0014|554574757414|12/03/2014|500|57-38-4F-ED|01/06/2014|APLP|123456798";
            String datos =factura.getAccount().getNit()+"|"+factura.getAccount().getName()+"|"+factura.getInvoiceNumber()+"|"+factura.getAccount().getNumAuto()+"|"+factura.getInvoiceDate()+"|"+factura.getControlCode()+"|"+factura.getAccount().getFechaLimite()+"|"+factura.getCliente().getName()+"|"+factura.getCliente().getNit();
            qrCodeImage = encode(datos);
            
//            Image imagen=Image.createImage("/generadorqr/f.png");
            
            
            
//            
            
            System.out.println("ancho"+qrCodeImage.getWidth());
            System.out.println("alto"+qrCodeImage.getWidth());
            temp = javax.microedition.lcdui.Image.createImage(getImage12().getWidth(),
				getImage12().getHeight());
		javax.microedition.lcdui.Graphics g = temp.getGraphics();
//                g.drawImage(getImage4(),0,0,Graphics.LEFT|Graphics.TOP);
		g.drawImage(qrCodeImage, 96, -10, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
               
		g.setColor(0x000000);
         
		javax.microedition.lcdui.Font myFont;
//		myFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN | Font.STYLE_BOLD, Font.SIZE_SMALL);// 设置字体
//		g.setFont(myFont);
//
//		g.drawString("small",0, 80, Graphics.LEFT | Graphics.TOP);
                myFont = javax.microedition.lcdui.Font.getFont(javax.microedition.lcdui.Font.FACE_SYSTEM, javax.microedition.lcdui.Font.STYLE_PLAIN | javax.microedition.lcdui.Font.STYLE_BOLD, javax.microedition.lcdui.Font.SIZE_SMALL);// 设置字体

		g.setFont(myFont);
                g.drawString("LA ALTERACI覰 FALSIFICACI覰 O ",0, 180, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
                g.drawString("COMERCIALIZACI覰 DE ESTE DOCUMENTO,",0, 195, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
                g.drawString("TIENE CARCEL.",0, 210, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
//                myFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN | Font.STYLE_BOLD, Font.SIZE_LARGE);// 设置字体
//
//		g.setFont(myFont);
//                g.drawString("large",0, 120, Graphics.LEFT | Graphics.TOP);
//                ImageItem mItem = new ImageItem(null, imagen, 0, null);
//                formPrueba.append(temp);
//                
//                Printer imprimir= Printer.getInstance();
//                BmpArray ba = new BmpArray();
//                imprimir.printBitmap(ba.readImage(BMPGenerator.encodeBMP(temp))); 
             
            //saveQRCodeImage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return temp;
    }
      private Image ImprimirQr(Inf infraccion) {
         javax.microedition.lcdui.Image temp=null;
        try {
            System.out.println(" decode");
//            String datos = "4771553|Guisbert S.R.L.|0014|554574757414|12/03/2014|500|57-38-4F-ED|01/06/2014|APLP|123456798";
//            String datos =factura.getAccount().getNit()+"|"+factura.getAccount().getName()+"|"+factura.getInvoiceNumber()+"|"+factura.getAccount().getNumAuto()+"|"+factura.getInvoiceDate()+"|"+factura.getControlCode()+"|"+factura.getAccount().getFechaLimite()+"|"+factura.getCliente().getName()+"|"+factura.getCliente().getNit();
              String datos ="|"+infraccion.getCodGrav()+"|"+infraccion.getPlacaLit()+" "+infraccion.getPlacaNum()+"|"+infraccion.getVia();
            qrCodeImage = encode(datos);
            
//            Image imagen=Image.createImage("/generadorqr/f.png");
            
            
            
//            
            
            System.out.println("ancho"+qrCodeImage.getWidth());
            System.out.println("alto"+qrCodeImage.getWidth());
            temp = javax.microedition.lcdui.Image.createImage(getImage12().getWidth(),
				getImage12().getHeight());
		javax.microedition.lcdui.Graphics g = temp.getGraphics();
//                g.drawImage(getImage4(),0,0,Graphics.LEFT|Graphics.TOP);
		g.drawImage(qrCodeImage, 96, -10, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
               
		g.setColor(0x000000);
         
		javax.microedition.lcdui.Font myFont;
//		myFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN | Font.STYLE_BOLD, Font.SIZE_SMALL);// 设置字体
//		g.setFont(myFont);
//
//		g.drawString("small",0, 80, Graphics.LEFT | Graphics.TOP);
                myFont = javax.microedition.lcdui.Font.getFont(javax.microedition.lcdui.Font.FACE_SYSTEM, javax.microedition.lcdui.Font.STYLE_PLAIN | javax.microedition.lcdui.Font.STYLE_BOLD, javax.microedition.lcdui.Font.SIZE_SMALL);// 设置字体

		g.setFont(myFont);
//                g.drawString("LA PAZ LIBRE ",0, 180, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
//                g.drawString("COMERCIALIZACI覰 DE ESTE DOCUMENTO,",0, 195, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
//                g.drawString("TIENE CARCEL.",0, 210, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
//                myFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN | Font.STYLE_BOLD, Font.SIZE_LARGE);// 设置字体
//
//		g.setFont(myFont);
//                g.drawString("large",0, 120, Graphics.LEFT | Graphics.TOP);
//                ImageItem mItem = new ImageItem(null, imagen, 0, null);
//                formPrueba.append(temp);
//                
//                Printer imprimir= Printer.getInstance();
//                BmpArray ba = new BmpArray();
//                imprimir.printBitmap(ba.readImage(BMPGenerator.encodeBMP(temp))); 
             
            //saveQRCodeImage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return temp;
    }
     
     private void ImprimirQr(String datos) {
        try {
            System.out.println(" decode");
//            String datos = "4771553|Guisbert S.R.L.|0014|554574757414|12/03/2014|500|57-38-4F-ED|01/06/2014|APLP|123456798";
//            String datos =factura.getAccount().getNit()+"|"+factura.getAccount().getName()+"|"+factura.getInvoiceNumber()+"|"+factura.getAccount().getNumAuto()+"|"+factura.getInvoiceDate()+"|"+factura.getControlCode()+"|"+factura.getAccount().getFechaLimite()+"|"+factura.getCliente().getName()+"|"+factura.getCliente().getNit();
            qrCodeImage = encode(datos);
            
//            Image imagen=Image.createImage("/generadorqr/f.png");
            
            
            BmpArray ba = new BmpArray();
//            
            
            System.out.println("ancho"+qrCodeImage.getWidth());
            System.out.println("alto"+qrCodeImage.getWidth());
            javax.microedition.lcdui.Image temp = javax.microedition.lcdui.Image.createImage(getImage12().getWidth(),
				getImage12().getHeight());
		javax.microedition.lcdui.Graphics g = temp.getGraphics();
//                g.drawImage(getImage4(),0,0,Graphics.LEFT|Graphics.TOP);
		g.drawImage(qrCodeImage, 96, -10, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
               
		g.setColor(0x000000);
         
		javax.microedition.lcdui.Font myFont;
//		myFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN | Font.STYLE_BOLD, Font.SIZE_SMALL);// 设置字体
//		g.setFont(myFont);
//
//		g.drawString("small",0, 80, Graphics.LEFT | Graphics.TOP);
                myFont = javax.microedition.lcdui.Font.getFont(javax.microedition.lcdui.Font.FACE_SYSTEM, javax.microedition.lcdui.Font.STYLE_PLAIN | javax.microedition.lcdui.Font.STYLE_BOLD, javax.microedition.lcdui.Font.SIZE_SMALL);// 设置字体

		g.setFont(myFont);
                g.drawString("LA ALTERACI覰 FALSIFICACI覰 O ",0, 180, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
                g.drawString("COMERCIALIZACI覰 DE ESTE DOCUMENTO,",0, 195, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
                g.drawString("TIENE CARCEL.",0, 210, javax.microedition.lcdui.Graphics.LEFT | javax.microedition.lcdui.Graphics.TOP);
//                myFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN | Font.STYLE_BOLD, Font.SIZE_LARGE);// 设置字体
//
//		g.setFont(myFont);
//                g.drawString("large",0, 120, Graphics.LEFT | Graphics.TOP);
//                ImageItem mItem = new ImageItem(null, imagen, 0, null);
//                formPrueba.append(temp);
                
                Printer imprimir= Printer.getInstance();
                
                imprimir.printBitmap(ba.readImage(BMPGenerator.encodeBMP(temp))); 
             
            //saveQRCodeImage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
//    public void NuevaFactura()
//    {
//        listaProductos.removeAllElements();
//        listLugar.deleteAll();
//        cliente = null;
//        factura =null;
//        
//       
//    }
     public void openRecStore(){
    try{
      rs = RecordStore.openRecordStore(REC_STORE, true );
    }catch (Exception e){}
  }    

  public void closeRecStore(){
    try{
      rs.closeRecordStore();
    }catch (Exception e){}
  }

  public void deleteRecStore(){
    if (RecordStore.listRecordStores() != null){
      try{
        RecordStore.deleteRecordStore(REC_STORE);
      }catch (Exception e){}
    }      
  }

  public void writeRecord(String str){
    byte[] rec = str.getBytes();
    try{
      rs.addRecord(rec, 0, rec.length);
    }catch (Exception e){}
  }

  public void readRecords(){
    try{
      byte[] recData = new byte[5]; 
      int len;
      
      for(int i = 1; i <= rs.getNumRecords(); i++){
        if(rs.getRecordSize(i) > recData.length){
          recData = new byte[rs.getRecordSize(i)];
        }
        len = rs.getRecord(i, recData, 0);
        
        txt3.setText("Record " + i + " : " + new String(recData, 0, len));
                              
      }
    }catch (Exception e){}
  }
   public FilteredList getFiltro() {
        if (filtro == null) {
                                     
            // write pre-init user codeasdas here
            filtro = new FilteredList("Nombre de la Via:",Choice.IMPLICIT); 
//            lista = new List("list", Choice.IMPLICIT);                                        
            filtro.addCommand(getOkFiltro());
//            filtro.addCommand(getBackCommand());
            filtro.setCommandListener(this);
             

            
            for(int i=0;i<15;i++)
            {
                
                filtro.append("via"+i,null);
            }
//            for(int i=0;i<cuenta.getProductos().size();i++)
//            {
//                Products prod = (Products) cuenta.getProductos().elementAt(i);
//                lista.append(prod.getNotes(), null);
//                lista.setTitle("Lista de Productos");
//            }
        }                           
        return filtro;
    }
   public FilteredList getZona() {
        if (zona == null) {
                                     
            // write pre-init user codeasdas here
            zona = new FilteredList("Zona:",Choice.IMPLICIT); 
//            lista = new List("list", Choice.IMPLICIT);                                        
            zona.addCommand(getOkZona());
//            filtro.addCommand(getBackCommand());
            zona.setCommandListener(this);
             
            for(int i=0;i<vectorZona.size();i++)
            {
                Zona z =(Zona) vectorZona.elementAt(i);
                zona.append(z.getZondes(),null);
            }
            //Cargando datos de la base de datos
//            for(int i=0;i<15;i++)
//            {
//                
//                zona.append("zona"+i,null);
//            }
//            for(int i=0;i<cuenta.getProductos().size();i++)
//            {
//                Products prod = (Products) cuenta.getProductos().elementAt(i);
//                lista.append(prod.getNotes(), null);
//                lista.setTitle("Lista de Productos");
//            }
        }                           
        return zona;
    }
   public FilteredList getVehiculos()
   {
       if(vehiculos==null)
       {
           vehiculos = new FilteredList("Vehiculos:",Choice.IMPLICIT);
           vehiculos.addCommand(getOkVehiculo());
          vehiculos.setCommandListener(this);
          for( int i=0 ;i<vectorVehiculo.size();i++)
          {
              Vehiculo v =(Vehiculo) vectorVehiculo.elementAt(i);
              vehiculos.append(v.getDesvehiculo(),null);
          }
       }
       return vehiculos;
   }
     public Command getOkVehiculo() {
        if (okVehiculo == null) {
                                     
            // write pre-init user code here
           okVehiculo = new Command("Seleccionar", Command.OK, 0);                                       
            // write post-init user code here
           }                           
        return okVehiculo;
    }
    public void Buscar(String text,Vector lista,int tipo)
    {
        switch(tipo)
        {
            case 0: for(int i=0;i<lista.size();i++)
                    {
                        Vehiculo vec = (Vehiculo) lista.elementAt(i);
                        if(text.equals(vec.getDesvehiculo()))
                        {
                            i=lista.size();
                            infcon.setVehiculo(vec.getCodvehiculo());
                        }
                        
                    }
                    break;
            case 1: 
                    for(int i=0;i<lista.size();i++)
                    {
                        Colores col = (Colores) lista.elementAt(i);
//                         vec = (Vehiculo) lista.elementAt(i);
                        if(text.equals(col.getColdes()))
                        {
                            i=lista.size();
//                            infcon.setVehiculo(vec.getCodvehiculo());
                            infcon.setCodColor(col.getCodcol());
                        }
                        
                    }
                    break;
            case 2: for(int i=0;i<lista.size();i++)
                    {
//                        Vehiculo vec = (Vehiculo) lista.elementAt(i);
                        Zona zon = (Zona) lista.elementAt(i);
                        if(text.equals(zon.getZondes()))
                        {
                            i=lista.size();
                            infcon.setCodZon(zon.getZoncod());
                        }
                        
                    }
                    break;
                    
        }
    }
    public void Limpiar()
    {
        textField.setText("");
        textField1.setText("");
        textField11.setText("");
        textField12.setText("");
        textField13.setText("");
        textField8.setText("");
        textField6.setText("");
        textField7.setText("");
        textField5.setText("");
        textField2.setText("");
        textField4.setText("");
        textField3.setText("");
        listVehiculo.set(0, "Tipo de Vehiculo:", null);
        listVehiculo.set(1, "Color:", null);
        listVehiculo.set(0, "Zona:", null);

        
        
        
    }
   
}
