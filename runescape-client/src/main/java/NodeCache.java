import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("r")
   int field3135;
   @ObfuscatedName("i")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();
   @ObfuscatedName("j")
   int field3137;
   @ObfuscatedName("z")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("x")
   CacheableNode field3139 = new CacheableNode();

   @ObfuscatedName("x")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3830(var1);
      if(var3 != null) {
         this.list.method3920(var3);
      }

      return var3;
   }

   @ObfuscatedName("z")
   @Export("reset")
   public void reset() {
      this.list.method3906();
      this.table.method3820();
      this.field3139 = new CacheableNode();
      this.field3137 = this.field3135;
   }

   @ObfuscatedName("j")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field3137 == 0) {
         CacheableNode var4 = this.list.method3924();
         var4.unlink();
         var4.method3925();
         if(var4 == this.field3139) {
            var4 = this.list.method3924();
            var4.unlink();
            var4.method3925();
         }
      } else {
         --this.field3137;
      }

      this.table.method3819(var1, var2);
      this.list.method3920(var1);
   }

   @ObfuscatedName("r")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3830(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3925();
         ++this.field3137;
      }

   }

   public NodeCache(int var1) {
      this.field3135 = var1;
      this.field3137 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
