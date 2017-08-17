import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1475735003
   )
   @Export("id")
   int id;
   @ObfuscatedName("b")
   @Export("finished")
   boolean finished;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1714962167
   )
   int field1367;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1691295051
   )
   int field1359;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   Sequence field1366;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -571656313
   )
   @Export("level")
   int level;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 591241167
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1432849723
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 671463779
   )
   @Export("height")
   int height;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1251247855
   )
   @Export("startCycle")
   int startCycle;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1359 = 0;
      this.field1367 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class36.getSpotAnimType(this.id).field3316;
      if(var8 != -1) {
         this.finished = false;
         this.field1366 = PendingSpawn.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Leo;",
      garbageValue = "1214595416"
   )
   protected final Model getModel() {
      Spotanim var1 = class36.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4367(this.field1359);
      } else {
         var2 = var1.method4367(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1752768936"
   )
   final void method1671(int var1) {
      if(!this.finished) {
         this.field1367 += var1;

         while(this.field1367 > this.field1366.frameLenghts[this.field1359]) {
            this.field1367 -= this.field1366.frameLenghts[this.field1359];
            ++this.field1359;
            if(this.field1359 >= this.field1366.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }
}
