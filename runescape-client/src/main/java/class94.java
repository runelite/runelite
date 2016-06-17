import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("DecorativeObject")
public final class class94 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 63240791
   )
   @Export("y")
   int field1576;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1442348565
   )
   @Export("floor")
   int field1577;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -841303921
   )
   int field1578;
   @ObfuscatedName("l")
   @Export("renderable2")
   public class85 field1579;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1522978385
   )
   int field1580;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1454491793
   )
   int field1581;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 113938791
   )
   int field1582;
   @ObfuscatedName("c")
   @Export("renderable1")
   public class85 field1583;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1999045951
   )
   @Export("hash")
   public int field1584 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1041135011
   )
   @Export("x")
   int field1585;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -173765407
   )
   int field1586 = 0;

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-241188776"
   )
   static final void method2172(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class108.method2413(var0, var1, class144.field2193) - var2;
         var0 -= class28.field670;
         var3 -= class59.field1188;
         var1 -= client.field478;
         int var4 = class91.field1563[class156.field2286];
         int var5 = class91.field1564[class156.field2286];
         int var6 = class91.field1563[class149.field2224];
         int var7 = class91.field1564[class149.field2224];
         int var8 = var7 * var0 + var1 * var6 >> 16;
         var1 = var7 * var1 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var3 * var4 + var1 * var5 >> 16;
         if(var1 >= 50) {
            client.field395 = client.field553 * var0 / var1 + client.field551 / 2;
            client.field544 = client.field552 / 2 + client.field553 * var8 / var1;
         } else {
            client.field395 = -1;
            client.field544 = -1;
         }

      } else {
         client.field395 = -1;
         client.field544 = -1;
      }
   }
}
