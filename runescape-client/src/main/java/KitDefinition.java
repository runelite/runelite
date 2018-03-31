import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("identKit_ref")
   public static IndexDataBase identKit_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3505;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1706094525
   )
   public static int field3512;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("identKits")
   static NodeCache identKits;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -11555789
   )
   @Export("bodyPartId")
   public int bodyPartId;
   @ObfuscatedName("x")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("z")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("p")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("w")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("r")
   @Export("retextureToReplace")
   short[] retextureToReplace;
   @ObfuscatedName("d")
   @Export("models")
   int[] models;
   @ObfuscatedName("a")
   @Export("nonSelectable")
   public boolean nonSelectable;

   static {
      identKits = new NodeCache(64);
   }

   KitDefinition() {
      this.bodyPartId = -1;
      this.models = new int[]{-1, -1, -1, -1, -1};
      this.nonSelectable = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "209084414"
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;IB)V",
      garbageValue = "-7"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.bodyPartId = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.modelIds = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.modelIds[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.nonSelectable = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorToFind = new short[var3];
            this.recolorToReplace = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorToFind[var4] = (short)var1.readUnsignedShort();
               this.recolorToReplace[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureToFind = new short[var3];
            this.retextureToReplace = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureToFind[var4] = (short)var1.readUnsignedShort();
               this.retextureToReplace[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.models[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-621565051"
   )
   @Export("ready")
   public boolean ready() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field3505.tryLoadRecord(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Ldj;",
      garbageValue = "24"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1[var2] = ModelData.method2583(field3505, this.modelIds[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.recolorToFind != null) {
            for(var3 = 0; var3 < this.recolorToFind.length; ++var3) {
               var4.recolor(this.recolorToFind[var3], this.recolorToReplace[var3]);
            }
         }

         if(this.retextureToFind != null) {
            for(var3 = 0; var3 < this.retextureToFind.length; ++var3) {
               var4.method2660(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "576991862"
   )
   public boolean method4835() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field3505.tryLoadRecord(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Ldj;",
      garbageValue = "-2064635094"
   )
   public ModelData method4836() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.models[var3] != -1) {
            var1[var2++] = ModelData.method2583(field3505, this.models[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.recolorToFind != null) {
         for(var4 = 0; var4 < this.recolorToFind.length; ++var4) {
            var5.recolor(this.recolorToFind[var4], this.recolorToReplace[var4]);
         }
      }

      if(this.retextureToFind != null) {
         for(var4 = 0; var4 < this.retextureToFind.length; ++var4) {
            var5.method2660(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var5;
   }
}
