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
   @ObfuscatedName("as")
   boolean field675;
   @ObfuscatedName("p")
   static GameEngine field676;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1128115199
   )
   static int field677;
   @ObfuscatedName("n")
   public static class154 field678;
   @ObfuscatedName("f")
   static boolean field679;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      longValue = 8669447344312178755L
   )
   volatile long field680;
   @ObfuscatedName("af")
   static volatile boolean field681;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1239430843
   )
   static int field682;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2135548521
   )
   static int field683;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 621412983
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 331803833
   )
   int field685;
   @ObfuscatedName("a")
   protected static long[] field687;
   @ObfuscatedName("b")
   protected static long[] field688;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 185604795
   )
   protected int field689;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1180029907
   )
   protected int field690;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 267157225
   )
   int field691;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 4244611870492840781L
   )
   static long field692;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1733729575
   )
   int field693;
   @ObfuscatedName("m")
   boolean field694;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 492360013
   )
   int field695;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1178861355
   )
   int field696;
   @ObfuscatedName("ah")
   volatile boolean field697;
   @ObfuscatedName("al")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("at")
   volatile boolean field699;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -32419353
   )
   static int field700;
   @ObfuscatedName("aq")
   final EventQueue field701;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1357549559
   )
   int field702;
   @ObfuscatedName("e")
   protected static class158 field703;
   @ObfuscatedName("ax")
   class49 field704;
   @ObfuscatedName("av")
   Clipboard field705;
   @ObfuscatedName("an")
   java.awt.Frame field706;
   @ObfuscatedName("gu")
   static ModIcon[] field707;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -50536641
   )
   static int field708;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -59995301
   )
   protected static int field709;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-910845355"
   )
   public final void method831(int var1, int var2) {
      if(this.field702 != var1 || this.field696 != var2) {
         this.method926();
      }

      this.field702 = var1;
      this.field696 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "1550762378"
   )
   final void method832(Object var1) {
      if(this.field701 != null) {
         for(int var2 = 0; var2 < 50 && this.field701.peekEvent() != null; ++var2) {
            DynamicObject.method1842(1L);
         }

         if(var1 != null) {
            this.field701.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lclass156;",
      garbageValue = "1648190563"
   )
   protected class156 method833() {
      if(this.field704 == null) {
         this.field704 = new class49();
         this.field704.method716(this.canvas);
      }

      return this.field704;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-54"
   )
   protected abstract void vmethod1140();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected final void method837() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(class59.mouse);
      var1.addMouseMotionListener(class59.mouse);
      var1.addFocusListener(class59.mouse);
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "10590"
   )
   void method839() {
      int var1 = this.field691;
      int var2 = this.field695;
      int var3 = this.field689 - class174.canvasWidth - var1;
      int var4 = this.field690 - class2.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.method860();
            int var6 = 0;
            int var7 = 0;
            if(this.field706 == var5) {
               Insets var8 = this.field706.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field690);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field689, var2);
            }

            if(var3 > 0) {
               var10.fillRect(this.field689 + var6 - var3, var7, var3, this.field690);
            }

            if(var4 > 0) {
               var10.fillRect(var6, this.field690 + var7 - var4, this.field689, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-128"
   )
   final void method840() {
      class14.method101(this.canvas);
      Canvas var1 = this.canvas;
      var1.removeMouseListener(class59.mouse);
      var1.removeMouseMotionListener(class59.mouse);
      var1.removeFocusListener(class59.mouse);
      class59.field712 = 0;
      if(this.field704 != null) {
         this.field704.method715(this.canvas);
      }

      this.method842();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(class50.keyboard);
      var2.addFocusListener(class50.keyboard);
      Canvas var3 = this.canvas;
      var3.addMouseListener(class59.mouse);
      var3.addMouseMotionListener(class59.mouse);
      var3.addFocusListener(class59.mouse);
      if(this.field704 != null) {
         this.field704.method716(this.canvas);
      }

      this.method926();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1847559885"
   )
   protected final void method841(int var1, int var2, int var3) {
      try {
         if(field676 != null) {
            ++field677;
            if(field677 >= 3) {
               this.method859("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field676 = this;
         class174.canvasWidth = var1;
         class2.canvasHeight = var2;
         class152.revision = var3;
         class15.field304 = this;
         if(field678 == null) {
            field678 = new class154();
         }

         field678.method2937(this, 1);
      } catch (Exception var5) {
         Projectile.method1734((String)null, var5);
         this.method859("crash");
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-325623529"
   )
   final synchronized void method842() {
      Container var1 = this.method860();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class174.canvasWidth = Math.max(var1.getWidth(), this.field693);
      class2.canvasHeight = Math.max(var1.getHeight(), this.field685);
      Insets var2;
      if(this.field706 != null) {
         var2 = this.field706.getInsets();
         class174.canvasWidth -= var2.left + var2.right;
         class2.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class174.canvasWidth, class2.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field706) {
         var2 = this.field706.getInsets();
         this.canvas.setLocation(this.field691 + var2.left, var2.top + this.field695);
      } else {
         this.canvas.setLocation(this.field691, this.field695);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field699 = true;
      if(class47.field601 != null && class174.canvasWidth == class47.field601.width && class47.field601.height == class2.canvasHeight) {
         ((MainBufferProvider)class47.field601).method813(this.canvas);
         class47.field601.vmethod5052(0, 0);
      } else {
         class47.field601 = new MainBufferProvider(class174.canvasWidth, class2.canvasHeight, this.canvas);
      }

      this.field697 = false;
      this.field680 = class134.method2587();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "237189426"
   )
   protected final boolean method843() {
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
                  this.method859("invalidhost");
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   public static int method844(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1171781121"
   )
   final void method847() {
      class278 var1 = this.method963();
      if(this.field689 != var1.field3739 || this.field690 != var1.field3738 || this.field675) {
         this.method900();
         this.field675 = false;
      }

   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-859055544"
   )
   final synchronized void method848() {
      if(!field679) {
         field679 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1194();
         } catch (Exception var4) {
            ;
         }

         if(this.field706 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(field678 != null) {
            try {
               field678.method2934();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1129();
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1294772132"
   )
   protected abstract void vmethod1467();

   public final void stop() {
      if(this == field676 && !field679) {
         field692 = class134.method2587() + 4000L;
      }
   }

   public final void destroy() {
      if(field676 == this && !field679) {
         field692 = class134.method2587();
         DynamicObject.method1842(5000L);
         this.method848();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(field676 == this && !field679) {
         this.field699 = true;
         if(class134.method2587() - this.field680 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class174.canvasWidth && var2.height >= class2.canvasHeight) {
               this.field697 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field681 = true;
      this.field699 = true;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void start() {
      if(this == field676 && !field679) {
         field692 = 0L;
      }
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1304530070"
   )
   void method855() {
      long var1 = class134.method2587();
      long var3 = field688[class43.field571];
      field688[class43.field571] = var1;
      class43.field571 = class43.field571 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         ScriptState.field760 = field681;
      }

      this.packetHandler();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   protected abstract void vmethod1194();

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "991926305"
   )
   protected final void method857(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class15.field298 == null) {
            class15.field298 = new java.awt.Font("Helvetica", 1, 13);
            GroundObject.field1880 = this.canvas.getFontMetrics(class15.field298);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class174.canvasWidth, class2.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class19.field330 == null) {
               class19.field330 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class19.field330.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class15.field298);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - GroundObject.field1880.stringWidth(var2)) / 2, 22);
            var4.drawImage(class19.field330, class174.canvasWidth / 2 - 152, class2.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class174.canvasWidth / 2 - 152;
            int var8 = class2.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + 2 + var1 * 3, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class15.field298);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - GroundObject.field1880.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1511589132"
   )
   protected final void method858() {
      class19.field330 = null;
      class15.field298 = null;
      GroundObject.field1880 = null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1886892889"
   )
   protected void method859(String var1) {
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

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-879527179"
   )
   Container method860() {
      return (Container)(this.field706 != null?this.field706:this);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1200232218"
   )
   void method861() {
      Container var1 = this.method860();
      long var2 = class134.method2587();
      long var4 = field687[class222.field2837];
      field687[class222.field2837] = var2;
      class222.field2837 = class222.field2837 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field700 - 1 > 50) {
         field700 -= 50;
         this.field699 = true;
         this.canvas.setSize(class174.canvasWidth, class2.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field706) {
            Insets var7 = this.field706.getInsets();
            this.canvas.setLocation(this.field691 + var7.left, var7.top + this.field695);
         } else {
            this.canvas.setLocation(this.field691, this.field695);
         }
      }

      if(this.field697) {
         this.method840();
      }

      this.method847();
      this.vmethod1169(this.field699);
      if(this.field699) {
         this.method839();
      }

      this.field699 = false;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1928402064"
   )
   protected final boolean method862() {
      return this.field706 != null;
   }

   public abstract void init();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1999037993"
   )
   protected final void method871() {
      class36.method493();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class50.keyboard);
      var1.addFocusListener(class50.keyboard);
   }

   static {
      field676 = null;
      field677 = 0;
      field692 = 0L;
      field679 = false;
      field682 = 20;
      field683 = 1;
      FPS = 0;
      field687 = new long[32];
      field688 = new long[32];
      field700 = 500;
      field681 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1160867796"
   )
   final void method900() {
      Container var1 = this.method860();
      if(var1 != null) {
         class278 var2 = this.method963();
         this.field689 = Math.max(var2.field3739, this.field693);
         this.field690 = Math.max(var2.field3738, this.field685);
         if(this.field689 <= 0) {
            this.field689 = 1;
         }

         if(this.field690 <= 0) {
            this.field690 = 1;
         }

         class174.canvasWidth = Math.min(this.field689, this.field702);
         class2.canvasHeight = Math.min(this.field690, this.field696);
         this.field691 = (this.field689 - class174.canvasWidth) / 2;
         this.field695 = 0;
         this.canvas.setSize(class174.canvasWidth, class2.canvasHeight);
         class47.field601 = new MainBufferProvider(class174.canvasWidth, class2.canvasHeight, this.canvas);
         if(this.field706 == var1) {
            Insets var3 = this.field706.getInsets();
            this.canvas.setLocation(var3.left + this.field691, var3.top + this.field695);
         } else {
            this.canvas.setLocation(this.field691, this.field695);
         }

         this.field699 = true;
         this.vmethod1140();
      }
   }

   public void run() {
      try {
         if(class154.field2241 != null) {
            String var1 = class154.field2241.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class154.field2242;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method859("wrongjava");
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
                  if(class157.method2977(var6) && class214.method3998(var6) < 10) {
                     this.method859("wrongjava");
                     return;
                  }
               }

               field683 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method842();
         this.vmethod1467();

         Object var10;
         try {
            var10 = new class150();
         } catch (Throwable var8) {
            var10 = new class151();
         }

         field703 = (class158)var10;

         while(0L == field692 || class134.method2587() < field692) {
            field709 = field703.vmethod2985(field682, field683);

            for(int var7 = 0; var7 < field709; ++var7) {
               this.method855();
            }

            this.method861();
            this.method832(this.canvas);
         }
      } catch (Exception var9) {
         Projectile.method1734((String)null, var9);
         this.method859("crash");
      }

      this.method848();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1018771065"
   )
   protected abstract void vmethod1169(boolean var1);

   protected GameEngine() {
      this.field694 = false;
      this.field691 = 0;
      this.field695 = 0;
      this.field699 = true;
      this.field675 = false;
      this.field697 = false;
      this.field680 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field701 = var1;
      class69.method1069(new class51());
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "10590"
   )
   protected void method921() {
      this.field705 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "96"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1363251910"
   )
   final void method926() {
      this.field675 = true;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1434759054"
   )
   protected void method936(String var1) {
      this.field705.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   public final void focusLost(FocusEvent var1) {
      field681 = false;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   protected abstract void vmethod1129();

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)Lclass278;",
      garbageValue = "-1"
   )
   class278 method963() {
      Container var1 = this.method860();
      int var2 = Math.max(var1.getWidth(), this.field693);
      int var3 = Math.max(var1.getHeight(), this.field685);
      if(this.field706 != null) {
         Insets var4 = this.field706.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new class278(var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IB)I",
      garbageValue = "6"
   )
   public static int method965(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = class14.method91(var9);
         var8 = class14.method91(var10);
         var9 = class3.method10(var9, var2);
         var10 = class3.method10(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return class40.method544(var9, var2) - class40.method544(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var11 != var12) {
               return class40.method544(var11, var2) - class40.method544(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var12 != var13) {
               return class40.method544(var12, var2) - class40.method544(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)[Lclass257;",
      garbageValue = "0"
   )
   static class257[] method966() {
      return new class257[]{class257.field3552, class257.field3555, class257.field3553};
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LModIcon;",
      garbageValue = "1115776578"
   )
   public static ModIcon method967() {
      ModIcon var0 = new ModIcon();
      var0.width = NPC.field1377;
      var0.originalHeight = class286.field3791;
      var0.offsetX = class95.field1493[0];
      var0.offsetY = class286.field3790[0];
      var0.originalWidth = class286.field3793[0];
      var0.height = class241.field3293[0];
      var0.palette = class174.field2410;
      var0.pixels = class31.field449[0];
      VertexNormal.method2592();
      return var0;
   }
}
