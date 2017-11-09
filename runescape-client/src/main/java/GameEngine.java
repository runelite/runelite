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
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 190869551
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 3627596494782452941L
   )
   static long field661;
   @ObfuscatedName("v")
   static boolean field679;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 21207737
   )
   static int field664;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 680592255
   )
   static int field665;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 742069721
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("t")
   protected static long[] field669;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1889617647
   )
   static int field687;
   @ObfuscatedName("u")
   protected static long[] field671;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -380602361
   )
   static int field672;
   @ObfuscatedName("ak")
   static Image field690;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 177342225
   )
   static int field685;
   @ObfuscatedName("ai")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = 3545385594688922451L
   )
   static long field680;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      longValue = -4903721730105594563L
   )
   static long field694;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static BuildType field689;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1181659989
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("e")
   boolean field663;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 234823585
   )
   protected int field673;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1786858185
   )
   protected int field674;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1726853933
   )
   int field675;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1396596643
   )
   int field676;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2053546069
   )
   int field677;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1022248223
   )
   int field681;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 2086016791
   )
   int field678;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1662926633
   )
   int field682;
   @ObfuscatedName("ag")
   java.awt.Frame field662;
   @ObfuscatedName("ap")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("av")
   volatile boolean field683;
   @ObfuscatedName("an")
   boolean field686;
   @ObfuscatedName("ah")
   volatile boolean field684;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = -627669237993103221L
   )
   volatile long field688;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   class49 field658;
   @ObfuscatedName("au")
   Clipboard field666;
   @ObfuscatedName("ac")
   final EventQueue field691;

   static {
      shell = null;
      shellCount = 0;
      field661 = 0L;
      field679 = false;
      field664 = 20;
      field665 = 1;
      FPS = 0;
      field669 = new long[32];
      field671 = new long[32];
      field685 = 500;
      focused = true;
      field680 = -1L;
      field694 = -1L;
   }

   protected GameEngine() {
      this.field663 = false;
      this.field675 = 0;
      this.field676 = 0;
      this.field683 = true;
      this.field686 = false;
      this.field684 = false;
      this.field688 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field691 = var1;
      class51 var2 = new class51();
      AbstractSoundSystem.field1567 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   protected final void method909(int var1, int var2) {
      if(this.field678 != var1 || var2 != this.field682) {
         this.method1032();
      }

      this.field678 = var1;
      this.field682 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "46035266"
   )
   final void method943(Object var1) {
      if(this.field691 != null) {
         for(int var2 = 0; var2 < 50 && this.field691.peekEvent() != null; ++var2) {
            class61.method1130(1L);
         }

         if(var1 != null) {
            this.field691.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lfq;",
      garbageValue = "490050738"
   )
   protected class157 method910() {
      if(this.field658 == null) {
         this.field658 = new class49();
         this.field658.method812(this.canvas);
      }

      return this.field658;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-94"
   )
   protected void method911() {
      this.field666 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1889373650"
   )
   protected void method959(String var1) {
      this.field666.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "24928"
   )
   protected final void method984() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field623[186] = 57;
         KeyFocusListener.field623[187] = 27;
         KeyFocusListener.field623[188] = 71;
         KeyFocusListener.field623[189] = 26;
         KeyFocusListener.field623[190] = 72;
         KeyFocusListener.field623[191] = 73;
         KeyFocusListener.field623[192] = 58;
         KeyFocusListener.field623[219] = 42;
         KeyFocusListener.field623[220] = 74;
         KeyFocusListener.field623[221] = 43;
         KeyFocusListener.field623[222] = 59;
         KeyFocusListener.field623[223] = 28;
      } else {
         KeyFocusListener.field623[44] = 71;
         KeyFocusListener.field623[45] = 26;
         KeyFocusListener.field623[46] = 72;
         KeyFocusListener.field623[47] = 73;
         KeyFocusListener.field623[59] = 57;
         KeyFocusListener.field623[61] = 27;
         KeyFocusListener.field623[91] = 42;
         KeyFocusListener.field623[92] = 74;
         KeyFocusListener.field623[93] = 43;
         KeyFocusListener.field623[192] = 28;
         KeyFocusListener.field623[222] = 58;
         KeyFocusListener.field623[520] = 59;
      }

      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "63"
   )
   protected final void method914() {
      class31.method307(this.canvas);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-340380112"
   )
   final void method1025() {
      Container var1 = this.container();
      if(var1 != null) {
         class287 var2 = this.method994();
         this.field673 = Math.max(var2.field3795, this.field677);
         this.field674 = Math.max(var2.field3796, this.field681);
         if(this.field673 <= 0) {
            this.field673 = 1;
         }

         if(this.field674 <= 0) {
            this.field674 = 1;
         }

         Tile.canvasWidth = Math.min(this.field673, this.field678);
         class89.canvasHeight = Math.min(this.field674, this.field682);
         this.field675 = (this.field673 - Tile.canvasWidth) / 2;
         this.field676 = 0;
         this.canvas.setSize(Tile.canvasWidth, class89.canvasHeight);
         class66.field779 = new MainBufferProvider(Tile.canvasWidth, class89.canvasHeight, this.canvas);
         if(var1 == this.field662) {
            Insets var3 = this.field662.getInsets();
            this.canvas.setLocation(var3.left + this.field675, this.field676 + var3.top);
         } else {
            this.canvas.setLocation(this.field675, this.field676);
         }

         this.field683 = true;
         this.vmethod1241();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1245071170"
   )
   protected abstract void vmethod1241();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "768854238"
   )
   void method1048() {
      int var1 = this.field675;
      int var2 = this.field676;
      int var3 = this.field673 - Tile.canvasWidth - var1;
      int var4 = this.field674 - class89.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field662) {
               Insets var8 = this.field662.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field674);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field673, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field673 - var3, var7, var3, this.field674);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field674 - var4, this.field673, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "86"
   )
   final void method925() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field611 = -1;
      class54.method858(this.canvas);
      if(this.field658 != null) {
         this.field658.method805(this.canvas);
      }

      this.method920();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      class31.method307(this.canvas);
      if(this.field658 != null) {
         this.field658.method812(this.canvas);
      }

      this.method1032();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1337695301"
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
         Tile.canvasWidth = var1;
         class89.canvasHeight = var2;
         class153.revision = var3;
         class153.field2133 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class33.method396((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-87604145"
   )
   final synchronized void method920() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      Tile.canvasWidth = Math.max(var1.getWidth(), this.field677);
      class89.canvasHeight = Math.max(var1.getHeight(), this.field681);
      Insets var2;
      if(this.field662 != null) {
         var2 = this.field662.getInsets();
         Tile.canvasWidth -= var2.right + var2.left;
         class89.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(Tile.canvasWidth, class89.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field662) {
         var2 = this.field662.getInsets();
         this.canvas.setLocation(var2.left + this.field675, this.field676 + var2.top);
      } else {
         this.canvas.setLocation(this.field675, this.field676);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field683 = true;
      if(class66.field779 != null && Tile.canvasWidth == class66.field779.width && class89.canvasHeight == class66.field779.height) {
         ((MainBufferProvider)class66.field779).method894(this.canvas);
         class66.field779.vmethod5235(0, 0);
      } else {
         class66.field779 = new MainBufferProvider(Tile.canvasWidth, class89.canvasHeight, this.canvas);
      }

      this.field684 = false;
      this.field688 = class268.currentTimeMs();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-20343"
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

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method922() {
      long var1 = class268.currentTimeMs();
      long var3 = field671[field672];
      field671[field672] = var1;
      field672 = field672 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class35.field474 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2007047117"
   )
   void method923() {
      Container var1 = this.container();
      long var2 = class268.currentTimeMs();
      long var4 = field669[field687];
      field669[field687] = var2;
      field687 = field687 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field685 - 1 > 50) {
         field685 -= 50;
         this.field683 = true;
         this.canvas.setSize(Tile.canvasWidth, class89.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field662) {
            Insets var7 = this.field662.getInsets();
            this.canvas.setLocation(var7.left + this.field675, var7.top + this.field676);
         } else {
            this.canvas.setLocation(this.field675, this.field676);
         }
      }

      if(this.field684) {
         this.method925();
      }

      this.method933();
      this.vmethod1234(this.field683);
      if(this.field683) {
         this.method1048();
      }

      this.field683 = false;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   final void method933() {
      class287 var1 = this.method994();
      if(var1.field3795 != this.field673 || var1.field3796 != this.field674 || this.field686) {
         this.method1025();
         this.field686 = false;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "14754"
   )
   final void method1032() {
      this.field686 = true;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "799734426"
   )
   final synchronized void method926() {
      if(!field679) {
         field679 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1235();
         } catch (Exception var4) {
            ;
         }

         if(this.field662 != null) {
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

         this.vmethod1230();
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2041847822"
   )
   protected abstract void vmethod1566();

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-140607315"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "280842206"
   )
   protected abstract void vmethod1234(boolean var1);

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   protected abstract void vmethod1235();

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "-531557726"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(KitDefinition.field3413 == null) {
            KitDefinition.field3413 = new java.awt.Font("Helvetica", 1, 13);
            class256.field3432 = this.canvas.getFontMetrics(KitDefinition.field3413);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, Tile.canvasWidth, class89.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(field690 == null) {
               field690 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = field690.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(KitDefinition.field3413);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class256.field3432.stringWidth(var2)) / 2, 22);
            var4.drawImage(field690, Tile.canvasWidth / 2 - 152, class89.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = Tile.canvasWidth / 2 - 152;
            int var8 = class89.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(KitDefinition.field3413);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class256.field3432.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "650992418"
   )
   protected final void method996() {
      field690 = null;
      KitDefinition.field3413 = null;
      class256.field3432 = null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "105"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field663) {
         this.field663 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "2"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field662 != null?this.field662:this);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)Lkp;",
      garbageValue = "62"
   )
   class287 method994() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field677);
      int var3 = Math.max(var1.getHeight(), this.field681);
      if(this.field662 != null) {
         Insets var4 = this.field662.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new class287(var2, var3);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-913518270"
   )
   protected final boolean method924() {
      return this.field662 != null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1435498460"
   )
   protected abstract void vmethod1230();

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field679) {
         this.field683 = true;
         if(class268.currentTimeMs() - this.field688 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= Tile.canvasWidth && var2.height >= class89.canvasHeight) {
               this.field684 = true;
            }
         }

      }
   }

   public final void destroy() {
      if(this == shell && !field679) {
         field661 = class268.currentTimeMs();
         class61.method1130(5000L);
         this.method926();
      }
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
                  for(var3 = 6; var3 < var2.length() && Actor.method1629(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var5 = KeyFocusListener.method832(var4, 10, true);
                  if(var5 && class94.method1871(var4) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               field665 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method920();
         this.vmethod1566();

         Object var9;
         try {
            var9 = new NanoTimer();
         } catch (Throwable var7) {
            var9 = new MilliTimer();
         }

         timer = (Timer)var9;

         while(field661 == 0L || class268.currentTimeMs() < field661) {
            class9.field249 = timer.vmethod3095(field664, field665);

            for(int var6 = 0; var6 < class9.field249; ++var6) {
               this.method922();
            }

            this.method923();
            this.method943(this.canvas);
         }
      } catch (Exception var8) {
         class33.method396((String)null, var8);
         this.error("crash");
      }

      this.method926();
   }

   public final void start() {
      if(this == shell && !field679) {
         field661 = 0L;
      }
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field683 = true;
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void stop() {
      if(this == shell && !field679) {
         field661 = class268.currentTimeMs() + 4000L;
      }
   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "57"
   )
   static final void method1053(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(CombatInfoListHolder.loadWidget(var0)) {
         ItemContainer.method1145(class243.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
