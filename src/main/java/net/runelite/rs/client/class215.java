package net.runelite.rs.client;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hq")
final class class215 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4016((class213)var1, (class213)var2);
   }

   @ObfuscatedName("j")
   int method4016(class213 var1, class213 var2) {
      return var1.field3135.field3152 < var2.field3135.field3152?-1:(var2.field3135.field3152 == var1.field3135.field3152?0:1);
   }
}
