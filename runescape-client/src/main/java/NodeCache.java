import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   CacheableNode field2551;
   @ObfuscatedName("p")
   int field2550;
   @ObfuscatedName("i")
   int field2549;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("table")
   HashTable table;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("list")
   Node2LinkedList list;

   public NodeCache(int var1) {
      this.field2551 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2550 = var1;
      this.field2549 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new HashTable(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(J)Lgu;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("p")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2549;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgu;J)V"
   )
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2549 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2551) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2549;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("j")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3720();
      this.field2551 = new CacheableNode();
      this.field2549 = this.field2550;
   }
}
