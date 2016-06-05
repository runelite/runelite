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

@ObfuscatedName("eh")
@Implements("GameEngine")
public abstract class class144 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pr")
   static class144 field2223 = null;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -1273464943
   )
   @Export("FPS")
   protected static int field2224 = 0;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      longValue = -7341805179402415213L
   )
   static long field2225 = 0L;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 1288724561
   )
   protected static int field2226 = 0;
   @ObfuscatedName("pd")
   boolean field2227;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -1790660477
   )
   static int field2228 = 20;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -729976239
   )
   static int field2229 = 1;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -947565607
   )
   static int field2230;
   @ObfuscatedName("qt")
   static long[] field2231 = new long[32];
   @ObfuscatedName("qo")
   static long[] field2232 = new long[32];
   @ObfuscatedName("pl")
   static boolean field2233 = false;
   @ObfuscatedName("qi")
   protected static volatile boolean field2234 = false;
   @ObfuscatedName("qg")
   protected static volatile boolean field2235 = true;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -521570403
   )
   static int field2236 = 500;
   @ObfuscatedName("qn")
   protected static boolean field2237 = false;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 1144987821
   )
   static int field2238 = 0;
   @ObfuscatedName("rb")
   @ObfuscatedGetter(
      longValue = 3253811240007369959L
   )
   static volatile long field2239 = 0L;
   @ObfuscatedName("re")
   static volatile boolean field2240 = true;
   @ObfuscatedName("ax")
   static class168 field2241;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 214088377
   )
   protected static int field2242 = 0;
   @ObfuscatedName("en")
   static class80[] field2243;

   @ObfuscatedName("rb")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-23"
   )
   protected final boolean method2981() {
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
                     this.method2997("invalidhost");
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
         if(null != class136.field2114) {
            String var1 = class136.field2114.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class136.field2124;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2997("wrongjava");
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

                  String var14 = var2.substring(6, var3);
                  boolean var7 = false;
                  boolean var8 = false;
                  int var9 = 0;
                  int var10 = var14.length();
                  int var11 = 0;

                  boolean var6;
                  while(true) {
                     if(var11 >= var10) {
                        var6 = var8;
                        break;
                     }

                     label184: {
                        char var12 = var14.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == 45) {
                              var7 = true;
                              break label184;
                           }

                           if(var12 == 43) {
                              break label184;
                           }
                        }

                        int var19;
                        if(var12 >= 48 && var12 <= 57) {
                           var19 = var12 - 48;
                        } else if(var12 >= 65 && var12 <= 90) {
                           var19 = var12 - 55;
                        } else {
                           if(var12 < 97 || var12 > 122) {
                              var6 = false;
                              break;
                           }

                           var19 = var12 - 87;
                        }

                        if(var19 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var19 = -var19;
                        }

                        int var13 = var19 + var9 * 10;
                        if(var9 != var13 / 10) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6 && class77.method1660(var14) < 10) {
                     this.method2997("wrongjava");
                     return;
                  }
               }

               field2229 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2992();
         this.vmethod2993();

         Object var18;
         try {
            var18 = new class147();
         } catch (Throwable var16) {
            var18 = new class141();
         }

         class190.field3081 = (class133)var18;

         while(0L == field2225 || class124.method2746() < field2225) {
            class44.field1038 = class190.field3081.vmethod3083(field2228, field2229);

            for(int var15 = 0; var15 < class44.field1038; ++var15) {
               this.method3028();
            }

            this.method2985();
            class122.method2718(class77.field1400, class59.field1221);
         }
      } catch (Exception var17) {
         class30.method654((String)null, var17);
         this.method2997("crash");
      }

      this.method3004();
   }

   public void destroy() {
      if(field2223 == this && !field2233) {
         field2225 = class124.method2746();
         class45.method926(5000L);
         this.method3004();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1817936179"
   )
   protected abstract void vmethod2984();

   @ObfuscatedName("re")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   void method2985() {
      Container var1 = this.method3051();
      long var2 = class124.method2746();
      long var4 = field2231[class131.field2077];
      field2231[class131.field2077] = var2;
      class131.field2077 = 1 + class131.field2077 & 31;
      if(0L != var4 && var2 > var4) {
         int var7 = (int)(var2 - var4);
         field2224 = ((var7 >> 1) + 32000) / var7;
      }

      if(++field2236 - 1 > 50) {
         field2236 -= 50;
         field2235 = true;
         class59.field1221.setSize(class10.field162, class41.field966);
         class59.field1221.setVisible(true);
         if(var1 == class43.field1022) {
            Insets var6 = class43.field1022.getInsets();
            class59.field1221.setLocation(var6.left + field2226, field2242 + var6.top);
         } else {
            class59.field1221.setLocation(field2226, field2242);
         }
      }

      this.vmethod2995();
   }

   public void stop() {
      if(field2223 == this && !field2233) {
         field2225 = class124.method2746() + 4000L;
      }
   }

   public void start() {
      if(field2223 == this && !field2233) {
         field2225 = 0L;
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2223 && !field2233) {
         field2235 = true;
         if(null != class136.field2124 && class136.field2124.startsWith("1.5") && class124.method2746() - field2239 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class10.field162 && var2.height >= class41.field966) {
               field2234 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field2240 = true;
      field2235 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2240 = false;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "765"
   )
   protected final void method2991(int var1, int var2, int var3) {
      try {
         if(null != field2223) {
            ++field2238;
            if(field2238 >= 3) {
               this.method2997("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2223 = this;
         class10.field162 = var1;
         class41.field966 = var2;
         class163.field2680 = var3;
         class148.field2257 = this;
         if(class77.field1400 == null) {
            class77.field1400 = new class136();
         }

         class77.field1400.method2868(this, 1);
      } catch (Exception var5) {
         class30.method654((String)null, var5);
         this.method2997("crash");
      }

   }

   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-52"
   )
   protected final synchronized void method2992() {
      Container var1 = this.method3051();
      if(class59.field1221 != null) {
         class59.field1221.removeFocusListener(this);
         var1.remove(class59.field1221);
      }

      class10.field162 = Math.max(var1.getWidth(), class43.field1016);
      class41.field966 = Math.max(var1.getHeight(), class29.field690);
      Insets var2;
      if(null != class43.field1022) {
         var2 = class43.field1022.getInsets();
         class10.field162 -= var2.left + var2.right;
         class41.field966 -= var2.top + var2.bottom;
      }

      class59.field1221 = new class139(this);
      var1.add(class59.field1221);
      class59.field1221.setSize(class10.field162, class41.field966);
      class59.field1221.setVisible(true);
      if(class43.field1022 == var1) {
         var2 = class43.field1022.getInsets();
         class59.field1221.setLocation(var2.left + field2226, field2242 + var2.top);
      } else {
         class59.field1221.setLocation(field2226, field2242);
      }

      class59.field1221.addFocusListener(this);
      class59.field1221.requestFocus();
      field2235 = true;
      class77 var3 = class12.method138(class10.field162, class41.field966, class59.field1221);
      if(class96.field1646 != null) {
         class96.field1646.vmethod1829(var3.field1395.getGraphics(), 0, 0);
      }

      class96.field1646 = var3;
      field2234 = false;
      field2239 = class124.method2746();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "36418783"
   )
   protected abstract void vmethod2993();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-65"
   )
   protected abstract void vmethod2994();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "50269187"
   )
   protected abstract void vmethod2995();

   @ObfuscatedName("ri")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1989162552"
   )
   protected void method2997(String var1) {
      if(!this.field2227) {
         this.field2227 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("rd")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "1233172868"
   )
   protected Dimension method2999() {
      Container var1 = this.method3051();
      int var2 = Math.max(var1.getWidth(), class43.field1016);
      int var3 = Math.max(var1.getHeight(), class29.field690);
      if(null != class43.field1022) {
         Insets var4 = class43.field1022.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("rn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   final synchronized void method3004() {
      if(!field2233) {
         field2233 = true;

         try {
            class59.field1221.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3030();
         } catch (Exception var4) {
            ;
         }

         if(class43.field1022 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class77.field1400) {
            try {
               class77.field1400.method2861();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2984();
      }
   }

   public abstract void init();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   @ObfuscatedName("rz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-386760230"
   )
   void method3028() {
      long var1 = class124.method2746();
      long var3 = field2232[class133.field2086];
      field2232[class133.field2086] = var1;
      class133.field2086 = class133.field2086 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class28.field670 = field2240;
      }

      this.vmethod2994();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-905979487"
   )
   protected abstract void vmethod3030();

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("ru")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "36"
   )
   protected Container method3051() {
      return (Container)(null != class43.field1022?class43.field1022:this);
   }
}
