import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3456;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3452;
   @ObfuscatedName("i")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("j")
   @Export("valType")
   public char valType;
   @ObfuscatedName("v")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2133980677
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 267851851
   )
   @Export("size")
   public int size;
   @ObfuscatedName("l")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("b")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("n")
   @Export("stringVals")
   public String[] stringVals;

   static {
      field3452 = new NodeCache(64);
   }

   public Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "858545466"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4652(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "-1986386204"
   )
   void method4652(Buffer var1, int var2) {
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
