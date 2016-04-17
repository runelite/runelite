import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public final class class129 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -326664467
   )
   static int field2050;
   @ObfuscatedName("y")
   @Export("worldList")
   static class25[] field2051;
   @ObfuscatedName("c")
   public static class167 field2052;
   @ObfuscatedName("ag")
   static class143 field2054;
   @ObfuscatedName("a")
   public static class113 field2055;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1652606231"
   )
   static void method2943(int var0, String var1, String var2) {
      class40.method899(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1779622273"
   )
   public static boolean method2946(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
