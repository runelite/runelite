import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("EnumDefinition")
public class EnumDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("EnumDefinition_indexCache")
   public static AbstractIndexCache EnumDefinition_indexCache;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("EnumDefinition_cached")
   static EvictingDualNodeHashTable EnumDefinition_cached;
   @ObfuscatedName("q")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("w")
   @Export("valType")
   public char valType;
   @ObfuscatedName("o")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1948115527
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -12324053
   )
   @Export("size0")
   public int size0;
   @ObfuscatedName("l")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("e")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("x")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new EvictingDualNodeHashTable(64);
   }

   EnumDefinition() {
      this.defaultString = "null";
      this.size0 = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-230039710"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-1255400805"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.keyType = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.valType = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.defaultString = var1.readStringCp1252NullTerminated();
      } else if(var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.size0 = var1.__ag_302();
            this.keys = new int[this.size0];
            this.stringVals = new String[this.size0];

            for(var3 = 0; var3 < this.size0; ++var3) {
               this.keys[var3] = var1.readInt();
               this.stringVals[var3] = var1.readStringCp1252NullTerminated();
            }
         } else if(var2 == 6) {
            this.size0 = var1.__ag_302();
            this.keys = new int[this.size0];
            this.intVals = new int[this.size0];

            for(var3 = 0; var3 < this.size0; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   @Export("size")
   public int size() {
      return this.size0;
   }
}
