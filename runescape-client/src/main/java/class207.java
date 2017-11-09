import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class207 implements Iterator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   class208 field2578;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   CacheableNode field2579;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   CacheableNode field2580;

   @ObfuscatedSignature(
      signature = "(Lha;)V"
   )
   class207(class208 var1) {
      this.field2580 = null;
      this.field2578 = var1;
      this.field2579 = this.field2578.field2581.previous;
      this.field2580 = null;
   }

   public boolean hasNext() {
      return this.field2578.field2581 != this.field2579;
   }

   public void remove() {
      if(this.field2580 == null) {
         throw new IllegalStateException();
      } else {
         this.field2580.unlinkDual();
         this.field2580 = null;
      }
   }

   public Object next() {
      CacheableNode var1 = this.field2579;
      if(var1 == this.field2578.field2581) {
         var1 = null;
         this.field2579 = null;
      } else {
         this.field2579 = var1.previous;
      }

      this.field2580 = var1;
      return var1;
   }
}
