import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class178 extends CacheableNode {
   @ObfuscatedName("b")
   static class170 field2951;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2041228117
   )
   public final int field2952;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1722493241
   )
   public final int field2953;
   @ObfuscatedName("z")
   public final int[] field2954;
   @ObfuscatedName("j")
   public final int[] field2956;

   class178(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2953 = var1;
      this.field2952 = var2;
      this.field2956 = var3;
      this.field2954 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1905207165"
   )
   public boolean method3473(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2954.length) {
         int var3 = this.field2954[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2956[var2]) {
            return true;
         }
      }

      return false;
   }
}
