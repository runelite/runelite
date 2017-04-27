import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
public final class class142 implements Iterable {
   @ObfuscatedName("d")
   int field2010;
   @ObfuscatedName("c")
   Node[] field2011;
   @ObfuscatedName("n")
   Node field2012;
   @ObfuscatedName("q")
   Node field2013;
   @ObfuscatedName("t")
   int field2014 = 0;

   @ObfuscatedName("d")
   public Node method2728(long var1) {
      Node var3 = this.field2011[(int)(var1 & (long)(this.field2010 - 1))];

      for(this.field2012 = var3.next; this.field2012 != var3; this.field2012 = this.field2012.next) {
         if(this.field2012.hash == var1) {
            Node var4 = this.field2012;
            this.field2012 = this.field2012.next;
            return var4;
         }
      }

      this.field2012 = null;
      return null;
   }

   @ObfuscatedName("c")
   public void method2729(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field2011[(int)(var2 & (long)(this.field2010 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("q")
   public Node method2730() {
      this.field2014 = 0;
      return this.method2732();
   }

   @ObfuscatedName("t")
   public Node method2732() {
      Node var1;
      if(this.field2014 > 0 && this.field2013 != this.field2011[this.field2014 - 1]) {
         var1 = this.field2013;
         this.field2013 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2014 >= this.field2010) {
               return null;
            }

            var1 = this.field2011[this.field2014++].next;
         } while(var1 == this.field2011[this.field2014 - 1]);

         this.field2013 = var1.next;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class153(this);
   }

   public class142(int var1) {
      this.field2010 = var1;
      this.field2011 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field2011[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("n")
   public void method2746() {
      for(int var1 = 0; var1 < this.field2010; ++var1) {
         Node var2 = this.field2011[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2012 = null;
      this.field2013 = null;
   }
}
