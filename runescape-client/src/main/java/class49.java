import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class49 extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1083420323
   )
   int field973;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1260220461
   )
   int field974;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1196833887
   )
   int field975;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 380864689
   )
   protected static int field976;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2104218689
   )
   int field977;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1736521857
   )
   int field978;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1629483833
   )
   int field979;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1744730729
   )
   int field980;
   @ObfuscatedName("r")
   Sequence field982;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1153675571
   )
   int field983;
   @ObfuscatedName("v")
   static int[][][] field984;

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field974 = var1;
      this.field973 = var2;
      this.field978 = var3;
      this.field975 = var4;
      this.field983 = var5;
      this.field977 = var6;
      if(var7 != -1) {
         this.field982 = class195.getAnimation(var7);
         this.field979 = 0;
         this.field980 = Client.gameCycle - 1;
         if(this.field982.replyMode == 0 && null != var9 && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(this.field982 == var10.field982) {
               this.field979 = var10.field979;
               this.field980 = var10.field980;
               return;
            }
         }

         if(var8 && this.field982.frameStep != -1) {
            this.field979 = (int)(Math.random() * (double)this.field982.frameIDs.length);
            this.field980 -= (int)(Math.random() * (double)this.field982.frameLenghts[this.field979]);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "286397846"
   )
   protected final Model getModel() {
      if(this.field982 != null) {
         int var12 = Client.gameCycle - this.field980;
         if(var12 > 100 && this.field982.frameStep > 0) {
            var12 = 100;
         }

         label61: {
            do {
               do {
                  if(var12 <= this.field982.frameLenghts[this.field979]) {
                     break label61;
                  }

                  var12 -= this.field982.frameLenghts[this.field979];
                  ++this.field979;
               } while(this.field979 < this.field982.frameIDs.length);

               this.field979 -= this.field982.frameStep;
            } while(this.field979 >= 0 && this.field979 < this.field982.frameIDs.length);

            this.field982 = null;
         }

         this.field980 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = class187.getObjectDefinition(this.field974);
      if(null != var1.impostorIds) {
         var1 = var1.getImpostor();
      }

      if(null == var1) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field978 != 1 && this.field978 != 3) {
            var2 = var1.sizeX;
            var3 = var1.sizeY;
         } else {
            var2 = var1.sizeY;
            var3 = var1.sizeX;
         }

         int var4 = this.field983 + (var2 >> 1);
         int var5 = this.field983 + (1 + var2 >> 1);
         int var6 = this.field977 + (var3 >> 1);
         int var7 = this.field977 + (var3 + 1 >> 1);
         int[][] var8 = class10.tileHeights[this.field975];
         int var9 = var8[var4][var6] + var8[var5][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.field983 << 7) + (var2 << 6);
         int var11 = (this.field977 << 7) + (var3 << 6);
         return var1.method3623(this.field973, this.field978, var8, var10, var9, var11, this.field982, this.field979);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "1234894972"
   )
   static final void method973(class68 var0) {
      var0.field1158 = false;
      if(var0.field1156 != null) {
         var0.field1156.field1190 = 0;
      }

      for(class68 var1 = var0.vmethod2734(); null != var1; var1 = var0.vmethod2717()) {
         method973(var1);
      }

   }
}
