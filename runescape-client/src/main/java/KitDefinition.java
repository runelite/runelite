import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1422666257
   )
   @Export("bodyPartId")
   public int bodyPartId;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 307694683
   )
   public static int field3338;
   @ObfuscatedName("i")
   public static IndexDataBase field3339;
   @ObfuscatedName("q")
   public static NodeCache field3340;
   @ObfuscatedName("h")
   public static IndexDataBase field3341;
   @ObfuscatedName("v")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("t")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("p")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("l")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("a")
   @Export("retextureToReplace")
   short[] retextureToReplace;
   @ObfuscatedName("k")
   @Export("models")
   int[] models;
   @ObfuscatedName("r")
   @Export("nonSelectable")
   public boolean nonSelectable;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "2020182794"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var4 = 0; var4 < this.modelIds.length; ++var4) {
            var1[var4] = ModelData.method2443(field3341, this.modelIds[var4], 0);
         }

         ModelData var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.recolorToFind != null) {
            for(var3 = 0; var3 < this.recolorToFind.length; ++var3) {
               var2.method2505(this.recolorToFind[var3], this.recolorToReplace[var3]);
            }
         }

         if(this.retextureToFind != null) {
            for(var3 = 0; var3 < this.retextureToFind.length; ++var3) {
               var2.method2511(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "50"
   )
   void method4444(Buffer var1, int var2) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-625121693"
   )
   @Export("ready")
   public boolean ready() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field3341.method4176(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1830839246"
   )
   public boolean method4447() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field3341.method4176(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass186;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1368185872"
   )
   static String method4451(class186 var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         class185 var3 = (class185)var0.method3559((long)var1);
         return var3 == null?var2:(String)var3.field2443;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "37"
   )
   public ModelData method4452() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.models[var3] != -1) {
            var1[var2++] = ModelData.method2443(field3341, this.models[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.recolorToFind != null) {
         for(var4 = 0; var4 < this.recolorToFind.length; ++var4) {
            var5.method2505(this.recolorToFind[var4], this.recolorToReplace[var4]);
         }
      }

      if(this.retextureToFind != null) {
         for(var4 = 0; var4 < this.retextureToFind.length; ++var4) {
            var5.method2511(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var5;
   }

   KitDefinition() {
      this.bodyPartId = -1;
      this.models = new int[]{-1, -1, -1, -1, -1};
      this.nonSelectable = false;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "661202605"
   )
   void method4463(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4444(var1, var2);
      }
   }

   static {
      field3340 = new NodeCache(64);
   }
}
