import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class90 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 212982245
   )
   static int field1541;
   @ObfuscatedName("mx")
   @Export("clanMembers")
   static class24[] field1542;
   @ObfuscatedName("ej")
   static class78[] field1544;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass2;III)V",
      garbageValue = "1316342844"
   )
   static void method2100(class2 var0, int var1, int var2) {
      if(var0.field819 == var1 && var1 != -1) {
         int var3 = class46.method974(var1).field971;
         if(1 == var3) {
            var0.field789 = 0;
            var0.field821 = 0;
            var0.field822 = var2;
            var0.field823 = 0;
         }

         if(var3 == 2) {
            var0.field823 = 0;
         }
      } else if(-1 == var1 || var0.field819 == -1 || class46.method974(var1).field973 >= class46.method974(var0.field819).field973) {
         var0.field819 = var1;
         var0.field789 = 0;
         var0.field821 = 0;
         var0.field822 = var2;
         var0.field823 = 0;
         var0.field811 = var0.field834;
      }

   }

   @ObfuscatedName("bv")
   static final void method2101(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(0 == var0.field225) {
         var1 = class151.field2250.method1952(var0.field239, var0.field226, var0.field227);
      }

      if(1 == var0.field225) {
         var1 = class151.field2250.method1942(var0.field239, var0.field226, var0.field227);
      }

      if(2 == var0.field225) {
         var1 = class151.field2250.method2012(var0.field239, var0.field226, var0.field227);
      }

      if(var0.field225 == 3) {
         var1 = class151.field2250.method1955(var0.field239, var0.field226, var0.field227);
      }

      if(0 != var1) {
         int var5 = class151.field2250.method1979(var0.field239, var0.field226, var0.field227, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field228 = var2;
      var0.field233 = var3;
      var0.field230 = var4;
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "-2012893764"
   )
   static void method2102(class173 var0) {
      class173 var1 = var0.field2774 == -1?null:class148.method3129(var0.field2774);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class35.field762;
         var3 = class21.field575;
      } else {
         var2 = var1.field2770;
         var3 = var1.field2834;
      }

      class48.method993(var0, var2, var3, false);
      class45.method946(var0, var2, var3);
   }
}
