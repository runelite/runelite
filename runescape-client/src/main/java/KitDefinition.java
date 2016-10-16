import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("ns")
   static class77 field1004;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 477834371
   )
   public static int field1005;
   @ObfuscatedName("f")
   short[] field1006;
   @ObfuscatedName("m")
   short[] field1007;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -787252773
   )
   public int field1008 = -1;
   @ObfuscatedName("s")
   public static class170 field1009;
   @ObfuscatedName("g")
   int[] field1010;
   @ObfuscatedName("k")
   short[] field1011;
   @ObfuscatedName("h")
   short[] field1012;
   @ObfuscatedName("r")
   int[] field1013 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("w")
   public boolean field1014 = false;
   @ObfuscatedName("y")
   public static NodeCache field1015 = new NodeCache(64);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "43"
   )
   public boolean method924() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1013[var2] != -1 && !class112.field1941.method3252(this.field1013[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "75"
   )
   void method925(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method936(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "15"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field1010 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1010.length; ++var2) {
            if(!class112.field1941.method3252(this.field1010[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-110"
   )
   public ModelData method930() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var5 = 0; var5 < 5; ++var5) {
         if(this.field1013[var5] != -1) {
            var1[var2++] = ModelData.method2184(class112.field1941, this.field1013[var5], 0);
         }
      }

      ModelData var3 = new ModelData(var1, var2);
      int var4;
      if(null != this.field1007) {
         for(var4 = 0; var4 < this.field1007.length; ++var4) {
            var3.method2197(this.field1007[var4], this.field1006[var4]);
         }
      }

      if(this.field1011 != null) {
         for(var4 = 0; var4 < this.field1011.length; ++var4) {
            var3.method2234(this.field1011[var4], this.field1012[var4]);
         }
      }

      return var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1847667465"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field1010 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field1010.length];

         for(int var4 = 0; var4 < this.field1010.length; ++var4) {
            var1[var4] = ModelData.method2184(class112.field1941, this.field1010[var4], 0);
         }

         ModelData var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field1007) {
            for(var3 = 0; var3 < this.field1007.length; ++var3) {
               var2.method2197(this.field1007[var3], this.field1006[var3]);
            }
         }

         if(null != this.field1011) {
            for(var3 = 0; var3 < this.field1011.length; ++var3) {
               var2.method2234(this.field1011[var3], this.field1012[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-58354809"
   )
   void method936(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1008 = var1.method2481();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2481();
            this.field1010 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1010[var4] = var1.method2668();
            }
         } else if(var2 == 3) {
            this.field1014 = true;
         } else if(var2 == 40) {
            var3 = var1.method2481();
            this.field1007 = new short[var3];
            this.field1006 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1007[var4] = (short)var1.method2668();
               this.field1006[var4] = (short)var1.method2668();
            }
         } else if(var2 == 41) {
            var3 = var1.method2481();
            this.field1011 = new short[var3];
            this.field1012 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1011[var4] = (short)var1.method2668();
               this.field1012[var4] = (short)var1.method2668();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1013[var2 - 60] = var1.method2668();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "1746628657"
   )
   static int method942(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
