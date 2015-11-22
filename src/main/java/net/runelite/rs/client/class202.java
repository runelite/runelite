package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
public final class class202 {
   @ObfuscatedName("j")
   class203 field3091 = new class203();

   @ObfuscatedName("u")
   void method3925() {
      while(true) {
         class203 var1 = this.field3091.field3093;
         if(var1 == this.field3091) {
            return;
         }

         var1.method3945();
      }
   }

   @ObfuscatedName("f")
   class203 method3927() {
      class203 var1 = this.field3091.field3093;
      if(var1 == this.field3091) {
         return null;
      } else {
         var1.method3945();
         return var1;
      }
   }

   @ObfuscatedName("l")
   public class203 method3928() {
      class203 var1 = this.field3091.field3093;
      return var1 == this.field3091?null:var1;
   }

   public class202() {
      this.field3091.field3093 = this.field3091;
      this.field3091.field3092 = this.field3091;
   }

   @ObfuscatedName("m")
   public void method3933(class203 var1) {
      if(var1.field3092 != null) {
         var1.method3945();
      }

      var1.field3092 = this.field3091;
      var1.field3093 = this.field3091.field3093;
      var1.field3092.field3093 = var1;
      var1.field3093.field3092 = var1;
   }

   @ObfuscatedName("j")
   public void method3934(class203 var1) {
      if(var1.field3092 != null) {
         var1.method3945();
      }

      var1.field3092 = this.field3091.field3092;
      var1.field3093 = this.field3091;
      var1.field3092.field3093 = var1;
      var1.field3093.field3092 = var1;
   }
}
