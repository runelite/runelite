import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -1667513523
   )
   static int field2051;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1062304309
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lei;",
      garbageValue = "1329079562"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cf")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([I[IB)V",
      garbageValue = "118"
   )
   public static void method3051(int[] var0, int[] var1) {
      if(var0 != null && var1 != null) {
         class195.field2584 = var0;
         OwnWorldComparator.field866 = new int[var0.length];
         class319.field3930 = new byte[var0.length][][];

         for(int var2 = 0; var2 < class195.field2584.length; ++var2) {
            class319.field3930[var2] = new byte[var1[var2]][];
         }

      } else {
         class195.field2584 = null;
         OwnWorldComparator.field866 = null;
         class319.field3930 = null;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1868311539"
   )
   static final int method3058(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
