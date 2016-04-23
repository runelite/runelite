import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class195 {
   @ObfuscatedName("h")
   class207 field3095;
   @ObfuscatedName("j")
   class207 field3096 = new class207();

   @ObfuscatedName("h")
   public class207 method3731() {
      class207 var1 = this.field3096.field3120;
      if(var1 == this.field3096) {
         this.field3095 = null;
         return null;
      } else {
         this.field3095 = var1.field3120;
         return var1;
      }
   }

   @ObfuscatedName("m")
   public class207 method3733() {
      class207 var1 = this.field3095;
      if(var1 == this.field3096) {
         this.field3095 = null;
         return null;
      } else {
         this.field3095 = var1.field3120;
         return var1;
      }
   }

   public class195() {
      this.field3096.field3120 = this.field3096;
      this.field3096.field3121 = this.field3096;
   }

   @ObfuscatedName("j")
   public void method3739(class207 var1) {
      if(var1.field3121 != null) {
         var1.method3880();
      }

      var1.field3121 = this.field3096.field3121;
      var1.field3120 = this.field3096;
      var1.field3121.field3120 = var1;
      var1.field3120.field3121 = var1;
   }
}
