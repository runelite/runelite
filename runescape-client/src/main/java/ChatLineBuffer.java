import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("r")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("ee")
   static SpritePixels[] field686;
   @ObfuscatedName("et")
   static ModIcon[] field689;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -137502667
   )
   @Export("length")
   int length;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "499614767"
   )
   MessageNode method634(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-84"
   )
   int method635() {
      return this.length;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "204250517"
   )
   static final void method640(Widget var0, int var1, int var2) {
      if(Client.field515 == 0 || Client.field515 == 3) {
         if(class143.field2198 == 1 || !class134.field2117 && class143.field2198 == 4) {
            class178 var3 = var0.method3449(true);
            if(null == var3) {
               return;
            }

            int var4 = class143.field2211 - var1;
            int var5 = class143.field2213 - var2;
            if(var3.method3473(var4, var5)) {
               var4 -= var3.field2953 / 2;
               var5 -= var3.field2952 / 2;
               int var6 = Client.mapAngle + Client.mapScale & 2047;
               int var7 = class94.field1639[var6];
               int var8 = class94.field1640[var6];
               var7 = (Client.mapScaleDelta + 256) * var7 >> 8;
               var8 = var8 * (Client.mapScaleDelta + 256) >> 8;
               int var9 = var8 * var4 + var5 * var7 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = class48.localPlayer.x + var9 >> 7;
               int var12 = class48.localPlayer.y - var10 >> 7;
               Client.field323.method2818(23);
               Client.field323.method2715(18);
               Client.field323.method2661(class159.baseY + var12);
               Client.field323.method2661(var11 + class28.baseX);
               Client.field323.method2715(class140.field2167[82]?(class140.field2167[81]?2:1):0);
               Client.field323.method2715(var4);
               Client.field323.method2715(var5);
               Client.field323.method2542(Client.mapAngle);
               Client.field323.method2715(57);
               Client.field323.method2715(Client.mapScale);
               Client.field323.method2715(Client.mapScaleDelta);
               Client.field323.method2715(89);
               Client.field323.method2542(class48.localPlayer.x);
               Client.field323.method2542(class48.localPlayer.y);
               Client.field323.method2715(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)LMessageNode;",
      garbageValue = "15"
   )
   MessageNode method644(int var1, String var2, String var3, String var4) {
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
         var5.method3925();
         var5.method732(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)Z",
      garbageValue = "-61"
   )
   static boolean method645(class125 var0, int var1) {
      int var2 = var0.method2827(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2827(1) != 0) {
            method645(var0, var1);
         }

         var3 = var0.method2827(6);
         var4 = var0.method2827(6);
         boolean var12 = var0.method2827(1) == 1;
         if(var12) {
            class34.field771[++class34.field762 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var11 = Client.cachedPlayers[var1] = new Player();
            var11.field48 = var1;
            if(class34.field759[var1] != null) {
               var11.method19(class34.field759[var1]);
            }

            var11.field835 = class34.field765[var1];
            var11.interacting = class34.field766[var1];
            var7 = class34.field761[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var11.field830[0] = class34.field758[var1];
            var11.field47 = (byte)var8;
            var11.method36(var3 + (var9 << 6) - class28.baseX, (var10 << 6) + var4 - class159.baseY);
            var11.field49 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2827(2);
         var4 = class34.field761[var1];
         class34.field761[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2827(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class34.field761[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
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

            class34.field761[var1] = var9 + (var8 << 14) + (var7 << 28);
            return false;
         } else {
            var3 = var0.method2827(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class34.field761[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var6 + var7 & 255;
            class34.field761[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "19"
   )
   static final void method646(Actor var0) {
      if(var0.field870 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < '耀') {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var1 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.field835 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field844) {
               var0.interacting = -1;
               var0.field844 = false;
            }
         }

         if(var0.field845 != -1 && (var0.field871 == 0 || var0.field875 > 0)) {
            var0.field835 = var0.field845;
            var0.field845 = -1;
         }

         int var4 = var0.field835 - var0.angle & 2047;
         if(var4 == 0 && var0.field844) {
            var0.interacting = -1;
            var0.field844 = false;
         }

         if(var4 != 0) {
            ++var0.field824;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field870;
               var6 = true;
               if(var4 < var0.field870 || var4 > 2048 - var0.field870) {
                  var0.angle = var0.field835;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field824 > 25 || var6)) {
                  if(var0.field839 != -1) {
                     var0.poseAnimation = var0.field839;
                  } else {
                     var0.poseAnimation = var0.field825;
                  }
               }
            } else {
               var0.angle += var0.field870;
               var6 = true;
               if(var4 < var0.field870 || var4 > 2048 - var0.field870) {
                  var0.angle = var0.field835;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field824 > 25 || var6)) {
                  if(var0.field852 != -1) {
                     var0.poseAnimation = var0.field852;
                  } else {
                     var0.poseAnimation = var0.field825;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field824 = 0;
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)I",
      garbageValue = "-723293598"
   )
   static int method647(class125 var0) {
      int var1 = var0.method2827(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2827(5);
      } else if(var1 == 2) {
         var2 = var0.method2827(8);
      } else {
         var2 = var0.method2827(11);
      }

      return var2;
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "47641571"
   )
   static final void method648(String var0, int var1) {
      Client.field323.method2818(155);
      Client.field323.method2715(class43.method857(var0) + 1);
      Client.field323.method2616(var0);
      Client.field323.method2715(var1);
   }
}
