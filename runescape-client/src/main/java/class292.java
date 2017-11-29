import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
public enum class292 implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   field3822(0, 0),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   field3819(1, 1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   field3820(2, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   field3818(3, 3),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   field3823(4, 4);

   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -86754067
   )
   public final int field3824;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1355885891
   )
   final int field3821;

   class292(int var3, int var4) {
      this.field3824 = var3;
      this.field3821 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.field3821;
   }
}
