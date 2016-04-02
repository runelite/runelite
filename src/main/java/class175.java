import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fn")
public class class175 extends class204 {
   @ObfuscatedName("f")
   public final int[] field2896;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -975986503
   )
   public final int field2897;
   @ObfuscatedName("s")
   public final int[] field2898;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 36079183
   )
   public final int field2899;

   @ObfuscatedName("e")
   public boolean method3426(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2898.length) {
         int var3 = this.field2898[var2];
         if(var1 >= var3 && var1 <= this.field2896[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   class175(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2899 = var1;
      this.field2897 = var2;
      this.field2896 = var3;
      this.field2898 = var4;
   }
}
