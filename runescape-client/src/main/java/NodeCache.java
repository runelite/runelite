import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   CacheableNode field2554;
   @ObfuscatedName("x")
   int field2552;
   @ObfuscatedName("k")
   int field2553;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("table")
   HashTable table;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("list")
   Node2LinkedList list;

   public NodeCache(int var1) {
      this.field2554 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.field2552 = var1;
      this.field2553 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new HashTable(var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(J)Lgt;"
   )
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   @ObfuscatedName("x")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.field2553;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgt;J)V"
   )
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field2553 == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2554) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.field2553;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   @ObfuscatedName("z")
   @Export("reset")
   public void reset() {
      this.list.clear();
      this.table.method3711();
      this.field2554 = new CacheableNode();
      this.field2553 = this.field2552;
   }
}
