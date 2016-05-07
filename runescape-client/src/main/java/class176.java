import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class176 {
   @ObfuscatedName("j")
   @Export("settings")
   public static int[] field2918;
   @ObfuscatedName("s")
   public static int[] field2919 = new int[32];
   @ObfuscatedName("p")
   @Export("widgetSettings")
   public static int[] field2920;
   @ObfuscatedName("eg")
   static class78[] field2921;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1210448693
   )
   static int field2922;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2919[var1] = var0 - 1;
         var0 += var0;
      }

      field2918 = new int[2000];
      field2920 = new int[2000];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass168;",
      garbageValue = "0"
   )
   static class168 method3436(int var0, boolean var1, boolean var2, boolean var3) {
      class134 var4 = null;
      if(class149.field2243 != null) {
         var4 = new class134(var0, class149.field2243, class20.field570[var0], 1000000);
      }

      return new class168(var4, class30.field709, var0, var1, var2, var3);
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2087997972"
   )
   static final void method3437(int var0) {
      if(class188.method3731(var0)) {
         class17.method203(class217.field3171[var0], -1);
      }
   }
}
