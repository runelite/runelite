package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
@Implements("Deque")
public class class198 {
   @ObfuscatedName("j")
   @Export("head")
   public class207 field3086 = new class207();
   @ObfuscatedName("m")
   @Export("current")
   class207 field3087;

   @ObfuscatedName("j")
   public void method3865() {
      while(true) {
         class207 var1 = this.field3086.field3102;
         if(var1 == this.field3086) {
            this.field3087 = null;
            return;
         }

         var1.method3965();
      }
   }

   @ObfuscatedName("a")
   public class207 method3866() {
      class207 var1 = this.field3086.field3103;
      if(var1 == this.field3086) {
         return null;
      } else {
         var1.method3965();
         return var1;
      }
   }

   @ObfuscatedName("f")
   public void method3867(class207 var1) {
      if(var1.field3103 != null) {
         var1.method3965();
      }

      var1.field3103 = this.field3086;
      var1.field3102 = this.field3086.field3102;
      var1.field3103.field3102 = var1;
      var1.field3102.field3103 = var1;
   }

   @ObfuscatedName("m")
   public void method3868(class207 var1) {
      if(var1.field3103 != null) {
         var1.method3965();
      }

      var1.field3103 = this.field3086.field3103;
      var1.field3102 = this.field3086;
      var1.field3103.field3102 = var1;
      var1.field3102.field3103 = var1;
   }

   @ObfuscatedName("u")
   public class207 method3869() {
      class207 var1 = this.field3086.field3102;
      if(var1 == this.field3086) {
         return null;
      } else {
         var1.method3965();
         return var1;
      }
   }

   @ObfuscatedName("h")
   public class207 method3871() {
      class207 var1 = this.field3086.field3102;
      if(var1 == this.field3086) {
         this.field3087 = null;
         return null;
      } else {
         this.field3087 = var1.field3102;
         return var1;
      }
   }

   @ObfuscatedName("t")
   public class207 method3873() {
      class207 var1 = this.field3087;
      if(var1 == this.field3086) {
         this.field3087 = null;
         return null;
      } else {
         this.field3087 = var1.field3102;
         return var1;
      }
   }

   @ObfuscatedName("k")
   public class207 method3874() {
      class207 var1 = this.field3087;
      if(var1 == this.field3086) {
         this.field3087 = null;
         return null;
      } else {
         this.field3087 = var1.field3103;
         return var1;
      }
   }

   public class198() {
      this.field3086.field3102 = this.field3086;
      this.field3086.field3103 = this.field3086;
   }

   @ObfuscatedName("i")
   public class207 method3884() {
      class207 var1 = this.field3086.field3103;
      if(var1 == this.field3086) {
         this.field3087 = null;
         return null;
      } else {
         this.field3087 = var1.field3103;
         return var1;
      }
   }

   @ObfuscatedName("l")
   public static void method3887(class207 var0, class207 var1) {
      if(var0.field3103 != null) {
         var0.method3965();
      }

      var0.field3103 = var1.field3103;
      var0.field3102 = var1;
      var0.field3103.field3102 = var0;
      var0.field3102.field3103 = var0;
   }
}
