import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hp")
public class class209 implements Iterator {
   @ObfuscatedName("t")
   CacheableNode field3160 = null;
   @ObfuscatedName("z")
   CacheableNode field3161;
   @ObfuscatedName("s")
   class203 field3162;

   public boolean hasNext() {
      return this.field3161 != this.field3162.field3150;
   }

   public void remove() {
      if(this.field3160 == null) {
         throw new IllegalStateException();
      } else {
         this.field3160.method3894();
         this.field3160 = null;
      }
   }

   public Object next() {
      CacheableNode var1 = this.field3161;
      if(var1 == this.field3162.field3150) {
         var1 = null;
         this.field3161 = null;
      } else {
         this.field3161 = var1.previous;
      }

      this.field3160 = var1;
      return var1;
   }

   class209(class203 var1) {
      this.field3162 = var1;
      this.field3161 = this.field3162.field3150.previous;
      this.field3160 = null;
   }
}
