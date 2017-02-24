import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dw")
public final class class121 implements Iterable {
   @ObfuscatedName("d")
   Node[] field1861;
   @ObfuscatedName("q")
   int field1862;
   @ObfuscatedName("h")
   Node field1863;

   @ObfuscatedName("d")
   public void method2365(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1861[(int)(var2 & (long)(this.field1862 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("h")
   public void method2366() {
      for(int var1 = 0; var1 < this.field1862; ++var1) {
         Node var2 = this.field1861[var1];

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

   @ObfuscatedName("q")
   public Node method2372(long var1) {
      Node var3 = this.field1861[(int)(var1 & (long)(this.field1862 - 1))];

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
      this.field1862 = var1;
      this.field1861 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1861[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }
}
