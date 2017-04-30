import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class159 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1626092593
   )
   public static int field2063;
   @ObfuscatedName("c")
   public static IndexDataBase field2064;
   @ObfuscatedName("q")
   public static class160 field2066;
   @ObfuscatedName("p")
   public static IndexDataBase field2067;
   @ObfuscatedName("d")
   public static IndexDataBase field2068;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -6522457
   )
   public static int field2069;
   @ObfuscatedName("n")
   public static IndexDataBase field2070;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 182014711
   )
   static int field2071;

   static {
      field2063 = 0;
   }

   class159() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-695743340"
   )
   static final void method2905(Widget var0, int var1, int var2, int var3) {
      GameEngine.method2201();
      class166 var4 = var0.method3211(false);
      if(var4 != null) {
         Rasterizer2D.method4083(var1, var2, var1 + var4.field2167, var2 + var4.field2165);
         if(Client.field522 != 2 && Client.field522 != 5) {
            int var5 = Client.mapScale + Client.mapAngle & 2047;
            int var6 = class22.localPlayer.x / 32 + 48;
            int var7 = 464 - class22.localPlayer.y / 32;
            ISAACCipher.field2000.method4257(var1, var2, var4.field2167, var4.field2165, var6, var7, var5, Client.mapScaleDelta + 256, var4.field2166, var4.field2164);

            int var8;
            int var9;
            int var17;
            for(var8 = 0; var8 < Client.field516; ++var8) {
               var9 = Client.field505[var8] * 4 + 2 - class22.localPlayer.x / 32;
               var17 = Client.field518[var8] * 4 + 2 - class22.localPlayer.y / 32;
               class39.method772(var1, var2, var9, var17, Client.field570[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var10 = Client.groundItemDeque[Client.plane][var8][var9];
                  if(var10 != null) {
                     var11 = var8 * 4 + 2 - class22.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class22.localPlayer.y / 32;
                     class39.method772(var1, var2, var11, var12, class49.field956[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field321; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.field350[var8]];
               if(var18 != null && var18.vmethod737()) {
                  NPCComposition var20 = var18.composition;
                  if(var20 != null && var20.configs != null) {
                     var20 = var20.method3804();
                  }

                  if(var20 != null && var20.isMinimapVisible && var20.field3061) {
                     var11 = var18.x / 32 - class22.localPlayer.x / 32;
                     var12 = var18.y / 32 - class22.localPlayer.y / 32;
                     class39.method772(var1, var2, var11, var12, class49.field956[1], var4);
                  }
               }
            }

            var8 = class45.field891;
            int[] var24 = class45.field894;

            for(var17 = 0; var17 < var8; ++var17) {
               Player var19 = Client.cachedPlayers[var24[var17]];
               if(var19 != null && var19.vmethod737() && !var19.field263 && class22.localPlayer != var19) {
                  var12 = var19.x / 32 - class22.localPlayer.x / 32;
                  int var13 = var19.y / 32 - class22.localPlayer.y / 32;
                  boolean var14 = false;
                  if(WidgetNode.method199(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class85.clanChatCount; ++var16) {
                     if(var19.name.equals(Client.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var23 = false;
                  if(class22.localPlayer.team != 0 && var19.team != 0 && var19.team == class22.localPlayer.team) {
                     var23 = true;
                  }

                  if(var14) {
                     class39.method772(var1, var2, var12, var13, class49.field956[3], var4);
                  } else if(var23) {
                     class39.method772(var1, var2, var12, var13, class49.field956[4], var4);
                  } else if(var15) {
                     class39.method772(var1, var2, var12, var13, class49.field956[5], var4);
                  } else {
                     class39.method772(var1, var2, var12, var13, class49.field956[2], var4);
                  }
               }
            }

            if(Client.field298 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field298 == 1 && Client.field299 >= 0 && Client.field299 < Client.cachedNPCs.length) {
                  NPC var21 = Client.cachedNPCs[Client.field299];
                  if(var21 != null) {
                     var11 = var21.x / 32 - class22.localPlayer.x / 32;
                     var12 = var21.y / 32 - class22.localPlayer.y / 32;
                     class38.method765(var1, var2, var11, var12, class5.field50[1], var4);
                  }
               }

               if(Client.field298 == 2) {
                  var17 = Client.field301 * 4 - class108.baseX * 4 + 2 - class22.localPlayer.x / 32;
                  var11 = Client.field302 * 4 - GameEngine.baseY * 4 + 2 - class22.localPlayer.y / 32;
                  class38.method765(var1, var2, var17, var11, class5.field50[1], var4);
               }

               if(Client.field298 == 10 && Client.field300 >= 0 && Client.field300 < Client.cachedPlayers.length) {
                  Player var22 = Client.cachedPlayers[Client.field300];
                  if(var22 != null) {
                     var11 = var22.x / 32 - class22.localPlayer.x / 32;
                     var12 = var22.y / 32 - class22.localPlayer.y / 32;
                     class38.method765(var1, var2, var11, var12, class5.field50[1], var4);
                  }
               }
            }

            if(Client.flagX != 0) {
               var17 = Client.flagX * 4 + 2 - class22.localPlayer.x / 32;
               var11 = Client.flagY * 4 + 2 - class22.localPlayer.y / 32;
               class39.method772(var1, var2, var17, var11, class5.field50[0], var4);
            }

            if(!class22.localPlayer.field263) {
               Rasterizer2D.method4089(var4.field2167 / 2 + var1 - 1, var2 + var4.field2165 / 2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method4126(var1, var2, 0, var4.field2166, var4.field2164);
         }

         Client.field491[var3] = true;
      }
   }
}
