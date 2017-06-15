import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class35 {
   @ObfuscatedName("w")
   static ModIcon[] field503;
   @ObfuscatedName("m")
   static final class35 field504;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1642752991
   )
   final int field505;
   @ObfuscatedName("p")
   static final class35 field512;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "308488042"
   )
   public static int method480(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class35(int var1) {
      this.field505 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2088805487"
   )
   public static void method481(int var0) {
      class59.mouseIdleTicks = var0;
   }

   static {
      field512 = new class35(0);
      field504 = new class35(1);
   }
}
