import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class217 extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 38274331
   )
   public final int field2683;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 293754701
   )
   public final int field2680;
   @ObfuscatedName("i")
   public final int[] field2682;
   @ObfuscatedName("j")
   public final int[] field2681;

   class217(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2683 = var1;
      this.field2680 = var2;
      this.field2682 = var3;
      this.field2681 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "399981235"
   )
   public boolean method4081(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2681.length) {
         int var3 = this.field2681[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2682[var2]) {
            return true;
         }
      }

      return false;
   }
}
