import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public final class class107 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1282455061
   )
   int field1836;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2109168511
   )
   int field1837;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 406077509
   )
   int field1839;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -724097235
   )
   int field1840;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1812627245
   )
   int field1841;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1126485611
   )
   int field1843;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 657833135
   )
   int field1844;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2038013603
   )
   int field1845;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1038730761
   )
   int field1846;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1065821063
   )
   int field1847;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1190598009
   )
   int field1848;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1003806969
   )
   int field1849;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 911185627
   )
   int field1850;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2036686003
   )
   int field1851;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1965957481
   )
   int field1852;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1062069405
   )
   int field1853;
   @ObfuscatedName("rt")
   protected static boolean field1854;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -322083959
   )
   int field1855;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1277374247
   )
   int field1856;

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1541402784"
   )
   static final void method2360(boolean var0) {
      class110.method2445();
      ++Client.field330;
      if(Client.field330 >= 50 || var0) {
         Client.field330 = 0;
         if(!Client.field335 && class28.field671 != null) {
            Client.field324.method2828(45);

            try {
               class28.field671.method3027(Client.field324.payload, 0, Client.field324.offset);
               Client.field324.offset = 0;
            } catch (IOException var2) {
               Client.field335 = true;
            }
         }

      }
   }
}
