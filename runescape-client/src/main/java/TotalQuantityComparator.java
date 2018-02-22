import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("p")
   static int[] field281;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;B)I",
      garbageValue = "97"
   )
   int method96(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method96((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "224651472"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = WorldMapType1.getSmoothNoise2D(var3, var5);
      int var8 = WorldMapType1.getSmoothNoise2D(var3 + 1, var5);
      int var9 = WorldMapType1.getSmoothNoise2D(var3, var5 + 1);
      int var10 = WorldMapType1.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(Lbl;ZI)V",
      garbageValue = "1886708767"
   )
   static void method99(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field808 << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class92.playerIndexesCount > 50 || class92.playerIndexesCount > 200) && var1 && var0.idlePoseAnimation == var0.poseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field797 = WorldMapType1.getTileHeight(var0.x, var0.y, class230.plane);
               GameObject.region.method2895(class230.plane, var0.x, var0.y, var0.field797, 60, var0, var0.angle, var2, var0.field781, var0.field796, var0.field784, var0.field795);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field1057[var3][var4] == Client.field868) {
                     return;
                  }

                  Client.field1057[var3][var4] = Client.field868;
               }

               var0.field797 = WorldMapType1.getTileHeight(var0.x, var0.y, class230.plane);
               GameObject.region.method2930(class230.plane, var0.x, var0.y, var0.field797, 60, var0, var0.angle, var2, var0.field1097);
            }
         }
      }

   }
}
