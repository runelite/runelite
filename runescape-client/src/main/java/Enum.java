import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static NodeCache field3388;
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static IndexDataBase field3396;
   @ObfuscatedName("x")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("f")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("p")
   @Export("valType")
   public char valType;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -977370715
   )
   @Export("size")
   public int size;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1046902501
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("l")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("b")
   @Export("stringVals")
   public String[] stringVals;
   @ObfuscatedName("w")
   @Export("intVals")
   public int[] intVals;

   static {
      field3388 = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "-110477450"
   )
   void method4497(Buffer var1, int var2) {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-1919746041"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4497(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-78"
   )
   static int method4509(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }
}
