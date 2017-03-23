import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("h")
   @Export("name")
   String name;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1186832055
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 17028789
   )
   @Export("id")
   int id;
   @ObfuscatedName("r")
   @Export("sender")
   String sender;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -259683925
   )
   @Export("type")
   int type;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -303716585
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 1970239387
   )
   static int field245;
   @ObfuscatedName("o")
   @Export("value")
   String value;
   @ObfuscatedName("an")
   static int[] field249;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 1095006045
   )
   static int field250;
   @ObfuscatedName("ew")
   static SpritePixels[] field251;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "84"
   )
   void method190(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field953 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field953 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-112"
   )
   static int method194(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method932();
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1656328602"
   )
   static final void method195(int var0, int var1, int var2, int var3, int var4) {
      int var5 = CombatInfo1.region.method1762(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var20;
      if(var5 != 0) {
         var6 = CombatInfo1.region.method1766(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = CombatInfo1.field686.image;
         var11 = 4 * var1 + 24624 + 2048 * (103 - var2);
         var20 = var5 >> 14 & 32767;
         ObjectComposition var13 = class140.getObjectDefinition(var20);
         if(var13.mapSceneId != -1) {
            ModIcon var14 = class5.field47[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method4088(var15 + 4 * var1 + 48, 48 + 4 * (104 - var2 - var13.sizeY) + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = CombatInfo1.region.method1774(var0, var1, var2);
      if(var5 != 0) {
         var6 = CombatInfo1.region.method1766(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class140.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            ModIcon var19 = class5.field47[var23.mapSceneId];
            if(var19 != null) {
               var20 = (var23.sizeX * 4 - var19.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var19.height) / 2;
               var19.method4088(var20 + var1 * 4 + 48, 4 * (104 - var2 - var23.sizeY) + 48 + var18);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var12 = CombatInfo1.field686.image;
            var18 = var1 * 4 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var12[var18] = var11;
               var12[512 + var18 + 1] = var11;
               var12[var18 + 1024 + 2] = var11;
               var12[3 + var18 + 1536] = var11;
            } else {
               var12[1536 + var18] = var11;
               var12[1024 + var18 + 1] = var11;
               var12[var18 + 512 + 2] = var11;
               var12[var18 + 3] = var11;
            }
         }
      }

      var5 = CombatInfo1.region.method1845(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var17 = class140.getObjectDefinition(var6);
         if(var17.mapSceneId != -1) {
            ModIcon var21 = class5.field47[var17.mapSceneId];
            if(null != var21) {
               var9 = (var17.sizeX * 4 - var21.originalWidth) / 2;
               int var22 = (var17.sizeY * 4 - var21.height) / 2;
               var21.method4088(48 + var1 * 4 + var9, var22 + (104 - var2 - var17.sizeY) * 4 + 48);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIIII[LCollisionData;I)V",
      garbageValue = "-329390505"
   )
   static final void method196(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var1 + var7 < 103 && var2 + var8 > 0 && var2 + var8 < 103) {
                  var5[var6].flags[var1 + var7][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               TextureProvider.method1489(var10, var7, var1 + var8, var2 + var9, var3, var4, 0);
            }
         }
      }

   }
}
