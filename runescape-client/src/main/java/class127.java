import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class127 {
   @ObfuscatedName("bi")
   static class168 field2058;
   @ObfuscatedName("bu")
   @Export("host")
   static String field2059;
   @ObfuscatedName("dp")
   static byte[][] field2061;

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-41"
   )
   static final void method2805(int var0) {
      int[] var1 = class74.field1370.field1414;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 2048 * (103 - var3) + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class5.field90[var0][var5][var3] & 24) == 0) {
               client.field339.method1991(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && 0 != (class5.field90[var0 + 1][var5][var3] & 8)) {
               client.field339.method1991(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class74.field1370.method1666();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if(0 == (class5.field90[var0][var6][var5] & 24)) {
               class24.method578(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class5.field90[1 + var0][var6][var5] & 8) != 0) {
               class24.method578(1 + var0, var6, var5, var3, var4);
            }
         }
      }

      client.field508 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = client.field339.method1924(class21.field581, var5, var6);
            if(0 != var7) {
               var7 = var7 >> 14 & 32767;
               int var8 = class9.method120(var7).field952;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(22 != var8 && var8 != 29 && 34 != var8 && var8 != 36 && 46 != var8 && 47 != var8 && 48 != var8) {
                     int[][] var11 = client.field340[class21.field581].field1911;

                     for(int var12 = 0; var12 < 10; ++var12) {
                        int var13 = (int)(Math.random() * 4.0D);
                        if(0 == var13 && var9 > 0 && var9 > var5 - 3 && 0 == (var11[var9 - 1][var10] & 19136776)) {
                           --var9;
                        }

                        if(var13 == 1 && var9 < 103 && var9 < 3 + var5 && (var11[1 + var9][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(2 == var13 && var10 > 0 && var10 > var6 - 3 && 0 == (var11[var9][var10 - 1] & 19136770)) {
                           --var10;
                        }

                        if(3 == var13 && var10 < 103 && var10 < var6 + 3 && 0 == (var11[var9][1 + var10] & 19136800)) {
                           ++var10;
                        }
                     }
                  }

                  client.field511[client.field508] = class176.field2921[var8];
                  client.field509[client.field508] = var9;
                  client.field522[client.field508] = var10;
                  ++client.field508;
               }
            }
         }
      }

      class135.field2094.method1646();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[Lclass190;",
      garbageValue = "-39"
   )
   public static class190[] method2808() {
      return new class190[]{class190.field3076, class190.field3071, class190.field3074, class190.field3080, class190.field3065, class190.field3070, class190.field3068, class190.field3066, class190.field3072, class190.field3067, class190.field3079, class190.field3075, class190.field3073, class190.field3069, class190.field3078};
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)Z",
      garbageValue = "1"
   )
   static final boolean method2809(class173 var0) {
      if(null == var0.field2878) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2878.length; ++var1) {
            int var2 = class121.method2733(var0, var1);
            int var3 = var0.field2879[var1];
            if(var0.field2878[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2878[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(4 == var0.field2878[var1]) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
