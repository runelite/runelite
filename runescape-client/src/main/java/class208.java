import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class208 implements Iterable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public CacheableNode field2574;

   public class208() {
      this.field2574 = new CacheableNode();
      this.field2574.previous = this.field2574;
      this.field2574.next = this.field2574;
   }

   @ObfuscatedName("b")
   public void method3713() {
      while(this.field2574.previous != this.field2574) {
         this.field2574.previous.unlinkDual();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   public void method3709(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.field2574.next;
      var1.previous = this.field2574;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new class207(this);
   }
}
