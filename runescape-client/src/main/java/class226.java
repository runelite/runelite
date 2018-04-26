import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class226 implements Iterator {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   IterableDualNodeQueue field2679;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   CacheableNode field2678;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   CacheableNode field2677;

   @ObfuscatedSignature(
      signature = "(Lhy;)V"
   )
   class226(IterableDualNodeQueue var1) {
      this.field2677 = null;
      this.field2679 = var1;
      this.field2678 = this.field2679.sentinel.previous;
      this.field2677 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2678;
      if(var1 == this.field2679.sentinel) {
         var1 = null;
         this.field2678 = null;
      } else {
         this.field2678 = var1.previous;
      }

      this.field2677 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2677 == null) {
         throw new IllegalStateException();
      } else {
         this.field2677.unlinkDual();
         this.field2677 = null;
      }
   }

   public boolean hasNext() {
      return this.field2679.sentinel != this.field2678;
   }
}
