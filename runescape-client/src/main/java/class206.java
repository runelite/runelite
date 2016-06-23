import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
public class class206 implements Iterator {
   @ObfuscatedName("f")
   class200 field3110;
   @ObfuscatedName("u")
   class204 field3111;
   @ObfuscatedName("x")
   class204 field3112 = null;

   public Object next() {
      class204 var1 = this.field3111;
      if(var1 == this.field3110.field3101) {
         var1 = null;
         this.field3111 = null;
      } else {
         this.field3111 = var1.field3105;
      }

      this.field3112 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3111 != this.field3110.field3101;
   }

   public void remove() {
      if(this.field3112 == null) {
         throw new IllegalStateException();
      } else {
         this.field3112.method3922();
         this.field3112 = null;
      }
   }

   class206(class200 var1) {
      this.field3110 = var1;
      this.field3111 = this.field3110.field3101.field3105;
      this.field3112 = null;
   }
}
