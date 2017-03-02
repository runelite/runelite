import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dl")
public final class class121 implements Iterable {
   @ObfuscatedName("b")
   int field1857;
   @ObfuscatedName("l")
   Node[] field1858;
   @ObfuscatedName("i")
   Node field1859;

   @ObfuscatedName("l")
   public void method2382(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1858[(int)(var2 & (long)(this.field1857 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("i")
   public void method2383() {
      for(int var1 = 0; var1 < this.field1857; ++var1) {
         Node var2 = this.field1858[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field1859 = null;
   }

   public class121(int var1) {
      this.field1857 = var1;
      this.field1858 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1858[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("b")
   public Node method2386(long var1) {
      Node var3 = this.field1858[(int)(var1 & (long)(this.field1857 - 1))];

      for(this.field1859 = var3.next; this.field1859 != var3; this.field1859 = this.field1859.next) {
         if(this.field1859.hash == var1) {
            Node var4 = this.field1859;
            this.field1859 = this.field1859.next;
            return var4;
         }
      }

      this.field1859 = null;
      return null;
   }

   public Iterator iterator() {
      return new class132(this);
   }
}
