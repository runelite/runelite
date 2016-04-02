import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
public class class205 implements Iterator {
   @ObfuscatedName("e")
   class202 field3106;
   @ObfuscatedName("w")
   class208 field3107;
   @ObfuscatedName("f")
   class208 field3108 = null;

   public Object next() {
      class208 var1 = this.field3107;
      if(var1 == this.field3106.field3102) {
         var1 = null;
         this.field3107 = null;
      } else {
         this.field3107 = var1.field3114;
      }

      this.field3108 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3107 != this.field3106.field3102;
   }

   public void remove() {
      if(this.field3108 == null) {
         throw new IllegalStateException();
      } else {
         this.field3108.method3913();
         this.field3108 = null;
      }
   }

   class205(class202 var1) {
      this.field3106 = var1;
      this.field3107 = this.field3106.field3102.field3114;
      this.field3108 = null;
   }
}
