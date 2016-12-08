import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class161 {
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 1491581887
   )
   static int field2151;

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1346164190"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class63.plane][var0][var1];
      if(null == var2) {
         class159.region.method1676(class63.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2349(); null != var6; var6 = (Item)var2.method2351()) {
            ItemComposition var7 = class137.getItemDefinition(var6.id);
            long var10 = (long)var7.price;
            if(var7.isStackable == 1) {
               var10 *= (long)(var6.quantity + 1);
            }

            if(var10 > var3) {
               var3 = var10;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class159.region.method1676(class63.plane, var0, var1);
         } else {
            var2.method2345(var5);
            Item var12 = null;
            Item var8 = null;

            for(var6 = (Item)var2.method2349(); null != var6; var6 = (Item)var2.method2351()) {
               if(var6.id != var5.id) {
                  if(var12 == null) {
                     var12 = var6;
                  }

                  if(var12.id != var6.id && var8 == null) {
                     var8 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class159.region.method1673(class63.plane, var0, var1, ChatLineBuffer.method896(128 * var0 + 64, 128 * var1 + 64, class63.plane), var5, var9, var12, var8);
         }
      }
   }
}
