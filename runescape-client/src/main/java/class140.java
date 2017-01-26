import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class140 extends Node {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1245378183
   )
   int field1957;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1509601479
   )
   int field1958;
   @ObfuscatedName("q")
   class137 field1959;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 419582791
   )
   int field1960;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 340267183
   )
   int field1961;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -581474687
   )
   int field1963;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 517019115
   )
   int field1964;
   @ObfuscatedName("g")
   class142 field1965;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1549279753
   )
   int field1966;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1239863023
   )
   int field1967;
   @ObfuscatedName("x")
   class55 field1968;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 18684061
   )
   int field1969;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1285245939
   )
   int field1970;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -771198091
   )
   int field1971;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1376104135
   )
   int field1972;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1258919037
   )
   int field1973;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1536177471
   )
   int field1974;
   @ObfuscatedName("w")
   class66 field1975;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -178163805
   )
   int field1976;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -110765543
   )
   int field1977;
   @ObfuscatedName("es")
   static SpritePixels[] field1978;
   @ObfuscatedName("cm")
   static class102 field1979;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1819443433
   )
   int field1981;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-2109382875"
   )
   public static boolean method2636(char var0) {
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         if(var0 != 0) {
            char[] var1 = class203.field3069;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-152720678"
   )
   void method2637() {
      this.field1965 = null;
      this.field1968 = null;
      this.field1959 = null;
      this.field1975 = null;
   }
}
