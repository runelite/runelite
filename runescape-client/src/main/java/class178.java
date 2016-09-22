import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class178 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1219498321
   )
   public final int field2959;
   @ObfuscatedName("v")
   public final int[] field2960;
   @ObfuscatedName("r")
   public final int[] field2961;
   @ObfuscatedName("t")
   static class170 field2962;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2008433047
   )
   public final int field2964;

   class178(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2959 = var1;
      this.field2964 = var2;
      this.field2960 = var3;
      this.field2961 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "101"
   )
   public boolean method3499(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2961.length) {
         int var3 = this.field2961[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2960[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-5148358"
   )
   static final int method3500(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var1 / 32 << 7) + (var0 / 4 << 10);
      return var3;
   }
}
