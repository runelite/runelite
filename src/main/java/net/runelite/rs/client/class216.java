package net.runelite.rs.client;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hc")
final class class216 implements Comparator {
   @ObfuscatedName("j")
   int method4018(class213 var1, class213 var2) {
      return var1.field3135.field3151 < var2.field3135.field3151?-1:(var2.field3135.field3151 == var1.field3135.field3151?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4018((class213)var1, (class213)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
