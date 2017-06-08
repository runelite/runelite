import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
public class class195 {
   @ObfuscatedName("n")
   class196 field2488;
   @ObfuscatedName("p")
   class196 field2489;

   @ObfuscatedName("n")
   public void method3645(class196 var1) {
      if(var1.field2490 != null) {
         var1.method3655();
      }

      var1.field2490 = this.field2488.field2490;
      var1.field2491 = this.field2488;
      var1.field2490.field2491 = var1;
      var1.field2491.field2490 = var1;
   }

   @ObfuscatedName("p")
   public class196 method3646() {
      class196 var1 = this.field2488.field2491;
      if(var1 == this.field2488) {
         this.field2489 = null;
         return null;
      } else {
         this.field2489 = var1.field2491;
         return var1;
      }
   }

   @ObfuscatedName("i")
   public class196 method3649() {
      class196 var1 = this.field2489;
      if(var1 == this.field2488) {
         this.field2489 = null;
         return null;
      } else {
         this.field2489 = var1.field2491;
         return var1;
      }
   }

   public class195() {
      this.field2488 = new class196();
      this.field2488.field2491 = this.field2488;
      this.field2488.field2490 = this.field2488;
   }
}
