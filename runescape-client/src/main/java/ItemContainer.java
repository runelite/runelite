import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "Llm;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "[Lki;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;
   @ObfuscatedName("g")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("m")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljc;",
      garbageValue = "-45836646"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4969(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4999(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.int3 != -1) {
            var1.method4971(getItemDefinition(var1.int3), getItemDefinition(var1.int2));
         }

         if(!class35.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.int1 = 0;
            if(var1.field3615 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3615.getHead(); var4 != null; var4 = var1.field3615.getTail()) {
                  class262 var5 = class185.method3760((int)var4.hash);
                  if(var5.field3470) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3615 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-634519728"
   )
   static void method1048(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1187[var5] != var0) {
            var2[var4] = World.field1187[var5];
            var3[var4] = World.field1186[var5];
            ++var4;
         }
      }

      World.field1187 = var2;
      World.field1186 = var3;
      class175.method3419(class31.worldList, 0, class31.worldList.length - 1, World.field1187, World.field1186);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2078848216"
   )
   public static int method1052(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-74"
   )
   static final void method1053(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.itemSelectionState != 0 || Client.spellSelected) {
         int var2 = Client.menuOptionCount - 1;
         String var4;
         if(Client.itemSelectionState == 1 && Client.menuOptionCount < 2) {
            var4 = "Use" + " " + Client.lastSelectedItemName + " " + "->";
         } else if(Client.spellSelected && Client.menuOptionCount < 2) {
            var4 = Client.field854 + " " + Client.field995 + " " + "->";
         } else {
            String var5;
            if(var2 < 0) {
               var5 = "";
            } else if(Client.menuTargets[var2].length() > 0) {
               var5 = Client.menuOptions[var2] + " " + Client.menuTargets[var2];
            } else {
               var5 = Client.menuOptions[var2];
            }

            var4 = var5;
         }

         if(Client.menuOptionCount > 2) {
            var4 = var4 + class70.getColTags(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         IndexDataBase.fontBold12.drawRandomizedMouseoverText(var4, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2052817687"
   )
   static void method1055(int var0) {
      class36.topContextMenuRow = new ContextMenuRow();
      class36.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      class36.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      class36.topContextMenuRow.type = Client.menuTypes[var0];
      class36.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      class36.topContextMenuRow.option = Client.menuOptions[var0];
   }
}
