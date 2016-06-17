import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class176 {
   @ObfuscatedName("g")
   @Export("settings")
   public static int[] field2894;
   @ObfuscatedName("j")
   @Export("widgetSettings")
   public static int[] field2896;
   @ObfuscatedName("b")
   public static int[] field2898 = new int[32];

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2898[var1] = var0 - 1;
         var0 += var0;
      }

      field2894 = new int[2000];
      field2896 = new int[2000];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IS)Lclass39;",
      garbageValue = "255"
   )
   @Export("getNpcDefinition")
   public static class39 method3460(int var0) {
      class39 var1 = (class39)class39.field861.method3764((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class39.field886.method3266(9, var0);
         var1 = new class39();
         var1.field867 = var0;
         if(var2 != null) {
            var1.method789(new class119(var2));
         }

         var1.method768();
         class39.field861.method3759(var1, (long)var0);
         return var1;
      }
   }
}
