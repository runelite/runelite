import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 921763307
   )
   public static int field3352;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("identKits")
   public static NodeCache identKits;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   static IndexDataBase field3361;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("identKit_ref")
   static IndexDataBase identKit_ref;
   @ObfuscatedName("e")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("m")
   @Export("models")
   int[] models;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1261760721
   )
   @Export("bodyPartId")
   public int bodyPartId;
   @ObfuscatedName("u")
   @Export("nonSelectable")
   public boolean nonSelectable;
   @ObfuscatedName("l")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("w")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("s")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("p")
   @Export("retextureToReplace")
   short[] retextureToReplace;

   static {
      identKits = new NodeCache(64);
   }

   KitDefinition() {
      this.bodyPartId = -1;
      this.models = new int[]{-1, -1, -1, -1, -1};
      this.nonSelectable = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfe;II)V",
      garbageValue = "-2139614307"
   )
   void method4327(Buffer var1, int var2) {
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1779814645"
   )
   public boolean method4335() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field3361.method4085(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)Ldv;",
      garbageValue = "8099"
   )
   public ModelData method4317() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.models[var3] != -1) {
            var1[var2++] = ModelData.method2396(field3361, this.models[var3], 0);
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
            var5.method2410(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2032808093"
   )
   @Export("ready")
   public boolean ready() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field3361.method4085(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-715955591"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4327(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Ldv;",
      garbageValue = "-41"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1[var2] = ModelData.method2396(field3361, this.modelIds[var2], 0);
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
               var4.method2410(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Ljt;",
      garbageValue = "1388441058"
   )
   static SpritePixels[] method4339() {
      SpritePixels[] var0 = new SpritePixels[class286.field3794];

      for(int var1 = 0; var1 < class286.field3794; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class286.field3793;
         var2.maxHeight = class286.field3792;
         var2.offsetX = class286.field3795[var1];
         var2.offsetY = class31.offsetsY[var1];
         var2.width = class286.field3797[var1];
         var2.height = class90.field1405[var1];
         int var3 = var2.width * var2.height;
         byte[] var4 = class177.spritePixels[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class286.field3796[var4[var5] & 255];
         }
      }

      class18.method138();
      return var0;
   }
}
