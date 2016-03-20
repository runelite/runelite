import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dw")
public class class123 {
   @ObfuscatedName("m")
   public static short[][] field2027;

   @ObfuscatedName("s")
   public static void method2786() {
      class139 var0 = class139.field2136;
      synchronized(class139.field2136) {
         class139.field2138 = class139.field2141;
         class139.field2140 = class139.field2137;
         class139.field2135 = class139.field2133;
         class139.field2145 = class139.field2151;
         class139.field2146 = class139.field2142;
         class139.field2147 = class139.field2143;
         class139.field2148 = class139.field2134;
         class139.field2151 = 0;
      }
   }

   @ObfuscatedName("a")
   public static int method2790(class118 var0, String var1) {
      int var2 = var0.field1979;
      byte[] var3 = class139.method2953(var1);
      var0.method2510(var3.length);
      var0.field1979 += class221.field3177.method2440(var3, 0, var3.length, var0.field1980, var0.field1979);
      return var0.field1979 - var2;
   }
}
