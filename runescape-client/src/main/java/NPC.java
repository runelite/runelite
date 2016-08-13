import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("l")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "76"
   )
   final boolean vmethod794() {
      return null != this.composition;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-673381210"
   )
   final void method760(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && class22.getAnimation(super.animation).field1028 == 1) {
         super.animation = -1;
      }

      if(super.field849 < 9) {
         ++super.field849;
      }

      for(int var5 = super.field849; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field888[var5] = super.field888[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field888[0] = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1036022233"
   )
   static void method762() {
      class5.field81 = 99;
      class5.field82 = new byte[4][104][104];
      class75.field1422 = new byte[4][104][104];
      class5.field88 = new byte[4][104][104];
      class5.field86 = new byte[4][104][104];
      VertexNormal.field1704 = new int[4][105][105];
      class232.field3275 = new byte[4][105][105];
      class13.field207 = new int[105][105];
      class5.field83 = new int[104];
      class5.field87 = new int[104];
      class5.field96 = new int[104];
      MessageNode.field809 = new int[104];
      class224.field3225 = new int[104];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-818408846"
   )
   public static String method763(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class168.field2718[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "503322838"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class22.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class22.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method818(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method2402();
            super.field837 = var3.modelHeight;
            if(super.graphic != -1 && super.field890 != -1) {
               Model var4 = class110.method2488(super.graphic).method952(super.field890);
               if(null != var4) {
                  var4.method2412(0, -super.field872, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field913 == 1) {
               var3.field1892 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "0"
   )
   final void method770(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class22.getAnimation(super.animation).field1028 == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field849 < 9) {
               ++super.field849;
            }

            for(int var6 = super.field849; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field888[var6] = super.field888[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field888[0] = 1;
            return;
         }
      }

      super.field849 = 0;
      super.field839 = 0;
      super.field889 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = 128 * super.pathX[0] + super.field877 * 64;
      super.y = super.pathY[0] * 128 + super.field877 * 64;
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1993559914"
   )
   static void method772(Widget var0, int var1, int var2) {
      if(var0.field2812 == 0) {
         var0.relativeX = var0.field2816;
      } else if(var0.field2812 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.field2816;
      } else if(var0.field2812 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2816;
      } else if(var0.field2812 == 3) {
         var0.relativeX = var1 * var0.field2816 >> 14;
      } else if(var0.field2812 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var1 * var0.field2816 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.field2816 * var1 >> 14);
      }

      if(var0.field2925 == 0) {
         var0.relativeY = var0.field2941;
      } else if(var0.field2925 == 1) {
         var0.relativeY = var0.field2941 + (var2 - var0.height) / 2;
      } else if(var0.field2925 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2941;
      } else if(var0.field2925 == 3) {
         var0.relativeY = var0.field2941 * var2 >> 14;
      } else if(var0.field2925 == 4) {
         var0.relativeY = (var0.field2941 * var2 >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var0.field2941 * var2 >> 14);
      }

      if(Client.field471 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "520571157"
   )
   public static ModIcon[] method773(class170 var0, String var1, String var2) {
      int var3 = var0.method3410(var1);
      int var4 = var0.method3459(var3, var2);
      ModIcon[] var5;
      if(!class4.method49(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon[] var6 = new ModIcon[class79.field1466];

         for(int var7 = 0; var7 < class79.field1466; ++var7) {
            ModIcon var8 = var6[var7] = new ModIcon();
            var8.width = class79.field1454;
            var8.originalHeight = class79.field1456;
            var8.offsetX = class79.field1457[var7];
            var8.offsetY = class180.field2962[var7];
            var8.originalWidth = class192.field3106[var7];
            var8.height = class79.field1458[var7];
            var8.palette = class79.field1459;
            var8.pixels = class145.field2236[var7];
         }

         ItemComposition.method1182();
         var5 = var6;
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-265596313"
   )
   static int method774(int var0) {
      MessageNode var1 = (MessageNode)class11.field174.method3950((long)var0);
      return var1 == null?-1:(var1.next == class11.field173.field3158?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "459242043"
   )
   static final void method776() {
      Region.field1545 = false;
      Client.field301 = false;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "14"
   )
   static final void method777(Actor var0) {
      if(var0.field878 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field848 + 1 > class22.getAnimation(var0.animation).field1018[var0.actionFrame]) {
         int var1 = var0.field878 - var0.field891;
         int var2 = Client.gameCycle - var0.field891;
         int var3 = var0.field873 * 128 + var0.field877 * 64;
         int var4 = var0.field877 * 64 + var0.field856 * 128;
         int var5 = var0.field877 * 64 + var0.field874 * 128;
         int var6 = var0.field876 * 128 + var0.field877 * 64;
         var0.x = (var5 * var2 + var3 * (var1 - var2)) / var1;
         var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
      }

      var0.field889 = 0;
      var0.field882 = var0.field884;
      var0.angle = var0.field882;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIIB)V",
      garbageValue = "59"
   )
   static final void method778(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field377) {
         Client.field513 = 32;
      } else {
         Client.field513 = 0;
      }

      Client.field377 = false;
      int var7;
      if(class143.field2207 == 1 || !class214.field3188 && class143.field2207 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class79.method1777(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class79.method1777(var0);
         } else if(var5 >= var1 - Client.field513 && var5 < Client.field513 + var1 + 16 && var6 >= 16 + var2 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = (var4 - var3) * var8 / var9;
            class79.method1777(var0);
            Client.field377 = true;
         }
      }

      if(Client.field491 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var2 + var3) {
            var0.scrollY += Client.field491 * 45;
            class79.method1777(var0);
         }
      }

   }
}
