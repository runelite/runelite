import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class195 {
   @ObfuscatedName("m")
   class196 field2488;
   @ObfuscatedName("p")
   class196 field2489;

   @ObfuscatedName("e")
   public class196 method3523() {
      class196 var1 = this.field2488;
      if(var1 == this.field2489) {
         this.field2488 = null;
         return null;
      } else {
         this.field2488 = var1.field2490;
         return var1;
      }
   }

   public class195() {
      this.field2489 = new class196();
      this.field2489.field2490 = this.field2489;
      this.field2489.field2491 = this.field2489;
   }

   @ObfuscatedName("m")
   public class196 method3524() {
      class196 var1 = this.field2489.field2490;
      if(var1 == this.field2489) {
         this.field2488 = null;
         return null;
      } else {
         this.field2488 = var1.field2490;
         return var1;
      }
   }

   @ObfuscatedName("p")
   public void method3525(class196 var1) {
      if(var1.field2491 != null) {
         var1.method3529();
      }

      var1.field2491 = this.field2489.field2491;
      var1.field2490 = this.field2489;
      var1.field2491.field2490 = var1;
      var1.field2490.field2491 = var1;
   }
}
