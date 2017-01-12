import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class114 {
   @ObfuscatedName("x")
   static String field1775 = null;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = 898180123
   )
   static int field1776;
   @ObfuscatedName("u")
   static Applet field1778 = null;
   @ObfuscatedName("eg")
   static ModIcon[] field1780;

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   static void method2162(int var0, int var1) {
      class38 var2 = class9.field89;
      class33.menuAction(var2.field787, var2.field785, var2.field786, var2.field784, var2.field790, var2.field790, var0, var1);
      class9.field89 = null;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "-754557752"
   )
   static final void method2175(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field567 == 0) {
         var1 = class6.region.method1696(var0.field584, var0.field568, var0.field569);
      }

      if(var0.field567 == 1) {
         var1 = class6.region.method1697(var0.field584, var0.field568, var0.field569);
      }

      if(var0.field567 == 2) {
         var1 = class6.region.method1698(var0.field584, var0.field568, var0.field569);
      }

      if(var0.field567 == 3) {
         var1 = class6.region.method1699(var0.field584, var0.field568, var0.field569);
      }

      if(var1 != 0) {
         int var5 = class6.region.method1714(var0.field584, var0.field568, var0.field569, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field570 = var2;
      var0.field574 = var3;
      var0.field571 = var4;
   }
}
