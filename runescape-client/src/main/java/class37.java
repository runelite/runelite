import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class37 {
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 628653537
   )
   static int field522;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IS)Lih;",
      garbageValue = "211"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3444 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "76"
   )
   static void method519() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.field1131[0] = false;
      Client.menuOptionCount = 1;
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2085153661"
   )
   static final void method513() {
      Client.field1136 = 0;
      int var0 = (GrandExchangeOffer.localPlayer.x >> 7) + class47.baseX;
      int var1 = (GrandExchangeOffer.localPlayer.y >> 7) + class44.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field1136 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field1136 = 1;
      }

      if(Client.field1136 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field1136 = 0;
      }

   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(Lhi;Lif;IIZB)V",
      garbageValue = "2"
   )
   static final void method515(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         String var9 = Tile.getColTags(16748608) + var1.name;
         int var11 = var1.id;
         int var13 = var0.id;
         if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var7;
            Client.menuTargets[Client.menuOptionCount] = var9;
            Client.menuTypes[Client.menuOptionCount] = var6;
            Client.menuIdentifiers[Client.menuOptionCount] = var11;
            Client.menuActionParams0[Client.menuOptionCount] = var2;
            Client.menuActionParams1[Client.menuOptionCount] = var13;
            Client.field1131[Client.menuOptionCount] = var4;
            ++Client.menuOptionCount;
         }
      }

   }
}
