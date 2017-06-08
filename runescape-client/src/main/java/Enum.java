import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 480851307
   )
   @Export("size")
   public int size;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1857382675
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("i")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("j")
   @Export("valType")
   public char valType;
   @ObfuscatedName("f")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("n")
   static IndexDataBase field3410;
   @ObfuscatedName("z")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("p")
   static NodeCache field3412;
   @ObfuscatedName("g")
   @Export("stringVals")
   public String[] stringVals;
   @ObfuscatedName("h")
   @Export("intVals")
   public int[] intVals;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "9"
   )
   void method4489(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4490(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1075292551"
   )
   void method4490(Buffer var1, int var2) {
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

   static {
      field3412 = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1282485801"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class44.method615(var0, var1, var2, var3, var4, var5, false);
   }
}
