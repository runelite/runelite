import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public enum class254 implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3316(5, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3312(1, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3313(4, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3314(6, 3),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3315(3, 4),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3311(0, 5),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3320(7, 6),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3318(2, 7);

   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 581631521
   )
   public final int field3319;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 394086745
   )
   final int field3317;

   class254(int var3, int var4) {
      this.field3319 = var3;
      this.field3317 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.field3317;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "2114948306"
   )
   public static final void method4525(int var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox2D(var0, var1, var2, var3, var4));
   }
}
