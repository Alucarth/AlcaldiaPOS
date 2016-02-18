 package com.mobiwire.startup;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.ipx.http.ConexionIpx;
import com.ipx.http.Rest;
import com.ipx.json.Autentificacion;
import com.ipx.json.Factura;
import com.ipx.json.Inf;
import com.ipx.json.InvoiceItems;
import com.ipx.json.Products;
import com.ipx.util.BmpArray;
import com.ipx.util.DateUtil;
import com.ipx.util.Log;
import com.ipx.util.Numero_a_Letra;
import com.ipx.util.Tokenizer;
import com.mobiwire.print.DeviceOps;
import com.nbbse.printer.Printer;
import com.sagereal.utils.BMPGenerator;
import david.torrez.salinas.Boleta;
import david.torrez.salinas.Infraccion;
import david.torrez.salinas.Infractor;
import david.torrez.salinas.Usuario;

import de.enough.polish.ui.*;
//import de.enough.polish.ui.TableItem;
import de.enough.polish.ui.SplashScreen;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import net.sf.microlog.core.Logger;
import net.sf.microlog.core.LoggerFactory;
import net.sf.microlog.core.PropertyConfigurator;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;
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
    
    
    
    private boolean midletPaused = false;
    //variables de comunicacion
       
 
    //datos Cuenta
   
    private Printer imprimir;
    private Vector listaProductos;
    
   
   //variable de envio Rest
 
    private ConexionIpx conexion;
  
  
  

    private int pantalla;
    private Rest rest;
    private String mensaje;
    private String titulo;
    private boolean estaRegistrado=false;
    
    private Image qrCodeImage;
   
    private static final int BACK = 0xFF000000;
    private static final int WHTIE = 0xFFFFFFFF;
    //variable para el filtro
    
    private Command okZona;
//    private Infraccion infraccion;
    private Autentificacion autentificacion;

    
    
    private Vector vectorVehiculo,vectorZona,vectorColores,vectorUsuarios;
//    private final Vector vectorUsuarios;
    private Command okVehiculo,backVehiculo;
    private ChoiceGroup group;
    private final int vV=0,vC=1,vZ=2;

    public Usuario usuario;
    public Vector listaInfracciones;
    
    public Infractor infractor;

//    private Thread t;
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command okLogin;
    private Command okCommand28;
    private Command exitCommand;
    private Command stopCommand;
    private Command okBorrar;
    private Command backCommand3;
    private Command cancelCommand;
    private Command okCommand4;
    private Command backCommand1;
    private Command screenCommand;
    private Command okCommand1;
    private Command backCommand2;
    private Command okAdicionar;
    private Command back;
    private Command okCommand3;
    private Command backCommand4;
    private Command okCommand5;
    private Command backInfraccion;
    private Command okCommand2;
    private Command okMenu;
    private Command exitCommand1;
    private Command okCommand;
    private Command backCommand;
    private SplashScreen splashScreen;
    private Form formLogin;
    private TextField textField9;
    private TextField textField10;
    private List list;
    private Form formLoading;
    private List listSeleccionados;
    private List listPrincipal;
    private Form form;
    private List listMenu;
    private Form formInfractor;
    private TextField txtRuta;
    private TextField txtPlaca;
    private TextField txtTipo;
    private TextField txtCI;
    private Alert Problemas;
    private Image image;
    private Ticker ticker;
    private SimpleCancellableTask task1;
    private Image image9;
    private SimpleCancellableTask task;
    private Image image8;
    private Image image16;
    private Image image17;
    private Image image18;
    private Image image13;
    private Image image14;
    private Image image15;
    private Image image2;
    private Image image11;
    private Ticker tickerLogin;
    private Image image12;
    private Image image1;
    private SimpleCancellableTask task2;
    private Image image4;
    private Image image3;
    private Image image10;
    private Ticker ticker1;
    private Image image5;
    private Font font;
    private Image image6;
    private Image image7;
//</editor-fold>//GEN-END:|fields|0|

    //SMS ENVIO
    /*
     * The StartApp constructor.
     */
    public StartApp() {
        // configuration for the logger
        PropertyConfigurator.configure();
         // restore notes from record store:
		
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
            Alert.setCurrent( display, alert, nextDisplayable );
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

        if (displayable == formInfractor) {//GEN-BEGIN:|7-commandAction|1|1465-preAction
            if (command == okCommand) {//GEN-END:|7-commandAction|1|1465-preAction
 // write pre-action user code here
    
                switchDisplayable(null, getListMenu());//GEN-LINE:|7-commandAction|2|1465-postAction
 // write post-action user code here
    infractor = new Infractor();
    infractor.setCi(getTxtCI().getText());
    infractor.setPlaca(getTxtPlaca().getText());
    infractor.setRuta(getTxtRuta().getText());
    infractor.setTipo(getTxtTipo().getText());
    
            } else if (command == okCommand3) {//GEN-LINE:|7-commandAction|3|1523-preAction
 // write pre-action user code here
switchDisplayable(null, getListMenu());//GEN-LINE:|7-commandAction|4|1523-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|5|1461-preAction
        } else if (displayable == formLogin) {
            if (command == exitCommand1) {//GEN-END:|7-commandAction|5|1461-preAction
 // write pre-action user code here
exitMIDlet();//GEN-LINE:|7-commandAction|6|1461-postAction
 // write post-action user code here
} else if (command == okCommand28) {//GEN-LINE:|7-commandAction|7|1400-preAction
 // write pre-action user code here
methodLogin();//GEN-LINE:|7-commandAction|8|1400-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|9|1493-preAction
        } else if (displayable == list) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|9|1493-preAction
 // write pre-action user code here
listAction();//GEN-LINE:|7-commandAction|10|1493-postAction
 // write post-action user code here
} else if (command == backCommand3) {//GEN-LINE:|7-commandAction|11|1503-preAction
 // write pre-action user code here
switchDisplayable(null, getListSeleccionados());//GEN-LINE:|7-commandAction|12|1503-postAction
 // write post-action user code here
} else if (command == okCommand4) {//GEN-LINE:|7-commandAction|13|1497-preAction
 // write pre-action user code here
    
    
                switchDisplayable(null, getListSeleccionados());//GEN-LINE:|7-commandAction|14|1497-postAction
 // write post-action user code here
//adicionando infracciones a la lista de infracciones
    Infraccion infraccion =(Infraccion) usuario.getInfracciones().elementAt(getList().getSelectedIndex());
    getListaInfracciones().addElement(infraccion);
    getListSeleccionados().append(infraccion.getCodigo(),null);
            }//GEN-BEGIN:|7-commandAction|15|1155-preAction
        } else if (displayable == listMenu) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|15|1155-preAction
                // write pre-action user code here
listMenuAction();//GEN-LINE:|7-commandAction|16|1155-postAction
                // write post-action user code here
} else if (command == backInfraccion) {//GEN-LINE:|7-commandAction|17|1520-preAction
 // write pre-action user code here
methodInfraccion();//GEN-LINE:|7-commandAction|18|1520-postAction
 // write post-action user code here
} else if (command == okMenu) {//GEN-LINE:|7-commandAction|19|1161-preAction
                // write pre-action user code here
listMenuAction();//GEN-LINE:|7-commandAction|20|1161-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|21|1526-preAction
        } else if (displayable == listPrincipal) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|21|1526-preAction
 // write pre-action user code here
listPrincipalAction();//GEN-LINE:|7-commandAction|22|1526-postAction
 // write post-action user code here
} else if (command == backCommand4) {//GEN-LINE:|7-commandAction|23|1534-preAction
 // write pre-action user code here
switchDisplayable(null, getFormLogin());//GEN-LINE:|7-commandAction|24|1534-postAction
 // write post-action user code here
} else if (command == okCommand5) {//GEN-LINE:|7-commandAction|25|1530-preAction
 // write pre-action user code here
listPrincipalAction();//GEN-LINE:|7-commandAction|26|1530-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|27|1483-preAction
        } else if (displayable == listSeleccionados) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|27|1483-preAction
 // write pre-action user code here
listSeleccionadosAction();//GEN-LINE:|7-commandAction|28|1483-postAction
 // write post-action user code here
} else if (command == backCommand2) {//GEN-LINE:|7-commandAction|29|1488-preAction
 // write pre-action user code here
switchDisplayable(null, getListMenu());//GEN-LINE:|7-commandAction|30|1488-postAction
 // write post-action user code here
} else if (command == okAdicionar) {//GEN-LINE:|7-commandAction|31|1486-preAction
 // write pre-action user code here
switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|32|1486-postAction
 // write post-action user code here
} else if (command == okBorrar) {//GEN-LINE:|7-commandAction|33|1490-preAction
 // write pre-action user code here
    getListaInfracciones().removeElementAt(getListSeleccionados().getSelectedIndex());
    getListSeleccionados().delete(getListSeleccionados().getSelectedIndex());
//GEN-LINE:|7-commandAction|34|1490-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|35|24-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|35|24-preAction
                // write pre-action user code here
switchDisplayable(null, getFormLogin());//GEN-LINE:|7-commandAction|36|24-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|37|7-postCommandAction
        }//GEN-END:|7-commandAction|37|7-postCommandAction
       
        
// write post-action user code here
}//GEN-BEGIN:|7-commandAction|38|
//</editor-fold>//GEN-END:|7-commandAction|38|













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
    public Ticker getPolishTicker() {
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
            
            listMenu = new List("Menu", Choice.IMPLICIT);//GEN-BEGIN:|1154-getter|1|1154-postInit
            listMenu.append(" Datos del Infractor", getImage17());
            listMenu.append(" Infracciones", getImage18());
            listMenu.addCommand(getOkMenu());
            listMenu.addCommand(getBackInfraccion());
            listMenu.setCommandListener(this);
            listMenu.setSelectedFlags(new boolean[]{false, false});//GEN-END:|1154-getter|1|1154-postInit
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
            if (__selectedString.equals(" Datos del Infractor")) {//GEN-END:|1154-action|1|1158-preAction
                // write pre-action user code here
switchDisplayable(null, getFormInfractor());//GEN-LINE:|1154-action|2|1158-postAction
                // write post-action user code here
                  
//                  infraccion = new Infraccion();
//                  infraccion.setNombreagente(textField9.getString());
               
                  Limpiar();
            } else if (__selectedString.equals(" Infracciones")) {//GEN-LINE:|1154-action|3|1159-preAction
                // write pre-action user code here
switchDisplayable(null, getListSeleccionados());//GEN-LINE:|1154-action|4|1159-postAction
                // wr
                
            }//GEN-BEGIN:|1154-action|5|1154-postAction
        }//GEN-END:|1154-action|5|1154-postAction
        // enter post-action user code here
}//GEN-BEGIN:|1154-action|6|
//</editor-fold>//GEN-END:|1154-action|6|




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

            Problemas = new Alert(getAlertTitulo(),getAlertMensaje(),getImage11(),AlertType.CONFIRMATION, de.enough.polish.ui.StyleSheet.mailalertStyle );
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
formLoading = new Form("Enviando Solicitud", de.enough.polish.ui.StyleSheet.mailalertStyle );
            // write post-init user code here
            //#style .busyIndicator
            Gauge busyIndicator = new Gauge( null, false,Gauge.INDEFINITE, Gauge.CONTINUOUS_RUNNING , de.enough.polish.ui.StyleSheet.busyindicatorStyle );
            formLoading.append(busyIndicator);
        }//GEN-BEGIN:|1239-getter|2|
        return formLoading;
    }
//</editor-fold>//GEN-END:|1239-getter|2|


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

    public Command getOkZona()
    {
        if(okZona == null )
        {
            //nota el valor 0 es la pocision del submenu de botones utilizados en la parte de la isquina inferio<
            okZona = new Command("Aceptar",Command.OK,0);
        }
        return okZona;
    }
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
            formLogin.addCommand(getExitCommand1());
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
textField10 = new TextField("Contrase\u00F1a:", null, 32, TextField.NUMERIC | TextField.PASSWORD);//GEN-LINE:|1398-getter|1|1398-postInit
 // write post-init user code here
}//GEN-BEGIN:|1398-getter|2|
        return textField10;
    }
//</editor-fold>//GEN-END:|1398-getter|2|



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
        
        usuario = new Usuario();
        usuario.setUsuario(getTextField9().getString());
        usuario.setPassword(getTextField10().getString());
//        usuario.setUsuario("oscar.conde");
//        usuario.setPassword("123");
        
        Cargando();
        if(conexion!=null)
        {
            conexion =null;
        }
     
        conexion = new ConexionIpx();
      
       
        Thread t = new Thread()
        {
            public void run()
            {
                   
                Log.i("Login "," thred consumidor activo");
                if(conexion.getCodigoRespuesta()==200)
                {
                   String p = usuario.getPassword();
                   usuario =null;
                   usuario = Usuario.fromJson(conexion.getRespuesta());
                   usuario.setPassword(p);
                   
                   cambiarPantalla();
                   
                   Log.i("metho Login", "infracciones total "+usuario.getInfracciones().size());
                   
                   //guardando usuario 
                   
                 
                   
                   
                    
                    //guardando sucursal
                   
                    
                  
                    
                }
                else
                {   
                    //Repinta la pantalla antes de que esta esetes
                    switchDisplayable(null, getFormLogin());
                    switchDisplayable(getProblemas(), getFormLogin());
                }   
//                conexion = null;
            
            }
      
        };       
        Log.i("llave de usuario", usuario.getUsuario()+" "+usuario.getPassword());
        conexion.EnviarPost(ConexionIpx.AUTENTIFICAZION, usuario.toJson(), null, t);
        conexion.start();
        
         
/*        
switchDisplayable (null, getListPrincipal ());//GEN-BEGIN:|1409-entry|1|1410-postAction
//GEN-END:|1409-entry|1|1410-postAction
 */
// write post-action user code here
}//GEN-BEGIN:|1409-entry|2|
//</editor-fold>//GEN-END:|1409-entry|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: methodInfraccion ">//GEN-BEGIN:|1427-entry|0|1428-preAction
    /**
     * Performs an action assigned to the methodInfraccion entry-point.
     */
    public void methodInfraccion() {
//GEN-END:|1427-entry|0|1428-preAction
 // write pre-action user code here
        
        pantalla = REGISTRARINFRACCION;
        
//        Cargando();
        
        if(infractor!=null && getListaInfracciones().size()>0)
        {
            JSONObject json = new JSONObject();
            try {
                json.put("placa", infractor.getPlaca());
                json.put("ruta", infractor.getRuta());
                json.put("ci", infractor.getCi());
                json.put("tipo", infractor.getTipo());
                json.put("idusuario", usuario.getId());
                
                JSONArray array = new JSONArray();
                for(int i=0;i<getListaInfracciones().size();i++)
                {
                    Infraccion inf = (Infraccion) getListaInfracciones().elementAt(i);
                    JSONObject j = new JSONObject();
                    j.put("inf_codigo", inf.getCodigo());
                    j.put("agravante", "0");
                    array.put(j);
                }
                json.put("infracciones", array);
                Log.i("resgistro servidor", json.toString());
                
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
            
            Cargando();
            
            if(conexion!=null)
            {
                conexion =null;
            }

            conexion = new ConexionIpx();


            Thread t = new Thread()
            {
                public void run()
                {

                    Log.i("Infraccion "," thred consumidor activo");
                    if(conexion.getCodigoRespuesta()==200)
                    {
                        Boleta boleta = Boleta.fromJson(conexion.getRespuesta());
                       Log.i("respuesta del servidor", conexion.getRespuesta());
                       cambiarPantalla();

                       Log.i("metho Infraccion", "infracciones total "+usuario.getInfracciones().size());

                       Imprimir(boleta);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                       Imprimir(boleta);
                        //guardando sucursal
                       



                    }
                    else
                    {   
                        //Repinta la pantalla antes de que esta esetes
                        switchDisplayable(null, getListMenu());
                        switchDisplayable(getProblemas(), getListMenu());
                    }   
    //                conexion = null;

                }

            };       
            Log.i("llave de usuario", usuario.getUsuario()+" "+usuario.getPassword());
            conexion.EnviarPost(ConexionIpx.REGISTRAR_INFRACCION, json.toString(), null, t);
            conexion.start();
            
            
        }
        
       
        /*
//GEN-LINE:|1427-entry|1|1428-postAction
        */
        
        // write post-action user code here
}//GEN-BEGIN:|1427-entry|2|
//</editor-fold>//GEN-END:|1427-entry|2|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|1460-getter|0|1460-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {
//GEN-END:|1460-getter|0|1460-preInit
 // write pre-init user code here
exitCommand1 = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|1460-getter|1|1460-postInit
 // write post-init user code here
}//GEN-BEGIN:|1460-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|1460-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|1464-getter|0|1464-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|1464-getter|0|1464-preInit
 // write pre-init user code here
okCommand = new Command("ok", Command.OK, 0);//GEN-LINE:|1464-getter|1|1464-postInit
 // write post-init user code here
}//GEN-BEGIN:|1464-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|1464-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|1466-getter|0|1466-preInit
    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {
//GEN-END:|1466-getter|0|1466-preInit
 // write pre-init user code here
backCommand = new Command("Cerrar Sesion", Command.BACK, 0);//GEN-LINE:|1466-getter|1|1466-postInit
 // write post-init user code here
}//GEN-BEGIN:|1466-getter|2|
        return backCommand;
    }
//</editor-fold>//GEN-END:|1466-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: formInfractor ">//GEN-BEGIN:|1463-getter|0|1463-preInit
    /**
     * Returns an initialized instance of formInfractor component.
     *
     * @return the initialized component instance
     */
    public Form getFormInfractor() {
        if (formInfractor == null) {
//GEN-END:|1463-getter|0|1463-preInit
 // write pre-init user code here
formInfractor = new Form("Datos del Infractor", new Item[]{getTxtPlaca(), getTxtRuta(), getTxtCI(), getTxtTipo()});//GEN-BEGIN:|1463-getter|1|1463-postInit
            formInfractor.addCommand(getOkCommand());
            formInfractor.addCommand(getOkCommand3());
            formInfractor.setCommandListener(this);//GEN-END:|1463-getter|1|1463-postInit
 // write post-init user code here
}//GEN-BEGIN:|1463-getter|2|
        return formInfractor;
    }
//</editor-fold>//GEN-END:|1463-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|1472-getter|0|1472-preInit
    /**
     * Returns an initialized instance of okCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {
//GEN-END:|1472-getter|0|1472-preInit
 // write pre-init user code here
okCommand1 = new Command("Nueva Infraccion", Command.OK, 0);//GEN-LINE:|1472-getter|1|1472-postInit
 // write post-init user code here
}//GEN-BEGIN:|1472-getter|2|
        return okCommand1;
    }
//</editor-fold>//GEN-END:|1472-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|1474-getter|0|1474-preInit
    /**
     * Returns an initialized instance of backCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {
//GEN-END:|1474-getter|0|1474-preInit
 // write pre-init user code here
backCommand1 = new Command("Cerrar Sesion", Command.BACK, 0);//GEN-LINE:|1474-getter|1|1474-postInit
 // write post-init user code here
}//GEN-BEGIN:|1474-getter|2|
        return backCommand1;
    }
//</editor-fold>//GEN-END:|1474-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtPlaca ">//GEN-BEGIN:|1478-getter|0|1478-preInit
    /**
     * Returns an initialized instance of txtPlaca component.
     *
     * @return the initialized component instance
     */
    public TextField getTxtPlaca() {
        if (txtPlaca == null) {
//GEN-END:|1478-getter|0|1478-preInit
 // write pre-init user code here
txtPlaca = new TextField("Placa:", null, 32, TextField.ANY);//GEN-LINE:|1478-getter|1|1478-postInit
 // write post-init user code here
}//GEN-BEGIN:|1478-getter|2|
        return txtPlaca;
    }
//</editor-fold>//GEN-END:|1478-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtRuta ">//GEN-BEGIN:|1479-getter|0|1479-preInit
    /**
     * Returns an initialized instance of txtRuta component.
     *
     * @return the initialized component instance
     */
    public TextField getTxtRuta() {
        if (txtRuta == null) {
//GEN-END:|1479-getter|0|1479-preInit
 // write pre-init user code here
txtRuta = new TextField("Ruta:", null, 32, TextField.NUMERIC);//GEN-LINE:|1479-getter|1|1479-postInit
 // write post-init user code here
}//GEN-BEGIN:|1479-getter|2|
        return txtRuta;
    }
//</editor-fold>//GEN-END:|1479-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtCI ">//GEN-BEGIN:|1480-getter|0|1480-preInit
    /**
     * Returns an initialized instance of txtCI component.
     *
     * @return the initialized component instance
     */
    public TextField getTxtCI() {
        if (txtCI == null) {
//GEN-END:|1480-getter|0|1480-preInit
 // write pre-init user code here
txtCI = new TextField("CI:", null, 32, TextField.NUMERIC);//GEN-LINE:|1480-getter|1|1480-postInit
 // write post-init user code here
}//GEN-BEGIN:|1480-getter|2|
        return txtCI;
    }
//</editor-fold>//GEN-END:|1480-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtTipo ">//GEN-BEGIN:|1481-getter|0|1481-preInit
    /**
     * Returns an initialized instance of txtTipo component.
     *
     * @return the initialized component instance
     */
    public TextField getTxtTipo() {
        if (txtTipo == null) {
//GEN-END:|1481-getter|0|1481-preInit
 // write pre-init user code here
txtTipo = new TextField("Tipo:", null, 32, TextField.ANY);//GEN-LINE:|1481-getter|1|1481-postInit
 // write post-init user code here
}//GEN-BEGIN:|1481-getter|2|
        return txtTipo;
    }
//</editor-fold>//GEN-END:|1481-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okAdicionar ">//GEN-BEGIN:|1485-getter|0|1485-preInit
    /**
     * Returns an initialized instance of okAdicionar component.
     *
     * @return the initialized component instance
     */
    public Command getOkAdicionar() {
        if (okAdicionar == null) {
//GEN-END:|1485-getter|0|1485-preInit
 // write pre-init user code here
okAdicionar = new Command("Adicionar Infraccion", Command.OK, 0);//GEN-LINE:|1485-getter|1|1485-postInit
 // write post-init user code here
}//GEN-BEGIN:|1485-getter|2|
        return okAdicionar;
    }
//</editor-fold>//GEN-END:|1485-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|1487-getter|0|1487-preInit
    /**
     * Returns an initialized instance of backCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand2() {
        if (backCommand2 == null) {
//GEN-END:|1487-getter|0|1487-preInit
 // write pre-init user code here
backCommand2 = new Command("Atras", Command.BACK, 0);//GEN-LINE:|1487-getter|1|1487-postInit
 // write post-init user code here
}//GEN-BEGIN:|1487-getter|2|
        return backCommand2;
    }
//</editor-fold>//GEN-END:|1487-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okBorrar ">//GEN-BEGIN:|1489-getter|0|1489-preInit
    /**
     * Returns an initialized instance of okBorrar component.
     *
     * @return the initialized component instance
     */
    public Command getOkBorrar() {
        if (okBorrar == null) {
//GEN-END:|1489-getter|0|1489-preInit
 // write pre-init user code here
okBorrar = new Command("Borra Infraccion", Command.OK, 0);//GEN-LINE:|1489-getter|1|1489-postInit
 // write post-init user code here
}//GEN-BEGIN:|1489-getter|2|
        return okBorrar;
    }
//</editor-fold>//GEN-END:|1489-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand4 ">//GEN-BEGIN:|1496-getter|0|1496-preInit
    /**
     * Returns an initialized instance of okCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand4() {
        if (okCommand4 == null) {
//GEN-END:|1496-getter|0|1496-preInit
 // write pre-init user code here
okCommand4 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1496-getter|1|1496-postInit
 // write post-init user code here
}//GEN-BEGIN:|1496-getter|2|
        return okCommand4;
    }
//</editor-fold>//GEN-END:|1496-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|1500-getter|0|1500-preInit
    /**
     * Returns an initialized instance of cancelCommand component.
     *
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {
//GEN-END:|1500-getter|0|1500-preInit
 // write pre-init user code here
cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|1500-getter|1|1500-postInit
 // write post-init user code here
}//GEN-BEGIN:|1500-getter|2|
        return cancelCommand;
    }
//</editor-fold>//GEN-END:|1500-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand3 ">//GEN-BEGIN:|1502-getter|0|1502-preInit
    /**
     * Returns an initialized instance of backCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand3() {
        if (backCommand3 == null) {
//GEN-END:|1502-getter|0|1502-preInit
 // write pre-init user code here
backCommand3 = new Command("Atras", Command.BACK, 0);//GEN-LINE:|1502-getter|1|1502-postInit
 // write post-init user code here
}//GEN-BEGIN:|1502-getter|2|
        return backCommand3;
    }
//</editor-fold>//GEN-END:|1502-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: listSeleccionados ">//GEN-BEGIN:|1482-getter|0|1482-preInit
    /**
     * Returns an initialized instance of listSeleccionados component.
     *
     * @return the initialized component instance
     */
    public List getListSeleccionados() {
        if (listSeleccionados == null) {
//GEN-END:|1482-getter|0|1482-preInit
 // write pre-init user code here
listSeleccionados = new List("Infracciones Seleccionadas", Choice.IMPLICIT);//GEN-BEGIN:|1482-getter|1|1482-postInit
            listSeleccionados.addCommand(getOkAdicionar());
            listSeleccionados.addCommand(getOkBorrar());
            listSeleccionados.addCommand(getBackCommand2());
            listSeleccionados.setCommandListener(this);//GEN-END:|1482-getter|1|1482-postInit
 // write post-init user code here
}//GEN-BEGIN:|1482-getter|2|
        return listSeleccionados;
    }
//</editor-fold>//GEN-END:|1482-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listSeleccionadosAction ">//GEN-BEGIN:|1482-action|0|1482-preAction
    /**
     * Performs an action assigned to the selected list element in the
     * listSeleccionados component.
     */
    public void listSeleccionadosAction() {
//GEN-END:|1482-action|0|1482-preAction
 // enter pre-action user code here
String __selectedString = getListSeleccionados().getString(getListSeleccionados().getSelectedIndex());//GEN-LINE:|1482-action|1|1482-postAction
 // enter post-action user code here
}//GEN-BEGIN:|1482-action|2|
//</editor-fold>//GEN-END:|1482-action|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|1492-getter|0|1492-preInit
    /**
     * Returns an initialized instance of list component.
     *
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {
//GEN-END:|1492-getter|0|1492-preInit
 // write pre-init user code here
list = new List("Lista de Infracciones", Choice.IMPLICIT);//GEN-BEGIN:|1492-getter|1|1492-postInit
            list.addCommand(getOkCommand4());
            list.addCommand(getBackCommand3());
            list.setCommandListener(this);
            list.setSelectedFlags(new boolean[]{});//GEN-END:|1492-getter|1|1492-postInit
 // write post-init user code here
            Log.i("creandoce lista", " lista tama駉 "+usuario.getInfracciones().size());
//            list.append("nuevo item",null);
            for(int i=0;i<usuario.getInfracciones().size();i++)
            {
                Infraccion inf = (Infraccion) usuario.getInfracciones().elementAt(i);
                list.append(inf.getCodigo(), null);
            }
        }//GEN-BEGIN:|1492-getter|2|
        return list;
    }
//</editor-fold>//GEN-END:|1492-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|1492-action|0|1492-preAction
    /**
     * Performs an action assigned to the selected list element in the list
     * component.
     */
    public void listAction() {
//GEN-END:|1492-action|0|1492-preAction
 // enter pre-action user code here
String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-LINE:|1492-action|1|1492-postAction
 // enter post-action user code here
}//GEN-BEGIN:|1492-action|2|
//</editor-fold>//GEN-END:|1492-action|2|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|1512-getter|0|1512-preInit
    /**
     * Returns an initialized instance of okCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {
//GEN-END:|1512-getter|0|1512-preInit
 // write pre-init user code here
okCommand2 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1512-getter|1|1512-postInit
 // write post-init user code here
}//GEN-BEGIN:|1512-getter|2|
        return okCommand2;
    }
//</editor-fold>//GEN-END:|1512-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|1511-getter|0|1511-preInit
    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
//GEN-END:|1511-getter|0|1511-preInit
 // write pre-init user code here
form = new Form("form");//GEN-LINE:|1511-getter|1|1511-postInit
 // write post-init user code here
}//GEN-BEGIN:|1511-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|1511-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backInfraccion ">//GEN-BEGIN:|1519-getter|0|1519-preInit
    /**
     * Returns an initialized instance of backInfraccion component.
     *
     * @return the initialized component instance
     */
    public Command getBackInfraccion() {
        if (backInfraccion == null) {
//GEN-END:|1519-getter|0|1519-preInit
 // write pre-init user code here
backInfraccion = new Command("Emitir Infraccion", Command.BACK, 0);//GEN-LINE:|1519-getter|1|1519-postInit
 // write post-init user code here
}//GEN-BEGIN:|1519-getter|2|
        return backInfraccion;
    }
//</editor-fold>//GEN-END:|1519-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand3 ">//GEN-BEGIN:|1522-getter|0|1522-preInit
    /**
     * Returns an initialized instance of okCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand3() {
        if (okCommand3 == null) {
//GEN-END:|1522-getter|0|1522-preInit
 // write pre-init user code here
okCommand3 = new Command("Atras", Command.OK, 0);//GEN-LINE:|1522-getter|1|1522-postInit
 // write post-init user code here
}//GEN-BEGIN:|1522-getter|2|
        return okCommand3;
    }
//</editor-fold>//GEN-END:|1522-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand5 ">//GEN-BEGIN:|1529-getter|0|1529-preInit
    /**
     * Returns an initialized instance of okCommand5 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand5() {
        if (okCommand5 == null) {
//GEN-END:|1529-getter|0|1529-preInit
 // write pre-init user code here
okCommand5 = new Command("Ok", Command.OK, 0);//GEN-LINE:|1529-getter|1|1529-postInit
 // write post-init user code here
}//GEN-BEGIN:|1529-getter|2|
        return okCommand5;
    }
//</editor-fold>//GEN-END:|1529-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: listPrincipal ">//GEN-BEGIN:|1525-getter|0|1525-preInit
    /**
     * Returns an initialized instance of listPrincipal component.
     *
     * @return the initialized component instance
     */
    public List getListPrincipal() {
        if (listPrincipal == null) {
//GEN-END:|1525-getter|0|1525-preInit
 // write pre-init user code here
listPrincipal = new List("Infracciones v 0.1", Choice.IMPLICIT);//GEN-BEGIN:|1525-getter|1|1525-postInit
            listPrincipal.append("Nueva Infracci\u00F3n", getImage16());
            listPrincipal.addCommand(getOkCommand5());
            listPrincipal.addCommand(getBackCommand4());
            listPrincipal.setCommandListener(this);
            listPrincipal.setSelectedFlags(new boolean[]{false});//GEN-END:|1525-getter|1|1525-postInit
 // write post-init user code here
}//GEN-BEGIN:|1525-getter|2|
        return listPrincipal;
    }
//</editor-fold>//GEN-END:|1525-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listPrincipalAction ">//GEN-BEGIN:|1525-action|0|1525-preAction
    /**
     * Performs an action assigned to the selected list element in the
     * listPrincipal component.
     */
    public void listPrincipalAction() {
//GEN-END:|1525-action|0|1525-preAction
 // enter pre-action user code here
String __selectedString = getListPrincipal().getString(getListPrincipal().getSelectedIndex());//GEN-BEGIN:|1525-action|1|1528-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Nueva Infracci\u00F3n")) {//GEN-END:|1525-action|1|1528-preAction
 // write pre-action user code here
switchDisplayable(null, getListMenu());//GEN-LINE:|1525-action|2|1528-postAction
 // write post-action user code here
    nuevaInfraccion();
            }//GEN-BEGIN:|1525-action|3|1525-postAction
        }//GEN-END:|1525-action|3|1525-postAction
 // enter post-action user code here
}//GEN-BEGIN:|1525-action|4|
//</editor-fold>//GEN-END:|1525-action|4|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand4 ">//GEN-BEGIN:|1533-getter|0|1533-preInit
    /**
     * Returns an initialized instance of backCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand4() {
        if (backCommand4 == null) {
//GEN-END:|1533-getter|0|1533-preInit
 // write pre-init user code here
backCommand4 = new Command("Cerrar Sesion", Command.BACK, 0);//GEN-LINE:|1533-getter|1|1533-postInit
 // write post-init user code here
}//GEN-BEGIN:|1533-getter|2|
        return backCommand4;
    }
//</editor-fold>//GEN-END:|1533-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image16 ">//GEN-BEGIN:|1536-getter|0|1536-preInit
    /**
     * Returns an initialized instance of image16 component.
     *
     * @return the initialized component instance
     */
    public Image getImage16() {
        if (image16 == null) {
//GEN-END:|1536-getter|0|1536-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|1536-getter|1|1536-@java.io.IOException
                image16 = Image.createImage("/produtoIpx.png");
            } catch (java.io.IOException e) {//GEN-END:|1536-getter|1|1536-@java.io.IOException
            }//GEN-LINE:|1536-getter|2|1536-postInit
 // write post-init user code here
}//GEN-BEGIN:|1536-getter|3|
        return image16;
    }
//</editor-fold>//GEN-END:|1536-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image17 ">//GEN-BEGIN:|1537-getter|0|1537-preInit
    /**
     * Returns an initialized instance of image17 component.
     *
     * @return the initialized component instance
     */
    public Image getImage17() {
        if (image17 == null) {
//GEN-END:|1537-getter|0|1537-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|1537-getter|1|1537-@java.io.IOException
                image17 = Image.createImage("/clienteIpx.png");
            } catch (java.io.IOException e) {//GEN-END:|1537-getter|1|1537-@java.io.IOException
            }//GEN-LINE:|1537-getter|2|1537-postInit
 // write post-init user code here
}//GEN-BEGIN:|1537-getter|3|
        return image17;
    }
//</editor-fold>//GEN-END:|1537-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image18 ">//GEN-BEGIN:|1538-getter|0|1538-preInit
    /**
     * Returns an initialized instance of image18 component.
     *
     * @return the initialized component instance
     */
    public Image getImage18() {
        if (image18 == null) {
//GEN-END:|1538-getter|0|1538-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|1538-getter|1|1538-@java.io.IOException
                image18 = Image.createImage("/facturaIpx.png");
            } catch (java.io.IOException e) {//GEN-END:|1538-getter|1|1538-@java.io.IOException
            }//GEN-LINE:|1538-getter|2|1538-postInit
 // write post-init user code here
}//GEN-BEGIN:|1538-getter|3|
        return image18;
    }
//</editor-fold>//GEN-END:|1538-getter|3|




public void Imprimir(Boleta boleta)
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

                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));

                                    imprimir.printText(ConstruirFila(" MEMORANDUM DE INFRACCION"),1);
                                    imprimir.printText(ConstruirFila(" Nro. "+boleta.getCorrelativo()),2);
                                    imprimir.printText(usuario.getCalle()+"-"+usuario.getZona(),1);
                                    imprimir.printText("Fecha: "+boleta.getFecha(), 1);

                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    //Datos del cliente
//                                    if(!infraccion.getOperador().equals("")){
//                                        imprimir.printText("OPERADOR:"+infraccion.getOperador(), 1);
//                                    }
//                                    if(!infraccion.getRuta().equals("")){
//                                        imprimir.printText("RUTA:"+infraccion.getRuta(), 1);
//                                    }
                                    imprimir.printText(boleta.getPlaca(), 2);
                                    imprimir.printText(boleta.getTipo() +" "+boleta.getColor(), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    
                                    imprimir.printText("OPERADOR: "+boleta.getOperador(), 1);
                                    imprimir.printText("RUTA: "+boleta.getRuta(), 1);
                                    imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    
                                    imprimir.printText("CONDUCTOR: "+boleta.getConductor(), 1);
                                    imprimir.printText("CI: "+boleta.getCi(), 1);
                                     imprimir.printBitmap(deviceOps.readImage("/linea.bmp", 0));
                                    for(int i=0;i<boleta.getInfracciones().size();i++)
                                    {
                                        Infraccion inf = (Infraccion) boleta.getInfracciones().elementAt(i);
                                        imprimir.printText(inf.getCodigo()+" "+inf.getMonto(), 1);
                                    }
                                    imprimir.printText("TOTAL: "+boleta.getMonto_total(), 1);
                                    imprimir.printText("GMT: "+usuario.getNombres()+" "+usuario.getPaterno()+" "+usuario.getMaterno(), 1);
                                    
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
                switchDisplayable(null,getListPrincipal());
                break;
             case REGISTRARINFRACCION:
                    switchDisplayable(null,getListPrincipal());
                    break;
//            
        }
                    
    }
    public void retornarPantalla()
    {
        switch(pantalla)
        {
            case AUTENTIFICACION:
                switchDisplayable(null,getFormLogin());
                break;
            
            case REGISTRARINFRACCION:
                switchDisplayable(null,getListMenu());
//                    switchDisplayable(null,getFormInfraccion());
                    break;
                
        }
    }   
    public String getAlertTitulo()
    { 
      switch(pantalla)
      {
          case AUTENTIFICACION:
        
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
         
         
      }
       
        return this.titulo;
    }
    public String getAlertMensaje()
    {
        switch(pantalla)
        {
            case AUTENTIFICACION:
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

   public Vector getListaInfracciones()
   {
       if(listaInfracciones==null)
       {
           listaInfracciones = new Vector();
       }
       return listaInfracciones;
   }
    public void nuevaInfraccion()
    {
        infractor = null;
        getListaInfracciones().removeAllElements();
        getListSeleccionados().deleteAll();
    }
    public void Limpiar()
    {
            
        
        
    }
   
}
