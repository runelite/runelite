import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
public class class121 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -576467757
   )
   static int field2014 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -206819805
   )
   static int field2015 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1681124235
   )
   static int field2016 = 0;
   @ObfuscatedName("e")
   static byte[][] field2018 = new byte[250][];
   @ObfuscatedName("y")
   static byte[][] field2019 = new byte[50][];
   @ObfuscatedName("p")
   static byte[][] field2020 = new byte[1000][];

   @ObfuscatedName("w")
   static synchronized byte[] method2744(int var0) {
      byte[] var1;
      if(100 == var0 && field2016 > 0) {
         var1 = field2020[--field2016];
         field2020[field2016] = null;
         return var1;
      } else if(5000 == var0 && field2015 > 0) {
         var1 = field2018[--field2015];
         field2018[field2015] = null;
         return var1;
      } else if(var0 == 30000 && field2014 > 0) {
         var1 = field2019[--field2014];
         field2019[field2014] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("a")
   static boolean method2747(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3335(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class149.method3145(var3);
         return true;
      }
   }
}
