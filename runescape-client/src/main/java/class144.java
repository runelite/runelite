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
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("GameEngine")
public abstract class class144 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -953612923
   )
   protected static int field2190 = 0;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -1378347019
   )
   static int field2191 = 0;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      longValue = -2042337238026216797L
   )
   static long field2192 = 0L;
   @ObfuscatedName("pt")
   static boolean field2193 = false;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -958342103
   )
   @Export("FPS")
   protected static int field2194 = 0;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -218292309
   )
   static int field2195 = 20;
   @ObfuscatedName("qx")
   public static volatile boolean field2196 = true;
   @ObfuscatedName("rn")
   @ObfuscatedGetter(
      longValue = 5430634423610707127L
   )
   static volatile long field2197 = 0L;
   @ObfuscatedName("ql")
   protected static volatile boolean field2198 = false;
   @ObfuscatedName("qb")
   static long[] field2199 = new long[32];
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1876991923
   )
   protected static int field2200 = 0;
   @ObfuscatedName("qe")
   static long[] field2201 = new long[32];
   @ObfuscatedName("rg")
   static volatile boolean field2202 = true;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -1292616701
   )
   static int field2203 = 500;
   @ObfuscatedName("qw")
   protected static boolean field2204 = false;
   @ObfuscatedName("ps")
   boolean field2205;
   @ObfuscatedName("pq")
   static class144 field2206 = null;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -1310219825
   )
   static int field2207 = 1;
   @ObfuscatedName("bw")
   static class168 field2208;

   @ObfuscatedName("sw")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "5"
   )
   protected final void method3044(int var1, int var2, int var3) {
      try {
         if(field2206 != null) {
            ++field2191;
            if(field2191 >= 3) {
               this.method3055("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2206 = this;
         class30.field708 = var1;
         class153.field2274 = var2;
         class148.field2228 = var3;
         class148.field2222 = this;
         if(class7.field136 == null) {
            class7.field136 = new class136();
         }

         class7.field136.method2903(this, 1);
      } catch (Exception var5) {
         class45.method984((String)null, var5);
         this.method3055("crash");
      }

   }

   @ObfuscatedName("sh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   protected final synchronized void method3045() {
      Container var1 = this.method3061();
      if(class89.field1567 != null) {
         class89.field1567.removeFocusListener(this);
         var1.remove(class89.field1567);
      }

      class30.field708 = Math.max(var1.getWidth(), class31.field749);
      class153.field2274 = Math.max(var1.getHeight(), class123.field2032);
      Insets var2;
      if(class102.field1764 != null) {
         var2 = class102.field1764.getInsets();
         class30.field708 -= var2.right + var2.left;
         class153.field2274 -= var2.bottom + var2.top;
      }

      class89.field1567 = new class139(this);
      var1.add(class89.field1567);
      class89.field1567.setSize(class30.field708, class153.field2274);
      class89.field1567.setVisible(true);
      if(var1 == class102.field1764) {
         var2 = class102.field1764.getInsets();
         class89.field1567.setLocation(var2.left + field2200, field2190 + var2.top);
      } else {
         class89.field1567.setLocation(field2200, field2190);
      }

      class89.field1567.addFocusListener(this);
      class89.field1567.requestFocus();
      field2196 = true;
      int var3 = class30.field708;
      int var4 = class153.field2274;
      Canvas var5 = class89.field1567;

      Object var9;
      try {
         class81 var6 = new class81();
         var6.vmethod1929(var3, var4, var5);
         var9 = var6;
      } catch (Throwable var8) {
         class75 var7 = new class75();
         var7.vmethod1929(var3, var4, var5);
         var9 = var7;
      }

      if(null != class12.field196) {
         class12.field196.vmethod1939(((class77)var9).field1405.getGraphics(), 0, 0);
      }

      class12.field196 = (class77)var9;
      field2198 = false;
      field2197 = class130.method2846();
   }

   public void run() {
      try {
         if(null != class136.field2089) {
            String var1 = class136.field2089.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class136.field2090;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3055("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class36.method786(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class156.method3184(var4) && class35.method772(var4) < 10) {
                     this.method3055("wrongjava");
                     return;
                  }
               }

               field2207 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3045();
         this.vmethod3056();
         class107.field1884 = class106.method2424();

         while(0L == field2192 || class130.method2846() < field2192) {
            class52.field1174 = class107.field1884.vmethod3147(field2195, field2207);

            for(int var5 = 0; var5 < class52.field1174; ++var5) {
               this.method3071();
            }

            this.method3123();
            class164.method3257(class7.field136, class89.field1567);
         }
      } catch (Exception var6) {
         class45.method984((String)null, var6);
         this.method3055("crash");
      }

      this.method3049();
   }

   @ObfuscatedName("sf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "62"
   )
   final synchronized void method3049() {
      if(!field2193) {
         field2193 = true;

         try {
            class89.field1567.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3059();
         } catch (Exception var4) {
            ;
         }

         if(null != class102.field1764) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class7.field136) {
            try {
               class7.field136.method2899();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3063();
      }
   }

   public void start() {
      if(this == field2206 && !field2193) {
         field2192 = 0L;
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(field2206 == this && !field2193) {
         field2196 = true;
         if(null != class136.field2090 && class136.field2090.startsWith("1.5") && class130.method2846() - field2197 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class30.field708 && var2.height >= class153.field2274) {
               field2198 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field2202 = true;
      field2196 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2202 = false;
   }

   public void stop() {
      if(field2206 == this && !field2193) {
         field2192 = class130.method2846() + 4000L;
      }
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("sv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-122"
   )
   protected void method3055(String var1) {
      if(!this.field2205) {
         this.field2205 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   protected abstract void vmethod3056();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-25474"
   )
   protected abstract void vmethod3057();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1927182290"
   )
   protected abstract void vmethod3058();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "155077562"
   )
   protected abstract void vmethod3059();

   @ObfuscatedName("sr")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1005281429"
   )
   protected Container method3061() {
      return (Container)(class102.field1764 != null?class102.field1764:this);
   }

   @ObfuscatedName("sk")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "-1320921406"
   )
   protected Dimension method3062() {
      Container var1 = this.method3061();
      int var2 = Math.max(var1.getWidth(), class31.field749);
      int var3 = Math.max(var1.getHeight(), class123.field2032);
      if(class102.field1764 != null) {
         Insets var4 = class102.field1764.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   protected abstract void vmethod3063();

   @ObfuscatedName("sb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2144519453"
   )
   void method3071() {
      long var1 = class130.method2846();
      long var3 = field2199[class27.field677];
      field2199[class27.field677] = var1;
      class27.field677 = 1 + class27.field677 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class30.field709 = field2202;
      }

      this.vmethod3057();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   static void method3081() {
      class5.field83 = 99;
      class5.field84 = new byte[4][104][104];
      class222.field3180 = new byte[4][104][104];
      class5.field81 = new byte[4][104][104];
      class5.field86 = new byte[4][104][104];
      class19.field286 = new int[4][105][105];
      class216.field3159 = new byte[4][105][105];
      class8.field147 = new int[105][105];
      class5.field103 = new int[104];
      class5.field87 = new int[104];
      class5.field85 = new int[104];
      class5.field90 = new int[104];
      class38.field887 = new int[104];
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public void destroy() {
      if(field2206 == this && !field2193) {
         field2192 = class130.method2846();
         class98.method2264(5000L);
         this.method3049();
      }
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("sp")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-115"
   )
   protected final boolean method3104() {
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
                     this.method3055("invalidhost");
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

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("sg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1536051358"
   )
   void method3123() {
      Container var1 = this.method3061();
      long var2 = class130.method2846();
      long var4 = field2201[class140.field2148];
      field2201[class140.field2148] = var2;
      class140.field2148 = 1 + class140.field2148 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2194 = ((var6 >> 1) + 32000) / var6;
      }

      if(++field2203 - 1 > 50) {
         field2203 -= 50;
         field2196 = true;
         class89.field1567.setSize(class30.field708, class153.field2274);
         class89.field1567.setVisible(true);
         if(class102.field1764 == var1) {
            Insets var7 = class102.field1764.getInsets();
            class89.field1567.setLocation(field2200 + var7.left, field2190 + var7.top);
         } else {
            class89.field1567.setLocation(field2200, field2190);
         }
      }

      this.vmethod3058();
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }
}
