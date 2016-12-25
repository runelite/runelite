import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class138 {
   @ObfuscatedName("f")
   public static class182 field1912;
   @ObfuscatedName("k")
   public static class139 field1913;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 660865175
   )
   public static int field1914 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -783843549
   )
   public static int field1915;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -823295807
   )
   public static int field1916;
   @ObfuscatedName("p")
   public static class144 field1917;
   @ObfuscatedName("e")
   public static class182 field1918;
   @ObfuscatedName("i")
   public static class182 field1919;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CS)Z",
      garbageValue = "-2548"
   )
   public static boolean method2457(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1826953075"
   )
   static void method2458() {
      NPC.underlayIds = null;
      class11.overlayIds = null;
      class10.overlayPaths = null;
      class65.overlayRotations = null;
      class10.field97 = null;
      class10.field92 = null;
      class7.field65 = null;
      class211.field3116 = null;
      WallObject.field1552 = null;
      CombatInfo1.field662 = null;
      class211.field3118 = null;
      ItemLayer.field1222 = null;
   }
}
