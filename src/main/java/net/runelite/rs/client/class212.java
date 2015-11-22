package net.runelite.rs.client;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hn")
final class class212 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("j")
   int method3994(class213 var1, class213 var2) {
      return var1.method4006().compareTo(var2.method4006());
   }

   public int compare(Object var1, Object var2) {
      return this.method3994((class213)var1, (class213)var2);
   }

   @ObfuscatedName("ag")
   static final void method3998() {
      client.field396 = 0;
      int var0 = class47.field1053 + (class0.field12.field846 >> 7);
      int var1 = (class0.field12.field834 >> 7) + class161.field2629;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         client.field396 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         client.field396 = 1;
      }

      if(client.field396 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         client.field396 = 0;
      }

   }
}
