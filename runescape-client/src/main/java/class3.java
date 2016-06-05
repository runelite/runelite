import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("WidgetNode")
public class class3 extends class208 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -682391945
   )
   int field64;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 361493473
   )
   @Export("id")
   int field65;
   @ObfuscatedName("g")
   boolean field66 = false;
   @ObfuscatedName("bx")
   static class168 field67;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -1046349523
   )
   static int field69;

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "38"
   )
   @Export("groundItemSpawned")
   static final void method35(int var0, int var1) {
      class199 var2 = client.field415[class32.field754][var0][var1];
      if(var2 == null) {
         class214.field3161.method1961(class32.field754, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3797(); null != var6; var6 = (class28)var2.method3779()) {
            class51 var7 = class123.method2743(var6.field677);
            long var8 = (long)var7.field1117;
            if(var7.field1131 == 1) {
               var8 *= (long)(1 + var6.field671);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class214.field3161.method1961(class32.field754, var0, var1);
         } else {
            var2.method3788(var5);
            class28 var11 = null;
            class28 var10 = null;

            for(var6 = (class28)var2.method3797(); null != var6; var6 = (class28)var2.method3779()) {
               if(var6.field677 != var5.field677) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var11.field677 != var6.field677 && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            class214.field3161.method1988(class32.field754, var0, var1, class14.method147(64 + 128 * var0, 64 + 128 * var1, class32.field754), var5, var9, var11, var10);
         }
      }
   }
}
