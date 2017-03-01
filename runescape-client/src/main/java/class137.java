import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class137 {
   @ObfuscatedName("n")
   byte[] field1904;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2124065695
   )
   int field1905;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -134517233
   )
   int field1906;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 279689239
   )
   int field1907;
   @ObfuscatedName("x")
   byte[] field1908;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1973067111
   )
   int field1910;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 27066239
   )
   int field1911;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1613662345
   )
   int field1912;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1542304531
   )
   int field1914;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIB)Z",
      garbageValue = "-6"
   )
   static boolean method2556(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class112.method2186(var3);
         return true;
      }
   }
}
