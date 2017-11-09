import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
public enum class292 implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3826(0, 0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3825(1, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3824(2, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3822(3, 3),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3823(4, 4);

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1762173195
   )
   public final int field3827;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1067402979
   )
   final int field3828;

   class292(int var3, int var4) {
      this.field3827 = var3;
      this.field3828 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field3828;
   }
}
