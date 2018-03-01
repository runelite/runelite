import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public final class class80 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   static Deque field1253;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -406182945
   )
   static int field1239;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1928320715
   )
   int field1243;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 60966345
   )
   int field1240;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   ObjectComposition field1242;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 923471911
   )
   int field1241;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 436763817
   )
   int field1256;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 885084839
   )
   int field1246;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1487100825
   )
   int field1248;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 649693787
   )
   int field1245;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 340596029
   )
   int field1244;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   class115 field1247;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 382760673
   )
   int field1249;
   @ObfuscatedName("t")
   int[] field1250;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1917938469
   )
   int field1251;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   class115 field1252;

   static {
      field1253 = new Deque();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1492427609"
   )
   void method1781() {
      int var1 = this.field1244;
      ObjectComposition var2 = this.field1242.getImpostor();
      if(var2 != null) {
         this.field1244 = var2.ambientSoundId;
         this.field1245 = var2.int4 * 128;
         this.field1248 = var2.int5;
         this.field1249 = var2.int6;
         this.field1250 = var2.field3596;
      } else {
         this.field1244 = -1;
         this.field1245 = 0;
         this.field1248 = 0;
         this.field1249 = 0;
         this.field1250 = null;
      }

      if(var1 != this.field1244 && this.field1247 != null) {
         class29.field431.method2129(this.field1247);
         this.field1247 = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "846450579"
   )
   static final void method1769() {
      short var0 = 256;
      int var1;
      if(class90.field1345 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class90.field1345 > 768) {
               class289.field3775[var1] = GroundObject.method2736(ScriptState.field755[var1], class297.field3826[var1], 1024 - class90.field1345);
            } else if(class90.field1345 > 256) {
               class289.field3775[var1] = class297.field3826[var1];
            } else {
               class289.field3775[var1] = GroundObject.method2736(class297.field3826[var1], ScriptState.field755[var1], 256 - class90.field1345);
            }
         }
      } else if(class90.field1346 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class90.field1346 > 768) {
               class289.field3775[var1] = GroundObject.method2736(ScriptState.field755[var1], BoundingBox3DDrawMode.field271[var1], 1024 - class90.field1346);
            } else if(class90.field1346 > 256) {
               class289.field3775[var1] = BoundingBox3DDrawMode.field271[var1];
            } else {
               class289.field3775[var1] = GroundObject.method2736(BoundingBox3DDrawMode.field271[var1], ScriptState.field755[var1], 256 - class90.field1346);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class289.field3775[var1] = ScriptState.field755[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class90.field1336, 9, class90.field1336 + 128, var0 + 7);
      class90.field1338.method6003(class90.field1336, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = class20.rasterProvider.width * 9 + class90.field1336;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class90.field1344[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class1.field11[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class289.field3775[var7];
               var10 = class20.rasterProvider.pixels[var2];
               class20.rasterProvider.pixels[var2++] = ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) + (var8 * (var7 & 65280) + var9 * (var10 & 65280) & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class20.rasterProvider.width - 128;
      }

      Rasterizer2D.setDrawRegion(class90.field1336 + 765 - 128, 9, class90.field1336 + 765, var0 + 7);
      class90.field1340.method6003(class90.field1336 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = class20.rasterProvider.width * 9 + class90.field1336 + 637 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class90.field1344[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class1.field11[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class289.field3775[var7];
               var10 = class20.rasterProvider.pixels[var2];
               class20.rasterProvider.pixels[var2++] = (var8 * (var7 & 65280) + var9 * (var10 & 65280) & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class20.rasterProvider.width - var5 - var4;
      }

   }
}
