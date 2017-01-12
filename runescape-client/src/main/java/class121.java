import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
public final class class121 implements Iterable {
   @ObfuscatedName("u")
   int field1847;
   @ObfuscatedName("x")
   Node[] field1848;
   @ObfuscatedName("i")
   Node field1849;

   @ObfuscatedName("u")
   public Node method2300(long var1) {
      Node var3 = this.field1848[(int)(var1 & (long)(this.field1847 - 1))];

      for(this.field1849 = var3.next; this.field1849 != var3; this.field1849 = this.field1849.next) {
         if(this.field1849.hash == var1) {
            Node var4 = this.field1849;
            this.field1849 = this.field1849.next;
            return var4;
         }
      }

      this.field1849 = null;
      return null;
   }

   @ObfuscatedName("x")
   public void method2301(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1848[(int)(var2 & (long)(this.field1847 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   public class121(int var1) {
      this.field1847 = var1;
      this.field1848 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1848[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   public Iterator iterator() {
      return new class132(this);
   }

   @ObfuscatedName("i")
   public void method2307() {
      for(int var1 = 0; var1 < this.field1847; ++var1) {
         Node var2 = this.field1848[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field1849 = null;
   }
}
