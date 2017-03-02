import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("i")
   boolean field178 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 851905271
   )
   int field179;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1967481681
   )
   @Export("id")
   int id;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)[LSpritePixels;",
      garbageValue = "-505944976"
   )
   static SpritePixels[] method199(class182 var0, int var1, int var2) {
      return !class185.method3467(var0, var1, var2)?null:class45.method902();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-417101534"
   )
   static final void method200() {
      if(class5.field46 != null) {
         class5.field46.method2109();
         class5.field46 = null;
      }

      Friend.method186();
      Varbit.region.method1756();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2316();
      }

      System.gc();
      class33.method765(2);
      Client.field523 = -1;
      Client.field401 = false;
      class105.method2075();
      GameObject.setGameState(10);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "524964752"
   )
   static final void method201() {
      short var0 = 256;
      int var1;
      if(class41.field826 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field826 > 768) {
               class150.field2037[var1] = class94.method1975(class159.field2122[var1], class72.field1173[var1], 1024 - class41.field826);
            } else if(class41.field826 > 256) {
               class150.field2037[var1] = class72.field1173[var1];
            } else {
               class150.field2037[var1] = class94.method1975(class72.field1173[var1], class159.field2122[var1], 256 - class41.field826);
            }
         }
      } else if(class41.field827 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field827 > 768) {
               class150.field2037[var1] = class94.method1975(class159.field2122[var1], class36.field761[var1], 1024 - class41.field827);
            } else if(class41.field827 > 256) {
               class150.field2037[var1] = class36.field761[var1];
            } else {
               class150.field2037[var1] = class94.method1975(class36.field761[var1], class159.field2122[var1], 256 - class41.field827);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class150.field2037[var1] = class159.field2122[var1];
         }
      }

      Rasterizer2D.method4124(class41.field817, 9, 128 + class41.field817, 7 + var0);
      class41.field820.method4252(class41.field817, 0);
      Rasterizer2D.method4140();
      var1 = 0;
      int var2 = class22.bufferProvider.width * 9 + class41.field817;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class41.field825[var3] / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class41.field828[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class150.field2037[var7];
               var10 = class22.bufferProvider.pixels[var2];
               class22.bufferProvider.pixels[var2++] = ((var7 & '\uff00') * var8 + var9 * (var10 & '\uff00') & 16711680) + (var9 * (var10 & 16711935) + var8 * (var7 & 16711935) & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += class22.bufferProvider.width + var5 - 128;
      }

      Rasterizer2D.method4124(class41.field817 + 765 - 128, 9, 765 + class41.field817, 7 + var0);
      class41.field846.method4252(382 + class41.field817, 0);
      Rasterizer2D.method4140();
      var1 = 0;
      var2 = 637 + 24 + class22.bufferProvider.width * 9 + class41.field817;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class41.field825[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class41.field828[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class150.field2037[var7];
               var10 = class22.bufferProvider.pixels[var2];
               class22.bufferProvider.pixels[var2++] = (var9 * (var10 & 16711935) + var8 * (var7 & 16711935) & -16711936) + (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class22.bufferProvider.width - var5 - var4;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "-940970224"
   )
   static int method202(World var0, World var1, int var2, boolean var3) {
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
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method652()?(var1.method652()?0:1):(var1.method652()?-1:0)):(var2 == 5?(var0.method665()?(var1.method665()?0:1):(var1.method665()?-1:0)):(var2 == 6?(var0.method648()?(var1.method648()?0:1):(var1.method648()?-1:0)):(var2 == 7?(var0.method664()?(var1.method664()?0:1):(var1.method664()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "1429656478"
   )
   static final void method203(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method246();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var9 = var0.method246();
            Client.field564.field1854 = var1;
            Client.field564.field1849 = var2;
            Client.field564.field1850 = 1;
            Client.field564.field1851 = 1;
            class22 var10 = Client.field564;
            int var11 = class110.method2136(var4, var5, var9, var10, Client.collisionMaps[var0.field260], true, Client.field565, Client.field566);
            if(var11 >= 1) {
               for(int var12 = 0; var12 < var11 - 1; ++var12) {
                  var0.method238(Client.field565[var12], Client.field566[var12], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "1"
   )
   static final void method204(Actor var0) {
      if(var0.field633 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field635 > XClanMember.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field633 - var0.field647;
         int var2 = Client.gameCycle - var0.field647;
         int var3 = var0.field643 * 128 + var0.field634 * 64;
         int var4 = var0.field634 * 64 + var0.field645 * 128;
         int var5 = var0.field634 * 64 + var0.field644 * 128;
         int var6 = var0.field646 * 128 + var0.field634 * 64;
         var0.x = (var3 * (var1 - var2) + var5 * var2) / var1;
         var0.y = ((var1 - var2) * var4 + var6 * var2) / var1;
      }

      var0.field601 = 0;
      var0.field652 = var0.field649;
      var0.angle = var0.field652;
   }
}
