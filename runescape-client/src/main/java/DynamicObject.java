import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 598731609
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 848782455
   )
   @Export("type")
   int type;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1428459525
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -14031925
   )
   @Export("level")
   int level;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 24290275
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -73535131
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   Sequence field1454;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1270951669
   )
   int field1456;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1287210683
   )
   int field1457;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLeb;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1454 = class270.getAnimation(var7);
         this.field1456 = 0;
         this.field1457 = Client.gameCycle - 1;
         if(this.field1454.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1454 == this.field1454) {
               this.field1456 = var10.field1456;
               this.field1457 = var10.field1457;
               return;
            }
         }

         if(var8 && this.field1454.frameStep != -1) {
            this.field1456 = (int)(Math.random() * (double)this.field1454.frameIDs.length);
            this.field1457 -= (int)(Math.random() * (double)this.field1454.frameLenghts[this.field1456]);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lel;",
      garbageValue = "2099798459"
   )
   protected final Model getModel() {
      if(this.field1454 != null) {
         int var1 = Client.gameCycle - this.field1457;
         if(var1 > 100 && this.field1454.frameStep > 0) {
            var1 = 100;
         }

         label53: {
            do {
               do {
                  if(var1 <= this.field1454.frameLenghts[this.field1456]) {
                     break label53;
                  }

                  var1 -= this.field1454.frameLenghts[this.field1456];
                  ++this.field1456;
               } while(this.field1456 < this.field1454.frameIDs.length);

               this.field1456 -= this.field1454.frameStep;
            } while(this.field1456 >= 0 && this.field1456 < this.field1454.frameIDs.length);

            this.field1454 = null;
         }

         this.field1457 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class169.getObjectDefinition(this.id);
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
         int[][] var8 = class62.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method5147(this.type, this.orientation, var8, var10, var9, var11, this.field1454, this.field1456);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "99848304"
   )
   static final void method2059() {
      class243.method4617("You can\'t add yourself to your own ignore list");
   }
}
