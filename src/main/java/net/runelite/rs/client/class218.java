package net.runelite.rs.client;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hf")
final class class218 implements Comparator {
   @ObfuscatedName("f")
   static class80 field3148;

   @ObfuscatedName("j")
   int method4035(class213 var1, class213 var2) {
      return var1.field3134 < var2.field3134?-1:(var2.field3134 == var1.field3134?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4035((class213)var1, (class213)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
