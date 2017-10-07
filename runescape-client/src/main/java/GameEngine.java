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

@ObfuscatedName("bn")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("at")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("q")
   static boolean field706;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1255819963
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("ab")
   static java.awt.Font field721;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -4765958493616511455L
   )
   static long field705;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1084744247
   )
   static int field708;
   @ObfuscatedName("f")
   static long[] field731;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -628188009
   )
   static int field709;
   @ObfuscatedName("u")
   static long[] field711;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1090364569
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("dp")
   @Export("host")
   static String host;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -343020981
   )
   static int field725;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = 6258036197809285445L
   )
   protected static long field730;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      longValue = 1067740428391119093L
   )
   protected static long field724;
   @ObfuscatedName("ap")
   Clipboard field715;
   @ObfuscatedName("ao")
   final EventQueue field735;
   @ObfuscatedName("az")
   boolean field716;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   class49 field729;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1790369061
   )
   int field719;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2024848497
   )
   int field733;
   @ObfuscatedName("s")
   boolean field704;
   @ObfuscatedName("ag")
   java.awt.Frame field722;
   @ObfuscatedName("as")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -758600609
   )
   int field723;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 945051901
   )
   int field720;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1535515847
   )
   protected int field713;
   @ObfuscatedName("af")
   volatile boolean field712;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -723067801
   )
   int field717;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1848242421
   )
   protected int field714;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1005227665
   )
   int field707;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = 4031958542116410779L
   )
   volatile long field728;
   @ObfuscatedName("av")
   volatile boolean field727;

   static {
      shell = null;
      shellCount = 0;
      field705 = 0L;
      field706 = false;
      field708 = 20;
      field709 = 1;
      FPS = 0;
      field711 = new long[32];
      field731 = new long[32];
      field725 = 500;
      focused = true;
      field730 = -1L;
      field724 = -1L;
   }

   protected GameEngine() {
      this.field704 = false;
      this.field733 = 0;
      this.field723 = 0;
      this.field712 = true;
      this.field716 = false;
      this.field727 = false;
      this.field728 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field735 = var1;
      class51 var2 = new class51();
      AbstractSoundSystem.field1614 = var2;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "22"
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
      if(this == shell && !field706) {
         field705 = class147.currentTimeMs();
         class211.method4044(5000L);
         this.method911();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field706) {
         this.field712 = true;
         if(class147.currentTimeMs() - this.field728 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class60.canvasWidth && var2.height >= class48.canvasHeight) {
               this.field727 = true;
            }
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)Ljt;",
      garbageValue = "-776741737"
   )
   class279 method936() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field717);
      int var3 = Math.max(var1.getHeight(), this.field707);
      if(this.field722 != null) {
         Insets var4 = this.field722.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new class279(var2, var3);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1737020506"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field722 != null?this.field722:this);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1387549247"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field704) {
         this.field704 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "247876066"
   )
   final void method889() {
      this.field716 = true;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1467952432"
   )
   final synchronized void method1014() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class60.canvasWidth = Math.max(var1.getWidth(), this.field717);
      class48.canvasHeight = Math.max(var1.getHeight(), this.field707);
      Insets var2;
      if(this.field722 != null) {
         var2 = this.field722.getInsets();
         class60.canvasWidth -= var2.left + var2.right;
         class48.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class60.canvasWidth, class48.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field722) {
         var2 = this.field722.getInsets();
         this.canvas.setLocation(var2.left + this.field733, this.field723 + var2.top);
      } else {
         this.canvas.setLocation(this.field733, this.field723);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field712 = true;
      if(class12.field275 != null && class60.canvasWidth == class12.field275.width && class48.canvasHeight == class12.field275.height) {
         ((MainBufferProvider)class12.field275).method853(this.canvas);
         class12.field275.vmethod5136(0, 0);
      } else {
         class12.field275 = new MainBufferProvider(class60.canvasWidth, class48.canvasHeight, this.canvas);
      }

      this.field727 = false;
      this.field728 = class147.currentTimeMs();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1788862010"
   )
   final synchronized void method911() {
      if(!field706) {
         field706 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1206();
         } catch (Exception var4) {
            ;
         }

         if(this.field722 != null) {
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

         this.vmethod1200();
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "506800678"
   )
   protected abstract void vmethod1206();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   final void method878() {
      Container var1 = this.container();
      if(var1 != null) {
         class279 var2 = this.method936();
         this.field713 = Math.max(var2.field3754, this.field717);
         this.field714 = Math.max(var2.field3755, this.field707);
         if(this.field713 <= 0) {
            this.field713 = 1;
         }

         if(this.field714 <= 0) {
            this.field714 = 1;
         }

         class60.canvasWidth = Math.min(this.field713, this.field719);
         class48.canvasHeight = Math.min(this.field714, this.field720);
         this.field733 = (this.field713 - class60.canvasWidth) / 2;
         this.field723 = 0;
         this.canvas.setSize(class60.canvasWidth, class48.canvasHeight);
         class12.field275 = new MainBufferProvider(class60.canvasWidth, class48.canvasHeight, this.canvas);
         if(var1 == this.field722) {
            Insets var3 = this.field722.getInsets();
            this.canvas.setLocation(var3.left + this.field733, var3.top + this.field723);
         } else {
            this.canvas.setLocation(this.field733, this.field723);
         }

         this.field712 = true;
         this.vmethod1211();
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1633753465"
   )
   protected abstract void vmethod1203();

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1242218194"
   )
   protected final void method900() {
      class48.field637 = null;
      field721 = null;
      class170.field2360 = null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "65"
   )
   protected abstract void vmethod1200();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "481093501"
   )
   protected final void method877() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field667[186] = 57;
         KeyFocusListener.field667[187] = 27;
         KeyFocusListener.field667[188] = 71;
         KeyFocusListener.field667[189] = 26;
         KeyFocusListener.field667[190] = 72;
         KeyFocusListener.field667[191] = 73;
         KeyFocusListener.field667[192] = 58;
         KeyFocusListener.field667[219] = 42;
         KeyFocusListener.field667[220] = 74;
         KeyFocusListener.field667[221] = 43;
         KeyFocusListener.field667[222] = 59;
         KeyFocusListener.field667[223] = 28;
      } else {
         KeyFocusListener.field667[44] = 71;
         KeyFocusListener.field667[45] = 26;
         KeyFocusListener.field667[46] = 72;
         KeyFocusListener.field667[47] = 73;
         KeyFocusListener.field667[59] = 57;
         KeyFocusListener.field667[61] = 27;
         KeyFocusListener.field667[91] = 42;
         KeyFocusListener.field667[92] = 74;
         KeyFocusListener.field667[93] = 43;
         KeyFocusListener.field667[192] = 28;
         KeyFocusListener.field667[222] = 58;
         KeyFocusListener.field667[520] = 59;
      }

      class249.method4518(this.canvas);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "791318295"
   )
   protected final void method924() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1234976950"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lfb;",
      garbageValue = "1601599846"
   )
   protected class156 method945() {
      if(this.field729 == null) {
         this.field729 = new class49();
         this.field729.method751(this.canvas);
      }

      return this.field729;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "255"
   )
   void method887() {
      Container var1 = this.container();
      long var2 = class147.currentTimeMs();
      long var4 = field711[class251.field3391];
      field711[class251.field3391] = var2;
      class251.field3391 = class251.field3391 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field725 - 1 > 50) {
         field725 -= 50;
         this.field712 = true;
         this.canvas.setSize(class60.canvasWidth, class48.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field722) {
            Insets var7 = this.field722.getInsets();
            this.canvas.setLocation(var7.left + this.field733, this.field723 + var7.top);
         } else {
            this.canvas.setLocation(this.field733, this.field723);
         }
      }

      if(this.field727) {
         this.method882();
      }

      this.method888();
      this.vmethod1205(this.field712);
      if(this.field712) {
         this.method871();
      }

      this.field712 = false;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1862313313"
   )
   void method1013() {
      long var1 = class147.currentTimeMs();
      long var3 = field731[WorldMapType3.field397];
      field731[WorldMapType3.field397] = var1;
      WorldMapType3.field397 = WorldMapType3.field397 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class43.field595 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "87513541"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(field721 == null) {
            field721 = new java.awt.Font("Helvetica", 1, 13);
            class170.field2360 = this.canvas.getFontMetrics(field721);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class60.canvasWidth, class48.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class48.field637 == null) {
               class48.field637 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class48.field637.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(field721);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class170.field2360.stringWidth(var2)) / 2, 22);
            var4.drawImage(class48.field637, class60.canvasWidth / 2 - 152, class48.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class60.canvasWidth / 2 - 152;
            int var8 = class48.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(field721);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class170.field2360.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "1078306525"
   )
   final void method873(Object var1) {
      if(this.field735 != null) {
         for(int var2 = 0; var2 < 50 && this.field735.peekEvent() != null; ++var2) {
            class211.method4044(1L);
         }

         if(var1 != null) {
            this.field735.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "141685774"
   )
   protected void method875() {
      this.field715 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2051276775"
   )
   protected abstract void vmethod1211();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2072258373"
   )
   protected final void method872(int var1, int var2) {
      if(this.field719 != var1 || var2 != this.field720) {
         this.method889();
      }

      this.field719 = var1;
      this.field720 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-846087261"
   )
   final void method882() {
      class81.method1724(this.canvas);
      Canvas var1 = this.canvas;
      var1.removeMouseListener(MouseInput.mouse);
      var1.removeMouseMotionListener(MouseInput.mouse);
      var1.removeFocusListener(MouseInput.mouse);
      MouseInput.field740 = 0;
      if(this.field729 != null) {
         this.field729.method764(this.canvas);
      }

      this.method1014();
      class249.method4518(this.canvas);
      class45.method652(this.canvas);
      if(this.field729 != null) {
         this.field729.method751(this.canvas);
      }

      this.method889();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-4972"
   )
   final void method888() {
      class279 var1 = this.method936();
      if(var1.field3754 != this.field713 || this.field714 != var1.field3755 || this.field716) {
         this.method878();
         this.field716 = false;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-87"
   )
   protected abstract void vmethod1205(boolean var1);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "4"
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
         class60.canvasWidth = var1;
         class48.canvasHeight = var2;
         class152.revision = var3;
         class152.field2230 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         DynamicObject.method1932((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "615406147"
   )
   void method871() {
      int var1 = this.field733;
      int var2 = this.field723;
      int var3 = this.field713 - class60.canvasWidth - var1;
      int var4 = this.field714 - class48.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field722) {
               Insets var8 = this.field722.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field714);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field713, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field713 - var3, var7, var3, this.field714);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field714 - var4, this.field713, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1641449030"
   )
   protected void method876(String var1) {
      this.field715.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2084525605"
   )
   protected final boolean method904() {
      return this.field722 != null;
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
                  if(class224.method4196(var6)) {
                     int var9 = class41.parseInt(var6, 10, true);
                     if(var9 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field709 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method1014();
         this.vmethod1203();
         class114.timer = class21.method151();

         while(0L == field705 || class147.currentTimeMs() < field705) {
            class56.field697 = class114.timer.vmethod3061(field708, field709);

            for(int var7 = 0; var7 < class56.field697; ++var7) {
               this.method1013();
            }

            this.method887();
            this.method873(this.canvas);
         }
      } catch (Exception var8) {
         DynamicObject.method1932((String)null, var8);
         this.error("crash");
      }

      this.method911();
   }

   public final void start() {
      if(this == shell && !field706) {
         field705 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field706) {
         field705 = class147.currentTimeMs() + 4000L;
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

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field712 = true;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;I)V",
      garbageValue = "1557456601"
   )
   public static void method1029(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.field3321 = var0;
      Spotanim.field3320 = var1;
   }
}
