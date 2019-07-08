import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("KitDefinition")
public class KitDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("KitDefinition_archive")
   public static AbstractArchive KitDefinition_archive;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static AbstractArchive field456;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 235389995
   )
   @Export("KitDefinition_totalCount")
   public static int KitDefinition_totalCount;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("KitDefinition_cached")
   static EvictingDualNodeHashTable KitDefinition_cached;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1619779051
   )
   @Export("bodypartID")
   public int bodypartID;
   @ObfuscatedName("u")
   @Export("models2")
   int[] models2;
   @ObfuscatedName("g")
   @Export("recolorFrom")
   short[] recolorFrom;
   @ObfuscatedName("l")
   @Export("recolorTo")
   short[] recolorTo;
   @ObfuscatedName("e")
   @Export("retextureFrom")
   short[] retextureFrom;
   @ObfuscatedName("x")
   @Export("retextureTo")
   short[] retextureTo;
   @ObfuscatedName("d")
   @Export("models")
   int[] models;
   @ObfuscatedName("k")
   @Export("nonSelectable")
   public boolean nonSelectable;

   KitDefinition() {
      this.bodypartID = -1;
      this.models = new int[]{-1, -1, -1, -1, -1};
      this.nonSelectable = false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;S)V",
      garbageValue = "22753"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while (true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-1828581673"
   )
   @Export("decodeNext")
   void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.bodypartID = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if (var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.models2 = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
               this.models2[var4] = var1.readUnsignedShort();
            }
         } else if (var2 == 3) {
            this.nonSelectable = true;
         } else if (var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorFrom = new short[var3];
            this.recolorTo = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
               this.recolorFrom[var4] = (short)var1.readUnsignedShort();
               this.recolorTo[var4] = (short)var1.readUnsignedShort();
            }
         } else if (var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureFrom = new short[var3];
            this.retextureTo = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
               this.retextureFrom[var4] = (short)var1.readUnsignedShort();
               this.retextureTo[var4] = (short)var1.readUnsignedShort();
            }
         } else if (var2 >= 60 && var2 < 70) {
            this.models[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1250940659"
   )
   @Export("ready")
   public boolean ready() {
      if (this.models2 == null) {
         return true;
      } else {
         boolean var1 = true;

         for (int var2 = 0; var2 < this.models2.length; ++var2) {
            if (!field456.tryLoadFile(this.models2[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Ldw;",
      garbageValue = "0"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if (this.models2 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.models2.length];

         for (int var2 = 0; var2 < this.models2.length; ++var2) {
            var1[var2] = ModelData.method2788(field456, this.models2[var2], 0);
         }

         ModelData var4;
         if (var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if (this.recolorFrom != null) {
            for (var3 = 0; var3 < this.recolorFrom.length; ++var3) {
               var4.recolor(this.recolorFrom[var3], this.recolorTo[var3]);
            }
         }

         if (this.retextureFrom != null) {
            for (var3 = 0; var3 < this.retextureFrom.length; ++var3) {
               var4.retexture(this.retextureFrom[var3], this.retextureTo[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "742548471"
   )
   public boolean method161() {
      boolean var1 = true;

      for (int var2 = 0; var2 < 5; ++var2) {
         if (this.models[var2] != -1 && !field456.tryLoadFile(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ldw;",
      garbageValue = "-56"
   )
   public ModelData method162() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for (int var3 = 0; var3 < 5; ++var3) {
         if (this.models[var3] != -1) {
            var1[var2++] = ModelData.method2788(field456, this.models[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if (this.recolorFrom != null) {
         for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
            var5.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
         }
      }

      if (this.retextureFrom != null) {
         for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
            var5.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)Ljava/lang/String;",
      garbageValue = "-1225602201"
   )
   public static String method4866(Buffer var0) {
      String var1;
      try {
         int var2 = var0.readUShortSmart();
         if (var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.index += class303.huffman.decompress(var0.array, var0.index, var3, 0, var2);
         String var4 = InterfaceParent.decodeStringCp1252(var3, 0, var2);
         var1 = var4;
      } catch (Exception var5) {
         var1 = "Cabbage";
      }

      return var1;
   }

   static {
      KitDefinition_cached = new EvictingDualNodeHashTable(64);
   }
}
