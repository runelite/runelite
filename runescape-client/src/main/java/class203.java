import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class203 implements Iterable {
   @ObfuscatedName("l")
   public CacheableNode field3158 = new CacheableNode();

   @ObfuscatedName("g")
   public void method4001(CacheableNode var1) {
      if(var1.next != null) {
         var1.method4045();
      }

      var1.next = this.field3158.next;
      var1.previous = this.field3158;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("l")
   public void method4002() {
      while(this.field3158.previous != this.field3158) {
         this.field3158.previous.method4045();
      }

   }

   public class203() {
      this.field3158.previous = this.field3158;
      this.field3158.next = this.field3158;
   }

   public Iterator iterator() {
      return new class209(this);
   }
}
