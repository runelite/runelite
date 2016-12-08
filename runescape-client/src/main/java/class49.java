import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class49 extends Renderable {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1389832743
   )
   int field955;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -202848479
   )
   int field956;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 685226111
   )
   int field957;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 941314981
   )
   int field958;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1188503631
   )
   int field959;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 736864427
   )
   int field960;
   @ObfuscatedName("l")
   Sequence field961;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -415758949
   )
   int field962;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 919230603
   )
   int field963;
   @ObfuscatedName("br")
   static ModIcon field965;

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field958 = var1;
      this.field955 = var2;
      this.field957 = var3;
      this.field963 = var4;
      this.field959 = var5;
      this.field956 = var6;
      if(var7 != -1) {
         this.field961 = class31.getAnimation(var7);
         this.field960 = 0;
         this.field962 = Client.gameCycle - 1;
         if(this.field961.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(this.field961 == var10.field961) {
               this.field960 = var10.field960;
               this.field962 = var10.field962;
               return;
            }
         }

         if(var8 && this.field961.frameStep != -1) {
            this.field960 = (int)(Math.random() * (double)this.field961.frameIDs.length);
            this.field962 -= (int)(Math.random() * (double)this.field961.frameLenghts[this.field960]);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-12"
   )
   protected final Model getModel() {
      if(this.field961 != null) {
         int var1 = Client.gameCycle - this.field962;
         if(var1 > 100 && this.field961.frameStep > 0) {
            var1 = 100;
         }

         label63: {
            do {
               do {
                  if(var1 <= this.field961.frameLenghts[this.field960]) {
                     break label63;
                  }

                  var1 -= this.field961.frameLenghts[this.field960];
                  ++this.field960;
               } while(this.field960 < this.field961.frameIDs.length);

               this.field960 -= this.field961.frameStep;
            } while(this.field960 >= 0 && this.field960 < this.field961.frameIDs.length);

            this.field961 = null;
         }

         this.field962 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class143.getObjectDefinition(this.field958);
      if(null != var12.impostorIds) {
         var12 = var12.getImpostor();
      }

      if(null == var12) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field957 != 1 && this.field957 != 3) {
            var2 = var12.field2905;
            var3 = var12.field2938;
         } else {
            var2 = var12.field2938;
            var3 = var12.field2905;
         }

         int var4 = (var2 >> 1) + this.field959;
         int var5 = (1 + var2 >> 1) + this.field959;
         int var6 = (var3 >> 1) + this.field956;
         int var7 = this.field956 + (1 + var3 >> 1);
         int[][] var8 = class10.tileHeights[this.field963];
         int var9 = var8[var5][var7] + var8[var4][var6] + var8[var5][var6] + var8[var4][var7] >> 2;
         int var10 = (this.field959 << 7) + (var2 << 6);
         int var11 = (this.field956 << 7) + (var3 << 6);
         return var12.method3515(this.field955, this.field957, var8, var10, var9, var11, this.field961, this.field960);
      }
   }
}
