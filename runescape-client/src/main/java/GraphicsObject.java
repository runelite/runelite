import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1167687871
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1329397819
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 575072753
   )
   @Export("level")
   int level;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -974728277
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 67811127
   )
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1349999035
   )
   @Export("height")
   int height;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   Sequence field1275;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 954736431
   )
   int field1276;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -202786333
   )
   int field1269;
   @ObfuscatedName("n")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1276 = 0;
      this.field1269 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class285.getSpotAnimType(this.id).field3386;
      if(var8 != -1) {
         this.finished = false;
         this.field1275 = ItemLayer.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "874353074"
   )
   final void method1748(int var1) {
      if(!this.finished) {
         this.field1269 += var1;

         while(this.field1269 > this.field1275.frameLenghts[this.field1276]) {
            this.field1269 -= this.field1275.frameLenghts[this.field1276];
            ++this.field1276;
            if(this.field1276 >= this.field1275.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-1864051962"
   )
   protected final Model getModel() {
      Spotanim var1 = class285.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4520(this.field1276);
      } else {
         var2 = var1.method4520(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1906748871"
   )
   public static int method1747(int var0) {
      return var0 >> 11 & 63;
   }
}
