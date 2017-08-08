import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class35 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   static final class35 field500;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   static final class35 field497;
   @ObfuscatedName("v")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 14813205
   )
   final int field499;

   static {
      field500 = new class35(0);
      field497 = new class35(1);
   }

   class35(int var1) {
      this.field499 = var1;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1642818155"
   )
   static final void method495() {
      if(GroundObject.soundSystem1 != null) {
         GroundObject.soundSystem1.method2039();
      }

      if(Actor.soundSystem0 != null) {
         Actor.soundSystem0.method2039();
      }

   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-111"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class29.plane][var0][var1];
      if(var2 == null) {
         class84.region.method2732(class29.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = ClassInfo.getItemDefinition(var6.id);
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
            class84.region.method2732(class29.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class84.region.addItemPile(class29.plane, var0, var1, Friend.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class29.plane), var5, var9, var11, var10);
         }
      }
   }
}
