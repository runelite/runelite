import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field1449;
   @ObfuscatedName("i")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("o")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("j")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2007836195
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -986383027
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 155988455
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1556061907
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lhz;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1449 = new NodeCache(128);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[Lhz;",
      garbageValue = "1575567631"
   )
   IterableHashTable[] method2009(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcx;ZS)I",
      garbageValue = "-23132"
   )
   static int method2018(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class81.intStack[--SceneTilePaint.intStackSize];
         var4 = class3.getWidget(var3);
      } else {
         var4 = var2?class336.field4073:class61.field713;
      }

      if(var0 == 1000) {
         SceneTilePaint.intStackSize -= 4;
         var4.originalX = class81.intStack[SceneTilePaint.intStackSize];
         var4.originalY = class81.intStack[SceneTilePaint.intStackSize + 1];
         var4.dynamicX = class81.intStack[SceneTilePaint.intStackSize + 2];
         var4.dynamicY = class81.intStack[SceneTilePaint.intStackSize + 3];
         WorldMapType1.method274(var4);
         BoundingBox.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            MapIcon.method578(class189.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         SceneTilePaint.intStackSize -= 4;
         var4.originalWidth = class81.intStack[SceneTilePaint.intStackSize];
         var4.originalHeight = class81.intStack[SceneTilePaint.intStackSize + 1];
         var4.dynamicWidth = class81.intStack[SceneTilePaint.intStackSize + 2];
         var4.buttonType = class81.intStack[SceneTilePaint.intStackSize + 3];
         WorldMapType1.method274(var4);
         BoundingBox.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            MapIcon.method578(class189.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            WorldMapType1.method274(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class81.intStack[--SceneTilePaint.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.noScrollThrough = class81.intStack[--SceneTilePaint.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
