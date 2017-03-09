import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("de")
public final class class121 implements Iterable {
   @ObfuscatedName("c")
   Node field1863;
   @ObfuscatedName("x")
   int field1864;
   @ObfuscatedName("j")
   Node[] field1865;

   public class121(int var1) {
      this.field1864 = var1;
      this.field1865 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1865[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("j")
   public void method2356(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1865[(int)(var2 & (long)(this.field1864 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("c")
   public void method2357() {
      for(int var1 = 0; var1 < this.field1864; ++var1) {
         Node var2 = this.field1865[var1];

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

   public Iterator iterator() {
      return new class132(this);
   }

   @ObfuscatedName("x")
   public Node method2361(long var1) {
      Node var3 = this.field1865[(int)(var1 & (long)(this.field1864 - 1))];

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
}
