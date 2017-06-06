import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("ft")
   static byte[][] field2158;
   @ObfuscatedName("y")
   public static IndexDataBase field2161;
   @ObfuscatedName("i")
   Frame[] field2163;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2006513288"
   )
   public boolean method2869(int var1) {
      return this.field2163[var1].field1908;
   }

   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method4187(var3);
      this.field2163 = new Frame[var6];
      int[] var7 = var1.method4161(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3576(); var12 != null; var12 = (FrameMap)var5.method3578()) {
            if(var12.field2071 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method4116(0, var11);
            } else {
               var13 = var2.method4116(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method3571(var10);
         }

         this.field2163[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2058066012"
   )
   static final int method2873() {
      return class134.field2007;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1596408237"
   )
   static final void method2874(int var0, int var1, boolean var2) {
      if(!var2 || class59.field748 != var0 || class59.field747 != var1) {
         class59.field748 = var0;
         class59.field747 = var1;
         class249.setGameState(25);
         KitDefinition.method4378("Loading - please wait.", true);
         int var3 = class41.baseX;
         int var4 = WorldMapType3.baseY;
         class41.baseX = (var0 - 6) * 8;
         WorldMapType3.baseY = (var1 - 6) * 8;
         int var5 = class41.baseX - var3;
         int var6 = WorldMapType3.baseY - var4;
         var3 = class41.baseX;
         var4 = WorldMapType3.baseY;

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
         byte var19 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var19 = -1;
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
         for(int var13 = var20; var19 != var13; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var13 + var5;
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

         for(class76 var18 = (class76)Client.field979.method3576(); var18 != null; var18 = (class76)Client.field979.method3578()) {
            var18.field1217 -= var5;
            var18.field1224 -= var6;
            if(var18.field1217 < 0 || var18.field1224 < 0 || var18.field1217 >= 104 || var18.field1224 >= 104) {
               var18.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var5;
            Client.flagY -= var6;
         }

         Client.field1061 = 0;
         Client.field989 = false;
         Client.field1157 = -1;
         Client.field1172.method3569();
         Client.projectiles.method3569();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].method3022();
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "-490952447"
   )
   public static void method2875(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      Widget.field2686 = var0;
      Widget.field2644 = var1;
      class83.field1361 = var2;
      class176.field2425 = var3;
      CombatInfo1.widgets = new Widget[Widget.field2686.method4121()][];
      Widget.validInterfaces = new boolean[Widget.field2686.method4121()];
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   static void method2876() {
      Client.field1122 = -1L;
      Client.field941 = -1;
      class64.field807.field872 = 0;
      class44.field582 = true;
      Client.field1042 = true;
      Client.field1154 = -1L;
      class226.method4078();
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.field976 = -1;
      Client.field995 = -1;
      Client.field980 = -1;
      Client.field1167 = -1;
      Client.field977 = 0;
      Client.field981 = 0;
      Client.field982 = 0;
      Client.field945 = 0;
      Client.menuOptionCount = 0;
      Client.field1090 = -1;
      Client.isMenuOpen = false;
      WorldMapType0.method722(0);
      class98.chatLineMap.clear();
      class98.field1532.method3484();
      class98.field1534.method3634();
      class98.field1533 = 0;
      Client.field1083 = 0;
      Client.field1085 = false;
      Client.field1061 = 0;
      Client.field994 = (int)(Math.random() * 100.0D) - 50;
      Client.field996 = (int)(Math.random() * 110.0D) - 55;
      Client.field1041 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field1170 = 0;
      Client.field1157 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field953 = class91.field1439;
      Client.field984 = class91.field1439;
      Client.field968 = 0;
      class96.field1507 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class96.field1506[var0] = null;
         class96.field1503[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field1059 = -1;
      Client.projectiles.method3569();
      Client.field1172.method3569();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.field979 = new Deque();
      Client.field1196 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class241.field3288; ++var0) {
         class241 var3 = class23.method159(var0);
         if(var3 != null) {
            class211.settings[var0] = 0;
            class211.widgetSettings[var0] = 0;
         }
      }

      Player.chatMessages.method1788();
      Client.field1193 = -1;
      if(Client.widgetRoot != -1) {
         class37.method487(Client.widgetRoot);
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method3518(); var4 != null; var4 = (WidgetNode)Client.componentTable.method3524()) {
         ScriptState.method1054(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field963 = null;
      Client.menuOptionCount = 0;
      Client.field1090 = -1;
      Client.isMenuOpen = false;
      Client.field1201.method3936((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      class34.method471();
      Client.field978 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1135[var0] = true;
      }

      class51.method757();
      Client.field1155 = null;
      class4.clanChatCount = 0;
      class77.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      class214.field2633 = null;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "17142"
   )
   static final String method2877(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + WorldMapData.method337('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + WorldMapData.method337(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + WorldMapData.method337(16776960) + var1 + "</col>");
   }
}
