import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class165 {
   @ObfuscatedName("x")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("g")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("p")
   public static int[] field2162 = new int[32];
   @ObfuscatedName("c")
   static int[] field2163;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2162[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1122813682"
   )
   static final void method3119(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field480; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field483[var4] = true;
         }
      }

   }

   class165() throws Throwable {
      throw new Error();
   }
}
