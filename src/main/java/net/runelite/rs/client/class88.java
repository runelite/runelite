package net.runelite.rs.client;

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
public final class class88 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1932098807
   )
   int field1531;
   @ObfuscatedName("cy")
   static class223 field1532;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1955505177
   )
   int field1533;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 690234391
   )
   int field1534;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1713779249
   )
   int field1535;
   @ObfuscatedName("a")
   boolean field1536 = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 261150005
   )
   int field1537;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1840400169
   )
   int field1538;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1996358291
   )
   static int field1540;
   @ObfuscatedName("c")
   static int[] field1542;

   class88(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1531 = var1;
      this.field1538 = var2;
      this.field1533 = var3;
      this.field1534 = var4;
      this.field1535 = var5;
      this.field1537 = var6;
      this.field1536 = var7;
   }

   @ObfuscatedName("a")
   static String method2099() {
      String var0 = "";

      class35 var2;
      for(Iterator var1 = class11.field166.iterator(); var1.hasNext(); var0 = var0 + var2.field774 + ':' + var2.field771 + '\n') {
         var2 = (class35)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("f")
   static String method2100(class118 var0, int var1) {
      try {
         int var2 = var0.method2548();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.field1981 += class221.field3165.method2460(var0.field1980, var0.field1981, var3, 0, var2);
         String var4 = class162.method3270(var3, 0, var2);
         return var4;
      } catch (Exception var5) {
         return "Cabbage";
      }
   }
}
