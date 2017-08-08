import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("g")
   int field2440;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   @Export("table")
   XHashTable table;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("list")
   Node2LinkedList list;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   CacheableNode field2438;
   @ObfuscatedName("n")
   int field2439;

   public NodeCache(int var1) {
      this.field2438 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2439 = var1;
      this.field2440 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(J)Lgz;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgz;J)V"
   )
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2440 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2438) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2440;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("y")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3550();
      this.field2438 = new CacheableNode();
      this.field2440 = this.field2439;
   }

   @ObfuscatedName("n")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2440;
      }

   }
}
