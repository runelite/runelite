import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   static class169 field1912;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2092631753
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 835090627
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1316724119
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -217463821
   )
   @Export("z")
   int z;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lex;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(Lbd;ZI)V",
      garbageValue = "1952442073"
   )
   static void method2844(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field845 << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class93.playerIndexesCount > 50 || class93.playerIndexesCount > 200) && var1 && var0.idlePoseAnimation == var0.poseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field839 = class35.getTileHeight(var0.x, var0.y, class36.plane);
               var0.field1143 = Client.gameCycle;
               class86.region.method2961(class36.plane, var0.x, var0.y, var0.field839, 60, var0, var0.angle, var2, var0.field832, var0.field838, var0.field846, var0.field834);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field947[var3][var4] == Client.field1108) {
                     return;
                  }

                  Client.field947[var3][var4] = Client.field1108;
               }

               var0.field839 = class35.getTileHeight(var0.x, var0.y, class36.plane);
               var0.field1143 = Client.gameCycle;
               class86.region.method3026(class36.plane, var0.x, var0.y, var0.field839, 60, var0, var0.angle, var2, var0.field1141);
            }
         }
      }

   }
}
