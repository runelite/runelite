import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("y")
   @Export("retextureToReplace")
   short[] retextureToReplace;
   @ObfuscatedName("g")
   @Export("retextureToFind")
   short[] retextureToFind;
   @ObfuscatedName("d")
   static NodeCache field2814 = new NodeCache(64);
   @ObfuscatedName("x")
   static class182 field2815;
   @ObfuscatedName("h")
   @Export("modelIds")
   int[] modelIds;
   @ObfuscatedName("u")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("k")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("j")
   static class182 field2820;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1118180789
   )
   @Export("bodyPartId")
   public int bodyPartId = -1;
   @ObfuscatedName("q")
   @Export("nonSelectable")
   public boolean nonSelectable = false;
   @ObfuscatedName("e")
   @Export("models")
   int[] models = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("bm")
   static class184 field2825;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1517782859"
   )
   void method3505(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3512(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2071285908"
   )
   public boolean method3506() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !field2820.method3374(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   @Export("ready")
   public boolean ready() {
      if(null == this.modelIds) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            if(!field2820.method3374(this.modelIds[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-13"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.modelIds == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.modelIds.length];

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1[var2] = ModelData.method1522(field2820, this.modelIds[var2], 0);
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
               var4.method1555(this.recolorToFind[var3], this.recolorToReplace[var3]);
            }
         }

         if(this.retextureToFind != null) {
            for(var3 = 0; var3 < this.retextureToFind.length; ++var3) {
               var4.method1536(this.retextureToFind[var3], this.retextureToReplace[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1539222737"
   )
   void method3512(Buffer var1, int var2) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-76"
   )
   public ModelData method3527() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var5 = 0; var5 < 5; ++var5) {
         if(this.models[var5] != -1) {
            var1[var2++] = ModelData.method1522(field2820, this.models[var5], 0);
         }
      }

      ModelData var3 = new ModelData(var1, var2);
      int var4;
      if(null != this.recolorToFind) {
         for(var4 = 0; var4 < this.recolorToFind.length; ++var4) {
            var3.method1555(this.recolorToFind[var4], this.recolorToReplace[var4]);
         }
      }

      if(null != this.retextureToFind) {
         for(var4 = 0; var4 < this.retextureToFind.length; ++var4) {
            var3.method1536(this.retextureToFind[var4], this.retextureToReplace[var4]);
         }
      }

      return var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LCombatInfo2;",
      garbageValue = "-55"
   )
   public static CombatInfo2 method3529(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2828.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field2827.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method3531(new Buffer(var2));
         }

         CombatInfo2.field2828.put(var1, (long)var0);
         return var1;
      }
   }
}
