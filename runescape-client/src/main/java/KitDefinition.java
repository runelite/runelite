import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("s")
   short[] field2813;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1339802665
   )
   public static int field2814;
   @ObfuscatedName("q")
   static NodeCache field2815 = new NodeCache(64);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 643860091
   )
   public int field2816 = -1;
   @ObfuscatedName("j")
   short[] field2817;
   @ObfuscatedName("m")
   public boolean field2818 = false;
   @ObfuscatedName("g")
   static class182 field2819;
   @ObfuscatedName("o")
   short[] field2820;
   @ObfuscatedName("a")
   short[] field2821;
   @ObfuscatedName("k")
   int[] field2822;
   @ObfuscatedName("c")
   int[] field2823 = new int[]{-1, -1, -1, -1, -1};

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2037148509"
   )
   static void method3483() {
      class10.underlayIds = null;
      class10.overlayIds = null;
      class40.overlayPaths = null;
      class60.overlayRotations = null;
      class137.field1909 = null;
      class47.field931 = null;
      class10.field100 = null;
      class189.field2782 = null;
      class165.field2163 = null;
      CombatInfoListHolder.field747 = null;
      NPC.field759 = null;
      class26.field581 = null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1885836081"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field2822 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2822.length; ++var2) {
            if(!field2819.method3326(this.field2822[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1369884707"
   )
   public boolean method3487() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2823[var2] != -1 && !field2819.method3326(this.field2823[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-336313315"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(null == this.field2822) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2822.length];

         for(int var2 = 0; var2 < this.field2822.length; ++var2) {
            var1[var2] = ModelData.method1459(field2819, this.field2822[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field2817) {
            for(var3 = 0; var3 < this.field2817.length; ++var3) {
               var4.method1471(this.field2817[var3], this.field2813[var3]);
            }
         }

         if(null != this.field2820) {
            for(var3 = 0; var3 < this.field2820.length; ++var3) {
               var4.method1472(this.field2820[var3], this.field2821[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1904203385"
   )
   void method3490(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3509(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "506924958"
   )
   public ModelData method3496() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var5 = 0; var5 < 5; ++var5) {
         if(this.field2823[var5] != -1) {
            var1[var2++] = ModelData.method1459(field2819, this.field2823[var5], 0);
         }
      }

      ModelData var3 = new ModelData(var1, var2);
      int var4;
      if(null != this.field2817) {
         for(var4 = 0; var4 < this.field2817.length; ++var4) {
            var3.method1471(this.field2817[var4], this.field2813[var4]);
         }
      }

      if(this.field2820 != null) {
         for(var4 = 0; var4 < this.field2820.length; ++var4) {
            var3.method1472(this.field2820[var4], this.field2821[var4]);
         }
      }

      return var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-118"
   )
   void method3509(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2816 = var1.readUnsignedByte();
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
            this.field2818 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2817 = new short[var3];
            this.field2813 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2817[var4] = (short)var1.readUnsignedShort();
               this.field2813[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2820 = new short[var3];
            this.field2821 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2820[var4] = (short)var1.readUnsignedShort();
               this.field2821[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2823[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[LModIcon;",
      garbageValue = "-704825875"
   )
   static ModIcon[] method3510() {
      ModIcon[] var0 = new ModIcon[class225.field3217];

      for(int var1 = 0; var1 < class225.field3217; ++var1) {
         ModIcon var2 = var0[var1] = new ModIcon();
         var2.width = class225.field3214;
         var2.originalHeight = NPC.field761;
         var2.offsetX = class225.field3216[var1];
         var2.offsetY = class225.field3215[var1];
         var2.originalWidth = class22.field231[var1];
         var2.height = class225.field3218[var1];
         var2.palette = class183.field2719;
         var2.pixels = class48.field949[var1];
      }

      class225.field3216 = null;
      class225.field3215 = null;
      class22.field231 = null;
      class225.field3218 = null;
      class183.field2719 = null;
      class48.field949 = null;
      return var0;
   }
}
