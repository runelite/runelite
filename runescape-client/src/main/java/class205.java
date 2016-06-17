import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
public class class205 implements Iterator {
   @ObfuscatedName("j")
   class208 field3105 = null;
   @ObfuscatedName("g")
   class208 field3106;
   @ObfuscatedName("b")
   class202 field3107;

   public Object next() {
      class208 var1 = this.field3106;
      if(var1 == this.field3107.field3101) {
         var1 = null;
         this.field3106 = null;
      } else {
         this.field3106 = var1.field3114;
      }

      this.field3105 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3106 != this.field3107.field3101;
   }

   public void remove() {
      if(this.field3105 == null) {
         throw new IllegalStateException();
      } else {
         this.field3105.method3916();
         this.field3105 = null;
      }
   }

   class205(class202 var1) {
      this.field3107 = var1;
      this.field3106 = this.field3107.field3101.field3114;
      this.field3105 = null;
   }
}
