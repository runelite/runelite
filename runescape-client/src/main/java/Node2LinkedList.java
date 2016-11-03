import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("k")
   @Export("sentinel")
   CacheableNode sentinel = new CacheableNode();

   @ObfuscatedName("c")
   public CacheableNode method3914() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("q")
   public void method3916(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3932();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("f")
   CacheableNode method3917() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method3932();
         return var1;
      }
   }

   @ObfuscatedName("v")
   void method3919() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method3932();
      }
   }

   @ObfuscatedName("k")
   public void method3920(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3932();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Node2LinkedList() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }
}
