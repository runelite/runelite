import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("y")
   public static class182 field2800;
   @ObfuscatedName("s")
   int[] field2801 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("k")
   public static class182 field2803;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -489553385
   )
   public int field2804 = -1;
   @ObfuscatedName("j")
   int[] field2805;
   @ObfuscatedName("q")
   short[] field2806;
   @ObfuscatedName("d")
   short[] field2807;
   @ObfuscatedName("r")
   public static NodeCache field2808 = new NodeCache(64);
   @ObfuscatedName("n")
   short[] field2809;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 339682277
   )
   public static int field2810;
   @ObfuscatedName("g")
   public boolean field2811 = false;
   @ObfuscatedName("c")
   short[] field2813;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1385036690"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field2805 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2805.length; ++var2) {
            if(!field2800.method3275(this.field2805[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1355142964"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field2805 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2805.length];

         for(int var2 = 0; var2 < this.field2805.length; ++var2) {
            var1[var2] = ModelData.method1470(field2800, this.field2805[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field2806) {
            for(var3 = 0; var3 < this.field2806.length; ++var3) {
               var4.method1474(this.field2806[var3], this.field2807[var3]);
            }
         }

         if(null != this.field2809) {
            for(var3 = 0; var3 < this.field2809.length; ++var3) {
               var4.method1484(this.field2809[var3], this.field2813[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "56"
   )
   void method3492(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2804 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.field2805 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2805[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.field2811 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2806 = new short[var3];
            this.field2807 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2806[var4] = (short)var1.readUnsignedShort();
               this.field2807[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2809 = new short[var3];
            this.field2813 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2809[var4] = (short)var1.readUnsignedShort();
               this.field2813[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2801[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "606130772"
   )
   public ModelData method3496() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field2801[var3] != -1) {
            var1[var2++] = ModelData.method1470(field2800, this.field2801[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(null != this.field2806) {
         for(var4 = 0; var4 < this.field2806.length; ++var4) {
            var5.method1474(this.field2806[var4], this.field2807[var4]);
         }
      }

      if(null != this.field2809) {
         for(var4 = 0; var4 < this.field2809.length; ++var4) {
            var5.method1484(this.field2809[var4], this.field2813[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-417065013"
   )
   public boolean method3499() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2801[var2] != -1 && !field2800.method3275(this.field2801[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "297555752"
   )
   void method3505(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3492(var1, var2);
      }
   }
}
