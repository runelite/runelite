import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class188 implements Iterator {
   @ObfuscatedName("h")
   Node field2450;
   @ObfuscatedName("u")
   Node field2451;
   @ObfuscatedName("i")
   CombatInfoList field2452;

   public boolean hasNext() {
      return this.field2450 != this.field2452.node;
   }

   public Object next() {
      Node var1 = this.field2450;
      if(var1 == this.field2452.node) {
         var1 = null;
         this.field2450 = null;
      } else {
         this.field2450 = var1.next;
      }

      this.field2451 = var1;
      return var1;
   }

   class188(CombatInfoList var1) {
      this.field2451 = null;
      this.field2452 = var1;
      this.field2450 = this.field2452.node.next;
      this.field2451 = null;
   }

   public void remove() {
      if(this.field2451 == null) {
         throw new IllegalStateException();
      } else {
         this.field2451.unlink();
         this.field2451 = null;
      }
   }
}
