import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class228 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -611187595
   )
   static int field2669;
   @ObfuscatedName("aj")
   static int[] field2670;
   @ObfuscatedName("t")
   byte[] field2671;
   @ObfuscatedName("q")
   byte[] field2661;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 308446449
   )
   int field2662;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -249965263
   )
   int field2667;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1961455951
   )
   int field2664;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 277493449
   )
   int field2666;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1111787581
   )
   int field2660;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 446302239
   )
   int field2665;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 136276765
   )
   int field2663;

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1705878866"
   )
   static final void method4140() {
      int var0 = class93.playerIndexesCount;
      int[] var1 = class93.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            MapCacheArchiveNames.method592(var3, 1);
         }
      }

   }
}
