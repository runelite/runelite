package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
public final class class202 {
   @ObfuscatedName("j")
   class203 field3099 = new class203();

   @ObfuscatedName("j")
   public void method3814(class203 var1) {
      if(var1.field3101 != null) {
         var1.method3835();
      }

      var1.field3101 = this.field3099.field3101;
      var1.field3100 = this.field3099;
      var1.field3101.field3100 = var1;
      var1.field3100.field3101 = var1;
   }

   @ObfuscatedName("a")
   class203 method3816() {
      class203 var1 = this.field3099.field3100;
      if(var1 == this.field3099) {
         return null;
      } else {
         var1.method3835();
         return var1;
      }
   }

   @ObfuscatedName("i")
   public class203 method3817() {
      class203 var1 = this.field3099.field3100;
      return var1 == this.field3099?null:var1;
   }

   @ObfuscatedName("l")
   public void method3818(class203 var1) {
      if(var1.field3101 != null) {
         var1.method3835();
      }

      var1.field3101 = this.field3099;
      var1.field3100 = this.field3099.field3100;
      var1.field3101.field3100 = var1;
      var1.field3100.field3101 = var1;
   }

   public class202() {
      this.field3099.field3100 = this.field3099;
      this.field3099.field3101 = this.field3099;
   }

   @ObfuscatedName("f")
   void method3824() {
      while(true) {
         class203 var1 = this.field3099.field3100;
         if(var1 == this.field3099) {
            return;
         }

         var1.method3835();
      }
   }
}
