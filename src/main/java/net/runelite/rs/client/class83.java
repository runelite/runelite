package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cz")
public class class83 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 460526475
   )
   int field1432;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1664613355
   )
   int field1433;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 258739071
   )
   static int field1434;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1298747813
   )
   int field1436;
   @ObfuscatedName("kp")
   static class19 field1439;

   @ObfuscatedName("bf")
   static final void method1919(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field408.method3871(); null != var10; var10 = (class16)client.field408.method3873()) {
         if(var0 == var10.field226 && var10.field224 == var1 && var2 == var10.field225 && var10.field223 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field226 = var0;
         var9.field223 = var3;
         var9.field224 = var1;
         var9.field225 = var2;
         class21.method612(var9);
         client.field408.method3868(var9);
      }

      var9.field229 = var4;
      var9.field231 = var5;
      var9.field230 = var6;
      var9.field222 = var7;
      var9.field233 = var8;
   }
}
