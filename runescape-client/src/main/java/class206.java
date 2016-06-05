import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class206 implements Iterator {
   @ObfuscatedName("i")
   class204 field3119;
   @ObfuscatedName("g")
   class204 field3120 = null;
   @ObfuscatedName("t")
   class200 field3121;

   public boolean hasNext() {
      return this.field3119 != this.field3121.field3110;
   }

   public void remove() {
      if(this.field3120 == null) {
         throw new IllegalStateException();
      } else {
         this.field3120.method3844();
         this.field3120 = null;
      }
   }

   public Object next() {
      class204 var1 = this.field3119;
      if(var1 == this.field3121.field3110) {
         var1 = null;
         this.field3119 = null;
      } else {
         this.field3119 = var1.field3114;
      }

      this.field3120 = var1;
      return var1;
   }

   class206(class200 var1) {
      this.field3121 = var1;
      this.field3119 = this.field3121.field3110.field3114;
      this.field3120 = null;
   }
}
