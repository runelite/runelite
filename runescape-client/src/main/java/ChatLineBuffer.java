import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Lbj;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 224711877
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lbj;",
      garbageValue = "-1"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Lbj;",
      garbageValue = "-108"
   )
   MessageNode method1874(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1461120937"
   )
   int method1883() {
      return this.length;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "47"
   )
   public static int method1878(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Lcj;II)V",
      garbageValue = "653045908"
   )
   static final void method1879(Actor var0, int var1) {
      if(var0.field1235 > Client.gameCycle) {
         FaceNormal.method2902(var0);
      } else if(var0.field1207 >= Client.gameCycle) {
         class46.method697(var0);
      } else {
         FileOnDisk.method1934(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1235 = 0;
         var0.field1207 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1216 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1216 * 64;
         var0.method1534();
      }

      if(class224.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1235 = 0;
         var0.field1207 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1216 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1216 * 64;
         var0.method1534();
      }

      int var5;
      if(var0.field1242 != 0) {
         if(var0.interacting != -1) {
            Object var2 = null;
            if(var0.interacting < '耀') {
               var2 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var2 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var2 != null) {
               int var3 = var0.x - ((Actor)var2).x;
               int var4 = var0.y - ((Actor)var2).y;
               if(var3 != 0 || var4 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1219) {
               var0.interacting = -1;
               var0.field1219 = false;
            }
         }

         if(var0.field1209 != -1 && (var0.queueSize == 0 || var0.field1247 > 0)) {
            var0.orientation = var0.field1209;
            var0.field1209 = -1;
         }

         var5 = var0.orientation - var0.angle & 2047;
         if(var5 == 0 && var0.field1219) {
            var0.interacting = -1;
            var0.field1219 = false;
         }

         if(var5 != 0) {
            ++var0.field1241;
            boolean var8;
            if(var5 > 1024) {
               var0.angle -= var0.field1242;
               var8 = true;
               if(var5 < var0.field1242 || var5 > 2048 - var0.field1242) {
                  var0.angle = var0.orientation;
                  var8 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1241 > 25 || var8)) {
                  if(var0.field1195 != -1) {
                     var0.poseAnimation = var0.field1195;
                  } else {
                     var0.poseAnimation = var0.field1197;
                  }
               }
            } else {
               var0.angle += var0.field1242;
               var8 = true;
               if(var5 < var0.field1242 || var5 > 2048 - var0.field1242) {
                  var0.angle = var0.orientation;
                  var8 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1241 > 25 || var8)) {
                  if(var0.field1196 != -1) {
                     var0.poseAnimation = var0.field1196;
                  } else {
                     var0.poseAnimation = var0.field1197;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1241 = 0;
         }
      }

      var0.field1192 = false;
      Sequence var7;
      if(var0.poseAnimation != -1) {
         var7 = class40.getAnimation(var0.poseAnimation);
         if(var7 != null && var7.frameIDs != null) {
            ++var0.field1220;
            if(var0.poseFrame < var7.frameIDs.length && var0.field1220 > var7.frameLenghts[var0.poseFrame]) {
               var0.field1220 = 1;
               ++var0.poseFrame;
               class19.method137(var7, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var7.frameIDs.length) {
               var0.field1220 = 0;
               var0.poseFrame = 0;
               class19.method137(var7, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1227 < 0) {
            var0.field1227 = 0;
         }

         var5 = class36.getSpotAnimType(var0.graphic).field3309;
         if(var5 != -1) {
            Sequence var6 = class40.getAnimation(var5);
            if(var6 != null && var6.frameIDs != null) {
               ++var0.field1228;
               if(var0.field1227 < var6.frameIDs.length && var0.field1228 > var6.frameLenghts[var0.field1227]) {
                  var0.field1228 = 1;
                  ++var0.field1227;
                  class19.method137(var6, var0.field1227, var0.x, var0.y);
               }

               if(var0.field1227 >= var6.frameIDs.length && (var0.field1227 < 0 || var0.field1227 >= var6.frameIDs.length)) {
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
         var7 = class40.getAnimation(var0.animation);
         if(var7.precedenceAnimating == 1 && var0.field1248 > 0 && var0.field1235 <= Client.gameCycle && var0.field1207 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var7 = class40.getAnimation(var0.animation);
         if(var7 != null && var7.frameIDs != null) {
            ++var0.field1223;
            if(var0.actionFrame < var7.frameIDs.length && var0.field1223 > var7.frameLenghts[var0.actionFrame]) {
               var0.field1223 = 1;
               ++var0.actionFrame;
               class19.method137(var7, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var7.frameIDs.length) {
               var0.actionFrame -= var7.frameStep;
               ++var0.field1218;
               if(var0.field1218 >= var7.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var7.frameIDs.length) {
                  class19.method137(var7, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1192 = var7.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "2101839532"
   )
   public static void method1881(String[] var0, short[] var1) {
      class203.method3706(var0, var1, 0, var0.length - 1);
   }
}
