import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
@Implements("Node2LinkedList")
public final class class206 {
   @ObfuscatedName("l")
   @Export("sentinel")
   class207 field3162 = new class207();

   @ObfuscatedName("e")
   public class207 method4029() {
      class207 var1 = this.field3162.field3164;
      return var1 == this.field3162?null:var1;
   }

   @ObfuscatedName("r")
   class207 method4032() {
      class207 var1 = this.field3162.field3164;
      if(var1 == this.field3162) {
         return null;
      } else {
         var1.method4045();
         return var1;
      }
   }

   @ObfuscatedName("l")
   public void method4033(class207 var1) {
      if(var1.field3163 != null) {
         var1.method4045();
      }

      var1.field3163 = this.field3162.field3163;
      var1.field3164 = this.field3162;
      var1.field3163.field3164 = var1;
      var1.field3164.field3163 = var1;
   }

   @ObfuscatedName("h")
   void method4034() {
      while(true) {
         class207 var1 = this.field3162.field3164;
         if(var1 == this.field3162) {
            return;
         }

         var1.method4045();
      }
   }

   public class206() {
      this.field3162.field3164 = this.field3162;
      this.field3162.field3163 = this.field3162;
   }

   @ObfuscatedName("g")
   public void method4043(class207 var1) {
      if(var1.field3163 != null) {
         var1.method4045();
      }

      var1.field3163 = this.field3162;
      var1.field3164 = this.field3162.field3164;
      var1.field3163.field3164 = var1;
      var1.field3164.field3163 = var1;
   }
}
