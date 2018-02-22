import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1519588391
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2033173111
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 763941871
   )
   @Export("level")
   int level;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1648686179
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -750365413
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1685116545
   )
   @Export("height")
   int height;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   Sequence field1241;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1245692255
   )
   int field1242;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1811479713
   )
   int field1235;
   @ObfuscatedName("c")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1242 = 0;
      this.field1235 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = IndexFile.getSpotAnimType(this.id).field3425;
      if(var8 != -1) {
         this.finished = false;
         this.field1241 = Occluder.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-113"
   )
   final void method1817(int var1) {
      if(!this.finished) {
         this.field1235 += var1;

         while(this.field1235 > this.field1241.frameLenghts[this.field1242]) {
            this.field1235 -= this.field1241.frameLenghts[this.field1242];
            ++this.field1242;
            if(this.field1242 >= this.field1241.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "582025400"
   )
   protected final Model getModel() {
      Spotanim var1 = IndexFile.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1242);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }
}
