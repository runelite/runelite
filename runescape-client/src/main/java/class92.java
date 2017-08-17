import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public enum class92 implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   field1426(0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   field1422(1),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   field1423(2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   field1424(3);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static SpritePixels field1425;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 778254501
   )
   static int field1427;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 581602443
   )
   final int field1431;

   class92(int var3) {
      this.field1431 = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field1431;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1336355027"
   )
   static final int method1731(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
