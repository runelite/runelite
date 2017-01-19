import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class7 implements Comparator {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-843821071"
   )
   int method83(class2 var1, class2 var2) {
      return var1.field25 < var2.field25?-1:(var2.field25 == var1.field25?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method83((class2)var1, (class2)var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "982563596"
   )
   static void method84(int var0, int var1, int var2, int var3) {
      for(class31 var4 = (class31)class31.field703.method2330(); null != var4; var4 = (class31)class31.field703.method2346()) {
         if(var4.field707 != -1 || var4.field709 != null) {
            int var5 = 0;
            if(var1 > var4.field706) {
               var5 += var1 - var4.field706;
            } else if(var1 < var4.field705) {
               var5 += var4.field705 - var1;
            }

            if(var2 > var4.field708) {
               var5 += var2 - var4.field708;
            } else if(var2 < var4.field715) {
               var5 += var4.field715 - var2;
            }

            if(var5 - 64 <= var4.field710 && Client.field551 != 0 && var0 == var4.field704) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field710 - var5) * Client.field551 / var4.field710;
               if(var4.field711 == null) {
                  if(var4.field707 >= 0) {
                     class53 var7 = class53.method921(class5.field60, var4.field707, 0);
                     if(null != var7) {
                        class55 var8 = var7.method918().method963(Player.field267);
                        class66 var9 = class66.method1126(var8, 100, var6);
                        var9.method1165(-1);
                        CombatInfoListHolder.field758.method868(var9);
                        var4.field711 = var9;
                     }
                  }
               } else {
                  var4.field711.method1130(var6);
               }

               if(var4.field716 == null) {
                  if(null != var4.field709 && (var4.field714 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field709.length);
                     class53 var12 = class53.method921(class5.field60, var4.field709[var11], 0);
                     if(null != var12) {
                        class55 var13 = var12.method918().method963(Player.field267);
                        class66 var10 = class66.method1126(var13, 100, var6);
                        var10.method1165(0);
                        CombatInfoListHolder.field758.method868(var10);
                        var4.field716 = var10;
                        var4.field714 = var4.field712 + (int)(Math.random() * (double)(var4.field713 - var4.field712));
                     }
                  }
               } else {
                  var4.field716.method1130(var6);
                  if(!var4.field716.linked()) {
                     var4.field716 = null;
                  }
               }
            } else {
               if(null != var4.field711) {
                  CombatInfoListHolder.field758.method869(var4.field711);
                  var4.field711 = null;
               }

               if(null != var4.field716) {
                  CombatInfoListHolder.field758.method869(var4.field716);
                  var4.field716 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(LActor;IB)V",
      garbageValue = "76"
   )
   static final void method87(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field661 > Client.gameCycle) {
         var2 = var0.field661 - Client.gameCycle;
         var3 = var0.field645 * 64 + var0.field606 * 128;
         var4 = var0.field645 * 64 + var0.field650 * 128;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field647 = 0;
         var0.field655 = var0.field652;
      } else if(var0.field651 >= Client.gameCycle) {
         class18.method164(var0);
      } else {
         GroundObject.method1504(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field661 = 0;
         var0.field651 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field645 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field645 * 64;
         var0.method575();
      }

      if(var0 == XItemContainer.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field661 = 0;
         var0.field651 = 0;
         var0.x = var0.field645 * 64 + 128 * var0.pathX[0];
         var0.y = var0.field645 * 64 + var0.pathY[0] * 128;
         var0.method575();
      }

      if(var0.field646 != 0) {
         if(var0.interacting != -1) {
            Object var5 = null;
            if(var0.interacting < '耀') {
               var5 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var5 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var5) {
               var3 = var0.x - ((Actor)var5).x;
               var4 = var0.y - ((Actor)var5).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field655 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field664) {
               var0.interacting = -1;
               var0.field664 = false;
            }
         }

         if(var0.field632 != -1 && (var0.field658 == 0 || var0.field647 > 0)) {
            var0.field655 = var0.field632;
            var0.field632 = -1;
         }

         var2 = var0.field655 - var0.angle & 2047;
         if(var2 == 0 && var0.field664) {
            var0.interacting = -1;
            var0.field664 = false;
         }

         if(var2 != 0) {
            ++var0.field656;
            boolean var7;
            if(var2 > 1024) {
               var0.angle -= var0.field646;
               var7 = true;
               if(var2 < var0.field646 || var2 > 2048 - var0.field646) {
                  var0.angle = var0.field655;
                  var7 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field656 > 25 || var7)) {
                  if(var0.field610 != -1) {
                     var0.poseAnimation = var0.field610;
                  } else {
                     var0.poseAnimation = var0.field636;
                  }
               }
            } else {
               var0.angle += var0.field646;
               var7 = true;
               if(var2 < var0.field646 || var2 > 2048 - var0.field646) {
                  var0.angle = var0.field655;
                  var7 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field656 > 25 || var7)) {
                  if(var0.field611 != -1) {
                     var0.poseAnimation = var0.field611;
                  } else {
                     var0.poseAnimation = var0.field636;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field656 = 0;
         }
      }

      class6.method76(var0);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)[Lclass177;",
      garbageValue = "93"
   )
   public static class177[] method91() {
      return new class177[]{class177.field2678, class177.field2668, class177.field2670, class177.field2671, class177.field2673, class177.field2672};
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "178166055"
   )
   public static boolean method92(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "31"
   )
   static final void method93(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field566 == -1) {
            Client.field566 = var0.textureId;
            Client.field567 = var0.field2245 * -1;
         }

         if(Client.field470.isFemale) {
            var0.textureId = Client.field566;
         } else {
            var0.textureId = Client.field567 * -1;
         }

      } else if(var1 == 325) {
         if(Client.field566 == -1) {
            Client.field566 = var0.textureId;
            Client.field567 = var0.field2245 * -1;
         }

         if(Client.field470.isFemale) {
            var0.textureId = Client.field567 * -1;
         } else {
            var0.textureId = Client.field566;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
