import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public final class class31 extends Renderable {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1717270121
   )
   int field705;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1748232969
   )
   int field706;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1185796447
   )
   int field707;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -969330915
   )
   int field708 = 0;
   @ObfuscatedName("pp")
   static class137 field709;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 556891469
   )
   int field710;
   @ObfuscatedName("m")
   Sequence field711;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 666873331
   )
   int field712;
   @ObfuscatedName("h")
   boolean field714 = false;
   @ObfuscatedName("o")
   static int[] field715;
   @ObfuscatedName("em")
   static SpritePixels[] field716;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1670410911
   )
   int field717 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2003128941
   )
   int field718;
   @ObfuscatedName("a")
   static Buffer field719;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "86"
   )
   static final void method676() {
      class48.field1076.reset();
      class43.field987.reset();
      KitDefinition.field1052.reset();
      ObjectComposition.field937.reset();
      ObjectComposition.field938.reset();
      ObjectComposition.field957.reset();
      ObjectComposition.field984.reset();
      SecondaryBufferProvider.method1682();
      ItemComposition.field1172.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class118.method2514();
      class119.method2516();
      class50.field1102.reset();
      class56.field1221.reset();
      class51.field1112.reset();
      class51.spriteCache.reset();
      class51.field1116.reset();
      class49.field1086.reset();
      class49.field1090.reset();
      class165.method3230();
      Widget.field2878.reset();
      Widget.field2793.reset();
      Widget.field2794.reset();
      Widget.field2795.reset();
      ((TextureProvider)class94.field1647).method2246();
      class23.field595.reset();
      class35.field789.method3337();
      class158.field2336.method3337();
      Buffer.field2060.method3337();
      class13.field195.method3337();
      class38.field820.method3337();
      Client.field423.method3337();
      class1.field13.method3337();
      class127.field2092.method3337();
      class59.field1254.method3337();
      class158.field2343.method3337();
      class9.field151.method3337();
      Client.field311.method3337();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-9743592"
   )
   static final void method677() {
      for(Projectile var0 = (Projectile)Client.projectiles.method3864(); null != var0; var0 = (Projectile)Client.projectiles.method3851()) {
         if(var0.floor == class145.plane && Client.gameCycle <= var0.field104) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(null != var1 && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method85(var1.x, var1.y, class109.method2439(var1.x, var1.y, var0.floor) - var0.field102, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(Client.localInteractingIndex == var2) {
                     var3 = class165.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method85(var3.x, var3.y, class109.method2439(var3.x, var3.y, var0.floor) - var0.field102, Client.gameCycle);
                  }
               }

               var0.method88(Client.field357);
               Frames.region.method1972(class145.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field99, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   class31(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field705 = var1;
      this.field707 = var2;
      this.field718 = var3;
      this.field712 = var4;
      this.field710 = var5;
      this.field706 = var7 + var6;
      int var8 = class156.method3182(this.field705).field1035;
      if(var8 != -1) {
         this.field714 = false;
         this.field711 = NPC.getAnimation(var8);
      } else {
         this.field714 = true;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-69"
   )
   final void method680(int var1) {
      if(!this.field714) {
         this.field717 += var1;

         while(this.field717 > this.field711.field1008[this.field708]) {
            this.field717 -= this.field711.field1008[this.field708];
            ++this.field708;
            if(this.field708 >= this.field711.field1006.length) {
               this.field714 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1714992488"
   )
   protected final Model getModel() {
      class45 var1 = class156.method3182(this.field705);
      Model var2;
      if(!this.field714) {
         var2 = var1.method938(this.field708);
      } else {
         var2 = var1.method938(-1);
      }

      return null == var2?null:var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1900881996"
   )
   public static int method685(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;I)V",
      garbageValue = "-413882005"
   )
   static final void method687(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      if(var4 != null) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class94.field1650[var6];
            int var9 = class94.field1651[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = 256 * var9 / (256 + Client.mapScaleDelta);
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var9 * var3 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method1759(var5.field2947 / 2 + var10 - var4.field1460 / 2, var5.field2942 / 2 - var11 - var4.field1464 / 2, var0, var1, var5.field2947, var5.field2942, var5.field2944, var5.field2941);
            } else {
               var4.method1760(var0 + var5.field2947 / 2 + var10 - var4.field1460 / 2, var5.field2942 / 2 + var1 - var11 - var4.field1464 / 2);
            }

         }
      }
   }
}
