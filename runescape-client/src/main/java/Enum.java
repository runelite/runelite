import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   static NodeCache field3408;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3398;
   @ObfuscatedName("g")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("q")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("o")
   @Export("valType")
   public char valType;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -598972931
   )
   @Export("size")
   public int size;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -47586189
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("e")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("x")
   @Export("stringVals")
   public String[] stringVals;
   @ObfuscatedName("d")
   @Export("intVals")
   public int[] intVals;

   static {
      field3408 = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "-1348777581"
   )
   void method4550(Buffer var1, int var2) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "-1357024022"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4550(var1, var2);
      }
   }
}
