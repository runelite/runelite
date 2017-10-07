import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class210 extends CacheableNode {
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static BuildType field2614;
   @ObfuscatedName("p")
   public final int[] field2616;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -579015167
   )
   public final int field2615;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1032370085
   )
   public final int field2611;
   @ObfuscatedName("e")
   public final int[] field2613;

   class210(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2615 = var1;
      this.field2611 = var2;
      this.field2613 = var3;
      this.field2616 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-27"
   )
   public boolean method4042(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2616.length) {
         int var3 = this.field2616[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2613[var2]) {
            return true;
         }
      }

      return false;
   }
}
