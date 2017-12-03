import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("EnumDefinition_indexCache")
   static IndexDataBase EnumDefinition_indexCache;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("EnumDefinition_cached")
   static NodeCache EnumDefinition_cached;
   @ObfuscatedName("e")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("k")
   @Export("valType")
   public char valType;
   @ObfuscatedName("u")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -970408909
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 72752757
   )
   @Export("size")
   public int size;
   @ObfuscatedName("f")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("g")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("j")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;B)V",
      garbageValue = "-21"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "2081692207"
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
}
