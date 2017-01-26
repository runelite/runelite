import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class49 extends Renderable {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -499615483
   )
   int field953;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1815773663
   )
   int field954;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -506023957
   )
   int field955;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1635980813
   )
   int field956;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -388559665
   )
   int field957;
   @ObfuscatedName("j")
   Sequence field958;
   @ObfuscatedName("bo")
   static ModIcon field959;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1561540145
   )
   int field960;
   @ObfuscatedName("bp")
   static class184 field962;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -510924751
   )
   static int field963;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 181401113
   )
   int field965;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -911430899
   )
   int field967;

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field965 = var1;
      this.field954 = var2;
      this.field955 = var3;
      this.field956 = var4;
      this.field957 = var5;
      this.field953 = var6;
      if(var7 != -1) {
         this.field958 = class146.getAnimation(var7);
         this.field960 = 0;
         this.field967 = Client.gameCycle - 1;
         if(this.field958.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(var10.field958 == this.field958) {
               this.field960 = var10.field960;
               this.field967 = var10.field967;
               return;
            }
         }

         if(var8 && this.field958.frameStep != -1) {
            this.field960 = (int)(Math.random() * (double)this.field958.frameIDs.length);
            this.field967 -= (int)(Math.random() * (double)this.field958.frameLenghts[this.field960]);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2063755858"
   )
   protected final Model getModel() {
      if(null != this.field958) {
         int var1 = Client.gameCycle - this.field967;
         if(var1 > 100 && this.field958.frameStep > 0) {
            var1 = 100;
         }

         label60: {
            do {
               do {
                  if(var1 <= this.field958.frameLenghts[this.field960]) {
                     break label60;
                  }

                  var1 -= this.field958.frameLenghts[this.field960];
                  ++this.field960;
               } while(this.field960 < this.field958.frameIDs.length);

               this.field960 -= this.field958.frameStep;
            } while(this.field960 >= 0 && this.field960 < this.field958.frameIDs.length);

            this.field958 = null;
         }

         this.field967 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class217.getObjectDefinition(this.field965);
      if(null != var12.impostorIds) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field955 != 1 && this.field955 != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = this.field957 + (var2 >> 1);
         int var5 = this.field957 + (var2 + 1 >> 1);
         int var6 = this.field953 + (var3 >> 1);
         int var7 = this.field953 + (var3 + 1 >> 1);
         int[][] var8 = class10.tileHeights[this.field956];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var4][var6] + var8[var5][var6] >> 2;
         int var10 = (this.field957 << 7) + (var2 << 6);
         int var11 = (var3 << 6) + (this.field953 << 7);
         return var12.method3602(this.field954, this.field955, var8, var10, var9, var11, this.field958, this.field960);
      }
   }
}
