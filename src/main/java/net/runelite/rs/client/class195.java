package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
public final class class195 {
   @ObfuscatedName("u")
   int field3077 = 0;
   @ObfuscatedName("m")
   class207[] field3078;
   @ObfuscatedName("f")
   class207 field3079;
   @ObfuscatedName("l")
   class207 field3080;
   @ObfuscatedName("j")
   int field3081;

   @ObfuscatedName("l")
   public class207 method3835() {
      this.field3077 = 0;
      return this.method3840();
   }

   @ObfuscatedName("j")
   public class207 method3836(long var1) {
      class207 var3 = this.field3078[(int)(var1 & (long)(this.field3081 - 1))];

      for(this.field3079 = var3.field3102; this.field3079 != var3; this.field3079 = this.field3079.field3102) {
         if(this.field3079.field3104 == var1) {
            class207 var4 = this.field3079;
            this.field3079 = this.field3079.field3102;
            return var4;
         }
      }

      this.field3079 = null;
      return null;
   }

   @ObfuscatedName("f")
   void method3838() {
      for(int var1 = 0; var1 < this.field3081; ++var1) {
         class207 var2 = this.field3078[var1];

         while(true) {
            class207 var3 = var2.field3102;
            if(var3 == var2) {
               break;
            }

            var3.method3965();
         }
      }

      this.field3079 = null;
      this.field3080 = null;
   }

   @ObfuscatedName("m")
   public void method3839(class207 var1, long var2) {
      if(var1.field3103 != null) {
         var1.method3965();
      }

      class207 var4 = this.field3078[(int)(var2 & (long)(this.field3081 - 1))];
      var1.field3103 = var4.field3103;
      var1.field3102 = var4;
      var1.field3103.field3102 = var1;
      var1.field3102.field3103 = var1;
      var1.field3104 = var2;
   }

   @ObfuscatedName("u")
   public class207 method3840() {
      class207 var1;
      if(this.field3077 > 0 && this.field3080 != this.field3078[this.field3077 - 1]) {
         var1 = this.field3080;
         this.field3080 = var1.field3102;
         return var1;
      } else {
         do {
            if(this.field3077 >= this.field3081) {
               return null;
            }

            var1 = this.field3078[this.field3077++].field3102;
         } while(var1 == this.field3078[this.field3077 - 1]);

         this.field3080 = var1.field3102;
         return var1;
      }
   }

   public class195(int var1) {
      this.field3081 = var1;
      this.field3078 = new class207[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class207 var3 = this.field3078[var2] = new class207();
         var3.field3102 = var3;
         var3.field3103 = var3;
      }

   }
}
