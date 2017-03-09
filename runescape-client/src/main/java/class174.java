import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class174 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)Ljava/lang/String;",
      garbageValue = "-1149073990"
   )
   public static String method3270(Buffer var0) {
      return CombatInfoListHolder.method777(var0, 32767);
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(LWidget;S)I",
      garbageValue = "12556"
   )
   static int method3271(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2405(((long)var0.id << 32) + (long)var0.index);
      return null != var1?var1.field1897:var0.field2258;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;IB)LModIcon;",
      garbageValue = "-18"
   )
   public static ModIcon method3272(class182 var0, int var1) {
      byte[] var3 = var0.method3311(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         Varbit.method3557(var3);
         var2 = true;
      }

      if(!var2) {
         return null;
      } else {
         ModIcon var4 = new ModIcon();
         var4.width = class203.field3083;
         var4.originalHeight = class225.field3232;
         var4.offsetX = XItemContainer.field147[0];
         var4.offsetY = class203.field3085[0];
         var4.originalWidth = class225.field3233[0];
         var4.height = class225.field3231[0];
         var4.palette = class225.field3237;
         var4.pixels = RSCanvas.field1766[0];
         XItemContainer.field147 = null;
         class203.field3085 = null;
         class225.field3233 = null;
         class225.field3231 = null;
         class225.field3237 = null;
         RSCanvas.field1766 = null;
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-1322127795"
   )
   static final void method3273(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -class203.method3806(var4 + 932731 + var2, var3 + 556238 + var5) * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = 8 * -var8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class10.overlayIds[var1][var2][var3] = var0.readByte();
               class10.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class172.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class10.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   class174() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1830021114"
   )
   static final void method3274(int var0, int var1) {
      if(var0 != FileOnDisk.field1203 || VertexNormal.field1435 != var1) {
         FileOnDisk.field1203 = var0;
         VertexNormal.field1435 = var1;
         class187.setGameState(25);
         class22.method238("Loading - please wait.", true);
         int var2 = CombatInfoListHolder.baseX;
         int var3 = class3.baseY;
         CombatInfoListHolder.baseX = (var0 - 6) * 8;
         class3.baseY = (var1 - 6) * 8;
         int var4 = CombatInfoListHolder.baseX - var2;
         int var5 = class3.baseY - var3;
         var2 = CombatInfoListHolder.baseX;
         var3 = class3.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= var4 * 128;
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= 128 * var4;
               var20.y -= var5 * 128;
            }
         }

         byte var19 = 0;
         byte var17 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var17 = -1;
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
         for(int var18 = var19; var17 != var18; var18 += var21) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var18 + var4;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var18][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var18][var13] = null;
                  }
               }
            }
         }

         for(class25 var12 = (class25)Client.field444.method2448(); var12 != null; var12 = (class25)Client.field444.method2445()) {
            var12.field598 -= var4;
            var12.field600 -= var5;
            if(var12.field598 < 0 || var12.field600 < 0 || var12.field598 >= 104 || var12.field600 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field419 = 0;
         Client.field440 = false;
         Client.field543 = -1;
         Client.field443.method2442();
         Client.projectiles.method2442();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2300();
         }

      }
   }
}
