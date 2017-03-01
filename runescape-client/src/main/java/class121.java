import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dy")
public final class class121 implements Iterable {
   @ObfuscatedName("n")
   Node[] field1864;
   @ObfuscatedName("g")
   Node field1865;
   @ObfuscatedName("x")
   int field1866;

   @ObfuscatedName("x")
   public Node method2404(long var1) {
      Node var3 = this.field1864[(int)(var1 & (long)(this.field1866 - 1))];

      for(this.field1865 = var3.next; this.field1865 != var3; this.field1865 = this.field1865.next) {
         if(this.field1865.hash == var1) {
            Node var4 = this.field1865;
            this.field1865 = this.field1865.next;
            return var4;
         }
      }

      this.field1865 = null;
      return null;
   }

   @ObfuscatedName("g")
   public void method2406() {
      for(int var1 = 0; var1 < this.field1866; ++var1) {
         Node var2 = this.field1864[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field1865 = null;
   }

   public Iterator iterator() {
      return new class132(this);
   }

   @ObfuscatedName("n")
   public void method2412(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1864[(int)(var2 & (long)(this.field1866 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   public class121(int var1) {
      this.field1866 = var1;
      this.field1864 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1864[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }
}
