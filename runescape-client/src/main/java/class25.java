import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class25 {
   @ObfuscatedName("k")
   @Export("highMemory")
   public static boolean highMemory;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 526869589
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("rf")
   @ObfuscatedGetter(
      intValue = -574292973
   )
   static int field373;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2067772879
   )
   int field368;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   Coordinates field369;

   @ObfuscatedSignature(
      signature = "(ILhq;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field368 = var1;
      this.field369 = var2;
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(IZZZB)Lid;",
      garbageValue = "8"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class156.field2231 != null) {
         var4 = new IndexFile(var0, class156.field2231, class156.field2227[var0], 1000000);
      }

      return new IndexData(var4, RSCanvas.field650, var0, var1, var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lhc;III)Lcc;",
      garbageValue = "-644140240"
   )
   static Script method184(class220 var0, int var1, int var2) {
      int var3 = Buffer.method3348(var1, var0);
      Script var4 = class9.method49(var3, var0);
      if(var4 != null) {
         return var4;
      } else {
         int var5 = var0.field2769 + (var2 + '鱀' << 8);
         var4 = class9.method49(var5, var0);
         return var4 != null?var4:null;
      }
   }
}
