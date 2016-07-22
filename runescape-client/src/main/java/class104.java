import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("Tile")
public final class class104 extends class211 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -145550553
   )
   int field1803;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 32708587
   )
   @Export("plane")
   int field1804;
   @ObfuscatedName("g")
   class92 field1805;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -418343137
   )
   int field1806;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 979351643
   )
   @Export("x")
   int field1807;
   @ObfuscatedName("l")
   class100 field1808;
   @ObfuscatedName("j")
   @Export("wallObject")
   class90 field1809;
   @ObfuscatedName("r")
   @Export("decorativeObject")
   class97 field1810;
   @ObfuscatedName("x")
   @Export("groundObject")
   class96 field1811;
   @ObfuscatedName("k")
   @Export("itemLayer")
   class102 field1812;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1619955697
   )
   @Export("y")
   int field1813;
   @ObfuscatedName("n")
   class104 field1814;
   @ObfuscatedName("u")
   int[] field1815 = new int[5];
   @ObfuscatedName("h")
   @Export("objects")
   class101[] field1816 = new class101[5];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -640044205
   )
   int field1817;
   @ObfuscatedName("s")
   boolean field1818;
   @ObfuscatedName("f")
   boolean field1819;
   @ObfuscatedName("i")
   boolean field1820;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2092036835
   )
   int field1821;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1264901459
   )
   int field1822;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1635226497
   )
   int field1823;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 1991404415
   )
   static int field1824;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 263797141
   )
   int field1825 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -800105403
   )
   int field1826;

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)Z",
      garbageValue = "-1696359871"
   )
   static final boolean method2357(class176 var0) {
      int var1 = var0.field2799;
      if(var1 == 205) {
         client.field323 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field516.method3535(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field516.method3556(var2, var3 == 1);
         }

         if(var1 == 324) {
            client.field516.method3538(false);
         }

         if(var1 == 325) {
            client.field516.method3538(true);
         }

         if(var1 == 326) {
            client.field313.method2797(151);
            client.field516.method3564(client.field313);
            return true;
         } else {
            return false;
         }
      }
   }

   class104(int var1, int var2, int var3) {
      this.field1826 = this.field1804 = var1;
      this.field1807 = var2;
      this.field1813 = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1999321066"
   )
   static void method2358(int var0) {
      if(var0 != -1) {
         if(class122.method2739(var0)) {
            class176[] var1 = class176.field2814[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class176 var3 = var1[var2];
               if(var3.field2876 != null) {
                  class0 var4 = new class0();
                  var4.field3 = var3;
                  var4.field1 = var3.field2876;
                  class43.method884(var4, 2000000);
               }
            }

         }
      }
   }
}
