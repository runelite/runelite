import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fs")
public class class175 extends class204 {
   @ObfuscatedName("p")
   public final int[] field2909;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -500781995
   )
   public final int field2911;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -399827109
   )
   public final int field2912;
   @ObfuscatedName("t")
   public final int[] field2914;

   @ObfuscatedName("w")
   public boolean method3475(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2909.length) {
         int var3 = this.field2909[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2914[var2]) {
            return true;
         }
      }

      return false;
   }

   class175(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2911 = var1;
      this.field2912 = var2;
      this.field2914 = var3;
      this.field2909 = var4;
   }
}
