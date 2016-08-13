import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class12 extends Renderable {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1481582643
   )
   int field186;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1625020031
   )
   int field188;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -961904025
   )
   int field189;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1593230715
   )
   int field190;
   @ObfuscatedName("k")
   Sequence field192;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1622408887
   )
   int field193;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -862625489
   )
   int field194;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1953793259
   )
   int field195;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1365484703
   )
   static int field198;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -115062023
   )
   int field200;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Lclass21;",
      garbageValue = "2053515751"
   )
   static class21[] method166() {
      return new class21[]{class21.field587, class21.field589, class21.field590, class21.field588};
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "503322838"
   )
   protected final Model getModel() {
      if(null != this.field192) {
         int var1 = Client.gameCycle - this.field194;
         if(var1 > 100 && this.field192.field1020 > 0) {
            var1 = 100;
         }

         label47: {
            do {
               do {
                  if(var1 <= this.field192.field1018[this.field193]) {
                     break label47;
                  }

                  var1 -= this.field192.field1018[this.field193];
                  ++this.field193;
               } while(this.field193 < this.field192.field1030.length);

               this.field193 -= this.field192.field1020;
            } while(this.field193 >= 0 && this.field193 < this.field192.field1030.length);

            this.field192 = null;
         }

         this.field194 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class160.getObjectDefinition(this.field186);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(null == var12) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field195 != 1 && this.field195 != 3) {
            var2 = var12.field960;
            var3 = var12.field970;
         } else {
            var2 = var12.field970;
            var3 = var12.field960;
         }

         int var4 = this.field190 + (var2 >> 1);
         int var5 = (1 + var2 >> 1) + this.field190;
         int var6 = this.field189 + (var3 >> 1);
         int var7 = (1 + var3 >> 1) + this.field189;
         int[][] var8 = class5.tileHeights[this.field200];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var4][var6] + var8[var5][var6] >> 2;
         int var10 = (this.field190 << 7) + (var2 << 6);
         int var11 = (var3 << 6) + (this.field189 << 7);
         return var12.method870(this.field188, this.field195, var8, var10, var9, var11, this.field192, this.field193);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1098425746"
   )
   static final void method171(int var0) {
      short var1 = 256;
      class33.field753 += 128 * var0;
      int var2;
      if(class33.field753 > class26.field649.length) {
         class33.field753 -= class26.field649.length;
         var2 = (int)(Math.random() * 12.0D);
         class47.method998(class33.field744[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = ChatLineBuffer.field699[var2 + var3] - var0 * class26.field649[var2 + class33.field753 & class26.field649.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         ChatLineBuffer.field699[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               ChatLineBuffer.field699[var7 + var6] = 255;
            } else {
               ChatLineBuffer.field699[var6 + var7] = 0;
            }
         }
      }

      if(class33.field749 > 0) {
         class33.field749 -= 4 * var0;
      }

      if(class33.field752 > 0) {
         class33.field752 -= 4 * var0;
      }

      if(class33.field749 == 0 && class33.field752 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class33.field749 = 1024;
         }

         if(var5 == 1) {
            class33.field752 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class33.field742[var5] = class33.field742[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class33.field742[var5] = (int)(Math.sin((double)class33.field756 / 14.0D) * 16.0D + Math.sin((double)class33.field756 / 15.0D) * 14.0D + Math.sin((double)class33.field756 / 16.0D) * 12.0D);
         ++class33.field756;
      }

      class33.field759 += var0;
      var5 = ((Client.gameCycle & 1) + var0) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class33.field759 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            ChatLineBuffer.field699[(var8 << 7) + var7] = 192;
         }

         class33.field759 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = 128 * var6;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += ChatLineBuffer.field699[var5 + var8 + var9];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= ChatLineBuffer.field699[var8 + var9 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  PlayerComposition.field2970[var8 + var9] = var7 / (1 + var5 * 2);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = 128 * var8;
               if(var5 + var8 < var1) {
                  var7 += PlayerComposition.field2970[var9 + var6 + var5 * 128];
               }

               if(var8 - (1 + var5) >= 0) {
                  var7 -= PlayerComposition.field2970[var6 + var9 - 128 * (var5 + 1)];
               }

               if(var8 >= 0) {
                  ChatLineBuffer.field699[var6 + var9] = var7 / (2 * var5 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "-232610020"
   )
   public static void method172(String[] var0, short[] var1) {
      GroundObject.method2254(var0, var1, 0, var0.length - 1);
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field186 = var1;
      this.field188 = var2;
      this.field195 = var3;
      this.field200 = var4;
      this.field190 = var5;
      this.field189 = var6;
      if(var7 != -1) {
         this.field192 = class22.getAnimation(var7);
         this.field193 = 0;
         this.field194 = Client.gameCycle - 1;
         if(this.field192.replyMode == 0 && null != var9 && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field192 == var10.field192) {
               this.field193 = var10.field193;
               this.field194 = var10.field194;
               return;
            }
         }

         if(var8 && this.field192.field1020 != -1) {
            this.field193 = (int)(Math.random() * (double)this.field192.field1030.length);
            this.field194 -= (int)(Math.random() * (double)this.field192.field1018[this.field193]);
         }
      }

   }
}
