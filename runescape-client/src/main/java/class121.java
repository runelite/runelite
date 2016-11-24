import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
public final class class121 implements Iterable {
   @ObfuscatedName("d")
   Node[] field1858;
   @ObfuscatedName("n")
   int field1859;
   @ObfuscatedName("m")
   Node field1860;

   @ObfuscatedName("m")
   public void method2372() {
      for(int var1 = 0; var1 < this.field1859; ++var1) {
         Node var2 = this.field1858[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field1860 = null;
   }

   public Iterator iterator() {
      return new class132(this);
   }

   @ObfuscatedName("d")
   public void method2373(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1858[(int)(var2 & (long)(this.field1859 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   public class121(int var1) {
      this.field1859 = var1;
      this.field1858 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1858[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("n")
   public Node method2378(long var1) {
      Node var3 = this.field1858[(int)(var1 & (long)(this.field1859 - 1))];

      for(this.field1860 = var3.next; this.field1860 != var3; this.field1860 = this.field1860.next) {
         if(this.field1860.hash == var1) {
            Node var4 = this.field1860;
            this.field1860 = this.field1860.next;
            return var4;
         }
      }

      this.field1860 = null;
      return null;
   }
}
