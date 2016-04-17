import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public final class class198 implements Iterable {
   @ObfuscatedName("w")
   class208[] field3104;
   @ObfuscatedName("d")
   class208 field3105;
   @ObfuscatedName("a")
   int field3106;

   @ObfuscatedName("a")
   public class208 method3889(long var1) {
      class208 var3 = this.field3104[(int)(var1 & (long)(this.field3106 - 1))];

      for(this.field3105 = var3.field3124; this.field3105 != var3; this.field3105 = this.field3105.field3124) {
         if(this.field3105.field3125 == var1) {
            class208 var4 = this.field3105;
            this.field3105 = this.field3105.field3124;
            return var4;
         }
      }

      this.field3105 = null;
      return null;
   }

   @ObfuscatedName("w")
   public void method3890(class208 var1, long var2) {
      if(var1.field3123 != null) {
         var1.method3998();
      }

      class208 var4 = this.field3104[(int)(var2 & (long)(this.field3106 - 1))];
      var1.field3123 = var4.field3123;
      var1.field3124 = var4;
      var1.field3123.field3124 = var1;
      var1.field3124.field3123 = var1;
      var1.field3125 = var2;
   }

   @ObfuscatedName("d")
   public void method3891() {
      for(int var1 = 0; var1 < this.field3106; ++var1) {
         class208 var2 = this.field3104[var1];

         while(true) {
            class208 var3 = var2.field3124;
            if(var3 == var2) {
               break;
            }

            var3.method3998();
         }
      }

      this.field3105 = null;
   }

   public Iterator iterator() {
      return new class194(this);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1024"
   )
   public class198(int var1) {
      this.field3106 = var1;
      this.field3104 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3104[var2] = new class208();
         var3.field3124 = var3;
         var3.field3123 = var3;
      }

   }
}
