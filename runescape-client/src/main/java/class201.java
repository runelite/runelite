import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
public final class class201 implements Iterable {
   @ObfuscatedName("q")
   Node[] field3145;
   @ObfuscatedName("k")
   int field3146;
   @ObfuscatedName("f")
   Node field3147;

   @ObfuscatedName("k")
   public Node method3835(long var1) {
      Node var3 = this.field3145[(int)(var1 & (long)(this.field3146 - 1))];

      for(this.field3147 = var3.next; this.field3147 != var3; this.field3147 = this.field3147.next) {
         if(this.field3147.hash == var1) {
            Node var4 = this.field3147;
            this.field3147 = this.field3147.next;
            return var4;
         }
      }

      this.field3147 = null;
      return null;
   }

   @ObfuscatedName("q")
   public void method3837(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field3145[(int)(var2 & (long)(this.field3146 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("f")
   public void method3838() {
      for(int var1 = 0; var1 < this.field3146; ++var1) {
         Node var2 = this.field3145[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field3147 = null;
   }

   public Iterator iterator() {
      return new class197(this);
   }

   public class201(int var1) {
      this.field3146 = var1;
      this.field3145 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field3145[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }
}
