import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1625643107
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2114743249
   )
   @Export("type")
   int type;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 504095065
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1581690875
   )
   @Export("level")
   int level;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 445271139
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 253897065
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   Sequence field1422;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 680967879
   )
   int field1428;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -937118633
   )
   int field1423;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLec;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1422 = CacheFile.getAnimation(var7);
         this.field1428 = 0;
         this.field1423 = Client.gameCycle - 1;
         if(this.field1422.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1422 == this.field1422) {
               this.field1428 = var10.field1428;
               this.field1423 = var10.field1423;
               return;
            }
         }

         if(var8 && this.field1422.frameStep != -1) {
            this.field1428 = (int)(Math.random() * (double)this.field1422.frameIDs.length);
            this.field1423 -= (int)(Math.random() * (double)this.field1422.frameLenghts[this.field1428]);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-2096748380"
   )
   protected final Model getModel() {
      if(this.field1422 != null) {
         int var1 = Client.gameCycle - this.field1423;
         if(var1 > 100 && this.field1422.frameStep > 0) {
            var1 = 100;
         }

         label55: {
            do {
               do {
                  if(var1 <= this.field1422.frameLenghts[this.field1428]) {
                     break label55;
                  }

                  var1 -= this.field1422.frameLenghts[this.field1428];
                  ++this.field1428;
               } while(this.field1428 < this.field1422.frameIDs.length);

               this.field1428 -= this.field1422.frameStep;
            } while(this.field1428 >= 0 && this.field1428 < this.field1422.frameIDs.length);

            this.field1422 = null;
         }

         this.field1423 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = TextureProvider.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.width;
            var3 = var12.length;
         } else {
            var2 = var12.length;
            var3 = var12.width;
         }

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var5][var6] + var8[var4][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4786(this.type, this.orientation, var8, var10, var9, var11, this.field1422, this.field1428);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1136540539"
   )
   @Export("loadCurrentSong")
   public static boolean loadCurrentSong() {
      return class214.field2596 != 0?true:class214.field2595.method3963();
   }
}
