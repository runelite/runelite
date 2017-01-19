import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("do")
public class class123 implements Iterator {
   @ObfuscatedName("s")
   CombatInfoList field1871;
   @ObfuscatedName("c")
   Node field1872;
   @ObfuscatedName("f")
   Node field1873 = null;

   public Object next() {
      Node var1 = this.field1872;
      if(var1 == this.field1871.node) {
         var1 = null;
         this.field1872 = null;
      } else {
         this.field1872 = var1.next;
      }

      this.field1873 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1872 != this.field1871.node;
   }

   public void remove() {
      if(this.field1873 == null) {
         throw new IllegalStateException();
      } else {
         this.field1873.unlink();
         this.field1873 = null;
      }
   }

   class123(CombatInfoList var1) {
      this.field1871 = var1;
      this.field1872 = this.field1871.node.next;
      this.field1873 = null;
   }
}
