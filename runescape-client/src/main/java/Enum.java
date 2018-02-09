import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("oh")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("EnumDefinition_indexCache")
   public static IndexDataBase EnumDefinition_indexCache;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("EnumDefinition_cached")
   static NodeCache EnumDefinition_cached;
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "[Lki;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("m")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("h")
   @Export("valType")
   public char valType;
   @ObfuscatedName("i")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1330365559
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1953497599
   )
   @Export("size")
   public int size;
   @ObfuscatedName("d")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("z")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("k")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "3"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "0"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-919829593"
   )
   public int method4868() {
      return this.size;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;I)V",
      garbageValue = "-1347217661"
   )
   public static void method4880(IndexDataBase var0, IndexDataBase var1) {
      KitDefinition.identKit_ref = var0;
      KitDefinition.field3441 = var1;
      KitDefinition.field3431 = KitDefinition.identKit_ref.fileCount(3);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;B)Ljava/lang/String;",
      garbageValue = "20"
   )
   public static String method4881(Buffer var0) {
      return Timer.method3296(var0, 32767);
   }
}
