import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public enum class149 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   field2177(0, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   field2176(3, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   field2174(2, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   field2175(1, 3);

   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1915150849
   )
   public final int field2172;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1181260843
   )
   final int field2173;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   static IndexedSprite field2178;

   class149(int var3, int var4) {
      this.field2172 = var3;
      this.field2173 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field2173;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "122"
   )
   public static boolean method2924(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "145922732"
   )
   static final void method2927() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class152.method2949(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "911649273"
   )
   public static boolean method2928(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
