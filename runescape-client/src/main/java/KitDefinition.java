import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1545390477
   )
   public static int field2817;
   @ObfuscatedName("q")
   short[] field2818;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1946777377
   )
   public int field2819 = -1;
   @ObfuscatedName("n")
   int[] field2820;
   @ObfuscatedName("e")
   static class182 field2821;
   @ObfuscatedName("v")
   short[] field2822;
   @ObfuscatedName("w")
   short[] field2823;
   @ObfuscatedName("a")
   short[] field2824;
   @ObfuscatedName("h")
   int[] field2825 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("i")
   static class182 field2826;
   @ObfuscatedName("k")
   static NodeCache field2828 = new NodeCache(64);
   @ObfuscatedName("p")
   public boolean field2829 = false;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2125847732"
   )
   void method3438(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3439(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-387570407"
   )
   void method3439(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2819 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.field2820 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2820[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.field2829 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2824 = new short[var3];
            this.field2818 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2824[var4] = (short)var1.readUnsignedShort();
               this.field2818[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2823 = new short[var3];
            this.field2822 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2823[var4] = (short)var1.readUnsignedShort();
               this.field2822[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2825[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-119"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field2820 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2820.length; ++var2) {
            if(!field2821.method3213(this.field2820[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2124493217"
   )
   public boolean method3442() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2825[var2] != -1 && !field2821.method3213(this.field2825[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "10"
   )
   public ModelData method3443() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field2825[var3] != -1) {
            var1[var2++] = ModelData.method1452(field2821, this.field2825[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(null != this.field2824) {
         for(var4 = 0; var4 < this.field2824.length; ++var4) {
            var5.method1483(this.field2824[var4], this.field2818[var4]);
         }
      }

      if(this.field2823 != null) {
         for(var4 = 0; var4 < this.field2823.length; ++var4) {
            var5.method1476(this.field2823[var4], this.field2822[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)LModelData;",
      garbageValue = "2663"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field2820 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2820.length];

         for(int var4 = 0; var4 < this.field2820.length; ++var4) {
            var1[var4] = ModelData.method1452(field2821, this.field2820[var4], 0);
         }

         ModelData var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field2824) {
            for(var3 = 0; var3 < this.field2824.length; ++var3) {
               var2.method1483(this.field2824[var3], this.field2818[var3]);
            }
         }

         if(this.field2823 != null) {
            for(var3 = 0; var3 < this.field2823.length; ++var3) {
               var2.method1476(this.field2823[var3], this.field2822[var3]);
            }
         }

         return var2;
      }
   }
}
