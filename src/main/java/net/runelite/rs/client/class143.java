package net.runelite.rs.client;

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
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
@Implements("GameEngine")
public abstract class class143 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("cs")
   static class223 field2174;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 1729852219
   )
   static int field2175 = 0;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      longValue = 7490976445048045437L
   )
   static long field2176 = 0L;
   @ObfuscatedName("pp")
   boolean field2178;
   @ObfuscatedName("ps")
   static boolean field2179 = false;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 827554445
   )
   static int field2180 = 1;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -587476029
   )
   @Export("fPS")
   protected static int field2181 = 0;
   @ObfuscatedName("qr")
   protected static long[] field2182 = new long[32];
   @ObfuscatedName("qy")
   protected static long[] field2183 = new long[32];
   @ObfuscatedName("pj")
   static class143 field2184 = null;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -16801463
   )
   protected static int field2185 = 0;
   @ObfuscatedName("qh")
   public static volatile boolean field2186 = true;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 1163027843
   )
   static int field2187 = 20;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -1582519083
   )
   protected static int field2188 = 0;
   @ObfuscatedName("ql")
   protected static volatile boolean field2189 = false;
   @ObfuscatedName("rf")
   @ObfuscatedGetter(
      longValue = 3372573524222138629L
   )
   static volatile long field2190 = 0L;
   @ObfuscatedName("qs")
   protected static boolean field2191 = false;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -1322903237
   )
   static int field2192 = 500;
   @ObfuscatedName("pv")
   static class220 field2193;
   @ObfuscatedName("rx")
   static volatile boolean field2194 = true;

   public final synchronized void paint(Graphics var1) {
      if(field2184 == this && !field2179) {
         field2186 = true;
         if(null != class135.field2080 && class135.field2080.startsWith("1.5") && class92.method2177() - field2190 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class129.field2048 && var2.height >= class136.field2101) {
               field2189 = true;
            }
         }

      }
   }

   @ObfuscatedName("qp")
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
                     this.method3058("invalidhost");
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
         if(null != class135.field2089) {
            String var1 = class135.field2089.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class135.field2080;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3058("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class42.method943(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class18.method222(var4)) {
                     int var5 = client.method585(var4, 10);
                     if(var5 < 10) {
                        this.method3058("wrongjava");
                        return;
                     }
                  }
               }

               field2180 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3051();
         this.vmethod3054();

         Object var8;
         try {
            var8 = new class146();
         } catch (Throwable var6) {
            var8 = new class140();
         }

         class45.field1026 = (class132)var8;

         while(field2176 == 0L || class92.method2177() < field2176) {
            class102.field1751 = class45.field1026.vmethod3158(field2187, field2180);

            for(int var9 = 0; var9 < class102.field1751; ++var9) {
               this.method3046();
            }

            this.method3130();
            class28.method697(class25.field630, class17.field244);
         }
      } catch (Exception var7) {
         class37.method803((String)null, var7);
         this.method3058("crash");
      }

      this.method3048();
   }

   @ObfuscatedName("qu")
   void method3046() {
      long var1 = class92.method2177();
      long var3 = field2183[class29.field671];
      field2183[class29.field671] = var1;
      class29.field671 = class29.field671 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class86.field1516 = field2194;
      }

      this.vmethod3096();
   }

   @ObfuscatedName("qb")
   final synchronized void method3048() {
      if(!field2179) {
         field2179 = true;

         try {
            class17.field244.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3050();
         } catch (Exception var4) {
            ;
         }

         if(null != class39.field902) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class25.field630 != null) {
            try {
               class25.field630.method2912();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3061();
      }
   }

   @ObfuscatedName("i")
   protected abstract void vmethod3050();

   @ObfuscatedName("qq")
   protected final synchronized void method3051() {
      Container var1 = this.method3059();
      if(class17.field244 != null) {
         class17.field244.removeFocusListener(this);
         var1.remove(class17.field244);
      }

      class129.field2048 = Math.max(var1.getWidth(), class8.field143);
      class136.field2101 = Math.max(var1.getHeight(), class107.field1885);
      Insets var2;
      if(null != class39.field902) {
         var2 = class39.field902.getInsets();
         class129.field2048 -= var2.right + var2.left;
         class136.field2101 -= var2.top + var2.bottom;
      }

      class17.field244 = new class138(this);
      var1.add(class17.field244);
      class17.field244.setSize(class129.field2048, class136.field2101);
      class17.field244.setVisible(true);
      if(class39.field902 == var1) {
         var2 = class39.field902.getInsets();
         class17.field244.setLocation(var2.left + field2188, field2185 + var2.top);
      } else {
         class17.field244.setLocation(field2188, field2185);
      }

      class17.field244.addFocusListener(this);
      class17.field244.requestFocus();
      field2186 = true;
      int var3 = class129.field2048;
      int var4 = class136.field2101;
      Canvas var5 = class17.field244;

      Object var9;
      try {
         class81 var6 = new class81();
         var6.vmethod1896(var3, var4, var5);
         var9 = var6;
      } catch (Throwable var8) {
         class75 var7 = new class75();
         var7.vmethod1896(var3, var4, var5);
         var9 = var7;
      }

      if(class84.field1440 != null) {
         class84.field1440.vmethod1895(((class77)var9).field1382.getGraphics(), 0, 0);
      }

      class84.field1440 = (class77)var9;
      field2189 = false;
      field2190 = class92.method2177();
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      field2194 = true;
      field2186 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2194 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public void destroy() {
      if(field2184 == this && !field2179) {
         field2176 = class92.method2177();
         class29.method711(5000L);
         this.method3048();
      }
   }

   public abstract void init();

   @ObfuscatedName("u")
   protected abstract void vmethod3054();

   @ObfuscatedName("h")
   protected abstract void vmethod3056();

   @ObfuscatedName("qm")
   protected void method3058(String var1) {
      if(!this.field2178) {
         this.field2178 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qi")
   protected Container method3059() {
      return (Container)(null != class39.field902?class39.field902:this);
   }

   @ObfuscatedName("qd")
   protected Dimension method3060() {
      Container var1 = this.method3059();
      int var2 = Math.max(var1.getWidth(), class8.field143);
      int var3 = Math.max(var1.getHeight(), class107.field1885);
      if(null != class39.field902) {
         Insets var4 = class39.field902.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("m")
   protected abstract void vmethod3061();

   public void stop() {
      if(field2184 == this && !field2179) {
         field2176 = class92.method2177() + 4000L;
      }
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("a")
   protected abstract void vmethod3096();

   public void start() {
      if(this == field2184 && !field2179) {
         field2176 = 0L;
      }
   }

   @ObfuscatedName("qz")
   void method3130() {
      Container var1 = this.method3059();
      long var2 = class92.method2177();
      long var4 = field2182[class42.field988];
      field2182[class42.field988] = var2;
      class42.field988 = 1 + class42.field988 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2181 = (32000 + (var6 >> 1)) / var6;
      }

      if(++field2192 - 1 > 50) {
         field2192 -= 50;
         field2186 = true;
         class17.field244.setSize(class129.field2048, class136.field2101);
         class17.field244.setVisible(true);
         if(class39.field902 == var1) {
            Insets var7 = class39.field902.getInsets();
            class17.field244.setLocation(field2188 + var7.left, var7.top + field2185);
         } else {
            class17.field244.setLocation(field2188, field2185);
         }
      }

      this.vmethod3056();
   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("qg")
   protected final void method3140(int var1, int var2, int var3) {
      try {
         if(null != field2184) {
            ++field2175;
            if(field2175 >= 3) {
               this.method3058("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2184 = this;
         class129.field2048 = var1;
         class136.field2101 = var2;
         class147.field2207 = var3;
         class147.field2208 = this;
         if(null == class25.field630) {
            class25.field630 = new class135();
         }

         class25.field630.method2919(this, 1);
      } catch (Exception var5) {
         class37.method803((String)null, var5);
         this.method3058("crash");
      }

   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("j")
   public static int method3144(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(1 == var2?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("cu")
   static final String[] method3145(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
