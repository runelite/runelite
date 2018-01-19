import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   static TextureProvider field752;
   @ObfuscatedName("v")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("y")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lil;IB)Z",
      garbageValue = "49"
   )
   static boolean method1098(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      if(var2 == null) {
         return false;
      } else {
         BuildType.decodeSprite(var2);
         return true;
      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1243843065"
   )
   static final void method1095() {
      int var0 = GrandExchangeOffer.localPlayer.x;
      int var1 = GrandExchangeOffer.localPlayer.y;
      if(IndexData.field3340 - var0 < -500 || IndexData.field3340 - var0 > 500 || SoundTask.field1575 - var1 < -500 || SoundTask.field1575 - var1 > 500) {
         IndexData.field3340 = var0;
         SoundTask.field1575 = var1;
      }

      if(var0 != IndexData.field3340) {
         IndexData.field3340 += (var0 - IndexData.field3340) / 16;
      }

      if(var1 != SoundTask.field1575) {
         SoundTask.field1575 += (var1 - SoundTask.field1575) / 16;
      }

      int var2;
      int var3;
      if(MouseInput.mouseCurrentButton == 4 && class45.middleMouseMovesCamera) {
         var2 = MouseInput.mouseLastY - Client.field996;
         Client.field941 = var2 * 2;
         Client.field996 = var2 != -1 && var2 != 1?(Client.field996 + MouseInput.mouseLastY) / 2:MouseInput.mouseLastY;
         var3 = Client.field891 - MouseInput.mouseLastX;
         Client.field1079 = var3 * 2;
         Client.field891 = var3 != -1 && var3 != 1?(MouseInput.mouseLastX + Client.field891) / 2:MouseInput.mouseLastX;
      } else {
         if(KeyFocusListener.keyPressed[96]) {
            Client.field1079 += (-24 - Client.field1079) / 2;
         } else if(KeyFocusListener.keyPressed[97]) {
            Client.field1079 += (24 - Client.field1079) / 2;
         } else {
            Client.field1079 /= 2;
         }

         if(KeyFocusListener.keyPressed[98]) {
            Client.field941 += (12 - Client.field941) / 2;
         } else if(KeyFocusListener.keyPressed[99]) {
            Client.field941 += (-12 - Client.field941) / 2;
         } else {
            Client.field941 /= 2;
         }

         Client.field996 = MouseInput.mouseLastY;
         Client.field891 = MouseInput.mouseLastX;
      }

      Client.mapAngle = Client.field1079 / 2 + Client.mapAngle & 2047;
      Client.field1092 += Client.field941 / 2;
      if(Client.field1092 < 128) {
         Client.field1092 = 128;
      }

      if(Client.field1092 > 383) {
         Client.field1092 = 383;
      }

      var2 = IndexData.field3340 >> 7;
      var3 = SoundTask.field1575 >> 7;
      int var4 = MouseInput.getTileHeight(IndexData.field3340, SoundTask.field1575, class7.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = class7.plane;
               if(var8 < 3 && (class61.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class61.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < 32768) {
         var6 = 32768;
      }

      if(var6 > Client.field947) {
         Client.field947 += (var6 - Client.field947) / 24;
      } else if(var6 < Client.field947) {
         Client.field947 += (var6 - Client.field947) / 80;
      }

   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(Lbf;ZI)V",
      garbageValue = "1518300589"
   )
   static void method1097(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field842 << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class94.playerIndexesCount > 50 || class94.playerIndexesCount > 200) && var1 && var0.poseAnimation == var0.idlePoseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field843 = MouseInput.getTileHeight(var0.x, var0.y, class7.plane);
               class45.region.method2758(class7.plane, var0.x, var0.y, var0.field843, 60, var0, var0.angle, var2, var0.field849, var0.field850, var0.field851, var0.field852);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field958[var3][var4] == Client.field919) {
                     return;
                  }

                  Client.field958[var3][var4] = Client.field919;
               }

               var0.field843 = MouseInput.getTileHeight(var0.x, var0.y, class7.plane);
               class45.region.method2829(class7.plane, var0.x, var0.y, var0.field843, 60, var0, var0.angle, var2, var0.field1152);
            }
         }
      }

   }
}
