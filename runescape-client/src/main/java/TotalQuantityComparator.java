import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("w")
   static byte[][][] field288;
   @ObfuscatedName("d")
   static int[] field287;
   @ObfuscatedName("c")
   static int[] field292;
   @ObfuscatedName("j")
   @Export("userHome")
   static String userHome;
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("region")
   static Region region;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;I)I",
      garbageValue = "-2145545026"
   )
   int method90(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method90((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "587214546"
   )
   static final void method98(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2979(var0, var1, var2);
      int[] var8 = Region.method2979(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "194"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class60.plane][var0][var1];
      if(var2 == null) {
         region.removeGroundItemPile(class60.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = ItemContainer.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            region.removeGroundItemPile(class60.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            region.addItemPile(class60.plane, var0, var1, MessageNode.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class60.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1177693160"
   )
   static void method89(int var0, int var1, int var2, int var3) {
      Widget var4 = class44.getWidgetChild(var0, var1);
      if(var4 != null && var4.field2845 != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.objs = var4.field2845;
         class84.method1868(var5);
      }

      Client.field1060 = var3;
      Client.spellSelected = true;
      class249.field3357 = var0;
      Client.field1038 = var1;
      Occluder.field2038 = var2;
      class33.method341(var4);
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "476945183"
   )
   static final void method91(int var0) {
      if(ServerPacket.loadWidget(var0)) {
         Widget[] var1 = ScriptState.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2876 = 0;
               var3.field2889 = 0;
            }
         }

      }
   }
}
