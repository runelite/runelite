import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class20 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1409530889
   )
   public static int field335;
   @ObfuscatedName("fg")
   @Export("mapRegions")
   static int[] mapRegions;

   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "36"
   )
   static final void method163() {
      for(int var0 = 0; var0 < class93.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class93.playerIndices[var0]];
         var1.method1212();
      }

   }
}
