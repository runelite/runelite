import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class114 {
   @ObfuscatedName("e")
   public static String field1784 = null;
   @ObfuscatedName("i")
   static Applet field1788 = null;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1608593208"
   )
   static void method2163(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field678[var5] != var0) {
            var2[var4] = World.field678[var5];
            var3[var4] = World.field674[var5];
            ++var4;
         }
      }

      World.field678 = var2;
      World.field674 = var3;
      class142.method2646(class107.worldList, 0, class107.worldList.length - 1, World.field678, World.field674);
   }
}
