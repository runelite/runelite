import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public final class class107 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1432391943
   )
   int field1820;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 344404329
   )
   int field1821;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 985436203
   )
   int field1822;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2028152437
   )
   int field1823;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -54251069
   )
   int field1824;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1436347663
   )
   int field1825;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1450877373
   )
   int field1826;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 441811605
   )
   int field1827;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1847990843
   )
   int field1828;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1618831291
   )
   int field1829;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 686014095
   )
   int field1830;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2126764849
   )
   int field1831;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 867182397
   )
   int field1832;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1095158571
   )
   int field1833;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -817619117
   )
   int field1834;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 79941847
   )
   int field1835;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 154888455
   )
   int field1836;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 727237967
   )
   int field1837;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Lclass45;",
      garbageValue = "8"
   )
   public static class45 method2269(int var0) {
      class45 var1 = (class45)class45.field988.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field989.method3272(13, var0);
         var1 = new class45();
         var1.field1000 = var0;
         if(null != var2) {
            var1.method914(new Buffer(var2));
         }

         class45.field988.put(var1, (long)var0);
         return var1;
      }
   }
}
