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
import net.runelite.rs.Reflection;

@ObfuscatedName("bh")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lbh;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -703923171
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -2496412811779325915L
   )
   static long field671;
   @ObfuscatedName("l")
   static boolean field662;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 802392609
   )
   static int field645;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1782569211
   )
   static int field649;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 538238087
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("v")
   static long[] field652;
   @ObfuscatedName("j")
   static long[] field653;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2050175027
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -832106625
   )
   static int field646;
   @ObfuscatedName("aw")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = -4582346536581302015L
   )
   @Export("garbageCollectorLastCollectionTime")
   protected static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = -7441083586745361739L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   protected static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("b")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1431474945
   )
   protected int field654;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1000901911
   )
   protected int field655;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1266553443
   )
   int field656;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1596880623
   )
   int field669;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -563351531
   )
   int field659;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 594749515
   )
   int field642;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -2118642509
   )
   int field661;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 356648081
   )
   int field667;
   @ObfuscatedName("am")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("az")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("ap")
   volatile boolean field665;
   @ObfuscatedName("ax")
   boolean field666;
   @ObfuscatedName("ar")
   volatile boolean field668;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = -5078350051022714201L
   )
   volatile long field657;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ag")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("as")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field671 = 0L;
      field662 = false;
      field645 = 20;
      field649 = 1;
      FPS = 0;
      field652 = new long[32];
      field653 = new long[32];
      field646 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field656 = 0;
      this.field669 = 0;
      this.field665 = true;
      this.field666 = false;
      this.field668 = false;
      this.field657 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      World.method1707(new SoundTaskDataProvider());
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1726967995"
   )
   protected final void method911(int var1, int var2) {
      if(this.field661 != var1 || var2 != this.field667) {
         this.method928();
      }

      this.field661 = var1;
      this.field667 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "36960529"
   )
   final void method1044(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            class93.method1982(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Lfs;",
      garbageValue = "79"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-55"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1156887288"
   )
   protected void method923(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1240581307"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      DState.method3517();
      PlayerComposition.method4433(this.canvas);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1899102440"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      KeyFocusListener.method828(this.canvas);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1017633802"
   )
   final void method1021() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method936();
         this.field654 = Math.max(var2.field3943, this.field659);
         this.field655 = Math.max(var2.field3944, this.field642);
         if(this.field654 <= 0) {
            this.field654 = 1;
         }

         if(this.field655 <= 0) {
            this.field655 = 1;
         }

         WallObject.canvasWidth = Math.min(this.field654, this.field661);
         canvasHeight = Math.min(this.field655, this.field667);
         this.field656 = (this.field654 - WallObject.canvasWidth) / 2;
         this.field669 = 0;
         this.canvas.setSize(WallObject.canvasWidth, canvasHeight);
         KeyFocusListener.rasterProvider = new MainBufferProvider(WallObject.canvasWidth, canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(this.field656 + var3.left, var3.top + this.field669);
         } else {
            this.canvas.setLocation(this.field656, this.field669);
         }

         this.field665 = true;
         this.vmethod1265();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-823924703"
   )
   protected abstract void vmethod1265();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-804224362"
   )
   void method979() {
      int var1 = this.field656;
      int var2 = this.field669;
      int var3 = this.field654 - WallObject.canvasWidth - var1;
      int var4 = this.field655 - canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field655);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field654, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field654 - var3, var7, var3, this.field655);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field655 - var4, this.field654, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "615719469"
   )
   final void method915() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field603 = -1;
      Canvas var2 = this.canvas;
      var2.removeMouseListener(MouseInput.mouse);
      var2.removeMouseMotionListener(MouseInput.mouse);
      var2.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      PlayerComposition.method4433(this.canvas);
      KeyFocusListener.method828(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method928();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1866100871"
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
         WallObject.canvasWidth = var1;
         canvasHeight = var2;
         class303.revision = var3;
         RunException.field2154 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         GroundObject.processClientError((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1913153217"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      WallObject.canvasWidth = Math.max(var1.getWidth(), this.field659);
      canvasHeight = Math.max(var1.getHeight(), this.field642);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         WallObject.canvasWidth -= var2.right + var2.left;
         canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(WallObject.canvasWidth, canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(var2.left + this.field656, this.field669 + var2.top);
      } else {
         this.canvas.setLocation(this.field656, this.field669);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field665 = true;
      if(KeyFocusListener.rasterProvider != null && WallObject.canvasWidth == KeyFocusListener.rasterProvider.width && canvasHeight == KeyFocusListener.rasterProvider.height) {
         ((MainBufferProvider)KeyFocusListener.rasterProvider).replaceComponent(this.canvas);
         KeyFocusListener.rasterProvider.drawFull(0, 0);
      } else {
         KeyFocusListener.rasterProvider = new MainBufferProvider(WallObject.canvasWidth, canvasHeight, this.canvas);
      }

      this.field668 = false;
      this.field657 = WorldMapRegion.method465();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1678182992"
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1804205789"
   )
   void method925() {
      long var1 = WorldMapRegion.method465();
      long var3 = field653[Enum.field3563];
      field653[Enum.field3563] = var1;
      Enum.field3563 = Enum.field3563 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         Buffer.field2550 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2140073307"
   )
   void method926() {
      Container var1 = this.container();
      long var2 = WorldMapRegion.method465();
      long var4 = field652[class3.field18];
      field652[class3.field18] = var2;
      class3.field18 = class3.field18 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field646 - 1 > 50) {
         field646 -= 50;
         this.field665 = true;
         this.canvas.setSize(WallObject.canvasWidth, canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(this.field656 + var7.left, this.field669 + var7.top);
         } else {
            this.canvas.setLocation(this.field656, this.field669);
         }
      }

      if(this.field668) {
         this.method915();
      }

      this.method927();
      this.methodDraw(this.field665);
      if(this.field665) {
         this.method979();
      }

      this.field665 = false;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2127600554"
   )
   final void method927() {
      Bounds var1 = this.method936();
      if(this.field654 != var1.field3943 || this.field655 != var1.field3944 || this.field666) {
         this.method1021();
         this.field666 = false;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "110"
   )
   final void method928() {
      this.field666 = true;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "41116327"
   )
   final synchronized void method929() {
      if(!field662) {
         field662 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1535();
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

         if(taskManager != null) {
            try {
               taskManager.join();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1354();
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1938638739"
   )
   protected abstract void setUp();

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "331738257"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "287492788"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   protected abstract void vmethod1535();

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "-93"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class22.field320 == null) {
            class22.field320 = new java.awt.Font("Helvetica", 1, 13);
            class199.field2583 = this.canvas.getFontMetrics(class22.field320);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, WallObject.canvasWidth, canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(UrlRequester.field2091 == null) {
               UrlRequester.field2091 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = UrlRequester.field2091.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class22.field320);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class199.field2583.stringWidth(var2)) / 2, 22);
            var4.drawImage(UrlRequester.field2091, WallObject.canvasWidth / 2 - 152, canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = WallObject.canvasWidth / 2 - 152;
            int var8 = canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class22.field320);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class199.field2583.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1371209429"
   )
   protected final void method1011() {
      UrlRequester.field2091 = null;
      class22.field320 = null;
      class199.field2583 = null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "181148408"
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

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-99999"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)Llb;",
      garbageValue = "-112"
   )
   Bounds method936() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field659);
      int var3 = Math.max(var1.getHeight(), this.field642);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-920588775"
   )
   protected final boolean method1023() {
      return this.frame != null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "40"
   )
   protected abstract void vmethod1354();

   public final void destroy() {
      if(this == shell && !field662) {
         field671 = WorldMapRegion.method465();
         class93.method1982(5000L);
         this.method929();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field662) {
         this.field665 = true;
         if(WorldMapRegion.method465() - this.field657 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= WallObject.canvasWidth && var2.height >= canvasHeight) {
               this.field668 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field665 = true;
   }

   public final void start() {
      if(this == shell && !field662) {
         field671 = 0L;
      }
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void stop() {
      if(this == shell && !field662) {
         field671 = WorldMapRegion.method465() + 4000L;
      }
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
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
                  if(class163.method3210(var6) && class158.method3176(var6) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               field649 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();
         timer = WorldMapRegion.method529();

         while(field671 == 0L || WorldMapRegion.method465() < field671) {
            Huffman.field2483 = timer.vmethod3323(field645, field649);

            for(int var7 = 0; var7 < Huffman.field2483; ++var7) {
               this.method925();
            }

            this.method926();
            this.method1044(this.canvas);
         }
      } catch (Exception var8) {
         GroundObject.processClientError((String)null, var8);
         this.error("crash");
      }

      this.method929();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1310674913"
   )
   @Export("loadClassFromDescriptor")
   static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "16"
   )
   static final int method1050(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 65280) * var2 + (var0 & 65280) * var3 & 16711680) + ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "([Lig;Lig;ZI)V",
      garbageValue = "-1000901911"
   )
   static void method1051(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class55.method856(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class55.method856(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(Script.loadWidget(var6)) {
            class55.method856(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Lig;I)V",
      garbageValue = "903508810"
   )
   static void method1053(Widget var0) {
      if(var0.loopCycle == Client.field1026) {
         Client.field1051[var0.boundsIndex] = true;
      }

   }
}
