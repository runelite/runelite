import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cz")
@Implements("GameObject")
public final class class97 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 249963455
   )
   @Export("y")
   int field1665;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1496951985
   )
   @Export("height")
   int field1666;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1324128483
   )
   @Export("relativeX")
   int field1667;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -439838937
   )
   @Export("x")
   int field1668;
   @ObfuscatedName("be")
   static class167 field1669;
   @ObfuscatedName("f")
   @Export("renderable")
   public class84 field1670;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1678710799
   )
   @Export("offsetX")
   int field1672;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1900169327
   )
   @Export("relativeY")
   int field1673;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 590979045
   )
   @Export("offsetY")
   int field1674;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 438025847
   )
   int field1675;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1323849609
   )
   int field1676;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1171940171
   )
   @Export("hash")
   public int field1677 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1386293683
   )
   @Export("flags")
   int field1678 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1937641387
   )
   @Export("plane")
   int field1679;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1178349931
   )
   @Export("orientation")
   int field1682;

   @ObfuscatedName("ai")
   static int method2167() {
      return client.field382?2:1;
   }

   @ObfuscatedName("h")
   public static Object method2168(byte[] var0) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class124.field2036) {
            try {
               class117 var1 = new class117();
               var1.vmethod2734(var0);
               return var1;
            } catch (Throwable var2) {
               class124.field2036 = true;
            }
         }

         return var0;
      }
   }
}
