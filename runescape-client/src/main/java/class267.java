import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public class class267 {
   @ObfuscatedName("i")
   static final char[] field3674;
   @ObfuscatedName("j")
   static final char[] field3677;
   @ObfuscatedName("de")
   static class153 field3679;

   static {
      field3674 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
      field3677 = new char[]{'[', ']', '#'};
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(Lclass76;B)V",
      garbageValue = "0"
   )
   static final void method4888(class76 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field1199 == 0) {
         var1 = class61.region.method2701(var0.field1203, var0.field1200, var0.field1201);
      }

      if(var0.field1199 == 1) {
         var1 = class61.region.method2702(var0.field1203, var0.field1200, var0.field1201);
      }

      if(var0.field1199 == 2) {
         var1 = class61.region.method2703(var0.field1203, var0.field1200, var0.field1201);
      }

      if(var0.field1199 == 3) {
         var1 = class61.region.method2704(var0.field1203, var0.field1200, var0.field1201);
      }

      if(var1 != 0) {
         int var5 = class61.region.method2770(var0.field1203, var0.field1200, var0.field1201, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1202 = var2;
      var0.field1214 = var3;
      var0.field1211 = var4;
   }
}
