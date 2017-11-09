import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("identKit_ref")
   public static IndexDataBase identKit_ref;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3409;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -235340549
   )
   public static int field3407;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("identKits")
   static NodeCache identKits;
   @ObfuscatedName("ab")
   static java.awt.Font field3413;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2062419353
   )
   @Export("bodyPartId")
   public int bodyPartId;
   @ObfuscatedName("x")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("e")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("l")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("b")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("n")
   @Export("retextureToReplace")
   short[] retextureToReplace;
   @ObfuscatedName("c")
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "-1651213949"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4546(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "34994308"
   )
   void method4546(Buffer var1, int var2) {
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
      signature = "(B)Z",
      garbageValue = "1"
   )
   @Export("ready")
   public boolean ready() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field3409.method4281(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Ldv;",
      garbageValue = "1424764697"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1[var2] = ModelData.method2533(field3409, this.modelIds[var2], 0);
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
               var4.method2536(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "97843921"
   )
   public boolean method4549() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field3409.method4281(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Ldv;",
      garbageValue = "-21"
   )
   public ModelData method4550() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.models[var3] != -1) {
            var1[var2++] = ModelData.method2533(field3409, this.models[var3], 0);
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
            var5.method2536(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var5;
   }
}
