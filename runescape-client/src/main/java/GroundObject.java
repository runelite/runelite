import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1978395211
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 937709269
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1797664371
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1034101317
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1197635451
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljz;",
      garbageValue = "184284081"
   )
   public static Enum method2768(int var0) {
      Enum var1 = (Enum)Enum.EnumDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.EnumDefinition_indexCache.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.EnumDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-57"
   )
   static void method2767() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(class85.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = GZipDecompressor.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = UnitPriceComparator.getWidget(var4);
               if(var5 != null) {
                  TotalQuantityComparator.method100(var5);
               }
            }
         }
      }

   }
}
