import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
public class class205 implements Iterator {
   @ObfuscatedName("a")
   class202 field3115;
   @ObfuscatedName("w")
   class208 field3116;
   @ObfuscatedName("d")
   class208 field3117 = null;

   class205(class202 var1) {
      this.field3115 = var1;
      this.field3116 = this.field3115.field3111.field3124;
      this.field3117 = null;
   }

   public boolean hasNext() {
      return this.field3116 != this.field3115.field3111;
   }

   public void remove() {
      if(this.field3117 == null) {
         throw new IllegalStateException();
      } else {
         this.field3117.method3998();
         this.field3117 = null;
      }
   }

   public Object next() {
      class208 var1 = this.field3116;
      if(var1 == this.field3115.field3111) {
         var1 = null;
         this.field3116 = null;
      } else {
         this.field3116 = var1.field3124;
      }

      this.field3117 = var1;
      return var1;
   }
}
