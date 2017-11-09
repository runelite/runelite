import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class171 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "54"
   )
   public static final void method3203() {
      class133.field1917 = false;
      class133.field1921 = 0;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(Lbq;ZI)V",
      garbageValue = "706950147"
   )
   static void method3210(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field853 << 14;
         var0.field849 = false;
         if((Client.lowMemory && class94.playerIndexesCount > 50 || class94.playerIndexesCount > 200) && var1 && var0.idlePoseAnimation == var0.poseAnimation) {
            var0.field849 = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.field839 && Client.gameCycle < var0.field840) {
               var0.field849 = false;
               var0.field831 = class70.getTileHeight(var0.x, var0.y, Ignore.plane);
               class56.region.method2793(Ignore.plane, var0.x, var0.y, var0.field831, 60, var0, var0.angle, var2, var0.field845, var0.field836, var0.field847, var0.field848);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field1049[var3][var4] == Client.field953) {
                     return;
                  }

                  Client.field1049[var3][var4] = Client.field953;
               }

               var0.field831 = class70.getTileHeight(var0.x, var0.y, Ignore.plane);
               class56.region.method2920(Ignore.plane, var0.x, var0.y, var0.field831, 60, var0, var0.angle, var2, var0.field1146);
            }
         }
      }

   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-97"
   )
   static void method3208() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.field995[var3] = Client.field995[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
