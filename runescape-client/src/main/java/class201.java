import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
public final class class201 implements Iterable {
   @ObfuscatedName("e")
   int field3141;
   @ObfuscatedName("l")
   class211[] field3142;
   @ObfuscatedName("c")
   class211 field3143;

   @ObfuscatedName("e")
   public class211 method3882(long var1) {
      class211 var3 = this.field3142[(int)(var1 & (long)(this.field3141 - 1))];

      for(this.field3143 = var3.field3162; this.field3143 != var3; this.field3143 = this.field3143.field3162) {
         if(this.field3143.field3161 == var1) {
            class211 var4 = this.field3143;
            this.field3143 = this.field3143.field3162;
            return var4;
         }
      }

      this.field3143 = null;
      return null;
   }

   @ObfuscatedName("l")
   public void method3883(class211 var1, long var2) {
      if(var1.field3163 != null) {
         var1.method4000();
      }

      class211 var4 = this.field3142[(int)(var2 & (long)(this.field3141 - 1))];
      var1.field3163 = var4.field3163;
      var1.field3162 = var4;
      var1.field3163.field3162 = var1;
      var1.field3162.field3163 = var1;
      var1.field3161 = var2;
   }

   @ObfuscatedName("c")
   public void method3884() {
      for(int var1 = 0; var1 < this.field3141; ++var1) {
         class211 var2 = this.field3142[var1];

         while(true) {
            class211 var3 = var2.field3162;
            if(var3 == var2) {
               break;
            }

            var3.method4000();
         }
      }

      this.field3143 = null;
   }

   public Iterator iterator() {
      return new class197(this);
   }

   public class201(int var1) {
      this.field3141 = var1;
      this.field3142 = new class211[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class211 var3 = this.field3142[var2] = new class211();
         var3.field3162 = var3;
         var3.field3163 = var3;
      }

   }
}
