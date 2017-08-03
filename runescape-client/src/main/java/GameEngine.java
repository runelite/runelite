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
   @ObfuscatedName("aa")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lbh;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("v")
   static boolean field673;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2147411719
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 3152307150423251591L
   )
   static long field665;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1581130635
   )
   static int field669;
   @ObfuscatedName("k")
   static long[] field680;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 345101669
   )
   static int field683;
   @ObfuscatedName("u")
   static long[] field672;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("taskManager")
   public static Signlink taskManager;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 83957495
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1607966183
   )
   static int field685;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      longValue = -1956997707606046359L
   )
   static long field693;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      longValue = -4796925479707067463L
   )
   static long field694;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1046505585
   )
   static int field666;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -1569382465
   )
   static int field695;
   @ObfuscatedName("an")
   Clipboard field667;
   @ObfuscatedName("af")
   final EventQueue field691;
   @ObfuscatedName("ah")
   boolean field681;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 648528761
   )
   int field686;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   class49 field689;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 27024451
   )
   int field690;
   @ObfuscatedName("t")
   boolean field688;
   @ObfuscatedName("ar")
   java.awt.Frame field682;
   @ObfuscatedName("ae")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 606951697
   )
   int field677;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1841090293
   )
   int field668;
   @ObfuscatedName("ai")
   volatile boolean field684;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 541747717
   )
   protected int field674;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2050933255
   )
   int field678;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 307519953
   )
   protected int field675;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1002001359
   )
   int field679;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      longValue = 1678317487982997265L
   )
   volatile long field662;
   @ObfuscatedName("ao")
   volatile boolean field687;

   static {
      shell = null;
      shellCount = 0;
      field665 = 0L;
      field673 = false;
      field669 = 20;
      field683 = 1;
      FPS = 0;
      field672 = new long[32];
      field680 = new long[32];
      field685 = 500;
      focused = true;
      field693 = -1L;
      field694 = -1L;
   }

   protected GameEngine() {
      this.field688 = false;
      this.field690 = 0;
      this.field677 = 0;
      this.field684 = true;
      this.field681 = false;
      this.field687 = false;
      this.field662 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field691 = var1;
      RSSocket.method3041(new class51());
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1666028542"
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
      if(this == shell && !field673) {
         field665 = BuildType.currentTimeMs();
         GroundObject.method2492(5000L);
         this.method893();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field673) {
         this.field684 = true;
         if(BuildType.currentTimeMs() - this.field662 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class31.canvasWidth && var2.height >= class67.canvasHeight) {
               this.field687 = true;
            }
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Ljg;",
      garbageValue = "1668284111"
   )
   class278 method887() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field678);
      int var3 = Math.max(var1.getHeight(), this.field679);
      if(this.field682 != null) {
         Insets var4 = this.field682.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new class278(var2, var3);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "1738272736"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field682 != null?this.field682:this);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1681302650"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field688) {
         this.field688 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-450761278"
   )
   final void method1006() {
      this.field681 = true;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2122273276"
   )
   final synchronized void method865() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class31.canvasWidth = Math.max(var1.getWidth(), this.field678);
      class67.canvasHeight = Math.max(var1.getHeight(), this.field679);
      Insets var2;
      if(this.field682 != null) {
         var2 = this.field682.getInsets();
         class31.canvasWidth -= var2.right + var2.left;
         class67.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class31.canvasWidth, class67.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field682) {
         var2 = this.field682.getInsets();
         this.canvas.setLocation(var2.left + this.field690, var2.top + this.field677);
      } else {
         this.canvas.setLocation(this.field690, this.field677);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field684 = true;
      if(class48.field582 != null && class31.canvasWidth == class48.field582.width && class67.canvasHeight == class48.field582.height) {
         ((MainBufferProvider)class48.field582).method847(this.canvas);
         class48.field582.vmethod5019(0, 0);
      } else {
         class48.field582 = new MainBufferProvider(class31.canvasWidth, class67.canvasHeight, this.canvas);
      }

      this.field687 = false;
      this.field662 = BuildType.currentTimeMs();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1937508617"
   )
   protected abstract void vmethod1179();

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2088527207"
   )
   protected abstract void vmethod1176();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1224177730"
   )
   final void method975() {
      Container var1 = this.container();
      if(var1 != null) {
         class278 var2 = this.method887();
         this.field674 = Math.max(var2.field3726, this.field678);
         this.field675 = Math.max(var2.field3725, this.field679);
         if(this.field674 <= 0) {
            this.field674 = 1;
         }

         if(this.field675 <= 0) {
            this.field675 = 1;
         }

         class31.canvasWidth = Math.min(this.field674, this.field686);
         class67.canvasHeight = Math.min(this.field675, this.field668);
         this.field690 = (this.field674 - class31.canvasWidth) / 2;
         this.field677 = 0;
         this.canvas.setSize(class31.canvasWidth, class67.canvasHeight);
         class48.field582 = new MainBufferProvider(class31.canvasWidth, class67.canvasHeight, this.canvas);
         if(var1 == this.field682) {
            Insets var3 = this.field682.getInsets();
            this.canvas.setLocation(var3.left + this.field690, var3.top + this.field677);
         } else {
            this.canvas.setLocation(this.field690, this.field677);
         }

         this.field684 = true;
         this.vmethod1402();
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   final synchronized void method893() {
      if(!field673) {
         field673 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1179();
         } catch (Exception var4) {
            ;
         }

         if(this.field682 != null) {
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

         this.vmethod1174();
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "75"
   )
   protected final void method884() {
      WorldListFetcher.field1188 = null;
      WallObject.field2094 = null;
      class276.field3723 = null;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   protected abstract void vmethod1174();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-892616774"
   )
   protected final void method859() {
      class22.method160();
      class90.method1719(this.canvas);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   protected final void method996() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Lfm;",
      garbageValue = "-93"
   )
   protected class156 method986() {
      if(this.field689 == null) {
         this.field689 = new class49();
         this.field689.method746(this.canvas);
      }

      return this.field689;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-905267502"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method867() {
      Container var1 = this.container();
      long var2 = BuildType.currentTimeMs();
      long var4 = field672[class17.field299];
      field672[class17.field299] = var2;
      class17.field299 = class17.field299 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field685 - 1 > 50) {
         field685 -= 50;
         this.field684 = true;
         this.canvas.setSize(class31.canvasWidth, class67.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field682) {
            Insets var7 = this.field682.getInsets();
            this.canvas.setLocation(var7.left + this.field690, this.field677 + var7.top);
         } else {
            this.canvas.setLocation(this.field690, this.field677);
         }
      }

      if(this.field687) {
         this.method937();
      }

      this.method868();
      this.vmethod1178(this.field684);
      if(this.field684) {
         this.method973();
      }

      this.field684 = false;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "16"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(WallObject.field2094 == null) {
            WallObject.field2094 = new java.awt.Font("Helvetica", 1, 13);
            class276.field3723 = this.canvas.getFontMetrics(WallObject.field2094);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class31.canvasWidth, class67.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(WorldListFetcher.field1188 == null) {
               WorldListFetcher.field1188 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = WorldListFetcher.field1188.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(WallObject.field2094);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class276.field3723.stringWidth(var2)) / 2, 22);
            var4.drawImage(WorldListFetcher.field1188, class31.canvasWidth / 2 - 152, class67.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class31.canvasWidth / 2 - 152;
            int var8 = class67.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + 2 + var1 * 3, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(WallObject.field2094);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class276.field3723.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "386711709"
   )
   void method957() {
      long var1 = BuildType.currentTimeMs();
      long var3 = field680[IndexFile.field2255];
      field680[IndexFile.field2255] = var1;
      IndexFile.field2255 = IndexFile.field2255 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class175.field2380 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-1986845786"
   )
   final void method855(Object var1) {
      if(this.field691 != null) {
         for(int var2 = 0; var2 < 50 && this.field691.peekEvent() != null; ++var2) {
            GroundObject.method2492(1L);
         }

         if(var1 != null) {
            this.field691.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-545139639"
   )
   protected void method899() {
      this.field667 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1865712798"
   )
   protected abstract void vmethod1402();

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "5"
   )
   protected final void method951(int var1, int var2) {
      if(this.field686 != var1 || var2 != this.field668) {
         this.method1006();
      }

      this.field686 = var1;
      this.field668 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1569234523"
   )
   final void method937() {
      class215.method4000(this.canvas);
      KeyFocusListener.method786(this.canvas);
      if(this.field689 != null) {
         this.field689.method747(this.canvas);
      }

      this.method865();
      class90.method1719(this.canvas);
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
      if(this.field689 != null) {
         this.field689.method746(this.canvas);
      }

      this.method1006();
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-32"
   )
   final void method868() {
      class278 var1 = this.method887();
      if(var1.field3726 != this.field674 || var1.field3725 != this.field675 || this.field681) {
         this.method975();
         this.field681 = false;
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "4"
   )
   protected abstract void vmethod1178(boolean var1);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-317478452"
   )
   void method973() {
      int var1 = this.field690;
      int var2 = this.field677;
      int var3 = this.field674 - class31.canvasWidth - var1;
      int var4 = this.field675 - class67.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field682) {
               Insets var8 = this.field682.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field675);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field674, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field674 - var3, var7, var3, this.field675);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field675 - var4, this.field674, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-86"
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
         class31.canvasWidth = var1;
         class67.canvasHeight = var2;
         class152.revision = var3;
         class152.field2193 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class23.method165((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-63"
   )
   protected void method858(String var1) {
      this.field667.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1391721796"
   )
   protected final boolean method888() {
      return this.field682 != null;
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
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
                  for(var3 = 6; var3 < var2.length() && IndexFile.method3055(var2.charAt(var3)); ++var3) {
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

                     label164: {
                        char var12 = var4.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == 45) {
                              var7 = true;
                              break label164;
                           }

                           if(var12 == 43) {
                              break label164;
                           }
                        }

                        int var17;
                        if(var12 >= 48 && var12 <= 57) {
                           var17 = var12 - 48;
                        } else if(var12 >= 65 && var12 <= 90) {
                           var17 = var12 - 55;
                        } else {
                           if(var12 < 97 || var12 > 122) {
                              var6 = false;
                              break;
                           }

                           var17 = var12 - 87;
                        }

                        if(var17 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var17 = -var17;
                        }

                        int var13 = var9 * 10 + var17;
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
                     int var16 = Timer.parseInt(var4, 10, true);
                     if(var16 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field683 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method865();
         this.vmethod1176();
         WidgetNode.timer = class118.method2191();

         while(0L == field665 || BuildType.currentTimeMs() < field665) {
            field666 = WidgetNode.timer.vmethod3006(field669, field683);

            for(int var14 = 0; var14 < field666; ++var14) {
               this.method957();
            }

            this.method867();
            this.method855(this.canvas);
         }
      } catch (Exception var15) {
         class23.method165((String)null, var15);
         this.error("crash");
      }

      this.method893();
   }

   public final void stop() {
      if(this == shell && !field673) {
         field665 = BuildType.currentTimeMs() + 4000L;
      }
   }

   public final void start() {
      if(this == shell && !field673) {
         field665 = 0L;
      }
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field684 = true;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "599906717"
   )
   static void method1007() {
      class62.field735 = 99;
      class62.underlayIds = new byte[4][104][104];
      class62.overlayIds = new byte[4][104][104];
      FileSystem.overlayPaths = new byte[4][104][104];
      class62.overlayRotations = new byte[4][104][104];
      class62.field742 = new int[4][105][105];
      class62.field739 = new byte[4][105][105];
      class62.field740 = new int[105][105];
      class62.blendedHue = new int[104];
      class48.blendedSaturation = new int[104];
      Friend.field779 = new int[104];
      class118.field1673 = new int[104];
      class54.field641 = new int[104];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-2038527990"
   )
   static int method854(int var0, Script var1, boolean var2) {
      Widget var3 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
      if(var0 == 2800) {
         class83.intStack[++class83.intStackSize - 1] = MilliTimer.method2938(class169.getWidgetConfig(var3));
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class83.intStack[--class83.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
