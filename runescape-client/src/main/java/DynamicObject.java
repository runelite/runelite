import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("v")
   static int[] field1228;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -397638811
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -407435463
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1144788199
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 685446185
   )
   @Export("level")
   int level;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1126673881
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1918137409
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   Sequence field1233;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1383469485
   )
   @Export("animFrame")
   int animFrame;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1546300439
   )
   @Export("animCycleCount")
   int animCycleCount;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLdz;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1233 = class137.getAnimation(var7);
         this.animFrame = 0;
         this.animCycleCount = Client.gameCycle - 1;
         if(this.field1233.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.field1233 == var10.field1233) {
               this.animFrame = var10.animFrame;
               this.animCycleCount = var10.animCycleCount;
               return;
            }
         }

         if(var8 && this.field1233.frameStep != -1) {
            this.animFrame = (int)(Math.random() * (double)this.field1233.frameIDs.length);
            this.animCycleCount -= (int)(Math.random() * (double)this.field1233.frameLengths[this.animFrame]);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Ldk;",
      garbageValue = "111"
   )
   protected final Model getModel() {
      if(this.field1233 != null) {
         int var1 = Client.gameCycle - this.animCycleCount;
         if(var1 > 100 && this.field1233.frameStep > 0) {
            var1 = 100;
         }

         label54: {
            do {
               do {
                  if(var1 <= this.field1233.frameLengths[this.animFrame]) {
                     break label54;
                  }

                  var1 -= this.field1233.frameLengths[this.animFrame];
                  ++this.animFrame;
               } while(this.animFrame < this.field1233.frameIDs.length);

               this.animFrame -= this.field1233.frameStep;
            } while(this.animFrame >= 0 && this.animFrame < this.field1233.frameIDs.length);

            this.field1233 = null;
         }

         this.animCycleCount = Client.gameCycle - var1;
      }

      ObjectComposition var12 = SoundTaskDataProvider.getObjectDefinition(this.id);
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
         int[][] var8 = class50.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var4][var6] + var8[var5][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method5092(this.type, this.orientation, var8, var10, var9, var11, this.field1233, this.animFrame);
      }
   }
}
