import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dx")
public final class class121 implements Iterable {
   @ObfuscatedName("u")
   Node field1884;
   @ObfuscatedName("i")
   Node[] field1885;
   @ObfuscatedName("f")
   int field1886;

   public Iterator iterator() {
      return new class132(this);
   }

   @ObfuscatedName("f")
   public Node method2380(long var1) {
      Node var3 = this.field1885[(int)(var1 & (long)(this.field1886 - 1))];

      for(this.field1884 = var3.next; this.field1884 != var3; this.field1884 = this.field1884.next) {
         if(this.field1884.hash == var1) {
            Node var4 = this.field1884;
            this.field1884 = this.field1884.next;
            return var4;
         }
      }

      this.field1884 = null;
      return null;
   }

   @ObfuscatedName("u")
   public void method2382() {
      for(int var1 = 0; var1 < this.field1886; ++var1) {
         Node var2 = this.field1885[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field1884 = null;
   }

   public class121(int var1) {
      this.field1886 = var1;
      this.field1885 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1885[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("i")
   public void method2389(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1885[(int)(var2 & (long)(this.field1886 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }
}
