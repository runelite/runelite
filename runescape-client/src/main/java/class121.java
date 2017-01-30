import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
public final class class121 implements Iterable {
   @ObfuscatedName("x")
   Node field1863;
   @ObfuscatedName("g")
   Node[] field1864;
   @ObfuscatedName("p")
   int field1865;

   @ObfuscatedName("p")
   public Node method2318(long var1) {
      Node var3 = this.field1864[(int)(var1 & (long)(this.field1865 - 1))];

      for(this.field1863 = var3.next; this.field1863 != var3; this.field1863 = this.field1863.next) {
         if(this.field1863.hash == var1) {
            Node var4 = this.field1863;
            this.field1863 = this.field1863.next;
            return var4;
         }
      }

      this.field1863 = null;
      return null;
   }

   public class121(int var1) {
      this.field1865 = var1;
      this.field1864 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1864[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   public Iterator iterator() {
      return new class132(this);
   }

   @ObfuscatedName("g")
   public void method2326(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1864[(int)(var2 & (long)(this.field1865 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("x")
   public void method2329() {
      for(int var1 = 0; var1 < this.field1865; ++var1) {
         Node var2 = this.field1864[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field1863 = null;
   }
}
