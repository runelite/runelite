import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class208 implements Iterable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public CacheableNode field2581;

   public class208() {
      this.field2581 = new CacheableNode();
      this.field2581.previous = this.field2581;
      this.field2581.next = this.field2581;
   }

   @ObfuscatedName("m")
   public void method3832() {
      while(this.field2581.previous != this.field2581) {
         this.field2581.previous.unlinkDual();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgu;)V"
   )
   public void method3837(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2581.next;
      var1.previous = this.field2581;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class207(this);
   }
}
