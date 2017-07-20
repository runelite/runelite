import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class200 implements Iterator {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   class201 field2455;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   CacheableNode field2453;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   CacheableNode field2454;

   @ObfuscatedSignature(
      signature = "(Lgm;)V"
   )
   class200(class201 var1) {
      this.field2454 = null;
      this.field2455 = var1;
      this.field2453 = this.field2455.field2456.previous;
      this.field2454 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2453;
      if(var1 == this.field2455.field2456) {
         var1 = null;
         this.field2453 = null;
      } else {
         this.field2453 = var1.previous;
      }

      this.field2454 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2455.field2456 != this.field2453;
   }

   public void remove() {
      if(this.field2454 == null) {
         throw new IllegalStateException();
      } else {
         this.field2454.unlinkDual();
         this.field2454 = null;
      }
   }
}
