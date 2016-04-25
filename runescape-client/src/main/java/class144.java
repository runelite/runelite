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

@ObfuscatedName("ed")
@Implements("GameEngine")
public abstract class class144 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -1805960495
   )
   static int field2171 = 500;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 1147491241
   )
   protected static int field2172 = 0;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 175101645
   )
   static int field2173 = 0;
   @ObfuscatedName("pr")
   static class144 field2174 = null;
   @ObfuscatedName("pt")
   boolean field2175;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -1956024657
   )
   static int field2176 = 20;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -1042694699
   )
   static int field2177 = 1;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      longValue = -8924186584454293971L
   )
   static long field2178 = 0L;
   @ObfuscatedName("qi")
   protected static long[] field2179 = new long[32];
   @ObfuscatedName("qb")
   protected static long[] field2181 = new long[32];
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 132007501
   )
   protected static int field2182 = 0;
   @ObfuscatedName("qt")
   public static volatile boolean field2183 = true;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 177918213
   )
   @Export("FPS")
   protected static int field2184 = 0;
   @ObfuscatedName("qe")
   protected static boolean field2185 = false;
   @ObfuscatedName("pc")
   static boolean field2186 = false;
   @ObfuscatedName("rq")
   @ObfuscatedGetter(
      longValue = 967462804284952733L
   )
   static volatile long field2187 = 0L;
   @ObfuscatedName("rk")
   static volatile boolean field2188 = true;
   @ObfuscatedName("qx")
   protected static volatile boolean field2189 = false;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1548178931"
   )
   protected abstract void vmethod2984();

   @ObfuscatedName("po")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1769645988"
   )
   protected final synchronized void method2985() {
      Container var1 = this.method2999();
      if(class3.field66 != null) {
         class3.field66.removeFocusListener(this);
         var1.remove(class3.field66);
      }

      class5.field102 = Math.max(var1.getWidth(), class41.field965);
      class39.field901 = Math.max(var1.getHeight(), class31.field724);
      Insets var2;
      if(null != class4.field82) {
         var2 = class4.field82.getInsets();
         class5.field102 -= var2.right + var2.left;
         class39.field901 -= var2.bottom + var2.top;
      }

      class3.field66 = new class139(this);
      var1.add(class3.field66);
      class3.field66.setSize(class5.field102, class39.field901);
      class3.field66.setVisible(true);
      if(class4.field82 == var1) {
         var2 = class4.field82.getInsets();
         class3.field66.setLocation(var2.left + field2172, field2182 + var2.top);
      } else {
         class3.field66.setLocation(field2172, field2182);
      }

      class3.field66.addFocusListener(this);
      class3.field66.requestFocus();
      field2183 = true;
      int var3 = class5.field102;
      int var4 = class39.field901;
      Canvas var5 = class3.field66;

      Object var9;
      try {
         class81 var6 = new class81();
         var6.vmethod1872(var3, var4, var5);
         var9 = var6;
      } catch (Throwable var8) {
         class75 var7 = new class75();
         var7.vmethod1872(var3, var4, var5);
         var9 = var7;
      }

      if(null != class75.field1363) {
         class75.field1363.vmethod1873(((class77)var9).field1380.getGraphics(), 0, 0);
      }

      class75.field1363 = (class77)var9;
      field2189 = false;
      field2187 = class77.method1674();
   }

   @ObfuscatedName("pr")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-5229215"
   )
   protected final boolean method2986() {
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
                     this.method2998("invalidhost");
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
         if(null != class136.field2076) {
            String var1 = class136.field2076.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class136.field2071;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2998("wrongjava");
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

                  String var10 = var2.substring(6, var3);
                  if(class82.method1878(var10) && class93.method2161(var10) < 10) {
                     this.method2998("wrongjava");
                     return;
                  }
               }

               field2177 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2985();
         this.vmethod2995();

         Object var8;
         try {
            var8 = new class147();
         } catch (Throwable var6) {
            var8 = new class141();
         }

         class110.field1934 = (class133)var8;

         while(0L == field2178 || class77.method1674() < field2178) {
            class169.field2695 = class110.field1934.vmethod3089(field2176, field2177);

            for(int var9 = 0; var9 < class169.field2695; ++var9) {
               this.method3051();
            }

            this.method3054();
            class27.method638(class142.field2153, class3.field66);
         }
      } catch (Exception var7) {
         class6.method102((String)null, var7);
         this.method2998("crash");
      }

      this.method2993();
   }

   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "2125564730"
   )
   protected Dimension method2987() {
      Container var1 = this.method2999();
      int var2 = Math.max(var1.getWidth(), class41.field965);
      int var3 = Math.max(var1.getHeight(), class31.field724);
      if(null != class4.field82) {
         Insets var4 = class4.field82.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   public void stop() {
      if(field2174 == this && !field2186) {
         field2178 = class77.method1674() + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2174 && !field2186) {
         field2183 = true;
         if(null != class136.field2071 && class136.field2071.startsWith("1.5") && class77.method1674() - field2187 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class5.field102 && var2.height >= class39.field901) {
               field2189 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field2188 = true;
      field2183 = true;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("pc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final synchronized void method2993() {
      if(!field2186) {
         field2186 = true;

         try {
            class3.field66.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2997();
         } catch (Exception var4) {
            ;
         }

         if(class4.field82 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class142.field2153) {
            try {
               class142.field2153.method2848();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3001();
      }
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-499334333"
   )
   protected abstract void vmethod2995();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2018964743"
   )
   protected abstract void vmethod2996();

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "587883500"
   )
   protected abstract void vmethod2997();

   @ObfuscatedName("pt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-68"
   )
   protected void method2998(String var1) {
      if(!this.field2175) {
         this.field2175 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("pm")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1823645161"
   )
   protected Container method2999() {
      return (Container)(class4.field82 != null?class4.field82:this);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   protected abstract void vmethod3001();

   @ObfuscatedName("pd")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "765"
   )
   protected final void method3018(int var1, int var2, int var3) {
      try {
         if(null != field2174) {
            ++field2173;
            if(field2173 >= 3) {
               this.method2998("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2174 = this;
         class5.field102 = var1;
         class39.field901 = var2;
         class148.field2205 = var3;
         class148.field2202 = this;
         if(class142.field2153 == null) {
            class142.field2153 = new class136();
         }

         class142.field2153.method2851(this, 1);
      } catch (Exception var5) {
         class6.method102((String)null, var5);
         this.method2998("crash");
      }

   }

   public void start() {
      if(this == field2174 && !field2186) {
         field2178 = 0L;
      }
   }

   public void destroy() {
      if(field2174 == this && !field2186) {
         field2178 = class77.method1674();
         class14.method170(5000L);
         this.method2993();
      }
   }

   public abstract void init();

   @ObfuscatedName("pg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-78"
   )
   void method3051() {
      long var1 = class77.method1674();
      long var3 = field2181[class122.field1989];
      field2181[class122.field1989] = var1;
      class122.field1989 = class122.field1989 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class107.field1864 = field2188;
      }

      this.vmethod2996();
   }

   @ObfuscatedName("pz")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "18530"
   )
   void method3054() {
      Container var1 = this.method2999();
      long var2 = class77.method1674();
      long var4 = field2179[class8.field140];
      field2179[class8.field140] = var2;
      class8.field140 = class8.field140 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2184 = ((var6 >> 1) + 32000) / var6;
      }

      if(++field2171 - 1 > 50) {
         field2171 -= 50;
         field2183 = true;
         class3.field66.setSize(class5.field102, class39.field901);
         class3.field66.setVisible(true);
         if(var1 == class4.field82) {
            Insets var7 = class4.field82.getInsets();
            class3.field66.setLocation(var7.left + field2172, field2182 + var7.top);
         } else {
            class3.field66.setLocation(field2172, field2182);
         }
      }

      this.vmethod2984();
   }

   public final void focusLost(FocusEvent var1) {
      field2188 = false;
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)I",
      garbageValue = "70"
   )
   static int method3075(class173 var0) {
      class201 var1 = (class201)client.field475.method3742(((long)var0.field2774 << 32) + (long)var0.field2798);
      return var1 != null?var1.field3109:var0.field2816;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass86;Lclass108;B)V",
      garbageValue = "0"
   )
   static final void method3076(int var0, int var1, int var2, int var3, int var4, int var5, class86 var6, class108 var7) {
      if(!client.field303 || (class5.field84[0][var1][var2] & 2) != 0 || 0 == (class5.field84[var0][var1][var2] & 16)) {
         if(var0 < class5.field85) {
            class5.field85 = var0;
         }

         class40 var8 = class85.method1903(var3);
         int var9;
         int var10;
         if(var4 != 1 && 3 != var4) {
            var9 = var8.field920;
            var10 = var8.field921;
         } else {
            var9 = var8.field921;
            var10 = var8.field920;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (1 + var10 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.field91[var0];
         int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + var1 + (var2 << 7) + (var3 << 14);
         if(var8.field917 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field945 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method795()) {
            class23 var21 = new class23();
            var21.field585 = var0;
            var21.field584 = var1 * 128;
            var21.field587 = var2 * 128;
            var22 = var8.field920;
            var23 = var8.field921;
            if(1 == var4 || var4 == 3) {
               var22 = var8.field921;
               var23 = var8.field920;
            }

            var21.field588 = (var22 + var1) * 128;
            var21.field595 = (var2 + var23) * 128;
            var21.field602 = var8.field951;
            var21.field590 = var8.field950 * 128;
            var21.field596 = var8.field914;
            var21.field586 = var8.field952;
            var21.field599 = var8.field953;
            if(null != var8.field956) {
               var21.field589 = var8;
               var21.method588();
            }

            class23.field593.method3779(var21);
            if(null != var21.field599) {
               var21.field591 = var21.field596 + (int)(Math.random() * (double)(var21.field586 - var21.field596));
            }
         }

         Object var26;
         if(22 == var5) {
            if(!client.field303 || 0 != var8.field917 || 1 == var8.field922 || var8.field915) {
               if(var8.field928 == -1 && null == var8.field956) {
                  var26 = var8.method791(22, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 22, var4, var0, var1, var2, var8.field928, true, (class85)null);
               }

               var6.method1911(var0, var1, var2, var16, (class85)var26, var19, var20);
               if(1 == var8.field922 && null != var7) {
                  var7.method2382(var1, var2);
               }

            }
         } else if(10 != var5 && 11 != var5) {
            if(var5 >= 12) {
               if(var8.field928 == -1 && var8.field956 == null) {
                  var26 = var8.method791(var5, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field928, true, (class85)null);
               }

               var6.method2037(var0, var1, var2, var16, 1, 1, (class85)var26, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && 13 != var5 && var0 > 0) {
                  class59.field1201[var0][var1][var2] |= 2340;
               }

               if(var8.field922 != 0 && var7 != null) {
                  var7.method2379(var1, var2, var9, var10, var8.field923);
               }

            } else if(var5 == 0) {
               if(-1 == var8.field928 && null == var8.field956) {
                  var26 = var8.method791(0, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 0, var4, var0, var1, var2, var8.field928, true, (class85)null);
               }

               var6.method1913(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field92[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field936) {
                     class186.field3009[var0][var1][var2] = 50;
                     class186.field3009[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.field927) {
                     class59.field1201[var0][var1][var2] |= 585;
                  }
               } else if(1 == var4) {
                  if(var8.field936) {
                     class186.field3009[var0][var1][1 + var2] = 50;
                     class186.field3009[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field927) {
                     class59.field1201[var0][var1][1 + var2] |= 1170;
                  }
               } else if(2 == var4) {
                  if(var8.field936) {
                     class186.field3009[var0][var1 + 1][var2] = 50;
                     class186.field3009[var0][1 + var1][var2 + 1] = 50;
                  }

                  if(var8.field927) {
                     class59.field1201[var0][1 + var1][var2] |= 585;
                  }
               } else if(3 == var4) {
                  if(var8.field936) {
                     class186.field3009[var0][var1][var2] = 50;
                     class186.field3009[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.field927) {
                     class59.field1201[var0][var1][var2] |= 1170;
                  }
               }

               if(0 != var8.field922 && var7 != null) {
                  var7.method2383(var1, var2, var5, var4, var8.field923);
               }

               if(16 != var8.field929) {
                  var6.method2071(var0, var1, var2, var8.field929);
               }

            } else if(var5 == 1) {
               if(-1 == var8.field928 && null == var8.field956) {
                  var26 = var8.method791(1, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 1, var4, var0, var1, var2, var8.field928, true, (class85)null);
               }

               var6.method1913(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field93[var4], 0, var19, var20);
               if(var8.field936) {
                  if(var4 == 0) {
                     class186.field3009[var0][var1][1 + var2] = 50;
                  } else if(var4 == 1) {
                     class186.field3009[var0][1 + var1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class186.field3009[var0][1 + var1][var2] = 50;
                  } else if(var4 == 3) {
                     class186.field3009[var0][var1][var2] = 50;
                  }
               }

               if(0 != var8.field922 && null != var7) {
                  var7.method2383(var1, var2, var5, var4, var8.field923);
               }

            } else {
               int var27;
               Object var28;
               if(2 == var5) {
                  var27 = var4 + 1 & 3;
                  Object var30;
                  if(-1 == var8.field928 && null == var8.field956) {
                     var30 = var8.method791(2, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.method791(2, var27, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 2, var4 + 4, var0, var1, var2, var8.field928, true, (class85)null);
                     var28 = new class12(var3, 2, var27, var0, var1, var2, var8.field928, true, (class85)null);
                  }

                  var6.method1913(var0, var1, var2, var16, (class85)var30, (class85)var28, class5.field92[var4], class5.field92[var27], var19, var20);
                  if(var8.field927) {
                     if(0 == var4) {
                        class59.field1201[var0][var1][var2] |= 585;
                        class59.field1201[var0][var1][var2 + 1] |= 1170;
                     } else if(1 == var4) {
                        class59.field1201[var0][var1][1 + var2] |= 1170;
                        class59.field1201[var0][var1 + 1][var2] |= 585;
                     } else if(2 == var4) {
                        class59.field1201[var0][1 + var1][var2] |= 585;
                        class59.field1201[var0][var1][var2] |= 1170;
                     } else if(3 == var4) {
                        class59.field1201[var0][var1][var2] |= 1170;
                        class59.field1201[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field922 != 0 && null != var7) {
                     var7.method2383(var1, var2, var5, var4, var8.field923);
                  }

                  if(16 != var8.field929) {
                     var6.method2071(var0, var1, var2, var8.field929);
                  }

               } else if(var5 == 3) {
                  if(-1 == var8.field928 && var8.field956 == null) {
                     var26 = var8.method791(3, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 3, var4, var0, var1, var2, var8.field928, true, (class85)null);
                  }

                  var6.method1913(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field93[var4], 0, var19, var20);
                  if(var8.field936) {
                     if(0 == var4) {
                        class186.field3009[var0][var1][1 + var2] = 50;
                     } else if(1 == var4) {
                        class186.field3009[var0][1 + var1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class186.field3009[var0][var1 + 1][var2] = 50;
                     } else if(3 == var4) {
                        class186.field3009[var0][var1][var2] = 50;
                     }
                  }

                  if(0 != var8.field922 && var7 != null) {
                     var7.method2383(var1, var2, var5, var4, var8.field923);
                  }

               } else if(9 == var5) {
                  if(-1 == var8.field928 && var8.field956 == null) {
                     var26 = var8.method791(var5, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field928, true, (class85)null);
                  }

                  var6.method2037(var0, var1, var2, var16, 1, 1, (class85)var26, 0, var19, var20);
                  if(0 != var8.field922 && var7 != null) {
                     var7.method2379(var1, var2, var9, var10, var8.field923);
                  }

                  if(16 != var8.field929) {
                     var6.method2071(var0, var1, var2, var8.field929);
                  }

               } else if(4 == var5) {
                  if(-1 == var8.field928 && null == var8.field956) {
                     var26 = var8.method791(4, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field928, true, (class85)null);
                  }

                  var6.method1914(var0, var1, var2, var16, (class85)var26, (class85)null, class5.field92[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var27 = 16;
                  var22 = var6.method2034(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class85.method1903(var22 >> 14 & 32767).field929;
                  }

                  if(var8.field928 == -1 && var8.field956 == null) {
                     var28 = var8.method791(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4, var0, var1, var2, var8.field928, true, (class85)null);
                  }

                  var6.method1914(var0, var1, var2, var16, (class85)var28, (class85)null, class5.field92[var4], 0, var27 * class5.field94[var4], class5.field95[var4] * var27, var19, var20);
               } else if(var5 == 6) {
                  var27 = 8;
                  var22 = var6.method2034(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class85.method1903(var22 >> 14 & 32767).field929 / 2;
                  }

                  if(-1 == var8.field928 && var8.field956 == null) {
                     var28 = var8.method791(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field928, true, (class85)null);
                  }

                  var6.method1914(var0, var1, var2, var16, (class85)var28, (class85)null, 256, var4, var27 * class5.field96[var4], class5.field97[var4] * var27, var19, var20);
               } else if(7 == var5) {
                  var22 = var4 + 2 & 3;
                  if(var8.field928 == -1 && var8.field956 == null) {
                     var26 = var8.method791(4, 4 + var22, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field928, true, (class85)null);
                  }

                  var6.method1914(var0, var1, var2, var16, (class85)var26, (class85)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var27 = 8;
                  var22 = var6.method2034(var0, var1, var2);
                  if(0 != var22) {
                     var27 = class85.method1903(var22 >> 14 & 32767).field929 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.field928 == -1 && null == var8.field956) {
                     var28 = var8.method791(4, 4 + var4, var15, var17, var16, var18);
                     var29 = var8.method791(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field928, true, (class85)null);
                     var29 = new class12(var3, 4, var25 + 4, var0, var1, var2, var8.field928, true, (class85)null);
                  }

                  var6.method1914(var0, var1, var2, var16, (class85)var28, (class85)var29, 256, var4, class5.field96[var4] * var27, class5.field97[var4] * var27, var19, var20);
               }
            }
         } else {
            if(-1 == var8.field928 && var8.field956 == null) {
               var26 = var8.method791(10, var4, var15, var17, var16, var18);
            } else {
               var26 = new class12(var3, 10, var4, var0, var1, var2, var8.field928, true, (class85)null);
            }

            if(null != var26 && var6.method2037(var0, var1, var2, var16, var9, var10, (class85)var26, 11 == var5?256:0, var19, var20) && var8.field936) {
               var22 = 15;
               if(var26 instanceof class105) {
                  var22 = ((class105)var26).method2321() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class186.field3009[var0][var1 + var23][var2 + var24]) {
                        class186.field3009[var0][var1 + var23][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(0 != var8.field922 && null != var7) {
               var7.method2379(var1, var2, var9, var10, var8.field923);
            }

         }
      }
   }
}
