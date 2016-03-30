import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
public class class205 implements Iterator {
   @ObfuscatedName("w")
   class202 field3115;
   @ObfuscatedName("x")
   class208 field3116;
   @ObfuscatedName("t")
   class208 field3117 = null;

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

   public boolean hasNext() {
      return this.field3116 != this.field3115.field3111;
   }

   class205(class202 var1) {
      this.field3115 = var1;
      this.field3116 = this.field3115.field3111.field3124;
      this.field3117 = null;
   }

   public void remove() {
      this.field3117.method3935();
      this.field3117 = null;
   }
}
