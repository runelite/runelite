package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public final class class192 {
   @ObfuscatedName("j")
   class203 field3066 = new class203();
   @ObfuscatedName("m")
   int field3067;
   @ObfuscatedName("f")
   int field3068;
   @ObfuscatedName("l")
   class195 field3069;
   @ObfuscatedName("u")
   class202 field3070 = new class202();

   public class192(int var1) {
      this.field3067 = var1;
      this.field3068 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3069 = new class195(var2);
   }

   @ObfuscatedName("m")
   public void method3804(long var1) {
      class203 var3 = (class203)this.field3069.method3836(var1);
      if(var3 != null) {
         var3.method3965();
         var3.method3945();
         ++this.field3068;
      }

   }

   @ObfuscatedName("f")
   public void method3805(class203 var1, long var2) {
      if(this.field3068 == 0) {
         class203 var4 = this.field3070.method3927();
         var4.method3965();
         var4.method3945();
         if(var4 == this.field3066) {
            var4 = this.field3070.method3927();
            var4.method3965();
            var4.method3945();
         }
      } else {
         --this.field3068;
      }

      this.field3069.method3839(var1, var2);
      this.field3070.method3934(var1);
   }

   @ObfuscatedName("l")
   public void method3806() {
      this.field3070.method3925();
      this.field3069.method3838();
      this.field3066 = new class203();
      this.field3068 = this.field3067;
   }

   @ObfuscatedName("j")
   public class203 method3808(long var1) {
      class203 var3 = (class203)this.field3069.method3836(var1);
      if(var3 != null) {
         this.field3070.method3934(var3);
      }

      return var3;
   }
}
