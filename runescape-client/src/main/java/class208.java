import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hj")
public class class208 implements Iterator {
   @ObfuscatedName("e")
   class205 field3153;
   @ObfuscatedName("l")
   class211 field3154;
   @ObfuscatedName("c")
   class211 field3155 = null;

   public Object next() {
      class211 var1 = this.field3154;
      if(var1 == this.field3153.field3149) {
         var1 = null;
         this.field3154 = null;
      } else {
         this.field3154 = var1.field3162;
      }

      this.field3155 = var1;
      return var1;
   }

   class208(class205 var1) {
      this.field3153 = var1;
      this.field3154 = this.field3153.field3149.field3162;
      this.field3155 = null;
   }

   public void remove() {
      if(this.field3155 == null) {
         throw new IllegalStateException();
      } else {
         this.field3155.method4000();
         this.field3155 = null;
      }
   }

   public boolean hasNext() {
      return this.field3154 != this.field3153.field3149;
   }
}
