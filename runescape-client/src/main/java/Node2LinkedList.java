import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("i")
   @Export("sentinel")
   CacheableNode sentinel = new CacheableNode();

   @ObfuscatedName("f")
   CacheableNode method2257() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method2388();
         return var1;
      }
   }

   @ObfuscatedName("i")
   public void method2258(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2388();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("e")
   public void method2259(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2388();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("k")
   public CacheableNode method2261() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("a")
   void method2263() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method2388();
      }
   }

   public Node2LinkedList() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }
}
