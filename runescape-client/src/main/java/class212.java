import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public final class class212 {
   @ObfuscatedName("s")
   static Widget field3176;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;B)V",
      garbageValue = "69"
   )
   static void method3955(class227 var0, class227 var1) {
      if(class12.field200 == null) {
         class12.field200 = NPC.method756(ItemComposition.field1199, "sl_back", "");
      }

      if(class16.field254 == null) {
         class16.field254 = class51.method1072(ItemComposition.field1199, "sl_flags", "");
      }

      if(Projectile.field134 == null) {
         Projectile.field134 = class51.method1072(ItemComposition.field1199, "sl_arrows", "");
      }

      if(TextureProvider.field1671 == null) {
         TextureProvider.field1671 = class51.method1072(ItemComposition.field1199, "sl_stars", "");
      }

      class82.method1853(class33.field755, 23, 765, 480, 0);
      class82.method1842(class33.field755, 0, 125, 23, 12425273, 9135624);
      class82.method1842(class33.field755 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4070("Select a world", class33.field755 + 62, 15, 0, -1);
      if(TextureProvider.field1671 != null) {
         TextureProvider.field1671[1].method1905(class33.field755 + 140, 1);
         var1.method4124("Members only world", 152 + class33.field755, 10, 16777215, -1);
         TextureProvider.field1671[0].method1905(140 + class33.field755, 12);
         var1.method4124("Free world", 152 + class33.field755, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(Projectile.field134 != null) {
         int var2 = class33.field755 + 280;
         if(World.field681[0] == 0 && World.field671[0] == 0) {
            Projectile.field134[2].method1905(var2, 4);
         } else {
            Projectile.field134[0].method1905(var2, 4);
         }

         if(World.field681[0] == 0 && World.field671[0] == 1) {
            Projectile.field134[3].method1905(var2 + 15, 4);
         } else {
            Projectile.field134[1].method1905(15 + var2, 4);
         }

         var0.method4124("World", 32 + var2, 17, 16777215, -1);
         int var3 = class33.field755 + 390;
         if(World.field681[0] == 1 && World.field671[0] == 0) {
            Projectile.field134[2].method1905(var3, 4);
         } else {
            Projectile.field134[0].method1905(var3, 4);
         }

         if(World.field681[0] == 1 && World.field671[0] == 1) {
            Projectile.field134[3].method1905(var3 + 15, 4);
         } else {
            Projectile.field134[1].method1905(15 + var3, 4);
         }

         var0.method4124("Players", 32 + var3, 17, 16777215, -1);
         var4 = class33.field755 + 500;
         if(World.field681[0] == 2 && World.field671[0] == 0) {
            Projectile.field134[2].method1905(var4, 4);
         } else {
            Projectile.field134[0].method1905(var4, 4);
         }

         if(World.field681[0] == 2 && World.field671[0] == 1) {
            Projectile.field134[3].method1905(var4 + 15, 4);
         } else {
            Projectile.field134[1].method1905(15 + var4, 4);
         }

         var0.method4124("Location", var4 + 32, 17, 16777215, -1);
         var5 = class33.field755 + 610;
         if(World.field681[0] == 3 && World.field671[0] == 0) {
            Projectile.field134[2].method1905(var5, 4);
         } else {
            Projectile.field134[0].method1905(var5, 4);
         }

         if(World.field681[0] == 3 && World.field671[0] == 1) {
            Projectile.field134[3].method1905(15 + var5, 4);
         } else {
            Projectile.field134[1].method1905(var5 + 15, 4);
         }

         var0.method4124("Type", 32 + var5, 17, 16777215, -1);
      }

      class82.method1853(class33.field755 + 708, 4, 50, 16, 0);
      var1.method4070("Cancel", 708 + class33.field755 + 25, 16, 16777215, -1);
      class33.field771 = -1;
      if(null != class12.field200) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (1 + var23);
         var5 = 480 / (1 + var24);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= World.field685) {
               --var4;
            }

            if((var5 - 1) * var4 >= World.field685) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.field685) {
               --var5;
            }
         } while(var6 != var5 || var4 != var7);

         var6 = (765 - var4 * var23) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var24 * var5) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var24 - (var5 - 1) * var7) / 2;
         int var10 = 23 + var9;
         int var11 = class33.field755 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field685; ++var14) {
            World var15 = VertexNormal.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method598()) {
               if(var15.method593()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method597()) {
               var19 = 16711680;
               if(var15.method593()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method622()) {
               if(var15.method593()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method593()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class143.field2204 >= var11 && class143.field2206 >= var10 && class143.field2204 < var11 + var23 && class143.field2206 < var24 + var10 && var16) {
               class33.field771 = var14;
               class12.field200[var18].method1754(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class12.field200[var18].method1748(var11, var10);
            }

            if(class16.field254 != null) {
               class16.field254[(var15.method593()?8:0) + var15.location].method1905(29 + var11, var10);
            }

            var0.method4070(Integer.toString(var15.id), var11 + 15, var24 / 2 + var10 + 5, var19, -1);
            var1.method4070(var17, 60 + var11, var10 + var24 / 2 + 5, 268435455, -1);
            var10 += var24 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4062(VertexNormal.worldList[class33.field771].activity) + 6;
            int var20 = var1.field3243 + 8;
            class82.method1853(class143.field2204 - var14 / 2, 5 + 20 + class143.field2206, var14, var20, 16777120);
            class82.method1856(class143.field2204 - var14 / 2, 5 + class143.field2206 + 20, var14, var20, 0);
            var1.method4070(VertexNormal.worldList[class33.field771].activity, class143.field2204, var1.field3243 + 5 + 20 + class143.field2206 + 4, 0, -1);
         }
      }

      try {
         Graphics var21 = class164.canvas.getGraphics();
         class220.bufferProvider.draw(var21, 0, 0);
      } catch (Exception var22) {
         class164.canvas.repaint();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2143102612"
   )
   static final void method3957() {
      if(XClanMember.field652 != null) {
         XClanMember.field652.method1239();
      }

      if(World.field683 != null) {
         World.field683.method1239();
      }

   }
}
