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

@ObfuscatedName("bf")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1916335479
   )
   int field698;
   @ObfuscatedName("c")
   static GameEngine field699;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1019999055
   )
   static int field700;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -3227927959522867377L
   )
   static long field701;
   @ObfuscatedName("b")
   static boolean field702;
   @ObfuscatedName("ap")
   volatile boolean field703;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -673637807
   )
   static int field704;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1960659463
   )
   static int field705;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -974092851
   )
   protected int field706;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1108952331
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("z")
   static class158 field708;
   @ObfuscatedName("ag")
   class49 field709;
   @ObfuscatedName("ai")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("h")
   boolean field711;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1640199523
   )
   protected int field712;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 876332635
   )
   int field713;
   @ObfuscatedName("r")
   static long[] field714;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1461601783
   )
   int field716;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 137183919
   )
   int field717;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1259839235
   )
   int field718;
   @ObfuscatedName("j")
   static long[] field719;
   @ObfuscatedName("ah")
   java.awt.Frame field720;
   @ObfuscatedName("i")
   public static class154 field721;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 134767589
   )
   static int field722;
   @ObfuscatedName("aa")
   boolean field723;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1056996703
   )
   static int field724;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = -6969670461658156201L
   )
   volatile long field725;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1885356377
   )
   int field726;
   @ObfuscatedName("az")
   Clipboard field727;
   @ObfuscatedName("ac")
   final EventQueue field728;
   @ObfuscatedName("ax")
   static volatile boolean field729;
   @ObfuscatedName("aw")
   volatile boolean field730;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)LSpritePixels;",
      garbageValue = "-819463128"
   )
   public static SpritePixels method827(IndexDataBase var0, int var1, int var2) {
      return !class7.method28(var0, var1, var2)?null:Tile.method2488();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "620666484"
   )
   final void method829(Object var1) {
      if(this.field728 != null) {
         for(int var2 = 0; var2 < 50 && this.field728.peekEvent() != null; ++var2) {
            class4.method9(1L);
         }

         if(var1 != null) {
            this.field728.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "122"
   )
   protected void method831() {
      this.field727 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1163635943"
   )
   protected void method832(String var1) {
      this.field727.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "340593250"
   )
   protected final void method833() {
      if(class154.field2254.toLowerCase().indexOf("microsoft") != -1) {
         class50.field658[186] = 57;
         class50.field658[187] = 27;
         class50.field658[188] = 71;
         class50.field658[189] = 26;
         class50.field658[190] = 72;
         class50.field658[191] = 73;
         class50.field658[192] = 58;
         class50.field658[219] = 42;
         class50.field658[220] = 74;
         class50.field658[221] = 43;
         class50.field658[222] = 59;
         class50.field658[223] = 28;
      } else {
         class50.field658[44] = 71;
         class50.field658[45] = 26;
         class50.field658[46] = 72;
         class50.field658[47] = 73;
         class50.field658[59] = 57;
         class50.field658[61] = 27;
         class50.field658[91] = 42;
         class50.field658[92] = 74;
         class50.field658[93] = 43;
         class50.field658[192] = 28;
         class50.field658[222] = 58;
         class50.field658[520] = 59;
      }

      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class50.keyboard);
      var1.addFocusListener(class50.keyboard);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-204492799"
   )
   protected final void method834() {
      class41.field558 = null;
      class254.field3431 = null;
      XGrandExchangeOffer.field300 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1409139396"
   )
   final void method835() {
      Container var1 = this.method859();
      if(var1 != null) {
         class278 var2 = this.method860();
         this.field706 = Math.max(var2.field3739, this.field726);
         this.field712 = Math.max(var2.field3740, this.field716);
         if(this.field706 <= 0) {
            this.field706 = 1;
         }

         if(this.field712 <= 0) {
            this.field712 = 1;
         }

         VertexNormal.field2020 = Math.min(this.field706, this.field717);
         class18.field311 = Math.min(this.field712, this.field718);
         this.field713 = (this.field706 - VertexNormal.field2020) / 2;
         this.field698 = 0;
         this.canvas.setSize(VertexNormal.field2020, class18.field311);
         class166.field2343 = new MainBufferProvider(VertexNormal.field2020, class18.field311, this.canvas);
         if(this.field720 == var1) {
            Insets var3 = this.field720.getInsets();
            this.canvas.setLocation(var3.left + this.field713, this.field698 + var3.top);
         } else {
            this.canvas.setLocation(this.field713, this.field698);
         }

         this.field730 = true;
         this.vmethod1154();
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "705089312"
   )
   final void method838() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(class50.keyboard);
      var1.removeFocusListener(class50.keyboard);
      class50.field650 = -1;
      Canvas var2 = this.canvas;
      var2.removeMouseListener(class59.mouse);
      var2.removeMouseMotionListener(class59.mouse);
      var2.removeFocusListener(class59.mouse);
      class59.field733 = 0;
      if(this.field709 != null) {
         this.field709.method725(this.canvas);
      }

      this.method840();
      Canvas var3 = this.canvas;
      var3.setFocusTraversalKeysEnabled(false);
      var3.addKeyListener(class50.keyboard);
      var3.addFocusListener(class50.keyboard);
      class243.method4319(this.canvas);
      if(this.field709 != null) {
         this.field709.method724(this.canvas);
      }

      this.method845();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1204598166"
   )
   final synchronized void method840() {
      Container var1 = this.method859();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      VertexNormal.field2020 = Math.max(var1.getWidth(), this.field726);
      class18.field311 = Math.max(var1.getHeight(), this.field716);
      Insets var2;
      if(this.field720 != null) {
         var2 = this.field720.getInsets();
         VertexNormal.field2020 -= var2.right + var2.left;
         class18.field311 -= var2.bottom + var2.top;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(VertexNormal.field2020, class18.field311);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field720) {
         var2 = this.field720.getInsets();
         this.canvas.setLocation(this.field713 + var2.left, this.field698 + var2.top);
      } else {
         this.canvas.setLocation(this.field713, this.field698);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field730 = true;
      if(class166.field2343 != null && VertexNormal.field2020 == class166.field2343.width && class166.field2343.height == class18.field311) {
         ((MainBufferProvider)class166.field2343).method807(this.canvas);
         class166.field2343.vmethod5008(0, 0);
      } else {
         class166.field2343 = new MainBufferProvider(VertexNormal.field2020, class18.field311, this.canvas);
      }

      this.field703 = false;
      this.field725 = XGrandExchangeOffer.method96();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-109"
   )
   protected final boolean method841() {
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
                  this.method858("invalidhost");
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
         if(class154.field2254 != null) {
            String var1 = class154.field2254.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class154.field2250;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method858("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class207.method3855(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class254.method4490(var4) && class208.method3857(var4) < 10) {
                     this.method858("wrongjava");
                     return;
                  }
               }

               field724 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method840();
         this.vmethod1297();

         Object var8;
         try {
            var8 = new class150();
         } catch (Throwable var6) {
            var8 = new class151();
         }

         field708 = (class158)var8;

         while(0L == field701 || XGrandExchangeOffer.method96() < field701) {
            field704 = field708.vmethod2972(field705, field724);

            for(int var5 = 0; var5 < field704; ++var5) {
               this.method842();
            }

            this.method843();
            this.method829(this.canvas);
         }
      } catch (Exception var7) {
         class21.method138((String)null, var7);
         this.method858("crash");
      }

      this.method846();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-838337776"
   )
   void method842() {
      long var1 = XGrandExchangeOffer.method96();
      long var3 = field714[WorldMapData.field464];
      field714[WorldMapData.field464] = var1;
      WorldMapData.field464 = WorldMapData.field464 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class44.field582 = field729;
      }

      this.packetHandler();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1174548990"
   )
   void method843() {
      Container var1 = this.method859();
      long var2 = XGrandExchangeOffer.method96();
      long var4 = field719[class47.field611];
      field719[class47.field611] = var2;
      class47.field611 = class47.field611 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field722 - 1 > 50) {
         field722 -= 50;
         this.field730 = true;
         this.canvas.setSize(VertexNormal.field2020, class18.field311);
         this.canvas.setVisible(true);
         if(var1 == this.field720) {
            Insets var7 = this.field720.getInsets();
            this.canvas.setLocation(var7.left + this.field713, this.field698 + var7.top);
         } else {
            this.canvas.setLocation(this.field713, this.field698);
         }
      }

      if(this.field703) {
         this.method838();
      }

      this.method844();
      this.vmethod1147(this.field730);
      if(this.field730) {
         this.method847();
      }

      this.field730 = false;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "362008214"
   )
   final void method844() {
      class278 var1 = this.method860();
      if(this.field706 != var1.field3739 || var1.field3740 != this.field712 || this.field723) {
         this.method835();
         this.field723 = false;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   final void method845() {
      this.field723 = true;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-113"
   )
   final synchronized void method846() {
      if(!field702) {
         field702 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1148();
         } catch (Exception var4) {
            ;
         }

         if(this.field720 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(field721 != null) {
            try {
               field721.method2933();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1143();
      }
   }

   public final void start() {
      if(this == field699 && !field702) {
         field701 = 0L;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-327850571"
   )
   void method847() {
      int var1 = this.field713;
      int var2 = this.field698;
      int var3 = this.field706 - VertexNormal.field2020 - var1;
      int var4 = this.field712 - class18.field311 - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.method859();
            int var6 = 0;
            int var7 = 0;
            if(this.field720 == var5) {
               Insets var8 = this.field720.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field712);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field706, var2);
            }

            if(var3 > 0) {
               var10.fillRect(this.field706 + var6 - var3, var7, var3, this.field712);
            }

            if(var4 > 0) {
               var10.fillRect(var6, this.field712 + var7 - var4, this.field706, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field699 && !field702) {
         this.field730 = true;
         if(XGrandExchangeOffer.method96() - this.field725 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= VertexNormal.field2020 && var2.height >= class18.field311) {
               this.field703 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field729 = true;
      this.field730 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field729 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1025709475"
   )
   static final int method849(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & '\uff00') * var2 + var3 * (var0 & '\uff00') & 16711680) + (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1929502106"
   )
   protected final void method851() {
      class243.method4319(this.canvas);
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-8413241"
   )
   protected abstract void vmethod1297();

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "1574609972"
   )
   protected final void method856(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class254.field3431 == null) {
            class254.field3431 = new java.awt.Font("Helvetica", 1, 13);
            XGrandExchangeOffer.field300 = this.canvas.getFontMetrics(class254.field3431);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, VertexNormal.field2020, class18.field311);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class41.field558 == null) {
               class41.field558 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class41.field558.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class254.field3431);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - XGrandExchangeOffer.field300.stringWidth(var2)) / 2, 22);
            var4.drawImage(class41.field558, VertexNormal.field2020 / 2 - 152, class18.field311 / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = VertexNormal.field2020 / 2 - 152;
            int var8 = class18.field311 / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class254.field3431);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - XGrandExchangeOffer.field300.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LModel;IIIII)V",
      garbageValue = "-1011477807"
   )
   static final void method857(Model var0, int var1, int var2, int var3, int var4) {
      class7.field239.method3531(new class10(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-744124204"
   )
   protected void method858(String var1) {
      if(!this.field711) {
         this.field711 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-687724396"
   )
   Container method859() {
      return (Container)(this.field720 != null?this.field720:this);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)Lclass278;",
      garbageValue = "-514480001"
   )
   class278 method860() {
      Container var1 = this.method859();
      int var2 = Math.max(var1.getWidth(), this.field726);
      int var3 = Math.max(var1.getHeight(), this.field716);
      if(this.field720 != null) {
         Insets var4 = this.field720.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new class278(var2, var3);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected abstract void vmethod1143();

   static {
      field699 = null;
      field700 = 0;
      field701 = 0L;
      field702 = false;
      field705 = 20;
      field724 = 1;
      FPS = 0;
      field719 = new long[32];
      field714 = new long[32];
      field722 = 500;
      field729 = true;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1235496190"
   )
   protected final void method872(int var1, int var2, int var3) {
      try {
         if(field699 != null) {
            ++field700;
            if(field700 >= 3) {
               this.method858("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field699 = this;
         VertexNormal.field2020 = var1;
         class18.field311 = var2;
         class215.revision = var3;
         class152.field2236 = this;
         if(field721 == null) {
            field721 = new class154();
         }

         field721.method2936(this, 1);
      } catch (Exception var5) {
         class21.method138((String)null, var5);
         this.method858("crash");
      }

   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1675032808"
   )
   static final boolean method880() {
      return class134.field2018;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   protected abstract void packetHandler();

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-99"
   )
   protected final boolean method890() {
      return this.field720 != null;
   }

   public final void destroy() {
      if(field699 == this && !field702) {
         field701 = XGrandExchangeOffer.method96();
         class4.method9(5000L);
         this.method846();
      }
   }

   protected GameEngine() {
      this.field711 = false;
      this.field713 = 0;
      this.field698 = 0;
      this.field730 = true;
      this.field723 = false;
      this.field703 = false;
      this.field725 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field728 = var1;
      class51 var2 = new class51();
      class241.field3287 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lclass156;",
      garbageValue = "1113155578"
   )
   protected class156 method944() {
      if(this.field709 == null) {
         this.field709 = new class49();
         this.field709.method724(this.canvas);
      }

      return this.field709;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1378668389"
   )
   protected abstract void vmethod1147(boolean var1);

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void stop() {
      if(field699 == this && !field702) {
         field701 = XGrandExchangeOffer.method96() + 4000L;
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1150257272"
   )
   protected abstract void vmethod1148();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "10"
   )
   public static boolean method961(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-84"
   )
   protected abstract void vmethod1154();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2115996431"
   )
   protected final void method963(int var1, int var2) {
      if(var1 != this.field717 || var2 != this.field718) {
         this.method845();
      }

      this.field717 = var1;
      this.field718 = var2;
   }
}
