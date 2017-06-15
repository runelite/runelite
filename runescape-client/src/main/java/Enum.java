import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("i")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("p")
   static IndexDataBase field3406;
   @ObfuscatedName("e")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("m")
   static NodeCache field3408;
   @ObfuscatedName("w")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("f")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1837232789
   )
   @Export("size")
   public int size;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1242787821
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("t")
   @Export("valType")
   public char valType;
   @ObfuscatedName("c")
   @Export("stringVals")
   public String[] stringVals;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1301392751"
   )
   void method4339(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4341(var1, var2);
      }
   }

   static {
      field3408 = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "104"
   )
   void method4341(Buffer var1, int var2) {
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
}
