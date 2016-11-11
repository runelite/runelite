import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
public class class203 implements Iterable {
   @ObfuscatedName("i")
   public CacheableNode field3158 = new CacheableNode();

   @ObfuscatedName("i")
   public void method3869() {
      while(this.field3158.previous != this.field3158) {
         this.field3158.previous.method3924();
      }

   }

   public Iterator iterator() {
      return new class209(this);
   }

   public class203() {
      this.field3158.previous = this.field3158;
      this.field3158.next = this.field3158;
   }

   @ObfuscatedName("h")
   public void method3876(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3924();
      }

      var1.next = this.field3158.next;
      var1.previous = this.field3158;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }
}
