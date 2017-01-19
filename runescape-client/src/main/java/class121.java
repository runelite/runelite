import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dl")
public final class class121 implements Iterable {
   @ObfuscatedName("f")
   Node field1867;
   @ObfuscatedName("c")
   Node[] field1868;
   @ObfuscatedName("s")
   int field1869;

   @ObfuscatedName("c")
   public void method2242(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1868[(int)(var2 & (long)(this.field1869 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   public class121(int var1) {
      this.field1869 = var1;
      this.field1868 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1868[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("f")
   public void method2244() {
      for(int var1 = 0; var1 < this.field1869; ++var1) {
         Node var2 = this.field1868[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field1867 = null;
   }

   public Iterator iterator() {
      return new class132(this);
   }

   @ObfuscatedName("s")
   public Node method2251(long var1) {
      Node var3 = this.field1868[(int)(var1 & (long)(this.field1869 - 1))];

      for(this.field1867 = var3.next; this.field1867 != var3; this.field1867 = this.field1867.next) {
         if(this.field1867.hash == var1) {
            Node var4 = this.field1867;
            this.field1867 = this.field1867.next;
            return var4;
         }
      }

      this.field1867 = null;
      return null;
   }
}
