import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
public enum class284 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   field3781(0, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   field3779(1, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   field3784(2, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   field3782(3, 3),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   field3783(4, 4);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 512474135
   )
   final int field3780;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -253866649
   )
   public final int field3785;

   class284(int var3, int var4) {
      this.field3785 = var3;
      this.field3780 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field3780;
   }
}
