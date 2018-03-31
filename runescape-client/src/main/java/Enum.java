import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("EnumDefinition_indexCache")
   public static IndexDataBase EnumDefinition_indexCache;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("EnumDefinition_cached")
   public static NodeCache EnumDefinition_cached;
   @ObfuscatedName("o")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("j")
   @Export("valType")
   public char valType;
   @ObfuscatedName("k")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1280776805
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -263499207
   )
   @Export("size")
   public int size;
   @ObfuscatedName("p")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("w")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("r")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   public Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-52449897"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "1608594237"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "575314488"
   )
   public int method4949() {
      return this.size;
   }
}
