import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public enum class27 implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   field398(2, (byte)0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   field394(3, (byte)1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   field395(1, (byte)2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   field396(0, (byte)3);

   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 259470889
   )
   final int field397;
   @ObfuscatedName("k")
   final byte field399;
   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   static IndexedSprite[] field401;

   class27(int var3, byte var4) {
      this.field397 = var3;
      this.field399 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field399;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)[Lay;",
      garbageValue = "530490508"
   )
   static class27[] method216() {
      return new class27[]{field398, field396, field394, field395};
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   static final void method223() {
      if(GZipDecompressor.rssocket != null) {
         GZipDecompressor.rssocket.close();
         GZipDecompressor.rssocket = null;
      }

      PendingSpawn.method1523();
      class84.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class204.field2487 = 1;
      class204.field2488 = null;
      class12.field273 = -1;
      class204.field2489 = -1;
      class204.field2490 = 0;
      class33.field472 = false;
      class204.field2491 = 2;
      Client.field1140 = -1;
      Client.field1141 = false;
      class23.method170();
      WorldMapType1.setGameState(10);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1161170087"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1772052679"
   )
   public static void method217() {
      Spotanim.spotanims.reset();
      Spotanim.field3318.reset();
   }
}
