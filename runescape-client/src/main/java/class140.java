import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public final class class140 implements KeyListener, FocusListener {
   @ObfuscatedName("co")
   public static boolean[] field2153 = new boolean[112];
   @ObfuscatedName("ct")
   public static int[] field2158 = new int[128];
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -84614505
   )
   public static int field2161;
   @ObfuscatedName("cq")
   static char[] field2162 = new char[128];
   @ObfuscatedName("cj")
   public static char field2163;
   @ObfuscatedName("cr")
   public static int[] field2165 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("az")
   static class149 field2166;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -283338393
   )
   public static int field2167 = 0;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1083869957
   )
   public static int field2168 = 0;
   @ObfuscatedName("ce")
   static int[] field2170 = new int[128];
   @ObfuscatedName("cs")
   public static int[] field2171 = new int[128];
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1269817699
   )
   public static int field2172 = 0;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1810499715
   )
   public static int field2173 = 0;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1099032523
   )
   public static int field2174 = 0;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1133950389
   )
   public static int field2175 = 0;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1099158949
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("f")
   @Export("keyboard")
   public static class140 keyboard = new class140();

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2165.length) {
            var2 = field2165[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2168 >= 0 && var2 >= 0) {
            field2158[field2168] = var2;
            field2168 = field2168 + 1 & 127;
            if(field2168 == field2167) {
               field2168 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = 1 + field2174 & 127;
            if(var3 != field2173) {
               field2170[field2174] = var2;
               field2162[field2174] = 0;
               field2174 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final void keyTyped(KeyEvent var1) {
      if(null != keyboard) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label72: {
                  if(var2 != 0) {
                     char[] var7 = class168.field2698;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label72;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = 1 + field2174 & 127;
               if(field2173 != var4) {
                  field2170[field2174] = -1;
                  field2162[field2174] = var2;
                  field2174 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2165.length) {
            var2 = field2165[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2168 >= 0 && var2 >= 0) {
            field2158[field2168] = ~var2;
            field2168 = field2168 + 1 & 127;
            if(field2167 == field2168) {
               field2168 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != keyboard) {
         field2168 = -1;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1667128018"
   )
   static void method2953(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = VertexNormal.method2231(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = VertexNormal.method2231(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method2953(var0, var7 - 1, var2, var3, var4, var5);
         method2953(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-638893936"
   )
   static File method2954(String var0) {
      if(!class138.field2139) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class138.field2137.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class138.field2136, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class138.field2137.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(null != var3) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }
}
