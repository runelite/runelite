package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ct")
public class class95 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2093213703
   )
   int field1614;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1880992171
   )
   int field1615;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1713592329
   )
   int field1616;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1680432837
   )
   int field1617;

   class95(class95 var1) {
      this.field1617 = var1.field1617;
      this.field1615 = var1.field1615;
      this.field1616 = var1.field1616;
      this.field1614 = var1.field1614;
   }

   class95() {
   }

   @ObfuscatedName("aq")
   static final void method2212() {
      if(1 == client.field387) {
         class115.field1965[client.field361 / 100].method1730(client.field520 - 8, client.field399 - 8);
      }

      if(client.field387 == 2) {
         class115.field1965[client.field361 / 100 + 4].method1730(client.field520 - 8, client.field399 - 8);
      }

      class212.method3998();
   }

   @ObfuscatedName("m")
   public static void method2213(int var0, int var1) {
      class47 var2 = class25.method673(var0);
      int var3 = var2.field1050;
      int var4 = var2.field1048;
      int var5 = var2.field1057;
      int var6 = class175.field2885[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class175.field2884[var3] = class175.field2884[var3] & ~var6 | var1 << var4 & var6;
   }
}
