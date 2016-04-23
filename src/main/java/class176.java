import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class176 {
   @ObfuscatedName("m")
   @Export("widgetSettings")
   public static int[] field2900;
   @ObfuscatedName("h")
   @Export("settings")
   public static int[] field2901;
   @ObfuscatedName("j")
   static int[] field2902 = new int[32];
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 515204351
   )
   static int field2905;
   @ObfuscatedName("aq")
   static int[] field2907;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass52;",
      garbageValue = "1994561822"
   )
   public static class52 method3415(int var0) {
      class52 var1 = (class52)class52.field1141.method3704((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class52.field1149.method3217(16, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1071(new class119(var2));
         }

         class52.field1141.method3706(var1, (long)var0);
         return var1;
      }
   }

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2902[var1] = var0 - 1;
         var0 += var0;
      }

      field2901 = new int[2000];
      field2900 = new int[2000];
   }
}
