import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public enum class283 implements RSEnum {
   @ObfuscatedName("i")
   field3772(0, 0),
   @ObfuscatedName("w")
   field3771(1, 1),
   @ObfuscatedName("a")
   field3769(2, 2),
   @ObfuscatedName("t")
   field3770(3, 3),
   @ObfuscatedName("s")
   field3768(4, 4);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -603295367
   )
   public final int field3767;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -486260483
   )
   final int field3773;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field3773;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class283(int var3, int var4) {
      this.field3767 = var3;
      this.field3773 = var4;
   }
}
