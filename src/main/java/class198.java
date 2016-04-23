import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public final class class198 implements Iterable {
   @ObfuscatedName("m")
   class208 field3103;
   @ObfuscatedName("h")
   class208[] field3104;
   @ObfuscatedName("j")
   int field3105;

   @ObfuscatedName("j")
   public class208 method3764(long var1) {
      class208 var3 = this.field3104[(int)(var1 & (long)(this.field3105 - 1))];

      for(this.field3103 = var3.field3123; this.field3103 != var3; this.field3103 = this.field3103.field3123) {
         if(this.field3103.field3122 == var1) {
            class208 var4 = this.field3103;
            this.field3103 = this.field3103.field3123;
            return var4;
         }
      }

      this.field3103 = null;
      return null;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1024"
   )
   public class198(int var1) {
      this.field3105 = var1;
      this.field3104 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3104[var2] = new class208();
         var3.field3123 = var3;
         var3.field3124 = var3;
      }

   }

   public Iterator iterator() {
      return new class194(this);
   }

   @ObfuscatedName("h")
   public void method3765(class208 var1, long var2) {
      if(var1.field3124 != null) {
         var1.method3883();
      }

      class208 var4 = this.field3104[(int)(var2 & (long)(this.field3105 - 1))];
      var1.field3124 = var4.field3124;
      var1.field3123 = var4;
      var1.field3124.field3123 = var1;
      var1.field3123.field3124 = var1;
      var1.field3122 = var2;
   }

   @ObfuscatedName("m")
   public void method3766() {
      for(int var1 = 0; var1 < this.field3105; ++var1) {
         class208 var2 = this.field3104[var1];

         while(true) {
            class208 var3 = var2.field3123;
            if(var3 == var2) {
               break;
            }

            var3.method3883();
         }
      }

      this.field3103 = null;
   }
}
