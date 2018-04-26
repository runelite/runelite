import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
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
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lbz;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1683555819
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -7855849656230624169L
   )
   static long field667;
   @ObfuscatedName("n")
   static boolean field668;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 154526775
   )
   static int field689;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1415798137
   )
   static int field691;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 552164287
   )
   static int field672;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1036263621
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("r")
   static long[] field673;
   @ObfuscatedName("q")
   static long[] field694;
   @ObfuscatedName("ao")
   static Image field687;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1302472685
   )
   static int field688;
   @ObfuscatedName("ap")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = -1462290612694009947L
   )
   @Export("garbageCollectorLastCollectionTime")
   static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = -1236216403836377587L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 1330924793
   )
   static int field685;
   @ObfuscatedName("l")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -182334827
   )
   protected int field681;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -903100767
   )
   protected int field684;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -820308695
   )
   int field678;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1743216113
   )
   int field679;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 619021825
   )
   int field680;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -467077207
   )
   int field665;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -631191981
   )
   int field682;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1230435177
   )
   int field683;
   @ObfuscatedName("ay")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("as")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("av")
   volatile boolean field686;
   @ObfuscatedName("ad")
   boolean field677;
   @ObfuscatedName("az")
   volatile boolean field690;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = 1978614402567128791L
   )
   volatile long field671;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ah")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("au")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field667 = 0L;
      field668 = false;
      field691 = 20;
      field672 = 1;
      FPS = 0;
      field673 = new long[32];
      field694 = new long[32];
      field688 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field678 = 0;
      this.field679 = 0;
      this.field686 = true;
      this.field677 = false;
      this.field690 = false;
      this.field671 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      SoundTaskDataProvider var2 = new SoundTaskDataProvider();
      MouseRecorder.soundTaskDataProvider = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-608612505"
   )
   public final void method902(int var1, int var2) {
      if(this.field682 != var1 || var2 != this.field683) {
         this.method917();
      }

      this.field682 = var1;
      this.field683 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-1421759891"
   )
   final void method1035(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            BoundingBox3DDrawMode.method59(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Lfo;",
      garbageValue = "2"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-47"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-206549114"
   )
   protected void method905(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2045624757"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      class157.method3254();
      DState.method3579(this.canvas);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      Size.method188(this.canvas);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-994337784"
   )
   final void method984() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method933();
         this.field681 = Math.max(var2.field3946, this.field680);
         this.field684 = Math.max(var2.field3944, this.field665);
         if(this.field681 <= 0) {
            this.field681 = 1;
         }

         if(this.field684 <= 0) {
            this.field684 = 1;
         }

         FaceNormal.canvasWidth = Math.min(this.field681, this.field682);
         class19.canvasHeight = Math.min(this.field684, this.field683);
         this.field678 = (this.field681 - FaceNormal.canvasWidth) / 2;
         this.field679 = 0;
         this.canvas.setSize(FaceNormal.canvasWidth, class19.canvasHeight);
         GrandExchangeOffer.rasterProvider = new MainBufferProvider(FaceNormal.canvasWidth, class19.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(var3.left + this.field678, var3.top + this.field679);
         } else {
            this.canvas.setLocation(this.field678, this.field679);
         }

         this.field686 = true;
         this.vmethod1282();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-94772277"
   )
   protected abstract void vmethod1282();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-390066414"
   )
   void method1033() {
      int var1 = this.field678;
      int var2 = this.field679;
      int var3 = this.field681 - FaceNormal.canvasWidth - var1;
      int var4 = this.field684 - class19.canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field684);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field681, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field681 - var3, var7, var3, this.field684);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field684 - var4, this.field681, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-557259807"
   )
   final void method911() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field614 = -1;
      WorldMapManager.method608(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      DState.method3579(this.canvas);
      Size.method188(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method917();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1049540084"
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
         FaceNormal.canvasWidth = var1;
         class19.canvasHeight = var2;
         class152.revision = var3;
         RunException.field2168 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class253.processClientError((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      FaceNormal.canvasWidth = Math.max(var1.getWidth(), this.field680);
      class19.canvasHeight = Math.max(var1.getHeight(), this.field665);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         FaceNormal.canvasWidth -= var2.right + var2.left;
         class19.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(FaceNormal.canvasWidth, class19.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(var2.left + this.field678, var2.top + this.field679);
      } else {
         this.canvas.setLocation(this.field678, this.field679);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field686 = true;
      if(GrandExchangeOffer.rasterProvider != null && FaceNormal.canvasWidth == GrandExchangeOffer.rasterProvider.width && class19.canvasHeight == GrandExchangeOffer.rasterProvider.height) {
         ((MainBufferProvider)GrandExchangeOffer.rasterProvider).replaceComponent(this.canvas);
         GrandExchangeOffer.rasterProvider.drawFull(0, 0);
      } else {
         GrandExchangeOffer.rasterProvider = new MainBufferProvider(FaceNormal.canvasWidth, class19.canvasHeight, this.canvas);
      }

      this.field690 = false;
      this.field671 = class289.method5267();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1440404519"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2060534564"
   )
   void method915() {
      long var1 = class289.method5267();
      long var3 = field694[class22.field342];
      field694[class22.field342] = var1;
      class22.field342 = class22.field342 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         GameCanvas.field643 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "125"
   )
   void method931() {
      Container var1 = this.container();
      long var2 = class289.method5267();
      long var4 = field673[class228.field2691];
      field673[class228.field2691] = var2;
      class228.field2691 = class228.field2691 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field688 - 1 > 50) {
         field688 -= 50;
         this.field686 = true;
         this.canvas.setSize(FaceNormal.canvasWidth, class19.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(var7.left + this.field678, var7.top + this.field679);
         } else {
            this.canvas.setLocation(this.field678, this.field679);
         }
      }

      if(this.field690) {
         this.method911();
      }

      this.method995();
      this.methodDraw(this.field686);
      if(this.field686) {
         this.method1033();
      }

      this.field686 = false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1338860190"
   )
   final void method995() {
      Bounds var1 = this.method933();
      if(this.field681 != var1.field3946 || this.field684 != var1.field3944 || this.field677) {
         this.method984();
         this.field677 = false;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1224760728"
   )
   final void method917() {
      this.field677 = true;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   final synchronized void method918() {
      if(!field668) {
         field668 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1276();
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

         this.vmethod1271();
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1316786070"
   )
   protected abstract void setUp();

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "87302511"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1429341575"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1055216285"
   )
   protected abstract void vmethod1276();

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "567922507"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(BoundingBox3DDrawMode.field265 == null) {
            BoundingBox3DDrawMode.field265 = new java.awt.Font("Helvetica", 1, 13);
            GameSocket.field2247 = this.canvas.getFontMetrics(BoundingBox3DDrawMode.field265);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, FaceNormal.canvasWidth, class19.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(field687 == null) {
               field687 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = field687.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(BoundingBox3DDrawMode.field265);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - GameSocket.field2247.stringWidth(var2)) / 2, 22);
            var4.drawImage(field687, FaceNormal.canvasWidth / 2 - 152, class19.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = FaceNormal.canvasWidth / 2 - 152;
            int var8 = class19.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(BoundingBox3DDrawMode.field265);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - GameSocket.field2247.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-17"
   )
   protected final void method1024() {
      field687 = null;
      BoundingBox3DDrawMode.field265 = null;
      GameSocket.field2247 = null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1329028875"
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

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "-32"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Lls;",
      garbageValue = "339444126"
   )
   Bounds method933() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field680);
      int var3 = Math.max(var1.getHeight(), this.field665);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "11776"
   )
   protected final boolean method934() {
      return this.frame != null;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "594976712"
   )
   protected abstract void vmethod1271();

   public final void destroy() {
      if(this == shell && !field668) {
         field667 = class289.method5267();
         BoundingBox3DDrawMode.method59(5000L);
         this.method918();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field668) {
         this.field686 = true;
         if(class289.method5267() - this.field671 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= FaceNormal.canvasWidth && var2.height >= class19.canvasHeight) {
               this.field690 = true;
            }
         }

      }
   }

   public final void windowDeiconified(WindowEvent var1) {
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
                  for(var3 = 6; var3 < var2.length() && JagexGame.method4636(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var5 = ClanMemberManager.method5518(var4, 10, true);
                  if(var5 && Item.method2020(var4) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               field672 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();

         Object var9;
         try {
            var9 = new NanoTimer();
         } catch (Throwable var7) {
            var9 = new MilliTimer();
         }

         class324.timer = (Timer)var9;

         while(0L == field667 || class289.method5267() < field667) {
            field689 = class324.timer.vmethod3398(field691, field672);

            for(int var6 = 0; var6 < field689; ++var6) {
               this.method915();
            }

            this.method931();
            this.method1035(this.canvas);
         }
      } catch (Exception var8) {
         class253.processClientError((String)null, var8);
         this.error("crash");
      }

      this.method918();
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void start() {
      if(this == shell && !field668) {
         field667 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field668) {
         field667 = class289.method5267() + 4000L;
      }
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @Export("focusGained")
   @Hook("focusGained")
   @ObfuscatedName("focusGained")
   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field686 = true;
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("init")
   public abstract void init();

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CIB)C",
      garbageValue = "61"
   )
   public static char method1053(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   @ObfuscatedName("e")
   static final void method949(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "118"
   )
   static final void method916(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               WorldMapType2.field519[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   static final int method1051() {
      return class132.Viewport_mouseX;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "114"
   )
   static final void method1050(String var0) {
      PacketNode var1 = AbstractSoundSystem.method2350(ClientPacket.field2457, Client.field911.field1460);
      var1.packetBuffer.putByte(class95.getLength(var0));
      var1.packetBuffer.putString(var0);
      Client.field911.method2135(var1);
   }
}
