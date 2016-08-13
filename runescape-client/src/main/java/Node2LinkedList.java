import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("l")
   @Export("sentinel")
   CacheableNode sentinel = new CacheableNode();

   @ObfuscatedName("e")
   public CacheableNode method4029() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("r")
   CacheableNode method4032() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method4045();
         return var1;
      }
   }

   @ObfuscatedName("l")
   public void method4033(CacheableNode var1) {
      if(var1.next != null) {
         var1.method4045();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("h")
   void method4034() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method4045();
      }
   }

   public Node2LinkedList() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("g")
   public void method4043(CacheableNode var1) {
      if(var1.next != null) {
         var1.method4045();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }
}
