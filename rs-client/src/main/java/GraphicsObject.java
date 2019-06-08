import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("GraphicsObject")
public final class GraphicsObject extends Entity {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1807262579
   )
   @Export("__bw_d")
   static int __bw_d;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("__bw_k")
   static IndexedSprite __bw_k;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -438288575
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -289084031
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1245488067
   )
   @Export("cycleStart")
   int cycleStart;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 432847573
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1189549567
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1416438985
   )
   @Export("y")
   int y;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1156757009
   )
   @Export("height")
   int height;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   @Export("sequenceDefinition")
   SequenceDefinition sequenceDefinition;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1541221595
   )
   @Export("frame")
   int frame;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1950327625
   )
   @Export("frameCycle")
   int frameCycle;
   @ObfuscatedName("x")
   @Export("isFinished")
   boolean isFinished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.frame = 0;
      this.frameCycle = 0;
      this.isFinished = false;
      this.id = var1;
      this.plane = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.cycleStart = var7 + var6;
      int var8 = class50.getSpotAnimationDefinition(this.id).sequence;
      if(var8 != -1) {
         this.isFinished = false;
         this.sequenceDefinition = WorldMapAreaData.getSequenceDefinition(var8);
      } else {
         this.isFinished = true;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-730240149"
   )
   @Export("advance")
   final void advance(int var1) {
      if(!this.isFinished) {
         this.frameCycle += var1;

         while(this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
            this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
            ++this.frame;
            if(this.frame >= this.sequenceDefinition.frameIds.length) {
               this.isFinished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldu;",
      garbageValue = "-2134947096"
   )
   protected final Model getModel() {
      SpotAnimationDefinition var1 = class50.getSpotAnimationDefinition(this.id);
      Model var2;
      if(!this.isFinished) {
         var2 = var1.getModel(this.frame);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "1241216858"
   )
   static final int method1986(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }
}
