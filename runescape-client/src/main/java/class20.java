import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class20 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-85"
   )
   public static void method164() {
      MouseInput var0 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.mouseCurrentButton = MouseInput.MouseHandler_currentButton;
         MouseInput.mouseLastX = MouseInput.mouseX;
         MouseInput.mouseLastY = MouseInput.mouseY;
         MouseInput.mouseLastButton = MouseInput.MouseHandler_lastButton;
         MouseInput.mouseLastPressedX = MouseInput.MouseHandler_lastPressedX;
         MouseInput.mouseLastPressedY = MouseInput.MouseHandler_lastPressedY;
         MouseInput.mouseLastPressedTimeMillis = MouseInput.MouseHandler_lastPressedTimeMillis;
         MouseInput.MouseHandler_lastButton = 0;
      }
   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "594976654"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class249.clientInstance.method1011();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field884 = 0;
            Client.field848 = 0;
            Client.field898.method5205(var0);
            if(var0 != 20) {
               Player.method1218(false);
            }
         }

         if(var0 != 20 && var0 != 40 && MapLabel.field445 != null) {
            MapLabel.field445.vmethod3339();
            MapLabel.field445 = null;
         }

         if(Client.gameState == 25) {
            Client.field905 = 0;
            Client.field901 = 0;
            Client.field902 = 1;
            Client.field934 = 0;
            Client.field1087 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               GrandExchangeEvents.method80(FileRequest.indexCache10, WorldMapRegion.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               GrandExchangeEvents.method80(FileRequest.indexCache10, WorldMapRegion.indexSprites, false, 4);
            } else if(class90.field1340) {
               class90.field1324 = null;
               class250.field3014 = null;
               class241.runeSprites = null;
               Item.field1387 = null;
               class237.field2773 = null;
               class252.logoSprite = null;
               class90.titlemuteSprite = null;
               FaceNormal.field2035 = null;
               class90.field1326 = null;
               class264.field3430 = null;
               Timer.slFlagSprites = null;
               class28.slArrowSprites = null;
               WorldMapType2.slStarSprites = null;
               class156.field2117 = null;
               MapLabel.field448 = null;
               class233.field2754 = null;
               MilliTimer.field2140 = null;
               ItemContainer.field750 = null;
               class27.field365 = null;
               SceneTilePaint.field1943 = null;
               class228.field2670 = null;
               class55.field626 = null;
               class229.field2674 = 1;
               class229.field2672 = null;
               class171.field2199 = -1;
               class229.field2676 = -1;
               class229.field2677 = 0;
               class85.field1294 = false;
               class2.field13 = 2;
               JagexGame.sendConInfo(true);
               class90.field1340 = false;
            }
         } else {
            GrandExchangeEvents.method80(FileRequest.indexCache10, WorldMapRegion.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
