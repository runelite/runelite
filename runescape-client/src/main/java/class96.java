import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class96 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 663835441
   )
   static int field1502;
   @ObfuscatedName("v")
   static byte[] field1503;
   @ObfuscatedName("e")
   static byte[] field1504;
   @ObfuscatedName("b")
   static Buffer[] field1506;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1618685777
   )
   static int field1507;
   @ObfuscatedName("h")
   static int[] field1508;
   @ObfuscatedName("n")
   static int[] field1511;
   @ObfuscatedName("a")
   static int[] field1512;
   @ObfuscatedName("o")
   static int[] field1513;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 903148295
   )
   static int field1514;
   @ObfuscatedName("f")
   static int[] field1515;
   @ObfuscatedName("j")
   static Buffer field1516;
   @ObfuscatedName("q")
   static int[] field1517;

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1331693355"
   )
   static final void method1763(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field1263 == 0) {
         var0.field1300 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class227.getAnimation(var0.animation);
            if(var0.field1301 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1300;
               return;
            }

            if(var0.field1301 <= 0 && var1.priority == 0) {
               ++var0.field1300;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.field1263 - 1] * 128 + var0.field1268 * 64;
         int var4 = var0.pathY[var0.field1263 - 1] * 128 + var0.field1268 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field1259 = 1280;
            } else if(var2 > var4) {
               var0.field1259 = 1792;
            } else {
               var0.field1259 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field1259 = 768;
            } else if(var2 > var4) {
               var0.field1259 = 256;
            } else {
               var0.field1259 = 512;
            }
         } else if(var2 < var4) {
            var0.field1259 = 1024;
         } else if(var2 > var4) {
            var0.field1259 = 0;
         }

         byte var5 = var0.field1257[var0.field1263 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field1259 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field1299;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1242;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1253;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1288;
            }

            if(var7 == -1) {
               var7 = var0.field1242;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.field1259 && var0.interacting == -1 && var0.field1295 != 0) {
                  var8 = 2;
               }

               if(var0.field1263 > 2) {
                  var8 = 6;
               }

               if(var0.field1263 > 3) {
                  var8 = 8;
               }

               if(var0.field1300 > 0 && var0.field1263 > 1) {
                  var8 = 8;
                  --var0.field1300;
               }
            } else {
               if(var0.field1263 > 1) {
                  var8 = 6;
               }

               if(var0.field1263 > 2) {
                  var8 = 8;
               }

               if(var0.field1300 > 0 && var0.field1263 > 1) {
                  var8 = 8;
                  --var0.field1300;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field1242 == var0.poseAnimation && var0.field1254 != -1) {
               var0.poseAnimation = var0.field1254;
            }

            if(var10 != var3 || var4 != var2) {
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
               --var0.field1263;
               if(var0.field1301 > 0) {
                  --var0.field1301;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field1263;
            if(var0.field1301 > 0) {
               --var0.field1301;
            }

         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2096374097"
   )
   public static void method1764() {
      class254.field3409.reset();
      class254.field3410.reset();
      class254.field3420.reset();
   }

   static {
      field1504 = new byte[2048];
      field1503 = new byte[2048];
      field1506 = new Buffer[2048];
      field1507 = 0;
      field1508 = new int[2048];
      field1502 = 0;
      field1515 = new int[2048];
      field1511 = new int[2048];
      field1512 = new int[2048];
      field1513 = new int[2048];
      field1514 = 0;
      field1517 = new int[2048];
      field1516 = new Buffer(new byte[5000]);
   }
}
