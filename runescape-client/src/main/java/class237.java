import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class237 {
   @ObfuscatedName("d")
   @Export("varpsMasks")
   static int[] varpsMasks;
   @ObfuscatedName("z")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("n")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      varpsMasks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         varpsMasks[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[Llv;",
      garbageValue = "1346623749"
   )
   static IndexedSprite[] method4477() {
      IndexedSprite[] var0 = new IndexedSprite[class18.field325];

      for(int var1 = 0; var1 < class18.field325; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class332.field3995;
         var2.originalHeight = class332.field3991;
         var2.offsetX = class332.field3990[var1];
         var2.offsetY = class332.offsetsY[var1];
         var2.originalWidth = Varbit.field3539[var1];
         var2.height = BoundingBox2D.field242[var1];
         var2.palette = class332.field3994;
         var2.pixels = class332.spritePixels[var1];
      }

      class151.method3208();
      return var0;
   }
}
