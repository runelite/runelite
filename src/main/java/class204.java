import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
public class class204 implements Iterator {
   @ObfuscatedName("r")
   class207 field3101;
   @ObfuscatedName("f")
   class207 field3102 = null;
   @ObfuscatedName("a")
   class201 field3103;

   public Object next() {
      class207 var1 = this.field3101;
      if(var1 == this.field3103.field3097) {
         var1 = null;
         this.field3101 = null;
      } else {
         this.field3101 = var1.field3110;
      }

      this.field3102 = var1;
      return var1;
   }

   public void remove() {
      if(this.field3102 == null) {
         throw new IllegalStateException();
      } else {
         this.field3102.method3946();
         this.field3102 = null;
      }
   }

   public boolean hasNext() {
      return this.field3101 != this.field3103.field3097;
   }

   class204(class201 var1) {
      this.field3103 = var1;
      this.field3101 = this.field3103.field3097.field3110;
      this.field3102 = null;
   }
}
