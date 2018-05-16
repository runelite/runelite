import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("EnumDefinition_cached")
   static NodeCache EnumDefinition_cached;
   @ObfuscatedName("q")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("b")
   @Export("valType")
   public char valType;
   @ObfuscatedName("f")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 67416857
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -303547453
   )
   @Export("size")
   public int size;
   @ObfuscatedName("x")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("j")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("a")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1038789195"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1216349647"
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
      signature = "(B)I",
      garbageValue = "3"
   )
   public int method4998() {
      return this.size;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "296702561"
   )
   static void method5008() {
      FileOnDisk var0 = null;

      try {
         var0 = class240.getPreferencesFile("", LoginPacket.field2265.name, true);
         Buffer var1 = ScriptState.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }
}
