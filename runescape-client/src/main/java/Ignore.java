import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("d")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("a")
   @Export("name")
   String name;

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "914993807"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-31650611"
   )
   static void method108() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1993016040"
   )
   public static void method109() {
      class51.field1126.reset();
      class51.spriteCache.reset();
      class51.field1128.reset();
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-2"
   )
   static final void method110(int var0, int var1) {
      if(var0 != class159.field2372 || var1 != WidgetNode.field66) {
         class159.field2372 = var0;
         WidgetNode.field66 = var1;
         XItemContainer.setGameState(25);
         class38.method779("Loading - please wait.", true);
         int var2 = class9.baseX;
         int var3 = KitDefinition.baseY;
         class9.baseX = (var0 - 6) * 8;
         KitDefinition.baseY = (var1 - 6) * 8;
         int var4 = class9.baseX - var2;
         int var5 = KitDefinition.baseY - var3;
         var2 = class9.baseX;
         var3 = KitDefinition.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= 128 * var4;
               var7.y -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= var4 * 128;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var19; var18 != var12; var12 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var12 + var4;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var12][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var17 = (class16)Client.field425.method3854(); null != var17; var17 = (class16)Client.field425.method3869()) {
            var17.field218 -= var4;
            var17.field219 -= var5;
            if(var17.field218 < 0 || var17.field219 < 0 || var17.field218 >= 104 || var17.field219 >= 104) {
               var17.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field522 = 0;
         Client.field528 = false;
         Client.field466 = -1;
         Client.field416.method3848();
         Client.projectiles.method3848();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2417();
         }

      }
   }
}
