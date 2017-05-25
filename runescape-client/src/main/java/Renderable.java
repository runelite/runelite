import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -571778433
   )
   @Export("modelHeight")
   public int modelHeight;

   @ObfuscatedName("ck")
   void vmethod2903(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2903(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1208682604"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "1"
   )
   public static final void method2907(int var0, int var1, int var2, int var3, int var4) {
      class7.field232.method3634(new class8(var0, var1, var2, var3, var4));
   }
}
