import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
public class class205 implements Iterable {
   @ObfuscatedName("g")
   Node field3160;
   @ObfuscatedName("l")
   Node field3161 = new Node();

   @ObfuscatedName("l")
   public void method4008(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3161.previous;
      var1.next = this.field3161;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("g")
   public void method4009(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3161;
      var1.next = this.field3161.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("r")
   public static void method4010(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("e")
   public Node method4011() {
      return this.method4012((Node)null);
   }

   @ObfuscatedName("h")
   Node method4012(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.field3161.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.field3161) {
         this.field3160 = null;
         return null;
      } else {
         this.field3160 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("s")
   public Node method4013() {
      Node var1 = this.field3160;
      if(var1 == this.field3161) {
         this.field3160 = null;
         return null;
      } else {
         this.field3160 = var1.next;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class208(this);
   }

   @ObfuscatedName("k")
   public boolean method4017() {
      return this.field3161.next == this.field3161;
   }

   public class205() {
      this.field3161.next = this.field3161;
      this.field3161.previous = this.field3161;
   }
}
