import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static NodeCache field3400;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3405;
   @ObfuscatedName("q")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("e")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("p")
   @Export("valType")
   public char valType;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -858506613
   )
   @Export("size")
   public int size;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2044020937
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("g")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("t")
   @Export("stringVals")
   public String[] stringVals;
   @ObfuscatedName("v")
   @Export("intVals")
   public int[] intVals;

   static {
      field3400 = new NodeCache(64);
   }

   public Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "2054685177"
   )
   void method4572(Buffer var1, int var2) {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfg;S)V",
      garbageValue = "2327"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4572(var1, var2);
      }
   }
}
