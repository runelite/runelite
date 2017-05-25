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
   @ObfuscatedName("i")
   public static class154 field682;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 654133689
   )
   int field683;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -7225497310474359279L
   )
   static long field684;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 269832625
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1520301569
   )
   protected int field686;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -48618797
   )
   static int field687;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -969016831
   )
   static int field688;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -426037629
   )
   int field689;
   @ObfuscatedName("b")
   protected static long[] field690;
   @ObfuscatedName("j")
   protected static long[] field691;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1243364247
   )
   protected int field692;
   @ObfuscatedName("h")
   static GameEngine field693;
   @ObfuscatedName("ax")
   volatile boolean field694;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1171491031
   )
   int field695;
   @ObfuscatedName("ap")
   final EventQueue field696;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 822327397
   )
   int field697;
   @ObfuscatedName("am")
   Clipboard field698;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -2020563923
   )
   int field699;
   @ObfuscatedName("af")
   java.awt.Frame field700;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -81394747
   )
   int field701;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -43635811
   )
   static int field703;
   @ObfuscatedName("ae")
   boolean field704;
   @ObfuscatedName("ar")
   volatile boolean field705;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      longValue = -4193330002536700869L
   )
   volatile long field706;
   @ObfuscatedName("ao")
   class49 field707;
   @ObfuscatedName("aj")
   Canvas field708;
   @ObfuscatedName("v")
   boolean field709;
   @ObfuscatedName("as")
   static volatile boolean field710;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -277280891
   )
   static int field711;
   @ObfuscatedName("g")
   static boolean field712;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1135630599"
   )
   public final void method841(int var1, int var2) {
      if(this.field683 != var1 || var2 != this.field699) {
         this.method898();
      }

      this.field683 = var1;
      this.field699 = var2;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "123"
   )
   protected final void method842(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.field708.getGraphics();
         if(ChatLineBuffer.field1552 == null) {
            ChatLineBuffer.field1552 = new java.awt.Font("Helvetica", 1, 13);
            class73.field850 = this.field708.getFontMetrics(ChatLineBuffer.field1552);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class261.field3626, class19.field320);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class40.field539 == null) {
               class40.field539 = this.field708.createImage(304, 34);
            }

            Graphics var6 = class40.field539.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(ChatLineBuffer.field1552);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class73.field850.stringWidth(var2)) / 2, 22);
            var4.drawImage(class40.field539, class261.field3626 / 2 - 152, class19.field320 / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class261.field3626 / 2 - 152;
            int var8 = class19.field320 / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(ChatLineBuffer.field1552);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class73.field850.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.field708.repaint();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lclass156;",
      garbageValue = "-1546374850"
   )
   protected class156 method843() {
      if(this.field707 == null) {
         this.field707 = new class49();
         this.field707.method741(this.field708);
      }

      return this.field707;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1788474962"
   )
   protected void method844(String var1) {
      this.field698.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1309227167"
   )
   protected final void method846() {
      PlayerComposition.method4040(this.field708);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-62"
   )
   final synchronized void method847() {
      if(!field712) {
         field712 = true;

         try {
            this.field708.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1234();
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

         if(field682 != null) {
            try {
               field682.method2990();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1169();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   protected abstract void vmethod1402();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-31"
   )
   void method849() {
      int var1 = this.field689;
      int var2 = this.field695;
      int var3 = this.field692 - class261.field3626 - var1;
      int var4 = this.field686 - class19.field320 - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.method871();
            int var6 = 0;
            int var7 = 0;
            if(this.field700 == var5) {
               Insets var8 = this.field700.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field686);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field692, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field692 - var3, var7, var3, this.field686);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field686 - var4, this.field692, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "233171277"
   )
   protected final void method851(int var1, int var2, int var3) {
      try {
         if(field693 != null) {
            ++field711;
            if(field711 >= 3) {
               this.method973("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field693 = this;
         class261.field3626 = var1;
         class19.field320 = var2;
         class152.revision = var3;
         class152.field2201 = this;
         if(field682 == null) {
            field682 = new class154();
         }

         field682.method2969(this, 1);
      } catch (Exception var5) {
         Game.method4169((String)null, var5);
         this.method973("crash");
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "918788102"
   )
   final synchronized void method852() {
      Container var1 = this.method871();
      if(this.field708 != null) {
         this.field708.removeFocusListener(this);
         var1.remove(this.field708);
      }

      class261.field3626 = Math.max(var1.getWidth(), this.field701);
      class19.field320 = Math.max(var1.getHeight(), this.field697);
      Insets var2;
      if(this.field700 != null) {
         var2 = this.field700.getInsets();
         class261.field3626 -= var2.right + var2.left;
         class19.field320 -= var2.top + var2.bottom;
      }

      this.field708 = new RSCanvas(this);
      var1.add(this.field708);
      this.field708.setSize(class261.field3626, class19.field320);
      this.field708.setVisible(true);
      this.field708.setBackground(Color.BLACK);
      if(this.field700 == var1) {
         var2 = this.field700.getInsets();
         this.field708.setLocation(var2.left + this.field689, this.field695 + var2.top);
      } else {
         this.field708.setLocation(this.field689, this.field695);
      }

      this.field708.addFocusListener(this);
      this.field708.requestFocus();
      this.field694 = true;
      if(class40.field541 != null && class40.field541.width == class261.field3626 && class40.field541.height == class19.field320) {
         ((MainBufferProvider)class40.field541).method827(this.field708);
         class40.field541.vmethod5083(0, 0);
      } else {
         class40.field541 = new MainBufferProvider(class261.field3626, class19.field320, this.field708);
      }

      this.field705 = false;
      this.field706 = class226.method4147();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1811014886"
   )
   protected final boolean method853() {
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
                  this.method973("invalidhost");
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "325712856"
   )
   protected final void method854() {
      if(class154.field2215.toLowerCase().indexOf("microsoft") != -1) {
         class50.field637[186] = 57;
         class50.field637[187] = 27;
         class50.field637[188] = 71;
         class50.field637[189] = 26;
         class50.field637[190] = 72;
         class50.field637[191] = 73;
         class50.field637[192] = 58;
         class50.field637[219] = 42;
         class50.field637[220] = 74;
         class50.field637[221] = 43;
         class50.field637[222] = 59;
         class50.field637[223] = 28;
      } else {
         class50.field637[44] = 71;
         class50.field637[45] = 26;
         class50.field637[46] = 72;
         class50.field637[47] = 73;
         class50.field637[59] = 57;
         class50.field637[61] = 27;
         class50.field637[91] = 42;
         class50.field637[92] = 74;
         class50.field637[93] = 43;
         class50.field637[192] = 28;
         class50.field637[222] = 58;
         class50.field637[520] = 59;
      }

      Canvas var1 = this.field708;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class50.keyboard);
      var1.addFocusListener(class50.keyboard);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "628316190"
   )
   void method855() {
      long var1 = class226.method4147();
      long var3 = field691[class89.field1385];
      field691[class89.field1385] = var1;
      class89.field1385 = class89.field1385 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class219.field2794 = field710;
      }

      this.packetHandler();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-5041"
   )
   void method856() {
      Container var1 = this.method871();
      long var2 = class226.method4147();
      long var4 = field690[class231.field3178];
      field690[class231.field3178] = var2;
      class231.field3178 = class231.field3178 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field703 - 1 > 50) {
         field703 -= 50;
         this.field694 = true;
         this.field708.setSize(class261.field3626, class19.field320);
         this.field708.setVisible(true);
         if(this.field700 == var1) {
            Insets var7 = this.field700.getInsets();
            this.field708.setLocation(this.field689 + var7.left, this.field695 + var7.top);
         } else {
            this.field708.setLocation(this.field689, this.field695);
         }
      }

      if(this.field705) {
         this.method957();
      }

      this.method857();
      this.vmethod1173(this.field694);
      if(this.field694) {
         this.method849();
      }

      this.field694 = false;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1580671128"
   )
   final void method857() {
      class278 var1 = this.method891();
      if(var1.field3735 != this.field692 || var1.field3734 != this.field686 || this.field704) {
         this.method899();
         this.field704 = false;
      }

   }

   protected GameEngine() {
      this.field709 = false;
      this.field689 = 0;
      this.field695 = 0;
      this.field694 = true;
      this.field704 = false;
      this.field705 = false;
      this.field706 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field696 = var1;
      class3.method3(new class51());
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1750808323"
   )
   protected abstract void vmethod1173(boolean var1);

   public abstract void init();

   public final void destroy() {
      if(this == field693 && !field712) {
         field684 = class226.method4147();
         class19.method145(5000L);
         this.method847();
      }
   }

   static {
      field693 = null;
      field711 = 0;
      field684 = 0L;
      field712 = false;
      field687 = 20;
      field688 = 1;
      FPS = 0;
      field690 = new long[32];
      field691 = new long[32];
      field703 = 500;
      field710 = true;
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field693 && !field712) {
         this.field694 = true;
         if(class226.method4147() - this.field706 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class261.field3626 && var2.height >= class19.field320) {
               this.field705 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field710 = true;
      this.field694 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field710 = false;
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "1339564964"
   )
   final void method862(Object var1) {
      if(this.field696 != null) {
         for(int var2 = 0; var2 < 50 && this.field696.peekEvent() != null; ++var2) {
            class19.method145(1L);
         }

         if(var1 != null) {
            this.field696.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "930621903"
   )
   public static int method866(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2062961080"
   )
   protected abstract void vmethod1234();

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "11"
   )
   protected final void method869() {
      class40.field539 = null;
      ChatLineBuffer.field1552 = null;
      class73.field850 = null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-109"
   )
   protected void method870() {
      this.field698 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "206371213"
   )
   Container method871() {
      return (Container)(this.field700 != null?this.field700:this);
   }

   public final void stop() {
      if(this == field693 && !field712) {
         field684 = class226.method4147() + 4000L;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "9492279"
   )
   protected final boolean method873() {
      return this.field700 != null;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1281079806"
   )
   protected abstract void vmethod1171();

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Lclass278;",
      garbageValue = "1789714330"
   )
   class278 method891() {
      Container var1 = this.method871();
      int var2 = Math.max(var1.getWidth(), this.field701);
      int var3 = Math.max(var1.getHeight(), this.field697);
      if(this.field700 != null) {
         Insets var4 = this.field700.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new class278(var2, var3);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1770292631"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-532651742"
   )
   final void method898() {
      this.field704 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1031137216"
   )
   final void method899() {
      Container var1 = this.method871();
      if(var1 != null) {
         class278 var2 = this.method891();
         this.field692 = Math.max(var2.field3735, this.field701);
         this.field686 = Math.max(var2.field3734, this.field697);
         if(this.field692 <= 0) {
            this.field692 = 1;
         }

         if(this.field686 <= 0) {
            this.field686 = 1;
         }

         class261.field3626 = Math.min(this.field692, this.field683);
         class19.field320 = Math.min(this.field686, this.field699);
         this.field689 = (this.field692 - class261.field3626) / 2;
         this.field695 = 0;
         this.field708.setSize(class261.field3626, class19.field320);
         class40.field541 = new MainBufferProvider(class261.field3626, class19.field320, this.field708);
         if(var1 == this.field700) {
            Insets var3 = this.field700.getInsets();
            this.field708.setLocation(this.field689 + var3.left, this.field695 + var3.top);
         } else {
            this.field708.setLocation(this.field689, this.field695);
         }

         this.field694 = true;
         this.vmethod1402();
      }
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public void run() {
      try {
         if(class154.field2215 != null) {
            String var1 = class154.field2215.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class154.field2213;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method973("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class233.method4170(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class269.method4931(var4) && Friend.method1098(var4) < 10) {
                     this.method973("wrongjava");
                     return;
                  }
               }

               field688 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method852();
         this.vmethod1171();

         Object var8;
         try {
            var8 = new class150();
         } catch (Throwable var6) {
            var8 = new class151();
         }

         class234.field3197 = (class158)var8;

         while(field684 == 0L || class226.method4147() < field684) {
            class64.field786 = class234.field3197.vmethod3022(field687, field688);

            for(int var5 = 0; var5 < class64.field786; ++var5) {
               this.method855();
            }

            this.method856();
            this.method862(this.field708);
         }
      } catch (Exception var7) {
         Game.method4169((String)null, var7);
         this.method973("crash");
      }

      this.method847();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "78"
   )
   protected abstract void vmethod1169();

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "849604058"
   )
   final void method957() {
      Canvas var1 = this.field708;
      var1.removeKeyListener(class50.keyboard);
      var1.removeFocusListener(class50.keyboard);
      class50.field628 = -1;
      class87.method1737(this.field708);
      if(this.field707 != null) {
         this.field707.method742(this.field708);
      }

      this.method852();
      Canvas var2 = this.field708;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(class50.keyboard);
      var2.addFocusListener(class50.keyboard);
      PlayerComposition.method4040(this.field708);
      if(this.field707 != null) {
         this.field707.method741(this.field708);
      }

      this.method898();
   }

   public final void start() {
      if(field693 == this && !field712) {
         field684 = 0L;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1666662226"
   )
   protected void method973(String var1) {
      if(!this.field709) {
         this.field709 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }
}
