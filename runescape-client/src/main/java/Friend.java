import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("Friend")
public class Friend extends Nameable {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1955832607
   )
   @Export("world")
   public int world;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -91873395
   )
   int field3738;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -297051129
   )
   public int field3740;
   @ObfuscatedName("h")
   boolean field3741;
   @ObfuscatedName("t")
   boolean field3742;

   Friend() {
      this.world = -1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljw;I)I",
      garbageValue = "-596745836"
   )
   int method5343(Friend var1) {
      return this.world == Client.world && Client.world != var1.world?-1:(Client.world == var1.world && this.world != Client.world?1:(this.world != 0 && var1.world == 0?-1:(var1.world != 0 && this.world == 0?1:(this.field3741 && !var1.field3741?-1:(!this.field3741 && var1.field3741?1:(this.field3742 && !var1.field3742?-1:(!this.field3742 && var1.field3742?1:(this.world != 0?this.field3738 - var1.field3738:var1.field3738 - this.field3738))))))));
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljq;I)I",
      garbageValue = "-1632311756"
   )
   int vmethod5337(Nameable var1) {
      return this.method5343((Friend)var1);
   }

   public int compareTo(Object var1) {
      return this.method5343((Friend)var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "2064187249"
   )
   static int method5348(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.scriptStringStack[++class294.scriptStringStackSize - 1] = ItemContainer.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if(var0 == 4201) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            var5 = ItemContainer.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            var5 = ItemContainer.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class80.intStack[--class80.intStackSize];
            class80.intStack[++class80.intStackSize - 1] = ItemContainer.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class80.intStack[--class80.intStackSize];
            class80.intStack[++class80.intStackSize - 1] = ItemContainer.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var6;
            if(var0 == 4205) {
               var3 = class80.intStack[--class80.intStackSize];
               var6 = ItemContainer.getItemDefinition(var3);
               if(var6.notedTemplate == -1 && var6.note >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var6.note;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class80.intStack[--class80.intStackSize];
               var6 = ItemContainer.getItemDefinition(var3);
               if(var6.notedTemplate >= 0 && var6.note >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var6.note;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class80.intStack[--class80.intStackSize];
               class80.intStack[++class80.intStackSize - 1] = ItemContainer.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class80.intStack[--class80.intStackSize];
               var6 = ItemContainer.getItemDefinition(var3);
               if(var6.int3 == -1 && var6.int2 >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var6.int2;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class80.intStack[--class80.intStackSize];
               var6 = ItemContainer.getItemDefinition(var3);
               if(var6.int3 >= 0 && var6.int2 >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var6.int2;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = class80.scriptStringStack[--class294.scriptStringStackSize];
               var4 = class80.intStack[--class80.intStackSize];
               class214.method4122(var7, var4 == 1);
               class80.intStack[++class80.intStackSize - 1] = OwnWorldComparator.field836;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  class157.field2152 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class27.field382 != null && class157.field2152 < OwnWorldComparator.field836) {
                  class80.intStack[++class80.intStackSize - 1] = class27.field382[++class157.field2152 - 1] & '\uffff';
               } else {
                  class80.intStack[++class80.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }
}
