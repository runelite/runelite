import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("b")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("r")
   @Export("previousName")
   String field248;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1246044911
   )
   @Export("world")
   int field249;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1244882187
   )
   int field250;
   @ObfuscatedName("y")
   boolean field251;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 2018633355
   )
   @Export("cameraY")
   static int field254;
   @ObfuscatedName("x")
   static int[] field256;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 1420280507
   )
   @Export("baseY")
   static int field257;
   @ObfuscatedName("k")
   static int[] field258;
   @ObfuscatedName("a")
   @Export("name")
   String field261;
   @ObfuscatedName("e")
   boolean field263;

   @ObfuscatedName("bo")
   static final void method205(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field227 == 0) {
         var1 = class77.field1396.method1948(var0.field236, var0.field229, var0.field244);
      }

      if(1 == var0.field227) {
         var1 = class77.field1396.method1949(var0.field236, var0.field229, var0.field244);
      }

      if(var0.field227 == 2) {
         var1 = class77.field1396.method1950(var0.field236, var0.field229, var0.field244);
      }

      if(3 == var0.field227) {
         var1 = class77.field1396.method1951(var0.field236, var0.field229, var0.field244);
      }

      if(0 != var1) {
         int var5 = class77.field1396.method2087(var0.field236, var0.field229, var0.field244, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field228 = var2;
      var0.field233 = var3;
      var0.field232 = var4;
   }
}
