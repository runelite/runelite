import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class236 extends CacheableNode {
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1929998547
   )
   public final int field2766;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -309301115
   )
   public final int field2767;
   @ObfuscatedName("i")
   public final int[] field2764;
   @ObfuscatedName("a")
   public final int[] field2765;

   class236(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2766 = var1;
      this.field2767 = var2;
      this.field2764 = var3;
      this.field2765 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1889394584"
   )
   public boolean method4386(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2765.length) {
         int var3 = this.field2765[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2764[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Ljm;",
      garbageValue = "428719059"
   )
   static HorizontalAlignment[] method4387() {
      return new HorizontalAlignment[]{HorizontalAlignment.field3701, HorizontalAlignment.field3702, HorizontalAlignment.field3700};
   }
}
