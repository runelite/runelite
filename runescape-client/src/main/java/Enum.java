import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("j")
   static NodeCache field3395;
   @ObfuscatedName("v")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("n")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("r")
   @Export("valType")
   public char valType;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -646215027
   )
   @Export("size")
   public int size;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1554110483
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("s")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("p")
   @Export("stringVals")
   public String[] stringVals;
   @ObfuscatedName("w")
   @Export("intVals")
   public int[] intVals;

   static {
      field3395 = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1925864743"
   )
   void method4423(Buffer var1, int var2) {
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
      signature = "(LBuffer;I)V",
      garbageValue = "2057364237"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4423(var1, var2);
      }
   }
}
