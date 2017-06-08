import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class20 {
   @ObfuscatedName("nk")
   static class276 field337;

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   static final void method166() {
      if(class8.rssocket != null) {
         class8.rssocket.method2989();
         class8.rssocket = null;
      }

      class100.method1838();
      class61.region.method2675();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method3016();
      }

      System.gc();
      class203.field2515 = 1;
      class203.field2516 = null;
      class158.field2275 = -1;
      class275.field3730 = -1;
      FileOnDisk.field1774 = 0;
      class271.field3690 = false;
      class155.field2261 = 2;
      Client.field1153 = -1;
      Client.field1154 = false;
      class12.method82();
      class3.setGameState(10);
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1577044023"
   )
   static final int method167() {
      if(class66.field801.field1318) {
         return class92.plane;
      } else {
         int var0 = 3;
         if(Client.cameraPitch < 310) {
            int var1 = class2.cameraX >> 7;
            int var2 = XItemContainer.cameraY >> 7;
            int var3 = class168.localPlayer.x >> 7;
            int var4 = class168.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class92.plane;
            }

            if((class61.tileSettings[class92.plane][var1][var2] & 4) != 0) {
               var0 = class92.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = '耀';

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class61.tileSettings[class92.plane][var1][var2] & 4) != 0) {
                     var0 = class92.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class61.tileSettings[class92.plane][var1][var2] & 4) != 0) {
                        var0 = class92.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class61.tileSettings[class92.plane][var1][var2] & 4) != 0) {
                     var0 = class92.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class61.tileSettings[class92.plane][var1][var2] & 4) != 0) {
                        var0 = class92.plane;
                     }
                  }
               }
            }
         }

         if(class168.localPlayer.x >= 0 && class168.localPlayer.y >= 0 && class168.localPlayer.x < 13312 && class168.localPlayer.y < 13312) {
            if((class61.tileSettings[class92.plane][class168.localPlayer.x >> 7][class168.localPlayer.y >> 7] & 4) != 0) {
               var0 = class92.plane;
            }

            return var0;
         } else {
            return class92.plane;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-690162697"
   )
   static void method168() {
      class61.field737 = 99;
      class234.underlayIds = new byte[4][104][104];
      class61.overlayIds = new byte[4][104][104];
      class21.overlayPaths = new byte[4][104][104];
      class61.overlayRotations = new byte[4][104][104];
      class51.field643 = new int[4][105][105];
      class10.field261 = new byte[4][105][105];
      class61.field740 = new int[105][105];
      class157.field2263 = new int[104];
      class61.field741 = new int[104];
      class61.field742 = new int[104];
      class43.field569 = new int[104];
      class61.field743 = new int[104];
   }
}
