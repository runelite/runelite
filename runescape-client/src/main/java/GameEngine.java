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

@ObfuscatedName("bo")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ai")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lbo;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("g")
   static boolean field690;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1977193627
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 2215114252866933213L
   )
   static long field706;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -599834205
   )
   static int field693;
   @ObfuscatedName("e")
   protected static long[] field686;
   @ObfuscatedName("ck")
   static boolean field699;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("taskManager")
   public static Signlink taskManager;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1080100983
   )
   static int field694;
   @ObfuscatedName("t")
   protected static long[] field696;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 713154131
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1683924877
   )
   static int field721;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      longValue = -6115400865740369045L
   )
   protected static long field717;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      longValue = 9161066209084306795L
   )
   protected static long field718;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1448607205
   )
   protected static int field692;
   @ObfuscatedName("ah")
   Clipboard field715;
   @ObfuscatedName("ax")
   final EventQueue field689;
   @ObfuscatedName("an")
   boolean field710;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   class49 field713;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 770673203
   )
   int field714;
   @ObfuscatedName("m")
   boolean field716;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 292197457
   )
   int field704;
   @ObfuscatedName("al")
   java.awt.Frame field691;
   @ObfuscatedName("ab")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1672705923
   )
   int field701;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -528871319
   )
   protected int field709;
   @ObfuscatedName("af")
   volatile boolean field712;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1583360173
   )
   int field705;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1481600567
   )
   int field702;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -602155683
   )
   protected int field708;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -915783467
   )
   int field703;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      longValue = -3099579531183231857L
   )
   volatile long field700;
   @ObfuscatedName("at")
   volatile boolean field711;

   static {
      shell = null;
      shellCount = 0;
      field706 = 0L;
      field690 = false;
      field693 = 20;
      field694 = 1;
      FPS = 0;
      field696 = new long[32];
      field686 = new long[32];
      field721 = 500;
      focused = true;
      field717 = -1L;
      field718 = -1L;
   }

   protected GameEngine() {
      this.field716 = false;
      this.field714 = 0;
      this.field701 = 0;
      this.field712 = true;
      this.field710 = false;
      this.field711 = false;
      this.field700 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field689 = var1;
      Ignore.method1055(new class51());
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2111684999"
   )
   @Export("isValidHost")
   protected final boolean isValidHost() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(var1.endsWith("127.0.0.1")) {
               return true;
            } else {
               while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= 48 && var1.charAt(var1.length() - 1) <= 57) {
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

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field690) {
         this.field712 = true;
         if(class157.currentTimeMs() - this.field700 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class45.canvasWidth && var2.height >= class10.canvasHeight) {
               this.field711 = true;
            }
         }

      }
   }

   public final void destroy() {
      if(this == shell && !field690) {
         field706 = class157.currentTimeMs();
         Occluder.method2829(5000L);
         this.method825();
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Lje;",
      garbageValue = "414048439"
   )
   class278 method841() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field702);
      int var3 = Math.max(var1.getHeight(), this.field703);
      if(this.field691 != null) {
         Insets var4 = this.field691.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new class278(var2, var3);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1816897038"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field691 != null?this.field691:this);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2078715934"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field716) {
         this.field716 = true;
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
      signature = "(I)V",
      garbageValue = "-1296180548"
   )
   final void method824() {
      this.field710 = true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-16047"
   )
   final synchronized void method818() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class45.canvasWidth = Math.max(var1.getWidth(), this.field702);
      class10.canvasHeight = Math.max(var1.getHeight(), this.field703);
      Insets var2;
      if(this.field691 != null) {
         var2 = this.field691.getInsets();
         class45.canvasWidth -= var2.left + var2.right;
         class10.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class45.canvasWidth, class10.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field691) {
         var2 = this.field691.getInsets();
         this.canvas.setLocation(this.field714 + var2.left, var2.top + this.field701);
      } else {
         this.canvas.setLocation(this.field714, this.field701);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field712 = true;
      if(WorldMapType1.field417 != null && class45.canvasWidth == WorldMapType1.field417.width && class10.canvasHeight == WorldMapType1.field417.height) {
         ((MainBufferProvider)WorldMapType1.field417).method790(this.canvas);
         WorldMapType1.field417.vmethod4917(0, 0);
      } else {
         WorldMapType1.field417 = new MainBufferProvider(class45.canvasWidth, class10.canvasHeight, this.canvas);
      }

      this.field711 = false;
      this.field700 = class157.currentTimeMs();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "50"
   )
   final synchronized void method825() {
      if(!field690) {
         field690 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1254();
         } catch (Exception var4) {
            ;
         }

         if(this.field691 != null) {
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

         this.vmethod1096();
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1989896526"
   )
   protected abstract void vmethod1254();

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   protected abstract void vmethod1149();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1555597925"
   )
   final void method865() {
      Container var1 = this.container();
      if(var1 != null) {
         class278 var2 = this.method841();
         this.field709 = Math.max(var2.field3726, this.field702);
         this.field708 = Math.max(var2.field3727, this.field703);
         if(this.field709 <= 0) {
            this.field709 = 1;
         }

         if(this.field708 <= 0) {
            this.field708 = 1;
         }

         class45.canvasWidth = Math.min(this.field709, this.field704);
         class10.canvasHeight = Math.min(this.field708, this.field705);
         this.field714 = (this.field709 - class45.canvasWidth) / 2;
         this.field701 = 0;
         this.canvas.setSize(class45.canvasWidth, class10.canvasHeight);
         WorldMapType1.field417 = new MainBufferProvider(class45.canvasWidth, class10.canvasHeight, this.canvas);
         if(var1 == this.field691) {
            Insets var3 = this.field691.getInsets();
            this.canvas.setLocation(var3.left + this.field714, this.field701 + var3.top);
         } else {
            this.canvas.setLocation(this.field714, this.field701);
         }

         this.field712 = true;
         this.vmethod1107();
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   protected final void method838() {
      class220.field2786 = null;
      class17.field308 = null;
      class11.field254 = null;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-10"
   )
   protected abstract void vmethod1096();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1114031154"
   )
   protected final void method811() {
      FrameMap.method2614();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "63"
   )
   protected final void method812() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Lfr;",
      garbageValue = "32"
   )
   protected class156 method808() {
      if(this.field713 == null) {
         this.field713 = new class49();
         this.field713.method701(this.canvas);
      }

      return this.field713;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16777215"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "118"
   )
   void method831() {
      Container var1 = this.container();
      long var2 = class157.currentTimeMs();
      long var4 = field696[class45.field587];
      field696[class45.field587] = var2;
      class45.field587 = class45.field587 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field721 - 1 > 50) {
         field721 -= 50;
         this.field712 = true;
         this.canvas.setSize(class45.canvasWidth, class10.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field691) {
            Insets var7 = this.field691.getInsets();
            this.canvas.setLocation(var7.left + this.field714, var7.top + this.field701);
         } else {
            this.canvas.setLocation(this.field714, this.field701);
         }
      }

      if(this.field711) {
         this.method853();
      }

      this.method823();
      this.vmethod1100(this.field712);
      if(this.field712) {
         this.method886();
      }

      this.field712 = false;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "58"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class17.field308 == null) {
            class17.field308 = new java.awt.Font("Helvetica", 1, 13);
            class11.field254 = this.canvas.getFontMetrics(class17.field308);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class45.canvasWidth, class10.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class220.field2786 == null) {
               class220.field2786 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class220.field2786.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(3 * var1 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class17.field308);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class11.field254.stringWidth(var2)) / 2, 22);
            var4.drawImage(class220.field2786, class45.canvasWidth / 2 - 152, class10.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class45.canvasWidth / 2 - 152;
            int var8 = class10.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class17.field308);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class11.field254.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   void method816() {
      long var1 = class157.currentTimeMs();
      long var3 = field686[IndexFile.field2242];
      field686[IndexFile.field2242] = var1;
      IndexFile.field2242 = IndexFile.field2242 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class31.field425 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "582512183"
   )
   final void method807(Object var1) {
      if(this.field689 != null) {
         for(int var2 = 0; var2 < 50 && this.field689.peekEvent() != null; ++var2) {
            Occluder.method2829(1L);
         }

         if(var1 != null) {
            this.field689.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-15"
   )
   protected void method809() {
      this.field715 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1493532347"
   )
   public final void method916(int var1, int var2) {
      if(this.field704 != var1 || var2 != this.field705) {
         this.method824();
      }

      this.field704 = var1;
      this.field705 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1831915263"
   )
   protected abstract void vmethod1107();

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1599632822"
   )
   final void method853() {
      class23.method168(this.canvas);
      class168.method3057(this.canvas);
      if(this.field713 != null) {
         this.field713.method710(this.canvas);
      }

      this.method818();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
      Canvas var2 = this.canvas;
      var2.addMouseListener(MouseInput.mouse);
      var2.addMouseMotionListener(MouseInput.mouse);
      var2.addFocusListener(MouseInput.mouse);
      if(this.field713 != null) {
         this.field713.method701(this.canvas);
      }

      this.method824();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2112059964"
   )
   final void method823() {
      class278 var1 = this.method841();
      if(var1.field3726 != this.field709 || var1.field3727 != this.field708 || this.field710) {
         this.method865();
         this.field710 = false;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1449216411"
   )
   protected abstract void vmethod1100(boolean var1);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-49"
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
         class45.canvasWidth = var1;
         class10.canvasHeight = var2;
         class152.revision = var3;
         class152.field2177 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         WorldMapType2.method495((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "22560"
   )
   void method886() {
      int var1 = this.field714;
      int var2 = this.field701;
      int var3 = this.field709 - class45.canvasWidth - var1;
      int var4 = this.field708 - class10.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field691) {
               Insets var8 = this.field691.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field708);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field709, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field709 - var3, var7, var3, this.field708);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field708 - var4, this.field709, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-102"
   )
   protected void method810(String var1) {
      this.field715.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-99"
   )
   protected final boolean method842() {
      return this.field691 != null;
   }

   public final void start() {
      if(this == shell && !field690) {
         field706 = 0L;
      }
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field712 = true;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public abstract void init();

   public void run() {
      try {
         if(Signlink.javaVendor != null) {
            String var1 = Signlink.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = Frames.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class2.method5(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(WorldMapType2.method509(var4) && GameObject.method2836(var4) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               field694 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method818();
         this.vmethod1149();
         ItemLayer.timer = class134.method2507();

         while(field706 == 0L || class157.currentTimeMs() < field706) {
            field692 = ItemLayer.timer.vmethod2910(field693, field694);

            for(int var5 = 0; var5 < field692; ++var5) {
               this.method816();
            }

            this.method831();
            this.method807(this.canvas);
         }
      } catch (Exception var6) {
         WorldMapType2.method495((String)null, var6);
         this.error("crash");
      }

      this.method825();
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void stop() {
      if(this == shell && !field690) {
         field706 = class157.currentTimeMs() + 4000L;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIILej;[Lfu;I)V",
      garbageValue = "-1871906161"
   )
   static final void method935(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
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

               class24.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(Lho;IIS)V",
      garbageValue = "-30908"
   )
   static final void method934(Widget var0, int var1, int var2) {
      if(Client.field1138 == 0 || Client.field1138 == 3) {
         if(MouseInput.field729 == 1 || !field699 && MouseInput.field729 == 4) {
            class210 var3 = var0.method3920(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.field737 - var1;
            int var5 = MouseInput.field723 - var2;
            if(var3.method3855(var4, var5)) {
               var4 -= var3.field2569 / 2;
               var5 -= var3.field2566 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var4 * var8 + var7 * var5 >> 11;
               int var10 = var8 * var5 - var7 * var4 >> 11;
               int var11 = var9 + class226.localPlayer.x >> 7;
               int var12 = class226.localPlayer.y - var10 >> 7;
               Client.secretPacketBuffer1.putOpcode(108);
               Client.secretPacketBuffer1.putByte(18);
               Client.secretPacketBuffer1.putShort(var11 + class21.baseX);
               Client.secretPacketBuffer1.putLEInt(var12 + class164.baseY);
               Client.secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?(KeyFocusListener.field636[81]?2:1):0);
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var5);
               Client.secretPacketBuffer1.putShort(Client.mapAngle);
               Client.secretPacketBuffer1.putByte(57);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(89);
               Client.secretPacketBuffer1.putShort(class226.localPlayer.x);
               Client.secretPacketBuffer1.putShort(class226.localPlayer.y);
               Client.secretPacketBuffer1.putByte(63);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }
}
