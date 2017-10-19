import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("q")
   int field2451;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("table")
   HashTable table;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("list")
   Node2LinkedList list;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   CacheableNode field2454;
   @ObfuscatedName("s")
   int field2452;

   public NodeCache(int var1) {
      this.field2454 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2452 = var1;
      this.field2451 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new HashTable(var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(J)Lgp;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgp;J)V"
   )
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2451 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2454) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2451;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("o")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3636();
      this.field2454 = new CacheableNode();
      this.field2451 = this.field2452;
   }

   @ObfuscatedName("s")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2451;
      }

   }
}
