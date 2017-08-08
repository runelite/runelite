import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1411628963
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1556850243
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 195489755
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1060828861
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 907734159
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -608650325
   )
   @Export("level")
   int level;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1351760967
   )
   int field1189;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -675626221
   )
   int field1191;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -764664903
   )
   @Export("type")
   int type;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1519639227
   )
   int field1202;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -536941951
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 109325971
   )
   int field1194;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 425422365
   )
   @Export("orientation")
   int orientation;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lbl;I)V",
      garbageValue = "-2043604273"
   )
   public static void method1525(ScriptEvent var0) {
      class8.method40(var0, 200000);
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "509515639"
   )
   static final void method1523() {
      class2.method0();
      class45.method654();
      KitDefinition.identKits.reset();
      ObjectComposition.objects.reset();
      ObjectComposition.field3437.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3466.reset();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      GraphicsObject.method1689();
      class27.method217();
      class215.method3988();
      class218.method4055();
      class255.field3419.reset();
      class255.field3405.reset();
      class255.field3406.reset();
      class51.method768();
      class206.method3818();
      class18.method142();
      Area.skeletonsIndex.reset();
      PlayerComposition.field2596.reset();
      Widget.field2617.reset();
      Widget.field2656.reset();
      Widget.field2619.reset();
      Widget.field2694.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1525.reset();
      class64.indexInterfaces.reset();
      class291.indexSoundEffects.reset();
      KitDefinition.field3353.reset();
      CombatInfo1.field1272.reset();
      class158.indexMaps.reset();
      class244.indexTrack1.reset();
      class19.indexModels.reset();
      WorldMapType1.indexSprites.reset();
      class61.indexTextures.reset();
      Ignore.field855.reset();
      class33.indexTrack2.reset();
      class253.indexScripts.reset();
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(Lcp;II)V",
      garbageValue = "-916657364"
   )
   static final void method1524(Actor var0, int var1) {
      int var3;
      int var4;
      int var11;
      if(var0.field1238 > Client.gameCycle) {
         class9.method43(var0);
      } else if(var0.field1252 >= Client.gameCycle) {
         class61.method1051(var0);
      } else {
         var0.poseAnimation = var0.idlePoseAnimation;
         if(var0.queueSize == 0) {
            var0.field1263 = 0;
         } else {
            label408: {
               if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                  Sequence var2 = Ignore.getAnimation(var0.animation);
                  if(var0.field1264 > 0 && var2.precedenceAnimating == 0) {
                     ++var0.field1263;
                     break label408;
                  }

                  if(var0.field1264 <= 0 && var2.priority == 0) {
                     ++var0.field1263;
                     break label408;
                  }
               }

               var11 = var0.x;
               var3 = var0.y;
               var4 = var0.field1254 * 64 + var0.pathX[var0.queueSize - 1] * 128;
               int var5 = var0.field1254 * 64 + var0.pathY[var0.queueSize - 1] * 128;
               if(var11 < var4) {
                  if(var3 < var5) {
                     var0.orientation = 1280;
                  } else if(var3 > var5) {
                     var0.orientation = 1792;
                  } else {
                     var0.orientation = 1536;
                  }
               } else if(var11 > var4) {
                  if(var3 < var5) {
                     var0.orientation = 768;
                  } else if(var3 > var5) {
                     var0.orientation = 256;
                  } else {
                     var0.orientation = 512;
                  }
               } else if(var3 < var5) {
                  var0.orientation = 1024;
               } else if(var3 > var5) {
                  var0.orientation = 0;
               }

               byte var6 = var0.field1262[var0.queueSize - 1];
               if(var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.orientation - var0.angle & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field1214;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field1241;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field1211;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field1249;
                  }

                  if(var8 == -1) {
                     var8 = var0.field1241;
                  }

                  var0.poseAnimation = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof NPC) {
                     var10 = ((NPC)var0).composition.isClickable;
                  }

                  if(var10) {
                     if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1229 != 0) {
                        var9 = 2;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 3) {
                        var9 = 8;
                     }

                     if(var0.field1263 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1263;
                     }
                  } else {
                     if(var0.queueSize > 1) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 8;
                     }

                     if(var0.field1263 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1263;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.poseAnimation == var0.field1241 && var0.field1256 != -1) {
                     var0.poseAnimation = var0.field1256;
                  }

                  if(var4 != var11 || var3 != var5) {
                     if(var11 < var4) {
                        var0.x += var9;
                        if(var0.x > var4) {
                           var0.x = var4;
                        }
                     } else if(var11 > var4) {
                        var0.x -= var9;
                        if(var0.x < var4) {
                           var0.x = var4;
                        }
                     }

                     if(var3 < var5) {
                        var0.y += var9;
                        if(var0.y > var5) {
                           var0.y = var5;
                        }
                     } else if(var3 > var5) {
                        var0.y -= var9;
                        if(var0.y < var5) {
                           var0.y = var5;
                        }
                     }
                  }

                  if(var4 == var0.x && var5 == var0.y) {
                     --var0.queueSize;
                     if(var0.field1264 > 0) {
                        --var0.field1264;
                     }
                  }
               } else {
                  var0.x = var4;
                  var0.y = var5;
                  --var0.queueSize;
                  if(var0.field1264 > 0) {
                     --var0.field1264;
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1238 = 0;
         var0.field1252 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1254 * 64;
         var0.y = var0.field1254 * 64 + var0.pathY[0] * 128;
         var0.method1532();
      }

      if(class54.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1238 = 0;
         var0.field1252 = 0;
         var0.x = var0.field1254 * 64 + var0.pathX[0] * 128;
         var0.y = var0.pathY[0] * 128 + var0.field1254 * 64;
         var0.method1532();
      }

      if(var0.field1229 != 0) {
         if(var0.interacting != -1) {
            Object var13 = null;
            if(var0.interacting < '耀') {
               var13 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var13 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var13 != null) {
               var3 = var0.x - ((Actor)var13).x;
               var4 = var0.y - ((Actor)var13).y;
               if(var3 != 0 || var4 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1242) {
               var0.interacting = -1;
               var0.field1242 = false;
            }
         }

         if(var0.field1205 != -1 && (var0.queueSize == 0 || var0.field1263 > 0)) {
            var0.orientation = var0.field1205;
            var0.field1205 = -1;
         }

         var11 = var0.orientation - var0.angle & 2047;
         if(var11 == 0 && var0.field1242) {
            var0.interacting = -1;
            var0.field1242 = false;
         }

         if(var11 != 0) {
            ++var0.field1257;
            boolean var14;
            if(var11 > 1024) {
               var0.angle -= var0.field1229;
               var14 = true;
               if(var11 < var0.field1229 || var11 > 2048 - var0.field1229) {
                  var0.angle = var0.orientation;
                  var14 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1257 > 25 || var14)) {
                  if(var0.field1227 != -1) {
                     var0.poseAnimation = var0.field1227;
                  } else {
                     var0.poseAnimation = var0.field1241;
                  }
               }
            } else {
               var0.angle += var0.field1229;
               var14 = true;
               if(var11 < var0.field1229 || var11 > 2048 - var0.field1229) {
                  var0.angle = var0.orientation;
                  var14 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1257 > 25 || var14)) {
                  if(var0.field1212 != -1) {
                     var0.poseAnimation = var0.field1212;
                  } else {
                     var0.poseAnimation = var0.field1241;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1257 = 0;
         }
      }

      class245.method4333(var0);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lcq;Lcq;IZI)I",
      garbageValue = "-1667512373"
   )
   static int method1522(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1553()?(var1.method1553()?0:1):(var1.method1553()?-1:0)):(var2 == 5?(var0.method1582()?(var1.method1582()?0:1):(var1.method1582()?-1:0)):(var2 == 6?(var0.method1552()?(var1.method1552()?0:1):(var1.method1552()?-1:0)):(var2 == 7?(var0.method1550()?(var1.method1550()?0:1):(var1.method1550()?-1:0)):var0.id - var1.id)))));
      }
   }
}
