import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class210 extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -795874025
   )
   public final int field2602;
   @ObfuscatedName("t")
   public final int[] field2604;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 986821743
   )
   public final int field2607;
   @ObfuscatedName("a")
   public final int[] field2608;
   @ObfuscatedName("j")
   public static byte[][] field2609;

   class210(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2607 = var1;
      this.field2602 = var2;
      this.field2608 = var3;
      this.field2604 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean method3898(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2604.length) {
         int var3 = this.field2604[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2608[var2]) {
            return true;
         }
      }

      return false;
   }
}
