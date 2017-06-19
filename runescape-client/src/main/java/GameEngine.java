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

@ObfuscatedName("bp")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("p")
   public static Signlink field691;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -161655687
   )
   static int field692;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1670528675
   )
   static int field693;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -3040112177458961813L
   )
   static long field694;
   @ObfuscatedName("m")
   static GameEngine field695;
   @ObfuscatedName("an")
   static volatile boolean field696;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -230165691
   )
   protected static int field697;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 41898875
   )
   int field698;
   @ObfuscatedName("ab")
   volatile boolean field699;
   @ObfuscatedName("ak")
   java.awt.Frame field700;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1032677855
   )
   int field701;
   @ObfuscatedName("a")
   protected static long[] field702;
   @ObfuscatedName("v")
   protected static long[] field703;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1141355493
   )
   protected int field704;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1440716083
   )
   protected int field705;
   @ObfuscatedName("z")
   static boolean field706;
   @ObfuscatedName("q")
   protected static class158 field707;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1934822117
   )
   int field708;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1821176123
   )
   int field709;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 65539599
   )
   int field710;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1877639775
   )
   int field711;
   @ObfuscatedName("j")
   boolean field712;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -889629255
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1921079281
   )
   static int field714;
   @ObfuscatedName("am")
   static Image field715;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1084893723
   )
   static int field716;
   @ObfuscatedName("ao")
   boolean field717;
   @ObfuscatedName("ac")
   volatile boolean field718;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = -16415636684996507L
   )
   volatile long field719;
   @ObfuscatedName("ag")
   class49 field720;
   @ObfuscatedName("aq")
   Clipboard field721;
   @ObfuscatedName("as")
   final EventQueue field722;
   @ObfuscatedName("al")
   @Export("canvas")
   Canvas canvas;

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1915005823"
   )
   void method794() {
      long var1 = class166.method2970();
      long var3 = field703[class202.field2502];
      field703[class202.field2502] = var1;
      class202.field2502 = class202.field2502 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class89.field1390 = field696;
      }

      this.packetHandler();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "22"
   )
   protected final void method795(int var1, int var2) {
      if(this.field710 != var1 || var2 != this.field711) {
         this.method857();
      }

      this.field710 = var1;
      this.field711 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1985920507"
   )
   protected void method798() {
      this.field721 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "56"
   )
   protected final void method800() {
      if(Signlink.field2242.toLowerCase().indexOf("microsoft") != -1) {
         class50.field662[186] = 57;
         class50.field662[187] = 27;
         class50.field662[188] = 71;
         class50.field662[189] = 26;
         class50.field662[190] = 72;
         class50.field662[191] = 73;
         class50.field662[192] = 58;
         class50.field662[219] = 42;
         class50.field662[220] = 74;
         class50.field662[221] = 43;
         class50.field662[222] = 59;
         class50.field662[223] = 28;
      } else {
         class50.field662[44] = 71;
         class50.field662[45] = 26;
         class50.field662[46] = 72;
         class50.field662[47] = 73;
         class50.field662[59] = 57;
         class50.field662[61] = 27;
         class50.field662[91] = 42;
         class50.field662[92] = 74;
         class50.field662[93] = 43;
         class50.field662[192] = 28;
         class50.field662[222] = 58;
         class50.field662[520] = 59;
      }

      class15.method102(this.canvas);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1444839800"
   )
   final void method802() {
      Container var1 = this.method826();
      if(var1 != null) {
         class278 var2 = this.method827();
         this.field704 = Math.max(var2.field3740, this.field708);
         this.field705 = Math.max(var2.field3739, this.field709);
         if(this.field704 <= 0) {
            this.field704 = 1;
         }

         if(this.field705 <= 0) {
            this.field705 = 1;
         }

         class10.canvasWidth = Math.min(this.field704, this.field710);
         class1.canvasHeight = Math.min(this.field705, this.field711);
         this.field701 = (this.field704 - class10.canvasWidth) / 2;
         this.field698 = 0;
         this.canvas.setSize(class10.canvasWidth, class1.canvasHeight);
         World.field1296 = new MainBufferProvider(class10.canvasWidth, class1.canvasHeight, this.canvas);
         if(var1 == this.field700) {
            Insets var3 = this.field700.getInsets();
            this.canvas.setLocation(var3.left + this.field701, this.field698 + var3.top);
         } else {
            this.canvas.setLocation(this.field701, this.field698);
         }

         this.field699 = true;
         this.vmethod1336();
      }

   }

   public final void focusLost(FocusEvent var1) {
      field696 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   final void method804() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(class50.keyboard);
      var1.removeFocusListener(class50.keyboard);
      class50.field653 = -1;
      Canvas var2 = this.canvas;
      var2.removeMouseListener(class59.mouse);
      var2.removeMouseMotionListener(class59.mouse);
      var2.removeFocusListener(class59.mouse);
      class59.field743 = 0;
      if(this.field720 != null) {
         this.field720.method695(this.canvas);
      }

      this.method860();
      class15.method102(this.canvas);
      Canvas var3 = this.canvas;
      var3.addMouseListener(class59.mouse);
      var3.addMouseMotionListener(class59.mouse);
      var3.addFocusListener(class59.mouse);
      if(this.field720 != null) {
         this.field720.method694(this.canvas);
      }

      this.method857();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1268913541"
   )
   protected final boolean method807() {
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
                  this.method816("invalidhost");
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

   public void run() {
      try {
         if(Signlink.field2242 != null) {
            String var1 = Signlink.field2242.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = Signlink.field2243;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method816("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && WallObject.method2761(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(IndexFile.method2910(var4) && class112.method1991(var4) < 10) {
                     this.method816("wrongjava");
                     return;
                  }
               }

               field714 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method860();
         this.vmethod1123();

         Object var7;
         try {
            var7 = new class150();
         } catch (Throwable var5) {
            var7 = new class151();
         }

         field707 = (class158)var7;

         while(field694 == 0L || class166.method2970() < field694) {
            field697 = field707.vmethod2868(field692, field714);

            for(int var8 = 0; var8 < field697; ++var8) {
               this.method794();
            }

            this.method809();
            this.method825(this.canvas);
         }
      } catch (Exception var6) {
         class8.method43((String)null, var6);
         this.method816("crash");
      }

      this.method811();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1945153437"
   )
   void method809() {
      Container var1 = this.method826();
      long var2 = class166.method2970();
      long var4 = field702[FrameMap.field2053];
      field702[FrameMap.field2053] = var2;
      FrameMap.field2053 = FrameMap.field2053 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field716 - 1 > 50) {
         field716 -= 50;
         this.field699 = true;
         this.canvas.setSize(class10.canvasWidth, class1.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field700) {
            Insets var7 = this.field700.getInsets();
            this.canvas.setLocation(var7.left + this.field701, this.field698 + var7.top);
         } else {
            this.canvas.setLocation(this.field701, this.field698);
         }
      }

      if(this.field718) {
         this.method804();
      }

      this.method820();
      this.vmethod1104(this.field699);
      if(this.field699) {
         this.method878();
      }

      this.field699 = false;
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass156;",
      garbageValue = "-293980137"
   )
   protected class156 method810() {
      if(this.field720 == null) {
         this.field720 = new class49();
         this.field720.method694(this.canvas);
      }

      return this.field720;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   final synchronized void method811() {
      if(!field706) {
         field706 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1221();
         } catch (Exception var4) {
            ;
         }

         if(this.field700 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(field691 != null) {
            try {
               field691.method2832();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1100();
      }

   }

   public final void stop() {
      if(field695 == this && !field706) {
         field694 = class166.method2970() + 4000L;
      }

   }

   public final void destroy() {
      if(this == field695 && !field706) {
         field694 = class166.method2970();
         class172.method3014(5000L);
         this.method811();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-130921145"
   )
   protected void method813(String var1) {
      this.field721.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   public final synchronized void paint(Graphics var1) {
      if(field695 == this && !field706) {
         this.field699 = true;
         if(class166.method2970() - this.field719 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class10.canvasWidth && var2.height >= class1.canvasHeight) {
               this.field718 = true;
            }
         }
      }

   }

   public final void focusGained(FocusEvent var1) {
      field696 = true;
      this.field699 = true;
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1463781196"
   )
   protected final void method815(int var1, int var2, int var3) {
      try {
         if(field695 != null) {
            ++field693;
            if(field693 >= 3) {
               this.method816("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field695 = this;
         class10.canvasWidth = var1;
         class1.canvasHeight = var2;
         class152.revision = var3;
         class152.field2225 = this;
         if(field691 == null) {
            field691 = new Signlink();
         }

         field691.method2822(this, 1);
      } catch (Exception var5) {
         class8.method43((String)null, var5);
         this.method816("crash");
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "506278977"
   )
   protected void method816(String var1) {
      if(!this.field712) {
         this.field712 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }
      }

   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2126031886"
   )
   protected abstract void vmethod1100();

   public abstract void init();

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1614382627"
   )
   protected abstract void vmethod1123();

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-975594519"
   )
   final void method820() {
      class278 var1 = this.method827();
      if(this.field704 != var1.field3740 || this.field705 != var1.field3739 || this.field717) {
         this.method802();
         this.field717 = false;
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2137821127"
   )
   protected abstract void vmethod1221();

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "-1451382188"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class1.field4 == null) {
            class1.field4 = new java.awt.Font("Helvetica", 1, 13);
            class238.field3277 = this.canvas.getFontMetrics(class1.field4);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class10.canvasWidth, class1.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(field715 == null) {
               field715 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = field715.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class1.field4);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class238.field3277.stringWidth(var2)) / 2, 22);
            var4.drawImage(field715, class10.canvasWidth / 2 - 152, class1.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class10.canvasWidth / 2 - 152;
            int var8 = class1.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + 2 + var1 * 3, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class1.field4);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class238.field3277.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "12"
   )
   protected final void method824() {
      field715 = null;
      class1.field4 = null;
      class238.field3277 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "173084304"
   )
   final void method825(Object var1) {
      if(this.field722 != null) {
         for(int var2 = 0; var2 < 50 && this.field722.peekEvent() != null; ++var2) {
            class172.method3014(1L);
         }

         if(var1 != null) {
            this.field722.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-380229477"
   )
   Container method826() {
      return (Container)(this.field700 != null?this.field700:this);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Lclass278;",
      garbageValue = "-402432375"
   )
   class278 method827() {
      Container var1 = this.method826();
      int var2 = Math.max(var1.getWidth(), this.field708);
      int var3 = Math.max(var1.getHeight(), this.field709);
      if(this.field700 != null) {
         Insets var4 = this.field700.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new class278(var2, var3);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   protected final boolean method828() {
      return this.field700 != null;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1149017965"
   )
   protected final void method835() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(class59.mouse);
      var1.addMouseMotionListener(class59.mouse);
      var1.addFocusListener(class59.mouse);
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1728701864"
   )
   final void method857() {
      this.field717 = true;
   }

   protected GameEngine() {
      this.field712 = false;
      this.field701 = 0;
      this.field698 = 0;
      this.field699 = true;
      this.field717 = false;
      this.field718 = false;
      this.field719 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field722 = var1;
      class7.method37(new class51());
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1326549533"
   )
   protected abstract void vmethod1336();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)LSequence;",
      garbageValue = "5"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3603.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class95.field1484.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method4575(new Buffer(var2));
         }

         var1.method4577();
         Sequence.field3603.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   final synchronized void method860() {
      Container var1 = this.method826();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class10.canvasWidth = Math.max(var1.getWidth(), this.field708);
      class1.canvasHeight = Math.max(var1.getHeight(), this.field709);
      Insets var2;
      if(this.field700 != null) {
         var2 = this.field700.getInsets();
         class10.canvasWidth -= var2.right + var2.left;
         class1.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class10.canvasWidth, class1.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field700) {
         var2 = this.field700.getInsets();
         this.canvas.setLocation(var2.left + this.field701, var2.top + this.field698);
      } else {
         this.canvas.setLocation(this.field701, this.field698);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field699 = true;
      if(World.field1296 != null && World.field1296.width == class10.canvasWidth && World.field1296.height == class1.canvasHeight) {
         ((MainBufferProvider)World.field1296).method776(this.canvas);
         World.field1296.vmethod4897(0, 0);
      } else {
         World.field1296 = new MainBufferProvider(class10.canvasWidth, class1.canvasHeight, this.canvas);
      }

      this.field718 = false;
      this.field719 = class166.method2970();
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1060890679"
   )
   static void method864() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3435(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3429()) {
         int var1 = var0.id;
         if(class59.method961(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class223.method3959(var4);
               if(var5 != null) {
                  XItemContainer.method1020(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1176910351"
   )
   void method878() {
      int var1 = this.field701;
      int var2 = this.field698;
      int var3 = this.field704 - class10.canvasWidth - var1;
      int var4 = this.field705 - class1.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.method826();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field700) {
               Insets var8 = this.field700.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field705);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field704, var2);
            }

            if(var3 > 0) {
               var10.fillRect(this.field704 + var6 - var3, var7, var3, this.field705);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field705 - var4, this.field704, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   public final void start() {
      if(this == field695 && !field706) {
         field694 = 0L;
      }

   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-112"
   )
   protected abstract void vmethod1104(boolean var1);

   public final void windowDeactivated(WindowEvent var1) {
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "128918498"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-61"
   )
   static final void method930(int var0) {
      short var1 = 256;
      class92.field1425 += var0 * 128;
      int var2;
      if(class92.field1425 > class14.field296.length) {
         class92.field1425 -= class14.field296.length;
         var2 = (int)(Math.random() * 12.0D);
         Renderable.method2760(class35.field503[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class10.field268[var2 + var3] - var0 * class14.field296[class92.field1425 + var2 & class14.field296.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class10.field268[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class10.field268[var6 + var7] = 255;
            } else {
               class10.field268[var7 + var6] = 0;
            }
         }
      }

      if(class92.field1442 > 0) {
         class92.field1442 -= var0 * 4;
      }

      if(class92.field1424 > 0) {
         class92.field1424 -= var0 * 4;
      }

      if(class92.field1442 == 0 && class92.field1424 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class92.field1442 = 1024;
         }

         if(var5 == 1) {
            class92.field1424 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class92.field1441[var5] = class92.field1441[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class92.field1441[var5] = (int)(Math.sin((double)class92.field1428 / 14.0D) * 16.0D + Math.sin((double)class92.field1428 / 15.0D) * 14.0D + Math.sin((double)class92.field1428 / 16.0D) * 12.0D);
         ++class92.field1428;
      }

      class92.field1426 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class92.field1426 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class10.field268[(var8 << 7) + var7] = 192;
         }

         class92.field1426 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class10.field268[var5 + var9 + var8];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class10.field268[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  class170.field2360[var8 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var8 + var5 < var1) {
                  var7 += class170.field2360[var9 + var6 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class170.field2360[var6 + var9 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class10.field268[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "31"
   )
   static void method931(int var0, int var1) {
      if(Client.field1141 != 0 && var0 != -1) {
         class13.method75(class11.indexTrack2, var0, 0, Client.field1141, false);
         Client.field1143 = true;
      }

   }

   static {
      field695 = null;
      field693 = 0;
      field694 = 0L;
      field706 = false;
      field692 = 20;
      field714 = 1;
      FPS = 0;
      field702 = new long[32];
      field703 = new long[32];
      field716 = 500;
      field696 = true;
   }
}
