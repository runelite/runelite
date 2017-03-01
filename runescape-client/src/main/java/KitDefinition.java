import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("a")
   short[] field2821;
   @ObfuscatedName("n")
   static class182 field2822;
   @ObfuscatedName("i")
   short[] field2823;
   @ObfuscatedName("k")
   public boolean field2824 = false;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -628882821
   )
   public int field2825 = -1;
   @ObfuscatedName("p")
   int[] field2826;
   @ObfuscatedName("j")
   short[] field2827;
   @ObfuscatedName("m")
   short[] field2828;
   @ObfuscatedName("x")
   static class182 field2829;
   @ObfuscatedName("v")
   public static NodeCache field2830 = new NodeCache(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -114724459
   )
   public static int field2831;
   @ObfuscatedName("s")
   int[] field2832 = new int[]{-1, -1, -1, -1, -1};

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1903468483"
   )
   public static void method3558() {
      Overlay.field3047.reset();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "22578"
   )
   void method3559(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3568(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1855057792"
   )
   @Export("ready")
   public boolean ready() {
      if(null == this.field2826) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2826.length; ++var2) {
            if(!field2822.method3356(this.field2826[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1567440868"
   )
   public boolean method3563() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2832[var2] != -1 && !field2822.method3356(this.field2832[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1473770612"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(null == this.field2826) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2826.length];

         for(int var2 = 0; var2 < this.field2826.length; ++var2) {
            var1[var2] = ModelData.method1547(field2822, this.field2826[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field2827) {
            for(var3 = 0; var3 < this.field2827.length; ++var3) {
               var4.method1617(this.field2827[var3], this.field2828[var3]);
            }
         }

         if(null != this.field2821) {
            for(var3 = 0; var3 < this.field2821.length; ++var3) {
               var4.method1612(this.field2821[var3], this.field2823[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "509780062"
   )
   public static int method3565(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-8652082"
   )
   void method3568(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2825 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.field2826 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2826[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.field2824 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2827 = new short[var3];
            this.field2828 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2827[var4] = (short)var1.readUnsignedShort();
               this.field2828[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2821 = new short[var3];
            this.field2823 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2821[var4] = (short)var1.readUnsignedShort();
               this.field2823[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2832[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1527181012"
   )
   public ModelData method3586() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field2832[var3] != -1) {
            var1[var2++] = ModelData.method1547(field2822, this.field2832[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(null != this.field2827) {
         for(var4 = 0; var4 < this.field2827.length; ++var4) {
            var5.method1617(this.field2827[var4], this.field2828[var4]);
         }
      }

      if(this.field2821 != null) {
         for(var4 = 0; var4 < this.field2821.length; ++var4) {
            var5.method1612(this.field2821[var4], this.field2823[var4]);
         }
      }

      return var5;
   }
}
