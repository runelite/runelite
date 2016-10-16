import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public final class class16 extends Node {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -427017401
   )
   int field207;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2063428351
   )
   int field208;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1268836669
   )
   int field209;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -459181671
   )
   int field210 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -566833005
   )
   int field211 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1590603213
   )
   int field212;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 129006633
   )
   int field213;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -997830177
   )
   int field214;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1815273091
   )
   int field215;
   @ObfuscatedName("d")
   static int[][][] field216;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 825466841
   )
   int field217;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1462031283
   )
   int field218;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1212127053
   )
   int field221;
   @ObfuscatedName("eh")
   static ModIcon[] field222;

   @ObfuscatedName("s")
   public static final void method185(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            class12.method157(var0 - 1L);
            class12.method157(1L);
         } else {
            class12.method157(var0);
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)Z",
      garbageValue = "-23"
   )
   static boolean method186(class125 var0, int var1) {
      int var2 = var0.method2762(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2762(1) != 0) {
            method186(var0, var1);
         }

         var3 = var0.method2762(6);
         var4 = var0.method2762(6);
         boolean var12 = var0.method2762(1) == 1;
         if(var12) {
            class34.field744[++class34.field750 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field48 = var1;
            if(class34.field742[var1] != null) {
               var6.method7(class34.field742[var1]);
            }

            var6.field852 = class34.field748[var1];
            var6.interacting = class34.field755[var1];
            var7 = class34.field747[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field858[0] = class34.field741[var1];
            var6.field47 = (byte)var8;
            var6.method12(var3 + (var9 << 6) - class23.baseX, (var10 << 6) + var4 - class8.baseY);
            var6.field46 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2762(2);
         var4 = class34.field747[var1];
         class34.field747[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2762(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class34.field747[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class34.field747[var1] = (var7 << 28) + (var8 << 14) + var9;
            return false;
         } else {
            var3 = var0.method2762(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class34.field747[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class34.field747[var1] = (var9 << 14) + (var8 << 28) + var10;
            return false;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;B)V",
      garbageValue = "-117"
   )
   public static void method187(class170 var0, class170 var1) {
      class49.field1049 = var0;
      class49.field1054 = var1;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(LActor;IB)V",
      garbageValue = "-27"
   )
   static final void method188(Actor var0, int var1) {
      if(var0.field847 > Client.gameCycle) {
         class35.method732(var0);
      } else if(var0.field848 >= Client.gameCycle) {
         class48.method962(var0);
      } else {
         Player.method17(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field847 = 0;
         var0.field848 = 0;
         var0.x = var0.field805 * 64 + 128 * var0.pathX[0];
         var0.y = var0.field805 * 64 + 128 * var0.pathY[0];
         var0.method768();
      }

      if(TextureProvider.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field847 = 0;
         var0.field848 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field805 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field805 * 64;
         var0.method768();
      }

      int var5;
      if(var0.field854 != 0) {
         if(var0.interacting != -1) {
            Object var2 = null;
            if(var0.interacting < '耀') {
               var2 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var2 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var2) {
               int var6 = var0.x - ((Actor)var2).x;
               int var4 = var0.y - ((Actor)var2).y;
               if(var6 != 0 || var4 != 0) {
                  var0.field852 = (int)(Math.atan2((double)var6, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field828) {
               var0.interacting = -1;
               var0.field828 = false;
            }
         }

         if(var0.field850 != -1 && (var0.field855 == 0 || var0.field859 > 0)) {
            var0.field852 = var0.field850;
            var0.field850 = -1;
         }

         var5 = var0.field852 - var0.angle & 2047;
         if(var5 == 0 && var0.field828) {
            var0.interacting = -1;
            var0.field828 = false;
         }

         if(var5 != 0) {
            ++var0.field810;
            boolean var8;
            if(var5 > 1024) {
               var0.angle -= var0.field854;
               var8 = true;
               if(var5 < var0.field854 || var5 > 2048 - var0.field854) {
                  var0.angle = var0.field852;
                  var8 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field810 > 25 || var8)) {
                  if(var0.field807 != -1) {
                     var0.poseAnimation = var0.field807;
                  } else {
                     var0.poseAnimation = var0.field813;
                  }
               }
            } else {
               var0.angle += var0.field854;
               var8 = true;
               if(var5 < var0.field854 || var5 > 2048 - var0.field854) {
                  var0.angle = var0.field852;
                  var8 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field810 > 25 || var8)) {
                  if(var0.field806 != -1) {
                     var0.poseAnimation = var0.field806;
                  } else {
                     var0.poseAnimation = var0.field813;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field810 = 0;
         }
      }

      var0.field860 = false;
      Sequence var7;
      if(var0.poseAnimation != -1) {
         var7 = class4.getAnimation(var0.poseAnimation);
         if(null != var7 && null != var7.field969) {
            ++var0.field832;
            if(var0.poseFrame < var7.field969.length && var0.field832 > var7.field981[var0.poseFrame]) {
               var0.field832 = 1;
               ++var0.poseFrame;
               ItemComposition.method1124(var7, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var7.field969.length) {
               var0.field832 = 0;
               var0.poseFrame = 0;
               ItemComposition.method1124(var7, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field853) {
         if(var0.field811 < 0) {
            var0.field811 = 0;
         }

         var5 = class107.method2269(var0.graphic).field991;
         if(var5 != -1) {
            Sequence var3 = class4.getAnimation(var5);
            if(null != var3 && var3.field969 != null) {
               ++var0.field840;
               if(var0.field811 < var3.field969.length && var0.field840 > var3.field981[var0.field811]) {
                  var0.field840 = 1;
                  ++var0.field811;
                  ItemComposition.method1124(var3, var0.field811, var0.x, var0.y);
               }

               if(var0.field811 >= var3.field969.length && (var0.field811 < 0 || var0.field811 >= var3.field969.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var7 = class4.getAnimation(var0.animation);
         if(var7.precedenceAnimating == 1 && var0.field821 > 0 && var0.field847 <= Client.gameCycle && var0.field848 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var7 = class4.getAnimation(var0.animation);
         if(var7 != null && var7.field969 != null) {
            ++var0.field835;
            if(var0.actionFrame < var7.field969.length && var0.field835 > var7.field981[var0.actionFrame]) {
               var0.field835 = 1;
               ++var0.actionFrame;
               ItemComposition.method1124(var7, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var7.field969.length) {
               var0.actionFrame -= var7.field973;
               ++var0.field837;
               if(var0.field837 >= var7.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var7.field969.length) {
                  ItemComposition.method1124(var7, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field860 = var7.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1311202079"
   )
   static final void method189() {
      for(int var0 = 0; var0 < Client.field510; ++var0) {
         --Client.field482[var0];
         if(Client.field482[var0] >= -10) {
            class61 var1 = Client.field515[var0];
            if(null == var1) {
               Object var10000 = null;
               var1 = class61.method1254(Client.field443, Client.field511[var0], 0);
               if(var1 == null) {
                  continue;
               }

               Client.field482[var0] += var1.method1246();
               Client.field515[var0] = var1;
            }

            if(Client.field482[var0] < 0) {
               int var2;
               if(Client.field514[var0] != 0) {
                  int var3 = (Client.field514[var0] & 255) * 128;
                  int var4 = Client.field514[var0] >> 16 & 255;
                  int var5 = 64 + var4 * 128 - TextureProvider.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field514[var0] >> 8 & 255;
                  int var7 = 64 + 128 * var6 - TextureProvider.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field482[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = Client.field303 * (var3 - var8) / var3;
               } else {
                  var2 = Client.field508;
               }

               if(var2 > 0) {
                  class65 var10 = var1.method1245().method1288(KitDefinition.field1004);
                  class67 var11 = class67.method1308(var10, 100, var2);
                  var11.method1311(Client.field315[var0] - 1);
                  class75.field1389.method1143(var11);
               }

               Client.field482[var0] = -100;
            }
         } else {
            --Client.field510;

            for(int var9 = var0; var9 < Client.field510; ++var9) {
               Client.field511[var9] = Client.field511[var9 + 1];
               Client.field515[var9] = Client.field515[1 + var9];
               Client.field315[var9] = Client.field315[var9 + 1];
               Client.field482[var9] = Client.field482[var9 + 1];
               Client.field514[var9] = Client.field514[1 + var9];
            }

            --var0;
         }
      }

      if(Client.field507) {
         boolean var12;
         if(class186.field3002 != 0) {
            var12 = true;
         } else {
            var12 = class186.field3007.method3588();
         }

         if(!var12) {
            if(Client.field424 != 0 && Client.field506 != -1) {
               class50.method1001(class47.field1024, Client.field506, 0, Client.field424, false);
            }

            Client.field507 = false;
         }
      }

   }
}
