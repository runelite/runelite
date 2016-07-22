import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public abstract class class110 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -363095359
   )
   public int field1938;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1906432509
   )
   public int field1939;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1262588917
   )
   public int field1940;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1373725381
   )
   public int field1941;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILclass111;B)Z",
      garbageValue = "-26"
   )
   protected abstract boolean vmethod2446(int var1, int var2, int var3, class111 var4);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "325919295"
   )
   static int method2450(int var0) {
      class37 var1 = (class37)class11.field157.method3864((long)var0);
      return var1 == null?-1:(class11.field158.field3151 == var1.field3157?-1:((class37)var1.field3157).field809);
   }
}
