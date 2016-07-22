import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
public final class class201 implements Iterable {
   @ObfuscatedName("m")
   int field3146;
   @ObfuscatedName("w")
   class211[] field3147;
   @ObfuscatedName("e")
   class211 field3148;

   public class201(int var1) {
      this.field3146 = var1;
      this.field3147 = new class211[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class211 var3 = this.field3147[var2] = new class211();
         var3.field3168 = var3;
         var3.field3166 = var3;
      }

   }

   @ObfuscatedName("w")
   public void method3861(class211 var1, long var2) {
      if(var1.field3166 != null) {
         var1.method3990();
      }

      class211 var4 = this.field3147[(int)(var2 & (long)(this.field3146 - 1))];
      var1.field3166 = var4.field3166;
      var1.field3168 = var4;
      var1.field3166.field3168 = var1;
      var1.field3168.field3166 = var1;
      var1.field3167 = var2;
   }

   @ObfuscatedName("e")
   public void method3863() {
      for(int var1 = 0; var1 < this.field3146; ++var1) {
         class211 var2 = this.field3147[var1];

         while(true) {
            class211 var3 = var2.field3168;
            if(var3 == var2) {
               break;
            }

            var3.method3990();
         }
      }

      this.field3148 = null;
   }

   public Iterator iterator() {
      return new class197(this);
   }

   @ObfuscatedName("m")
   public class211 method3864(long var1) {
      class211 var3 = this.field3147[(int)(var1 & (long)(this.field3146 - 1))];

      for(this.field3148 = var3.field3168; this.field3148 != var3; this.field3148 = this.field3148.field3168) {
         if(this.field3148.field3167 == var1) {
            class211 var4 = this.field3148;
            this.field3148 = this.field3148.field3168;
            return var4;
         }
      }

      this.field3148 = null;
      return null;
   }
}
