import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("a")
   short[] field2818;
   @ObfuscatedName("l")
   public static class182 field2819;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 664839695
   )
   public static int field2820;
   @ObfuscatedName("x")
   int[] field2821 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -310832767
   )
   public int field2822 = -1;
   @ObfuscatedName("h")
   int[] field2823;
   @ObfuscatedName("n")
   short[] field2824;
   @ObfuscatedName("t")
   static NodeCache field2825 = new NodeCache(64);
   @ObfuscatedName("f")
   short[] field2826;
   @ObfuscatedName("r")
   short[] field2827;
   @ObfuscatedName("b")
   public static class182 field2828;
   @ObfuscatedName("z")
   public boolean field2829 = false;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "1"
   )
   public static char method3570(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-702734544"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field2823 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2823.length];

         for(int var2 = 0; var2 < this.field2823.length; ++var2) {
            var1[var2] = ModelData.method1563(field2819, this.field2823[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.field2824 != null) {
            for(var3 = 0; var3 < this.field2824.length; ++var3) {
               var4.method1579(this.field2824[var3], this.field2826[var3]);
            }
         }

         if(null != this.field2818) {
            for(var3 = 0; var3 < this.field2818.length; ++var3) {
               var4.method1541(this.field2818[var3], this.field2827[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "71"
   )
   @Export("ready")
   public boolean ready() {
      if(null == this.field2823) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2823.length; ++var2) {
            if(!field2819.method3413(this.field2823[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2016752156"
   )
   public boolean method3574() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2821[var2] != -1 && !field2819.method3413(this.field2821[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1645944021"
   )
   public ModelData method3575() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field2821[var3] != -1) {
            var1[var2++] = ModelData.method1563(field2819, this.field2821[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(null != this.field2824) {
         for(var4 = 0; var4 < this.field2824.length; ++var4) {
            var5.method1579(this.field2824[var4], this.field2826[var4]);
         }
      }

      if(null != this.field2818) {
         for(var4 = 0; var4 < this.field2818.length; ++var4) {
            var5.method1541(this.field2818[var4], this.field2827[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1670723689"
   )
   void method3590(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2822 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.field2823 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2823[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.field2829 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2824 = new short[var3];
            this.field2826 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2824[var4] = (short)var1.readUnsignedShort();
               this.field2826[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2818 = new short[var3];
            this.field2827 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2818[var4] = (short)var1.readUnsignedShort();
               this.field2827[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2821[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "959205545"
   )
   void method3594(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3590(var1, var2);
      }
   }
}
