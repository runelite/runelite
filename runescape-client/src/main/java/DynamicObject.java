import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljg;"
   )
   Sequence field1543;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1581002617
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1140677741
   )
   int field1547;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -968208439
   )
   @Export("type")
   int type;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -463285165
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1331028599
   )
   @Export("level")
   int level;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -488042345
   )
   int field1546;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 907518845
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -160305821
   )
   @Export("sceneY")
   int sceneY;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLef;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1543 = class112.getAnimation(var7);
         this.field1546 = 0;
         this.field1547 = Client.gameCycle - 1;
         if(this.field1543.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.field1543 == var10.field1543) {
               this.field1546 = var10.field1546;
               this.field1547 = var10.field1547;
               return;
            }
         }

         if(var8 && this.field1543.frameStep != -1) {
            this.field1546 = (int)(Math.random() * (double)this.field1543.frameIDs.length);
            this.field1547 -= (int)(Math.random() * (double)this.field1543.frameLenghts[this.field1546]);
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Lej;",
      garbageValue = "19"
   )
   protected final Model getModel() {
      if(this.field1543 != null) {
         int var1 = Client.gameCycle - this.field1547;
         if(var1 > 100 && this.field1543.frameStep > 0) {
            var1 = 100;
         }

         label55: {
            do {
               do {
                  if(var1 <= this.field1543.frameLenghts[this.field1546]) {
                     break label55;
                  }

                  var1 -= this.field1543.frameLenghts[this.field1546];
                  ++this.field1546;
               } while(this.field1546 < this.field1543.frameIDs.length);

               this.field1546 -= this.field1543.frameStep;
            } while(this.field1546 >= 0 && this.field1546 < this.field1543.frameIDs.length);

            this.field1543 = null;
         }

         this.field1547 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = PlayerComposition.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = this.sceneX + (var2 >> 1);
         int var5 = (1 + var2 >> 1) + this.sceneX;
         int var6 = this.sceneY + (var3 >> 1);
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var5][var6] + var8[var4][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4463(this.type, this.orientation, var8, var10, var9, var11, this.field1543, this.field1546);
      }
   }
}
