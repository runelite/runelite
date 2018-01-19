import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class31 {
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1856805415
   )
   final int field422;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 595050407
   )
   final int field420;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -926130039
   )
   final int field421;

   class31(int var1, int var2, int var3) {
      this.field422 = var1;
      this.field420 = var2;
      this.field421 = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-1180869467"
   )
   public static void method271(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method271(var0, var1, var2, var5 - 1);
         method271(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "-802872046"
   )
   static SpritePixels method270() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class299.field3868;
      var0.maxHeight = class299.field3867;
      var0.offsetX = class299.field3870[0];
      var0.offsetY = class299.offsetsY[0];
      var0.width = class54.field635[0];
      var0.height = UrlRequester.field2099[0];
      int var1 = var0.width * var0.height;
      byte[] var2 = class188.spritePixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class299.field3869[var2[var3] & 255];
      }

      class139.method2922();
      return var0;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IIS)Ljava/lang/String;",
      garbageValue = "-12704"
   )
   static final String method272(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class54.getColTags(16711680):(var2 < -6?class54.getColTags(16723968):(var2 < -3?class54.getColTags(16740352):(var2 < 0?class54.getColTags(16756736):(var2 > 9?class54.getColTags(65280):(var2 > 6?class54.getColTags(4259584):(var2 > 3?class54.getColTags(8453888):(var2 > 0?class54.getColTags(12648192):class54.getColTags(16776960))))))));
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "510193549"
   )
   static final String method269(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class54.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class54.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class54.getColTags(16776960) + var1 + "</col>");
   }
}
