import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class45 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 811525653
   )
   int field1027;
   @ObfuscatedName("e")
   public static NodeCache field1029 = new NodeCache(64);
   @ObfuscatedName("g")
   public static NodeCache field1030 = new NodeCache(30);
   @ObfuscatedName("h")
   public static class170 field1031;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -541361989
   )
   int field1032;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1728674115
   )
   public int field1033 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1994104237
   )
   int field1034 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 454026727
   )
   int field1035 = 0;
   @ObfuscatedName("j")
   short[] field1036;
   @ObfuscatedName("y")
   short[] field1037;
   @ObfuscatedName("i")
   public static class170 field1038;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1973102295
   )
   int field1039 = 128;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1229601995
   )
   int field1040 = 0;
   @ObfuscatedName("m")
   short[] field1041;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1075761177
   )
   int field1042 = 128;
   @ObfuscatedName("l")
   short[] field1044;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-72"
   )
   void method933(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method934(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1341754331"
   )
   void method934(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1032 = var1.method2546();
      } else if(var2 == 2) {
         this.field1033 = var1.method2546();
      } else if(var2 == 4) {
         this.field1042 = var1.method2546();
      } else if(var2 == 5) {
         this.field1039 = var1.method2546();
      } else if(var2 == 6) {
         this.field1040 = var1.method2546();
      } else if(var2 == 7) {
         this.field1034 = var1.method2544();
      } else if(var2 == 8) {
         this.field1035 = var1.method2544();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2544();
            this.field1044 = new short[var3];
            this.field1041 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1044[var4] = (short)var1.method2546();
               this.field1041[var4] = (short)var1.method2546();
            }
         } else if(var2 == 41) {
            var3 = var1.method2544();
            this.field1036 = new short[var3];
            this.field1037 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1036[var4] = (short)var1.method2546();
               this.field1037[var4] = (short)var1.method2546();
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "1952059225"
   )
   public final Model method935(int var1) {
      Model var2 = (Model)field1030.get((long)this.field1027);
      if(null == var2) {
         ModelData var3 = ModelData.method2245(field1031, this.field1032, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(null != this.field1044) {
            for(var4 = 0; var4 < this.field1044.length; ++var4) {
               var3.method2315(this.field1044[var4], this.field1041[var4]);
            }
         }

         if(this.field1036 != null) {
            for(var4 = 0; var4 < this.field1036.length; ++var4) {
               var3.method2258(this.field1036[var4], this.field1037[var4]);
            }
         }

         var2 = var3.method2265(64 + this.field1034, this.field1035 + 850, -30, -50, -30);
         field1030.put(var2, (long)this.field1027);
      }

      Model var5;
      if(this.field1033 != -1 && var1 != -1) {
         var5 = class192.getAnimation(this.field1033).method916(var2, var1);
      } else {
         var5 = var2.method2384(true);
      }

      if(this.field1042 != 128 || this.field1039 != 128) {
         var5.method2346(this.field1042, this.field1039, this.field1042);
      }

      if(this.field1040 != 0) {
         if(this.field1040 == 90) {
            var5.method2341();
         }

         if(this.field1040 == 180) {
            var5.method2341();
            var5.method2341();
         }

         if(this.field1040 == 270) {
            var5.method2341();
            var5.method2341();
            var5.method2341();
         }
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-648559916"
   )
   static int method946(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
