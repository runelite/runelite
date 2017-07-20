import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class188 implements Iterator {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   CombatInfoList field2421;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2422;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2423;

   @ObfuscatedSignature(
      signature = "(Lgg;)V"
   )
   class188(CombatInfoList var1) {
      this.field2423 = null;
      this.field2421 = var1;
      this.field2422 = this.field2421.node.next;
      this.field2423 = null;
   }

   public Object next() {
      Node var1 = this.field2422;
      if(var1 == this.field2421.node) {
         var1 = null;
         this.field2422 = null;
      } else {
         this.field2422 = var1.next;
      }

      this.field2423 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2421.node != this.field2422;
   }

   public void remove() {
      if(this.field2423 == null) {
         throw new IllegalStateException();
      } else {
         this.field2423.unlink();
         this.field2423 = null;
      }
   }
}
