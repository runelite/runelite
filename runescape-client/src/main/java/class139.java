import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class139 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1759634308"
   )
   public static void method2983() {
      try {
         class156.field2157.method2427();

         for(int var0 = 0; var0 < class156.field2153; ++var0) {
            ItemContainer.field751[var0].method2427();
         }

         class156.field2154.method2427();
         class156.field2155.method2427();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2015756477"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class233.plane][var0][var1];
      if(var2 == null) {
         class14.region.method2796(class233.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = WorldMapType2.getItemDefinition(var6.id);
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
            class14.region.method2796(class233.plane, var0, var1);
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
            class14.region.addItemPile(class233.plane, var0, var1, class41.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class233.plane), var5, var9, var11, var10);
         }
      }
   }
}
