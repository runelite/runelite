import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("fy")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -600593349
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 395978261
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Les;",
      garbageValue = "-25440425"
   )
   protected final Model getModel() {
      return ItemContainer.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "16"
   )
   static int method1955() {
      return 11;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcf;ZB)I",
      garbageValue = "-65"
   )
   static int method1959(int var0, Script var1, boolean var2) {
      Widget var3 = class216.getWidget(class80.intStack[--class80.intStackSize]);
      if(var0 == 2800) {
         int[] var4 = class80.intStack;
         int var5 = ++class80.intStackSize - 1;
         int var7 = WorldComparator.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
            } else {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class80.intStack[--class80.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
