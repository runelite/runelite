import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class230 {
   @ObfuscatedName("fj")
   @Export("landMapFileIds")
   static int[] landMapFileIds;

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1443719524"
   )
   static void method4226() {
      int var0 = class94.playerIndexesCount;
      int[] var1 = class94.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         if(var1[var2] != Client.field1094 && var1[var2] != Client.localInteractingIndex) {
            class3.method7(Client.cachedPlayers[var1[var2]], true);
         }
      }

   }
}
