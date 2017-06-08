import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("m")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("p")
   public static IndexDataBase field3352;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1047849243
   )
   public static int field3353;
   @ObfuscatedName("o")
   @Export("nonSelectable")
   public boolean nonSelectable;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2049691599
   )
   @Export("bodyPartId")
   public int bodyPartId;
   @ObfuscatedName("j")
   static NodeCache field3356;
   @ObfuscatedName("n")
   public static IndexDataBase field3357;
   @ObfuscatedName("z")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("h")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("g")
   @Export("retextureToReplace")
   short[] retextureToReplace;
   @ObfuscatedName("e")
   @Export("models")
   int[] models;
   @ObfuscatedName("c")
   @Export("recolorToFind")
   short[] recolorToFind;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1744393853"
   )
   void method4392(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4393(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "99297451"
   )
   void method4393(Buffer var1, int var2) {
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
      garbageValue = "-328566038"
   )
   @Export("ready")
   public boolean ready() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field3352.method4127(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   static {
      field3356 = new NodeCache(64);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1474073654"
   )
   public boolean method4398() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field3352.method4127(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   KitDefinition() {
      this.bodyPartId = -1;
      this.models = new int[]{-1, -1, -1, -1, -1};
      this.nonSelectable = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)LModelData;",
      garbageValue = "-17613"
   )
   public ModelData method4401() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var5 = 0; var5 < 5; ++var5) {
         if(this.models[var5] != -1) {
            var1[var2++] = ModelData.method2416(field3352, this.models[var5], 0);
         }
      }

      ModelData var3 = new ModelData(var1, var2);
      int var4;
      if(this.recolorToFind != null) {
         for(var4 = 0; var4 < this.recolorToFind.length; ++var4) {
            var3.method2490(this.recolorToFind[var4], this.recolorToReplace[var4]);
         }
      }

      if(this.retextureToFind != null) {
         for(var4 = 0; var4 < this.retextureToFind.length; ++var4) {
            var3.method2430(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-14"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1[var2] = ModelData.method2416(field3352, this.modelIds[var2], 0);
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
               var4.method2490(this.recolorToFind[var3], this.recolorToReplace[var3]);
            }
         }

         if(this.retextureToFind != null) {
            for(var3 = 0; var3 < this.retextureToFind.length; ++var3) {
               var4.method2430(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var4;
      }
   }
}
