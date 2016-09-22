import java.applet.Applet;
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
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ph")
   boolean field2260;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -1295888399
   )
   static int field2261 = 500;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      longValue = -697977240101076387L
   )
   static long field2262 = 0L;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -2107303915
   )
   protected static int field2263 = 0;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 1644686445
   )
   static int field2264 = 0;
   @ObfuscatedName("qs")
   protected static boolean field2265 = false;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -179492889
   )
   static int field2266 = 1;
   @ObfuscatedName("pt")
   static GameEngine field2267 = null;
   @ObfuscatedName("qo")
   protected static long[] field2268 = new long[32];
   @ObfuscatedName("qm")
   protected static long[] field2269 = new long[32];
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 783265029
   )
   protected static int field2270 = 0;
   @ObfuscatedName("po")
   static boolean field2271 = false;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 1972061569
   )
   static int field2272 = 20;
   @ObfuscatedName("qf")
   protected static volatile boolean field2273 = true;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -841829169
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("qg")
   protected static volatile boolean field2275 = false;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      longValue = 5331238865708554673L
   )
   static volatile long field2276 = 0L;
   @ObfuscatedName("ra")
   static volatile boolean field2277 = true;

   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   protected final boolean method3045() {
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
                     this.method3057("invalidhost");
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
         if(class139.field2162 != null) {
            String var1 = class139.field2162.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class139.field2161;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3057("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && SecondaryBufferProvider.method1668(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(BufferProvider.method1715(var4)) {
                     int var5 = class145.method3020(var4, 10, true);
                     if(var5 < 10) {
                        this.method3057("wrongjava");
                        return;
                     }
                  }
               }

               field2266 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3069();
         this.vmethod3053();

         Object var9;
         try {
            var9 = new class150();
         } catch (Throwable var7) {
            var9 = new class144();
         }

         DecorativeObject.field1699 = (class136)var9;

         while(field2262 == 0L || class5.method63() < field2262) {
            TextureProvider.field1702 = DecorativeObject.field1699.vmethod3149(field2272, field2266);

            for(int var6 = 0; var6 < TextureProvider.field1702; ++var6) {
               this.method3046();
            }

            this.method3048();
            class129.method2857(class126.field2103, class79.canvas);
         }
      } catch (Exception var8) {
         class128.method2843((String)null, var8);
         this.method3057("crash");
      }

      this.method3123();
   }

   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "799625429"
   )
   void method3046() {
      long var1 = class5.method63();
      long var3 = field2269[class139.field2168];
      field2269[class139.field2168] = var1;
      class139.field2168 = class139.field2168 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         XClanMember.field632 = field2277;
      }

      this.packetHandler();
   }

   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "179099949"
   )
   void method3048() {
      Container var1 = this.method3058();
      long var2 = class5.method63();
      long var4 = field2268[ChatLineBuffer.field701];
      field2268[ChatLineBuffer.field701] = var2;
      ChatLineBuffer.field701 = 1 + ChatLineBuffer.field701 & 31;
      if(var4 != 0L && var2 > var4) {
         int var7 = (int)(var2 - var4);
         FPS = ((var7 >> 1) + 32000) / var7;
      }

      if(++field2261 - 1 > 50) {
         field2261 -= 50;
         field2273 = true;
         class79.canvas.setSize(class159.field2374, class92.field1643);
         class79.canvas.setVisible(true);
         if(var1 == WallObject.field1621) {
            Insets var6 = WallObject.field1621.getInsets();
            class79.canvas.setLocation(var6.left + field2270, var6.top + field2263);
         } else {
            class79.canvas.setLocation(field2270, field2263);
         }
      }

      this.vmethod3066();
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2267 && !field2271) {
         field2273 = true;
         if(null != class139.field2161 && class139.field2161.startsWith("1.5") && class5.method63() - field2276 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class159.field2374 && var2.height >= class92.field1643) {
               field2275 = true;
            }
         }

      }
   }

   public void stop() {
      if(field2267 == this && !field2271) {
         field2262 = class5.method63() + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      field2277 = true;
      field2273 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2277 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "14570"
   )
   protected abstract void vmethod3053();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-81"
   )
   protected abstract void vmethod3055();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-66"
   )
   protected abstract void vmethod3056();

   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2086707387"
   )
   protected void method3057(String var1) {
      if(!this.field2260) {
         this.field2260 = true;
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
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "11"
   )
   protected Container method3058() {
      return (Container)(null != WallObject.field1621?WallObject.field1621:this);
   }

   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "-718375752"
   )
   protected Dimension method3059() {
      Container var1 = this.method3058();
      int var2 = Math.max(var1.getWidth(), class93.field1648);
      int var3 = Math.max(var1.getHeight(), class9.field151);
      if(WallObject.field1621 != null) {
         Insets var4 = WallObject.field1621.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   protected abstract void vmethod3066();

   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1061347968"
   )
   protected final synchronized void method3069() {
      Container var1 = this.method3058();
      if(null != class79.canvas) {
         class79.canvas.removeFocusListener(this);
         var1.remove(class79.canvas);
      }

      class159.field2374 = Math.max(var1.getWidth(), class93.field1648);
      class92.field1643 = Math.max(var1.getHeight(), class9.field151);
      Insets var2;
      if(null != WallObject.field1621) {
         var2 = WallObject.field1621.getInsets();
         class159.field2374 -= var2.right + var2.left;
         class92.field1643 -= var2.bottom + var2.top;
      }

      class79.canvas = new RSCanvas(this);
      var1.add(class79.canvas);
      class79.canvas.setSize(class159.field2374, class92.field1643);
      class79.canvas.setVisible(true);
      if(var1 == WallObject.field1621) {
         var2 = WallObject.field1621.getInsets();
         class79.canvas.setLocation(field2270 + var2.left, var2.top + field2263);
      } else {
         class79.canvas.setLocation(field2270, field2263);
      }

      class79.canvas.addFocusListener(this);
      class79.canvas.requestFocus();
      field2273 = true;
      BufferProvider var3 = class1.method10(class159.field2374, class92.field1643, class79.canvas);
      if(null != Buffer.bufferProvider) {
         Buffer.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      Buffer.bufferProvider = var3;
      field2275 = false;
      field2276 = class5.method63();
   }

   public abstract void init();

   public void start() {
      if(this == field2267 && !field2271) {
         field2262 = 0L;
      }
   }

   public void destroy() {
      if(this == field2267 && !field2271) {
         field2262 = class5.method63();
         Item.method681(5000L);
         this.method3123();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1647699249"
   )
   protected abstract void packetHandler();

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2032042522"
   )
   protected final void method3114(int var1, int var2, int var3) {
      try {
         if(null != field2267) {
            ++field2264;
            if(field2264 >= 3) {
               this.method3057("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2267 = this;
         class159.field2374 = var1;
         class92.field1643 = var2;
         class151.field2293 = var3;
         class151.field2291 = this;
         if(null == class126.field2103) {
            class126.field2103 = new class139();
         }

         class126.field2103.method2934(this, 1);
      } catch (Exception var5) {
         class128.method2843((String)null, var5);
         this.method3057("crash");
      }

   }

   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1161949710"
   )
   final synchronized void method3123() {
      if(!field2271) {
         field2271 = true;

         try {
            class79.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3056();
         } catch (Exception var4) {
            ;
         }

         if(WallObject.field1621 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class126.field2103) {
            try {
               class126.field2103.method2916();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3055();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1390000400"
   )
   static void method3132(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3817((long)var0);
      if(null != var1) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "-1546082053"
   )
   static int method3133(Widget var0) {
      class204 var1 = (class204)Client.widgetFlags.method3817(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.field3155:var0.field2888;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1768795084"
   )
   static void method3134(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class21.method572(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method3134(var0, var7 - 1, var2, var3, var4, var5);
         method3134(1 + var7, var1, var2, var3, var4, var5);
      }

   }
}
