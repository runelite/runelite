import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public enum class228 implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2877(0, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2873(1, 0),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2874(2, 0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2875(3, 0),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2872(9, 2),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2890(4, 1),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2893(5, 1),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2879(6, 1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2880(7, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2889(8, 1),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2882(12, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2883(13, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2884(14, 2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2885(15, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2886(16, 2),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2887(17, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2878(18, 2),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2895(19, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2881(20, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2891(21, 2),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2892(10, 2),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2876(11, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2894(22, 3);

   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 225085181
   )
   public final int field2888;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class228(int var3, int var4) {
      this.field2888 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field2888;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgd;I)I",
      garbageValue = "-387428626"
   )
   static int method4085(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }
}
