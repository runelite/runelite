import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class210 extends CacheableNode {
   @ObfuscatedName("q")
   public final int[] field2587;
   @ObfuscatedName("u")
   public final int[] field2589;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 864208735
   )
   public final int field2590;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 673689791
   )
   public final int field2591;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "60"
   )
   public boolean method3980(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2587.length) {
         int var3 = this.field2587[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2589[var2]) {
            return true;
         }
      }

      return false;
   }

   class210(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2591 = var1;
      this.field2590 = var2;
      this.field2589 = var3;
      this.field2587 = var4;
   }
}
