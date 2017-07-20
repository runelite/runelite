import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public final class class186 implements Iterable {
   @ObfuscatedName("c")
   int field2419;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lgh;"
   )
   Node[] field2416;
   @ObfuscatedName("g")
   int field2415;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2417;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2418;

   public class186(int var1) {
      this.field2415 = 0;
      this.field2419 = var1;
      this.field2416 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field2416[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(J)Lgh;"
   )
   public Node method3439(long var1) {
      Node var3 = this.field2416[(int)(var1 & (long)(this.field2419 - 1))];

      for(this.field2417 = var3.next; var3 != this.field2417; this.field2417 = this.field2417.next) {
         if(this.field2417.hash == var1) {
            Node var4 = this.field2417;
            this.field2417 = this.field2417.next;
            return var4;
         }
      }

      this.field2417 = null;
      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3442() {
      Node var1;
      if(this.field2415 > 0 && this.field2416[this.field2415 - 1] != this.field2418) {
         var1 = this.field2418;
         this.field2418 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2415 >= this.field2419) {
               return null;
            }

            var1 = this.field2416[this.field2415++].next;
         } while(this.field2416[this.field2415 - 1] == var1);

         this.field2418 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgh;J)V"
   )
   public void method3440(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field2416[(int)(var2 & (long)(this.field2419 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3456() {
      this.field2415 = 0;
      return this.method3442();
   }

   public Iterator iterator() {
      return new class197(this);
   }

   @ObfuscatedName("i")
   public void method3455() {
      for(int var1 = 0; var1 < this.field2419; ++var1) {
         Node var2 = this.field2416[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2417 = null;
      this.field2418 = null;
   }
}
