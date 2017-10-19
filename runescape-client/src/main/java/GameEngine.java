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

@ObfuscatedName("bv")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ah")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lbv;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("v")
   static boolean field708;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 93504255
   )
   @Export("canvasHeight")
   public static int canvasHeight;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2095621767
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -440489885027683771L
   )
   static long field707;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -236348169
   )
   static int field720;
   @ObfuscatedName("h")
   static long[] field716;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -606433009
   )
   static int field712;
   @ObfuscatedName("a")
   static long[] field714;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1030988915
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -371760561
   )
   static int field711;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1008644817
   )
   static int field727;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      longValue = 841659426504087423L
   )
   protected static long field709;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = -3267633387702766373L
   )
   protected static long field739;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 754722713
   )
   static int field710;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static BufferProvider field733;
   @ObfuscatedName("ad")
   Clipboard field735;
   @ObfuscatedName("am")
   final EventQueue field736;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   class49 field729;
   @ObfuscatedName("av")
   boolean field734;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2097892717
   )
   int field719;
   @ObfuscatedName("p")
   boolean field726;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1535961797
   )
   int field724;
   @ObfuscatedName("az")
   java.awt.Frame field713;
   @ObfuscatedName("at")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1807395557
   )
   int field723;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 257496041
   )
   protected int field717;
   @ObfuscatedName("ao")
   volatile boolean field728;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -285147299
   )
   int field725;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1416483249
   )
   int field715;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -816922807
   )
   protected int field718;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -352004321
   )
   int field722;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = -8351676792515152779L
   )
   volatile long field732;
   @ObfuscatedName("al")
   volatile boolean field731;

   static {
      shell = null;
      shellCount = 0;
      field707 = 0L;
      field708 = false;
      field720 = 20;
      field712 = 1;
      FPS = 0;
      field714 = new long[32];
      field716 = new long[32];
      field727 = 500;
      focused = true;
      field709 = -1L;
      field739 = -1L;
   }

   protected GameEngine() {
      this.field726 = false;
      this.field719 = 0;
      this.field723 = 0;
      this.field728 = true;
      this.field734 = false;
      this.field731 = false;
      this.field732 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field736 = var1;
      Script.method1895(new class51());
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1203647557"
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

   public final void destroy() {
      if(this == shell && !field708) {
         field707 = class174.currentTimeMs();
         class94.method1823(5000L);
         this.method856();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field708) {
         this.field728 = true;
         if(class174.currentTimeMs() - this.field732 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= Timer.canvasWidth && var2.height >= canvasHeight) {
               this.field731 = true;
            }
         }

      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)Ljx;",
      garbageValue = "-122"
   )
   class279 method857() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field715);
      int var3 = Math.max(var1.getHeight(), this.field722);
      if(this.field713 != null) {
         Insets var4 = this.field713.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new class279(var2, var3);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "-41"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field713 != null?this.field713:this);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "17083"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field726) {
         this.field726 = true;
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
      signature = "(I)V",
      garbageValue = "-1038975187"
   )
   final void method855() {
      this.field734 = true;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "83"
   )
   final synchronized void method849() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      Timer.canvasWidth = Math.max(var1.getWidth(), this.field715);
      canvasHeight = Math.max(var1.getHeight(), this.field722);
      Insets var2;
      if(this.field713 != null) {
         var2 = this.field713.getInsets();
         Timer.canvasWidth -= var2.left + var2.right;
         canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(Timer.canvasWidth, canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field713) {
         var2 = this.field713.getInsets();
         this.canvas.setLocation(this.field719 + var2.left, var2.top + this.field723);
      } else {
         this.canvas.setLocation(this.field719, this.field723);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field728 = true;
      if(field733 != null && Timer.canvasWidth == field733.width && canvasHeight == field733.height) {
         ((MainBufferProvider)field733).method819(this.canvas);
         field733.vmethod5121(0, 0);
      } else {
         field733 = new MainBufferProvider(Timer.canvasWidth, canvasHeight, this.canvas);
      }

      this.field731 = false;
      this.field732 = class174.currentTimeMs();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "827218284"
   )
   final synchronized void method856() {
      if(!field708) {
         field708 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1147();
         } catch (Exception var4) {
            ;
         }

         if(this.field713 != null) {
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

         this.vmethod1142();
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2049908648"
   )
   protected abstract void vmethod1147();

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2019327335"
   )
   final void method844() {
      Container var1 = this.container();
      if(var1 != null) {
         class279 var2 = this.method857();
         this.field717 = Math.max(var2.field3756, this.field715);
         this.field718 = Math.max(var2.field3754, this.field722);
         if(this.field717 <= 0) {
            this.field717 = 1;
         }

         if(this.field718 <= 0) {
            this.field718 = 1;
         }

         Timer.canvasWidth = Math.min(this.field717, this.field724);
         canvasHeight = Math.min(this.field718, this.field725);
         this.field719 = (this.field717 - Timer.canvasWidth) / 2;
         this.field723 = 0;
         this.canvas.setSize(Timer.canvasWidth, canvasHeight);
         field733 = new MainBufferProvider(Timer.canvasWidth, canvasHeight, this.canvas);
         if(var1 == this.field713) {
            Insets var3 = this.field713.getInsets();
            this.canvas.setLocation(var3.left + this.field719, var3.top + this.field723);
         } else {
            this.canvas.setLocation(this.field719, this.field723);
         }

         this.field728 = true;
         this.vmethod1264();
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1676674157"
   )
   protected abstract void vmethod1144();

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   protected final void method878() {
      Coordinates.field2603 = null;
      class261.field3631 = null;
      class41.field570 = null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1870455738"
   )
   protected abstract void vmethod1142();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1469163740"
   )
   protected final void method842() {
      class22.method168();
      class80.method1602(this.canvas);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-331319080"
   )
   protected final void method847() {
      class162.method3122(this.canvas);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1709088746"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lfh;",
      garbageValue = "-1375929117"
   )
   protected class156 method839() {
      if(this.field729 == null) {
         this.field729 = new class49();
         this.field729.method723(this.canvas);
      }

      return this.field729;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2105693965"
   )
   void method853() {
      Container var1 = this.container();
      long var2 = class174.currentTimeMs();
      long var4 = field714[field711];
      field714[field711] = var2;
      field711 = field711 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field727 - 1 > 50) {
         field727 -= 50;
         this.field728 = true;
         this.canvas.setSize(Timer.canvasWidth, canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field713) {
            Insets var7 = this.field713.getInsets();
            this.canvas.setLocation(this.field719 + var7.left, this.field723 + var7.top);
         } else {
            this.canvas.setLocation(this.field719, this.field723);
         }
      }

      if(this.field731) {
         this.method894();
      }

      this.method941();
      this.vmethod1146(this.field728);
      if(this.field728) {
         this.method846();
      }

      this.field728 = false;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "760961573"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class261.field3631 == null) {
            class261.field3631 = new java.awt.Font("Helvetica", 1, 13);
            class41.field570 = this.canvas.getFontMetrics(class261.field3631);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, Timer.canvasWidth, canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(Coordinates.field2603 == null) {
               Coordinates.field2603 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = Coordinates.field2603.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class261.field3631);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class41.field570.stringWidth(var2)) / 2, 22);
            var4.drawImage(Coordinates.field2603, Timer.canvasWidth / 2 - 152, canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = Timer.canvasWidth / 2 - 152;
            int var8 = canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class261.field3631);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class41.field570.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method908() {
      long var1 = class174.currentTimeMs();
      long var3 = field716[class22.field348];
      field716[class22.field348] = var1;
      class22.field348 = class22.field348 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         RSSocket.field2267 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-716692650"
   )
   final void method838(Object var1) {
      if(this.field736 != null) {
         for(int var2 = 0; var2 < 50 && this.field736.peekEvent() != null; ++var2) {
            class94.method1823(1L);
         }

         if(var1 != null) {
            this.field736.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "125"
   )
   protected void method840() {
      this.field735 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "93"
   )
   protected abstract void vmethod1264();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "115"
   )
   public final void method837(int var1, int var2) {
      if(this.field724 != var1 || var2 != this.field725) {
         this.method855();
      }

      this.field724 = var1;
      this.field725 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1829285095"
   )
   final void method894() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field662 = -1;
      GrandExchangeOffer.method112(this.canvas);
      if(this.field729 != null) {
         this.field729.method724(this.canvas);
      }

      this.method849();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      class162.method3122(this.canvas);
      if(this.field729 != null) {
         this.field729.method723(this.canvas);
      }

      this.method855();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "97"
   )
   final void method941() {
      class279 var1 = this.method857();
      if(var1.field3756 != this.field717 || var1.field3754 != this.field718 || this.field734) {
         this.method844();
         this.field734 = false;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "187"
   )
   protected abstract void vmethod1146(boolean var1);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-78"
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
         Timer.canvasWidth = var1;
         canvasHeight = var2;
         SoundTask.revision = var3;
         class152.field2213 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class46.method680((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "782300175"
   )
   void method846() {
      int var1 = this.field719;
      int var2 = this.field723;
      int var3 = this.field717 - Timer.canvasWidth - var1;
      int var4 = this.field718 - canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field713) {
               Insets var8 = this.field713.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field718);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field717, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field717 - var3, var7, var3, this.field718);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field718 - var4, this.field717, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-49"
   )
   protected void method910(String var1) {
      this.field735.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "30167"
   )
   protected final boolean method927() {
      return this.field713 != null;
   }

   public final void start() {
      if(this == shell && !field708) {
         field707 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field708) {
         field707 = class174.currentTimeMs() + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
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

   public final void windowIconified(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field728 = true;
   }

   public abstract void init();

   public void run() {
      try {
         if(Signlink.javaVendor != null) {
            String var1 = Signlink.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class18.javaVersion;
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

                  String var14 = var2.substring(6, var3);
                  boolean var7 = false;
                  boolean var8 = false;
                  int var9 = 0;
                  int var10 = var14.length();
                  int var11 = 0;

                  boolean var6;
                  while(true) {
                     if(var11 >= var10) {
                        var6 = var8;
                        break;
                     }

                     label175: {
                        char var12 = var14.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == '-') {
                              var7 = true;
                              break label175;
                           }

                           if(var12 == '+') {
                              break label175;
                           }
                        }

                        int var18;
                        if(var12 >= '0' && var12 <= '9') {
                           var18 = var12 - '0';
                        } else if(var12 >= 'A' && var12 <= 'Z') {
                           var18 = var12 - '7';
                        } else {
                           if(var12 < 'a' || var12 > 'z') {
                              var6 = false;
                              break;
                           }

                           var18 = var12 - 'W';
                        }

                        if(var18 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var18 = -var18;
                        }

                        int var13 = var18 + var9 * 10;
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
                     int var17 = MilliTimer.parseInt(var14, 10, true);
                     if(var17 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field712 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method849();
         this.vmethod1144();
         DynamicObject.timer = ScriptEvent.method1090();

         while(0L == field707 || class174.currentTimeMs() < field707) {
            field710 = DynamicObject.timer.vmethod3025(field720, field712);

            for(int var15 = 0; var15 < field710; ++var15) {
               this.method908();
            }

            this.method853();
            this.method838(this.canvas);
         }
      } catch (Exception var16) {
         class46.method680((String)null, var16);
         this.error("crash");
      }

      this.method856();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "1578493865"
   )
   public static Object method934(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.field2410) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.field2410 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1883123"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = GraphicsObject.getSmoothNoise2D(var3, var5);
      int var8 = GraphicsObject.getSmoothNoise2D(var3 + 1, var5);
      int var9 = GraphicsObject.getSmoothNoise2D(var3, var5 + 1);
      int var10 = GraphicsObject.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var11 = DecorativeObject.method2922(var7, var8, var4, var2);
      int var12 = DecorativeObject.method2922(var9, var10, var4, var2);
      return DecorativeObject.method2922(var11, var12, var6, var2);
   }
}
