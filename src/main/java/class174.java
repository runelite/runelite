import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fk")
public class class174 extends class203 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2143868605
   )
   public final int field2883;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1142460413
   )
   public final int field2884;
   @ObfuscatedName("f")
   public final int[] field2885;
   @ObfuscatedName("s")
   public final int[] field2886;
   @ObfuscatedName("rl")
   protected static String field2889;

   @ObfuscatedName("a")
   public boolean method3465(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2886.length) {
         int var3 = this.field2886[var2];
         if(var1 >= var3 && var1 <= this.field2885[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   class174(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2884 = var1;
      this.field2883 = var2;
      this.field2885 = var3;
      this.field2886 = var4;
   }
}
