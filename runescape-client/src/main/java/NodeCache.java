import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("v")
   int field3132;
   @ObfuscatedName("d")
   int field3133;
   @ObfuscatedName("a")
   CacheableNode field3134 = new CacheableNode();
   @ObfuscatedName("r")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("z")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   @ObfuscatedName("a")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3817(var1);
      if(var3 != null) {
         this.list.method3925(var3);
      }

      return var3;
   }

   @ObfuscatedName("v")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field3132 == 0) {
         CacheableNode var4 = this.list.method3927();
         var4.unlink();
         var4.method3938();
         if(var4 == this.field3134) {
            var4 = this.list.method3927();
            var4.unlink();
            var4.method3938();
         }
      } else {
         --this.field3132;
      }

      this.table.method3823(var1, var2);
      this.list.method3925(var1);
   }

   @ObfuscatedName("d")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3817(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3938();
         ++this.field3132;
      }

   }

   @ObfuscatedName("r")
   @Export("reset")
   public void reset() {
      this.list.method3934();
      this.table.method3819();
      this.field3134 = new CacheableNode();
      this.field3132 = this.field3133;
   }

   public NodeCache(int var1) {
      this.field3133 = var1;
      this.field3132 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }
}
