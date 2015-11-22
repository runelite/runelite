package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
public class class194 {
   @ObfuscatedName("j")
   class206 field3075 = new class206();
   @ObfuscatedName("m")
   class206 field3076;

   public class194() {
      this.field3075.field3101 = this.field3075;
      this.field3075.field3100 = this.field3075;
   }

   @ObfuscatedName("m")
   public class206 method3826() {
      class206 var1 = this.field3075.field3101;
      if(var1 == this.field3075) {
         this.field3076 = null;
         return null;
      } else {
         this.field3076 = var1.field3101;
         return var1;
      }
   }

   @ObfuscatedName("f")
   public class206 method3827() {
      class206 var1 = this.field3076;
      if(var1 == this.field3075) {
         this.field3076 = null;
         return null;
      } else {
         this.field3076 = var1.field3101;
         return var1;
      }
   }

   @ObfuscatedName("j")
   public void method3834(class206 var1) {
      if(var1.field3100 != null) {
         var1.method3963();
      }

      var1.field3100 = this.field3075.field3100;
      var1.field3101 = this.field3075;
      var1.field3100.field3101 = var1;
      var1.field3101.field3100 = var1;
   }
}
