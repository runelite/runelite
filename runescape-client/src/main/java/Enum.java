import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("EnumDefinition_indexCache")
   public static IndexDataBase EnumDefinition_indexCache;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("EnumDefinition_cached")
   public static NodeCache EnumDefinition_cached;
   @ObfuscatedName("t")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("d")
   @Export("valType")
   public char valType;
   @ObfuscatedName("h")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 58984681
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 142456961
   )
   @Export("size")
   public int size;
   @ObfuscatedName("i")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("u")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("x")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   public Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-505255438"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;IB)V",
      garbageValue = "40"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
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
      signature = "(I)I",
      garbageValue = "-1726440698"
   )
   public int method4957() {
      return this.size;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1126393101"
   )
   public static String method4958(CharSequence var0) {
      return VarCInt.method4785('*', var0.length());
   }
}
