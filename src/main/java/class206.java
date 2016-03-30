import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
public class class206 implements Iterator {
   @ObfuscatedName("t")
   class204 field3118 = null;
   @ObfuscatedName("x")
   class204 field3119;
   @ObfuscatedName("w")
   class200 field3120;

   public boolean hasNext() {
      return this.field3119 != this.field3120.field3109;
   }

   public Object next() {
      class204 var1 = this.field3119;
      if(var1 == this.field3120.field3109) {
         var1 = null;
         this.field3119 = null;
      } else {
         this.field3119 = var1.field3114;
      }

      this.field3118 = var1;
      return var1;
   }

   public void remove() {
      if(this.field3118 == null) {
         throw new IllegalStateException();
      } else {
         this.field3118.method3909();
         this.field3118 = null;
      }
   }

   class206(class200 var1) {
      this.field3120 = var1;
      this.field3119 = this.field3120.field3109.field3114;
      this.field3118 = null;
   }
}
