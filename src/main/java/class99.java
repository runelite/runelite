import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("ItemLayer")
public final class class99 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 340080313
   )
   @Export("y")
   int field1686;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 339607231
   )
   @Export("x")
   int field1687;
   @ObfuscatedName("y")
   @Export("top")
   class85 field1688;
   @ObfuscatedName("p")
   @Export("bottom")
   class85 field1689;
   @ObfuscatedName("e")
   @Export("middle")
   class85 field1690;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 243586573
   )
   @Export("hash")
   int field1691;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -427976247
   )
   @Export("flags")
   int field1692;
   @ObfuscatedName("iv")
   static class173 field1693;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -244027953
   )
   @Export("height")
   int field1699;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILclass134;Lclass168;I)V",
      garbageValue = "-2038074079"
   )
   static void method2190(int var0, class134 var1, class168 var2) {
      byte[] var3 = null;
      class199 var4 = class170.field2729;
      synchronized(class170.field2729) {
         for(class169 var5 = (class169)class170.field2729.method3836(); null != var5; var5 = (class169)class170.field2729.method3841()) {
            if(var5.field3123 == (long)var0 && var1 == var5.field2722 && 0 == var5.field2723) {
               var3 = var5.field2721;
               break;
            }
         }
      }

      if(null != var3) {
         var2.method3368(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2875(var0);
         var2.method3368(var1, var0, var8, true);
      }
   }
}
