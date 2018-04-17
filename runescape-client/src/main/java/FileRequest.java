import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -690512423
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("t")
   @Export("padding")
   byte padding;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILcr;ZB)I",
      garbageValue = "1"
   )
   static int method4524(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class44.getWidget(class81.intStack[--WorldComparator.intStackSize]);
      } else {
         var3 = var2?class81.field1285:Signlink.field2218;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class81.intStack[--WorldComparator.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize]);
            return 1;
         } else {
            --KeyFocusListener.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         WorldComparator.intStackSize -= 2;
         var4 = class81.intStack[WorldComparator.intStackSize];
         int var5 = class81.intStack[WorldComparator.intStackSize + 1];
         var3.dragParent = FontName.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.dragRenderBehavior = class81.intStack[--WorldComparator.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.dragDeadZone = class81.intStack[--WorldComparator.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.dragDeadTime = class81.intStack[--WorldComparator.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.opBase = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.targetVerb = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
