import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class25 {
   @ObfuscatedName("b")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1458031421
   )
   int field375;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   Coordinates field374;

   @ObfuscatedSignature(
      signature = "(ILix;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field375 = var1;
      this.field374 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-640028135"
   )
   public static void method200(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-114"
   )
   public static void method201() {
      Widget.field2817.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2819.reset();
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(Lin;IIII)V",
      garbageValue = "2109013568"
   )
   static final void method202(Widget var0, int var1, int var2, int var3) {
      class236 var4 = var0.method4425(false);
      if(var4 != null) {
         if(Client.field1099 < 3) {
            class7.compass.method5875(var1, var2, var4.field2773, var4.field2772, 25, 25, Client.mapAngle, 256, var4.field2774, var4.field2771);
         } else {
            Rasterizer2D.method5737(var1, var2, 0, var4.field2774, var4.field2771);
         }

      }
   }
}
