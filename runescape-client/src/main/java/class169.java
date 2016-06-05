import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class169 extends class208 {
   @ObfuscatedName("i")
   byte[] field2731;
   @ObfuscatedName("g")
   class134 field2732;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2081269049
   )
   int field2733;
   @ObfuscatedName("h")
   class168 field2734;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[BLclass134;I)V",
      garbageValue = "-1549037945"
   )
   static void method3331(int var0, byte[] var1, class134 var2) {
      class169 var3 = new class169();
      var3.field2733 = 0;
      var3.field3125 = (long)var0;
      var3.field2731 = var1;
      var3.field2732 = var2;
      class199 var4 = class170.field2738;
      synchronized(class170.field2738) {
         class170.field2738.method3771(var3);
      }

      class87.method2045();
   }
}
