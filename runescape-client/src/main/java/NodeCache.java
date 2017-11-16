import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   CacheableNode field2546;
   @ObfuscatedName("s")
   int field2543;
   @ObfuscatedName("r")
   int field2544;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("table")
   HashTable table;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("list")
   Node2LinkedList list;

   public NodeCache(int var1) {
      this.field2546 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2543 = var1;
      this.field2544 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new HashTable(var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(J)Lgh;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("s")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2544;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgh;J)V"
   )
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2544 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2546) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2544;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("g")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3591();
      this.field2546 = new CacheableNode();
      this.field2544 = this.field2543;
   }
}
