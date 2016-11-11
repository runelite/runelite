import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public abstract class class136 {
   @ObfuscatedName("pp")
   static class224 field2122;
   @ObfuscatedName("ct")
   static class227 field2123;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-130934505"
   )
   public static boolean method2884(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-9037346"
   )
   abstract int vmethod3148(int var1, int var2);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "1760417790"
   )
   public static Widget method2889(int var0, int var1) {
      Widget var2 = class173.method3412(var0);
      return var1 == -1?var2:(null != var2 && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   abstract void vmethod3147();
}
