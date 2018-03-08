import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field1433;
   @ObfuscatedName("q")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("i")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("a")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2115928073
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 950532213
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1929874997
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1572978431
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lhq;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1433 = new NodeCache(128);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[Lhq;",
      garbageValue = "552036554"
   )
   IterableHashTable[] method2042(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;IB)Lho;",
      garbageValue = "1"
   )
   static class233 method2048(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      return var2 == null?null:new class233(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-18399"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(WorldComparator.validInterfaces[var0]) {
         return true;
      } else if(!Widget.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = Widget.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            WorldComparator.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            WorldComparator.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
