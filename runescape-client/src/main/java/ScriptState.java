import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("i")
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("u")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1000208797
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("q")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "-1563932071"
   )
   static final void method1079(PacketBuffer var0) {
      int var1 = 0;
      var0.method3469();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class96.field1489; ++var2) {
         var3 = class96.field1496[var2];
         if((class96.field1484[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
            } else {
               var4 = var0.method3470(1);
               if(var4 == 0) {
                  var1 = Overlay.method4747(var0);
                  class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
               } else {
                  class257.method4698(var0, var3);
               }
            }
         }
      }

      var0.method3466();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method3469();

         for(var2 = 0; var2 < class96.field1489; ++var2) {
            var3 = class96.field1496[var2];
            if((class96.field1484[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
               } else {
                  var4 = var0.method3470(1);
                  if(var4 == 0) {
                     var1 = Overlay.method4747(var0);
                     class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
                  } else {
                     class257.method4698(var0, var3);
                  }
               }
            }
         }

         var0.method3466();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method3469();

            for(var2 = 0; var2 < class96.field1499; ++var2) {
               var3 = class96.field1490[var2];
               if((class96.field1484[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
                  } else {
                     var4 = var0.method3470(1);
                     if(var4 == 0) {
                        var1 = Overlay.method4747(var0);
                        class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
                     } else if(Player.method1166(var0, var3)) {
                        class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
                     }
                  }
               }
            }

            var0.method3466();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method3469();

               for(var2 = 0; var2 < class96.field1499; ++var2) {
                  var3 = class96.field1490[var2];
                  if((class96.field1484[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
                     } else {
                        var4 = var0.method3470(1);
                        if(var4 == 0) {
                           var1 = Overlay.method4747(var0);
                           class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
                        } else if(Player.method1166(var0, var3)) {
                           class96.field1484[var3] = (byte)(class96.field1484[var3] | 2);
                        }
                     }
                  }
               }

               var0.method3466();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class96.field1489 = 0;
                  class96.field1499 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class96.field1484[var2] = (byte)(class96.field1484[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class96.field1496[++class96.field1489 - 1] = var2;
                     } else {
                        class96.field1490[++class96.field1499 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "9"
   )
   static final void method1080(Actor var0) {
      if(Client.gameCycle == var0.field1224 || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1220 + 1 > class165.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1224 - var0.field1244;
         int var2 = Client.gameCycle - var0.field1244;
         int var3 = var0.field1198 * 128 + var0.field1202 * 64;
         int var4 = var0.field1242 * 128 + var0.field1202 * 64;
         int var5 = var0.field1225 * 128 + var0.field1202 * 64;
         int var6 = var0.field1243 * 128 + var0.field1202 * 64;
         var0.x = (var2 * var5 + (var1 - var2) * var3) / var1;
         var0.y = (var4 * (var1 - var2) + var2 * var6) / var1;
      }

      var0.field1257 = 0;
      var0.field1247 = var0.field1201;
      var0.angle = var0.field1247;
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "121"
   )
   static final void method1081(int var0, int var1, boolean var2) {
      if(!var2 || class51.field646 != var0 || DecorativeObject.field2158 != var1) {
         class51.field646 = var0;
         DecorativeObject.field2158 = var1;
         class12.setGameState(25);
         class32.method349("Loading - please wait.", true);
         int var3 = class166.baseX;
         int var4 = class146.baseY;
         class166.baseX = (var0 - 6) * 8;
         class146.baseY = (var1 - 6) * 8;
         int var5 = class166.baseX - var3;
         int var6 = class146.baseY - var4;
         var3 = class166.baseX;
         var4 = class146.baseY;

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
         for(int var18 = var20; var18 != var19; var18 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var5 + var18;
               int var16 = var6 + var14;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var18][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var18][var14] = null;
                  }
               }
            }
         }

         for(class76 var13 = (class76)Client.field1021.method3660(); var13 != null; var13 = (class76)Client.field1021.method3661()) {
            var13.field1176 -= var5;
            var13.field1177 -= var6;
            if(var13.field1176 < 0 || var13.field1177 < 0 || var13.field1176 >= 104 || var13.field1177 >= 104) {
               var13.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var5;
            Client.flagY -= var6;
         }

         Client.field1131 = 0;
         Client.field929 = false;
         Client.field1117 = -1;
         Client.field1023.method3656();
         Client.projectiles.method3656();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].method3073();
         }

      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2206"
   )
   static final void method1082() {
      for(class76 var0 = (class76)Client.field1021.method3660(); var0 != null; var0 = (class76)Client.field1021.method3661()) {
         if(var0.field1185 > 0) {
            --var0.field1185;
         }

         if(var0.field1185 == 0) {
            if(var0.field1178 < 0 || Preferences.method1593(var0.field1178, var0.field1180)) {
               class154.method2992(var0.field1174, var0.field1181, var0.field1176, var0.field1177, var0.field1178, var0.field1179, var0.field1180);
               var0.unlink();
            }
         } else {
            if(var0.field1184 > 0) {
               --var0.field1184;
            }

            if(var0.field1184 == 0 && var0.field1176 >= 1 && var0.field1177 >= 1 && var0.field1176 <= 102 && var0.field1177 <= 102 && (var0.field1175 < 0 || Preferences.method1593(var0.field1175, var0.field1183))) {
               class154.method2992(var0.field1174, var0.field1181, var0.field1176, var0.field1177, var0.field1175, var0.field1182, var0.field1183);
               var0.field1184 = -1;
               if(var0.field1178 == var0.field1175 && var0.field1178 == -1) {
                  var0.unlink();
               } else if(var0.field1175 == var0.field1178 && var0.field1182 == var0.field1179 && var0.field1180 == var0.field1183) {
                  var0.unlink();
               }
            }
         }
      }

   }

   ScriptState() {
      this.invokedFromPc = -1;
   }
}
