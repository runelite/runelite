import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class211 implements Iterator {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   IterableDualNodeQueue field2614;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   CacheableNode field2612;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   CacheableNode field2613;

   @ObfuscatedSignature(
      signature = "(Lhe;)V"
   )
   class211(IterableDualNodeQueue var1) {
      this.field2613 = null;
      this.field2614 = var1;
      this.field2612 = this.field2614.sentinel.previous;
      this.field2613 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2612;
      if(var1 == this.field2614.sentinel) {
         var1 = null;
         this.field2612 = null;
      } else {
         this.field2612 = var1.previous;
      }

      this.field2613 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2613 == null) {
         throw new IllegalStateException();
      } else {
         this.field2613.unlinkDual();
         this.field2613 = null;
      }
   }

   public boolean hasNext() {
      return this.field2614.sentinel != this.field2612;
   }
}
