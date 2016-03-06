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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("er")
@Implements("GameEngine")
public abstract class class143 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ri")
   @ObfuscatedGetter(
      longValue = -3680540670619559579L
   )
   static volatile long field2198 = 0L;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 1143641043
   )
   static int field2199 = 0;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 1816255739
   )
   static int field2200 = 1;
   @ObfuscatedName("pu")
   static boolean field2201 = false;
   @ObfuscatedName("pi")
   boolean field2202;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 437503085
   )
   static int field2203 = 20;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      longValue = -5130131683057424855L
   )
   static long field2204 = 0L;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 95389503
   )
   @Export("fPS")
   protected static int field2205 = 0;
   @ObfuscatedName("qu")
   static long[] field2206 = new long[32];
   @ObfuscatedName("qm")
   static long[] field2207 = new long[32];
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 473414713
   )
   protected static int field2208 = 0;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 1978704855
   )
   protected static int field2209 = 0;
   @ObfuscatedName("qw")
   public static volatile boolean field2210 = true;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -1669466743
   )
   static int field2211 = 500;
   @ObfuscatedName("qp")
   protected static boolean field2212 = false;
   @ObfuscatedName("qd")
   protected static volatile boolean field2213 = false;
   @ObfuscatedName("rc")
   static volatile boolean field2214 = true;
   @ObfuscatedName("pb")
   static class143 field2215 = null;

   @ObfuscatedName("qk")
   protected final void method2957(int var1, int var2, int var3) {
      try {
         if(null != field2215) {
            ++field2199;
            if(field2199 >= 3) {
               this.method2970("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2215 = this;
         class142.field2190 = var1;
         class89.field1566 = var2;
         class147.field2232 = var3;
         class217.field3158 = this;
         if(null == class26.field648) {
            class26.field648 = new class135();
         }

         class26.field648.method2833(this, 1);
      } catch (Exception var5) {
         class16.method184((String)null, var5);
         this.method2970("crash");
      }

   }

   @ObfuscatedName("qc")
   protected final synchronized void method2958() {
      Container var1 = this.method2971();
      if(null != class125.field2039) {
         class125.field2039.removeFocusListener(this);
         var1.remove(class125.field2039);
      }

      class142.field2190 = Math.max(var1.getWidth(), class86.field1534);
      class89.field1566 = Math.max(var1.getHeight(), class45.field1044);
      Insets var2;
      if(client.field574 != null) {
         var2 = client.field574.getInsets();
         class142.field2190 -= var2.left + var2.right;
         class89.field1566 -= var2.top + var2.bottom;
      }

      class125.field2039 = new class138(this);
      var1.add(class125.field2039);
      class125.field2039.setSize(class142.field2190, class89.field1566);
      class125.field2039.setVisible(true);
      if(var1 == client.field574) {
         var2 = client.field574.getInsets();
         class125.field2039.setLocation(field2208 + var2.left, field2209 + var2.top);
      } else {
         class125.field2039.setLocation(field2208, field2209);
      }

      class125.field2039.addFocusListener(this);
      class125.field2039.requestFocus();
      field2210 = true;
      class77 var3 = class88.method2054(class142.field2190, class89.field1566, class125.field2039);
      if(class75.field1385 != null) {
         class75.field1385.vmethod1842(var3.field1399.getGraphics(), 0, 0);
      }

      class75.field1385 = var3;
      field2213 = false;
      field2198 = class109.method2381();
   }

   @ObfuscatedName("qx")
   protected final boolean method2959() {
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
                     this.method2970("invalidhost");
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
         if(null != class135.field2091) {
            String var1 = class135.field2091.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class135.field2090;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2970("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  for(var3 = 6; var3 < var2.length() && class47.method980(var2.charAt(var3)); ++var3) {
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
                        if(0 == var11) {
                           if(45 == var12) {
                              var7 = true;
                              break label186;
                           }

                           if(43 == var12) {
                              break label186;
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
                        if(var9 != var13 / 10) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6 && class106.method2339(var4) < 10) {
                     this.method2970("wrongjava");
                     return;
                  }
               }

               field2200 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2958();
         this.vmethod2967();
         class30.field703 = class121.method2700();

         label104:
         while(true) {
            class135 var16;
            Canvas var17;
            do {
               if(field2204 != 0L && class109.method2381() >= field2204) {
                  break label104;
               }

               class136.field2109 = class30.field703.vmethod3067(field2203, field2200);

               for(int var15 = 0; var15 < class136.field2109; ++var15) {
                  this.method2994();
               }

               this.method2987();
               var16 = class26.field648;
               var17 = class125.field2039;
            } while(var16.field2097 == null);

            for(var3 = 0; var3 < 50 && var16.field2097.peekEvent() != null; ++var3) {
               class105.method2332(1L);
            }

            if(var17 != null) {
               var16.field2097.postEvent(new ActionEvent(var17, 1001, "dummy"));
            }
         }
      } catch (Exception var14) {
         class16.method184((String)null, var14);
         this.method2970("crash");
      }

      this.method2986();
   }

   public void destroy() {
      if(field2215 == this && !field2201) {
         field2204 = class109.method2381();
         class105.method2332(5000L);
         this.method2986();
      }
   }

   public void start() {
      if(field2215 == this && !field2201) {
         field2204 = 0L;
      }
   }

   @ObfuscatedName("i")
   protected abstract void vmethod2963();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2215 && !field2201) {
         field2210 = true;
         if(class135.field2090 != null && class135.field2090.startsWith("1.5") && class109.method2381() - field2198 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class142.field2190 && var2.height >= class89.field1566) {
               field2213 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field2214 = true;
      field2210 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2214 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("ri")
   protected Dimension method2966() {
      Container var1 = this.method2971();
      int var2 = Math.max(var1.getWidth(), class86.field1534);
      int var3 = Math.max(var1.getHeight(), class45.field1044);
      if(null != client.field574) {
         Insets var4 = client.field574.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("o")
   protected abstract void vmethod2967();

   @ObfuscatedName("h")
   protected abstract void vmethod2968();

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("k")
   protected abstract void vmethod2969();

   @ObfuscatedName("qp")
   protected void method2970(String var1) {
      if(!this.field2202) {
         this.field2202 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qd")
   protected Container method2971() {
      return (Container)(null != client.field574?client.field574:this);
   }

   @ObfuscatedName("j")
   public static void method2979() {
      class210.field3125 = new class201();
   }

   @ObfuscatedName("l")
   static void method2982(File var0, File var1) {
      try {
         class226 var2 = new class226(class148.field2237, "rw", 10000L);
         class118 var3 = new class118(500);
         var3.method2438(3);
         var3.method2438(null != var1?1:0);
         var3.method2446(var0.getPath());
         if(null != var1) {
            var3.method2446(var1.getPath());
         }

         var2.method4061(var3.field1995, 0, var3.field1998);
         var2.method4069();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("qw")
   final synchronized void method2986() {
      if(!field2201) {
         field2201 = true;

         try {
            class125.field2039.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2969();
         } catch (Exception var4) {
            ;
         }

         if(client.field574 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class26.field648) {
            try {
               class26.field648.method2809();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2963();
      }
   }

   @ObfuscatedName("qy")
   void method2987() {
      Container var1 = this.method2971();
      long var2 = class109.method2381();
      long var4 = field2206[class217.field3161];
      field2206[class217.field3161] = var2;
      class217.field3161 = 1 + class217.field3161 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2205 = ((var6 >> 1) + 32000) / var6;
      }

      if(++field2211 - 1 > 50) {
         field2211 -= 50;
         field2210 = true;
         class125.field2039.setSize(class142.field2190, class89.field1566);
         class125.field2039.setVisible(true);
         if(client.field574 == var1) {
            Insets var7 = client.field574.getInsets();
            class125.field2039.setLocation(var7.left + field2208, var7.top + field2209);
         } else {
            class125.field2039.setLocation(field2208, field2209);
         }
      }

      this.vmethod3033();
   }

   @ObfuscatedName("qt")
   void method2994() {
      long var1 = class109.method2381();
      long var3 = field2207[class94.field1627];
      field2207[class94.field1627] = var1;
      class94.field1627 = class94.field1627 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class50.field1106 = field2214;
      }

      this.vmethod2968();
   }

   public void stop() {
      if(field2215 == this && !field2201) {
         field2204 = class109.method2381() + 4000L;
      }
   }

   @ObfuscatedName("n")
   protected abstract void vmethod3033();

   public abstract void init();

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }
}
