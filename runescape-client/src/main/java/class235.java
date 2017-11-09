import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public enum class235 implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3217(0, 0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3219(2, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3225(5, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3220(3, 3),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3221(4, 4),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3222(1, 5),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3223(6, 6),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3224(7, 7);

   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 299799901
   )
   public final int field3226;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1746580055
   )
   final int field3218;

   class235(int var3, int var4) {
      this.field3226 = var3;
      this.field3218 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field3218;
   }
}
