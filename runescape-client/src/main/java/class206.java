import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class206 implements Iterator {
   @ObfuscatedName("s")
   class200 field3119;
   @ObfuscatedName("j")
   class204 field3120;
   @ObfuscatedName("p")
   class204 field3121 = null;

   public Object next() {
      class204 var1 = this.field3120;
      if(var1 == this.field3119.field3110) {
         var1 = null;
         this.field3120 = null;
      } else {
         this.field3120 = var1.field3114;
      }

      this.field3121 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3120 != this.field3119.field3110;
   }

   public void remove() {
      if(this.field3121 == null) {
         throw new IllegalStateException();
      } else {
         this.field3121.method3876();
         this.field3121 = null;
      }
   }

   class206(class200 var1) {
      this.field3119 = var1;
      this.field3120 = this.field3119.field3110.field3114;
      this.field3121 = null;
   }
}
