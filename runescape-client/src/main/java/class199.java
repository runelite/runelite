import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("Deque")
public class class199 {
   @ObfuscatedName("g")
   @Export("current")
   class208 field3097;
   @ObfuscatedName("b")
   @Export("head")
   public class208 field3098 = new class208();

   @ObfuscatedName("y")
   public class208 method3818() {
      class208 var1 = this.field3098.field3115;
      if(var1 == this.field3098) {
         return null;
      } else {
         var1.method3916();
         return var1;
      }
   }

   @ObfuscatedName("g")
   public void method3819(class208 var1) {
      if(var1.field3115 != null) {
         var1.method3916();
      }

      var1.field3115 = this.field3098.field3115;
      var1.field3114 = this.field3098;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
   }

   @ObfuscatedName("j")
   public void method3820(class208 var1) {
      if(var1.field3115 != null) {
         var1.method3916();
      }

      var1.field3115 = this.field3098;
      var1.field3114 = this.field3098.field3114;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
   }

   @ObfuscatedName("d")
   public static void method3821(class208 var0, class208 var1) {
      if(var0.field3115 != null) {
         var0.method3916();
      }

      var0.field3115 = var1.field3115;
      var0.field3114 = var1;
      var0.field3115.field3114 = var0;
      var0.field3114.field3115 = var0;
   }

   public class199() {
      this.field3098.field3114 = this.field3098;
      this.field3098.field3115 = this.field3098;
   }

   @ObfuscatedName("b")
   public void method3823() {
      while(true) {
         class208 var1 = this.field3098.field3114;
         if(var1 == this.field3098) {
            this.field3097 = null;
            return;
         }

         var1.method3916();
      }
   }

   @ObfuscatedName("c")
   public class208 method3824() {
      class208 var1 = this.field3098.field3115;
      if(var1 == this.field3098) {
         this.field3097 = null;
         return null;
      } else {
         this.field3097 = var1.field3115;
         return var1;
      }
   }

   @ObfuscatedName("u")
   public class208 method3826() {
      class208 var1 = this.field3097;
      if(var1 == this.field3098) {
         this.field3097 = null;
         return null;
      } else {
         this.field3097 = var1.field3115;
         return var1;
      }
   }

   @ObfuscatedName("x")
   public class208 method3833() {
      class208 var1 = this.field3098.field3114;
      if(var1 == this.field3098) {
         return null;
      } else {
         var1.method3916();
         return var1;
      }
   }

   @ObfuscatedName("l")
   public class208 method3834() {
      class208 var1 = this.field3097;
      if(var1 == this.field3098) {
         this.field3097 = null;
         return null;
      } else {
         this.field3097 = var1.field3114;
         return var1;
      }
   }

   @ObfuscatedName("r")
   public class208 method3844() {
      class208 var1 = this.field3098.field3114;
      if(var1 == this.field3098) {
         this.field3097 = null;
         return null;
      } else {
         this.field3097 = var1.field3114;
         return var1;
      }
   }
}
