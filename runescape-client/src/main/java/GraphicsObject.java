import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("nk")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static SpritePixels field1280;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 410980155
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -28285143
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1014138851
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1599576869
   )
   @Export("level")
   int level;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 274878075
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -169473045
   )
   @Export("y")
   int y;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2005972509
   )
   @Export("height")
   int height;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   Sequence field1275;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1179306289
   )
   int field1276;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1471925407
   )
   int field1277;
   @ObfuscatedName("n")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1276 = 0;
      this.field1277 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class245.getSpotAnimType(this.id).field3387;
      if(var8 != -1) {
         this.finished = false;
         this.field1275 = class90.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "520686279"
   )
   final void method1635(int var1) {
      if(!this.finished) {
         this.field1277 += var1;

         while(this.field1277 > this.field1275.frameLenghts[this.field1276]) {
            this.field1277 -= this.field1275.frameLenghts[this.field1276];
            ++this.field1276;
            if(this.field1276 >= this.field1275.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1008738898"
   )
   protected final Model getModel() {
      Spotanim var1 = class245.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4321(this.field1276);
      } else {
         var2 = var1.method4321(-1);
      }

      return var2 == null?null:var2;
   }
}
