import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class164 extends CacheableNode {
   @ObfuscatedName("d")
   public final int[] field2141;
   @ObfuscatedName("c")
   public final int[] field2142;
   @ObfuscatedName("u")
   public static short[] field2145;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2082644997
   )
   public final int field2146;
   @ObfuscatedName("v")
   public static boolean field2147;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1331790569
   )
   public final int field2150;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "61"
   )
   public boolean method3155(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2141.length) {
         int var3 = this.field2141[var2];
         if(var1 >= var3 && var1 <= this.field2142[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "27"
   )
   public static int method3157(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "26"
   )
   public static boolean method3158(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2146 = var1;
      this.field2150 = var2;
      this.field2142 = var3;
      this.field2141 = var4;
   }
}
