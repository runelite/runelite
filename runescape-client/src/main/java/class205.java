import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
public class class205 implements Iterator {
   @ObfuscatedName("j")
   class208 field3116;
   @ObfuscatedName("s")
   class202 field3117;
   @ObfuscatedName("p")
   class208 field3118 = null;

   class205(class202 var1) {
      this.field3117 = var1;
      this.field3116 = this.field3117.field3112.field3124;
      this.field3118 = null;
   }

   public boolean hasNext() {
      return this.field3116 != this.field3117.field3112;
   }

   public void remove() {
      if(this.field3118 == null) {
         throw new IllegalStateException();
      } else {
         this.field3118.method3898();
         this.field3118 = null;
      }
   }

   public Object next() {
      class208 var1 = this.field3116;
      if(var1 == this.field3117.field3112) {
         var1 = null;
         this.field3116 = null;
      } else {
         this.field3116 = var1.field3124;
      }

      this.field3118 = var1;
      return var1;
   }
}
