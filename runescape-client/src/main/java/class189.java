import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class189 implements Iterator {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   CombatInfoList field2452;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Node field2453;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Node field2454;

   @ObfuscatedSignature(
      signature = "(Lgo;)V"
   )
   class189(CombatInfoList var1) {
      this.field2454 = null;
      this.field2452 = var1;
      this.field2453 = this.field2452.node.next;
      this.field2454 = null;
   }

   public void remove() {
      if(this.field2454 == null) {
         throw new IllegalStateException();
      } else {
         this.field2454.unlink();
         this.field2454 = null;
      }
   }

   public Object next() {
      Node var1 = this.field2453;
      if(var1 == this.field2452.node) {
         var1 = null;
         this.field2453 = null;
      } else {
         this.field2453 = var1.next;
      }

      this.field2454 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2452.node != this.field2453;
   }
}
