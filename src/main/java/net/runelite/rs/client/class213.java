package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hg")
public class class213 {
   @ObfuscatedName("u")
   String field3133;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1149192641
   )
   public final int field3134;
   @ObfuscatedName("f")
   public final class219 field3135;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -410791121213620027L
   )
   public final long field3136;
   @ObfuscatedName("l")
   String field3137;

   class213(class118 var1, byte var2, int var3) {
      this.field3137 = var1.method2544();
      this.field3133 = var1.method2544();
      this.field3134 = var1.method2538();
      this.field3136 = var1.method2734();
      int var4 = var1.method2541();
      int var5 = var1.method2541();
      this.field3135 = new class219();
      this.field3135.method4045(2);
      this.field3135.method4041(var2);
      this.field3135.field3151 = var4;
      this.field3135.field3152 = var5;
      this.field3135.field3153 = 0;
      this.field3135.field3154 = 0;
      this.field3135.field3150 = var3;
   }

   @ObfuscatedName("j")
   public String method4006() {
      return this.field3137;
   }

   @ObfuscatedName("m")
   public String method4008() {
      return this.field3133;
   }
}
