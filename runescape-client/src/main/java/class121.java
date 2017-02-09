import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
public final class class121 implements Iterable {
   @ObfuscatedName("o")
   Node field1853;
   @ObfuscatedName("k")
   int field1854;
   @ObfuscatedName("y")
   Node[] field1855;

   @ObfuscatedName("y")
   public void method2296(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field1855[(int)(var2 & (long)(this.field1854 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("k")
   public Node method2297(long var1) {
      Node var3 = this.field1855[(int)(var1 & (long)(this.field1854 - 1))];

      for(this.field1853 = var3.next; this.field1853 != var3; this.field1853 = this.field1853.next) {
         if(this.field1853.hash == var1) {
            Node var4 = this.field1853;
            this.field1853 = this.field1853.next;
            return var4;
         }
      }

      this.field1853 = null;
      return null;
   }

   public Iterator iterator() {
      return new class132(this);
   }

   @ObfuscatedName("o")
   public void method2302() {
      for(int var1 = 0; var1 < this.field1854; ++var1) {
         Node var2 = this.field1855[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field1853 = null;
   }

   public class121(int var1) {
      this.field1854 = var1;
      this.field1855 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field1855[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }
}
