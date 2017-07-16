import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public final class class186 implements Iterable {
   @ObfuscatedName("a")
   int field2446;
   @ObfuscatedName("v")
   int field2443;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lge;"
   )
   Node[] field2444;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   Node field2447;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   Node field2445;

   public class186(int var1) {
      this.field2443 = 0;
      this.field2446 = var1;
      this.field2444 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field2444[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(J)Lge;"
   )
   public Node method3482(long var1) {
      Node var3 = this.field2444[(int)(var1 & (long)(this.field2446 - 1))];

      for(this.field2447 = var3.next; var3 != this.field2447; this.field2447 = this.field2447.next) {
         if(this.field2447.hash == var1) {
            Node var4 = this.field2447;
            this.field2447 = this.field2447.next;
            return var4;
         }
      }

      this.field2447 = null;
      return null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lge;"
   )
   public Node method3485() {
      Node var1;
      if(this.field2443 > 0 && this.field2444[this.field2443 - 1] != this.field2445) {
         var1 = this.field2445;
         this.field2445 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2443 >= this.field2446) {
               return null;
            }

            var1 = this.field2444[this.field2443++].next;
         } while(this.field2444[this.field2443 - 1] == var1);

         this.field2445 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lge;J)V"
   )
   public void method3501(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field2444[(int)(var2 & (long)(this.field2446 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Lge;"
   )
   public Node method3484() {
      this.field2443 = 0;
      return this.method3485();
   }

   @ObfuscatedName("n")
   public void method3483() {
      for(int var1 = 0; var1 < this.field2446; ++var1) {
         Node var2 = this.field2444[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2447 = null;
      this.field2445 = null;
   }

   public Iterator iterator() {
      return new class197(this);
   }
}
