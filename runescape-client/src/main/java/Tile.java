import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1935665965
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1442300261
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   boolean field1329;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1154265393
   )
   int field1330;
   @ObfuscatedName("f")
   class85 field1331;
   @ObfuscatedName("c")
   class77 field1332;
   @ObfuscatedName("q")
   int[] field1333 = new int[5];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1291966217
   )
   int field1334;
   @ObfuscatedName("g")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("z")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 216730305
   )
   int field1337;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1451425087
   )
   int field1338;
   @ObfuscatedName("d")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1358608083
   )
   int field1340 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1302850227
   )
   int field1341;
   @ObfuscatedName("m")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("p")
   boolean field1343;
   @ObfuscatedName("k")
   boolean field1344;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1114724191
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("l")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 51532031
   )
   int field1348;
   @ObfuscatedName("w")
   Tile field1349;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1767976545
   )
   static int field1351;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1843166337
   )
   int field1353;
   @ObfuscatedName("dw")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1587144562"
   )
   static final void method1511(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field653 == 0) {
         var0.field657 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = CombatInfo2.getAnimation(var0.animation);
            if(var0.field658 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field657;
               return;
            }

            if(var0.field658 <= 0 && var1.priority == 0) {
               ++var0.field657;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field603 * 64 + 128 * var0.pathX[var0.field653 - 1];
         int var4 = var0.field603 * 64 + 128 * var0.pathY[var0.field653 - 1];
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field650 = 1280;
            } else if(var2 > var4) {
               var0.field650 = 1792;
            } else {
               var0.field650 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field650 = 768;
            } else if(var2 > var4) {
               var0.field650 = 256;
            } else {
               var0.field650 = 512;
            }
         } else if(var2 < var4) {
            var0.field650 = 1024;
         } else if(var2 > var4) {
            var0.field650 = 0;
         }

         byte var5 = var0.field656[var0.field653 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field650 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field608;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field607;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field614;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field639;
            }

            if(var7 == -1) {
               var7 = var0.field607;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.field650 != var0.angle && var0.interacting == -1 && var0.field616 != 0) {
                  var8 = 2;
               }

               if(var0.field653 > 2) {
                  var8 = 6;
               }

               if(var0.field653 > 3) {
                  var8 = 8;
               }

               if(var0.field657 > 0 && var0.field653 > 1) {
                  var8 = 8;
                  --var0.field657;
               }
            } else {
               if(var0.field653 > 1) {
                  var8 = 6;
               }

               if(var0.field653 > 2) {
                  var8 = 8;
               }

               if(var0.field657 > 0 && var0.field653 > 1) {
                  var8 = 8;
                  --var0.field657;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field607 == var0.poseAnimation && var0.field622 != -1) {
               var0.poseAnimation = var0.field622;
            }

            if(var10 != var3 || var2 != var4) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var0.x == var3 && var0.y == var4) {
               --var0.field653;
               if(var0.field658 > 0) {
                  --var0.field658;
               }
            }
         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field653;
            if(var0.field658 > 0) {
               --var0.field658;
            }
         }
      }

   }

   Tile(int var1, int var2, int var3) {
      this.field1330 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-853609796"
   )
   static final void method1512() {
      class109.method2005();
      class176.method3242();
      class47.method866();
      ObjectComposition.field2904.reset();
      ObjectComposition.field2929.reset();
      ObjectComposition.field2884.reset();
      ObjectComposition.field2908.reset();
      CombatInfoListHolder.method714();
      class137.method2460();
      Sequence.field3044.reset();
      Sequence.field3040.reset();
      class190.field2768.reset();
      class190.field2769.reset();
      class5.method79();
      class187.field2752.reset();
      class196.field2854.reset();
      class196.spriteCache.reset();
      class196.field2856.reset();
      CombatInfo2.field2815.reset();
      CombatInfo2.field2824.reset();
      class72.method1362();
      class99.method1898();
      ((TextureProvider)class84.field1434).method1391();
      class48.field929.reset();
      class5.field46.method3275();
      class11.field120.method3275();
      Client.field349.method3275();
      class10.field94.method3275();
      Client.field563.method3275();
      class37.field781.method3275();
      Client.field314.method3275();
      class0.field4.method3275();
      class5.field49.method3275();
      ChatLineBuffer.field956.method3275();
      class162.field2136.method3275();
      class137.field1898.method3275();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-879614425"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2904.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2881.method3272(6, var0);
         var1 = new ObjectComposition();
         var1.field2887 = var0;
         if(var2 != null) {
            var1.method3594(new Buffer(var2));
         }

         var1.method3600();
         if(var1.isSolid) {
            var1.field2923 = 0;
            var1.field2898 = false;
         }

         ObjectComposition.field2904.put(var1, (long)var0);
         return var1;
      }
   }
}
