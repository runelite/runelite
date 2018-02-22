import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class22 extends class28 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgn;Lgn;I)V",
      garbageValue = "-572581716"
   )
   void method175(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field463.field469) {
         throw new IllegalStateException("");
      } else {
         super.field384 = var2.readUnsignedByte();
         super.field377 = var2.readUnsignedByte();
         super.field383 = var2.readUnsignedShort();
         super.field373 = var2.readUnsignedShort();
         super.field374 = var2.readUnsignedShort();
         super.field381 = var2.readUnsignedShort();
         super.field377 = Math.min(super.field377, 4);
         super.field378 = new short[1][64][64];
         super.field379 = new short[super.field377][64][64];
         super.field386 = new byte[super.field377][64][64];
         super.field380 = new byte[super.field377][64][64];
         super.field382 = new class31[super.field377][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field461.field455) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field374 && var5 == super.field381) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method242(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field374 == super.field374 && super.field381 == var2.field381;
      }
   }

   public int hashCode() {
      return super.field374 | super.field381 << 8;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-22"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class230.plane][var0][var1];
      if(var2 == null) {
         GameObject.region.removeGroundItemPile(class230.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = ContextMenuRow.getItemDefinition(var6.id);
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
            GameObject.region.removeGroundItemPile(class230.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            GameObject.region.addItemPile(class230.plane, var0, var1, WorldMapType1.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class230.plane), var5, var9, var11, var10);
         }
      }
   }
}
