import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
public class class205 implements Iterator {
   @ObfuscatedName("t")
   class202 field3116;
   @ObfuscatedName("i")
   class208 field3117;
   @ObfuscatedName("g")
   class208 field3118 = null;

   class205(class202 var1) {
      this.field3116 = var1;
      this.field3117 = this.field3116.field3112.field3126;
      this.field3118 = null;
   }

   public boolean hasNext() {
      return this.field3117 != this.field3116.field3112;
   }

   public void remove() {
      if(this.field3118 == null) {
         throw new IllegalStateException();
      } else {
         this.field3118.method3870();
         this.field3118 = null;
      }
   }

   public Object next() {
      class208 var1 = this.field3117;
      if(var1 == this.field3116.field3112) {
         var1 = null;
         this.field3117 = null;
      } else {
         this.field3117 = var1.field3126;
      }

      this.field3118 = var1;
      return var1;
   }
}
