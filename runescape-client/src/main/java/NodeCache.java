import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("f")
   CacheableNode field3128 = new CacheableNode();
   @ObfuscatedName("e")
   int field3129;
   @ObfuscatedName("n")
   int field3130;
   @ObfuscatedName("t")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("v")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();

   public NodeCache(int var1) {
      this.field3129 = var1;
      this.field3130 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("f")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3849(var1);
      if(var3 != null) {
         this.list.method3954(var3);
      }

      return var3;
   }

   @ObfuscatedName("e")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3849(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3968();
         ++this.field3130;
      }

   }

   @ObfuscatedName("n")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field3130 == 0) {
         CacheableNode var4 = this.list.method3960();
         var4.unlink();
         var4.method3968();
         if(var4 == this.field3128) {
            var4 = this.list.method3960();
            var4.unlink();
            var4.method3968();
         }
      } else {
         --this.field3130;
      }

      this.table.method3850(var1, var2);
      this.list.method3954(var1);
   }

   @ObfuscatedName("t")
   @Export("reset")
   public void reset() {
      this.list.method3958();
      this.table.method3851();
      this.field3128 = new CacheableNode();
      this.field3130 = this.field3129;
   }
}
