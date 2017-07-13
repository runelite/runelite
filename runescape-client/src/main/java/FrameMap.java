import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("e")
   @Export("item_ref")
   static IndexDataBase item_ref;
   @ObfuscatedName("v")
   static Thread field2049;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -478955957
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1438586063
   )
   @Export("count")
   int count;
   @ObfuscatedName("n")
   @Export("types")
   int[] types;
   @ObfuscatedName("r")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   public static void method2664() {
      try {
         class155.field2237.method2329();

         for(int var0 = 0; var0 < class155.field2241; ++var0) {
            class155.field2247[var0].method2329();
         }

         class155.field2246.method2329();
         class155.field2239.method2329();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "961581326"
   )
   static int method2663(int var0) {
      MessageNode var1 = (MessageNode)class98.field1520.method3482((long)var0);
      return var1 == null?-1:(var1.next == class98.field1526.field2484?-1:((MessageNode)var1.next).id);
   }
}
