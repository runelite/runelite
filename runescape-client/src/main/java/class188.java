import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class188 implements Iterator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   CombatInfoList field2425;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   Node field2424;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   Node field2423;

   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   class188(CombatInfoList var1) {
      this.field2423 = null;
      this.field2425 = var1;
      this.field2424 = this.field2425.node.next;
      this.field2423 = null;
   }

   public boolean hasNext() {
      return this.field2425.node != this.field2424;
   }

   public void remove() {
      this.field2423.unlink();
      this.field2423 = null;
   }

   public Object next() {
      Node var1 = this.field2424;
      if(var1 == this.field2425.node) {
         var1 = null;
         this.field2424 = null;
      } else {
         this.field2424 = var1.next;
      }

      this.field2423 = var1;
      return var1;
   }
}
