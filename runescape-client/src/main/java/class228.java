import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public enum class228 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   field3150(3, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   field3153(2, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   field3155(4, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   field3151(7, 3),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   field3152(0, 4),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   field3154(5, 5),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   field3163(6, 6),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   field3157(1, 7);

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 269789679
   )
   final int field3148;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1145751383
   )
   public final int field3156;

   class228(int var3, int var4) {
      this.field3156 = var3;
      this.field3148 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field3148;
   }
}
