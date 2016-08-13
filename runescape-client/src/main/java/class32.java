import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class32 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 945408375
   )
   int field729;
   @ObfuscatedName("an")
   static SpritePixels[] field731;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2031326021
   )
   int field732;
   @ObfuscatedName("h")
   String field733;
   @ObfuscatedName("ed")
   static SpritePixels field735;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1338337337
   )
   int field737;
   @ObfuscatedName("p")
   static boolean field738;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1591210625
   )
   int field739;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIB)LSpritePixels;",
      garbageValue = "125"
   )
   public static SpritePixels method699(class170 var0, int var1, int var2) {
      return !class4.method49(var0, var1, var2)?null:class23.method597();
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   static final void method700() {
      for(int var0 = 0; var0 < Client.field454; ++var0) {
         int var1 = Client.field336[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field339.method2633();
         if((var3 & 8) != 0) {
            var2.overhead = Client.field339.method2663();
            var2.field847 = 100;
         }

         int var4;
         int var5;
         int var6;
         if((var3 & 16) != 0) {
            var4 = Client.field339.method2670();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field339.method2617();
            if(var4 == var2.animation && var4 != -1) {
               var6 = class22.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field848 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field867 = 0;
               }

               if(var6 == 2) {
                  var2.field867 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class22.getAnimation(var4).field1023 >= class22.getAnimation(var2.animation).field1023) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field848 = 0;
               var2.actionAnimationDisable = var5;
               var2.field867 = 0;
               var2.field839 = var2.field849;
            }
         }

         int var7;
         if((var3 & 4) != 0) {
            var4 = Client.field339.method2749();
            var5 = Client.field339.method2803();
            var6 = var2.x - (var4 - class0.baseX - class0.baseX) * 64;
            var7 = var2.y - 64 * (var5 - class21.baseY - class21.baseY);
            if(var6 != 0 || var7 != 0) {
               var2.field859 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 64) != 0) {
            var4 = Client.field339.method2633();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field339.method2646();
                  if(var6 == 32767) {
                     var6 = Client.field339.method2646();
                     var8 = Client.field339.method2646();
                     var7 = Client.field339.method2646();
                     var9 = Client.field339.method2646();
                  } else if(var6 != 32766) {
                     var8 = Client.field339.method2646();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field339.method2646();
                  var2.method795(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field339.method2662();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field339.method2646();
                  var8 = Client.field339.method2646();
                  if(var8 != 32767) {
                     var9 = Client.field339.method2646();
                     var10 = Client.field339.method2662();
                     int var11 = var8 > 0?Client.field339.method2662():var10;
                     var2.method796(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method797(var7);
                  }
               }
            }
         }

         if((var3 & 2) != 0) {
            var2.composition = class16.getNpcDefinition(Client.field339.method2635());
            var2.field877 = var2.composition.field913;
            var2.field846 = var2.composition.field936;
            var2.field879 = var2.composition.field919;
            var2.field840 = var2.composition.field917;
            var2.field841 = var2.composition.field932;
            var2.field831 = var2.composition.field922;
            var2.idlePoseAnimation = var2.composition.field931;
            var2.field866 = var2.composition.field928;
            var2.field853 = var2.composition.field923;
         }

         if((var3 & 1) != 0) {
            var2.interacting = Client.field339.method2670();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 32) != 0) {
            var2.graphic = Client.field339.method2803();
            var4 = Client.field339.method2799();
            var2.field872 = var4 >> 16;
            var2.field871 = (var4 & '\uffff') + Client.gameCycle;
            var2.field890 = 0;
            var2.field858 = 0;
            if(var2.field871 > Client.gameCycle) {
               var2.field890 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }
      }

   }
}
