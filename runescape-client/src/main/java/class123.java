import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("do")
public class class123 implements Iterator {
   @ObfuscatedName("f")
   CombatInfoList field1888;
   @ObfuscatedName("i")
   Node field1889;
   @ObfuscatedName("u")
   Node field1890 = null;

   public boolean hasNext() {
      return this.field1889 != this.field1888.node;
   }

   public Object next() {
      Node var1 = this.field1889;
      if(var1 == this.field1888.node) {
         var1 = null;
         this.field1889 = null;
      } else {
         this.field1889 = var1.next;
      }

      this.field1890 = var1;
      return var1;
   }

   class123(CombatInfoList var1) {
      this.field1888 = var1;
      this.field1889 = this.field1888.node.next;
      this.field1890 = null;
   }

   public void remove() {
      if(this.field1890 == null) {
         throw new IllegalStateException();
      } else {
         this.field1890.unlink();
         this.field1890 = null;
      }
   }
}
