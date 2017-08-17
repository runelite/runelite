import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class201 implements Iterator {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   class202 field2485;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   CacheableNode field2484;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   CacheableNode field2486;

   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   class201(class202 var1) {
      this.field2486 = null;
      this.field2485 = var1;
      this.field2484 = this.field2485.field2487.previous;
      this.field2486 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2484;
      if(var1 == this.field2485.field2487) {
         var1 = null;
         this.field2484 = null;
      } else {
         this.field2484 = var1.previous;
      }

      this.field2486 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2485.field2487 != this.field2484;
   }

   public void remove() {
      if(this.field2486 == null) {
         throw new IllegalStateException();
      } else {
         this.field2486.unlinkDual();
         this.field2486 = null;
      }
   }
}
