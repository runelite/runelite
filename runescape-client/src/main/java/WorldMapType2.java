import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static IndexData field500;
   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field492;
   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field497;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 910216061
   )
   int field491;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -121876621
   )
   int field502;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -728179193
   )
   int field493;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2047340839
   )
   int field499;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 483270433
   )
   int field495;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -142256923
   )
   int field496;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;I)V",
      garbageValue = "1038625343"
   )
   public void vmethod724(WorldMapData var1) {
      if(var1.field427 > this.field495) {
         var1.field427 = this.field495;
      }

      if(var1.field431 < this.field495) {
         var1.field431 = this.field495;
      }

      if(var1.field428 > this.field496) {
         var1.field428 = this.field496;
      }

      if(var1.field436 < this.field496) {
         var1.field436 = this.field496;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952023960"
   )
   public boolean vmethod728(int var1, int var2, int var3) {
      return var1 >= this.field491 && var1 < this.field502 + this.field491?var2 >> 6 == this.field493 && var3 >> 6 == this.field499:false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-27"
   )
   public boolean vmethod716(int var1, int var2) {
      return var1 >> 6 == this.field495 && var2 >> 6 == this.field496;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-495685061"
   )
   public int[] vmethod717(int var1, int var2, int var3) {
      if(!this.vmethod728(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field495 * 64 - this.field493 * 64 + var2, var3 + (this.field496 * 64 - this.field499 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhp;",
      garbageValue = "1"
   )
   public Coordinates vmethod741(int var1, int var2) {
      if(!this.vmethod716(var1, var2)) {
         return null;
      } else {
         int var3 = this.field493 * 64 - this.field495 * 64 + var1;
         int var4 = this.field499 * 64 - this.field496 * 64 + var2;
         return new Coordinates(this.field491, var3, var4);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "-1975557779"
   )
   public void vmethod719(Buffer var1) {
      this.field491 = var1.readUnsignedByte();
      this.field502 = var1.readUnsignedByte();
      this.field493 = var1.readUnsignedShort();
      this.field499 = var1.readUnsignedShort();
      this.field495 = var1.readUnsignedShort();
      this.field496 = var1.readUnsignedShort();
      this.method518();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "66"
   )
   void method518() {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljb;",
      garbageValue = "2134352867"
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
            var1.method4751(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4811(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3605 != -1) {
            var1.method4753(getItemDefinition(var1.field3605), getItemDefinition(var1.field3557));
         }

         if(!MessageNode.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3594 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3601 = 0;
            if(var1.field3597 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3597.getHead(); var4 != null; var4 = var1.field3597.getTail()) {
                  class258 var5 = ClanMember.method1187((int)var4.hash);
                  if(var5.field3459) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3597 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "99"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1376302631"
   )
   static void method529() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3707(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3703()) {
         int var1 = var0.id;
         if(ISAACCipher.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = class11.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class87.method1762(var4);
               if(var5 != null) {
                  class40.method556(var5);
               }
            }
         }
      }

   }
}
