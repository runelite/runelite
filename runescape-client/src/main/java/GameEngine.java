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

@ObfuscatedName("bh")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ad")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lbh;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("g")
   static boolean field705;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -188601191
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1185559749
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 6378217584274992765L
   )
   static long field692;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1263536641
   )
   static int field696;
   @ObfuscatedName("a")
   protected static long[] field701;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1875119609
   )
   static int field697;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("r")
   protected static long[] field700;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1758101963
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 282932951
   )
   static int field718;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 472471465
   )
   protected static int field695;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      longValue = -7775234959810864483L
   )
   static long field722;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = -5862677496361708935L
   )
   static long field723;
   @ObfuscatedName("ah")
   Clipboard field719;
   @ObfuscatedName("ap")
   final EventQueue field720;
   @ObfuscatedName("as")
   boolean field712;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "Lak;"
   )
   class49 field716;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1172344705
   )
   int field708;
   @ObfuscatedName("c")
   boolean field694;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -653132163
   )
   int field689;
   @ObfuscatedName("av")
   java.awt.Frame field711;
   @ObfuscatedName("ab")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -303972721
   )
   int field704;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1859619517
   )
   protected int field713;
   @ObfuscatedName("aj")
   volatile boolean field715;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1004484489
   )
   int field710;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -279389843
   )
   int field707;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -837262167
   )
   protected int field702;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1600113377
   )
   int field714;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      longValue = -1079391673244757773L
   )
   volatile long field717;
   @ObfuscatedName("af")
   volatile boolean field706;

   static {
      shell = null;
      shellCount = 0;
      field692 = 0L;
      field705 = false;
      field696 = 20;
      field697 = 1;
      FPS = 0;
      field700 = new long[32];
      field701 = new long[32];
      field718 = 500;
      focused = true;
      field722 = -1L;
      field723 = -1L;
   }

   protected GameEngine() {
      this.field694 = false;
      this.field708 = 0;
      this.field704 = 0;
      this.field715 = true;
      this.field712 = false;
      this.field706 = false;
      this.field717 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field720 = var1;
      class262.method4758(new class51());
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "149988327"
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

   public final void destroy() {
      if(this == shell && !field705) {
         field692 = class74.currentTimeMs();
         class10.method51(5000L);
         this.method922();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field705) {
         this.field715 = true;
         if(class74.currentTimeMs() - this.field717 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= canvasWidth && var2.height >= class1.canvasHeight) {
               this.field706 = true;
            }
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)Lju;",
      garbageValue = "32"
   )
   class279 method918() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field707);
      int var3 = Math.max(var1.getHeight(), this.field714);
      if(this.field711 != null) {
         Insets var4 = this.field711.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new class279(var2, var3);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "127"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field711 != null?this.field711:this);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "429484105"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field694) {
         this.field694 = true;
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
      signature = "(I)V",
      garbageValue = "-1862440558"
   )
   final void method992() {
      this.field712 = true;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1854007766"
   )
   final synchronized void method899() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      canvasWidth = Math.max(var1.getWidth(), this.field707);
      class1.canvasHeight = Math.max(var1.getHeight(), this.field714);
      Insets var2;
      if(this.field711 != null) {
         var2 = this.field711.getInsets();
         canvasWidth -= var2.left + var2.right;
         class1.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(canvasWidth, class1.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field711) {
         var2 = this.field711.getInsets();
         this.canvas.setLocation(var2.left + this.field708, this.field704 + var2.top);
      } else {
         this.canvas.setLocation(this.field708, this.field704);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field715 = true;
      if(IndexFile.field2286 != null && canvasWidth == IndexFile.field2286.width && class1.canvasHeight == IndexFile.field2286.height) {
         ((MainBufferProvider)IndexFile.field2286).method871(this.canvas);
         IndexFile.field2286.vmethod5043(0, 0);
      } else {
         IndexFile.field2286 = new MainBufferProvider(canvasWidth, class1.canvasHeight, this.canvas);
      }

      this.field706 = false;
      this.field717 = class74.currentTimeMs();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   final synchronized void method922() {
      if(!field705) {
         field705 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1399();
         } catch (Exception var4) {
            ;
         }

         if(this.field711 != null) {
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

         this.vmethod1219();
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-893701307"
   )
   protected abstract void vmethod1399();

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1833788586"
   )
   protected abstract void vmethod1272();

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-95"
   )
   final void method947() {
      Container var1 = this.container();
      if(var1 != null) {
         class279 var2 = this.method918();
         this.field713 = Math.max(var2.field3726, this.field707);
         this.field702 = Math.max(var2.field3727, this.field714);
         if(this.field713 <= 0) {
            this.field713 = 1;
         }

         if(this.field702 <= 0) {
            this.field702 = 1;
         }

         canvasWidth = Math.min(this.field713, this.field689);
         class1.canvasHeight = Math.min(this.field702, this.field710);
         this.field708 = (this.field713 - canvasWidth) / 2;
         this.field704 = 0;
         this.canvas.setSize(canvasWidth, class1.canvasHeight);
         IndexFile.field2286 = new MainBufferProvider(canvasWidth, class1.canvasHeight, this.canvas);
         if(var1 == this.field711) {
            Insets var3 = this.field711.getInsets();
            this.canvas.setLocation(this.field708 + var3.left, var3.top + this.field704);
         } else {
            this.canvas.setLocation(this.field708, this.field704);
         }

         this.field715 = true;
         this.vmethod1211();
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "381096602"
   )
   protected final void method915() {
      class41.field563 = null;
      IndexFile.field2289 = null;
      AbstractSoundSystem.field1648 = null;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-109"
   )
   protected abstract void vmethod1219();

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "90"
   )
   void method1022() {
      long var1 = class74.currentTimeMs();
      long var3 = field701[KitDefinition.field3346];
      field701[KitDefinition.field3346] = var1;
      KitDefinition.field3346 = KitDefinition.field3346 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         Area.field3297 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-62"
   )
   protected final void method928() {
      class11.method53();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1050897931"
   )
   protected final void method1003() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1954258505"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Lfz;",
      garbageValue = "519442291"
   )
   protected class157 method905() {
      if(this.field716 == null) {
         this.field716 = new class49();
         this.field716.method770(this.canvas);
      }

      return this.field716;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "1813181145"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(IndexFile.field2289 == null) {
            IndexFile.field2289 = new java.awt.Font("Helvetica", 1, 13);
            AbstractSoundSystem.field1648 = this.canvas.getFontMetrics(IndexFile.field2289);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, canvasWidth, class1.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class41.field563 == null) {
               class41.field563 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class41.field563.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(IndexFile.field2289);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - AbstractSoundSystem.field1648.stringWidth(var2)) / 2, 22);
            var4.drawImage(class41.field563, canvasWidth / 2 - 152, class1.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = canvasWidth / 2 - 152;
            int var8 = class1.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(IndexFile.field2289);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - AbstractSoundSystem.field1648.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-673372222"
   )
   void method938() {
      Container var1 = this.container();
      long var2 = class74.currentTimeMs();
      long var4 = field700[class12.field267];
      field700[class12.field267] = var2;
      class12.field267 = class12.field267 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field718 - 1 > 50) {
         field718 -= 50;
         this.field715 = true;
         this.canvas.setSize(canvasWidth, class1.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field711) {
            Insets var7 = this.field711.getInsets();
            this.canvas.setLocation(var7.left + this.field708, this.field704 + var7.top);
         } else {
            this.canvas.setLocation(this.field708, this.field704);
         }
      }

      if(this.field706) {
         this.method897();
      }

      this.method909();
      this.vmethod1214(this.field715);
      if(this.field715) {
         this.method896();
      }

      this.field715 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-430276522"
   )
   final void method889(Object var1) {
      if(this.field720 != null) {
         for(int var2 = 0; var2 < 50 && this.field720.peekEvent() != null; ++var2) {
            class10.method51(1L);
         }

         if(var1 != null) {
            this.field720.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "19"
   )
   protected void method914() {
      this.field719 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1350835066"
   )
   public final void method888(int var1, int var2) {
      if(this.field689 != var1 || var2 != this.field710) {
         this.method992();
      }

      this.field689 = var1;
      this.field710 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   protected abstract void vmethod1211();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2114847263"
   )
   final void method897() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field645 = -1;
      MouseInput.method1065(this.canvas);
      if(this.field716 != null) {
         this.field716.method771(this.canvas);
      }

      this.method899();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      Canvas var3 = this.canvas;
      var3.addMouseListener(MouseInput.mouse);
      var3.addMouseMotionListener(MouseInput.mouse);
      var3.addFocusListener(MouseInput.mouse);
      if(this.field716 != null) {
         this.field716.method770(this.canvas);
      }

      this.method992();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1312552718"
   )
   final void method909() {
      class279 var1 = this.method918();
      if(this.field713 != var1.field3726 || var1.field3727 != this.field702 || this.field712) {
         this.method947();
         this.field712 = false;
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "758013495"
   )
   protected abstract void vmethod1214(boolean var1);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-966075394"
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
         canvasWidth = var1;
         class1.canvasHeight = var2;
         class91.revision = var3;
         class153.field2224 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         Varcs.method1853((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1304896530"
   )
   void method896() {
      int var1 = this.field708;
      int var2 = this.field704;
      int var3 = this.field713 - canvasWidth - var1;
      int var4 = this.field702 - class1.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field711) {
               Insets var8 = this.field711.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field702);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field713, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field713 - var3, var7, var3, this.field702);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field702 - var4, this.field713, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "188489950"
   )
   protected final boolean method993() {
      return this.field711 != null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1741261401"
   )
   protected void method892(String var1) {
      this.field719.setContents(new StringSelection(var1), (ClipboardOwner)null);
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
                     boolean var4 = var5 >= 48 && var5 <= 57;
                     if(!var4) {
                        break;
                     }
                  }

                  String var6 = var2.substring(6, var3);
                  if(class141.method2889(var6)) {
                     int var11 = class19.parseInt(var6, 10, true);
                     if(var11 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field697 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method899();
         this.vmethod1272();

         Object var10;
         try {
            var10 = new NanoTimer();
         } catch (Throwable var8) {
            var10 = new MilliTimer();
         }

         timer = (Timer)var10;

         while(0L == field692 || class74.currentTimeMs() < field692) {
            field695 = timer.vmethod3004(field696, field697);

            for(int var7 = 0; var7 < field695; ++var7) {
               this.method1022();
            }

            this.method938();
            this.method889(this.canvas);
         }
      } catch (Exception var9) {
         Varcs.method1853((String)null, var9);
         this.error("crash");
      }

      this.method922();
   }

   public final void start() {
      if(this == shell && !field705) {
         field692 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field705) {
         field692 = class74.currentTimeMs() + 4000L;
      }
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field715 = true;
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

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-56"
   )
   static void method1029() {
      for(class82 var0 = (class82)class82.field1330.getFront(); var0 != null; var0 = (class82)class82.field1330.getNext()) {
         if(var0.field1329 != null) {
            var0.method1599();
         }
      }

   }
}
