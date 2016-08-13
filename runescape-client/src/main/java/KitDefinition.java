import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("q")
   public boolean field1053 = false;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1837911351
   )
   public static int field1054;
   @ObfuscatedName("l")
   public static class170 field1055;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1820259691
   )
   public int field1056 = -1;
   @ObfuscatedName("u")
   short[] field1059;
   @ObfuscatedName("s")
   int[] field1060;
   @ObfuscatedName("b")
   short[] field1061;
   @ObfuscatedName("m")
   int[] field1062 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("e")
   static NodeCache field1063 = new NodeCache(64);
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -36709909
   )
   static int field1064;
   @ObfuscatedName("n")
   short[] field1067;
   @ObfuscatedName("k")
   short[] field1068;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "44"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field1060 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1060.length; ++var2) {
            if(!RSCanvas.field2197.method3453(this.field1060[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1169958639"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field1060 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field1060.length];

         for(int var2 = 0; var2 < this.field1060.length; ++var2) {
            var1[var2] = ModelData.method2369(RSCanvas.field2197, this.field1060[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field1068) {
            for(var3 = 0; var3 < this.field1068.length; ++var3) {
               var4.method2305(this.field1068[var3], this.field1059[var3]);
            }
         }

         if(this.field1067 != null) {
            for(var3 = 0; var3 < this.field1067.length; ++var3) {
               var4.method2306(this.field1067[var3], this.field1061[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "0"
   )
   public ModelData method974() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1062[var3] != -1) {
            var1[var2++] = ModelData.method2369(RSCanvas.field2197, this.field1062[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.field1068 != null) {
         for(var4 = 0; var4 < this.field1068.length; ++var4) {
            var5.method2305(this.field1068[var4], this.field1059[var4]);
         }
      }

      if(null != this.field1067) {
         for(var4 = 0; var4 < this.field1067.length; ++var4) {
            var5.method2306(this.field1067[var4], this.field1061[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2102241104"
   )
   void method986(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1056 = var1.method2633();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2633();
            this.field1060 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1060[var4] = var1.method2635();
            }
         } else if(var2 == 3) {
            this.field1053 = true;
         } else if(var2 == 40) {
            var3 = var1.method2633();
            this.field1068 = new short[var3];
            this.field1059 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1068[var4] = (short)var1.method2635();
               this.field1059[var4] = (short)var1.method2635();
            }
         } else if(var2 == 41) {
            var3 = var1.method2633();
            this.field1067 = new short[var3];
            this.field1061 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1067[var4] = (short)var1.method2635();
               this.field1061[var4] = (short)var1.method2635();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1062[var2 - 60] = var1.method2635();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-55"
   )
   void method987(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method986(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1133544757"
   )
   public boolean method991() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1062[var2] != -1 && !RSCanvas.field2197.method3453(this.field1062[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }
}
