import java.applet.Applet;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ad")
public final class class50 implements KeyListener, FocusListener {
   @ObfuscatedName("cb")
   public static int[] field634;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -344812585
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("p")
   @Export("keyboard")
   public static class50 keyboard;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1821405625
   )
   public static int field652;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 632684771
   )
   public static int field653;
   @ObfuscatedName("ct")
   static char[] field654;
   @ObfuscatedName("cy")
   static int[] field655;
   @ObfuscatedName("cr")
   public static int[] field656;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -1960883123
   )
   public static int field657;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1352737815
   )
   public static int field658;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 767274993
   )
   public static int field659;
   @ObfuscatedName("cp")
   public static boolean[] field660;
   @ObfuscatedName("cc")
   static int[] field662;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -10455741
   )
   public static int field665;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field662.length) {
            var2 = field662[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field653 >= 0 && var2 >= 0) {
            field634[field653] = var2;
            field653 = field653 + 1 & 127;
            if(field652 == field653) {
               field653 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field659 + 1 & 127;
            if(var3 != field658) {
               field655[field659] = var2;
               field654[field659] = 0;
               field659 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label56: {
                  if(var2 != 0) {
                     char[] var4 = class266.field3665;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label56;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var7 = field659 + 1 & 127;
               if(var7 != field658) {
                  field655[field659] = -1;
                  field654[field659] = var2;
                  field659 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field653 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field662.length) {
            var2 = field662[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field653 >= 0 && var2 >= 0) {
            field634[field653] = ~var2;
            field653 = field653 + 1 & 127;
            if(field653 == field652) {
               field653 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "0"
   )
   static boolean method725(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field687.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var11.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var10 = class52.method733(class56.field688, var2, new Object[]{(new URL(class56.field688.getCodeBase(), var0)).toString()});
            return var10 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field688.getAppletContext().showDocument(new URL(class56.field688.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class56.field688;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var9) {
            ;
         }

         try {
            class56.field688.getAppletContext().showDocument(new URL(class56.field688.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-56"
   )
   static void method726() {
      class61.underlayIds = (byte[][][])((byte[][][])null);
      class61.overlayIds = (byte[][][])((byte[][][])null);
      class90.overlayPaths = (byte[][][])((byte[][][])null);
      class275.overlayRotations = (byte[][][])((byte[][][])null);
      class61.field750 = (int[][][])((int[][][])null);
      class267.field3669 = (byte[][][])((byte[][][])null);
      XItemContainer.field774 = (int[][])((int[][])null);
      Widget.field2648 = null;
      class61.field753 = null;
      WallObject.field2140 = null;
      class40.field552 = null;
      WidgetNode.field810 = null;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(LPendingSpawn;B)V",
      garbageValue = "103"
   )
   static final void method727(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class17.region.method2584(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class17.region.method2605(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class17.region.method2606(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class17.region.method2659(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class17.region.method2727(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1191 = var2;
      var0.field1193 = var3;
      var0.field1195 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1862452562"
   )
   public static int method728(int var0) {
      Varbit var1 = (Varbit)Varbit.field3389.get((long)var0);
      Varbit var2;
      if(var1 != null) {
         var2 = var1;
      } else {
         byte[] var3 = Varbit.field3390.getConfigData(14, var0);
         var1 = new Varbit();
         if(var3 != null) {
            var1.method4296(new Buffer(var3));
         }

         Varbit.field3389.put(var1, (long)var0);
         var2 = var1;
      }

      int var7 = var2.configId;
      int var4 = var2.leastSignificantBit;
      int var5 = var2.mostSignificantBit;
      int var6 = class211.field2614[var5 - var4];
      return class211.widgetSettings[var7] >> var4 & var6;
   }

   static {
      keyboard = new class50();
      field660 = new boolean[112];
      field634 = new int[128];
      field652 = 0;
      field653 = 0;
      field654 = new char[128];
      field655 = new int[128];
      field656 = new int[128];
      field657 = 0;
      field658 = 0;
      field659 = 0;
      field665 = 0;
      keyboardIdleTicks = 0;
      field662 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }
}
