import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static NodeCache field3376;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1402117039
   )
   static int field3384;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field3375;
   @ObfuscatedName("e")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("x")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("y")
   @Export("valType")
   public char valType;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1967045701
   )
   @Export("size")
   public int size;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 5089365
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("t")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("r")
   @Export("stringVals")
   public String[] stringVals;
   @ObfuscatedName("i")
   @Export("intVals")
   public int[] intVals;

   static {
      field3376 = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "1947500029"
   )
   void method4444(Buffer var1, int var2) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;B)V",
      garbageValue = "52"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4444(var1, var2);
      }
   }
}
