import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class175 extends class204 {
   @ObfuscatedName("dd")
   static int[] field2897;
   @ObfuscatedName("b")
   public final int[] field2898;
   @ObfuscatedName("x")
   public final int[] field2899;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2079172787
   )
   public final int field2900;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -465395487
   )
   public final int field2901;

   class175(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2900 = var1;
      this.field2901 = var2;
      this.field2899 = var3;
      this.field2898 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-92"
   )
   public boolean method3475(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2898.length) {
         int var3 = this.field2898[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2899[var2]) {
            return true;
         }
      }

      return false;
   }
}
