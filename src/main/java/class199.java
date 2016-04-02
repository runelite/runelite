import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
@Implements("Deque")
public class class199 {
   @ObfuscatedName("w")
   @Export("current")
   class208 field3098;
   @ObfuscatedName("e")
   @Export("head")
   public class208 field3099 = new class208();

   @ObfuscatedName("a")
   public class208 method3818() {
      class208 var1 = this.field3099.field3116;
      if(var1 == this.field3099) {
         this.field3098 = null;
         return null;
      } else {
         this.field3098 = var1.field3116;
         return var1;
      }
   }

   @ObfuscatedName("e")
   public void method3819() {
      while(true) {
         class208 var1 = this.field3099.field3114;
         if(var1 == this.field3099) {
            this.field3098 = null;
            return;
         }

         var1.method3913();
      }
   }

   @ObfuscatedName("f")
   public void method3821(class208 var1) {
      if(var1.field3116 != null) {
         var1.method3913();
      }

      var1.field3116 = this.field3099;
      var1.field3114 = this.field3099.field3114;
      var1.field3116.field3114 = var1;
      var1.field3114.field3116 = var1;
   }

   @ObfuscatedName("s")
   public static void method3822(class208 var0, class208 var1) {
      if(var0.field3116 != null) {
         var0.method3913();
      }

      var0.field3116 = var1.field3116;
      var0.field3114 = var1;
      var0.field3116.field3114 = var0;
      var0.field3114.field3116 = var0;
   }

   @ObfuscatedName("p")
   public class208 method3823() {
      class208 var1 = this.field3099.field3114;
      if(var1 == this.field3099) {
         return null;
      } else {
         var1.method3913();
         return var1;
      }
   }

   @ObfuscatedName("h")
   public class208 method3824() {
      class208 var1 = this.field3099.field3116;
      if(var1 == this.field3099) {
         return null;
      } else {
         var1.method3913();
         return var1;
      }
   }

   @ObfuscatedName("g")
   public class208 method3825() {
      class208 var1 = this.field3099.field3114;
      if(var1 == this.field3099) {
         this.field3098 = null;
         return null;
      } else {
         this.field3098 = var1.field3114;
         return var1;
      }
   }

   @ObfuscatedName("r")
   public class208 method3827() {
      class208 var1 = this.field3098;
      if(var1 == this.field3099) {
         this.field3098 = null;
         return null;
      } else {
         this.field3098 = var1.field3114;
         return var1;
      }
   }

   public class199() {
      this.field3099.field3114 = this.field3099;
      this.field3099.field3116 = this.field3099;
   }

   @ObfuscatedName("w")
   public void method3834(class208 var1) {
      if(var1.field3116 != null) {
         var1.method3913();
      }

      var1.field3116 = this.field3099.field3116;
      var1.field3114 = this.field3099;
      var1.field3116.field3114 = var1;
      var1.field3114.field3116 = var1;
   }

   @ObfuscatedName("k")
   public class208 method3844() {
      class208 var1 = this.field3098;
      if(var1 == this.field3099) {
         this.field3098 = null;
         return null;
      } else {
         this.field3098 = var1.field3116;
         return var1;
      }
   }
}
