import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("EnumDefinition_indexCache")
   static IndexDataBase EnumDefinition_indexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("EnumDefinition_cached")
   static NodeCache EnumDefinition_cached;
   @ObfuscatedName("o")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("p")
   @Export("valType")
   public char valType;
   @ObfuscatedName("a")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1050615061
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 315108431
   )
   @Export("size")
   public int size;
   @ObfuscatedName("y")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("g")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("c")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "458163131"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "860536387"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.keyType = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.valType = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.defaultString = var1.readString();
      } else if(var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.size = var1.readUnsignedShort();
            this.keys = new int[this.size];
            this.stringVals = new String[this.size];

            for(var3 = 0; var3 < this.size; ++var3) {
               this.keys[var3] = var1.readInt();
               this.stringVals[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.size = var1.readUnsignedShort();
            this.keys = new int[this.size];
            this.intVals = new int[this.size];

            for(var3 = 0; var3 < this.size; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-933959885"
   )
   public int method4904() {
      return this.size;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[BLfn;B)V",
      garbageValue = "14"
   )
   static void method4913(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 0;
      var3.hash = (long)var0;
      var3.field3316 = var1;
      var3.index = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      class231.method4370();
   }
}
