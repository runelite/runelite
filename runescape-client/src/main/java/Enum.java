import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("EnumDefinition_cached")
   static NodeCache EnumDefinition_cached;
   @ObfuscatedName("y")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("r")
   @Export("valType")
   public char valType;
   @ObfuscatedName("h")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1801841691
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1460843299
   )
   @Export("size")
   public int size;
   @ObfuscatedName("b")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("e")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("f")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "1592885827"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "-2014517542"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-119202881"
   )
   public int method4671() {
      return this.size;
   }
}
