import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class48 extends CacheableNode {
   @ObfuscatedName("f")
   int[] field948;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1887849457
   )
   int field949;
   @ObfuscatedName("e")
   int[] field950;
   @ObfuscatedName("k")
   String[] field951;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2119381441
   )
   int field952;
   @ObfuscatedName("i")
   static NodeCache field953 = new NodeCache(128);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1683474505
   )
   int field954;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1727362077
   )
   int field955;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "735017078"
   )
   public static int method855(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1644478184"
   )
   public static int method856(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "378269264"
   )
   public static void method860() {
      class227.field3228 = new CombatInfoList();
   }
}
