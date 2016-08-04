import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
public class class205 implements Iterable {
   @ObfuscatedName("g")
   class211 field3160;
   @ObfuscatedName("l")
   class211 field3161 = new class211();

   @ObfuscatedName("l")
   public void method4008(class211 var1) {
      if(var1.field3174 != null) {
         var1.method4067();
      }

      var1.field3174 = this.field3161.field3174;
      var1.field3173 = this.field3161;
      var1.field3174.field3173 = var1;
      var1.field3173.field3174 = var1;
   }

   @ObfuscatedName("g")
   public void method4009(class211 var1) {
      if(var1.field3174 != null) {
         var1.method4067();
      }

      var1.field3174 = this.field3161;
      var1.field3173 = this.field3161.field3173;
      var1.field3174.field3173 = var1;
      var1.field3173.field3174 = var1;
   }

   @ObfuscatedName("r")
   public static void method4010(class211 var0, class211 var1) {
      if(var0.field3174 != null) {
         var0.method4067();
      }

      var0.field3174 = var1;
      var0.field3173 = var1.field3173;
      var0.field3174.field3173 = var0;
      var0.field3173.field3174 = var0;
   }

   @ObfuscatedName("e")
   public class211 method4011() {
      return this.method4012((class211)null);
   }

   @ObfuscatedName("h")
   class211 method4012(class211 var1) {
      class211 var2;
      if(var1 == null) {
         var2 = this.field3161.field3173;
      } else {
         var2 = var1;
      }

      if(var2 == this.field3161) {
         this.field3160 = null;
         return null;
      } else {
         this.field3160 = var2.field3173;
         return var2;
      }
   }

   @ObfuscatedName("s")
   public class211 method4013() {
      class211 var1 = this.field3160;
      if(var1 == this.field3161) {
         this.field3160 = null;
         return null;
      } else {
         this.field3160 = var1.field3173;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class208(this);
   }

   @ObfuscatedName("k")
   public boolean method4017() {
      return this.field3161.field3173 == this.field3161;
   }

   public class205() {
      this.field3161.field3173 = this.field3161;
      this.field3161.field3174 = this.field3161;
   }
}
