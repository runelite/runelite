import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public enum class27 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   field393(0, (byte)0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   field392(1, (byte)1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   field394(3, (byte)2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   field396(2, (byte)3);

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1006164869
   )
   @Export("worldMapType")
   final int worldMapType;
   @ObfuscatedName("l")
   final byte field391;

   class27(int worldMapType, byte var4) {
      this.worldMapType = worldMapType;
      this.field391 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.field391;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "413"
   )
   static void method222(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1213[var5] != var0) {
            var2[var4] = World.field1213[var5];
            var3[var4] = World.field1210[var5];
            ++var4;
         }
      }

      World.field1213 = var2;
      World.field1210 = var3;
      CombatInfo1.method1724(class171.worldList, 0, class171.worldList.length - 1, World.field1213, World.field1210);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)[Lai;",
      garbageValue = "-83"
   )
   @Export("getWorldMapTypes")
   static class27[] getWorldMapTypes() {
      return new class27[]{field394, field396, field393, field392};
   }
}
