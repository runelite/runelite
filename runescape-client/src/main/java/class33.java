import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public final class class33 extends Renderable {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -686630585
   )
   int field740;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1229944737
   )
   int field741;
   @ObfuscatedName("y")
   Sequence field742;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1271133595
   )
   int field743;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 331501577
   )
   int field744;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 828879893
   )
   int field745;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1711699233
   )
   int field746 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -417479497
   )
   int field748 = 0;
   @ObfuscatedName("i")
   boolean field749 = false;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -901715569
   )
   static int field750;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1698593239
   )
   int field751;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2016293900"
   )
   static final int method769(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & 16711935) * var3 + var2 * (var1 & 16711935) & -16711936) + ((var1 & '\uff00') * var2 + (var0 & '\uff00') * var3 & 16711680) >> 8;
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field740 = var1;
      this.field751 = var2;
      this.field743 = var3;
      this.field744 = var4;
      this.field745 = var5;
      this.field741 = var7 + var6;
      int var8 = class157.method3129(this.field740).field2797;
      if(var8 != -1) {
         this.field749 = false;
         this.field742 = TextureProvider.getAnimation(var8);
      } else {
         this.field749 = true;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "529735633"
   )
   final void method770(int var1) {
      if(!this.field749) {
         this.field748 += var1;

         while(this.field748 > this.field742.frameLenghts[this.field746]) {
            this.field748 -= this.field742.frameLenghts[this.field746];
            ++this.field746;
            if(this.field746 >= this.field742.frameIDs.length) {
               this.field749 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "58"
   )
   static final void method773() {
      if(XGrandExchangeOffer.field30 != null) {
         XGrandExchangeOffer.field30.method2139();
         XGrandExchangeOffer.field30 = null;
      }

      class3.method37();
      Friend.region.method1790();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2342();
      }

      System.gc();
      WallObject.method1982(2);
      Client.field528 = -1;
      Client.field439 = false;
      World.method693();
      World.setGameState(10);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)LWidget;",
      garbageValue = "0"
   )
   public static Widget method774(int var0, int var1) {
      Widget var2 = ChatLineBuffer.method993(var0);
      return var1 == -1?var2:(var2 != null && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      Spotanim var1 = class157.method3129(this.field740);
      Model var2;
      if(!this.field749) {
         var2 = var1.method3535(this.field746);
      } else {
         var2 = var1.method3535(-1);
      }

      return null == var2?null:var2;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1835962489"
   )
   static final void method776(boolean var0) {
      Client.field557 = 0;
      Client.field513 = 0;
      class20.method213();
      class162.method3180(var0);

      int var1;
      int var2;
      for(var1 = 0; var1 < Client.field513; ++var1) {
         var2 = Client.field331[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = Client.field334.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         int var8;
         if((var4 & 1) != 0) {
            var5 = Client.field334.method2924();
            var6 = Client.field334.method2924();
            var7 = var3.x - (var5 - Player.baseX - Player.baseX) * 64;
            var8 = var3.y - 64 * (var6 - SecondaryBufferProvider.baseY - SecondaryBufferProvider.baseY);
            if(var7 != 0 || var8 != 0) {
               var3.field631 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 64) != 0) {
            var3.graphic = Client.field334.method2923();
            var5 = Client.field334.method2931();
            var3.field616 = var5 >> 16;
            var3.field643 = Client.gameCycle + (var5 & '\uffff');
            var3.field648 = 0;
            var3.field642 = 0;
            if(var3.field643 > Client.gameCycle) {
               var3.field648 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 16) != 0) {
            var3.interacting = Client.field334.method2922();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 32) != 0) {
            var5 = Client.field334.method2992();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = Client.field334.method3039();
                  if(var7 == 32767) {
                     var7 = Client.field334.method3039();
                     var9 = Client.field334.method3039();
                     var8 = Client.field334.method3039();
                     var10 = Client.field334.method3039();
                  } else if(var7 != 32766) {
                     var9 = Client.field334.method3039();
                  } else {
                     var7 = -1;
                  }

                  var11 = Client.field334.method3039();
                  var3.method624(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = Client.field334.method2913();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = Client.field334.method3039();
                  var9 = Client.field334.method3039();
                  if(var9 != 32767) {
                     var10 = Client.field334.method3039();
                     var11 = Client.field334.method2913();
                     int var12 = var9 > 0?Client.field334.readUnsignedByte():var11;
                     var3.method622(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method626(var8);
                  }
               }
            }
         }

         if((var4 & 2) != 0) {
            var3.composition = class159.getNpcDefinition(Client.field334.method2922());
            var3.field607 = var3.composition.field3040;
            var3.field656 = var3.composition.field3035;
            var3.field632 = var3.composition.field3011;
            var3.field612 = var3.composition.field3019;
            var3.field603 = var3.composition.field3029;
            var3.field614 = var3.composition.field3021;
            var3.idlePoseAnimation = var3.composition.field3015;
            var3.field610 = var3.composition.field3016;
            var3.field621 = var3.composition.field3017;
         }

         if((var4 & 4) != 0) {
            var5 = Client.field334.method2923();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = Client.field334.method2914();
            if(var3.animation == var5 && var5 != -1) {
               var7 = TextureProvider.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field629 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field639 = 0;
               }

               if(var7 == 2) {
                  var3.field639 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || TextureProvider.getAnimation(var5).forcedPriority >= TextureProvider.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field629 = 0;
               var3.actionAnimationDisable = var6;
               var3.field639 = 0;
               var3.field662 = var3.field657;
            }
         }

         if((var4 & 8) != 0) {
            var3.overhead = Client.field334.readString();
            var3.field637 = 100;
         }
      }

      for(var1 = 0; var1 < Client.field557; ++var1) {
         var2 = Client.field318[var1];
         if(Client.cachedNPCs[var2].field622 != Client.gameCycle) {
            Client.cachedNPCs[var2].composition = null;
            Client.cachedNPCs[var2] = null;
         }
      }

      if(Client.field334.offset != Client.field335) {
         throw new RuntimeException(Client.field334.offset + "," + Client.field335);
      } else {
         for(var1 = 0; var1 < Client.field328; ++var1) {
            if(null == Client.cachedNPCs[Client.field285[var1]]) {
               throw new RuntimeException(var1 + "," + Client.field328);
            }
         }

      }
   }
}
