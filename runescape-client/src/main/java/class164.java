import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class164 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1228068329
   )
   public final int field2155;
   @ObfuscatedName("g")
   public final int[] field2156;
   @ObfuscatedName("v")
   public final int[] field2157;
   @ObfuscatedName("ap")
   static class102 field2158;
   @ObfuscatedName("m")
   public static short[][] field2159;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 283173829
   )
   public final int field2160;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-20"
   )
   public boolean method3225(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2157.length) {
         int var3 = this.field2157[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2156[var2]) {
            return true;
         }
      }

      return false;
   }

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2160 = var1;
      this.field2155 = var2;
      this.field2156 = var3;
      this.field2157 = var4;
   }
}
