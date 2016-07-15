import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class179 {
   @ObfuscatedName("c")
   @Export("widgetSettings")
   public static int[] field2944;
   @ObfuscatedName("e")
   public static int[] field2945 = new int[32];
   @ObfuscatedName("l")
   @Export("settings")
   public static int[] field2946;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2945[var1] = var0 - 1;
         var0 += var0;
      }

      field2946 = new int[2000];
      field2944 = new int[2000];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-1012265091"
   )
   public static void method3548(class170 var0) {
      class53.field1159 = var0;
   }
}
