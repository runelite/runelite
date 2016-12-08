import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
public final class class121 implements Iterable {
   @ObfuscatedName("b")
   Node field1874;
   @ObfuscatedName("m")
   Node[] field1875;
   @ObfuscatedName("o")
   int field1876;

   @ObfuscatedName("o")
   public Node method2258(long var1) {
      Node var3 = this.field1875[(int)(var1 & (long)(this.field1876 - 1))];

      for(this.field1874 = var3.next; this.field1874 != var3; this.field1874 = this.field1874.next) {
         if(this.field1874.hash == var1) {
            Node var4 = this.field1874;
            this.field1874 = this.field1874.next;
            return var4;
         }
      }

      this.field1874 = null;
      return null;
   }

   @ObfuscatedName("m")
   public void method2259(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1875[(int)(var2 & (long)(this.field1876 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("b")
   public void method2260() {
      for(int var1 = 0; var1 < this.field1876; ++var1) {
         Node var2 = this.field1875[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field1874 = null;
   }

   public class121(int var1) {
      this.field1876 = var1;
      this.field1875 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1875[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   public Iterator iterator() {
      return new class132(this);
   }
}
