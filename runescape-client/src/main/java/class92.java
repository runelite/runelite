import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public final class class92 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2134031093
   )
   int field1626;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1140542389
   )
   int field1627;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -187436831
   )
   int field1628;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -377942455
   )
   int field1629;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -141799917
   )
   int field1630;
   @ObfuscatedName("s")
   boolean field1631 = true;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1170981507
   )
   int field1632;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass170;B)V",
      garbageValue = "9"
   )
   public static void method2160(class170 var0, class170 var1, class170 var2, class170 var3) {
      Widget.field2798 = var0;
      Widget.field2799 = var1;
      Widget.field2846 = var2;
      class49.field1113 = var3;
      Widget.widgets = new Widget[Widget.field2798.method3406()][];
      Widget.validInterfaces = new boolean[Widget.field2798.method3406()];
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1629 = var1;
      this.field1628 = var2;
      this.field1627 = var3;
      this.field1626 = var4;
      this.field1630 = var5;
      this.field1632 = var6;
      this.field1631 = var7;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2137452360"
   )
   static final void method2161(int var0, int var1) {
      if(var0 != class48.field1092 || var1 != class16.field242) {
         class48.field1092 = var0;
         class16.field242 = var1;
         class138.setGameState(25);
         class9.method131("Loading - please wait.", true);
         int var2 = class0.baseX;
         int var3 = class21.baseY;
         class0.baseX = (var0 - 6) * 8;
         class21.baseY = (var1 - 6) * 8;
         int var4 = class0.baseX - var2;
         int var5 = class21.baseY - var3;
         var2 = class0.baseX;
         var3 = class21.baseY;

         int var6;
         int var7;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var8 = Client.cachedNPCs[var6];
            if(var8 != null) {
               for(var7 = 0; var7 < 10; ++var7) {
                  var8.pathX[var7] -= var4;
                  var8.pathY[var7] -= var5;
               }

               var8.x -= 128 * var4;
               var8.y -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var19 = Client.cachedPlayers[var6];
            if(var19 != null) {
               for(var7 = 0; var7 < 10; ++var7) {
                  var19.pathX[var7] -= var4;
                  var19.pathY[var7] -= var5;
               }

               var19.x -= 128 * var4;
               var19.y -= 128 * var5;
            }
         }

         byte var20 = 0;
         byte var9 = 104;
         byte var10 = 1;
         if(var4 < 0) {
            var20 = 103;
            var9 = -1;
            var10 = -1;
         }

         byte var11 = 0;
         byte var12 = 104;
         byte var13 = 1;
         if(var5 < 0) {
            var11 = 103;
            var12 = -1;
            var13 = -1;
         }

         int var14;
         for(int var15 = var20; var9 != var15; var15 += var10) {
            for(var14 = var11; var14 != var12; var14 += var13) {
               int var16 = var15 + var4;
               int var17 = var14 + var5;

               for(int var18 = 0; var18 < 4; ++var18) {
                  if(var16 >= 0 && var17 >= 0 && var16 < 104 && var17 < 104) {
                     Client.groundItemDeque[var18][var15][var14] = Client.groundItemDeque[var18][var16][var17];
                  } else {
                     Client.groundItemDeque[var18][var15][var14] = null;
                  }
               }
            }
         }

         for(class16 var21 = (class16)Client.field427.method3980(); null != var21; var21 = (class16)Client.field427.method3970()) {
            var21.field238 -= var4;
            var21.field231 -= var5;
            if(var21.field238 < 0 || var21.field231 < 0 || var21.field238 >= 104 || var21.field231 >= 104) {
               var21.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field536 = 0;
         Client.field542 = false;
         Client.field523 = -1;
         Client.field429.method3996();
         Client.projectiles.method3996();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].method2493();
         }
      }

   }
}
