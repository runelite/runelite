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
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = 1057723811
   )
   protected static int field2241 = 0;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -1722798149
   )
   static int field2242 = 0;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      longValue = -7991595145011478525L
   )
   static long field2243 = 0L;
   @ObfuscatedName("pu")
   static boolean field2244 = false;
   @ObfuscatedName("pm")
   boolean field2245;
   @ObfuscatedName("qs")
   protected static volatile boolean field2246 = false;
   @ObfuscatedName("qr")
   protected static boolean field2247 = false;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 187493041
   )
   protected static int field2248 = 0;
   @ObfuscatedName("qy")
   static long[] field2249 = new long[32];
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      longValue = 1831698517766920977L
   )
   static volatile long field2251 = 0L;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -1281671873
   )
   protected static int field2252 = 0;
   @ObfuscatedName("qv")
   public static volatile boolean field2253 = true;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -468515047
   )
   static int field2254 = 500;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = -1343355883
   )
   static int field2255 = 20;
   @ObfuscatedName("qd")
   static long[] field2256 = new long[32];
   @ObfuscatedName("rc")
   static volatile boolean field2257 = true;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 419090643
   )
   static int field2258 = 1;
   @ObfuscatedName("pr")
   static GameEngine field2260 = null;

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("pp")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "624802550"
   )
   protected final boolean method3046() {
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
                     this.method3051("invalidhost");
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
         if(class93.field1614 != null) {
            String var1 = class93.field1614.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class139.field2140;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3051("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  for(var3 = 6; var3 < var2.length() && class143.method3011(var2.charAt(var3)); ++var3) {
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

                        int var13 = 10 * var9 + var19;
                        if(var9 != var13 / 10) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6) {
                     int var18 = class145.method3022(var4, 10, true);
                     if(var18 < 10) {
                        this.method3051("wrongjava");
                        return;
                     }
                  }
               }

               field2258 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3114();
         this.vmethod3054();
         class175.field2787 = class132.method2860();

         label104:
         while(true) {
            class139 var16;
            Canvas var17;
            do {
               if(0L != field2243 && class34.method738() >= field2243) {
                  break label104;
               }

               class34.field789 = class175.field2787.vmethod3148(field2255, field2258);

               for(int var14 = 0; var14 < class34.field789; ++var14) {
                  this.method3047();
               }

               this.method3048();
               var16 = class40.field898;
               var17 = class164.canvas;
            } while(var16.field2148 == null);

            for(var3 = 0; var3 < 50 && var16.field2148.peekEvent() != null; ++var3) {
               PlayerComposition.method3511(1L);
            }

            if(var17 != null) {
               var16.field2148.postEvent(new ActionEvent(var17, 1001, "dummy"));
            }
         }
      } catch (Exception var15) {
         class93.method2139((String)null, var15);
         this.method3051("crash");
      }

      this.method3119();
   }

   @ObfuscatedName("pn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-62"
   )
   void method3047() {
      long var1 = class34.method738();
      long var3 = field2256[class194.field3132];
      field2256[class194.field3132] = var1;
      class194.field3132 = 1 + class194.field3132 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class38.field833 = field2257;
      }

      this.packetHandler();
   }

   @ObfuscatedName("py")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   void method3048() {
      Container var1 = this.method3081();
      long var2 = class34.method738();
      long var4 = field2249[class4.field73];
      field2249[class4.field73] = var2;
      class4.field73 = 1 + class4.field73 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2248 = (32000 + (var6 >> 1)) / var6;
      }

      if(++field2254 - 1 > 50) {
         field2254 -= 50;
         field2253 = true;
         class164.canvas.setSize(class62.field1267, class77.field1428);
         class164.canvas.setVisible(true);
         if(var1 == class0.field15) {
            Insets var7 = class0.field15.getInsets();
            class164.canvas.setLocation(var7.left + field2241, var7.top + field2252);
         } else {
            class164.canvas.setLocation(field2241, field2252);
         }
      }

      this.vmethod3056();
   }

   public void start() {
      if(this == field2260 && !field2244) {
         field2243 = 0L;
      }
   }

   public void stop() {
      if(field2260 == this && !field2244) {
         field2243 = class34.method738() + 4000L;
      }
   }

   public void destroy() {
      if(field2260 == this && !field2244) {
         field2243 = class34.method738();
         PlayerComposition.method3511(5000L);
         this.method3119();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2260 && !field2244) {
         field2253 = true;
         if(null != class139.field2140 && class139.field2140.startsWith("1.5") && class34.method738() - field2251 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class62.field1267 && var2.height >= class77.field1428) {
               field2246 = true;
            }
         }

      }
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      field2257 = true;
      field2253 = true;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("pg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1588509536"
   )
   protected void method3051(String var1) {
      if(!this.field2245) {
         this.field2245 = true;
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

   public abstract void init();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-14217"
   )
   protected abstract void vmethod3054();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1748155642"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-152826336"
   )
   protected abstract void vmethod3056();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   protected abstract void vmethod3057();

   @ObfuscatedName("pb")
   @ObfuscatedSignature(
      signature = "(S)Ljava/awt/Dimension;",
      garbageValue = "10549"
   )
   protected Dimension method3060() {
      Container var1 = this.method3081();
      int var2 = Math.max(var1.getWidth(), class116.field2014);
      int var3 = Math.max(var1.getHeight(), class130.field2102);
      if(null != class0.field15) {
         Insets var4 = class0.field15.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1338462384"
   )
   protected abstract void vmethod3061();

   @ObfuscatedName("pw")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-8"
   )
   protected final void method3065(int var1, int var2, int var3) {
      try {
         if(null != field2260) {
            ++field2242;
            if(field2242 >= 3) {
               this.method3051("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2260 = this;
         class62.field1267 = var1;
         class77.field1428 = var2;
         class151.field2273 = var3;
         class151.field2278 = this;
         if(class40.field898 == null) {
            class40.field898 = new class139();
         }

         class40.field898.method2920(this, 1);
      } catch (Exception var5) {
         class93.method2139((String)null, var5);
         this.method3051("crash");
      }

   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("pl")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-883528289"
   )
   protected Container method3081() {
      return (Container)(class0.field15 != null?class0.field15:this);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CS)Z",
      garbageValue = "3934"
   )
   public static boolean method3089(char var0) {
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         if(var0 != 0) {
            char[] var1 = class168.field2709;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public final void focusLost(FocusEvent var1) {
      field2257 = false;
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @ObfuscatedName("ps")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1606871673"
   )
   protected final synchronized void method3114() {
      Container var1 = this.method3081();
      if(class164.canvas != null) {
         class164.canvas.removeFocusListener(this);
         var1.remove(class164.canvas);
      }

      class62.field1267 = Math.max(var1.getWidth(), class116.field2014);
      class77.field1428 = Math.max(var1.getHeight(), class130.field2102);
      Insets var2;
      if(null != class0.field15) {
         var2 = class0.field15.getInsets();
         class62.field1267 -= var2.right + var2.left;
         class77.field1428 -= var2.bottom + var2.top;
      }

      class164.canvas = new RSCanvas(this);
      var1.add(class164.canvas);
      class164.canvas.setSize(class62.field1267, class77.field1428);
      class164.canvas.setVisible(true);
      if(var1 == class0.field15) {
         var2 = class0.field15.getInsets();
         class164.canvas.setLocation(var2.left + field2241, var2.top + field2252);
      } else {
         class164.canvas.setLocation(field2241, field2252);
      }

      class164.canvas.addFocusListener(this);
      class164.canvas.requestFocus();
      field2253 = true;
      BufferProvider var3 = class47.method980(class62.field1267, class77.field1428, class164.canvas);
      if(null != class220.bufferProvider) {
         class220.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      class220.bufferProvider = var3;
      field2246 = false;
      field2251 = class34.method738();
   }

   @ObfuscatedName("po")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-770730541"
   )
   final synchronized void method3119() {
      if(!field2244) {
         field2244 = true;

         try {
            class164.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3057();
         } catch (Exception var4) {
            ;
         }

         if(class0.field15 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class40.field898 != null) {
            try {
               class40.field898.method2917();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3061();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "65280"
   )
   public static FileOnDisk method3132(String var0, String var1, boolean var2) {
      File var3 = new File(class152.field2281, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class77.field1426 == 33) {
         var4 = "_rc";
      } else if(class77.field1426 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class152.field2280, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
