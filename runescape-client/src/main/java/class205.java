import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
public class class205 implements Iterator {
   @ObfuscatedName("x")
   class208 field3107 = null;
   @ObfuscatedName("f")
   class202 field3108;
   @ObfuscatedName("u")
   class208 field3109;

   public Object next() {
      class208 var1 = this.field3109;
      if(var1 == this.field3108.field3103) {
         var1 = null;
         this.field3109 = null;
      } else {
         this.field3109 = var1.field3116;
      }

      this.field3107 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3109 != this.field3108.field3103;
   }

   public void remove() {
      if(this.field3107 == null) {
         throw new IllegalStateException();
      } else {
         this.field3107.method3946();
         this.field3107 = null;
      }
   }

   class205(class202 var1) {
      this.field3108 = var1;
      this.field3109 = this.field3108.field3103.field3116;
      this.field3107 = null;
   }
}
