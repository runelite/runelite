import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class181 {
   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(Lbc;ZI)V",
      garbageValue = "-1658719256"
   )
   static void method3381(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field809 << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class92.playerIndexesCount > 50 || class92.playerIndexesCount > 200) && var1 && var0.poseAnimation == var0.idlePoseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field799 = GameCanvas.getTileHeight(var0.x, var0.y, MessageNode.plane);
               class48.region.method2900(MessageNode.plane, var0.x, var0.y, var0.field799, 60, var0, var0.angle, var2, var0.field801, var0.field804, var0.field803, var0.field816);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field909[var3][var4] == Client.field821) {
                     return;
                  }

                  Client.field909[var3][var4] = Client.field821;
               }

               var0.field799 = GameCanvas.getTileHeight(var0.x, var0.y, MessageNode.plane);
               class48.region.method2822(MessageNode.plane, var0.x, var0.y, var0.field799, 60, var0, var0.angle, var2, var0.field1132);
            }
         }
      }

   }
}
