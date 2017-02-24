import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class137 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 542343803
   )
   int field1901;
   @ObfuscatedName("d")
   byte[] field1902;
   @ObfuscatedName("q")
   byte[] field1903;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1869304045
   )
   int field1905;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2010570243
   )
   int field1906;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 826731951
   )
   int field1907;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1556582771
   )
   int field1908;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1337270891
   )
   int field1910;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1693934427
   )
   int field1912;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "13"
   )
   public static String method2528(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1670732120"
   )
   static void method2529() {
      if(Client.field511) {
         Widget var0 = class57.method1157(Friend.field166, Client.field461);
         if(var0 != null && null != var0.field2206) {
            class18 var1 = new class18();
            var1.field198 = var0;
            var1.field209 = var0.field2206;
            FloorUnderlayDefinition.method3491(var1);
         }

         Client.field511 = false;
         class174.method3276(var0);
      }
   }
}
