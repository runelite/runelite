import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class12 extends Renderable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1058606381
   )
   int field193;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -642877905
   )
   int field194;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -238191667
   )
   int field195;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 391856953
   )
   int field197;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 385968191
   )
   int field198;
   @ObfuscatedName("d")
   Sequence field199;
   @ObfuscatedName("ae")
   static SpritePixels[] field200;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 83543777
   )
   int field201;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 660464737
   )
   int field204;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1150026335
   )
   int field208;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZB)V",
      garbageValue = "0"
   )
   public static void method149(class170 var0, class170 var1, boolean var2) {
      ObjectComposition.field992 = var0;
      ObjectComposition.field986 = var1;
      ObjectComposition.field958 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1050401255"
   )
   protected final Model getModel() {
      if(this.field199 != null) {
         int var12 = Client.gameCycle - this.field201;
         if(var12 > 100 && this.field199.field1012 > 0) {
            var12 = 100;
         }

         label65: {
            do {
               do {
                  if(var12 <= this.field199.field1019[this.field208]) {
                     break label65;
                  }

                  var12 -= this.field199.field1019[this.field208];
                  ++this.field208;
               } while(this.field208 < this.field199.field1011.length);

               this.field208 -= this.field199.field1012;
            } while(this.field208 >= 0 && this.field208 < this.field199.field1011.length);

            this.field199 = null;
         }

         this.field201 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = class9.getObjectDefinition(this.field204);
      if(null != var1.impostorIds) {
         var1 = var1.getImpostor();
      }

      if(null == var1) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field195 != 1 && this.field195 != 3) {
            var2 = var1.field959;
            var3 = var1.field960;
         } else {
            var2 = var1.field960;
            var3 = var1.field959;
         }

         int var4 = (var2 >> 1) + this.field197;
         int var5 = (1 + var2 >> 1) + this.field197;
         int var6 = this.field198 + (var3 >> 1);
         int var7 = this.field198 + (var3 + 1 >> 1);
         int[][] var8 = class5.tileHeights[this.field193];
         int var9 = var8[var5][var7] + var8[var4][var6] + var8[var5][var6] + var8[var4][var7] >> 2;
         int var10 = (var2 << 6) + (this.field197 << 7);
         int var11 = (var3 << 6) + (this.field198 << 7);
         return var1.method852(this.field194, this.field195, var8, var10, var9, var11, this.field199, this.field208);
      }
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field204 = var1;
      this.field194 = var2;
      this.field195 = var3;
      this.field193 = var4;
      this.field197 = var5;
      this.field198 = var6;
      if(var7 != -1) {
         this.field199 = class192.getAnimation(var7);
         this.field208 = 0;
         this.field201 = Client.gameCycle - 1;
         if(this.field199.replyMode == 0 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field199 == var10.field199) {
               this.field208 = var10.field208;
               this.field201 = var10.field201;
               return;
            }
         }

         if(var8 && this.field199.field1012 != -1) {
            this.field208 = (int)(Math.random() * (double)this.field199.field1011.length);
            this.field201 -= (int)(Math.random() * (double)this.field199.field1019[this.field208]);
         }
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "11"
   )
   static final void method154() {
      for(int var0 = 0; var0 < Client.field343; ++var0) {
         int var1 = Client.field555[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field347.method2544();
         int var4;
         int var5;
         int var6;
         if((var3 & 8) != 0) {
            var4 = Client.field347.method2546();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field347.method2653();
            if(var2.animation == var4 && var4 != -1) {
               var6 = class192.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field880 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field871 = 0;
               }

               if(var6 == 2) {
                  var2.field871 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class192.getAnimation(var4).field1014 >= class192.getAnimation(var2.animation).field1014) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field880 = 0;
               var2.actionAnimationDisable = var5;
               var2.field871 = 0;
               var2.field894 = var2.field889;
            }
         }

         if((var3 & 1) != 0) {
            var2.graphic = Client.field347.method2528();
            var4 = Client.field347.method2589();
            var2.field876 = var4 >> 16;
            var2.field835 = Client.gameCycle + (var4 & '\uffff');
            var2.field873 = 0;
            var2.field874 = 0;
            if(var2.field835 > Client.gameCycle) {
               var2.field873 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 64) != 0) {
            var2.composition = Friend.getNpcDefinition(Client.field347.method2546());
            var2.field839 = var2.composition.field910;
            var2.field888 = var2.composition.field933;
            var2.field859 = var2.composition.field916;
            var2.field844 = var2.composition.field930;
            var2.field845 = var2.composition.field918;
            var2.field846 = var2.composition.field907;
            var2.idlePoseAnimation = var2.composition.field934;
            var2.field862 = var2.composition.field921;
            var2.field842 = var2.composition.field915;
         }

         int var7;
         if((var3 & 4) != 0) {
            var4 = Client.field347.method2620();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field347.method2573();
                  if(var6 == 32767) {
                     var6 = Client.field347.method2573();
                     var8 = Client.field347.method2573();
                     var7 = Client.field347.method2573();
                     var9 = Client.field347.method2573();
                  } else if(var6 != 32766) {
                     var8 = Client.field347.method2573();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field347.method2573();
                  var2.method784(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field347.method2544();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field347.method2573();
                  var8 = Client.field347.method2573();
                  if(var8 != 32767) {
                     var9 = Client.field347.method2573();
                     var10 = Client.field347.method2544();
                     int var11 = var8 > 0?Client.field347.method2571():var10;
                     var2.method785(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method786(var7);
                  }
               }
            }
         }

         if((var3 & 16) != 0) {
            var2.interacting = Client.field347.method2572();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 32) != 0) {
            var4 = Client.field347.method2725();
            var5 = Client.field347.method2725();
            var6 = var2.x - (var4 - class193.baseX - class193.baseX) * 64;
            var7 = var2.y - (var5 - DecorativeObject.baseY - DecorativeObject.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field863 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 2) != 0) {
            var2.overhead = Client.field347.method2552();
            var2.field847 = 100;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass0;I)V",
      garbageValue = "952381949"
   )
   static void method155(class0 var0) {
      ChatLineBuffer.method634(var0, 200000);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[LModIcon;",
      garbageValue = "2107775237"
   )
   static ModIcon[] method156() {
      ModIcon[] var0 = new ModIcon[class79.field1436];

      for(int var1 = 0; var1 < class79.field1436; ++var1) {
         ModIcon var2 = var0[var1] = new ModIcon();
         var2.width = class169.field2713;
         var2.originalHeight = class79.field1435;
         var2.offsetX = class79.field1439[var1];
         var2.offsetY = class79.field1438[var1];
         var2.originalWidth = class79.field1443[var1];
         var2.height = class79.field1440[var1];
         var2.palette = class129.field2092;
         var2.pixels = class79.field1441[var1];
      }

      ChatLineBuffer.method649();
      return var0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModIcon;",
      garbageValue = "2027608568"
   )
   static ModIcon method157() {
      ModIcon var0 = new ModIcon();
      var0.width = class169.field2713;
      var0.originalHeight = class79.field1435;
      var0.offsetX = class79.field1439[0];
      var0.offsetY = class79.field1438[0];
      var0.originalWidth = class79.field1443[0];
      var0.height = class79.field1440[0];
      var0.palette = class129.field2092;
      var0.pixels = class79.field1441[0];
      ChatLineBuffer.method649();
      return var0;
   }
}
