import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class226 implements Iterator {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   IterableDualNodeQueue field2655;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   CacheableNode field2656;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   CacheableNode field2657;

   @ObfuscatedSignature(
      signature = "(Lhv;)V"
   )
   class226(IterableDualNodeQueue var1) {
      this.field2657 = null;
      this.field2655 = var1;
      this.field2656 = this.field2655.sentinel.previous;
      this.field2657 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2656;
      if(var1 == this.field2655.sentinel) {
         var1 = null;
         this.field2656 = null;
      } else {
         this.field2656 = var1.previous;
      }

      this.field2657 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2655.sentinel != this.field2656;
   }

   public void remove() {
      if(this.field2657 == null) {
         throw new IllegalStateException();
      } else {
         this.field2657.unlinkDual();
         this.field2657 = null;
      }
   }
}
