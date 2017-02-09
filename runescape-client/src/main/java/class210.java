import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class210 {
   @ObfuscatedName("w")
   public static class182 field3109;
   @ObfuscatedName("k")
   public static class152 field3110;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "888367043"
   )
   static void method3946(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field669[var5]) {
            var2[var4] = World.field669[var5];
            var3[var4] = World.field674[var5];
            ++var4;
         }
      }

      World.field669 = var2;
      World.field674 = var3;
      class103.method1962(WidgetNode.worldList, 0, WidgetNode.worldList.length - 1, World.field669, World.field674);
   }

   class210() throws Throwable {
      throw new Error();
   }
}
