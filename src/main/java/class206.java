import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class206 implements Iterator {
   @ObfuscatedName("d")
   class204 field3118 = null;
   @ObfuscatedName("a")
   class200 field3119;
   @ObfuscatedName("w")
   class204 field3120;

   public boolean hasNext() {
      return this.field3120 != this.field3119.field3109;
   }

   public Object next() {
      class204 var1 = this.field3120;
      if(var1 == this.field3119.field3109) {
         var1 = null;
         this.field3120 = null;
      } else {
         this.field3120 = var1.field3114;
      }

      this.field3118 = var1;
      return var1;
   }

   public void remove() {
      this.field3118.method3979();
      this.field3118 = null;
   }

   class206(class200 var1) {
      this.field3119 = var1;
      this.field3120 = this.field3119.field3109.field3114;
      this.field3118 = null;
   }
}
