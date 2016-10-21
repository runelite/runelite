import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("n")
   int[] field1823;
   @ObfuscatedName("c")
   public static short[] field1824;
   @ObfuscatedName("de")
   static int[] field1826;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1693721321
   )
   int field1828;
   @ObfuscatedName("t")
   int[][] field1829;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1081954783
   )
   int field1830;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LModIcon;",
      garbageValue = "1789720947"
   )
   static ModIcon method2312() {
      ModIcon var0 = new ModIcon();
      var0.width = class79.field1430;
      var0.originalHeight = class79.field1437;
      var0.offsetX = class189.field3050[0];
      var0.offsetY = class79.field1431[0];
      var0.originalWidth = class79.field1432[0];
      var0.height = XItemContainer.field221[0];
      var0.palette = class137.field2130;
      var0.pixels = BufferProvider.field1450[0];
      class14.method161();
      return var0;
   }

   FrameMap(int var1, byte[] var2) {
      this.field1830 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1828 = var3.method2656();
      this.field1823 = new int[this.field1828];
      this.field1829 = new int[this.field1828][];

      int var4;
      for(var4 = 0; var4 < this.field1828; ++var4) {
         this.field1823[var4] = var3.method2656();
      }

      for(var4 = 0; var4 < this.field1828; ++var4) {
         this.field1829[var4] = new int[var3.method2656()];
      }

      for(var4 = 0; var4 < this.field1828; ++var4) {
         for(int var5 = 0; var5 < this.field1829[var4].length; ++var5) {
            this.field1829[var4][var5] = var3.method2656();
         }
      }

   }
}
