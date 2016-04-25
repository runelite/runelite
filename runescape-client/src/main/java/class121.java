import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class121 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 206215063
   )
   static int field1979 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1469916507
   )
   static int field1980 = 0;
   @ObfuscatedName("e")
   static byte[][] field1981 = new byte[50][];
   @ObfuscatedName("z")
   static byte[][] field1982 = new byte[1000][];
   @ObfuscatedName("x")
   static byte[][] field1983 = new byte[250][];
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -364750983
   )
   static int field1985;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2062229475
   )
   static int field1986 = 0;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1559645593"
   )
   static synchronized byte[] method2730(int var0) {
      byte[] var1;
      if(100 == var0 && field1980 > 0) {
         var1 = field1982[--field1980];
         field1982[field1980] = null;
         return var1;
      } else if(var0 == 5000 && field1979 > 0) {
         var1 = field1983[--field1979];
         field1983[field1979] = null;
         return var1;
      } else if(var0 == 30000 && field1986 > 0) {
         var1 = field1981[--field1986];
         field1981[field1986] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "759830342"
   )
   static void method2732() {
      if(client.field511) {
         class173 var0 = class46.method972(class10.field167, client.field429);
         if(var0 != null && null != var0.field2836) {
            class0 var1 = new class0();
            var1.field18 = var0;
            var1.field16 = var0.field2836;
            class37.method749(var1);
         }

         client.field511 = false;
         class2.method28(var0);
      }
   }
}
