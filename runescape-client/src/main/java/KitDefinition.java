import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("x")
   short[] field2822;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -535893345
   )
   public static int field2823;
   @ObfuscatedName("s")
   static class182 field2824;
   @ObfuscatedName("k")
   short[] field2825;
   @ObfuscatedName("g")
   int[] field2826;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1151798117
   )
   public int field2827 = -1;
   @ObfuscatedName("u")
   short[] field2828;
   @ObfuscatedName("r")
   int[] field2829 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("h")
   static NodeCache field2830 = new NodeCache(64);
   @ObfuscatedName("b")
   short[] field2831;
   @ObfuscatedName("n")
   public boolean field2832 = false;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-817306065"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field2826 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2826.length; ++var2) {
            if(!Client.field575.method3184(this.field2826[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "46783042"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(null == this.field2826) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2826.length];

         for(int var4 = 0; var4 < this.field2826.length; ++var4) {
            var1[var4] = ModelData.method1426(Client.field575, this.field2826[var4], 0);
         }

         ModelData var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.field2825 != null) {
            for(var3 = 0; var3 < this.field2825.length; ++var3) {
               var2.method1439(this.field2825[var3], this.field2828[var3]);
            }
         }

         if(null != this.field2831) {
            for(var3 = 0; var3 < this.field2831.length; ++var3) {
               var2.method1440(this.field2831[var3], this.field2822[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-68"
   )
   public boolean method3388() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2829[var2] != -1 && !Client.field575.method3184(this.field2829[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1264111645"
   )
   void method3389(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2827 = var1.readUnsignedByte();
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
            this.field2832 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2825 = new short[var3];
            this.field2828 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2825[var4] = (short)var1.readUnsignedShort();
               this.field2828[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2831 = new short[var3];
            this.field2822 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2831[var4] = (short)var1.readUnsignedShort();
               this.field2822[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2829[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-125"
   )
   void method3403(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3389(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "2125212195"
   )
   public ModelData method3404() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field2829[var3] != -1) {
            var1[var2++] = ModelData.method1426(Client.field575, this.field2829[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(null != this.field2825) {
         for(var4 = 0; var4 < this.field2825.length; ++var4) {
            var5.method1439(this.field2825[var4], this.field2828[var4]);
         }
      }

      if(null != this.field2831) {
         for(var4 = 0; var4 < this.field2831.length; ++var4) {
            var5.method1440(this.field2831[var4], this.field2822[var4]);
         }
      }

      return var5;
   }
}
