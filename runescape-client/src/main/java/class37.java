import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class37 {
   @ObfuscatedName("bp")
   static class184 field820;

   class37() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "2"
   )
   public static int method808(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2086[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1222486107"
   )
   static int method809(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class32.field756[++class32.field752 - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         int[] var5;
         int var6;
         int var7;
         XItemContainer var8;
         if(var0 == 3301) {
            class32.field752 -= 2;
            var3 = class32.field756[class32.field752];
            var4 = class32.field756[class32.field752 + 1];
            var5 = class32.field756;
            var6 = ++class32.field752 - 1;
            var8 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var3);
            if(var8 == null) {
               var7 = -1;
            } else if(var4 >= 0 && var4 < var8.itemIds.length) {
               var7 = var8.itemIds[var4];
            } else {
               var7 = -1;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3302) {
            class32.field752 -= 2;
            var3 = class32.field756[class32.field752];
            var4 = class32.field756[class32.field752 + 1];
            var5 = class32.field756;
            var6 = ++class32.field752 - 1;
            var8 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var3);
            if(null == var8) {
               var7 = 0;
            } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
               var7 = var8.stackSizes[var4];
            } else {
               var7 = 0;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3303) {
            class32.field752 -= 2;
            var3 = class32.field756[class32.field752];
            var4 = class32.field756[class32.field752 + 1];
            class32.field756[++class32.field752 - 1] = class1.method18(var3, var4);
            return 1;
         } else if(var0 == 3304) {
            var3 = class32.field756[--class32.field752];
            class32.field756[++class32.field752 - 1] = class152.method2812(var3).field2761;
            return 1;
         } else if(var0 == 3305) {
            var3 = class32.field756[--class32.field752];
            class32.field756[++class32.field752 - 1] = Client.boostedSkillLevels[var3];
            return 1;
         } else if(var0 == 3306) {
            var3 = class32.field756[--class32.field752];
            class32.field756[++class32.field752 - 1] = Client.realSkillLevels[var3];
            return 1;
         } else if(var0 == 3307) {
            var3 = class32.field756[--class32.field752];
            class32.field756[++class32.field752 - 1] = Client.skillExperiences[var3];
            return 1;
         } else if(var0 == 3308) {
            var3 = class31.plane;
            var4 = (class22.localPlayer.x >> 7) + CombatInfoListHolder.baseX;
            int var9 = (class22.localPlayer.y >> 7) + class3.baseY;
            class32.field756[++class32.field752 - 1] = (var3 << 28) + (var4 << 14) + var9;
            return 1;
         } else if(var0 == 3309) {
            var3 = class32.field756[--class32.field752];
            class32.field756[++class32.field752 - 1] = var3 >> 14 & 16383;
            return 1;
         } else if(var0 == 3310) {
            var3 = class32.field756[--class32.field752];
            class32.field756[++class32.field752 - 1] = var3 >> 28;
            return 1;
         } else if(var0 == 3311) {
            var3 = class32.field756[--class32.field752];
            class32.field756[++class32.field752 - 1] = var3 & 16383;
            return 1;
         } else if(var0 == 3312) {
            class32.field756[++class32.field752 - 1] = Client.isMembers?1:0;
            return 1;
         } else if(var0 == 3313) {
            class32.field752 -= 2;
            var3 = '耀' + class32.field756[class32.field752];
            var4 = class32.field756[class32.field752 + 1];
            var5 = class32.field756;
            var6 = ++class32.field752 - 1;
            var8 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var3);
            if(null == var8) {
               var7 = -1;
            } else if(var4 >= 0 && var4 < var8.itemIds.length) {
               var7 = var8.itemIds[var4];
            } else {
               var7 = -1;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 != 3314) {
            if(var0 == 3315) {
               class32.field752 -= 2;
               var3 = class32.field756[class32.field752] + '耀';
               var4 = class32.field756[1 + class32.field752];
               class32.field756[++class32.field752 - 1] = class1.method18(var3, var4);
               return 1;
            } else if(var0 == 3316) {
               if(Client.field480 >= 2) {
                  class32.field756[++class32.field752 - 1] = Client.field480;
               } else {
                  class32.field756[++class32.field752 - 1] = 0;
               }

               return 1;
            } else if(var0 == 3317) {
               class32.field756[++class32.field752 - 1] = Client.field327;
               return 1;
            } else if(var0 == 3318) {
               class32.field756[++class32.field752 - 1] = Client.world;
               return 1;
            } else if(var0 == 3321) {
               class32.field756[++class32.field752 - 1] = Client.energy;
               return 1;
            } else if(var0 == 3322) {
               class32.field756[++class32.field752 - 1] = Client.weight;
               return 1;
            } else if(var0 == 3323) {
               if(Client.field482) {
                  class32.field756[++class32.field752 - 1] = 1;
               } else {
                  class32.field756[++class32.field752 - 1] = 0;
               }

               return 1;
            } else if(var0 == 3324) {
               class32.field756[++class32.field752 - 1] = Client.flags;
               return 1;
            } else {
               return 2;
            }
         } else {
            class32.field752 -= 2;
            var3 = '耀' + class32.field756[class32.field752];
            var4 = class32.field756[class32.field752 + 1];
            var5 = class32.field756;
            var6 = ++class32.field752 - 1;
            var8 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var3);
            if(null == var8) {
               var7 = 0;
            } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
               var7 = var8.stackSizes[var4];
            } else {
               var7 = 0;
            }

            var5[var6] = var7;
            return 1;
         }
      }
   }
}
