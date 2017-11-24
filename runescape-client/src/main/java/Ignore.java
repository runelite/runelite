import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 327012135
   )
   static int field816;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("x")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method1126() {
      class210.field2595.method3863();
      class210.field2598 = 1;
      class3.field22 = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2146752135"
   )
   public static int method1125(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }
}
