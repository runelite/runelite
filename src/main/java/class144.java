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

@ObfuscatedName("ec")
@Implements("GameEngine")
public abstract class class144 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = -5790949538093393667L
   )
   static long field2188 = 0L;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 449290407
   )
   static int field2189 = 500;
   @ObfuscatedName("qi")
   protected static volatile boolean field2190 = false;
   @ObfuscatedName("rg")
   @ObfuscatedGetter(
      longValue = -7880952447231795315L
   )
   static volatile long field2191 = 0L;
   @ObfuscatedName("pu")
   static boolean field2192 = false;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -776076821
   )
   static int field2193 = 20;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 524781581
   )
   static int field2194 = 1;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -162447781
   )
   @Export("FPS")
   protected static int field2195 = 0;
   @ObfuscatedName("qj")
   protected static long[] field2196 = new long[32];
   @ObfuscatedName("qq")
   protected static long[] field2197 = new long[32];
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 807065969
   )
   protected static int field2198 = 0;
   @ObfuscatedName("pc")
   boolean field2199;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 1923463537
   )
   protected static int field2200 = 0;
   @ObfuscatedName("pl")
   static class144 field2201 = null;
   @ObfuscatedName("qz")
   protected static boolean field2202 = false;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -885446839
   )
   static int field2203 = 0;
   @ObfuscatedName("qh")
   protected static volatile boolean field2204 = true;
   @ObfuscatedName("rr")
   static volatile boolean field2205 = true;

   @ObfuscatedName("rq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   void method3004() {
      long var1 = class140.method2967();
      long var3 = field2197[class49.field1071];
      field2197[class49.field1071] = var1;
      class49.field1071 = 1 + class49.field1071 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class113.field1948 = field2205;
      }

      this.vmethod3019();
   }

   @ObfuscatedName("rk")
   protected final boolean method3007() {
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
                     this.method3099("invalidhost");
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
         if(class226.field3212 != null) {
            String var1 = class226.field3212.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class136.field2092;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3099("wrongjava");
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

                  String var12 = var2.substring(6, var3);
                  if(class116.method2473(var12) && class140.method2929(var12) < 10) {
                     this.method3099("wrongjava");
                     return;
                  }
               }

               field2194 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3073();
         this.vmethod3018();

         Object var8;
         try {
            var8 = new class147();
         } catch (Throwable var6) {
            var8 = new class141();
         }

         class4.field75 = (class133)var8;

         label91:
         while(true) {
            class136 var10;
            Canvas var11;
            do {
               if(field2188 != 0L && class140.method2967() >= field2188) {
                  break label91;
               }

               class143.field2185 = class4.field75.vmethod3116(field2193, field2194);

               for(int var9 = 0; var9 < class143.field2185; ++var9) {
                  this.method3004();
               }

               this.method3054();
               var10 = class125.field2028;
               var11 = class12.field192;
            } while(var10.field2087 == null);

            for(int var13 = 0; var13 < 50 && var10.field2087.peekEvent() != null; ++var13) {
               class130.method2818(1L);
            }

            if(var11 != null) {
               var10.field2087.postEvent(new ActionEvent(var11, 1001, "dummy"));
            }
         }
      } catch (Exception var7) {
         class1.method16((String)null, var7);
         this.method3099("crash");
      }

      this.method3098();
   }

   public void stop() {
      if(field2201 == this && !field2192) {
         field2188 = class140.method2967() + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
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

   @ObfuscatedName("p")
   protected abstract void vmethod3018();

   @ObfuscatedName("h")
   protected abstract void vmethod3019();

   @ObfuscatedName("g")
   protected abstract void vmethod3020();

   @ObfuscatedName("w")
   protected abstract void vmethod3025();

   @ObfuscatedName("rj")
   protected Container method3026() {
      return (Container)(null != class2.field61?class2.field61:this);
   }

   @ObfuscatedName("ry")
   protected Dimension method3032() {
      Container var1 = this.method3026();
      int var2 = Math.max(var1.getWidth(), class38.field848);
      int var3 = Math.max(var1.getHeight(), class116.field1961);
      if(null != class2.field61) {
         Insets var4 = class2.field61.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   public final void focusLost(FocusEvent var1) {
      field2205 = false;
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final synchronized void paint(Graphics var1) {
      if(field2201 == this && !field2192) {
         field2204 = true;
         if(class136.field2092 != null && class136.field2092.startsWith("1.5") && class140.method2967() - field2191 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class35.field762 && var2.height >= class21.field575) {
               field2190 = true;
            }
         }

      }
   }

   @ObfuscatedName("rf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1157798622"
   )
   void method3054() {
      Container var1 = this.method3026();
      long var2 = class140.method2967();
      long var4 = field2196[class131.field2055];
      field2196[class131.field2055] = var2;
      class131.field2055 = class131.field2055 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2195 = (32000 + (var6 >> 1)) / var6;
      }

      if(++field2189 - 1 > 50) {
         field2189 -= 50;
         field2204 = true;
         class12.field192.setSize(class35.field762, class21.field575);
         class12.field192.setVisible(true);
         if(var1 == class2.field61) {
            Insets var7 = class2.field61.getInsets();
            class12.field192.setLocation(field2198 + var7.left, var7.top + field2200);
         } else {
            class12.field192.setLocation(field2198, field2200);
         }
      }

      this.vmethod3020();
   }

   public void destroy() {
      if(this == field2201 && !field2192) {
         field2188 = class140.method2967();
         class130.method2818(5000L);
         this.method3098();
      }
   }

   @ObfuscatedName("rp")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1743578394"
   )
   protected final void method3066(int var1, int var2, int var3) {
      try {
         if(null != field2201) {
            ++field2203;
            if(field2203 >= 3) {
               this.method3099("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2201 = this;
         class35.field762 = var1;
         class21.field575 = var2;
         class90.field1541 = var3;
         class148.field2220 = this;
         if(null == class125.field2028) {
            class125.field2028 = new class136();
         }

         class125.field2028.method2888(this, 1);
      } catch (Exception var5) {
         class1.method16((String)null, var5);
         this.method3099("crash");
      }

   }

   @ObfuscatedName("ro")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "818803731"
   )
   protected final synchronized void method3073() {
      Container var1 = this.method3026();
      if(class12.field192 != null) {
         class12.field192.removeFocusListener(this);
         var1.remove(class12.field192);
      }

      class35.field762 = Math.max(var1.getWidth(), class38.field848);
      class21.field575 = Math.max(var1.getHeight(), class116.field1961);
      Insets var2;
      if(null != class2.field61) {
         var2 = class2.field61.getInsets();
         class35.field762 -= var2.right + var2.left;
         class21.field575 -= var2.bottom + var2.top;
      }

      class12.field192 = new class139(this);
      var1.add(class12.field192);
      class12.field192.setSize(class35.field762, class21.field575);
      class12.field192.setVisible(true);
      if(class2.field61 == var1) {
         var2 = class2.field61.getInsets();
         class12.field192.setLocation(field2198 + var2.left, var2.top + field2200);
      } else {
         class12.field192.setLocation(field2198, field2200);
      }

      class12.field192.addFocusListener(this);
      class12.field192.requestFocus();
      field2204 = true;
      class77 var3 = class14.method169(class35.field762, class21.field575, class12.field192);
      if(class134.field2070 != null) {
         class134.field2070.vmethod1886(var3.field1360.getGraphics(), 0, 0);
      }

      class134.field2070 = var3;
      field2190 = false;
      field2191 = class140.method2967();
   }

   @ObfuscatedName("a")
   protected abstract void vmethod3075();

   public final void windowOpened(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      field2205 = true;
      field2204 = true;
   }

   @ObfuscatedName("rl")
   final synchronized void method3098() {
      if(!field2192) {
         field2192 = true;

         try {
            class12.field192.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3075();
         } catch (Exception var4) {
            ;
         }

         if(null != class2.field61) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class125.field2028) {
            try {
               class125.field2028.method2885();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3025();
      }
   }

   @ObfuscatedName("ru")
   protected void method3099(String var1) {
      if(!this.field2199) {
         this.field2199 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   public void start() {
      if(this == field2201 && !field2192) {
         field2188 = 0L;
      }
   }

   @ObfuscatedName("e")
   public static void method3102(String var0, boolean var1, boolean var2) {
      class177.method3442(var0, var1, "openjs", var2);
   }
}
