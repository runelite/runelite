import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
public final class class201 implements Iterable {
   @ObfuscatedName("r")
   class211 field3153;
   @ObfuscatedName("g")
   class211[] field3154;
   @ObfuscatedName("l")
   int field3155;

   public Iterator iterator() {
      return new class197(this);
   }

   public class201(int var1) {
      this.field3155 = var1;
      this.field3154 = new class211[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class211 var3 = this.field3154[var2] = new class211();
         var3.field3173 = var3;
         var3.field3174 = var3;
      }

   }

   @ObfuscatedName("g")
   public void method3948(class211 var1, long var2) {
      if(var1.field3174 != null) {
         var1.method4067();
      }

      class211 var4 = this.field3154[(int)(var2 & (long)(this.field3155 - 1))];
      var1.field3174 = var4.field3174;
      var1.field3173 = var4;
      var1.field3174.field3173 = var1;
      var1.field3173.field3174 = var1;
      var1.field3175 = var2;
   }

   @ObfuscatedName("r")
   public void method3949() {
      for(int var1 = 0; var1 < this.field3155; ++var1) {
         class211 var2 = this.field3154[var1];

         while(true) {
            class211 var3 = var2.field3173;
            if(var3 == var2) {
               break;
            }

            var3.method4067();
         }
      }

      this.field3153 = null;
   }

   @ObfuscatedName("l")
   public class211 method3950(long var1) {
      class211 var3 = this.field3154[(int)(var1 & (long)(this.field3155 - 1))];

      for(this.field3153 = var3.field3173; this.field3153 != var3; this.field3153 = this.field3153.field3173) {
         if(this.field3153.field3175 == var1) {
            class211 var4 = this.field3153;
            this.field3153 = this.field3153.field3173;
            return var4;
         }
      }

      this.field3153 = null;
      return null;
   }
}
