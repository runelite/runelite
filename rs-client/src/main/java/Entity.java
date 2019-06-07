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
   @Export("renderDraw")
   void renderDraw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
      Model var11 = this.getModel();
      if(var11 != null) {
         this.height = var11.height;
         var11.renderDraw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }
}
