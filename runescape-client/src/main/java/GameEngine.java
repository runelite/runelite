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

@ObfuscatedName("bx")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("an")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lbx;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("o")
   static boolean field736;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -972533907
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 1416091603861272233L
   )
   static long field704;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1046395373
   )
   static int field707;
   @ObfuscatedName("c")
   protected static long[] field706;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1766899745
   )
   static int field716;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("t")
   protected static long[] field711;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 137602467
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 485041547
   )
   static int field717;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      longValue = 2749462283490677371L
   )
   protected static long field733;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      longValue = 6698101861502256635L
   )
   protected static long field734;
   @ObfuscatedName("af")
   protected static boolean field732;
   @ObfuscatedName("fq")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("aw")
   Clipboard field729;
   @ObfuscatedName("ah")
   final EventQueue field730;
   @ObfuscatedName("ac")
   boolean field713;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   class49 field728;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -533703961
   )
   int field715;
   @ObfuscatedName("n")
   boolean field723;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1256748107
   )
   int field712;
   @ObfuscatedName("ab")
   java.awt.Frame field721;
   @ObfuscatedName("am")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1409281179
   )
   int field708;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2004080981
   )
   protected int field701;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1292310183
   )
   int field720;
   @ObfuscatedName("aq")
   volatile boolean field727;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1238102077
   )
   int field725;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -62971649
   )
   protected int field714;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -471616423
   )
   int field719;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      longValue = 4996619456965707755L
   )
   volatile long field724;
   @ObfuscatedName("aa")
   volatile boolean field726;

   static {
      shell = null;
      shellCount = 0;
      field704 = 0L;
      field736 = false;
      field707 = 20;
      field716 = 1;
      FPS = 0;
      field711 = new long[32];
      field706 = new long[32];
      field717 = 500;
      focused = true;
      field733 = -1L;
      field734 = -1L;
   }

   protected GameEngine() {
      this.field723 = false;
      this.field715 = 0;
      this.field708 = 0;
      this.field727 = true;
      this.field713 = false;
      this.field726 = false;
      this.field724 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field730 = var1;
      class51 var2 = new class51();
      class43.field586 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1827910530"
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
      if(this == shell && !field736) {
         field704 = class45.currentTimeMs();
         NPC.method1702(5000L);
         this.method906();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field736) {
         this.field727 = true;
         if(class45.currentTimeMs() - this.field724 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class91.canvasWidth && var2.height >= class64.canvasHeight) {
               this.field726 = true;
            }
         }

      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(S)Ljd;",
      garbageValue = "128"
   )
   class279 method921() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field725);
      int var3 = Math.max(var1.getHeight(), this.field719);
      if(this.field721 != null) {
         Insets var4 = this.field721.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new class279(var2, var3);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1265421780"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field721 != null?this.field721:this);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "18"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field723) {
         this.field723 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-30"
   )
   final void method912() {
      this.field713 = true;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-468709499"
   )
   final synchronized void method899() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class91.canvasWidth = Math.max(var1.getWidth(), this.field725);
      class64.canvasHeight = Math.max(var1.getHeight(), this.field719);
      Insets var2;
      if(this.field721 != null) {
         var2 = this.field721.getInsets();
         class91.canvasWidth -= var2.left + var2.right;
         class64.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class91.canvasWidth, class64.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field721) {
         var2 = this.field721.getInsets();
         this.canvas.setLocation(this.field715 + var2.left, this.field708 + var2.top);
      } else {
         this.canvas.setLocation(this.field715, this.field708);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field727 = true;
      if(class20.field342 != null && class91.canvasWidth == class20.field342.width && class64.canvasHeight == class20.field342.height) {
         ((MainBufferProvider)class20.field342).method872(this.canvas);
         class20.field342.vmethod4967(0, 0);
      } else {
         class20.field342 = new MainBufferProvider(class91.canvasWidth, class64.canvasHeight, this.canvas);
      }

      this.field726 = false;
      this.field724 = class45.currentTimeMs();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1663779438"
   )
   protected abstract void vmethod1176();

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1249507264"
   )
   protected abstract void vmethod1350();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1792958294"
   )
   final void method966() {
      Container var1 = this.container();
      if(var1 != null) {
         class279 var2 = this.method921();
         this.field701 = Math.max(var2.field3741, this.field725);
         this.field714 = Math.max(var2.field3742, this.field719);
         if(this.field701 <= 0) {
            this.field701 = 1;
         }

         if(this.field714 <= 0) {
            this.field714 = 1;
         }

         class91.canvasWidth = Math.min(this.field701, this.field712);
         class64.canvasHeight = Math.min(this.field714, this.field720);
         this.field715 = (this.field701 - class91.canvasWidth) / 2;
         this.field708 = 0;
         this.canvas.setSize(class91.canvasWidth, class64.canvasHeight);
         class20.field342 = new MainBufferProvider(class91.canvasWidth, class64.canvasHeight, this.canvas);
         if(var1 == this.field721) {
            Insets var3 = this.field721.getInsets();
            this.canvas.setLocation(var3.left + this.field715, var3.top + this.field708);
         } else {
            this.canvas.setLocation(this.field715, this.field708);
         }

         this.field727 = true;
         this.vmethod1182();
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-52"
   )
   final synchronized void method906() {
      if(!field736) {
         field736 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1176();
         } catch (Exception var4) {
            ;
         }

         if(this.field721 != null) {
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

         this.vmethod1171();
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-705680371"
   )
   protected final void method918() {
      WorldMapData.field460 = null;
      class21.field354 = null;
      class225.field2854 = null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1378790770"
   )
   protected abstract void vmethod1171();

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "8"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class21.field354 == null) {
            class21.field354 = new java.awt.Font("Helvetica", 1, 13);
            class225.field2854 = this.canvas.getFontMetrics(class21.field354);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class91.canvasWidth, class64.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(WorldMapData.field460 == null) {
               WorldMapData.field460 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = WorldMapData.field460.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class21.field354);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class225.field2854.stringWidth(var2)) / 2, 22);
            var4.drawImage(WorldMapData.field460, class91.canvasWidth / 2 - 152, class64.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class91.canvasWidth / 2 - 152;
            int var8 = class64.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class21.field354);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class225.field2854.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "727556906"
   )
   void method902() {
      long var1 = class45.currentTimeMs();
      long var3 = field706[class47.field616];
      field706[class47.field616] = var1;
      class47.field616 = class47.field616 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         field732 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1287550365"
   )
   protected final void method1021() {
      class8.method40();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-213107059"
   )
   protected final void method962() {
      class240.method4273(this.canvas);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-38373875"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lfo;",
      garbageValue = "-1222949865"
   )
   protected class157 method890() {
      if(this.field728 == null) {
         this.field728 = new class49();
         this.field728.method776(this.canvas);
      }

      return this.field728;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-44"
   )
   public final void method888(int var1, int var2) {
      if(this.field712 != var1 || var2 != this.field720) {
         this.method912();
      }

      this.field712 = var1;
      this.field720 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "792807359"
   )
   void method903() {
      Container var1 = this.container();
      long var2 = class45.currentTimeMs();
      long var4 = field711[class3.field20];
      field711[class3.field20] = var2;
      class3.field20 = class3.field20 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field717 - 1 > 50) {
         field717 -= 50;
         this.field727 = true;
         this.canvas.setSize(class91.canvasWidth, class64.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field721) {
            Insets var7 = this.field721.getInsets();
            this.canvas.setLocation(var7.left + this.field715, this.field708 + var7.top);
         } else {
            this.canvas.setLocation(this.field715, this.field708);
         }
      }

      if(this.field726) {
         this.method897();
      }

      this.method904();
      this.vmethod1407(this.field727);
      if(this.field727) {
         this.method947();
      }

      this.field727 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "426525874"
   )
   final void method889(Object var1) {
      if(this.field730 != null) {
         for(int var2 = 0; var2 < 50 && this.field730.peekEvent() != null; ++var2) {
            NPC.method1702(1L);
         }

         if(var1 != null) {
            this.field730.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "398701743"
   )
   final void method897() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field654 = -1;
      class208.method3931(this.canvas);
      if(this.field728 != null) {
         this.field728.method778(this.canvas);
      }

      this.method899();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      class240.method4273(this.canvas);
      if(this.field728 != null) {
         this.field728.method776(this.canvas);
      }

      this.method912();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1121367227"
   )
   final void method904() {
      class279 var1 = this.method921();
      if(var1.field3741 != this.field701 || this.field714 != var1.field3742 || this.field713) {
         this.method966();
         this.field713 = false;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1410092045"
   )
   protected void method955() {
      this.field729 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1252570597"
   )
   protected abstract void vmethod1407(boolean var1);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   protected abstract void vmethod1182();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   void method947() {
      int var1 = this.field715;
      int var2 = this.field708;
      int var3 = this.field701 - class91.canvasWidth - var1;
      int var4 = this.field714 - class64.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field721) {
               Insets var8 = this.field721.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field714);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field701, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field701 - var3, var7, var3, this.field714);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field714 - var4, this.field701, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "12"
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
         class91.canvasWidth = var1;
         class64.canvasHeight = var2;
         class5.revision = var3;
         class153.field2228 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class150.method2975((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "417882932"
   )
   protected final boolean method922() {
      return this.field721 != null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1219985501"
   )
   protected void method916(String var1) {
      this.field729.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void start() {
      if(this == shell && !field736) {
         field704 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field736) {
         field704 = class45.currentTimeMs() + 4000L;
      }
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field727 = true;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public abstract void init();

   public final void windowIconified(WindowEvent var1) {
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public void run() {
      try {
         if(Signlink.javaVendor != null) {
            String var1 = Signlink.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class170.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && RSCanvas.method828(var2.charAt(var3)); ++var3) {
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

                     label183: {
                        char var12 = var4.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == 45) {
                              var7 = true;
                              break label183;
                           }

                           if(var12 == 43) {
                              break label183;
                           }
                        }

                        int var19;
                        if(var12 >= 48 && var12 <= 57) {
                           var19 = var12 - 48;
                        } else if(var12 >= 65 && var12 <= 90) {
                           var19 = var12 - 55;
                        } else {
                           if(var12 < 97 || var12 > 122) {
                              var6 = false;
                              break;
                           }

                           var19 = var12 - 87;
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
                     int var18 = class227.parseInt(var4, 10, true);
                     if(var18 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field716 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method899();
         this.vmethod1350();

         Object var17;
         try {
            var17 = new NanoTimer();
         } catch (Throwable var15) {
            var17 = new MilliTimer();
         }

         timer = (Timer)var17;

         while(field704 == 0L || class45.currentTimeMs() < field704) {
            class15.field305 = timer.vmethod3051(field707, field716);

            for(int var14 = 0; var14 < class15.field305; ++var14) {
               this.method902();
            }

            this.method903();
            this.method889(this.canvas);
         }
      } catch (Exception var16) {
         class150.method2975((String)null, var16);
         this.error("crash");
      }

      this.method906();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;II)Lhh;",
      garbageValue = "1301711025"
   )
   static class208 method1027(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4209(var1);
      return var2 == null?null:new class208(var2);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "65"
   )
   static void method907(int var0) {
      if(var0 != -1) {
         if(class13.loadWidget(var0)) {
            Widget[] var1 = class268.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2739 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field864 = var3.field2739;
                  WorldMapType1.method300(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "3915"
   )
   static final String method1028(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
