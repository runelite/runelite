import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class152 extends class297 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   @Export("NetCache_reference")
   public static Buffer NetCache_reference;
   @ObfuscatedName("t")
   final boolean field2104;

   public class152(boolean var1) {
      this.field2104 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)I",
      garbageValue = "-436814831"
   )
   int method3126(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2104?var1.field3842 - var2.field3842:var2.field3842 - var1.field3842):this.method5273(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3126((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILfv;Lfa;Z[I[II)I",
      garbageValue = "265371293"
   )
   public static int method3132(int var0, int var1, int var2, class178 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class177.field2249[var8][var9] = 0;
            class177.field2250[var8][var9] = 99999999;
         }
      }

      boolean var27;
      if(var2 == 1) {
         var27 = class154.method3150(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var27 = Item.method1972(var0, var1, var3, var4);
      } else {
         var27 = class71.method1198(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      int var10 = var1 - 64;
      int var11 = UnitPriceComparator.field297;
      int var12 = TotalQuantityComparator.field282;
      int var13;
      int var14;
      int var16;
      if(!var27) {
         var13 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var15 = 10;
         var16 = var3.field2254;
         int var17 = var3.field2255;
         int var18 = var3.field2257;
         int var19 = var3.field2256;

         for(int var20 = var16 - var15; var20 <= var15 + var16; ++var20) {
            for(int var21 = var17 - var15; var21 <= var17 + var15; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class177.field2250[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var16) {
                     var24 = var16 - var20;
                  } else if(var20 > var18 + var16 - 1) {
                     var24 = var20 - (var16 + var18 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var13 || var13 == var26 && class177.field2250[var22][var23] < var14) {
                     var13 = var26;
                     var14 = class177.field2250[var22][var23];
                     var11 = var20;
                     var12 = var21;
                  }
               }
            }
         }

         if(var13 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var12 == var1) {
         return 0;
      } else {
         byte var28 = 0;
         class177.field2251[var28] = var11;
         var13 = var28 + 1;
         class177.field2253[var28] = var12;

         int var29;
         for(var14 = var29 = class177.field2249[var11 - var9][var12 - var10]; var0 != var11 || var12 != var1; var14 = class177.field2249[var11 - var9][var12 - var10]) {
            if(var29 != var14) {
               var29 = var14;
               class177.field2251[var13] = var11;
               class177.field2253[var13++] = var12;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var12;
            } else if((var14 & 4) != 0) {
               --var12;
            }
         }

         var16 = 0;

         while(var13-- > 0) {
            var6[var16] = class177.field2251[var13];
            var7[var16++] = class177.field2253[var13];
            if(var16 >= var6.length) {
               break;
            }
         }

         return var16;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "83"
   )
   static String method3127(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class317.field3928[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class317.field3928[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class317.field3928[(var6 & 15) << 2 | var7 >>> 6]).append(class317.field3928[var7 & 63]);
            } else {
               var3.append(class317.field3928[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class317.field3928[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}
