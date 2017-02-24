import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public final class class94 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 252486365
   )
   int field1583;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -499267675
   )
   int field1584;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1260811935
   )
   int field1586;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2070713063
   )
   int field1587;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1245670065
   )
   int field1588;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 818805499
   )
   int field1589;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1672629971
   )
   int field1590;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -9766469
   )
   int field1591;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 72240421
   )
   int field1592;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1491908287
   )
   int field1593;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -462165523
   )
   int field1594;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2103266057
   )
   int field1595;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1563250411
   )
   int field1596;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1871650655
   )
   int field1597;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1497101691
   )
   int field1598;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 315020143
   )
   int field1599;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 569150197
   )
   int field1600;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -291734995
   )
   int field1601;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)[LModIcon;",
      garbageValue = "1826287500"
   )
   static ModIcon[] method1977(class182 var0, int var1, int var2) {
      if(!method1979(var0, var1, var2)) {
         return null;
      } else {
         ModIcon[] var4 = new ModIcon[class225.field3232];

         for(int var5 = 0; var5 < class225.field3232; ++var5) {
            ModIcon var6 = var4[var5] = new ModIcon();
            var6.width = class202.field3074;
            var6.originalHeight = class225.field3231;
            var6.offsetX = Ignore.field223[var5];
            var6.offsetY = class225.field3233[var5];
            var6.originalWidth = class225.field3234[var5];
            var6.height = class41.field862[var5];
            var6.palette = class160.field2146;
            var6.pixels = class11.field129[var5];
         }

         Actor.method636();
         return var4;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Lclass189;",
      garbageValue = "6"
   )
   public static class189 method1978(int var0) {
      class189 var1 = (class189)class189.field2796.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class189.field2793.getConfigData(15, var0);
         var1 = new class189();
         if(null != var2) {
            var1.method3460(new Buffer(var2));
         }

         class189.field2796.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)Z",
      garbageValue = "-1010698683"
   )
   static boolean method1979(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class210.method3984(var3);
         return true;
      }
   }
}
