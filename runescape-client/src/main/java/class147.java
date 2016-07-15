import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Component;
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

@ObfuscatedName("er")
@Implements("GameEngine")
public abstract class class147 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 1255331777
   )
   static int field2239 = 0;
   @ObfuscatedName("rq")
   static volatile boolean field2240 = true;
   @ObfuscatedName("ps")
   static class147 field2241 = null;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -1670067055
   )
   static int field2242 = 500;
   @ObfuscatedName("pn")
   boolean field2243;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 331512913
   )
   static int field2244 = 20;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      longValue = -6177092798011502853L
   )
   static long field2245 = 0L;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 752275289
   )
   @Export("FPS")
   protected static int field2246 = 0;
   @ObfuscatedName("pe")
   static boolean field2247 = false;
   @ObfuscatedName("qp")
   protected static long[] field2248 = new long[32];
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 1893515339
   )
   protected static int field2249 = 0;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -981804325
   )
   protected static int field2250 = 0;
   @ObfuscatedName("qc")
   public static volatile boolean field2251 = true;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 1264960145
   )
   static int field2252 = 1;
   @ObfuscatedName("qu")
   protected static boolean field2253 = false;
   @ObfuscatedName("qr")
   protected static volatile boolean field2254 = false;
   @ObfuscatedName("qk")
   protected static long[] field2255 = new long[32];
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      longValue = 4130633476147748039L
   )
   static volatile long field2256 = 0L;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = 9111439788473701007L
   )
   static long field2258;

   @ObfuscatedName("rg")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "1630822111"
   )
   protected Dimension method3107() {
      Container var1 = this.method3122();
      int var2 = Math.max(var1.getWidth(), class114.field2019);
      int var3 = Math.max(var1.getHeight(), class47.field1076);
      if(class105.field1845 != null) {
         Insets var4 = class105.field1845.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   protected final synchronized void method3109() {
      Container var1 = this.method3122();
      if(class158.field2346 != null) {
         class158.field2346.removeFocusListener(this);
         var1.remove(class158.field2346);
      }

      class142.field2191 = Math.max(var1.getWidth(), class114.field2019);
      class132.field2109 = Math.max(var1.getHeight(), class47.field1076);
      Insets var2;
      if(class105.field1845 != null) {
         var2 = class105.field1845.getInsets();
         class142.field2191 -= var2.left + var2.right;
         class132.field2109 -= var2.bottom + var2.top;
      }

      class158.field2346 = new class142(this);
      var1.add(class158.field2346);
      class158.field2346.setSize(class142.field2191, class132.field2109);
      class158.field2346.setVisible(true);
      if(var1 == class105.field1845) {
         var2 = class105.field1845.getInsets();
         class158.field2346.setLocation(var2.left + field2249, field2250 + var2.top);
      } else {
         class158.field2346.setLocation(field2249, field2250);
      }

      class158.field2346.addFocusListener(this);
      class158.field2346.requestFocus();
      field2251 = true;
      int var3 = class142.field2191;
      int var4 = class132.field2109;
      Canvas var5 = class158.field2346;

      Object var9;
      try {
         class84 var6 = new class84();
         var6.vmethod1966(var3, var4, var5);
         var9 = var6;
      } catch (Throwable var8) {
         class78 var7 = new class78();
         var7.vmethod1966(var3, var4, var5);
         var9 = var7;
      }

      if(null != class44.field1039) {
         class44.field1039.vmethod1975(((class80)var9).field1462.getGraphics(), 0, 0);
      }

      class44.field1039 = (class80)var9;
      field2254 = false;
      field2256 = client.method424();
   }

   public void run() {
      try {
         if(null != class139.field2143) {
            String var1 = class139.field2143.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class216.field3190;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3121("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class140.method3024(var2.charAt(var3)); ++var3) {
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

                     label193: {
                        char var12 = var4.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == 45) {
                              var7 = true;
                              break label193;
                           }

                           if(var12 == 43) {
                              break label193;
                           }
                        }

                        int var21;
                        if(var12 >= 48 && var12 <= 57) {
                           var21 = var12 - 48;
                        } else if(var12 >= 65 && var12 <= 90) {
                           var21 = var12 - 55;
                        } else {
                           if(var12 < 97 || var12 > 122) {
                              var6 = false;
                              break;
                           }

                           var21 = var12 - 87;
                        }

                        if(var21 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var21 = -var21;
                        }

                        int var13 = var9 * 10 + var21;
                        if(var9 != var13 / 10) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6 && class48.method1046(var4) < 10) {
                     this.method3121("wrongjava");
                     return;
                  }
               }

               field2252 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3109();
         this.vmethod3191();

         Object var19;
         try {
            var19 = new class150();
         } catch (Throwable var17) {
            var19 = new class144();
         }

         class158.field2347 = (class136)var19;

         label112:
         while(true) {
            Canvas var15;
            class139 var20;
            do {
               if(0L != field2245 && client.method424() >= field2245) {
                  break label112;
               }

               class113.field1974 = class158.field2347.vmethod3207(field2244, field2252);

               for(int var14 = 0; var14 < class113.field1974; ++var14) {
                  this.method3111();
               }

               this.method3164();
               var20 = class107.field1869;
               var15 = class158.field2346;
            } while(null == var20.field2144);

            for(int var16 = 0; var16 < 50 && var20.field2144.peekEvent() != null; ++var16) {
               class125.method2881(1L);
            }

            if(null != var15) {
               var20.field2144.postEvent(new ActionEvent(var15, 1001, "dummy"));
            }
         }
      } catch (Exception var18) {
         class46.method1008((String)null, var18);
         this.method3121("crash");
      }

      this.method3113();
   }

   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-205430169"
   )
   void method3111() {
      long var1 = client.method424();
      long var3 = field2248[class23.field622];
      field2248[class23.field622] = var1;
      class23.field622 = class23.field622 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class59.field1263 = field2240;
      }

      this.vmethod3118();
   }

   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2105536801"
   )
   final synchronized void method3113() {
      if(!field2247) {
         field2247 = true;

         try {
            class158.field2346.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3120();
         } catch (Exception var4) {
            ;
         }

         if(class105.field1845 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class107.field1869) {
            try {
               class107.field1869.method3016();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3124();
      }
   }

   public void start() {
      if(this == field2241 && !field2247) {
         field2245 = 0L;
      }
   }

   public void destroy() {
      if(field2241 == this && !field2247) {
         field2245 = client.method424();
         class125.method2881(5000L);
         this.method3113();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2241 && !field2247) {
         field2251 = true;
         if(null != class216.field3190 && class216.field3190.startsWith("1.5") && client.method424() - field2256 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class142.field2191 && var2.height >= class132.field2109) {
               field2254 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field2240 = true;
      field2251 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2240 = false;
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

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-56"
   )
   protected abstract void vmethod3118();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   protected abstract void vmethod3119();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   protected abstract void vmethod3120();

   @ObfuscatedName("rq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-55783097"
   )
   protected void method3121(String var1) {
      if(!this.field2243) {
         this.field2243 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("rf")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1212893483"
   )
   protected Container method3122() {
      return (Container)(null != class105.field1845?class105.field1845:this);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1356024751"
   )
   protected abstract void vmethod3124();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass170;Lclass170;ZII)V",
      garbageValue = "951560562"
   )
   static void method3138(Component var0, class170 var1, class170 var2, boolean var3, int var4) {
      if(class33.field773) {
         if(var4 == 4) {
            class33.field778 = 4;
         }

      } else {
         class33.field778 = var4;
         class82.method1887();
         byte[] var5 = var1.method3358("title.jpg", "");
         class33.field761 = new class81(var5, var0);
         class8.field151 = class33.field761.method1854();
         if((client.field292 & 536870912) != 0) {
            class33.field762 = class24.method580(var2, "logo_deadman_mode", "");
         } else {
            class33.field762 = class24.method580(var2, "logo", "");
         }

         class33.field759 = class24.method580(var2, "titlebox", "");
         class33.field760 = class24.method580(var2, "titlebutton", "");
         class35.field818 = class178.method3539(var2, "runes", "");
         class29.field712 = class178.method3539(var2, "title_mute", "");
         class192.field3095 = class24.method580(var2, "options_radio_buttons,0", "");
         class3.field61 = class24.method580(var2, "options_radio_buttons,2", "");
         class79.field1456 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class79.field1456[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class79.field1456[var6 + 64] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class79.field1456[128 + var6] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class79.field1456[var6 + 192] = 16777215;
         }

         class33.field785 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field785[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field785[64 + var6] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field785[128 + var6] = 262144 * var6 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field785[var6 + 192] = 16777215;
         }

         class101.field1744 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class101.field1744[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class101.field1744[var6 + 64] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class101.field1744[128 + var6] = var6 * 1024 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class101.field1744[var6 + 192] = 16777215;
         }

         class110.field1954 = new int[256];
         class22.field606 = new int['耀'];
         class143.field2210 = new int['耀'];
         class36.method762((class83)null);
         class33.field771 = new int['耀'];
         class0.field6 = new int['耀'];
         if(var3) {
            class33.field784 = "";
            class33.field780 = "";
         }

         class180.field2948 = 0;
         class33.field786 = "";
         class33.field787 = true;
         class33.field757 = false;
         if(!client.field571.field144) {
            class171 var9 = class109.field1948;
            int var7 = var9.method3342("scape main");
            int var8 = var9.method3357(var7, "");
            class87.method1996(2, var9, var7, var8, 255, false);
         } else {
            class182.method3600(2);
         }

         class62.method1369(false);
         class33.field773 = true;
         class33.field758 = (class142.field2191 - client.field510) / 2;
         class33.field765 = 202 + class33.field758;
         class33.field761.method1800(class33.field758, 0);
         class8.field151.method1800(class33.field758 + 382, 0);
         class33.field762.method1952(382 + class33.field758 - class33.field762.field1486 / 2, 18);
      }
   }

   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-15245"
   )
   protected final boolean method3143() {
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
                     this.method3121("invalidhost");
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

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "845246119"
   )
   void method3164() {
      Container var1 = this.method3122();
      long var2 = client.method424();
      long var4 = field2255[class6.field125];
      field2255[class6.field125] = var2;
      class6.field125 = class6.field125 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var7 = (int)(var2 - var4);
         field2246 = (32000 + (var7 >> 1)) / var7;
      }

      if(++field2242 - 1 > 50) {
         field2242 -= 50;
         field2251 = true;
         class158.field2346.setSize(class142.field2191, class132.field2109);
         class158.field2346.setVisible(true);
         if(var1 == class105.field1845) {
            Insets var6 = class105.field1845.getInsets();
            class158.field2346.setLocation(field2249 + var6.left, var6.top + field2250);
         } else {
            class158.field2346.setLocation(field2249, field2250);
         }
      }

      this.vmethod3119();
   }

   public void stop() {
      if(field2241 == this && !field2247) {
         field2245 = client.method424() + 4000L;
      }
   }

   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1566045977"
   )
   protected final void method3187(int var1, int var2, int var3) {
      try {
         if(field2241 != null) {
            ++field2239;
            if(field2239 >= 3) {
               this.method3121("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2241 = this;
         class142.field2191 = var1;
         class132.field2109 = var2;
         class151.field2271 = var3;
         class151.field2270 = this;
         if(null == class107.field1869) {
            class107.field1869 = new class139();
         }

         class107.field1869.method3005(this, 1);
      } catch (Exception var5) {
         class46.method1008((String)null, var5);
         this.method3121("crash");
      }

   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "122"
   )
   protected abstract void vmethod3191();

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)Lclass81;",
      garbageValue = "487185079"
   )
   public static class81 method3192(class170 var0, String var1, String var2) {
      int var3 = var0.method3342(var1);
      int var4 = var0.method3357(var3, var2);
      return class117.method2533(var0, var3, var4);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "707283246"
   )
   static void method3193(int var0, int var1) {
      if(client.field354 != 0 && var0 != -1) {
         class127.method2904(class104.field1813, var0, 0, client.field354, false);
         client.field411 = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-2054218435"
   )
   public static int method3194(byte[] var0, int var1, CharSequence var2) {
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
