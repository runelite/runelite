import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("WallObject")
public final class class90 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1565600063
   )
   @Export("floor")
   int field1592;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 599704701
   )
   @Export("x")
   int field1593;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -708181047
   )
   @Export("y")
   int field1594;
   @ObfuscatedName("by")
   static class171 field1595;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2028542425
   )
   int field1596;
   @ObfuscatedName("a")
   @Export("renderable1")
   public class88 field1597;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1808408733
   )
   int field1598 = 0;
   @ObfuscatedName("b")
   @Export("renderable2")
   public class88 field1599;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 458623163
   )
   int field1600;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1240583357
   )
   @Export("hash")
   public int field1601 = 0;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method2176() {
      class186.field2996.method3689();
      class186.field2993 = 1;
      class186.field2998 = null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1430189109"
   )
   public static int method2177(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class9.method106(var0.charAt(var3));
      }

      return var2;
   }
}
