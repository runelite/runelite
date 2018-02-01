import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public enum class148 implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   field2080(2, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   field2079(1, 1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   field2075(0, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   field2074(3, 3);

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -735753889
   )
   public final int field2077;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 772826137
   )
   final int field2078;

   class148(int var3, int var4) {
      this.field2077 = var3;
      this.field2078 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.field2078;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;Lik;I)V",
      garbageValue = "-1064123271"
   )
   public static void method3040(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class265.field3492 = var0;
      class265.field3469 = var1;
      class265.field3476 = var2;
   }
}
