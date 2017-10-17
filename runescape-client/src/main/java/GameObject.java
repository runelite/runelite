import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("rj")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1094402199
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1323863499
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1764823617
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1368551095
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 411947517
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1299454667
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -577031491
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -152636925
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 493563687
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1164147829
   )
   @Export("height")
   int height;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1691976901
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1400343359
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -905884947
   )
   @Export("drawPriority")
   int drawPriority;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "395429518"
   )
   static final void method2968(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4730()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1211 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1015[var4][var5] == Client.field1016) {
                     continue;
                  }

                  Client.field1015[var4][var5] = Client.field1016;
               }

               if(!var2.composition.field3586) {
                  var3 -= Integer.MIN_VALUE;
               }

               class8.region.method2768(class5.plane, var2.x, var2.y, CacheFile.getTileHeight(var2.field1211 * 64 - 64 + var2.x, var2.field1211 * 64 - 64 + var2.y, class5.plane), 60 + (var2.field1211 * 64 - 64), var2, var2.angle, var3, var2.field1210);
            }
         }
      }

   }
}
