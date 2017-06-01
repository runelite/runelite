import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public final class class76 extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1416466631
   )
   int field1215;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 464173719
   )
   int field1216;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1914115077
   )
   int field1217;
   @ObfuscatedName("p")
   public static String field1218;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 324146797
   )
   int field1219;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -8690471
   )
   int field1220;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 233504701
   )
   int field1221;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1139167161
   )
   int field1222;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1028761243
   )
   int field1223;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1763963759
   )
   int field1224;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1015995275
   )
   int field1225;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 174674079
   )
   int field1226;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -341903039
   )
   int field1227;

   class76() {
      this.field1219 = 0;
      this.field1226 = -1;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-323410698"
   )
   static final void method1505(Widget var0, int var1, int var2, int var3) {
      WidgetNode.method1084();
      class210 var4 = var0.method3987(false);
      if(var4 != null) {
         Rasterizer2D.method4940(var1, var2, var1 + var4.field2602, var2 + var4.field2601);
         if(Client.field1170 != 2 && Client.field1170 != 5) {
            int var5 = Client.mapScale + Client.mapAngle & 2047;
            int var6 = World.localPlayer.x / 32 + 48;
            int var7 = 464 - World.localPlayer.y / 32;
            class41.field564.method5057(var1, var2, var4.field2602, var4.field2601, var6, var7, var5, Client.mapScaleDelta + 256, var4.field2603, var4.field2605);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1158; ++var8) {
               var9 = Client.field1075[var8] * 4 + 2 - World.localPlayer.x / 32;
               var10 = Client.field1160[var8] * 4 + 2 - World.localPlayer.y / 32;
               class22.method149(var1, var2, var9, var10, Client.field1110[var8], var4);
            }

            int var12;
            int var19;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[FaceNormal.plane][var8][var9];
                  if(var17 != null) {
                     var19 = var8 * 4 + 2 - World.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - World.localPlayer.y / 32;
                     class22.method149(var1, var2, var19, var12, Client.field1212[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field968; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.field950[var8]];
               if(var18 != null && var18.vmethod1691()) {
                  NPCComposition var21 = var18.composition;
                  if(var21 != null && var21.configs != null) {
                     var21 = var21.method4652();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field3559) {
                     var19 = var18.x / 32 - World.localPlayer.x / 32;
                     var12 = var18.y / 32 - World.localPlayer.y / 32;
                     class22.method149(var1, var2, var19, var12, Client.field1212[1], var4);
                  }
               }
            }

            var8 = class96.field1507;
            int[] var22 = class96.field1508;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var11 = Client.cachedPlayers[var22[var10]];
               if(var11 != null && var11.vmethod1691() && !var11.field913 && World.localPlayer != var11) {
                  var12 = var11.x / 32 - World.localPlayer.x / 32;
                  int var13 = var11.y / 32 - World.localPlayer.y / 32;
                  boolean var14 = false;
                  if(Projectile.method1749(var11.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class4.clanChatCount; ++var16) {
                     if(var11.name.equals(class77.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(World.localPlayer.team != 0 && var11.team != 0 && World.localPlayer.team == var11.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class22.method149(var1, var2, var12, var13, Client.field1212[3], var4);
                  } else if(var20) {
                     class22.method149(var1, var2, var12, var13, Client.field1212[4], var4);
                  } else if(var15) {
                     class22.method149(var1, var2, var12, var13, Client.field1212[5], var4);
                  } else {
                     class22.method149(var1, var2, var12, var13, Client.field1212[2], var4);
                  }
               }
            }

            if(Client.field945 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field945 == 1 && Client.field946 >= 0 && Client.field946 < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.field946];
                  if(var23 != null) {
                     var19 = var23.x / 32 - World.localPlayer.x / 32;
                     var12 = var23.y / 32 - World.localPlayer.y / 32;
                     class208.method3889(var1, var2, var19, var12, ScriptState.field782[1], var4);
                  }
               }

               if(Client.field945 == 2) {
                  var10 = Client.field948 * 4 - class41.baseX * 4 + 2 - World.localPlayer.x / 32;
                  var19 = Client.field949 * 4 - WorldMapType3.baseY * 4 + 2 - World.localPlayer.y / 32;
                  class208.method3889(var1, var2, var10, var19, ScriptState.field782[1], var4);
               }

               if(Client.field945 == 10 && Client.field947 >= 0 && Client.field947 < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.field947];
                  if(var24 != null) {
                     var19 = var24.x / 32 - World.localPlayer.x / 32;
                     var12 = var24.y / 32 - World.localPlayer.y / 32;
                     class208.method3889(var1, var2, var19, var12, ScriptState.field782[1], var4);
                  }
               }
            }

            if(Client.flagX != 0) {
               var10 = Client.flagX * 4 + 2 - World.localPlayer.x / 32;
               var19 = Client.flagY * 4 + 2 - World.localPlayer.y / 32;
               class22.method149(var1, var2, var10, var19, ScriptState.field782[0], var4);
            }

            if(!World.localPlayer.field913) {
               Rasterizer2D.method4923(var4.field2602 / 2 + var1 - 1, var2 + var4.field2601 / 2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method4938(var1, var2, 0, var4.field2603, var4.field2605);
         }

         Client.field1136[var3] = true;
      }
   }
}
