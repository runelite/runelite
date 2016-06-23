import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("DecorativeObject")
public final class class94 {
   @ObfuscatedName("g")
   @Export("renderable2")
   public class85 field1609;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1468284629
   )
   int field1610;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1218542585
   )
   @Export("y")
   int field1611;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -159784563
   )
   @Export("x")
   int field1612;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 326829865
   )
   @Export("floor")
   int field1613;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 926884437
   )
   int field1614;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1813777375
   )
   int field1615;
   @ObfuscatedName("m")
   @Export("renderable1")
   public class85 field1616;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1581167555
   )
   @Export("hash")
   public int field1617 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1261874207
   )
   int field1618;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1734888431
   )
   int field1619 = 0;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)Z",
      garbageValue = "987152406"
   )
   static boolean method2227(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3286(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class130.method2852(var3);
         return true;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1615605502"
   )
   static final int method2228(int var0, int var1) {
      int var2 = 57 * var1 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (15731 * var2 * var2 + 789221) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
