import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public enum class27 implements RSEnum {
   @ObfuscatedName("i")
   field396(1, (byte)0),
   @ObfuscatedName("w")
   field405(0, (byte)1),
   @ObfuscatedName("a")
   field395(2, (byte)2),
   @ObfuscatedName("t")
   field398(3, (byte)3);

   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1611886361
   )
   static int field397;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -81664947
   )
   final int field399;
   @ObfuscatedName("r")
   final byte field400;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field400;
   }

   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   class27(int var3, byte var4) {
      this.field399 = var3;
      this.field400 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1766136460"
   )
   public static int method208(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2399[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2067755467"
   )
   public static int method209(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }
}
