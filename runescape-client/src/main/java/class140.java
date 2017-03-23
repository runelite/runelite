import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class140 extends Node {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 153789049
   )
   int field1975;
   @ObfuscatedName("i")
   class142 field1976;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 80936217
   )
   int field1977;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1320011443
   )
   int field1978;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1688114963
   )
   int field1979;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 111071581
   )
   int field1980;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -950338343
   )
   int field1981;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1192444513
   )
   int field1983;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 5193875
   )
   int field1984;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1629222513
   )
   int field1985;
   @ObfuscatedName("u")
   class55 field1986;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1907444771
   )
   int field1987;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -821837301
   )
   int field1988;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -709456417
   )
   int field1989;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 638634987
   )
   int field1990;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2064452423
   )
   int field1991;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 309470009
   )
   int field1992;
   @ObfuscatedName("z")
   class66 field1993;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1787443603
   )
   int field1994;
   @ObfuscatedName("h")
   class137 field1995;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2000380183
   )
   int field1996;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1223405660"
   )
   void method2682() {
      this.field1976 = null;
      this.field1986 = null;
      this.field1995 = null;
      this.field1993 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-2131509706"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2928.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2897.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field2904 = var0;
         if(var2 != null) {
            var1.method3639(new Buffer(var2));
         }

         var1.method3638();
         if(var1.isSolid) {
            var1.field2914 = 0;
            var1.field2915 = false;
         }

         ObjectComposition.field2928.put(var1, (long)var0);
         return var1;
      }
   }
}
