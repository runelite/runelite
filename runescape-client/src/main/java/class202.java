import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
@Implements("Deque")
public class class202 {
   @ObfuscatedName("l")
   @Export("current")
   class211 field3144;
   @ObfuscatedName("e")
   @Export("head")
   public class211 field3145 = new class211();

   @ObfuscatedName("p")
   public class211 method3893() {
      class211 var1 = this.field3144;
      if(var1 == this.field3145) {
         this.field3144 = null;
         return null;
      } else {
         this.field3144 = var1.field3163;
         return var1;
      }
   }

   @ObfuscatedName("l")
   public void method3895(class211 var1) {
      if(var1.field3163 != null) {
         var1.method4000();
      }

      var1.field3163 = this.field3145.field3163;
      var1.field3162 = this.field3145;
      var1.field3163.field3162 = var1;
      var1.field3162.field3163 = var1;
   }

   @ObfuscatedName("c")
   public void method3896(class211 var1) {
      if(var1.field3163 != null) {
         var1.method4000();
      }

      var1.field3163 = this.field3145;
      var1.field3162 = this.field3145.field3162;
      var1.field3163.field3162 = var1;
      var1.field3162.field3163 = var1;
   }

   public class202() {
      this.field3145.field3162 = this.field3145;
      this.field3145.field3163 = this.field3145;
   }

   @ObfuscatedName("r")
   public class211 method3897() {
      class211 var1 = this.field3145.field3162;
      if(var1 == this.field3145) {
         return null;
      } else {
         var1.method4000();
         return var1;
      }
   }

   @ObfuscatedName("a")
   public class211 method3898() {
      class211 var1 = this.field3145.field3163;
      if(var1 == this.field3145) {
         return null;
      } else {
         var1.method4000();
         return var1;
      }
   }

   @ObfuscatedName("b")
   public class211 method3899() {
      class211 var1 = this.field3145.field3162;
      if(var1 == this.field3145) {
         this.field3144 = null;
         return null;
      } else {
         this.field3144 = var1.field3162;
         return var1;
      }
   }

   @ObfuscatedName("u")
   public class211 method3900() {
      class211 var1 = this.field3145.field3163;
      if(var1 == this.field3145) {
         this.field3144 = null;
         return null;
      } else {
         this.field3144 = var1.field3163;
         return var1;
      }
   }

   @ObfuscatedName("h")
   public static void method3902(class211 var0, class211 var1) {
      if(var0.field3163 != null) {
         var0.method4000();
      }

      var0.field3163 = var1.field3163;
      var0.field3162 = var1;
      var0.field3163.field3162 = var0;
      var0.field3162.field3163 = var0;
   }

   @ObfuscatedName("e")
   public void method3917() {
      while(true) {
         class211 var1 = this.field3145.field3162;
         if(var1 == this.field3145) {
            this.field3144 = null;
            return;
         }

         var1.method4000();
      }
   }

   @ObfuscatedName("o")
   public class211 method3918() {
      class211 var1 = this.field3144;
      if(var1 == this.field3145) {
         this.field3144 = null;
         return null;
      } else {
         this.field3144 = var1.field3162;
         return var1;
      }
   }
}
