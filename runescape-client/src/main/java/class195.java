import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
public class class195 {
   @ObfuscatedName("i")
   class196 field2486;
   @ObfuscatedName("c")
   class196 field2487;

   @ObfuscatedName("c")
   public class196 method3603() {
      class196 var1 = this.field2486.field2489;
      if(var1 == this.field2486) {
         this.field2487 = null;
         return null;
      } else {
         this.field2487 = var1.field2489;
         return var1;
      }
   }

   public class195() {
      this.field2486 = new class196();
      this.field2486.field2489 = this.field2486;
      this.field2486.field2488 = this.field2486;
   }

   @ObfuscatedName("e")
   public class196 method3605() {
      class196 var1 = this.field2487;
      if(var1 == this.field2486) {
         this.field2487 = null;
         return null;
      } else {
         this.field2487 = var1.field2489;
         return var1;
      }
   }

   @ObfuscatedName("i")
   public void method3608(class196 var1) {
      if(var1.field2488 != null) {
         var1.method3615();
      }

      var1.field2488 = this.field2486.field2488;
      var1.field2489 = this.field2486;
      var1.field2488.field2489 = var1;
      var1.field2489.field2488 = var1;
   }
}
