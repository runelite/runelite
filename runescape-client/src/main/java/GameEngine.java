import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 841247817
   )
   static int field1778 = 20;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = -1960198469
   )
   static int field1779 = 0;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      longValue = 5842987418357431749L
   )
   static long field1780 = 0L;
   @ObfuscatedName("pr")
   static GameEngine field1781 = null;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 1857538663
   )
   protected static int field1782 = 0;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -1048741889
   )
   static int field1783 = 500;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -1721311019
   )
   static int field1784 = 1;
   @ObfuscatedName("qg")
   protected static volatile boolean field1785 = false;
   @ObfuscatedName("qr")
   protected static long[] field1786 = new long[32];
   @ObfuscatedName("pt")
   boolean field1787;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 1854327455
   )
   protected static int field1788 = 0;
   @ObfuscatedName("pd")
   static boolean field1790 = false;
   @ObfuscatedName("qa")
   protected static long[] field1791 = new long[32];
   @ObfuscatedName("qs")
   protected static boolean field1792 = false;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 963695397
   )
   protected static int field1793 = 0;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      longValue = -6628677095738050369L
   )
   static volatile long field1794 = 0L;
   @ObfuscatedName("rg")
   static volatile boolean field1795 = true;
   @ObfuscatedName("qd")
   public static volatile boolean field1797 = true;

   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-999124169"
   )
   protected final void method2053(int var1, int var2, int var3) {
      try {
         if(field1781 != null) {
            ++field1779;
            if(field1779 >= 3) {
               this.method2068("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1781 = this;
         TextureProvider.field1200 = var1;
         class94.field1584 = var2;
         class101.field1646 = var3;
         class101.field1653 = this;
         if(Tile.field1346 == null) {
            Tile.field1346 = new class103();
         }

         Tile.field1346.method1939(this, 1);
      } catch (Exception var5) {
         FaceNormal.method1844((String)null, var5);
         this.method2068("crash");
      }

   }

   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-923277393"
   )
   protected final synchronized void method2054() {
      Container var1 = this.method2069();
      if(null != class36.canvas) {
         class36.canvas.removeFocusListener(this);
         var1.remove(class36.canvas);
      }

      TextureProvider.field1200 = Math.max(var1.getWidth(), class38.field809);
      class94.field1584 = Math.max(var1.getHeight(), WidgetNode.field185);
      Insets var2;
      if(class112.field1777 != null) {
         var2 = class112.field1777.getInsets();
         TextureProvider.field1200 -= var2.left + var2.right;
         class94.field1584 -= var2.bottom + var2.top;
      }

      class36.canvas = new RSCanvas(this);
      var1.add(class36.canvas);
      class36.canvas.setSize(TextureProvider.field1200, class94.field1584);
      class36.canvas.setVisible(true);
      if(class112.field1777 == var1) {
         var2 = class112.field1777.getInsets();
         class36.canvas.setLocation(var2.left + field1788, field1793 + var2.top);
      } else {
         class36.canvas.setLocation(field1788, field1793);
      }

      class36.canvas.addFocusListener(this);
      class36.canvas.requestFocus();
      field1797 = true;
      int var3 = TextureProvider.field1200;
      int var4 = class94.field1584;
      Canvas var5 = class36.canvas;

      Object var9;
      try {
         MainBufferProvider var6 = new MainBufferProvider();
         var6.init(var3, var4, var5);
         var9 = var6;
      } catch (Throwable var8) {
         SecondaryBufferProvider var7 = new SecondaryBufferProvider();
         var7.init(var3, var4, var5);
         var9 = var7;
      }

      if(null != TextureProvider.bufferProvider) {
         TextureProvider.bufferProvider.draw(((BufferProvider)var9).image.getGraphics(), 0, 0);
      }

      TextureProvider.bufferProvider = (BufferProvider)var9;
      field1785 = false;
      field1794 = class114.method2154();
   }

   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1626300504"
   )
   protected final boolean method2055() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(!var1.equals("mechscape.com") && !var1.endsWith(".mechscape.com")) {
               if(var1.endsWith("127.0.0.1")) {
                  return true;
               } else {
                  while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= 48 && var1.charAt(var1.length() - 1) <= 57) {
                     var1 = var1.substring(0, var1.length() - 1);
                  }

                  if(var1.endsWith("192.168.1.")) {
                     return true;
                  } else {
                     this.method2068("invalidhost");
                     return false;
                  }
               }
            } else {
               return true;
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
         if(class103.field1678 != null) {
            String var1 = class103.field1678.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1666;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2068("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class15.method179(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(Tile.method1520(var4) && FileOnDisk.method1403(var4) < 10) {
                     this.method2068("wrongjava");
                     return;
                  }
               }

               field1784 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2054();
         this.vmethod2064();
         class9.field77 = ChatLineBuffer.method889();

         while(0L == field1780 || class114.method2154() < field1780) {
            WidgetNode.field184 = class9.field77.vmethod2002(field1778, field1784);

            for(int var5 = 0; var5 < WidgetNode.field184; ++var5) {
               this.method2060();
            }

            this.method2056();
            CombatInfo1.method594(Tile.field1346, class36.canvas);
         }
      } catch (Exception var6) {
         FaceNormal.method1844((String)null, var6);
         this.method2068("crash");
      }

      this.method2094();
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "244"
   )
   void method2056() {
      Container var1 = this.method2069();
      long var2 = class114.method2154();
      long var4 = field1791[Buffer.field2108];
      field1791[Buffer.field2108] = var2;
      Buffer.field2108 = 1 + Buffer.field2108 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field1782 = (32000 + (var6 >> 1)) / var6;
      }

      if(++field1783 - 1 > 50) {
         field1783 -= 50;
         field1797 = true;
         class36.canvas.setSize(TextureProvider.field1200, class94.field1584);
         class36.canvas.setVisible(true);
         if(var1 == class112.field1777) {
            Insets var7 = class112.field1777.getInsets();
            class36.canvas.setLocation(var7.left + field1788, var7.top + field1793);
         } else {
            class36.canvas.setLocation(field1788, field1793);
         }
      }

      this.vmethod2091();
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1188581645"
   )
   void method2060() {
      long var1 = class114.method2154();
      long var3 = field1786[class37.field795];
      field1786[class37.field795] = var1;
      class37.field795 = class37.field795 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         Player.field270 = field1795;
      }

      this.packetHandler();
   }

   public final void focusGained(FocusEvent var1) {
      field1795 = true;
      field1797 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field1795 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "169773653"
   )
   protected abstract void vmethod2064();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1686960688"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1935400414"
   )
   protected abstract void vmethod2067();

   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1410394213"
   )
   protected void method2068(String var1) {
      if(!this.field1787) {
         this.field1787 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "809889746"
   )
   protected Container method2069() {
      return (Container)(class112.field1777 != null?class112.field1777:this);
   }

   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Dimension;",
      garbageValue = "-1"
   )
   protected Dimension method2070() {
      Container var1 = this.method2069();
      int var2 = Math.max(var1.getWidth(), class38.field809);
      int var3 = Math.max(var1.getHeight(), WidgetNode.field185);
      if(class112.field1777 != null) {
         Insets var4 = class112.field1777.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1315306595"
   )
   protected abstract void vmethod2071();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public void stop() {
      if(field1781 == this && !field1790) {
         field1780 = class114.method2154() + 4000L;
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(field1781 == this && !field1790) {
         field1797 = true;
         if(class103.field1666 != null && class103.field1666.startsWith("1.5") && class114.method2154() - field1794 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= TextureProvider.field1200 && var2.height >= class94.field1584) {
               field1785 = true;
            }
         }

      }
   }

   public void destroy() {
      if(this == field1781 && !field1790) {
         field1780 = class114.method2154();
         XClanMember.method237(5000L);
         this.method2094();
      }
   }

   public void start() {
      if(this == field1781 && !field1790) {
         field1780 = 0L;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1577952340"
   )
   protected abstract void vmethod2091();

   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   final synchronized void method2094() {
      if(!field1790) {
         field1790 = true;

         try {
            class36.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2067();
         } catch (Exception var4) {
            ;
         }

         if(class112.field1777 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != Tile.field1346) {
            try {
               Tile.field1346.method1916();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2071();
      }
   }
}
