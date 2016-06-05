import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class183 {
   @ObfuscatedName("p")
   public static class180 field2974;
   @ObfuscatedName("g")
   public static class167 field2975;
   @ObfuscatedName("h")
   public static class184 field2976;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1287090851
   )
   static int field2977;
   @ObfuscatedName("t")
   public static class167 field2978;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 367291591
   )
   public static int field2980;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -866986341
   )
   public static int field2981 = 0;

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "787089150"
   )
   static final void method3545(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field230 == 0) {
         var1 = class214.field3161.method1990(var0.field229, var0.field226, var0.field227);
      }

      if(var0.field230 == 1) {
         var1 = class214.field3161.method1897(var0.field229, var0.field226, var0.field227);
      }

      if(var0.field230 == 2) {
         var1 = class214.field3161.method1914(var0.field229, var0.field226, var0.field227);
      }

      if(var0.field230 == 3) {
         var1 = class214.field3161.method1899(var0.field229, var0.field226, var0.field227);
      }

      if(var1 != 0) {
         int var5 = class214.field3161.method1994(var0.field229, var0.field226, var0.field227, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field224 = var2;
      var0.field228 = var3;
      var0.field233 = var4;
   }
}
