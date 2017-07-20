import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3381;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3374;
   @ObfuscatedName("g")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("i")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("u")
   @Export("valType")
   public char valType;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -243480413
   )
   @Export("size")
   public int size;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 646497707
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("x")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("k")
   @Export("stringVals")
   public String[] stringVals;
   @ObfuscatedName("p")
   @Export("intVals")
   public int[] intVals;

   static {
      field3381 = new NodeCache(64);
   }

   public Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "354332493"
   )
   void method4353(Buffer var1, int var2) {
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;S)V",
      garbageValue = "-26672"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4353(var1, var2);
      }
   }
}
