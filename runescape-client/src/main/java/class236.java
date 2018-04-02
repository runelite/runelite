import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public class class236 extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   public static Font field2767;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -800911011
   )
   public final int field2765;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2098725367
   )
   public final int field2763;
   @ObfuscatedName("o")
   public final int[] field2768;
   @ObfuscatedName("j")
   public final int[] field2766;

   class236(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2765 = var1;
      this.field2763 = var2;
      this.field2768 = var3;
      this.field2766 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-411649183"
   )
   public boolean method4374(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2766.length) {
         int var3 = this.field2766[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2768[var2]) {
            return true;
         }
      }

      return false;
   }
}
