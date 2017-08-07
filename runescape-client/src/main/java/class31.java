import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class31 {
   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field451;
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 878127619
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2125036969
   )
   final int field448;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2135306163
   )
   final int field445;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1609484777
   )
   final int field446;

   class31(int var1, int var2, int var3) {
      this.field448 = var1;
      this.field445 = var2;
      this.field446 = var3;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "([Lhg;IB)V",
      garbageValue = "-17"
   )
   static final void method280(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method280(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class10.loadWidget(var5)) {
                     method280(Item.widgets[var5], var1);
                  }
               }
            }

            ScriptEvent var6;
            if(var1 == 0 && var3.field2730 != null) {
               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field849 = var3.field2730;
               PendingSpawn.method1525(var6);
            }

            if(var1 == 1 && var3.field2731 != null) {
               if(var3.index >= 0) {
                  Widget var7 = class266.method4862(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field849 = var3.field2731;
               PendingSpawn.method1525(var6);
            }
         }
      }

   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "66"
   )
   static final void method282(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class48.field605 || WidgetNode.field826 != var1) {
         class48.field605 = var0;
         WidgetNode.field826 = var1;
         WorldMapType1.setGameState(25);
         class23.drawStatusBox("Loading - please wait.", true);
         int var3 = class25.baseX;
         int var4 = ScriptEvent.baseY;
         class25.baseX = (var0 - 6) * 8;
         ScriptEvent.baseY = (var1 - 6) * 8;
         int var5 = class25.baseX - var3;
         int var6 = ScriptEvent.baseY - var4;
         var3 = class25.baseX;
         var4 = ScriptEvent.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < '耀'; ++var7) {
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
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var5 + var13;
               int var16 = var6 + var14;

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

         Client.field1144 = 0;
         Client.field939 = false;
         Client.field949 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcc;ZB)I",
      garbageValue = "103"
   )
   static int method281(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class266.method4862(class84.intStack[--class84.intStackSize]);
      } else {
         var3 = var2?class269.field3661:DecorativeObject.field2164;
      }

      String var4 = class84.scriptStringStack[--class84.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class84.intStack[--class84.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class84.intStack[--class84.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class84.scriptStringStack[--class84.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class84.intStack[--class84.intStackSize]);
         }
      }

      var7 = class84.intStack[--class84.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2705 = var8;
      } else if(var0 == 1401) {
         var3.field2711 = var8;
      } else if(var0 == 1402) {
         var3.field2707 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2712 = var8;
      } else if(var0 == 1406) {
         var3.field2735 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2723 = var8;
      } else if(var0 == 1410) {
         var3.field2625 = var8;
      } else if(var0 == 1411) {
         var3.field2706 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2714 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2750 = var8;
      } else if(var0 == 1419) {
         var3.field2726 = var8;
      } else if(var0 == 1420) {
         var3.field2742 = var8;
      } else if(var0 == 1421) {
         var3.field2728 = var8;
      } else if(var0 == 1422) {
         var3.field2675 = var8;
      } else if(var0 == 1423) {
         var3.field2730 = var8;
      } else if(var0 == 1424) {
         var3.field2731 = var8;
      } else if(var0 == 1425) {
         var3.field2733 = var8;
      } else if(var0 == 1426) {
         var3.field2716 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2732 = var8;
      }

      var3.field2739 = true;
      return 1;
   }
}
