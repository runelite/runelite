import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class211 extends CacheableNode {
   @ObfuscatedName("x")
   @Export("offsetsY")
   static int[] offsetsY;
   @ObfuscatedName("p")
   public final int[] field2595;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 204054215
   )
   public final int field2599;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1314879773
   )
   public final int field2597;
   @ObfuscatedName("f")
   public final int[] field2596;

   class211(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2599 = var1;
      this.field2597 = var2;
      this.field2596 = var3;
      this.field2595 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1578988055"
   )
   public boolean method3927(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2595.length) {
         int var3 = this.field2595[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2596[var2]) {
            return true;
         }
      }

      return false;
   }
}
