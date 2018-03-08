import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("EnumDefinition_indexCache")
   static IndexDataBase EnumDefinition_indexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("EnumDefinition_cached")
   static NodeCache EnumDefinition_cached;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1741970031
   )
   static int field3563;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 422817245
   )
   static int field3558;
   @ObfuscatedName("i")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("a")
   @Export("valType")
   public char valType;
   @ObfuscatedName("l")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1864046515
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1289242389
   )
   @Export("size")
   public int size;
   @ObfuscatedName("x")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("p")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("g")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;B)V",
      garbageValue = "1"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "1867564346"
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-99"
   )
   public int method4938() {
      return this.size;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1403469468"
   )
   public static File method4950(String var0) {
      if(!class170.field2194) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class170.field2190.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class170.field2189, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class170.field2190.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-126"
   )
   static void method4949() {
      int var0 = class93.playerIndexesCount;
      int[] var1 = class93.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         if(var1[var2] != Client.field890 && var1[var2] != Client.localInteractingIndex) {
            class62.method1112(Client.cachedPlayers[var1[var2]], true);
         }
      }

   }
}
