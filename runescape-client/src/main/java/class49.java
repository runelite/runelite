import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class49 extends Renderable {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1258332305
   )
   static int field967;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 466103987
   )
   int field968;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 219703127
   )
   int field969;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2031629327
   )
   int field970;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 783293339
   )
   int field971;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1637938381
   )
   int field972;
   @ObfuscatedName("u")
   Sequence field973;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1923884399
   )
   int field975;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1995977747
   )
   int field976;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1214970011
   )
   int field977;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-10054"
   )
   protected final Model getModel() {
      if(null != this.field973) {
         int var1 = Client.gameCycle - this.field975;
         if(var1 > 100 && this.field973.frameStep > 0) {
            var1 = 100;
         }

         label64: {
            do {
               do {
                  if(var1 <= this.field973.frameLenghts[this.field970]) {
                     break label64;
                  }

                  var1 -= this.field973.frameLenghts[this.field970];
                  ++this.field970;
               } while(this.field970 < this.field973.frameIDs.length);

               this.field970 -= this.field973.frameStep;
            } while(this.field970 >= 0 && this.field970 < this.field973.frameIDs.length);

            this.field973 = null;
         }

         this.field975 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class195.getObjectDefinition(this.field968);
      if(null != var12.impostorIds) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field977 != 1 && this.field977 != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = (var2 >> 1) + this.field971;
         int var5 = this.field971 + (var2 + 1 >> 1);
         int var6 = this.field969 + (var3 >> 1);
         int var7 = this.field969 + (1 + var3 >> 1);
         int[][] var8 = class10.tileHeights[this.field976];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var4][var6] + var8[var5][var6] >> 2;
         int var10 = (this.field971 << 7) + (var2 << 6);
         int var11 = (this.field969 << 7) + (var3 << 6);
         return var12.method3615(this.field972, this.field977, var8, var10, var9, var11, this.field973, this.field970);
      }
   }

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field968 = var1;
      this.field972 = var2;
      this.field977 = var3;
      this.field976 = var4;
      this.field971 = var5;
      this.field969 = var6;
      if(var7 != -1) {
         this.field973 = class168.getAnimation(var7);
         this.field970 = 0;
         this.field975 = Client.gameCycle - 1;
         if(this.field973.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(var10.field973 == this.field973) {
               this.field970 = var10.field970;
               this.field975 = var10.field975;
               return;
            }
         }

         if(var8 && this.field973.frameStep != -1) {
            this.field970 = (int)(Math.random() * (double)this.field973.frameIDs.length);
            this.field975 -= (int)(Math.random() * (double)this.field973.frameLenghts[this.field970]);
         }
      }

   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1277971667"
   )
   static final void method979() {
      Client.field432 = 0;
      int var0 = CombatInfoListHolder.baseX + (class22.localPlayer.x >> 7);
      int var1 = (class22.localPlayer.y >> 7) + class3.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field432 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field432 = 1;
      }

      if(Client.field432 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field432 = 0;
      }

   }
}
