import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
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

@ObfuscatedName("ek")
@Implements("GameEngine")
public abstract class class144 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = 1119734347
   )
   static int field2212 = 0;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      longValue = 6755769692308809875L
   )
   static long field2213 = 0L;
   @ObfuscatedName("pz")
   static boolean field2214 = false;
   @ObfuscatedName("pw")
   boolean field2215;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -738070347
   )
   static int field2216 = 20;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -1340261165
   )
   static int field2217 = 1;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -1140021355
   )
   @Export("FPS")
   protected static int field2218 = 0;
   @ObfuscatedName("pc")
   static class144 field2219 = null;
   @ObfuscatedName("qw")
   protected static long[] field2220 = new long[32];
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = 1118242169
   )
   protected static int field2221 = 0;
   @ObfuscatedName("qc")
   protected static long[] field2222 = new long[32];
   @ObfuscatedName("qi")
   protected static volatile boolean field2223 = true;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1038102637
   )
   static int field2224 = 500;
   @ObfuscatedName("qv")
   protected static boolean field2225 = false;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 989648513
   )
   protected static int field2226 = 0;
   @ObfuscatedName("rc")
   @ObfuscatedGetter(
      longValue = 3401484314479508121L
   )
   static volatile long field2227 = 0L;
   @ObfuscatedName("rl")
   static volatile boolean field2228 = true;
   @ObfuscatedName("qy")
   protected static volatile boolean field2229 = false;

   @ObfuscatedName("ro")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1125981535"
   )
   final synchronized void method3022() {
      if(!field2214) {
         field2214 = true;

         try {
            class87.field1537.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3037();
         } catch (Exception var4) {
            ;
         }

         if(class33.field773 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class123.field2036 != null) {
            try {
               class123.field2036.method2886();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3113();
      }
   }

   @ObfuscatedName("ru")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2022229468"
   )
   protected final synchronized void method3024() {
      Container var1 = this.method3039();
      if(class87.field1537 != null) {
         class87.field1537.removeFocusListener(this);
         var1.remove(class87.field1537);
      }

      class15.field235 = Math.max(var1.getWidth(), class30.field711);
      class15.field233 = Math.max(var1.getHeight(), class22.field601);
      Insets var2;
      if(null != class33.field773) {
         var2 = class33.field773.getInsets();
         class15.field235 -= var2.right + var2.left;
         class15.field233 -= var2.bottom + var2.top;
      }

      class87.field1537 = new class139(this);
      var1.add(class87.field1537);
      class87.field1537.setSize(class15.field235, class15.field233);
      class87.field1537.setVisible(true);
      if(class33.field773 == var1) {
         var2 = class33.field773.getInsets();
         class87.field1537.setLocation(field2226 + var2.left, field2221 + var2.top);
      } else {
         class87.field1537.setLocation(field2226, field2221);
      }

      class87.field1537.addFocusListener(this);
      class87.field1537.requestFocus();
      field2223 = true;
      class77 var3 = class24.method610(class15.field235, class15.field233, class87.field1537);
      if(class42.field991 != null) {
         class42.field991.vmethod1870(var3.field1398.getGraphics(), 0, 0);
      }

      class42.field991 = var3;
      field2229 = false;
      field2227 = class14.method165();
   }

   public void run() {
      try {
         if(null != class136.field2112) {
            String var1 = class136.field2112.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class34.field786;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3093("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class15.method175(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var5 = class149.method3169(var4, 10);
                  if(var5 && class141.method2991(var4) < 10) {
                     this.method3093("wrongjava");
                     return;
                  }
               }

               field2217 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3024();
         this.vmethod3034();

         Object var8;
         try {
            var8 = new class147();
         } catch (Throwable var6) {
            var8 = new class141();
         }

         class27.field679 = (class133)var8;

         label85:
         while(true) {
            class136 var10;
            Canvas var11;
            do {
               if(0L != field2213 && class14.method165() >= field2213) {
                  break label85;
               }

               class124.field2039 = class27.field679.vmethod3132(field2216, field2217);

               for(int var9 = 0; var9 < class124.field2039; ++var9) {
                  this.method3041();
               }

               this.method3027();
               var10 = class123.field2036;
               var11 = class87.field1537;
            } while(null == var10.field2109);

            for(int var12 = 0; var12 < 50 && var10.field2109.peekEvent() != null; ++var12) {
               class104.method2291(1L);
            }

            if(var11 != null) {
               var10.field2109.postEvent(new ActionEvent(var11, 1001, "dummy"));
            }
         }
      } catch (Exception var7) {
         class0.method0((String)null, var7);
         this.method3093("crash");
      }

      this.method3022();
   }

   @ObfuscatedName("rm")
   void method3027() {
      Container var1 = this.method3039();
      long var2 = class14.method165();
      long var4 = field2222[class109.field1919];
      field2222[class109.field1919] = var2;
      class109.field1919 = class109.field1919 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2218 = (32000 + (var6 >> 1)) / var6;
      }

      if(++field2224 - 1 > 50) {
         field2224 -= 50;
         field2223 = true;
         class87.field1537.setSize(class15.field235, class15.field233);
         class87.field1537.setVisible(true);
         if(class33.field773 == var1) {
            Insets var7 = class33.field773.getInsets();
            class87.field1537.setLocation(var7.left + field2226, field2221 + var7.top);
         } else {
            class87.field1537.setLocation(field2226, field2221);
         }
      }

      this.vmethod3103();
   }

   public void destroy() {
      if(this == field2219 && !field2214) {
         field2213 = class14.method165();
         class104.method2291(5000L);
         this.method3022();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      field2228 = true;
      field2223 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2228 = false;
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

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("p")
   protected abstract void vmethod3034();

   @ObfuscatedName("e")
   protected abstract void vmethod3035();

   @ObfuscatedName("m")
   protected abstract void vmethod3037();

   @ObfuscatedName("ry")
   protected Container method3039() {
      return (Container)(null != class33.field773?class33.field773:this);
   }

   @ObfuscatedName("rq")
   protected Dimension method3040() {
      Container var1 = this.method3039();
      int var2 = Math.max(var1.getWidth(), class30.field711);
      int var3 = Math.max(var1.getHeight(), class22.field601);
      if(class33.field773 != null) {
         Insets var4 = class33.field773.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("rt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1332747699"
   )
   void method3041() {
      long var1 = class14.method165();
      long var3 = field2220[class46.field1073];
      field2220[class46.field1073] = var1;
      class46.field1073 = 1 + class46.field1073 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class136.field2103 = field2228;
      }

      this.vmethod3035();
   }

   public void stop() {
      if(field2219 == this && !field2214) {
         field2213 = class14.method165() + 4000L;
      }
   }

   public abstract void init();

   public void start() {
      if(this == field2219 && !field2214) {
         field2213 = 0L;
      }
   }

   @ObfuscatedName("rk")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-755041099"
   )
   protected final void method3080(int var1, int var2, int var3) {
      try {
         if(field2219 != null) {
            ++field2212;
            if(field2212 >= 3) {
               this.method3093("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2219 = this;
         class15.field235 = var1;
         class15.field233 = var2;
         class148.field2243 = var3;
         class148.field2251 = this;
         if(null == class123.field2036) {
            class123.field2036 = new class136();
         }

         class123.field2036.method2889(this, 1);
      } catch (Exception var5) {
         class0.method0((String)null, var5);
         this.method3093("crash");
      }

   }

   public final synchronized void paint(Graphics var1) {
      if(field2219 == this && !field2214) {
         field2223 = true;
         if(class34.field786 != null && class34.field786.startsWith("1.5") && class14.method165() - field2227 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class15.field235 && var2.height >= class15.field233) {
               field2229 = true;
            }
         }

      }
   }

   @ObfuscatedName("rb")
   protected void method3093(String var1) {
      if(!this.field2215) {
         this.field2215 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("y")
   protected abstract void vmethod3103();

   @ObfuscatedName("rs")
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
                     this.method3093("invalidhost");
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

   @ObfuscatedName("x")
   protected abstract void vmethod3113();

   @ObfuscatedName("x")
   public static int method3121(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }
}
