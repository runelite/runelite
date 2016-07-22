import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
public class class205 implements Iterable {
   @ObfuscatedName("w")
   class211 field3153;
   @ObfuscatedName("m")
   class211 field3154 = new class211();

   @ObfuscatedName("w")
   public void method3918(class211 var1) {
      if(var1.field3166 != null) {
         var1.method3990();
      }

      var1.field3166 = this.field3154;
      var1.field3168 = this.field3154.field3168;
      var1.field3166.field3168 = var1;
      var1.field3168.field3166 = var1;
   }

   public class205() {
      this.field3154.field3168 = this.field3154;
      this.field3154.field3166 = this.field3154;
   }

   @ObfuscatedName("o")
   public class211 method3921() {
      return this.method3922((class211)null);
   }

   @ObfuscatedName("g")
   class211 method3922(class211 var1) {
      class211 var2;
      if(var1 == null) {
         var2 = this.field3154.field3168;
      } else {
         var2 = var1;
      }

      if(var2 == this.field3154) {
         this.field3153 = null;
         return null;
      } else {
         this.field3153 = var2.field3168;
         return var2;
      }
   }

   @ObfuscatedName("e")
   public static void method3923(class211 var0, class211 var1) {
      if(var0.field3166 != null) {
         var0.method3990();
      }

      var0.field3166 = var1;
      var0.field3168 = var1.field3168;
      var0.field3166.field3168 = var0;
      var0.field3168.field3166 = var0;
   }

   @ObfuscatedName("j")
   public boolean method3924() {
      return this.field3154.field3168 == this.field3154;
   }

   public Iterator iterator() {
      return new class208(this);
   }

   @ObfuscatedName("m")
   public void method3928(class211 var1) {
      if(var1.field3166 != null) {
         var1.method3990();
      }

      var1.field3166 = this.field3154.field3166;
      var1.field3168 = this.field3154;
      var1.field3166.field3168 = var1;
      var1.field3168.field3166 = var1;
   }

   @ObfuscatedName("l")
   public class211 method3936() {
      class211 var1 = this.field3153;
      if(var1 == this.field3154) {
         this.field3153 = null;
         return null;
      } else {
         this.field3153 = var1.field3168;
         return var1;
      }
   }
}
