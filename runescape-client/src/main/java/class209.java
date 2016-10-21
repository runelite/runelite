import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hu")
public class class209 implements Iterator {
   @ObfuscatedName("f")
   class203 field3160;
   @ObfuscatedName("e")
   CacheableNode field3161;
   @ObfuscatedName("n")
   CacheableNode field3162 = null;

   public boolean hasNext() {
      return this.field3161 != this.field3160.field3150;
   }

   public Object next() {
      CacheableNode var1 = this.field3161;
      if(var1 == this.field3160.field3150) {
         var1 = null;
         this.field3161 = null;
      } else {
         this.field3161 = var1.previous;
      }

      this.field3162 = var1;
      return var1;
   }

   public void remove() {
      if(this.field3162 == null) {
         throw new IllegalStateException();
      } else {
         this.field3162.method3968();
         this.field3162 = null;
      }
   }

   class209(class203 var1) {
      this.field3160 = var1;
      this.field3161 = this.field3160.field3150.previous;
      this.field3162 = null;
   }
}
