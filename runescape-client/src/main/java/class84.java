import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("FaceNormal")
public class class84 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 214322857
   )
   int field1458;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1551157057
   )
   int field1459;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1544574945
   )
   int field1460;
   @ObfuscatedName("h")
   static String[] field1461;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -1350765729
   )
   static int field1464;
   @ObfuscatedName("y")
   static class80 field1465;

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(Lclass173;IB)Ljava/lang/String;",
      garbageValue = "3"
   )
   static String method1858(class173 var0, int var1) {
      int var3 = class138.method2906(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && null == var0.field2847?null:(var0.field2850 != null && var0.field2850.length > var1 && var0.field2850[var1] != null && var0.field2850[var1].trim().length() != 0?var0.field2850[var1]:null);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "746337925"
   )
   static void method1859() {
      for(class23 var0 = (class23)class23.field599.method3797(); null != var0; var0 = (class23)class23.field599.method3779()) {
         if(null != var0.field598) {
            var0.method564();
         }
      }

   }
}
