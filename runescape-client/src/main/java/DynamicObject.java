import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1491631469
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1983970681
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -382740061
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1135912917
   )
   @Export("level")
   int level;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1823920007
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -452987337
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   Sequence field1448;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1071554321
   )
   int field1447;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1341536839
   )
   int field1446;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLeu;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1448 = class90.getAnimation(var7);
         this.field1447 = 0;
         this.field1446 = Client.gameCycle - 1;
         if(this.field1448.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1448 == this.field1448) {
               this.field1447 = var10.field1447;
               this.field1446 = var10.field1446;
               return;
            }
         }

         if(var8 && this.field1448.frameStep != -1) {
            this.field1447 = (int)(Math.random() * (double)this.field1448.frameIDs.length);
            this.field1446 -= (int)(Math.random() * (double)this.field1448.frameLenghts[this.field1447]);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1008738898"
   )
   protected final Model getModel() {
      if(this.field1448 != null) {
         int var1 = Client.gameCycle - this.field1446;
         if(var1 > 100 && this.field1448.frameStep > 0) {
            var1 = 100;
         }

         label55: {
            do {
               do {
                  if(var1 <= this.field1448.frameLenghts[this.field1447]) {
                     break label55;
                  }

                  var1 -= this.field1448.frameLenghts[this.field1447];
                  ++this.field1447;
               } while(this.field1447 < this.field1448.frameIDs.length);

               this.field1447 -= this.field1448.frameStep;
            } while(this.field1447 >= 0 && this.field1447 < this.field1448.frameIDs.length);

            this.field1448 = null;
         }

         this.field1446 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = ClientPacket.getObjectDefinition(this.id);
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

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var4][var7] + var8[var4][var6] + var8[var5][var6] + var8[var5][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4518(this.type, this.orientation, var8, var10, var9, var11, this.field1448, this.field1447);
      }
   }
}
