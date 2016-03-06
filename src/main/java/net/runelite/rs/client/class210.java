package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hm")
public class class210 {
   @ObfuscatedName("j")
   static class201 field3125 = new class201();

   @ObfuscatedName("bd")
   static final void method3871() {
      int var0 = class136.field2114;
      int var1 = class75.field1387;
      int var2 = class74.field1373;
      int var3 = client.field429;
      int var4 = 6116423;
      class79.method1776(var0, var1, var2, var3, var4);
      class79.method1776(1 + var0, var1 + 1, var2 - 2, 16, 0);
      class79.method1813(1 + var0, 18 + var1, var2 - 2, var3 - 19, 0);
      class1.field28.method3967("Choose Option", 3 + var0, var1 + 14, var4, -1);
      int var5 = class139.field2162;
      int var6 = class139.field2171;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < client.field430; ++var7) {
         var8 = var1 + 31 + (client.field430 - 1 - var7) * 15;
         var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class1.field28.method3967(class38.method762(var7), 3 + var0, var8, var9, 0);
      }

      var7 = class136.field2114;
      var8 = class75.field1387;
      var9 = class74.field1373;
      int var10 = client.field429;

      for(int var11 = 0; var11 < client.field491; ++var11) {
         if(client.field498[var11] + client.field496[var11] > var7 && client.field496[var11] < var9 + var7 && client.field499[var11] + client.field456[var11] > var8 && client.field456[var11] < var8 + var10) {
            client.field497[var11] = true;
         }
      }

   }
}
