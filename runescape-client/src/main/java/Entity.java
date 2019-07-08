import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("Entity")
public abstract class Entity extends DualNode {
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 849583845
   )
   @Export("height")
   public int height;

   protected Entity() {
      this.height = 1000;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldu;",
      garbageValue = "-2134947096"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cy")
   @Export("draw")
   void draw(int yaw, int cameraPitchSine, int cameraPitchCosine, int cameraYawSine, int cameraYawCosine, int x, int y, int var8, long tag) {
      Model var11 = this.getModel();
      if (var11 != null) {
         this.height = var11.height;
         var11.draw(yaw, cameraPitchSine, cameraPitchCosine, cameraYawSine, cameraYawCosine, x, y, var8, tag);
      }

   }
}
