import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("ff")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 347987907
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 105460573
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -368900621
   )
   @Export("level")
   int level;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -915572563
   )
   @Export("x")
   int x;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1095122683
   )
   @Export("y")
   int y;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1344357911
   )
   @Export("height")
   int height;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   Sequence field1275;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 220288827
   )
   int field1272;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1335842449
   )
   int field1273;
   @ObfuscatedName("g")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1272 = 0;
      this.field1273 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = MapLabel.getSpotAnimType(this.id).field3494;
      if(var8 != -1) {
         this.finished = false;
         this.field1275 = class158.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-105"
   )
   final void method1873(int var1) {
      if(!this.finished) {
         this.field1273 += var1;

         while(this.field1273 > this.field1275.frameLenghts[this.field1272]) {
            this.field1273 -= this.field1275.frameLenghts[this.field1272];
            ++this.field1272;
            if(this.field1272 >= this.field1275.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lek;",
      garbageValue = "22"
   )
   protected final Model getModel() {
      Spotanim var1 = MapLabel.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1272);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }
}
