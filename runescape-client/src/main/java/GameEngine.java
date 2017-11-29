import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lbs;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1820589139
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 4903497815206533891L
   )
   static long field660;
   @ObfuscatedName("m")
   static boolean field688;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1959301615
   )
   protected static int field681;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1608219953
   )
   static int field664;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1898326115
   )
   static int field665;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -494826869
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("c")
   protected static long[] field667;
   @ObfuscatedName("f")
   protected static long[] field668;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 84836883
   )
   @Export("canvasHeight")
   public static int canvasHeight;
   @ObfuscatedName("ax")
   static java.awt.Font field690;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 815709213
   )
   static int field682;
   @ObfuscatedName("ar")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      longValue = -5282427061472028005L
   )
   @Export("garbageCollectorLastCollectionTime")
   protected static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      longValue = 1207182417536958589L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   protected static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 2111392483
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("b")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1936304199
   )
   protected int field670;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1365854793
   )
   protected int field663;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1306852901
   )
   int field671;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1299525521
   )
   int field672;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1016415933
   )
   int field674;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -304789867
   )
   int field661;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 915738651
   )
   int field676;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1844361997
   )
   int field677;
   @ObfuscatedName("au")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("al")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("ae")
   volatile boolean field692;
   @ObfuscatedName("am")
   boolean field683;
   @ObfuscatedName("ag")
   volatile boolean field684;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      longValue = 8952685860138889361L
   )
   volatile long field685;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "Lab;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ai")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("ay")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field660 = 0L;
      field688 = false;
      field664 = 20;
      field665 = 1;
      FPS = 0;
      field667 = new long[32];
      field668 = new long[32];
      field682 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field671 = 0;
      this.field672 = 0;
      this.field692 = true;
      this.field683 = false;
      this.field684 = false;
      this.field685 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      class25.method191(new SoundTaskDataProvider());
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1482920586"
   )
   public final void method854(int var1, int var2) {
      if(this.field676 != var1 || var2 != this.field677) {
         this.method870();
      }

      this.field676 = var1;
      this.field677 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "1689581251"
   )
   final void method855(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            BaseVarType.method12(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lfi;",
      garbageValue = "16711680"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-124"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1346887492"
   )
   protected void method867(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1271473206"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      class150.method3044();
      BoundingBox2D.method45(this.canvas);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-15792"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1218504130"
   )
   final void method861() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method875();
         this.field670 = Math.max(var2.field3793, this.field674);
         this.field663 = Math.max(var2.field3791, this.field661);
         if(this.field670 <= 0) {
            this.field670 = 1;
         }

         if(this.field663 <= 0) {
            this.field663 = 1;
         }

         class86.canvasWidth = Math.min(this.field670, this.field676);
         canvasHeight = Math.min(this.field663, this.field677);
         this.field671 = (this.field670 - class86.canvasWidth) / 2;
         this.field672 = 0;
         this.canvas.setSize(class86.canvasWidth, canvasHeight);
         class86.rasterProvider = new MainBufferProvider(class86.canvasWidth, canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(var3.left + this.field671, var3.top + this.field672);
         } else {
            this.canvas.setLocation(this.field671, this.field672);
         }

         this.field692 = true;
         this.vmethod1205();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-318420935"
   )
   protected abstract void vmethod1205();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-866667912"
   )
   void method998() {
      int var1 = this.field671;
      int var2 = this.field672;
      int var3 = this.field670 - class86.canvasWidth - var1;
      int var4 = this.field663 - canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.frame) {
               Insets var8 = this.frame.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field663);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field670, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field670 - var3, var7, var3, this.field663);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field663 - var4, this.field670, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void method860() {
      class209.method3829(this.canvas);
      BoundingBox2D.method41(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      BoundingBox2D.method45(this.canvas);
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method870();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "43"
   )
   @Export("initialize")
   protected final void initialize(int var1, int var2, int var3) {
      try {
         if(shell != null) {
            ++shellCount;
            if(shellCount >= 3) {
               this.error("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         shell = this;
         class86.canvasWidth = var1;
         canvasHeight = var2;
         RunException.revision = var3;
         RunException.field2126 = this;
         if(class277.taskManager == null) {
            class277.taskManager = new Signlink();
         }

         class277.taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         Item.method1829((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-94"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class86.canvasWidth = Math.max(var1.getWidth(), this.field674);
      canvasHeight = Math.max(var1.getHeight(), this.field661);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         class86.canvasWidth -= var2.right + var2.left;
         canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class86.canvasWidth, canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(this.field671 + var2.left, var2.top + this.field672);
      } else {
         this.canvas.setLocation(this.field671, this.field672);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field692 = true;
      if(class86.rasterProvider != null && class86.canvasWidth == class86.rasterProvider.width && canvasHeight == class86.rasterProvider.height) {
         ((MainBufferProvider)class86.rasterProvider).replaceComponent(this.canvas);
         class86.rasterProvider.drawFull(0, 0);
      } else {
         class86.rasterProvider = new MainBufferProvider(class86.canvasWidth, canvasHeight, this.canvas);
      }

      this.field684 = false;
      this.field685 = ServerPacket.currentTimeMs();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-14195"
   )
   @Export("isValidHost")
   protected final boolean isValidHost() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(var1.endsWith("127.0.0.1")) {
               return true;
            } else {
               while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
                  var1 = var1.substring(0, var1.length() - 1);
               }

               if(var1.endsWith("192.168.1.")) {
                  return true;
               } else {
                  this.error("invalidhost");
                  return false;
               }
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1659039145"
   )
   void method887() {
      long var1 = ServerPacket.currentTimeMs();
      long var3 = field668[class60.field718];
      field668[class60.field718] = var1;
      class60.field718 = class60.field718 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class43.field548 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2141360532"
   )
   void method1004() {
      Container var1 = this.container();
      long var2 = ServerPacket.currentTimeMs();
      long var4 = field667[BaseVarType.field30];
      field667[BaseVarType.field30] = var2;
      BaseVarType.field30 = BaseVarType.field30 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field682 - 1 > 50) {
         field682 -= 50;
         this.field692 = true;
         this.canvas.setSize(class86.canvasWidth, canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(this.field671 + var7.left, var7.top + this.field672);
         } else {
            this.canvas.setLocation(this.field671, this.field672);
         }
      }

      if(this.field684) {
         this.method860();
      }

      this.method869();
      this.methodDraw(this.field692);
      if(this.field692) {
         this.method998();
      }

      this.field692 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "56"
   )
   final void method869() {
      Bounds var1 = this.method875();
      if(var1.field3793 != this.field670 || this.field663 != var1.field3791 || this.field683) {
         this.method861();
         this.field683 = false;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   final void method870() {
      this.field683 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "107"
   )
   final synchronized void method896() {
      if(!field688) {
         field688 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1199();
         } catch (Exception var4) {
            ;
         }

         if(this.frame != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class277.taskManager != null) {
            try {
               class277.taskManager.join();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1194();
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-84214018"
   )
   protected abstract void setUp();

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "713150438"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1225770057"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "20949"
   )
   protected abstract void vmethod1199();

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "-1944585993"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(field690 == null) {
            field690 = new java.awt.Font("Helvetica", 1, 13);
            Frames.field2045 = this.canvas.getFontMetrics(field690);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class86.canvasWidth, canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class94.field1408 == null) {
               class94.field1408 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class94.field1408.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(field690);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - Frames.field2045.stringWidth(var2)) / 2, 22);
            var4.drawImage(class94.field1408, class86.canvasWidth / 2 - 152, canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class86.canvasWidth / 2 - 152;
            int var8 = canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(field690);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - Frames.field2045.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-495685061"
   )
   protected final void method881() {
      class94.field1408 = null;
      field690 = null;
      Frames.field2045 = null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-418751668"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.hasErrored) {
         this.hasErrored = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(S)Ljava/awt/Container;",
      garbageValue = "14821"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Lke;",
      garbageValue = "-1745569528"
   )
   Bounds method875() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field674);
      int var3 = Math.max(var1.getHeight(), this.field661);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1546554772"
   )
   protected final boolean method884() {
      return this.frame != null;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1585253082"
   )
   protected abstract void vmethod1194();

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field688) {
         this.field692 = true;
         if(ServerPacket.currentTimeMs() - this.field685 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class86.canvasWidth && var2.height >= canvasHeight) {
               this.field684 = true;
            }
         }

      }
   }

   public final void destroy() {
      if(this == shell && !field688) {
         field660 = ServerPacket.currentTimeMs();
         BaseVarType.method12(5000L);
         this.method896();
      }
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public void run() {
      try {
         if(Signlink.javaVendor != null) {
            String var1 = Signlink.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = Signlink.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length(); ++var3) {
                     char var5 = var2.charAt(var3);
                     boolean var4 = var5 >= '0' && var5 <= '9';
                     if(!var4) {
                        break;
                     }
                  }

                  String var6 = var2.substring(6, var3);
                  if(class82.method1695(var6) && class37.method510(var6) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               field665 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();
         CombatInfoListHolder.timer = ClanMember.method1191();

         while(0L == field660 || ServerPacket.currentTimeMs() < field660) {
            field681 = CombatInfoListHolder.timer.vmethod3108(field664, field665);

            for(int var7 = 0; var7 < field681; ++var7) {
               this.method887();
            }

            this.method1004();
            this.method855(this.canvas);
         }
      } catch (Exception var8) {
         Item.method1829((String)null, var8);
         this.error("crash");
      }

      this.method896();
   }

   public final void start() {
      if(this == shell && !field688) {
         field660 = 0L;
      }
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field692 = true;
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();

   public final void stop() {
      if(this == shell && !field688) {
         field660 = ServerPacket.currentTimeMs() + 4000L;
      }
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIILed;[Lfb;I)V",
      garbageValue = "-1170321677"
   )
   static final void method1006(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.getUSmart();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.getUSmart();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class61.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               FriendLoginUpdate.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }
}
