import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("Enum")
public class Enum extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("EnumDefinition_indexCache")
   static IndexDataBase EnumDefinition_indexCache;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("EnumDefinition_cached")
   static NodeCache EnumDefinition_cached;
   @ObfuscatedName("b")
   @Export("keyType")
   public char keyType;
   @ObfuscatedName("z")
   @Export("valType")
   public char valType;
   @ObfuscatedName("n")
   @Export("defaultString")
   public String defaultString;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1948597767
   )
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1897020051
   )
   @Export("size")
   public int size;
   @ObfuscatedName("y")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("c")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("h")
   @Export("stringVals")
   public String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "155654623"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-1633125485"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "56"
   )
   public int method5029() {
      return this.size;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;IZB)Leu;",
      garbageValue = "4"
   )
   public static Frames method5042(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }
}
