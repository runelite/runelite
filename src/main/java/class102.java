import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class102 extends class208 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -203901011
   )
   int field1760;
   @ObfuscatedName("d")
   int[] field1761;
   @ObfuscatedName("c")
   int[][] field1762;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -264839075
   )
   int field1763;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1790744003"
   )
   public static int method2373(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = (var0 >>> 4) + var0 & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   class102(int var1, byte[] var2) {
      this.field1763 = var1;
      class119 var3 = new class119(var2);
      this.field1760 = var3.method2613();
      this.field1761 = new int[this.field1760];
      this.field1762 = new int[this.field1760][];

      int var4;
      for(var4 = 0; var4 < this.field1760; ++var4) {
         this.field1761[var4] = var3.method2613();
      }

      for(var4 = 0; var4 < this.field1760; ++var4) {
         this.field1762[var4] = new int[var3.method2613()];
      }

      for(var4 = 0; var4 < this.field1760; ++var4) {
         for(int var5 = 0; var5 < this.field1762[var4].length; ++var5) {
            this.field1762[var4][var5] = var3.method2613();
         }
      }

   }
}
