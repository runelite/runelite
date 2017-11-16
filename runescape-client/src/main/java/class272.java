import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
public class class272 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   public static Huffman field3707;
   @ObfuscatedName("ab")
   static GarbageCollectorMXBean field3708;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Lks;",
      garbageValue = "5"
   )
   static IndexedSprite method4852() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class295.field3846;
      var0.originalHeight = class224.field2850;
      var0.offsetX = WidgetNode.field774[0];
      var0.offsetY = class285.offsetsY[0];
      var0.originalWidth = class295.field3848[0];
      var0.height = class295.field3845[0];
      var0.palette = class278.field3733;
      var0.pixels = class70.spritePixels[0];
      class274.method4876();
      return var0;
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(IZZZI)Liu;",
      garbageValue = "-1061855817"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class156.field2148 != null) {
         var4 = new IndexFile(var0, class156.field2148, class221.field2700[var0], 1000000);
      }

      return new IndexData(var4, class7.field223, var0, var1, var2, var3);
   }
}
