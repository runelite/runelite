import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("f")
   int field2455;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("table")
   HashTable table;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("list")
   Node2LinkedList list;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   CacheableNode field2457;
   @ObfuscatedName("h")
   int field2456;

   public NodeCache(int var1) {
      this.field2457 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2456 = var1;
      this.field2455 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new HashTable(var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(J)Lge;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lge;J)V"
   )
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2455 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2457) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2455;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("p")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3557();
      this.field2457 = new CacheableNode();
      this.field2455 = this.field2456;
   }

   @ObfuscatedName("h")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2455;
      }

   }
}
