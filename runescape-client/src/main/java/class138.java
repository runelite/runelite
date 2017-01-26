import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class138 {
   @ObfuscatedName("kz")
   static class112 field1917;
   @ObfuscatedName("x")
   static class182 field1918;
   @ObfuscatedName("p")
   static class182 field1919;
   @ObfuscatedName("q")
   public static class139 field1920;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1969360635
   )
   public static int field1921 = 0;
   @ObfuscatedName("c")
   public static boolean field1922;
   @ObfuscatedName("bn")
   static class184 field1925;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 312655199
   )
   public static int field1926;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "269233745"
   )
   static World method2501() {
      World.field673 = 0;
      World var0;
      if(World.field673 < World.field668) {
         var0 = class5.worldList[++World.field673 - 1];
      } else {
         var0 = null;
      }

      return var0;
   }

   class138() throws Throwable {
      throw new Error();
   }
}
