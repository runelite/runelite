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

@ObfuscatedName("em")
@Implements("GameEngine")
public abstract class class147 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -1414177189
   )
   static int field2251 = 20;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = 325039805
   )
   static int field2252 = 0;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      longValue = 2076138819687844761L
   )
   static long field2253 = 0L;
   @ObfuscatedName("pg")
   static boolean field2254 = false;
   @ObfuscatedName("pd")
   boolean field2255;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = 9098071
   )
   static int field2256 = 1;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 566740855
   )
   static int field2258 = 500;
   @ObfuscatedName("qt")
   protected static long[] field2259 = new long[32];
   @ObfuscatedName("qd")
   protected static long[] field2260 = new long[32];
   @ObfuscatedName("rv")
   static volatile boolean field2261 = true;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 1189694439
   )
   protected static int field2262 = 0;
   @ObfuscatedName("qe")
   public static volatile boolean field2263 = true;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -592561851
   )
   @Export("FPS")
   protected static int field2264 = 0;
   @ObfuscatedName("qi")
   protected static boolean field2265 = false;
   @ObfuscatedName("qx")
   protected static volatile boolean field2266 = false;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      longValue = -7721056355659316701L
   )
   static volatile long field2267 = 0L;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -719269089
   )
   protected static int field2268 = 0;
   @ObfuscatedName("pp")
   static class147 field2270 = null;

   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "53"
   )
   protected final void method3155(int var1, int var2, int var3) {
      try {
         if(field2270 != null) {
            ++field2252;
            if(field2252 >= 3) {
               this.method3170("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2270 = this;
         class189.field3056 = var1;
         class39.field892 = var2;
         class151.field2284 = var3;
         class151.field2286 = this;
         if(null == class125.field2070) {
            class125.field2070 = new class139();
         }

         class125.field2070.method3029(this, 1);
      } catch (Exception var5) {
         class13.method176((String)null, var5);
         this.method3170("crash");
      }

   }

   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1932774633"
   )
   protected final synchronized void method3156() {
      Container var1 = this.method3174();
      if(class107.field1867 != null) {
         class107.field1867.removeFocusListener(this);
         var1.remove(class107.field1867);
      }

      class189.field3056 = Math.max(var1.getWidth(), class102.field1757);
      class39.field892 = Math.max(var1.getHeight(), class128.field2089);
      Insets var2;
      if(class114.field2013 != null) {
         var2 = class114.field2013.getInsets();
         class189.field3056 -= var2.right + var2.left;
         class39.field892 -= var2.top + var2.bottom;
      }

      class107.field1867 = new class142(this);
      var1.add(class107.field1867);
      class107.field1867.setSize(class189.field3056, class39.field892);
      class107.field1867.setVisible(true);
      if(var1 == class114.field2013) {
         var2 = class114.field2013.getInsets();
         class107.field1867.setLocation(field2268 + var2.left, var2.top + field2262);
      } else {
         class107.field1867.setLocation(field2268, field2262);
      }

      class107.field1867.addFocusListener(this);
      class107.field1867.requestFocus();
      field2263 = true;
      class80 var3 = class21.method573(class189.field3056, class39.field892, class107.field1867);
      if(class54.field1173 != null) {
         class54.field1173.vmethod1965(var3.field1475.getGraphics(), 0, 0);
      }

      class54.field1173 = var3;
      field2266 = false;
      field2267 = class56.method1249();
   }

   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-124"
   )
   protected final boolean method3157() {
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
                     this.method3170("invalidhost");
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
         int var3;
         if(null != class139.field2152) {
            String var1 = class139.field2152.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class139.field2146;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3170("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  for(var3 = 6; var3 < var2.length() && class40.method812(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var7 = false;
                  boolean var8 = false;
                  int var9 = 0;
                  int var10 = var4.length();
                  int var11 = 0;

                  boolean var6;
                  while(true) {
                     if(var11 >= var10) {
                        var6 = var8;
                        break;
                     }

                     label186: {
                        char var12 = var4.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == 45) {
                              var7 = true;
                              break label186;
                           }

                           if(var12 == 43) {
                              break label186;
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

                        int var13 = var19 + 10 * var9;
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
                     int var18 = class5.method91(var4, 10, true);
                     if(var18 < 10) {
                        this.method3170("wrongjava");
                        return;
                     }
                  }
               }

               field2256 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3156();
         this.vmethod3166();
         class96.field1669 = class53.method1137();

         label104:
         while(true) {
            class139 var16;
            Canvas var17;
            do {
               if(0L != field2253 && class56.method1249() >= field2253) {
                  break label104;
               }

               class45.field1050 = class96.field1669.vmethod3261(field2251, field2256);

               for(int var14 = 0; var14 < class45.field1050; ++var14) {
                  this.method3158();
               }

               this.method3159();
               var16 = class125.field2070;
               var17 = class107.field1867;
            } while(null == var16.field2151);

            for(var3 = 0; var3 < 50 && var16.field2151.peekEvent() != null; ++var3) {
               class22.method594(1L);
            }

            if(null != var17) {
               var16.field2151.postEvent(new ActionEvent(var17, 1001, "dummy"));
            }
         }
      } catch (Exception var15) {
         class13.method176((String)null, var15);
         this.method3170("crash");
      }

      this.method3189();
   }

   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "230061674"
   )
   void method3158() {
      long var1 = class56.method1249();
      long var3 = field2260[class19.field286];
      field2260[class19.field286] = var1;
      class19.field286 = 1 + class19.field286 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class54.field1172 = field2261;
      }

      this.vmethod3246();
   }

   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "485557939"
   )
   void method3159() {
      Container var1 = this.method3174();
      long var2 = class56.method1249();
      long var4 = field2259[class101.field1745];
      field2259[class101.field1745] = var2;
      class101.field1745 = class101.field1745 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2264 = ((var6 >> 1) + 32000) / var6;
      }

      if(++field2258 - 1 > 50) {
         field2258 -= 50;
         field2263 = true;
         class107.field1867.setSize(class189.field3056, class39.field892);
         class107.field1867.setVisible(true);
         if(class114.field2013 == var1) {
            Insets var7 = class114.field2013.getInsets();
            class107.field1867.setLocation(var7.left + field2268, field2262 + var7.top);
         } else {
            class107.field1867.setLocation(field2268, field2262);
         }
      }

      this.vmethod3225();
   }

   public void stop() {
      if(this == field2270 && !field2254) {
         field2253 = class56.method1249() + 4000L;
      }
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2270 && !field2254) {
         field2263 = true;
         if(class139.field2146 != null && class139.field2146.startsWith("1.5") && class56.method1249() - field2267 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class189.field3056 && var2.height >= class39.field892) {
               field2266 = true;
            }
         }

      }
   }

   public final void focusLost(FocusEvent var1) {
      field2261 = false;
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

   public abstract void init();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   protected abstract void vmethod3166();

   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1479444814"
   )
   protected void method3170(String var1) {
      if(!this.field2255) {
         this.field2255 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "-1159034136"
   )
   protected Dimension method3172() {
      Container var1 = this.method3174();
      int var2 = Math.max(var1.getWidth(), class102.field1757);
      int var3 = Math.max(var1.getHeight(), class128.field2089);
      if(null != class114.field2013) {
         Insets var4 = class114.field2013.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "265552880"
   )
   protected abstract void vmethod3173();

   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1527425134"
   )
   protected Container method3174() {
      return (Container)(class114.field2013 != null?class114.field2013:this);
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      field2261 = true;
      field2263 = true;
   }

   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-824891580"
   )
   final synchronized void method3189() {
      if(!field2254) {
         field2254 = true;

         try {
            class107.field1867.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3234();
         } catch (Exception var4) {
            ;
         }

         if(null != class114.field2013) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class125.field2070) {
            try {
               class125.field2070.method3026();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3173();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public void start() {
      if(this == field2270 && !field2254) {
         field2253 = 0L;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   protected abstract void vmethod3225();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1575533843"
   )
   protected abstract void vmethod3234();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lclass56;",
      garbageValue = "-2"
   )
   public static class56 method3242(int var0) {
      class56 var1 = (class56)class56.field1231.method3905((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class56.field1232.method3411(16, var0);
         var1 = new class56();
         if(null != var2) {
            var1.method1236(new class122(var2));
         }

         class56.field1231.method3907(var1, (long)var0);
         return var1;
      }
   }

   public void destroy() {
      if(field2270 == this && !field2254) {
         field2253 = class56.method1249();
         class22.method594(5000L);
         this.method3189();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1031914960"
   )
   protected abstract void vmethod3246();

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "([Lclass176;II)V",
      garbageValue = "424460431"
   )
   static final void method3250(class176[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class176 var3 = var0[var2];
         if(null != var3 && var3.field2826 == var1 && (!var3.field2855 || !class9.method132(var3))) {
            int var5;
            if(var3.field2910 == 0) {
               if(!var3.field2855 && class9.method132(var3) && var3 != class11.field177) {
                  continue;
               }

               method3250(var0, var3.field2807);
               if(null != var3.field2931) {
                  method3250(var3.field2931, var3.field2807);
               }

               class3 var7 = (class3)client.field475.method3936((long)var3.field2807);
               if(null != var7) {
                  var5 = var7.field70;
                  if(class14.method179(var5)) {
                     method3250(class176.field2836[var5], -1);
                  }
               }
            }

            if(var3.field2910 == 6) {
               if(var3.field2854 != -1 || var3.field2923 != -1) {
                  boolean var4 = class53.method1149(var3);
                  if(var4) {
                     var5 = var3.field2923;
                  } else {
                     var5 = var3.field2854;
                  }

                  if(var5 != -1) {
                     class44 var6 = class22.method585(var5);

                     for(var3.field2930 += client.field370; var3.field2930 > var6.field1018[var3.field2929]; class79.method1777(var3)) {
                        var3.field2930 -= var6.field1018[var3.field2929];
                        ++var3.field2929;
                        if(var3.field2929 >= var6.field1030.length) {
                           var3.field2929 -= var6.field1020;
                           if(var3.field2929 < 0 || var3.field2929 >= var6.field1030.length) {
                              var3.field2929 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2863 != 0 && !var3.field2855) {
                  int var8 = var3.field2863 >> 16;
                  var5 = var3.field2863 << 16 >> 16;
                  var8 *= client.field370;
                  var5 *= client.field370;
                  var3.field2927 = var3.field2927 + var8 & 2047;
                  var3.field2859 = var5 + var3.field2859 & 2047;
                  class79.method1777(var3);
               }
            }
         }
      }

   }
}
