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
      int var10;
      int var11;
      ModIcon var12;
      int var15;
      if(var5 != 0) {
         var6 = CombatInfo1.region.method1766(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var13 = CombatInfo1.field686.image;
         var10 = var1 * 4 + 24624 + (103 - var2) * 2048;
         var11 = var5 >> 14 & 32767;
         ObjectComposition var14 = class140.getObjectDefinition(var11);
         if(var14.mapSceneId != -1) {
            var12 = class5.field47[var14.mapSceneId];
            if(var12 != null) {
               var15 = (var14.sizeX * 4 - var12.originalWidth) / 2;
               int var16 = (var14.sizeY * 4 - var12.height) / 2;
               var12.method4088(var15 + var1 * 4 + 48, (104 - var2 - var14.sizeY) * 4 + 48 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var13[var10] = var9;
                  var13[var10 + 512] = var9;
                  var13[var10 + 1024] = var9;
                  var13[var10 + 1536] = var9;
               } else if(var7 == 1) {
                  var13[var10] = var9;
                  var13[var10 + 1] = var9;
                  var13[var10 + 2] = var9;
                  var13[var10 + 3] = var9;
               } else if(var7 == 2) {
                  var13[var10 + 3] = var9;
                  var13[var10 + 515] = var9;
                  var13[var10 + 1027] = var9;
                  var13[var10 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var13[var10 + 1536] = var9;
                  var13[var10 + 1536 + 1] = var9;
                  var13[var10 + 2 + 1536] = var9;
                  var13[var10 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var13[var10] = var9;
               } else if(var7 == 1) {
                  var13[var10 + 3] = var9;
               } else if(var7 == 2) {
                  var13[var10 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var13[var10 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var13[var10] = var9;
                  var13[var10 + 512] = var9;
                  var13[var10 + 1024] = var9;
                  var13[var10 + 1536] = var9;
               } else if(var7 == 0) {
                  var13[var10] = var9;
                  var13[var10 + 1] = var9;
                  var13[var10 + 2] = var9;
                  var13[var10 + 3] = var9;
               } else if(var7 == 1) {
                  var13[var10 + 3] = var9;
                  var13[var10 + 512 + 3] = var9;
                  var13[var10 + 3 + 1024] = var9;
                  var13[var10 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var13[var10 + 1536] = var9;
                  var13[var10 + 1537] = var9;
                  var13[var10 + 1536 + 2] = var9;
                  var13[var10 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = CombatInfo1.region.method1774(var0, var1, var2);
      ObjectComposition var17;
      if(var5 != 0) {
         var6 = CombatInfo1.region.method1766(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         var17 = class140.getObjectDefinition(var9);
         int var18;
         if(var17.mapSceneId != -1) {
            var12 = class5.field47[var17.mapSceneId];
            if(var12 != null) {
               var11 = (var17.sizeX * 4 - var12.originalWidth) / 2;
               var18 = (var17.sizeY * 4 - var12.height) / 2;
               var12.method4088(var11 + var1 * 4 + 48, (104 - var2 - var17.sizeY) * 4 + 48 + var18);
            }
         } else if(var8 == 9) {
            var10 = 15658734;
            if(var5 > 0) {
               var10 = 15597568;
            }

            int[] var20 = CombatInfo1.field686.image;
            var18 = var1 * 4 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var20[var18] = var10;
               var20[var18 + 512 + 1] = var10;
               var20[var18 + 1024 + 2] = var10;
               var20[var18 + 3 + 1536] = var10;
            } else {
               var20[var18 + 1536] = var10;
               var20[var18 + 1024 + 1] = var10;
               var20[var18 + 512 + 2] = var10;
               var20[var18 + 3] = var10;
            }
         }
      }

      var5 = CombatInfo1.region.method1845(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         var17 = class140.getObjectDefinition(var6);
         if(var17.mapSceneId != -1) {
            ModIcon var19 = class5.field47[var17.mapSceneId];
            if(var19 != null) {
               var9 = (var17.sizeX * 4 - var19.originalWidth) / 2;
               var15 = (var17.sizeY * 4 - var19.height) / 2;
               var19.method4088(var1 * 4 + 48 + var9, var15 + (104 - var2 - var17.sizeY) * 4 + 48);
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
      int var6;
      int var7;
      for(int var8 = 0; var8 < 4; ++var8) {
         for(var6 = 0; var6 < 64; ++var6) {
            for(var7 = 0; var7 < 64; ++var7) {
               if(var6 + var1 > 0 && var1 + var6 < 103 && var2 + var7 > 0 && var2 + var7 < 103) {
                  var5[var8].flags[var1 + var6][var7 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(int var9 = 0; var9 < 64; ++var9) {
               TextureProvider.method1489(var10, var6, var1 + var7, var2 + var9, var3, var4, 0);
            }
         }
      }

   }
}
