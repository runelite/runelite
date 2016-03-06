package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
@Implements("Deque")
public class class198 {
   @ObfuscatedName("l")
   @Export("current")
   class207 field3094;
   @ObfuscatedName("j")
   @Export("head")
   public class207 field3095 = new class207();

   @ObfuscatedName("i")
   public static void method3766(class207 var0, class207 var1) {
      if(var0.field3110 != null) {
         var0.method3853();
      }

      var0.field3110 = var1.field3110;
      var0.field3111 = var1;
      var0.field3110.field3111 = var0;
      var0.field3111.field3110 = var0;
   }

   @ObfuscatedName("j")
   public void method3767() {
      while(true) {
         class207 var1 = this.field3095.field3111;
         if(var1 == this.field3095) {
            this.field3094 = null;
            return;
         }

         var1.method3853();
      }
   }

   @ObfuscatedName("l")
   public void method3768(class207 var1) {
      if(var1.field3110 != null) {
         var1.method3853();
      }

      var1.field3110 = this.field3095.field3110;
      var1.field3111 = this.field3095;
      var1.field3110.field3111 = var1;
      var1.field3111.field3110 = var1;
   }

   @ObfuscatedName("a")
   public void method3769(class207 var1) {
      if(var1.field3110 != null) {
         var1.method3853();
      }

      var1.field3110 = this.field3095;
      var1.field3111 = this.field3095.field3111;
      var1.field3110.field3111 = var1;
      var1.field3111.field3110 = var1;
   }

   @ObfuscatedName("f")
   public class207 method3771() {
      class207 var1 = this.field3095.field3111;
      if(var1 == this.field3095) {
         return null;
      } else {
         var1.method3853();
         return var1;
      }
   }

   @ObfuscatedName("n")
   public class207 method3772() {
      class207 var1 = this.field3094;
      if(var1 == this.field3095) {
         this.field3094 = null;
         return null;
      } else {
         this.field3094 = var1.field3111;
         return var1;
      }
   }

   @ObfuscatedName("o")
   public class207 method3773() {
      class207 var1 = this.field3095.field3111;
      if(var1 == this.field3095) {
         this.field3094 = null;
         return null;
      } else {
         this.field3094 = var1.field3111;
         return var1;
      }
   }

   @ObfuscatedName("h")
   public class207 method3774() {
      class207 var1 = this.field3095.field3110;
      if(var1 == this.field3095) {
         this.field3094 = null;
         return null;
      } else {
         this.field3094 = var1.field3110;
         return var1;
      }
   }

   @ObfuscatedName("k")
   public class207 method3776() {
      class207 var1 = this.field3094;
      if(var1 == this.field3095) {
         this.field3094 = null;
         return null;
      } else {
         this.field3094 = var1.field3110;
         return var1;
      }
   }

   public class198() {
      this.field3095.field3111 = this.field3095;
      this.field3095.field3110 = this.field3095;
   }

   @ObfuscatedName("m")
   public class207 method3795() {
      class207 var1 = this.field3095.field3110;
      if(var1 == this.field3095) {
         return null;
      } else {
         var1.method3853();
         return var1;
      }
   }
}
