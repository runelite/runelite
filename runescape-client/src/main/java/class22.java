import java.awt.Component;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class22 extends class204 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 288404505
   )
   int field591;
   @ObfuscatedName("u")
   int[] field592;
   @ObfuscatedName("x")
   int[] field593;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 2014404721
   )
   static int field594;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1737305063
   )
   int field596;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -564138935
   )
   int field597;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -439456037
   )
   int field598;
   @ObfuscatedName("f")
   static class193 field600 = new class193(128);
   @ObfuscatedName("b")
   String[] field601;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "1"
   )
   public static boolean method617(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1989575705"
   )
   public static void method621(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class137.field2118);
      var0.addFocusListener(class137.field2118);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "515062047"
   )
   static void method622(class122 var0, int var1) {
      boolean var2 = var0.method2776(1) == 1;
      if(var2) {
         class32.field768[++class32.field765 - 1] = var1;
      }

      int var3 = var0.method2776(2);
      class2 var4 = client.field302[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field58 = false;
         } else if(client.field411 == var1) {
            throw new RuntimeException();
         } else {
            class32.field762[var1] = (var4.field876[0] + class20.field576 >> 6) + (var4.field35 << 28) + (class172.field2734 + var4.field875[0] >> 6 << 14);
            if(var4.field848 != -1) {
               class32.field763[var1] = var4.field848;
            } else {
               class32.field763[var1] = var4.field871;
            }

            class32.field764[var1] = var4.field846;
            client.field302[var1] = null;
            if(var0.method2776(1) != 0) {
               class121.method2766(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2776(3);
            var6 = var4.field875[0];
            var7 = var4.field876[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 == client.field411 && (var4.field837 < 1536 || var4.field880 < 1536 || var4.field837 >= 11776 || var4.field880 >= 11776)) {
               var4.method33(var6, var7);
               var4.field58 = false;
            } else if(var2) {
               var4.field58 = true;
               var4.field59 = var6;
               var4.field55 = var7;
            } else {
               var4.field58 = false;
               var4.method18(var6, var7, class32.field767[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2776(4);
            var6 = var4.field875[0];
            var7 = var4.field876[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == client.field411 && (var4.field837 < 1536 || var4.field880 < 1536 || var4.field837 >= 11776 || var4.field880 >= 11776)) {
               var4.method33(var6, var7);
               var4.field58 = false;
            } else if(var2) {
               var4.field58 = true;
               var4.field59 = var6;
               var4.field55 = var7;
            } else {
               var4.field58 = false;
               var4.method18(var6, var7, class32.field767[var1]);
            }

         } else {
            var5 = var0.method2776(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2776(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.field875[0] + var8;
               var11 = var4.field876[0] + var9;
               if(var1 != client.field411 || var4.field837 >= 1536 && var4.field880 >= 1536 && var4.field837 < 11776 && var4.field880 < 11776) {
                  if(var2) {
                     var4.field58 = true;
                     var4.field59 = var10;
                     var4.field55 = var11;
                  } else {
                     var4.field58 = false;
                     var4.method18(var10, var11, class32.field767[var1]);
                  }
               } else {
                  var4.method33(var10, var11);
                  var4.field58 = false;
               }

               var4.field35 = (byte)(var7 + var4.field35 & 3);
               if(var1 == client.field411) {
                  class14.field212 = var4.field35;
               }

            } else {
               var6 = var0.method2776(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.field875[0] + class172.field2734 & 16383) - class172.field2734;
               var11 = (var4.field876[0] + class20.field576 + var9 & 16383) - class20.field576;
               if(var1 == client.field411 && (var4.field837 < 1536 || var4.field880 < 1536 || var4.field837 >= 11776 || var4.field880 >= 11776)) {
                  var4.method33(var10, var11);
                  var4.field58 = false;
               } else if(var2) {
                  var4.field58 = true;
                  var4.field59 = var10;
                  var4.field55 = var11;
               } else {
                  var4.field58 = false;
                  var4.method18(var10, var11, class32.field767[var1]);
               }

               var4.field35 = (byte)(var4.field35 + var7 & 3);
               if(client.field411 == var1) {
                  class14.field212 = var4.field35;
               }

            }
         }
      }
   }
}
