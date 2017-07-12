import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("w")
   public static NodeCache field3415;
   @ObfuscatedName("i")
   public static IndexDataBase field3409;
   @ObfuscatedName("s")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("a")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("t")
   @Export("valType")
   public char valType;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -904889213
   )
   @Export("size")
   public int size;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1937549869
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("y")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("k")
   @Export("stringVals")
   public String[] stringVals;
   @ObfuscatedName("j")
   @Export("intVals")
   public int[] intVals;

   static {
      field3415 = new NodeCache(64);
   }

   public Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1114586823"
   )
   void method4474(Buffer var1, int var2) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "4"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4474(var1, var2);
      }
   }
}
