import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public final class class60 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lia;",
      garbageValue = "1965171849"
   )
   public static JagexGame[] method980() {
      return new JagexGame[]{JagexGame.field3296, JagexGame.field3293, JagexGame.field3291, JagexGame.field3289, JagexGame.field3290, JagexGame.field3292};
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "509408844"
   )
   static int method984(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class139.field2008:AttackOption.field1306;
      }

      String var4 = class82.scriptStringStack[--class35.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class82.intStack[--class82.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class82.intStack[--class82.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class82.scriptStringStack[--class35.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class82.intStack[--class82.intStackSize]);
         }
      }

      var7 = class82.intStack[--class82.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2847 = var8;
      } else if(var0 == 1401) {
         var3.field2873 = var8;
      } else if(var0 == 1402) {
         var3.field2843 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2848 = var8;
      } else if(var0 == 1406) {
         var3.field2797 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2859 = var8;
      } else if(var0 == 1410) {
         var3.field2849 = var8;
      } else if(var0 == 1411) {
         var3.field2842 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2850 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2861 = var8;
      } else if(var0 == 1419) {
         var3.field2751 = var8;
      } else if(var0 == 1420) {
         var3.field2891 = var8;
      } else if(var0 == 1421) {
         var3.field2864 = var8;
      } else if(var0 == 1422) {
         var3.field2865 = var8;
      } else if(var0 == 1423) {
         var3.field2799 = var8;
      } else if(var0 == 1424) {
         var3.field2856 = var8;
      } else if(var0 == 1425) {
         var3.field2869 = var8;
      } else if(var0 == 1426) {
         var3.field2801 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2868 = var8;
      }

      var3.field2887 = true;
      return 1;
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "90"
   )
   static final void method983(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class2.field13 || Frames.field2030 != var1) {
         class2.field13 = var0;
         Frames.field2030 = var1;
         Friend.setGameState(25);
         class185.drawStatusBox("Loading - please wait.", true);
         int var3 = SceneChunkMetadata.baseX;
         int var4 = Client.baseY;
         SceneChunkMetadata.baseX = (var0 - 6) * 8;
         Client.baseY = (var1 - 6) * 8;
         int var5 = SceneChunkMetadata.baseX - var3;
         int var6 = Client.baseY - var4;
         var3 = SceneChunkMetadata.baseX;
         var4 = Client.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 32768; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var18 != var13; var13 += var22) {
            for(var14 = var10; var11 != var14; var14 += var12) {
               int var15 = var5 + var13;
               int var16 = var14 + var6;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field1068 = 0;
         Client.field930 = false;
         Client.field1055 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(Lhz;III)V",
      garbageValue = "-495848669"
   )
   static void method985(Widget var0, int var1, int var2) {
      if(var0.field2764 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2764 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2764 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2764 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2764 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2838 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2838 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2838 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2838 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2838 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field978 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}
