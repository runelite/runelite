import java.awt.Component;
import java.awt.Frame;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class32 {
   @ObfuscatedName("x")
   static int[] field759 = new int[2048];
   @ObfuscatedName("qs")
   protected static Frame field760;
   @ObfuscatedName("y")
   static class119[] field761 = new class119[2048];
   @ObfuscatedName("r")
   static int[] field762 = new int[2048];
   @ObfuscatedName("t")
   static class119 field763 = new class119(new byte[5000]);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 462978115
   )
   static int field764 = 0;
   @ObfuscatedName("q")
   static int[] field765 = new int[2048];
   @ObfuscatedName("m")
   static int[] field766 = new int[2048];
   @ObfuscatedName("e")
   static int[] field767 = new int[2048];
   @ObfuscatedName("d")
   static byte[] field768 = new byte[2048];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1052963963
   )
   static int field769 = 0;
   @ObfuscatedName("i")
   static int[] field770 = new int[2048];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2070156743
   )
   static int field771 = 0;
   @ObfuscatedName("c")
   static byte[] field772 = new byte[2048];
   @ObfuscatedName("h")
   public static String field773;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "1"
   )
   static void method779(String[] var0, short[] var1, int var2, int var3) {
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
         method779(var0, var1, var2, var5 - 1);
         method779(var0, var1, 1 + var5, var3);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/awt/Component;III)Lclass56;",
      garbageValue = "283631369"
   )
   public static final class56 method788(class136 var0, Component var1, int var2, int var3) {
      if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class69 var7 = new class69();
            var7.field1188 = new int[(class96.field1633?2:1) * 256];
            var7.field1189 = var3;
            var7.vmethod1614(var1);
            var7.field1197 = (var3 & -1024) + 1024;
            if(var7.field1197 > 16384) {
               var7.field1197 = 16384;
            }

            var7.vmethod1615(var7.field1197);
            if(class227.field3217 > 0 && class56.field1198 == null) {
               class56.field1198 = new class72();
               class56.field1198.field1357 = var0;
               var0.method2991(class56.field1198, class227.field3217);
            }

            if(null != class56.field1198) {
               if(class56.field1198.field1360[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class56.field1198.field1360[var2] = var7;
            }

            return var7;
         } catch (Throwable var6) {
            try {
               class54 var4 = new class54(var0, var2);
               var4.field1188 = new int[256 * (class96.field1633?2:1)];
               var4.field1189 = var3;
               var4.vmethod1614(var1);
               var4.field1197 = 16384;
               var4.vmethod1615(var4.field1197);
               if(class227.field3217 > 0 && class56.field1198 == null) {
                  class56.field1198 = new class72();
                  class56.field1198.field1357 = var0;
                  var0.method2991(class56.field1198, class227.field3217);
               }

               if(class56.field1198 != null) {
                  if(class56.field1198.field1360[var2] != null) {
                     throw new IllegalArgumentException();
                  }

                  class56.field1198.field1360[var2] = var4;
               }

               return var4;
            } catch (Throwable var5) {
               return new class56();
            }
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
