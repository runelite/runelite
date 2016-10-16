import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
@Implements("NodeCache")
public final class NodeCache {
   @ObfuscatedName("p")
   @Export("list")
   Node2LinkedList list = new Node2LinkedList();
   @ObfuscatedName("z")
   int field3129;
   @ObfuscatedName("t")
   int field3130;
   @ObfuscatedName("y")
   @Export("table")
   XHashTable table;
   @ObfuscatedName("s")
   CacheableNode field3132 = new CacheableNode();

   public NodeCache(int var1) {
      this.field3129 = var1;
      this.field3130 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.table = new XHashTable(var2);
   }

   @ObfuscatedName("z")
   @Export("remove")
   public void remove(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3775(var1);
      if(var3 != null) {
         var3.unlink();
         var3.method3894();
         ++this.field3130;
      }

   }

   @ObfuscatedName("t")
   @Export("put")
   public void put(CacheableNode var1, long var2) {
      if(this.field3130 == 0) {
         CacheableNode var4 = this.list.method3889();
         var4.unlink();
         var4.method3894();
         if(var4 == this.field3132) {
            var4 = this.list.method3889();
            var4.unlink();
            var4.method3894();
         }
      } else {
         --this.field3130;
      }

      this.table.method3776(var1, var2);
      this.list.method3872(var1);
   }

   @ObfuscatedName("y")
   @Export("reset")
   public void reset() {
      this.list.method3876();
      this.table.method3777();
      this.field3132 = new CacheableNode();
      this.field3130 = this.field3129;
   }

   @ObfuscatedName("s")
   @Export("get")
   public CacheableNode get(long var1) {
      CacheableNode var3 = (CacheableNode)this.table.method3775(var1);
      if(var3 != null) {
         this.list.method3872(var3);
      }

      return var3;
   }
}
