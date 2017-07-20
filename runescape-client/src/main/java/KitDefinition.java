import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1052662819
   )
   public static int field3323;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("identKits")
   static NodeCache identKits;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3328;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("identKit_ref")
   public static IndexDataBase identKit_ref;
   @ObfuscatedName("m")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("r")
   @Export("models")
   int[] models;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2100282773
   )
   @Export("bodyPartId")
   public int bodyPartId;
   @ObfuscatedName("w")
   @Export("nonSelectable")
   public boolean nonSelectable;
   @ObfuscatedName("s")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("p")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("x")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("k")
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "0"
   )
   void method4259(Buffer var1, int var2) {
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "35"
   )
   public boolean method4257() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field3328.method4010(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)Ldj;",
      garbageValue = "-9286"
   )
   public ModelData method4260() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.models[var3] != -1) {
            var1[var2++] = ModelData.method2331(field3328, this.models[var3], 0);
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
            var5.method2347(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "103"
   )
   @Export("ready")
   public boolean ready() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field3328.method4010(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1595209819"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4259(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ldj;",
      garbageValue = "90"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1[var2] = ModelData.method2331(field3328, this.modelIds[var2], 0);
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
               var4.method2347(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "1"
   )
   public static long method4277(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }
}
