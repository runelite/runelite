package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
public abstract class class106 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 130382741
   )
   public int field1858;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -904663037
   )
   public int field1859;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -652710773
   )
   public int field1860;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2081039665
   )
   public int field1865;

   @ObfuscatedName("j")
   public abstract boolean vmethod2416(int var1, int var2);

   @ObfuscatedName("bx")
   static String method2418(int var0) {
      return client.field422[var0].length() > 0?client.field297[var0] + " " + client.field422[var0]:client.field297[var0];
   }

   @ObfuscatedName("cq")
   static final void method2419(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class167.method3400(var0)) {
         class37.field836 = null;
         class114.method2464(class172.field2857[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class37.field836 != null) {
            class114.method2464(class37.field836, -1412584499, var1, var2, var3, var4, class10.field157, class48.field1070, var7);
            class37.field836 = null;
         }

      } else {
         if(var7 != -1) {
            client.field370[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field370[var8] = true;
            }
         }

      }
   }
}
