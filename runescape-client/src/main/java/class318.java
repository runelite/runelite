import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
public final class class318 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-1505155639"
   )
   static int method5706(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class81.intStack[--class171.intStackSize];
         class81.scriptStringStack[++class81.scriptStringStackSize - 1] = NetWriter.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if(var0 == 4201) {
            class171.intStackSize -= 2;
            var3 = class81.intStack[class171.intStackSize];
            var4 = class81.intStack[class171.intStackSize + 1];
            var5 = NetWriter.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class171.intStackSize -= 2;
            var3 = class81.intStack[class171.intStackSize];
            var4 = class81.intStack[class171.intStackSize + 1];
            var5 = NetWriter.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class81.intStack[--class171.intStackSize];
            class81.intStack[++class171.intStackSize - 1] = NetWriter.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class81.intStack[--class171.intStackSize];
            class81.intStack[++class171.intStackSize - 1] = NetWriter.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var6;
            if(var0 == 4205) {
               var3 = class81.intStack[--class171.intStackSize];
               var6 = NetWriter.getItemDefinition(var3);
               if(var6.notedTemplate == -1 && var6.note >= 0) {
                  class81.intStack[++class171.intStackSize - 1] = var6.note;
               } else {
                  class81.intStack[++class171.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class81.intStack[--class171.intStackSize];
               var6 = NetWriter.getItemDefinition(var3);
               if(var6.notedTemplate >= 0 && var6.note >= 0) {
                  class81.intStack[++class171.intStackSize - 1] = var6.note;
               } else {
                  class81.intStack[++class171.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class81.intStack[--class171.intStackSize];
               class81.intStack[++class171.intStackSize - 1] = NetWriter.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class81.intStack[--class171.intStackSize];
               var6 = NetWriter.getItemDefinition(var3);
               if(var6.placeholderTemplateId == -1 && var6.placeholderId >= 0) {
                  class81.intStack[++class171.intStackSize - 1] = var6.placeholderId;
               } else {
                  class81.intStack[++class171.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class81.intStack[--class171.intStackSize];
               var6 = NetWriter.getItemDefinition(var3);
               if(var6.placeholderTemplateId >= 0 && var6.placeholderId >= 0) {
                  class81.intStack[++class171.intStackSize - 1] = var6.placeholderId;
               } else {
                  class81.intStack[++class171.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = class81.scriptStringStack[--class81.scriptStringStackSize];
               var4 = class81.intStack[--class171.intStackSize];
               Tile.method2780(var7, var4 == 1);
               class81.intStack[++class171.intStackSize - 1] = WidgetNode.field772;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  OwnWorldComparator.field846 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(Size.field366 != null && OwnWorldComparator.field846 < WidgetNode.field772) {
                  class81.intStack[++class171.intStackSize - 1] = Size.field366[++OwnWorldComparator.field846 - 1] & '\uffff';
               } else {
                  class81.intStack[++class171.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1922159388"
   )
   static final void method5710() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class22.method169(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
