package net.runelite.rs.client;

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ha")
final class class217 implements Comparator {
   @ObfuscatedName("m")
   public static String field3147;

   @ObfuscatedName("j")
   int method4027(class213 var1, class213 var2) {
      return var1.field3136 < var2.field3136?-1:(var2.field3136 == var1.field3136?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4027((class213)var1, (class213)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
