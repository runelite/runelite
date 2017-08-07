import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3392;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3393;
   @ObfuscatedName("w")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("g")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("y")
   @Export("valType")
   public char valType;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1652504545
   )
   @Export("size")
   public int size;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -959721897
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("z")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("u")
   @Export("stringVals")
   public String[] stringVals;
   @ObfuscatedName("r")
   @Export("intVals")
   public int[] intVals;

   static {
      field3392 = new NodeCache(64);
   }

   public Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "-647775871"
   )
   void method4487(Buffer var1, int var2) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "-6"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4487(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "-441327375"
   )
   public static char method4494(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class267.field3653[var1 - 128];
            if(var2 == 0) {
               var2 = 63;
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }
}
