import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 477441379
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1714992488"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("ac")
   void vmethod2392(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2392(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }
}
