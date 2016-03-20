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

@ObfuscatedName("el")
@Implements("GameEngine")
public abstract class class143 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 1903634739
   )
   @Export("FPS")
   protected static int field2178 = 0;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 1516482703
   )
   protected static int field2179 = 0;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      longValue = -2066817314247289097L
   )
   static long field2180 = 0L;
   @ObfuscatedName("ps")
   static boolean field2181 = false;
   @ObfuscatedName("pg")
   boolean field2182;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 1772397673
   )
   static int field2183 = 20;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 1498844079
   )
   static int field2184 = 1;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = 1061872891
   )
   static int field2185 = 0;
   @ObfuscatedName("ql")
   static long[] field2186 = new long[32];
   @ObfuscatedName("qi")
   protected static boolean field2187 = false;
   @ObfuscatedName("pv")
   static class143 field2188 = null;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -117811025
   )
   protected static int field2189 = 0;
   @ObfuscatedName("qn")
   public static volatile boolean field2190 = true;
   @ObfuscatedName("qa")
   static long[] field2191 = new long[32];
   @ObfuscatedName("qt")
   protected static volatile boolean field2192 = false;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -1727486501
   )
   static int field2193 = 500;
   @ObfuscatedName("ro")
   @ObfuscatedGetter(
      longValue = 6283792537468741073L
   )
   static volatile long field2194 = 0L;
   @ObfuscatedName("ri")
   static volatile boolean field2195 = true;

   @ObfuscatedName("pr")
   protected final void method3021(int var1, int var2, int var3) {
      try {
         if(field2188 != null) {
            ++field2185;
            if(field2185 >= 3) {
               this.method3075("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2188 = this;
         class6.field107 = var1;
         class31.field749 = var2;
         class147.field2210 = var3;
         class147.field2211 = this;
         if(class129.field2056 == null) {
            class129.field2056 = new class135();
         }

         class129.field2056.method2893(this, 1);
      } catch (Exception var5) {
         class28.method651((String)null, var5);
         this.method3075("crash");
      }

   }

   @ObfuscatedName("pg")
   protected final boolean method3023() {
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
                     this.method3075("invalidhost");
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
         if(class135.field2080 != null) {
            String var1 = class135.field2080.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class108.field1900;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3075("wrongjava");
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

                  String var16 = var2.substring(6, var3);
                  boolean var7 = false;
                  boolean var8 = false;
                  int var9 = 0;
                  int var10 = var16.length();
                  int var11 = 0;

                  boolean var6;
                  while(true) {
                     if(var11 >= var10) {
                        var6 = var8;
                        break;
                     }

                     label177: {
                        char var12 = var16.charAt(var11);
                        if(0 == var11) {
                           if(45 == var12) {
                              var7 = true;
                              break label177;
                           }

                           if(var12 == 43) {
                              break label177;
                           }
                        }

                        int var18;
                        if(var12 >= 48 && var12 <= 57) {
                           var18 = var12 - 48;
                        } else if(var12 >= 65 && var12 <= 90) {
                           var18 = var12 - 55;
                        } else {
                           if(var12 < 97 || var12 > 122) {
                              var6 = false;
                              break;
                           }

                           var18 = var12 - 87;
                        }

                        if(var18 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var18 = -var18;
                        }

                        int var13 = var9 * 10 + var18;
                        if(var13 / 10 != var9) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6) {
                     int var17 = class109.method2432(var16, 10);
                     if(var17 < 10) {
                        this.method3075("wrongjava");
                        return;
                     }
                  }
               }

               field2184 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3063();
         this.vmethod3031();
         class28.field682 = class161.method3203();

         while(0L == field2180 || class18.method214() < field2180) {
            class43.field1022 = class28.field682.vmethod3122(field2183, field2184);

            for(int var15 = 0; var15 < class43.field1022; ++var15) {
               this.method3080();
            }

            this.method3025();
            class106.method2392(class129.field2056, class45.field1042);
         }
      } catch (Exception var14) {
         class28.method651((String)null, var14);
         this.method3075("crash");
      }

      this.method3026();
   }

   @ObfuscatedName("qj")
   void method3025() {
      Container var1 = this.method3036();
      long var2 = class18.method214();
      long var4 = field2186[class102.field1761];
      field2186[class102.field1761] = var2;
      class102.field1761 = class102.field1761 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2178 = (32000 + (var6 >> 1)) / var6;
      }

      if(++field2193 - 1 > 50) {
         field2193 -= 50;
         field2190 = true;
         class45.field1042.setSize(class6.field107, class31.field749);
         class45.field1042.setVisible(true);
         if(var1 == class59.field1217) {
            Insets var7 = class59.field1217.getInsets();
            class45.field1042.setLocation(var7.left + field2179, var7.top + field2189);
         } else {
            class45.field1042.setLocation(field2179, field2189);
         }
      }

      this.vmethod3055();
   }

   @ObfuscatedName("qb")
   final synchronized void method3026() {
      if(!field2181) {
         field2181 = true;

         try {
            class45.field1042.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3034();
         } catch (Exception var4) {
            ;
         }

         if(class59.field1217 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class129.field2056) {
            try {
               class129.field2056.method2881();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3056();
      }
   }

   public void start() {
      if(field2188 == this && !field2181) {
         field2180 = 0L;
      }
   }

   public void stop() {
      if(field2188 == this && !field2181) {
         field2180 = class18.method214() + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusLost(FocusEvent var1) {
      field2195 = false;
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

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      field2195 = true;
      field2190 = true;
   }

   @ObfuscatedName("e")
   protected abstract void vmethod3031();

   @ObfuscatedName("j")
   protected abstract void vmethod3034();

   @ObfuscatedName("ql")
   protected Container method3036() {
      return (Container)(null != class59.field1217?class59.field1217:this);
   }

   @ObfuscatedName("qx")
   protected Dimension method3037() {
      Container var1 = this.method3036();
      int var2 = Math.max(var1.getWidth(), class118.field1985);
      int var3 = Math.max(var1.getHeight(), class140.field2160);
      if(class59.field1217 != null) {
         Insets var4 = class59.field1217.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("g")
   protected abstract void vmethod3044();

   @ObfuscatedName("m")
   protected abstract void vmethod3055();

   @ObfuscatedName("f")
   protected abstract void vmethod3056();

   @ObfuscatedName("ps")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "86"
   )
   protected final synchronized void method3063() {
      Container var1 = this.method3036();
      if(null != class45.field1042) {
         class45.field1042.removeFocusListener(this);
         var1.remove(class45.field1042);
      }

      class6.field107 = Math.max(var1.getWidth(), class118.field1985);
      class31.field749 = Math.max(var1.getHeight(), class140.field2160);
      Insets var2;
      if(null != class59.field1217) {
         var2 = class59.field1217.getInsets();
         class6.field107 -= var2.right + var2.left;
         class31.field749 -= var2.bottom + var2.top;
      }

      class45.field1042 = new class138(this);
      var1.add(class45.field1042);
      class45.field1042.setSize(class6.field107, class31.field749);
      class45.field1042.setVisible(true);
      if(var1 == class59.field1217) {
         var2 = class59.field1217.getInsets();
         class45.field1042.setLocation(var2.left + field2179, var2.top + field2189);
      } else {
         class45.field1042.setLocation(field2179, field2189);
      }

      class45.field1042.addFocusListener(this);
      class45.field1042.requestFocus();
      field2190 = true;
      class77 var3 = class19.method247(class6.field107, class31.field749, class45.field1042);
      if(null != class139.field2149) {
         class139.field2149.vmethod1900(var3.field1392.getGraphics(), 0, 0);
      }

      class139.field2149 = var3;
      field2192 = false;
      field2194 = class18.method214();
   }

   public abstract void init();

   public void destroy() {
      if(field2188 == this && !field2181) {
         field2180 = class18.method214();
         class103.method2301(5000L);
         this.method3026();
      }
   }

   @ObfuscatedName("qe")
   protected void method3075(String var1) {
      if(!this.field2182) {
         this.field2182 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("pc")
   void method3080() {
      long var1 = class18.method214();
      long var3 = field2191[class107.field1891];
      field2191[class107.field1891] = var1;
      class107.field1891 = class107.field1891 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class46.field1057 = field2195;
      }

      this.vmethod3044();
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-17"
   )
   static final void method3092() {
      for(int var0 = 0; var0 < client.field330; ++var0) {
         int var1 = client.field334[var0];
         class34 var2 = client.field358[var1];
         int var3 = client.field472.method2579();
         int var4;
         int var5;
         if((var3 & 2) != 0) {
            var4 = client.field472.method2642();
            var5 = client.field472.method2579();
            var2.method758(var4, var5, client.field303);
            var2.field838 = client.field303 + 300;
            var2.field835 = client.field472.method2546();
            var2.field836 = client.field472.method2546();
         }

         if((var3 & 64) != 0) {
            var4 = client.field472.method2579();
            var5 = client.field472.method2642();
            var2.method758(var4, var5, client.field303);
            var2.field838 = client.field303 + 300;
            var2.field835 = client.field472.method2514();
            var2.field836 = client.field472.method2546();
         }

         if((var3 & 128) != 0) {
            var2.field825 = client.field472.method2520();
            var2.field855 = 100;
         }

         if((var3 & 32) != 0) {
            var2.field859 = client.field472.method2547();
            var4 = client.field472.method2517();
            var2.field852 = var4 >> 16;
            var2.field868 = (var4 & '\uffff') + client.field303;
            var2.field849 = 0;
            var2.field850 = 0;
            if(var2.field868 > client.field303) {
               var2.field849 = -1;
            }

            if('\uffff' == var2.field859) {
               var2.field859 = -1;
            }
         }

         int var6;
         if((var3 & 8) != 0) {
            var4 = client.field472.method2690();
            var5 = client.field472.method2514();
            var6 = var2.field870 - (var4 - class147.field2214 - class147.field2214) * 64;
            int var7 = var2.field813 - 64 * (var5 - class17.field257 - class17.field257);
            if(0 != var6 || var7 != 0) {
               var2.field839 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 1) != 0) {
            var4 = client.field472.method2690();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = client.field472.method2540();
            if(var2.field869 == var4 && var4 != -1) {
               var6 = class134.method2875(var4).field1001;
               if(1 == var6) {
                  var2.field844 = 0;
                  var2.field856 = 0;
                  var2.field846 = var5;
                  var2.field847 = 0;
               }

               if(var6 == 2) {
                  var2.field847 = 0;
               }
            } else if(var4 == -1 || -1 == var2.field869 || class134.method2875(var4).field983 >= class134.method2875(var2.field869).field983) {
               var2.field869 = var4;
               var2.field844 = 0;
               var2.field856 = 0;
               var2.field846 = var5;
               var2.field847 = 0;
               var2.field861 = var2.field865;
            }
         }

         if(0 != (var3 & 4)) {
            var2.field837 = client.field472.method2514();
            if(var2.field837 == '\uffff') {
               var2.field837 = -1;
            }
         }

         if((var3 & 16) != 0) {
            var2.field785 = class23.method593(client.field472.method2546());
            var2.field816 = var2.field785.field881;
            var2.field864 = var2.field785.field910;
            var2.field820 = var2.field785.field893 * -1;
            var2.field821 = var2.field785.field894 * -1;
            var2.field860 = var2.field785.field904 * -1;
            var2.field823 = var2.field785.field914 * -1;
            var2.field817 = var2.field785.field890 * -1;
            var2.field830 = var2.field785.field891 * -1;
            var2.field819 = var2.field785.field892;
         }
      }

   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2188 && !field2181) {
         field2190 = true;
         if(null != class108.field1900 && class108.field1900.startsWith("1.5") && class18.method214() - field2194 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class6.field107 && var2.height >= class31.field749) {
               field2192 = true;
            }
         }

      }
   }

   @ObfuscatedName("w")
   static final byte[] method3110(byte[] var0) {
      class118 var1 = new class118(var0);
      int var2 = var1.method2579();
      int var3 = var1.method2517();
      if(var3 >= 0 && (0 == class166.field2672 || var3 <= class166.field2672)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2506(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2517();
            if(var4 < 0 || class166.field2672 != 0 && var4 > class166.field2672) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(1 == var2) {
                  class116.method2457(var5, var4, var0, 9);
               } else {
                  class166.field2668.method2453(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
