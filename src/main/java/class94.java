import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public final class class94 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -354423833
   )
   int field1606;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1430746887
   )
   int field1607;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -249200927
   )
   int field1608;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1304411477
   )
   int field1609;
   @ObfuscatedName("mg")
   static class78 field1610;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2036816635
   )
   int field1611;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1590642729
   )
   int field1612;
   @ObfuscatedName("p")
   public class85 field1613;
   @ObfuscatedName("q")
   public class85 field1614;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -219783557
   )
   public int field1615 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1398711799
   )
   int field1616 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 94475781
   )
   int field1618;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "-58"
   )
   public static int method2252(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = 1 + (var0 << 4);
      }

      return var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method2253(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class125.field2037) {
            try {
               class118 var2 = new class118();
               var2.vmethod2916(var0);
               return var2;
            } catch (Throwable var3) {
               class125.field2037 = true;
            }
         }

         return var0;
      }
   }
}
