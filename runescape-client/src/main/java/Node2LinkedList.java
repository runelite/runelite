import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("n")
   @Export("sentinel")
   CacheableNode sentinel;

   @ObfuscatedName("n")
   public void method3472(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3641();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("p")
   public void method3474(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3641();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("i")
   CacheableNode method3476() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method3641();
         return var1;
      }
   }

   public Node2LinkedList() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("j")
   public CacheableNode method3485() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("f")
   void method3490() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method3641();
      }
   }
}
