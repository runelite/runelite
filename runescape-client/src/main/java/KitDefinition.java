import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("d")
   public static class182 field2818;
   @ObfuscatedName("p")
   static NodeCache field2819 = new NodeCache(64);
   @ObfuscatedName("m")
   int[] field2820 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 953944989
   )
   public int field2821 = -1;
   @ObfuscatedName("n")
   int[] field2822;
   @ObfuscatedName("r")
   short[] field2823;
   @ObfuscatedName("c")
   short[] field2824;
   @ObfuscatedName("q")
   public static class182 field2825;
   @ObfuscatedName("o")
   short[] field2826;
   @ObfuscatedName("i")
   short[] field2827;
   @ObfuscatedName("s")
   public boolean field2828 = false;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1583078257"
   )
   void method3498(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3500(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1062387591"
   )
   @Export("ready")
   public boolean ready() {
      if(null == this.field2822) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2822.length; ++var2) {
            if(!field2818.method3376(this.field2822[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1735042113"
   )
   void method3500(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2821 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.field2822 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2822[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.field2828 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2823 = new short[var3];
            this.field2824 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2823[var4] = (short)var1.readUnsignedShort();
               this.field2824[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2827 = new short[var3];
            this.field2826 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2827[var4] = (short)var1.readUnsignedShort();
               this.field2826[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2820[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "47"
   )
   public boolean method3501() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2820[var2] != -1 && !field2818.method3376(this.field2820[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-120"
   )
   public ModelData method3502() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field2820[var3] != -1) {
            var1[var2++] = ModelData.method1559(field2818, this.field2820[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.field2823 != null) {
         for(var4 = 0; var4 < this.field2823.length; ++var4) {
            var5.method1526(this.field2823[var4], this.field2824[var4]);
         }
      }

      if(this.field2827 != null) {
         for(var4 = 0; var4 < this.field2827.length; ++var4) {
            var5.method1564(this.field2827[var4], this.field2826[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass139;I)Z",
      garbageValue = "-569163536"
   )
   public static boolean method3503(class182 var0, class182 var1, class182 var2, class139 var3) {
      class138.field1917 = var0;
      class138.field1914 = var1;
      class138.field1915 = var2;
      class138.field1916 = var3;
      return true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "102"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(null == this.field2822) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2822.length];

         for(int var2 = 0; var2 < this.field2822.length; ++var2) {
            var1[var2] = ModelData.method1559(field2818, this.field2822[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field2823) {
            for(var3 = 0; var3 < this.field2823.length; ++var3) {
               var4.method1526(this.field2823[var3], this.field2824[var3]);
            }
         }

         if(null != this.field2827) {
            for(var3 = 0; var3 < this.field2827.length; ++var3) {
               var4.method1564(this.field2827[var3], this.field2826[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-2021762800"
   )
   public static int method3526(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
