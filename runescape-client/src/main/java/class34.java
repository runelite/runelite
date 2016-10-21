import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class34 {
   @ObfuscatedName("m")
   static int[] field758 = new int[2048];
   @ObfuscatedName("n")
   static byte[] field759 = new byte[2048];
   @ObfuscatedName("t")
   static byte[] field760 = new byte[2048];
   @ObfuscatedName("v")
   static Buffer[] field761 = new Buffer[2048];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2028085881
   )
   static int field763 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -777483257
   )
   static int field764 = 0;
   @ObfuscatedName("c")
   static int[] field765 = new int[2048];
   @ObfuscatedName("ho")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("l")
   static int[] field767 = new int[2048];
   @ObfuscatedName("h")
   static int[] field768 = new int[2048];
   @ObfuscatedName("w")
   static int[] field769 = new int[2048];
   @ObfuscatedName("x")
   static Buffer field770 = new Buffer(new byte[5000]);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -437210595
   )
   static int field771 = 0;
   @ObfuscatedName("u")
   static int[] field775 = new int[2048];

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "684556959"
   )
   static void method724() {
      if(loadWorlds()) {
         class33.worldSelectShown = true;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "3582"
   )
   static final void method729(int var0, int var1) {
      if(Client.field298 == 2) {
         class178.method3497((Client.field353 - class32.baseX << 7) + Client.field304, Client.field279 + (Client.field357 - class8.baseY << 7), Client.field303 * 2);
         if(Client.field387 > -1 && Client.gameCycle % 20 < 10) {
            class40.field882[0].method1763(Client.field387 + var0 - 12, var1 + Client.field388 - 28);
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "36"
   )
   static final void method735(Actor var0) {
      var0.field819 = false;
      Sequence var3;
      if(var0.poseAnimation != -1) {
         var3 = class62.getAnimation(var0.poseAnimation);
         if(null != var3 && null != var3.field992) {
            ++var0.field833;
            if(var0.poseFrame < var3.field992.length && var0.field833 > var3.field994[var0.poseFrame]) {
               var0.field833 = 1;
               ++var0.poseFrame;
               class167.method3258(var3, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var3.field992.length) {
               var0.field833 = 0;
               var0.poseFrame = 0;
               class167.method3258(var3, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field846) {
         if(var0.field835 < 0) {
            var0.field835 = 0;
         }

         int var1 = GameEngine.method3084(var0.graphic).field1023;
         if(var1 != -1) {
            Sequence var2 = class62.getAnimation(var1);
            if(null != var2 && null != var2.field992) {
               ++var0.field855;
               if(var0.field835 < var2.field992.length && var0.field855 > var2.field994[var0.field835]) {
                  var0.field855 = 1;
                  ++var0.field835;
                  class167.method3258(var2, var0.field835, var0.x, var0.y);
               }

               if(var0.field835 >= var2.field992.length && (var0.field835 < 0 || var0.field835 >= var2.field992.length)) {
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
         var3 = class62.getAnimation(var0.animation);
         if(var3.precedenceAnimating == 1 && var0.field875 > 0 && var0.field866 <= Client.gameCycle && var0.field841 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var3 = class62.getAnimation(var0.animation);
         if(var3 != null && null != var3.field992) {
            ++var0.field850;
            if(var0.actionFrame < var3.field992.length && var0.field850 > var3.field994[var0.actionFrame]) {
               var0.field850 = 1;
               ++var0.actionFrame;
               class167.method3258(var3, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var3.field992.length) {
               var0.actionFrame -= var3.field996;
               ++var0.field852;
               if(var0.field852 >= var3.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var3.field992.length) {
                  class167.method3258(var3, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field819 = var3.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1403163574"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class13.worldServersDownload == null) {
            class13.worldServersDownload = new class18(class54.field1146, new URL(class13.field196));
         } else {
            byte[] var0 = class13.worldServersDownload.method190();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field651 = var1.method2535();
               World.worldList = new World[World.field651];

               World var3;
               for(int var2 = 0; var2 < World.field651; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.method2535();
                  var3.mask = var1.method2538();
                  var3.address = var1.method2541();
                  var3.activity = var1.method2541();
                  var3.location = var1.method2656();
                  var3.playerCount = var1.method2633();
               }

               class56.method1168(World.worldList, 0, World.worldList.length - 1, World.field654, World.field663);
               class13.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class13.worldServersDownload = null;
      }

      return false;
   }
}
