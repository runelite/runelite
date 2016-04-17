import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class154 implements class112 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1786124435
   )
   final int field2279;
   @ObfuscatedName("r")
   public final String field2280;
   @ObfuscatedName("d")
   static final class154 field2281 = new class154("game3", "Game 3", 2);
   @ObfuscatedName("c")
   static final class154 field2282 = new class154("game4", "Game 4", 3);
   @ObfuscatedName("y")
   static final class154 field2283 = new class154("game5", "Game 5", 4);
   @ObfuscatedName("w")
   static final class154 field2284 = new class154("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("a")
   static final class154 field2285 = new class154("runescape", "RuneScape", 0);
   @ObfuscatedName("k")
   public static final class154 field2286 = new class154("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 475751141
   )
   static int field2287;

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "34437093"
   )
   static final boolean method3253(class173 var0) {
      if(null == var0.field2871) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2871.length; ++var1) {
            int var2 = class116.method2556(var0, var1);
            int var3 = var0.field2770[var1];
            if(2 == var0.field2871[var1]) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2871[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(4 == var0.field2871[var1]) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   static final void method3254(boolean var0) {
      for(int var1 = 0; var1 < client.field343; ++var1) {
         class34 var2 = client.field546[client.field335[var1]];
         int var3 = (client.field335[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod836() && var0 == var2.field784.field888 && var2.field784.method863()) {
            int var4 = var2.field844 >> 7;
            int var5 = var2.field819 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(1 == var2.field841 && 64 == (var2.field844 & 127) && 64 == (var2.field819 & 127)) {
                  if(client.field398[var4][var5] == client.field399) {
                     continue;
                  }

                  client.field398[var4][var5] = client.field399;
               }

               if(!var2.field784.field898) {
                  var3 -= Integer.MIN_VALUE;
               }

               class30.field717.method2019(class42.field1002, var2.field844, var2.field819, class34.method816(var2.field844 + (var2.field841 * 64 - 64), var2.field819 + (var2.field841 * 64 - 64), class42.field1002), var2.field841 * 64 - 64 + 60, var2, var2.field863, var3, var2.field820);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1405875737"
   )
   public int vmethod3266() {
      return this.field2279;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-754276735"
   )
   static void method3257(int var0, boolean var1, int var2, boolean var3) {
      if(null != class129.field2051) {
         class111.method2530(0, class129.field2051.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "16"
   )
   public static int method3258(CharSequence var0, int var1) {
      return class158.method3265(var0, var1, true);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "2044189869"
   )
   static final void method3259(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class30.field717.method2034(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class30.field717.method2038(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class94.field1610.field1411;
         var11 = 24624 + 4 * var1 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         class40 var13 = class133.method2969(var12);
         if(var13.field952 != -1) {
            class80 var14 = class165.field2655[var13.field952];
            if(null != var14) {
               int var15 = (var13.field938 * 4 - var14.field1419) / 2;
               int var16 = (var13.field939 * 4 - var14.field1420) / 2;
               var14.method1962(48 + 4 * var1 + var15, 48 + 4 * (104 - var2 - var13.field939) + var16);
            }
         } else {
            if(0 == var8 || var8 == 2) {
               if(0 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(1 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(3 == var7) {
                  var10[1536 + var11] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(3 == var8) {
               if(0 == var7) {
                  var10[var11] = var9;
               } else if(1 == var7) {
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(3 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(0 == var7) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[1536 + 3 + var11] = var9;
               } else if(2 == var7) {
                  var10[1536 + var11] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }
         }
      }

      var5 = class30.field717.method2036(var0, var1, var2);
      if(var5 != 0) {
         var6 = class30.field717.method2038(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var19 = class133.method2969(var9);
         int var23;
         if(var19.field952 != -1) {
            class80 var21 = class165.field2655[var19.field952];
            if(var21 != null) {
               var12 = (var19.field938 * 4 - var21.field1419) / 2;
               var23 = (var19.field939 * 4 - var21.field1420) / 2;
               var21.method1962(var12 + 48 + var1 * 4, var23 + 48 + 4 * (104 - var2 - var19.field939));
            }
         } else if(9 == var8) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class94.field1610.field1411;
            var23 = 4 * var1 + 24624 + 2048 * (103 - var2);
            if(var7 != 0 && 2 != var7) {
               var22[var23] = var11;
               var22[1 + var23 + 512] = var11;
               var22[var23 + 1024 + 2] = var11;
               var22[3 + var23 + 1536] = var11;
            } else {
               var22[var23 + 1536] = var11;
               var22[var23 + 1024 + 1] = var11;
               var22[var23 + 512 + 2] = var11;
               var22[var23 + 3] = var11;
            }
         }
      }

      var5 = class30.field717.method2037(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class40 var17 = class133.method2969(var6);
         if(var17.field952 != -1) {
            class80 var18 = class165.field2655[var17.field952];
            if(null != var18) {
               var9 = (var17.field938 * 4 - var18.field1419) / 2;
               int var20 = (var17.field939 * 4 - var18.field1420) / 2;
               var18.method1962(var9 + 48 + 4 * var1, (104 - var2 - var17.field939) * 4 + 48 + var20);
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class154(String var1, String var2, int var3) {
      this.field2280 = var1;
      this.field2279 = var3;
   }
}
