import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("i")
   @Export("sentinel")
   CacheableNode sentinel;

   @ObfuscatedName("i")
   public void method3539(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3687();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("h")
   public void method3540(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3687();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("u")
   CacheableNode method3541() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method3687();
         return var1;
      }
   }

   @ObfuscatedName("q")
   public CacheableNode method3542() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("g")
   void method3543() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method3687();
      }
   }

   public Node2LinkedList() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }
}
