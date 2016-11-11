import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("g")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("i")
   CacheableNode field3137 = new CacheableNode();
   @ObfuscatedName("e")
   int field3138;
   @ObfuscatedName("n")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();
   @ObfuscatedName("h")
   int field3140;

   @ObfuscatedName("h")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3812(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3924();
         ++this.field3138;
      }

   }

   @ObfuscatedName("e")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field3138 == 0) {
         CacheableNode var4 = this.list.method3909();
         var4.unlink();
         var4.method3924();
         if(var4 == this.field3137) {
            var4 = this.list.method3909();
            var4.unlink();
            var4.method3924();
         }
      } else {
         --this.field3138;
      }

      this.table.method3813(var1, var2);
      this.list.method3903(var1);
   }

   @ObfuscatedName("g")
   @Export("reset")
   public void reset() {
      this.list.method3908();
      this.table.method3820();
      this.field3137 = new CacheableNode();
      this.field3138 = this.field3140;
   }

   public NodeCache(int var1) {
      this.field3140 = var1;
      this.field3138 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("i")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3812(var1);
      if(var3 != null) {
         this.list.method3903(var3);
      }

      return var3;
   }
}
