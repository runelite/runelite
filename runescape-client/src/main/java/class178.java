import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class178 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 790538345
   )
   public final int field2943;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1786474299
   )
   public final int field2944;
   @ObfuscatedName("t")
   public final int[] field2945;
   @ObfuscatedName("d")
   static String field2947;
   @ObfuscatedName("y")
   public final int[] field2948;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-780844001"
   )
   public boolean method3447(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2948.length) {
         int var3 = this.field2948[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2945[var2]) {
            return true;
         }
      }

      return false;
   }

   class178(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2943 = var1;
      this.field2944 = var2;
      this.field2945 = var3;
      this.field2948 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-118"
   )
   public static void method3448(int var0) {
      if(class186.field3002 != 0) {
         class186.field3005 = var0;
      } else {
         class186.field3007.method3617(var0);
      }

   }
}
