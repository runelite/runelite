import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
@Implements("Deque")
public class class202 {
   @ObfuscatedName("g")
   @Export("current")
   class211 field3156;
   @ObfuscatedName("l")
   @Export("head")
   public class211 field3157 = new class211();

   @ObfuscatedName("g")
   public void method3963(class211 var1) {
      if(var1.field3174 != null) {
         var1.method4067();
      }

      var1.field3174 = this.field3157.field3174;
      var1.field3173 = this.field3157;
      var1.field3174.field3173 = var1;
      var1.field3173.field3174 = var1;
   }

   @ObfuscatedName("r")
   public void method3964(class211 var1) {
      if(var1.field3174 != null) {
         var1.method4067();
      }

      var1.field3174 = this.field3157;
      var1.field3173 = this.field3157.field3173;
      var1.field3174.field3173 = var1;
      var1.field3173.field3174 = var1;
   }

   @ObfuscatedName("h")
   public class211 method3966() {
      class211 var1 = this.field3157.field3173;
      if(var1 == this.field3157) {
         return null;
      } else {
         var1.method4067();
         return var1;
      }
   }

   @ObfuscatedName("s")
   public class211 method3967() {
      class211 var1 = this.field3157.field3174;
      if(var1 == this.field3157) {
         return null;
      } else {
         var1.method4067();
         return var1;
      }
   }

   @ObfuscatedName("u")
   public class211 method3969() {
      class211 var1 = this.field3157.field3174;
      if(var1 == this.field3157) {
         this.field3156 = null;
         return null;
      } else {
         this.field3156 = var1.field3174;
         return var1;
      }
   }

   @ObfuscatedName("n")
   public class211 method3970() {
      class211 var1 = this.field3156;
      if(var1 == this.field3157) {
         this.field3156 = null;
         return null;
      } else {
         this.field3156 = var1.field3173;
         return var1;
      }
   }

   @ObfuscatedName("b")
   public class211 method3971() {
      class211 var1 = this.field3156;
      if(var1 == this.field3157) {
         this.field3156 = null;
         return null;
      } else {
         this.field3156 = var1.field3174;
         return var1;
      }
   }

   public class202() {
      this.field3157.field3173 = this.field3157;
      this.field3157.field3174 = this.field3157;
   }

   @ObfuscatedName("k")
   public class211 method3980() {
      class211 var1 = this.field3157.field3173;
      if(var1 == this.field3157) {
         this.field3156 = null;
         return null;
      } else {
         this.field3156 = var1.field3173;
         return var1;
      }
   }

   @ObfuscatedName("l")
   public void method3996() {
      while(true) {
         class211 var1 = this.field3157.field3173;
         if(var1 == this.field3157) {
            this.field3156 = null;
            return;
         }

         var1.method4067();
      }
   }

   @ObfuscatedName("e")
   public static void method3998(class211 var0, class211 var1) {
      if(var0.field3174 != null) {
         var0.method4067();
      }

      var0.field3174 = var1.field3174;
      var0.field3173 = var1;
      var0.field3174.field3173 = var0;
      var0.field3173.field3174 = var0;
   }
}
