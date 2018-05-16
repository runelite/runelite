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
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1361678311
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 2836813929099139673L
   )
   static long field383;
   @ObfuscatedName("n")
   static boolean field384;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1689766149
   )
   static int field386;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1392235875
   )
   static int field387;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1564891621
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("g")
   static long[] field390;
   @ObfuscatedName("e")
   static long[] field397;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -698610971
   )
   static int field413;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -741352333
   )
   static int field400;
   @ObfuscatedName("au")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = 7031479172029741533L
   )
   @Export("garbageCollectorLastCollectionTime")
   protected static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      longValue = 1019046935399526603L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   protected static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("br")
   static String field414;
   @ObfuscatedName("fg")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("h")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1359376647
   )
   protected int field393;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -699256651
   )
   protected int field415;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 914914601
   )
   int field395;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1335456885
   )
   int field396;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -541578041
   )
   int field392;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1973436221
   )
   int field398;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 970051927
   )
   int field405;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1582770673
   )
   int field407;
   @ObfuscatedName("an")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("as")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("aw")
   volatile boolean field403;
   @ObfuscatedName("az")
   boolean field381;
   @ObfuscatedName("ao")
   volatile boolean field406;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      longValue = 8431450235844399711L
   )
   volatile long field394;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("aj")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("ae")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field383 = 0L;
      field384 = false;
      field386 = 20;
      field387 = 1;
      FPS = 0;
      field390 = new long[32];
      field397 = new long[32];
      field400 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field395 = 0;
      this.field396 = 0;
      this.field403 = true;
      this.field381 = false;
      this.field406 = false;
      this.field394 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      class240.method4598(new SoundTaskDataProvider());
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "114"
   )
   public final void method896(int var1, int var2) {
      if(this.field405 != var1 || var2 != this.field407) {
         this.method836();
      }

      this.field405 = var1;
      this.field407 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-1496637941"
   )
   final void method844(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            WorldMapType1.method218(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lfp;",
      garbageValue = "-24"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "648845159"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1271957491"
   )
   protected void method929(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1606203667"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      class262.method4940();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "19804"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1973501131"
   )
   final void method888() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method860();
         this.field393 = Math.max(var2.field3750, this.field392);
         this.field415 = Math.max(var2.field3751, this.field398);
         if(this.field393 <= 0) {
            this.field393 = 1;
         }

         if(this.field415 <= 0) {
            this.field415 = 1;
         }

         class9.canvasWidth = Math.min(this.field393, this.field405);
         class37.canvasHeight = Math.min(this.field415, this.field407);
         this.field395 = (this.field393 - class9.canvasWidth) / 2;
         this.field396 = 0;
         this.canvas.setSize(class9.canvasWidth, class37.canvasHeight);
         class50.rasterProvider = new MainBufferProvider(class9.canvasWidth, class37.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(this.field395 + var3.left, var3.top + this.field396);
         } else {
            this.canvas.setLocation(this.field395, this.field396);
         }

         this.field403 = true;
         this.vmethod1203();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected abstract void vmethod1203();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "592579589"
   )
   void method845() {
      int var1 = this.field395;
      int var2 = this.field396;
      int var3 = this.field393 - class9.canvasWidth - var1;
      int var4 = this.field415 - class37.canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field415);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field393, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field393 - var3, var7, var3, this.field415);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field415 - var4, this.field393, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1870127336"
   )
   final void method859() {
      GrandExchangeOffer.method53(this.canvas);
      Canvas var1 = this.canvas;
      var1.removeMouseListener(MouseInput.mouse);
      var1.removeMouseMotionListener(MouseInput.mouse);
      var1.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      Canvas var3 = this.canvas;
      var3.addMouseListener(MouseInput.mouse);
      var3.addMouseMotionListener(MouseInput.mouse);
      var3.addFocusListener(MouseInput.mouse);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method836();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "112"
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
         class9.canvasWidth = var1;
         class37.canvasHeight = var2;
         class54.revision = var3;
         RunException.field1957 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class43.processClientError((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1810851436"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class9.canvasWidth = Math.max(var1.getWidth(), this.field392);
      class37.canvasHeight = Math.max(var1.getHeight(), this.field398);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         class9.canvasWidth -= var2.left + var2.right;
         class37.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class9.canvasWidth, class37.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(var2.left + this.field395, this.field396 + var2.top);
      } else {
         this.canvas.setLocation(this.field395, this.field396);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field403 = true;
      if(class50.rasterProvider != null && class9.canvasWidth == class50.rasterProvider.width && class37.canvasHeight == class50.rasterProvider.height) {
         ((MainBufferProvider)class50.rasterProvider).replaceComponent(this.canvas);
         class50.rasterProvider.drawFull(0, 0);
      } else {
         class50.rasterProvider = new MainBufferProvider(class9.canvasWidth, class37.canvasHeight, this.canvas);
      }

      this.field406 = false;
      this.field394 = class166.method3456();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "753677261"
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

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2031567293"
   )
   void method851() {
      long var1 = class166.method3456();
      long var3 = field397[field413];
      field397[field413] = var1;
      field413 = field413 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         Preferences.field978 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2093614494"
   )
   void method914() {
      Container var1 = this.container();
      long var2 = class166.method3456();
      long var4 = field390[UnitPriceComparator.field35];
      field390[UnitPriceComparator.field35] = var2;
      UnitPriceComparator.field35 = UnitPriceComparator.field35 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field400 - 1 > 50) {
         field400 -= 50;
         this.field403 = true;
         this.canvas.setSize(class9.canvasWidth, class37.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(this.field395 + var7.left, this.field396 + var7.top);
         } else {
            this.canvas.setLocation(this.field395, this.field396);
         }
      }

      if(this.field406) {
         this.method859();
      }

      this.method853();
      this.methodDraw(this.field403);
      if(this.field403) {
         this.method845();
      }

      this.field403 = false;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1806849065"
   )
   final void method853() {
      Bounds var1 = this.method860();
      if(this.field393 != var1.field3750 || var1.field3751 != this.field415 || this.field381) {
         this.method888();
         this.field381 = false;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-370826843"
   )
   final void method836() {
      this.field381 = true;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1316647126"
   )
   final synchronized void method855() {
      if(!field384) {
         field384 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1197();
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

         this.vmethod1192();
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-81564058"
   )
   protected abstract void setUp();

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1245920510"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2135258546"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "949470738"
   )
   protected abstract void vmethod1197();

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "-2016466129"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(FileOnDisk.field1455 == null) {
            FileOnDisk.field1455 = new java.awt.Font("Helvetica", 1, 13);
            class37.field322 = this.canvas.getFontMetrics(FileOnDisk.field1455);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class9.canvasWidth, class37.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class234.field2799 == null) {
               class234.field2799 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class234.field2799.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(FileOnDisk.field1455);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class37.field322.stringWidth(var2)) / 2, 22);
            var4.drawImage(class234.field2799, class9.canvasWidth / 2 - 152, class37.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class9.canvasWidth / 2 - 152;
            int var8 = class37.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(FileOnDisk.field1455);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class37.field322.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1761915639"
   )
   protected final void method866() {
      class234.field2799 = null;
      FileOnDisk.field1455 = null;
      class37.field322 = null;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "15040"
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

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1376238359"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Lka;",
      garbageValue = "1409221587"
   )
   Bounds method860() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field392);
      int var3 = Math.max(var1.getHeight(), this.field398);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1818111363"
   )
   protected final boolean method979() {
      return this.frame != null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1726845378"
   )
   protected abstract void vmethod1192();

   public final void destroy() {
      if(this == shell && !field384) {
         field383 = class166.method3456();
         WorldMapType1.method218(5000L);
         this.method855();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field384) {
         this.field403 = true;
         if(class166.method3456() - this.field394 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class9.canvasWidth && var2.height >= class37.canvasHeight) {
               this.field406 = true;
            }
         }

      }
   }

   @Export("focusGained")
   @Hook("focusGained")
   @ObfuscatedName("focusGained")
   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field403 = true;
   }

   public final void start() {
      if(this == shell && !field384) {
         field383 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field384) {
         field383 = class166.method3456() + 4000L;
      }
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
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

   public final void windowIconified(WindowEvent var1) {
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
                  for(var3 = 6; var3 < var2.length() && class184.method3830(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var7 = false;
                  boolean var8 = false;
                  int var9 = 0;
                  int var10 = var4.length();
                  int var11 = 0;

                  boolean var6;
                  while(true) {
                     if(var11 >= var10) {
                        var6 = var8;
                        break;
                     }

                     label171: {
                        char var12 = var4.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == '-') {
                              var7 = true;
                              break label171;
                           }

                           if(var12 == '+') {
                              break label171;
                           }
                        }

                        int var19;
                        if(var12 >= '0' && var12 <= '9') {
                           var19 = var12 - '0';
                        } else if(var12 >= 'A' && var12 <= 'Z') {
                           var19 = var12 - '7';
                        } else {
                           if(var12 < 'a' || var12 > 'z') {
                              var6 = false;
                              break;
                           }

                           var19 = var12 - 'W';
                        }

                        if(var19 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var19 = -var19;
                        }

                        int var13 = var9 * 10 + var19;
                        if(var9 != var13 / 10) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6) {
                     int var18 = GrandExchangeEvents.parseInt(var4, 10, true);
                     if(var18 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field387 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();

         Object var17;
         try {
            var17 = new NanoTimer();
         } catch (Throwable var15) {
            var17 = new MilliTimer();
         }

         timer = (Timer)var17;

         while(field383 == 0L || class166.method3456() < field383) {
            Ignore.field3645 = timer.vmethod3348(field386, field387);

            for(int var14 = 0; var14 < Ignore.field3645; ++var14) {
               this.method851();
            }

            this.method914();
            this.method844(this.canvas);
         }
      } catch (Exception var16) {
         class43.processClientError((String)null, var16);
         this.error("crash");
      }

      this.method855();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Liv;Ljava/lang/String;Ljava/lang/String;I)Llh;",
      garbageValue = "1889737035"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return NPC.method1842(var0, var3, var4);
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1616251664"
   )
   static final void method983(int var0) {
      int[] var1 = class283.minimapSprite.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class50.tileSettings[var0][var5][var3] & 24) == 0) {
               ScriptEvent.region.drawTile(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class50.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               ScriptEvent.region.drawTile(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class283.minimapSprite.setRaster();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class50.tileSettings[var0][var6][var5] & 24) == 0) {
               Actor.drawObject(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class50.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               Actor.drawObject(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field651 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            long var7 = ScriptEvent.region.method2930(class192.plane, var5, var6);
            if(var7 != 0L) {
               int var9 = class8.method93(var7);
               int var10 = SoundTaskDataProvider.getObjectDefinition(var9).mapIconId;
               if(var10 >= 0) {
                  Client.mapIcons[Client.field651] = Area.mapAreaType[var10].getMapIcon(false);
                  Client.field817[Client.field651] = var5;
                  Client.field818[Client.field651] = var6;
                  ++Client.field651;
               }
            }
         }
      }

      class50.rasterProvider.setRaster();
   }
}
