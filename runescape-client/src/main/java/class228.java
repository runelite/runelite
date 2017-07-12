import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public enum class228 implements RSEnum {
   @ObfuscatedName("i")
   field3165(4, 0),
   @ObfuscatedName("w")
   field3157(7, 1),
   @ObfuscatedName("a")
   field3158(6, 2),
   @ObfuscatedName("t")
   field3162(1, 3),
   @ObfuscatedName("s")
   field3160(3, 4),
   @ObfuscatedName("r")
   field3161(5, 5),
   @ObfuscatedName("v")
   field3164(2, 6),
   @ObfuscatedName("y")
   field3163(0, 7);

   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1654934513
   )
   final int field3156;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 493489157
   )
   public final int field3167;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-37"
   )
   static int method4084(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class7.currentRequest != null && class7.currentRequest.hash == var2?class39.field559.offset * 99 / (class39.field559.payload.length - class7.currentRequest.padding) + 1:0;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   private class228(int var3, int var4) {
      this.field3167 = var3;
      this.field3156 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field3156;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-721249226"
   )
   public static void method4093() {
      Spotanim.spotanims.reset();
      Spotanim.field3333.reset();
   }
}
