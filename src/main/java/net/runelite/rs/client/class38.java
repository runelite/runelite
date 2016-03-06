package net.runelite.rs.client;
import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("af")
public class class38 extends class206 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -583768493
   )
   int field870 = (int)(class109.method2381() / 1000L);
   @ObfuscatedName("a")
   short field871;
   @ObfuscatedName("qz")
   protected static Image field872;
   @ObfuscatedName("l")
   String field875;

   @ObfuscatedName("e")
   static void method761(int var0, int var1, int var2) {
      if(client.field300 != 0 && var1 != 0 && client.field530 < 50) {
         client.field531[client.field530] = var0;
         client.field532[client.field530] = var1;
         client.field443[client.field530] = var2;
         client.field401[client.field530] = null;
         client.field534[client.field530] = 0;
         ++client.field530;
      }

   }

   @ObfuscatedName("bh")
   static String method762(int var0) {
      return client.field365[var0].length() > 0?client.field437[var0] + " " + client.field365[var0]:client.field437[var0];
   }

   @ObfuscatedName("dl")
   static final void method763(int var0, int var1, int var2, int var3, class78 var4, class174 var5) {
      if(var4 != null) {
         int var6 = client.field374 + client.field522 & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class90.field1587[var6];
            int var9 = class90.field1590[var6];
            var8 = var8 * 256 / (client.field359 + 256);
            var9 = 256 * var9 / (client.field359 + 256);
            int var10 = var9 * var2 + var8 * var3 >> 16;
            int var11 = var3 * var9 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1698(var10 + var5.field2903 / 2 - var4.field1421 / 2, var5.field2900 / 2 - var11 - var4.field1416 / 2, var0, var1, var5.field2903, var5.field2900, var5.field2902, var5.field2899);
            } else {
               var4.method1706(var0 + var5.field2903 / 2 + var10 - var4.field1421 / 2, var1 + var5.field2900 / 2 - var11 - var4.field1416 / 2);
            }

         }
      }
   }

   @ObfuscatedName("t")
   static final void method764() {
      if(class77.field1403 != null) {
         class77.field1403.method1175();
      }

      if(null != class47.field1070) {
         class47.field1070.method1175();
      }

   }

   class38(String var1, int var2) {
      this.field875 = var1;
      this.field871 = (short)var2;
   }
}
