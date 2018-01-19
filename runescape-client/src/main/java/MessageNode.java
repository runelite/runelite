import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("bu")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 1915926205
   )
   static int field826;
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -890292739
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2130115035
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 11789715
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   @Export("sender")
   String sender;
   @ObfuscatedName("d")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = class72.method1125();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1516721459"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = class72.method1125();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public static boolean method1122(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1296847789"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class7.plane][var0][var1];
      if(var2 == null) {
         class45.region.removeGroundItemPile(class7.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class115.getItemDefinition(var6.id);
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
            class45.region.removeGroundItemPile(class7.plane, var0, var1);
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
            class45.region.addItemPile(class7.plane, var0, var1, MouseInput.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class7.plane), var5, var9, var11, var10);
         }
      }
   }
}
