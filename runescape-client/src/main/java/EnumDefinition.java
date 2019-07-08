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
   @Export("EnumDefinition_archive")
   public static AbstractArchive EnumDefinition_archive;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("EnumDefinition_cached")
   static EvictingDualNodeHashTable EnumDefinition_cached;
   @ObfuscatedName("q")
   @Export("inputType")
   public char inputType;
   @ObfuscatedName("w")
   @Export("outputType")
   public char outputType;
   @ObfuscatedName("o")
   @Export("defaultStr")
   public String defaultStr;
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
   @Export("outputCount")
   public int outputCount;
   @ObfuscatedName("l")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("e")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("x")
   @Export("strVals")
   public String[] strVals;

   EnumDefinition() {
      this.defaultStr = "null";
      this.outputCount = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-230039710"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while (true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-1255400805"
   )
   @Export("decodeNext")
   void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.inputType = (char)var1.readUnsignedByte();
      } else if (var2 == 2) {
         this.outputType = (char)var1.readUnsignedByte();
      } else if (var2 == 3) {
         this.defaultStr = var1.readStringCp1252NullTerminated();
      } else if (var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if (var2 == 5) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.strVals = new String[this.outputCount];

            for (var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.strVals[var3] = var1.readStringCp1252NullTerminated();
            }
         } else if (var2 == 6) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.intVals = new int[this.outputCount];

            for (var3 = 0; var3 < this.outputCount; ++var3) {
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
      return this.outputCount;
   }

   static {
      EnumDefinition_cached = new EvictingDualNodeHashTable(64);
   }
}
