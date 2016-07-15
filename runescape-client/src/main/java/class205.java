import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class205 implements Iterable {
   @ObfuscatedName("l")
   class211 field3148;
   @ObfuscatedName("e")
   class211 field3149 = new class211();

   @ObfuscatedName("b")
   public boolean method3934() {
      return this.field3149.field3162 == this.field3149;
   }

   @ObfuscatedName("e")
   public void method3935(class211 var1) {
      if(var1.field3163 != null) {
         var1.method4000();
      }

      var1.field3163 = this.field3149.field3163;
      var1.field3162 = this.field3149;
      var1.field3163.field3162 = var1;
      var1.field3162.field3163 = var1;
   }

   @ObfuscatedName("c")
   public static void method3937(class211 var0, class211 var1) {
      if(var0.field3163 != null) {
         var0.method4000();
      }

      var0.field3163 = var1;
      var0.field3162 = var1.field3162;
      var0.field3163.field3162 = var0;
      var0.field3162.field3163 = var0;
   }

   @ObfuscatedName("h")
   public class211 method3938() {
      return this.method3941((class211)null);
   }

   @ObfuscatedName("a")
   public class211 method3940() {
      class211 var1 = this.field3148;
      if(var1 == this.field3149) {
         this.field3148 = null;
         return null;
      } else {
         this.field3148 = var1.field3162;
         return var1;
      }
   }

   public class205() {
      this.field3149.field3162 = this.field3149;
      this.field3149.field3163 = this.field3149;
   }

   @ObfuscatedName("r")
   class211 method3941(class211 var1) {
      class211 var2;
      if(var1 == null) {
         var2 = this.field3149.field3162;
      } else {
         var2 = var1;
      }

      if(var2 == this.field3149) {
         this.field3148 = null;
         return null;
      } else {
         this.field3148 = var2.field3162;
         return var2;
      }
   }

   @ObfuscatedName("l")
   public void method3945(class211 var1) {
      if(var1.field3163 != null) {
         var1.method4000();
      }

      var1.field3163 = this.field3149;
      var1.field3162 = this.field3149.field3162;
      var1.field3163.field3162 = var1;
      var1.field3162.field3163 = var1;
   }

   public Iterator iterator() {
      return new class208(this);
   }
}
