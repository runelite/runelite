import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class208 implements Iterable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public CacheableNode field2583;

   public class208() {
      this.field2583 = new CacheableNode();
      this.field2583.previous = this.field2583;
      this.field2583.next = this.field2583;
   }

   @ObfuscatedName("d")
   public void method3821() {
      while(this.field2583.previous != this.field2583) {
         this.field2583.previous.unlinkDual();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   public void method3822(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2583.next;
      var1.previous = this.field2583;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class207(this);
   }
}
