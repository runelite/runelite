import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1438830713
   )
   @Export("modelHeight")
   public int modelHeight;

   @ObfuscatedName("by")
   void vmethod2859(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2859(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1914243094"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LSpotanim;",
      garbageValue = "8"
   )
   public static Spotanim method2864(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field3330.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3347.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field3334 = var0;
         if(var2 != null) {
            var1.method4341(new Buffer(var2));
         }

         Spotanim.field3330.put(var1, (long)var0);
         return var1;
      }
   }
}
