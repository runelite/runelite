import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class55 {
   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1732209731"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            InvType.clientInstance.method1024();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field1095 = 0;
            Client.field888 = 0;
            Client.field902.method5274(var0);
            if(var0 != 20) {
               ScriptVarType.method25(false);
            }
         }

         if(var0 != 20 && var0 != 40 && Tile.field1812 != null) {
            Tile.field1812.vmethod3404();
            Tile.field1812 = null;
         }

         if(Client.gameState == 25) {
            Client.field1002 = 0;
            Client.field904 = 0;
            Client.field905 = 1;
            Client.field910 = 0;
            Client.field907 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class28.method245(Occluder.indexCache10, UnitPriceComparator.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class28.method245(Occluder.indexCache10, UnitPriceComparator.indexSprites, false, 4);
            } else if(class90.field1335) {
               class90.field1337 = null;
               class149.field2106 = null;
               class90.runeSprites = null;
               class90.field1359 = null;
               class90.field1340 = null;
               GrandExchangeOffer.logoSprite = null;
               class85.titlemuteSprite = null;
               BaseVarType.field33 = null;
               class21.field339 = null;
               ScriptState.field744 = null;
               class90.slFlagSprites = null;
               class3.slArrowSprites = null;
               WorldMapData.slStarSprites = null;
               class149.field2107 = null;
               class37.field501 = null;
               class317.field3926 = null;
               class3.field18 = null;
               class90.field1338 = null;
               class199.field2604 = null;
               class33.field459 = null;
               MouseRecorder.field789 = null;
               WorldMapManager.field559 = null;
               class229.field2694 = 1;
               class132.field1905 = null;
               class321.field3940 = -1;
               class132.field1897 = -1;
               AttackOption.field1334 = 0;
               Signlink.field2193 = false;
               class20.field335 = 2;
               class19.sendConInfo(true);
               class90.field1335 = false;
            }
         } else {
            class28.method245(Occluder.indexCache10, UnitPriceComparator.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "677650737"
   )
   static final void method847() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var0.level == ScriptVarType.plane && !var0.finished) {
            if(Client.gameCycle >= var0.startCycle) {
               var0.method1914(Client.field913);
               if(var0.finished) {
                  var0.unlink();
               } else {
                  GameSocket.region.method2958(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }
}
