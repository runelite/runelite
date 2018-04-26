import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("fq")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -422749901
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -412219883
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 668166133
   )
   @Export("health")
   int health;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 309980405
   )
   @Export("int2")
   int int2;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "25"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Lbx;II[I[II)V",
      garbageValue = "-1779536167"
   )
   static void method1724(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1727()?1:0;
                     var12 = var8.method1727()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1727()?1:0;
                     var12 = var8.method1727()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method1724(var0, var1, var6, var3, var4);
         method1724(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ILio;ZB)V",
      garbageValue = "37"
   )
   static void method1722(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class71.method1202().getWorldMapDataByFileId(var0);
      int var4 = class265.localPlayer.field831;
      int var5 = (class265.localPlayer.x >> 7) + ClientPacket.baseX;
      int var6 = (class265.localPlayer.y >> 7) + MapIconReference.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class71.method1202().method6103(var3, var7, var1, var2);
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-34"
   )
   static boolean method1725() {
      return (Client.playerNameMask & 1) != 0;
   }
}
