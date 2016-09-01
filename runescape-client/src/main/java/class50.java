import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class50 extends CacheableNode {
   @ObfuscatedName("r")
   public static NodeCache field1089 = new NodeCache(64);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 718721731
   )
   public int field1090;
   @ObfuscatedName("x")
   static class170 field1091;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1582979883
   )
   public int field1092;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1137662045
   )
   public int field1093;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "1"
   )
   void method1014(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1090 = var1.method2551();
         this.field1093 = var1.method2556();
         this.field1092 = var1.method2556();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-1834981733"
   )
   public static void method1015(class170 var0) {
      class56.field1214 = var0;
      class22.field583 = class56.field1214.method3299(16);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "84"
   )
   void method1017(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1014(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "1036890400"
   )
   static void method1026(String[] var0, short[] var1, int var2, int var3) {
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
            if(var6 == null || null != var0[var8] && var0[var8].compareTo(var6) < (var8 & 1)) {
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
         method1026(var0, var1, var2, var5 - 1);
         method1026(var0, var1, var5 + 1, var3);
      }

   }
}
